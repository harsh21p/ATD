package com.atd.atdmobileapp.ui.selectlocation

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSelectLocationBinding
import com.atd.atdmobileapp.models.Location
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class SelectLocation : Fragment() {
    private var _binding: FragmentSelectLocationBinding? = null
    private val binding get() = _binding!!
    private val selectLocationViewModel by viewModels<SelectLocationViewModel>()
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var firebaseCrashlytics: FirebaseCrashlytics
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var selectLocationAdapter: SelectLocationAdapter
    private var filteredSearchList = mutableListOf<Location>()
    private var mainList = listOf<Location>()

    private var selectedLocation: Location? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSelectLocationBinding.inflate(inflater, container, false)
        selectLocationAdapter = SelectLocationAdapter(::onSelectLocationClicked,sharedPrefManager,selectedLocation)
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireActivity())
        firebaseCrashlytics = FirebaseCrashlyticsManager.getInstance()
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        landsOnLocationScreenEvent()
        setTheme()
        return binding.root
    }

    private fun landsOnLocationScreenEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Select_Location,
            Category.Login,
            Action.Impression,
            "Viewed locations screen"
        )
        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Select_Location)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSaveLocation.isClickable = false
        binding.rvLocation.visible()
        binding.tvNoResult.gone()
        binding.tvRetrySearchMessage.gone()
        getTextFromSpeech()
        performSearch()
        navigateChooseProfilePage()
        bindObservers()
        selectLocationViewModel.getLocationsToSave()
        binding.rvLocation.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvLocation.adapter = selectLocationAdapter
    }

    private fun setTheme(){
        val selectedProfile =sharedPrefManager.getProfileSelected()
        when (selectedProfile){
            Constants.TIRE_PROS -> {
                binding.ivBack.setColorFilter(ContextCompat.getColor(requireContext(), R.color.icon_color), PorterDuff.Mode.SRC_IN)
                binding.searchHeader.ivSearch.setColorFilter(ContextCompat.getColor(requireContext(), R.color.black), PorterDuff.Mode.SRC_IN)
                binding.searchHeader.voiceLL.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.icon_color))
                val drawable = binding.searchHeader.rlSearch.background as GradientDrawable
                drawable?.setStroke(2, ContextCompat.getColor(requireContext(), R.color.icon_color))
            }
            Constants.ATD_ONLINE -> {
                binding.ivBack.setColorFilter(ContextCompat.getColor(requireContext(), R.color.atd_blue), PorterDuff.Mode.SRC_IN)
                binding.searchHeader.ivSearch.setColorFilter(ContextCompat.getColor(requireContext(), R.color.atd_blue), PorterDuff.Mode.SRC_IN)
                binding.searchHeader.voiceLL.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.atd_blue))
                val drawable = binding.searchHeader.rlSearch.background as GradientDrawable
                drawable?.setStroke(2, ContextCompat.getColor(requireContext(), R.color.atd_blue))
            }
        }
    }

    private fun navigateChooseProfilePage() {
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_selectLocation_to_chooseProfileFragment)
        }
    }

    private fun bindObservers() {
        selectLocationViewModel.selectedLocationLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressbar.gone()
            when (it) {
                is NetworkResult.Success -> {
                    selectLocationAdapter.submitList(it.data?.locations)
                    mainList = it.data?.locations!!
                    requireActivity().window
                        .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    it.data.locations.size.let { it1 -> sharedPrefManager.saveLocationCount(it1) }
                }
                is NetworkResult.Error -> {
                    showErrors(it.message.toString())
                    firebaseCrashlytics.log(it.message.toString())
                    requireActivity().window
                        .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )

                }
            }
        })
    }

    private fun searchLocationEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Select_Location,
            Category.Login,
            Action.Impression,
            "Search for Location"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search_Location, params)

    }

    private fun onSelectLocationClicked(location: com.atd.atdmobileapp.models.Location) {
        binding.tvSaveLocation.isClickable = true
        updateSaveLocationButton()
        binding.tvSaveLocation.setOnClickListener {
            sharedPrefManager.saveLocationNumber(location.locationnumber)
            sharedPrefManager.saveServicingdcNumber(location.servicingdc)
            selectLocationEvent(location.locationnumber)
            val bundle = Bundle()
            bundle.putString(Constants.LOCATION, Gson().toJson(location))
            findNavController().navigate(R.id.action_selectLocation_to_boottomNavigation, bundle)
        }
    }

    private fun updateSaveLocationButton() {
        if (sharedPrefManager.getProfileSelected() == Constants.TIRE_PROS) {
            binding.tvSaveLocation.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
            binding.tvSaveLocation.setTextColor(resources.getColor(R.color.white))
        } else {
            binding.tvSaveLocation.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
            binding.tvSaveLocation.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun selectLocationEvent(locationName:String){
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Select_Location,
            Category.Login,
            Action.Click,
            locationName
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Select_Location, params)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun performSearch() {
        binding.searchHeader.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().toLowerCase(Locale.getDefault())
                filterWithQuery(query)
            }

        })
    }

    private fun filterWithQuery(query: String) {
        //triggering search event
        searchLocationEvent()
        // Perform operation only is query is not empty
        if (query.isNotEmpty()) {
            // Call the function with valid query and take new filtered list.
            val filteredList = onQueryChanged(query)
            if (filteredList.isNotEmpty()) {
                binding.rvLocation.visible()
                binding.tvNoResult.gone()
                binding.tvRetrySearchMessage.gone()
                selectLocationAdapter.submitList(filteredList.toList())
                selectLocationAdapter.notifyDataSetChanged()
            } else {
                binding.rvLocation.gone()
                binding.tvNoResult.visible()
                binding.tvRetrySearchMessage.visible()
            }
        } else if (query.isEmpty()) {
            // If query is empty don't make changes to list
            //selectLocationAdapter.notifyDataSetChanged()
            selectLocationAdapter.submitList(mainList)
        }
    }

    private fun onQueryChanged(filterQuery: String): List<Location> {
        // Empty new array list which contains new strings
        filteredSearchList.clear()
        // Loop through each item in list
        for (currentDetails in selectLocationAdapter.currentList) {
            // Before checking string matching convert string to lower case.
            val searchData = currentDetails.locationname.plus(currentDetails.servicingdc)
                .plus(currentDetails.locationnumber)
                .plus(currentDetails.servicingdc)
                .plus(currentDetails.address.address1)
                .plus(currentDetails.address.city)
                .plus(currentDetails.address.state)
                .plus(currentDetails.address.zipcode)
            if (searchData.toLowerCase(Locale.getDefault()).contains(filterQuery)
            ) {
                // If the match is success, add item to list.
                filteredSearchList.add(currentDetails)
            }
        }
        return filteredSearchList
    }

    private fun showErrors(error: String) {
        toast(error)
    }


    private fun getTextFromSpeech() {
        binding.searchHeader.ivMicSearch.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.RECORD_AUDIO),
                    Constants.REQUEST_CODE
                )

            } else {
                performVoiceSearch()
            }
        }
    }

    private fun performVoiceSearch() {
        val speechDialog = AlertDialog.Builder(requireActivity(), R.style.WideDialog)

        val view: View =
            LayoutInflater.from(requireActivity()).inflate(R.layout.speech_layout, null)
        speechDialog.setView(view)

        val close = view.findViewById<ImageView>(R.id.ivClose)
        val tvHeader = view.findViewById<TextView>(R.id.tvHeader)
        val tvContent = view.findViewById<TextView>(R.id.tvSpeechToText)
        val ivWave = view.findViewById<ImageView>(R.id.ivWave)
        val ivMic = view.findViewById<TextView>(R.id.ivMic)
        val dialog = speechDialog.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialog.show()

        close.setOnClickListener {
            speechRecognizer.stopListening()
            dialog.dismiss()
            binding.searchHeader.etSearch.setText(" ")

        }
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        ivMic.setOnClickListener {
            ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
            speechRecognizer.startListening(speechRecognizerIntent)
        }
        speechRecognizer.startListening(speechRecognizerIntent)
        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {

                tvHeader.text = getString(R.string.listening)
                ivMic.text = ""
                ivWave.visible()
                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_active)
                Glide.with(requireActivity()).asGif().load(R.raw.atd_mic_animation).into(ivWave)

            }

            override fun onBeginningOfSpeech() {
                tvHeader.text = getString(R.string.listening)
            }

            override fun onRmsChanged(rmsdB: Float) {


            }

            override fun onBufferReceived(buffer: ByteArray?) {

            }

            override fun onEndOfSpeech() {
                tvHeader.text = getString(R.string.searching)
                delayTimer(dialog)

            }

            override fun onError(error: Int) {

                tvHeader.text = getString(R.string.trayagain)
                ivMic.text = getString(R.string.tap_mic_search)

                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
                Glide.with(requireActivity()).load(R.drawable.wave).into(ivWave)

            }

            override fun onResults(results: Bundle?) {

                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
                ivWave.gone()

                val data: ArrayList<String> =
                    results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                tvContent.text = data[0]
                binding.searchHeader.etSearch.setText(tvContent.text.toString())

            }

            override fun onPartialResults(partialResults: Bundle?) {

                val data: ArrayList<String> =
                    partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                tvContent.text = data[0]
                binding.searchHeader.etSearch.setText(tvContent.text.toString())

            }

            override fun onEvent(eventType: Int, params: Bundle?) {

            }
        })
    }

    private fun delayTimer(alertDialog: AlertDialog) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                alertDialog.dismiss()
                timer.cancel()
            }
        }, 1500)
    }


}
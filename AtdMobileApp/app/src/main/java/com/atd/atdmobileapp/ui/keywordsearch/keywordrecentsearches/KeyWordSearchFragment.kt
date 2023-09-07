package com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches

import android.Manifest
import android.app.AlertDialog
import android.app.usage.UsageEvents
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentKeyWordSearchBinding
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import com.google.common.eventbus.Subscribe
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class KeyWordSearchFragment : Fragment(), OnClickItem ,View.OnKeyListener{

    var _binding : FragmentKeyWordSearchBinding? = null
    val binding get() = _binding!!
    var adapter: KeywordRecentSearchesAdapter?=null
    private var textToSpeech: TextToSpeech? = null
    private lateinit var speechRecognizer: SpeechRecognizer
    private val recentKeywordSearchViewModel by viewModels<RecentKeywordSearchViewModel>()

    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding= FragmentKeyWordSearchBinding.inflate(inflater, container, false)
        val view: View = binding.root
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireActivity())
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        setupUI()

        setupTheme()
        sharedPrefManager.getLocationNumber()?.let {

            binding.locationLayout.tvLocation.text="Location#"+it

        }
        sharedPrefManager.getSelectedLocation()?.let {

            val dcDetails: DCDetails = Gson().fromJson(it, DCDetails::class.java)


            binding.locationLayout.tvAddress.text =
                dcDetails.distributioncenter.address.address1 +"\n"+
                        dcDetails.distributioncenter.address.city +","+
                        dcDetails.distributioncenter.address.state +" "+
                        dcDetails.distributioncenter.address.zipcode +" "

            binding.locationLayout.tvAddress2.text=  dcDetails.distributioncenter.address.city +" (#"+dcDetails.distributioncenter.servicingdc+")"




        }


        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.keyword_search)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }

        recentKeywordSearchViewModel.getMyKeywords()



        binding.locationLayout.tvKeywordSearch.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(keyWord: Editable?) {

                if (keyWord != null) {
                    if (keyWord.isNotEmpty()&&keyWord.length <4){

                        InputValidation()
                    }
                }
            }
        })


        binding.locationLayout.tvKeywordSearch.setOnKeyListener(this)
/*
        binding.locationLayout.tvKeywordSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH && InputValidation()) {

                ClickItem(binding.locationLayout.tvKeywordSearch.text.toString(), false)
                //input for keyword search text
                tapKeySearchEvent(binding.locationLayout.tvKeywordSearch.text.toString())
                //Toast.makeText(requireContext(), "No Data Available", Toast.LENGTH_SHORT).show()
            }
            true
        }
*/


        binding.locationLayout.voiceLL.setOnClickListener {

            VoiceSearch()

        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )

        return view
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {

        System.out.println(" code: "+keyCode);
        System.out.println(" event: "+event);
        System.out.println("key event: ${KeyEvent.KEYCODE_SEARCH}");

            if (keyCode == KeyEvent.KEYCODE_ENTER && InputValidation()) {


            ClickItem(binding.locationLayout.tvKeywordSearch.text.toString(), false)
            //input for keyword search text
            tapKeySearchEvent(binding.locationLayout.tvKeywordSearch.text.toString())
            //Toast.makeText(requireContext(), "No Data Available", Toast.LENGTH_SHORT).show()
        }

            return true

    }

    private fun setupTheme() {

        if (theameColor==R.color.red){
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
        }else{
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)
        }
        binding.locationLayout.ivKeywordSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),
            theameColor
        )
        binding.locationLayout.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),
            BottomNavigationScreenFragment.theameColor
        )

        if (BottomNavigationScreenFragment.theameColor ==R.color.red) {
            binding.locationLayout.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.red_baseline_rectangle_24)
        }else{
            binding.locationLayout.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.baseline_rectangle_24)
        }
    }

    private fun VoiceSearch() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.RECORD_AUDIO),
                101
            )


        }else{
            /*val intent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            textToSpeech?.stop()

            if (intent.resolveActivity(requireActivity().packageManager)!=null){
                resultLauncher.launch(intent)
            }else{
                Toast.makeText(requireActivity(),"Your Device don't support speech input",Toast.LENGTH_SHORT).show()
            }*/
            val speechDialog= AlertDialog.Builder(requireActivity(), R.style.WideDialog)

            val view : View = LayoutInflater.from(requireActivity())
                .inflate(R.layout.speech_layout,null)
            speechDialog.setView(view)

            val close =view.findViewById<ImageView>(R.id.ivClose)
            val tvHeader =view.findViewById<TextView>(R.id.tvHeader)
            val tvContent =view.findViewById<TextView>(R.id.tvSpeechToText)
            val ivWave =view.findViewById<ImageView>(R.id.ivWave)
            val ivMic =view.findViewById<TextView>(R.id.ivMic)

            //Glide.with(requireActivity()).asGif().load(R.raw.atd_mic_animation).into(ivWave)
            val dialog = speechDialog.create()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.show()

            close.setOnClickListener {
                speechRecognizer.stopListening()
                dialog.dismiss()

            }
            val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            speechRecognizerIntent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            ivMic.setOnClickListener {
                ivMic.setCompoundDrawablesWithIntrinsicBounds(0,0,0, R.drawable.mic_inactive)
                speechRecognizer.startListening(speechRecognizerIntent)
            }
            speechRecognizer.startListening(speechRecognizerIntent)
            speechRecognizer .setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {

                    tvHeader.text=requireActivity().resources.getString(R.string.listening)
                    ivMic.text=""
                    ivWave.visible()
                    ivMic.setCompoundDrawablesWithIntrinsicBounds(0,0,0, R.drawable.mic_active)
                    Glide.with(requireActivity()).asGif().load(R.raw.atd_mic_animation).into(ivWave)

                }

                override fun onBeginningOfSpeech() {
                    tvHeader.text=requireActivity().resources.getString(R.string.listening)
                }

                override fun onRmsChanged(rmsdB: Float) {


                }

                override fun onBufferReceived(buffer: ByteArray?) {

                }

                override fun onEndOfSpeech() {

                    tvHeader.text=requireActivity().resources.getString(R.string.searching)

                }

                override fun onError(error: Int) {

                    tvHeader.text=(requireActivity().resources.getString(R.string.trayagain))
                    ivMic.text=(requireActivity().resources.getString(R.string.tap_mic_search))

                    ivMic.setCompoundDrawablesWithIntrinsicBounds(0,0,0, R.drawable.mic_inactive)
                    Glide.with(requireActivity()).load(R.drawable.wave).into(ivWave)

                }

                override fun onResults(results: Bundle?) {

                    ivMic.setCompoundDrawablesWithIntrinsicBounds(0,0,0, R.drawable.mic_inactive)
                    ivWave.gone()

                    val data: ArrayList<String> =
                        results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>

                    tvContent.text=(data[0])
                    binding.locationLayout.tvKeywordSearch.setText(tvContent.text.toString())

                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        ClickItem(binding.locationLayout.tvKeywordSearch.text.toString(), false)
                        //voice input for keyword search
                        voiceKeySearchEvent(binding.locationLayout.tvKeywordSearch.text.toString())
                        dialog.dismiss()
                    }


                }

                override fun onPartialResults(partialResults: Bundle?) {

                    val data: ArrayList<String> =
                        partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>

                    tvContent.text=(data[0])
                    binding.locationLayout.tvKeywordSearch.setText(tvContent.text.toString())

                }

                override fun onEvent(eventType: Int, params: Bundle?) {

                }
            })
        }

    }


    private fun setupUI() {

        textToSpeech = TextToSpeech(requireActivity()) { i ->

            if (i != TextToSpeech.ERROR) {

                textToSpeech!!.language = Locale.UK

            }
        }


        adapter = KeywordRecentSearchesAdapter(arrayListOf(),this@KeyWordSearchFragment,requireActivity())
        binding.rvRecentSearches.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )
        binding.rvRecentSearches.addItemDecoration(
            DividerItemDecoration(
                binding.rvRecentSearches.context,
                (binding.rvRecentSearches.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.rvRecentSearches.adapter = adapter
    }

    fun InputValidation(): Boolean{
        if (binding.locationLayout.tvKeywordSearch.text.toString().trim().length <4){

            binding.locationLayout.tvKeywordSearch.error=("You must enter at least 4 characters")
            binding.locationLayout.tvKeywordSearch.requestFocus()
            return false
        }else {
            return true
        }
    }

    override fun ClickItem(keyword: String, isRecentSearch: Boolean) {

        //checking if its from recent search
        if (isRecentSearch){
            recentKeySearchEvent(keyword)
        }

        val bundle= Bundle()
        bundle.putString("keyword", keyword)
        bundle.putString(Constants.KEY_TYPE, Constants.KEY_PRODUCT_BY_KEYWORD)
        bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Keyword)
        //adding submitKeySearchEvent
        submitKeySearchEvent(keyword)
        val resultsFragment= KeywordSearchResultsFragment()
        resultsFragment.arguments=bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, resultsFragment)
            .addToBackStack("KeyWordSearchFragment")
            .commit()
    }

    override fun BackPressed() {

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener(null)
        BottomNavigationScreenFragment.tvHeaderText?.text=""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)
                println("logo ===> $it")

            }else if (it.equals("atdonline",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)
                println("logo ===> $it")


            }
        }
        val hostFragment = HomeTabFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recentKeywordSearchViewModel.keywordResponseLiveData.observe(viewLifecycleOwner, {
            when(it){
                is NetworkResult.Success -> {

                    binding.progressbar.gone()

                    it.data?.let {result->


                        RecentKeywordResult(result)

                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)
                    binding.progressbar.gone()

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    binding.progressbar.visible()
                }
            }
        })

    }

    private fun RecentKeywordResult(result: List<PreviousKeywordSearchEntity>) {

        if (result.isNotEmpty()){
            adapter?.addRecentSearches(result)
            adapter?.notifyDataSetChanged()
        }
    }


    private fun tapKeySearchEvent(keyword: String){
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Keyword_Search,
            Category.Search_Keyword,
            Action.Input,
            keyword
        )

        params.putString(FirebaseAnalytics.Event.SCREEN_VIEW, Screen.Keyword_Search)
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun recentKeySearchEvent(keyword: String){
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Keyword_Search,
            Category.Search_Keyword,
            Action.Click,
            keyword
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.keyword,
            searchTerm = keyword
        )

        params.putString("type", searchNonCriteria.type)
        params.putString("searchTerm", searchNonCriteria.searchTerm)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun voiceKeySearchEvent(keyword: String){
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Keyword_Search,
            Category.Search_Keyword,
            Action.Input,
            keyword
        )

        params.putString("type", SearchType.keyword)
        params.putString("searchTerm", keyword)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun submitKeySearchEvent(keyword: String){
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Keyword_Search,
            Category.Search_Keyword,
            Action.Click,
            keyword
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.keyword,
            searchTerm = keyword
        )

        params.putString("type", searchNonCriteria.type)
        params.putString("searchTerm", searchNonCriteria.searchTerm)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }


}
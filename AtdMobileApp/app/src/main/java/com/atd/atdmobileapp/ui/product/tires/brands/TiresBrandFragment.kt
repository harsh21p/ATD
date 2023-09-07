package com.atd.atdmobileapp.ui.product.tires.brands

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentTiresBrandBinding
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class TiresBrandFragment( val brandFilterType: String) : DialogFragment() {
    private var _binding: FragmentTiresBrandBinding? = null
    private val binding get() = _binding!!
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()
    private lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var preferredBrandList = listOf<String>()
    private var otherBrandList = listOf<List<String>>()
    private lateinit var otherBrandsAdapter: OtherBrandsAdapter
    private lateinit var preferredBrandsAdapter: PreferredBrandsAdapter
    private lateinit var speechRecognizer: SpeechRecognizer
    private var result= Bundle()
    companion object {
        const val TAG = "TiresBrandFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding =FragmentTiresBrandBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        otherBrandsAdapter = OtherBrandsAdapter(::onSelectOtherBrandClicked,requireActivity())
        preferredBrandsAdapter = PreferredBrandsAdapter(::onSelectPreferredBrandClicked,requireActivity())
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancelDialog()
        bindObservers()
        tiresBrandsViewModel.getPreferredBrandConfigurationList()
        tiresBrandsViewModel.getOtherBrands(BrandsRequest(sharedPrefManager.getLocationNumber().toString()))
        binding.rvPreferredBrand.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvPreferredBrand.adapter = preferredBrandsAdapter
        binding.rvOtherBrand.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvOtherBrand.adapter = otherBrandsAdapter
        expandAndCollapseRecyclerView()
        performSearch()
        getTextFromSpeech()
        clearSelectedItems()
        apply()
        preferredBrandsAdapter.setSelectedViews(mainViewModel.getSelectedPositions(),mainViewModel.getSelectedPositionsItem())
        otherBrandsAdapter.setSelectedViews(mainViewModel.getSelectedOtherPositions(),mainViewModel.getSelectedOtherPositionsItem())

        setupTheme()
    }

    private fun setupTheme() {
        binding.ivClose.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.tvClearAll.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
        binding.ivPreferredBrand.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.ivOtherBrands.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.searchHeader.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        if (theameColor==R.color.red) {
            binding.searchHeader.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.red_baseline_rectangle_24)
        }else{
            binding.searchHeader.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.baseline_rectangle_24)
        }
        binding.tvApply.backgroundTintList=ContextCompat.getColorStateList(requireContext(),R.color.disable_background)

        //binding.tvApply.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
        binding.tvApply.setTextColor(resources.getColor(R.color.disableText))
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun bindObservers() {
        tiresBrandsViewModel.preferredBrandsLiveData.observe(viewLifecycleOwner, Observer {
            preferredBrandList = it.data?.map { it.value }?.toList()!!
            preferredBrandList = preferredBrandList.filter { brand -> brand.isNotEmpty() } //adding to eliminate null values
            preferredBrandsAdapter.setItems(preferredBrandList)

        })
        tiresBrandsViewModel.tiresBrandsLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NetworkResult.Success -> {

                    otherBrandList =it.data?.brandgroups?.filter { it.productgroup.equals(brandFilterType,true) }?.map { it.brands.map { it.name }.toSet().toList() }!!
                    println("Filter Brands List : $otherBrandList")
                    //to get no duplicate entry
                    otherBrandsAdapter.setItems(otherBrandList.flatten().distinct().filter { !preferredBrandList.contains(it) })
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        })

    }


    private fun expandAndCollapseRecyclerView(){

            binding.forPFBrands.setOnClickListener {
                if (binding.ivPreferredBrand.tag.equals(getString(R.string.expand))){
                    binding.ivPreferredBrand.setImageResource(R.drawable.ic_collapse)
                    binding.rvPreferredBrand.visible()
                    binding.ivPreferredBrand.tag = getString(R.string.collapse)
                }else {
                    binding.ivPreferredBrand.tag = getString(R.string.expand)
                    binding.rvPreferredBrand.gone()
                    binding.ivPreferredBrand.setImageResource(R.drawable.ic_expand)
                }
            }

            binding.forOBrands.setOnClickListener {
                    if (binding.ivOtherBrands.tag.equals(getString(R.string.expand))){
                        binding.ivOtherBrands.setImageResource(R.drawable.ic_collapse)
                        binding.rvOtherBrand.visible()
                        binding.ivOtherBrands.tag = getString(R.string.collapse)
                    } else {
                        binding.ivOtherBrands.tag = getString(R.string.expand)
                        binding.rvOtherBrand.gone()
                        binding.ivOtherBrands.setImageResource(R.drawable.ic_expand)
                    }
            }
    }

    private fun performSearch() {
        binding.searchHeader.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().toLowerCase(Locale.getDefault())
                query?.let {
                    preferredBrandsAdapter.filterItems(it)
                    binding.rvPreferredBrand.visible()
                    binding.ivPreferredBrand.setImageResource(R.drawable.ic_collapse)
                }
                query?.let {
                    otherBrandsAdapter.filterItems(it)
                    binding.rvOtherBrand.visible()
                    binding.ivOtherBrands.setImageResource(R.drawable.ic_collapse)
                }
            }

        })
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

    private fun clearSelectedItems(){
        binding.tvClearAll.setOnClickListener {
            preferredBrandsAdapter.clearSelectedViews()
            otherBrandsAdapter.clearSelectedViews()
            mainViewModel.setSelectedPositions(emptySet())
            mainViewModel.setSelectedPositionsItems(emptySet())
            mainViewModel.setSelectedOtherPositions(emptySet())
            mainViewModel.setSelectedOtherPositionsItems(emptySet())
            binding.tvApply.backgroundTintList=ContextCompat.getColorStateList(requireContext(),R.color.disable_background)

            //binding.tvApply.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
            binding.tvApply.setTextColor(resources.getColor(R.color.disableText))
        }
    }

    private fun apply(){
        binding.tvApply.setOnClickListener {
            setFragmentResult(Constants.BRAND_RESULT,result)
            dismiss()
        }
    }

    private fun onSelectPreferredBrandClicked(list :Set<String>, selectedListIndex :Set<Int>){
        binding.tvApply.isClickable = true
        binding.tvApply.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.tvApply.setTextColor(resources.getColor(R.color.white))
        mainViewModel.setSelectedPositions(selectedListIndex)
        mainViewModel.setSelectedPositionsItems(list.toSet())

    }

    private fun onSelectOtherBrandClicked(list :Set<String>,selectedListIndex :Set<Int>){
        binding.tvApply.isClickable = true
        binding.tvApply.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        //binding.tvApply.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
        binding.tvApply.setTextColor(resources.getColor(R.color.white))
        mainViewModel.setSelectedOtherPositions(selectedListIndex)
        mainViewModel.setSelectedOtherPositionsItems(list.toSet())

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun cancelDialog(){
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }

}
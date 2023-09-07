package com.atd.atdmobileapp.ui.barcode

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentBarcodeSearchBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.vin.BarcodeFragment
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BarcodeSearchFragment : Fragment() {


    private var _binding: FragmentBarcodeSearchBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private val CAMERA_PERMISSION_REQUEST: Int=123
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentBarcodeSearchBinding.inflate(inflater, container, false)
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()
        sharedPrefManager.saveBarcode("")

        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        visitBarCodeSearchEvent()
        val bundle = this.arguments
        bundle?.let {
            binding.etBarcode.setText(it.getString("scannedText"))

        }


        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.etBarcode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.ivBarCode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

            }else if (it.equals("atdonline",true)){

                binding.etBarcode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.ivBarCode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

            } else {

            }
        }



        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.barcode_search)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )

        binding.tvSearch.setOnClickListener {
            
            if (!binding.etBarcode.equals("")) {

                val criteria = Criteria()
                criteria.upc= listOf(binding.etBarcode.text.toString())
                val bundle =Bundle()
                bundle.putString(Constants.BARCODE,Gson().toJson(criteria))
                bundle.putString(Constants.KEY_TYPE, Constants.BARCODE_SEARCH)
                bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Barcode)
                submitBarCodeSearchEvent(binding.etBarcode.text.toString())

                val fragment = KeywordSearchResultsFragment()
                fragment.arguments=bundle
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("BarcodeFragment")
                    .commit()


            }
        }
        binding.ivBarCode.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startBarcodeScanner()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST
                )
            }
        }

        binding.etBarcode.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                if (!s.toString().equals("")){
                    enable()
                }else{
                    disable()
                }
            }
        })

        return binding.root

    }

    private fun submitBarCodeSearchEvent(value: String) {

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Barcode_Search,
            Category.Search_Barcode,
            Action.Click,
            value
        )
        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.barcode,
            barcodeNumber = value
        )

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun visitBarCodeSearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Barcode_Search,
            Category.Search_Barcode,
            Action.Impression,
            "View barcode search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Barcode_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    fun enable(){

        binding.tvSearch.isEnabled=true
        binding.tvSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.tvSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
            }else if (it.equals("atdonline",true)){
                binding.tvSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
            }
        }
    }

    fun disable(){

        binding.tvSearch.isEnabled = false
        binding.tvSearch.backgroundTintList =
            ContextCompat.getColorStateList(requireActivity(), R.color.disable_background)
        binding.tvSearch.setTextColor(
            ContextCompat.getColorStateList(
                requireActivity(),
                R.color.disableText
            )
        )
    }




    private fun startBarcodeScanner() {

        val intent = Intent(requireActivity(), BarcodeFragment::class.java)
        startActivity(intent)

    }

    private fun BackPressed() {
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
        sharedPrefManager.saveBarcode("")

    }

    override fun onResume() {
        super.onResume()
        sharedPrefManager.getBarcode()?.let {

            if (!it.equals("")){
                if (it.length<11){
                    val barcode = "000"+it
                    binding.etBarcode.setText(barcode)
                    scanBarCodeSearchEvent(barcode)
                }else if (it.length<12){
                    val barcode = "00"+it
                    binding.etBarcode.setText(barcode)
                    scanBarCodeSearchEvent(barcode)
                }else if (it.length<13){
                    val barcode = "0"+it
                    binding.etBarcode.setText(barcode)
                    scanBarCodeSearchEvent(barcode)
                }else {
                    binding.etBarcode.setText(it)
                    scanBarCodeSearchEvent(it)
                }
            }
        }
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()

    }

    private fun scanBarCodeSearchEvent(value: String) {

        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Barcode_Search,
            Category.Search_Barcode,
            Action.Input,
            value
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)

    }


}
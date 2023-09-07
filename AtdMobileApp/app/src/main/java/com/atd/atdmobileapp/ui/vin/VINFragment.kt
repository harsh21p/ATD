package com.atd.atdmobileapp.ui.vin

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentVINBinding
import com.atd.atdmobileapp.databinding.FragmentVehicleSearchBinding
import com.atd.atdmobileapp.models.vehicle.Vehicle
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.licenceplate.OCRLicencePlate
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import com.google.zxing.Result
import dagger.hilt.android.AndroidEntryPoint
import me.dm7.barcodescanner.zxing.ZXingScannerView
import javax.inject.Inject

@AndroidEntryPoint
class VINFragment : Fragment() {


    private var _binding: FragmentVINBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private val CAMERA_PERMISSION_REQUEST: Int=123
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private val vinViewModel by viewModels<VinViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentVINBinding.inflate(inflater, container, false)
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()
        sharedPrefManager.saveBarcode("")
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        landsOnVinSearchEvent()

        val bundle = this.arguments
        bundle?.let {
            binding.etVin.setText(it.getString("scannedText"))

        }


        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.etVin.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.ivBarCode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

            }else if (it.equals("atdonline",true)){

                binding.etVin.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.ivBarCode.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

            }else{

            }
        }



        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.vin_search)

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
            
            if (!binding.etVin.equals("")) {
                binding.noResultTv1.gone()
                binding.noResultTv2.gone()
                vinViewModel.getVinDetails(binding.etVin.text.toString().trim())
                submitVinSearchEvent(binding.etVin.text.toString())
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

        binding.etVin.addTextChangedListener(object : TextWatcher{
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

    private fun submitVinSearchEvent(value: String) {

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.VIN_Search,
            Category.Search_VIN,
            Action.Click,
            value
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.VIN,
            vinNumber = value
        )

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun landsOnVinSearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.VIN_Search,
            Category.Search_VIN,
            Action.Impression,
            "View VIN search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.VIN_Search)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vinViewModel.vinResponseLiveData.observe(viewLifecycleOwner, Observer {

            when(it){
                is NetworkResult.Success -> {

                    binding.progressbar.gone()

                    it.data?.let {

                        val vinResponse= Gson().toJson(it)
                        val bundle =Bundle()
                        bundle.putString("vinData",vinResponse)
                        bundle.putString("type","VIN")
                        val fragment = VehicleSearch()
                        fragment.arguments=bundle
                        requireActivity().supportFragmentManager
                             .beginTransaction()
                             .replace(R.id.bottomNavigationViewFrame, fragment)
                             .addToBackStack("VINFragment")
                             .commit()
                        println("Vin Response : ${it}")

                    }
                }
                is NetworkResult.Error -> {
                    binding.progressbar.gone()
                    binding.noResultTv1.visible()
                    binding.noResultTv2.visible()
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        })
    }



    private fun startBarcodeScanner() {

        /*val intent = Intent(requireActivity(),BarcodeFragment::class.java)
        startActivity(intent)*/

        val intent = Intent(requireActivity(), OCRLicencePlate::class.java)
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

                binding.etVin.setText(it.replace(" ","").replace("*","").trim().toString())
                scanVinSearchEvent(it)
            }
        }
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()

    }

    private fun scanVinSearchEvent(value: String) {

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.VIN_Search,
            Category.Search_VIN,
            Action.Input,
            value
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.VIN,
            vinNumber = value
        )

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)

    }


}
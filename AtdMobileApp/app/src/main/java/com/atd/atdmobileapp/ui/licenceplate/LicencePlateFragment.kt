package com.atd.atdmobileapp.ui.licenceplate

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentLicencePlateBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.io.*
import javax.inject.Inject


@AndroidEntryPoint
class LicencePlateFragment : Fragment() {

    private var _binding: FragmentLicencePlateBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private val CAMERA_PERMISSION_REQUEST: Int=123
    lateinit var mainViewModel: MainViewModel
    lateinit var stateCode :String
    var jsonArray : JSONArray?=null
    private val licencePlateViewModel by viewModels<LicencePlateViewModel> ()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding= FragmentLicencePlateBinding.inflate(inflater,container,false)

        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val statesData: InputStream = resources.openRawResource(R.raw.states)
        val writer = StringBuffer()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(statesData, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.append(buffer)
            }
        } finally {
            statesData.close()
        }

        val responce = writer.toString()

         jsonArray = JSONArray(responce)

        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())

        sharedPrefManager.saveBarcode("")
        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.license_plate_search)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
               binding.devider1.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
               binding.ivState.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
               binding.etLicencePlate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
               binding.ivLicencePlate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

            }else if (it.equals("atdonline",true)){

                binding.devider1.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.ivState.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.etLicencePlate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.ivLicencePlate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

            }else{

            }
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )

        binding.etLicencePlate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                if (!s.toString().trim().equals("") && !binding.etState.text.toString().equals("")){
                    enable()
                }else{
                    disable()
                }
            }
        })

        binding.ivLicencePlate.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startLicencePlateScanner()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST
                )
            }
        }

        binding.etState.setOnClickListener {
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val statesFragment: DialogFragment = StatesFragment(jsonArray!!)
            statesFragment.show(ft, "dialog")
        }

        binding.tvSearch.setOnClickListener {
            binding.noResultTv1.gone()
            binding.noResultTv2.gone()
            submitPlateSearchEvent(binding.etLicencePlate.text.toString(), stateCode)
            val licencePlate= binding.etLicencePlate.text.toString().trim()
            licencePlateViewModel.getLicencePlateDetails(stateCode,licencePlate)
        }

        return binding.root
    }

    private fun submitPlateSearchEvent(value: String, stateCode: String) {

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.License_Plate_Search,
            Category.Search_LP,
            Action.Click,
            null
        )

        params.putString("licence_plate_input", value)
        params.putString("region", stateCode)

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.license_plate,
            region = stateCode
        )

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun visitPlateSearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.License_Plate_Search,
            Category.Search_LP,
            Action.Impression,
            "View license plate search form"
        )
        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.License_Plate_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    private fun startLicencePlateScanner() {
        val intent = Intent(requireActivity(), OCRLicencePlate::class.java)
        startActivity(intent)
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

    }

    override fun onResume() {
        super.onResume()
        sharedPrefManager.getBarcode()?.let {

            if (!it.equals("")){
                binding.etLicencePlate.setText(it.replace(" ","").trim().toString())

                scanPlateSearchEvent(it.replace(" ","").trim().toString(), "") //need to get state value and replace with empty quotes
            }
        }
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()

    }

    private fun scanPlateSearchEvent(value: String, state: String) {

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.License_Plate_Search,
            Category.Search_LP,
            Action.Input,
            value
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.license_plate,
            region = state
        )

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visitPlateSearchEvent()
        mainViewModel?.licencePlateState?.observe(viewLifecycleOwner, Observer {

           it?.let {
               binding.etState.text=it

               for (i in 0 until jsonArray?.length()!!){
                   val jsonObject = jsonArray?.getJSONObject(i)
                   if (jsonObject?.getString("value").equals(it)){
                       stateCode= jsonObject?.getString("code").toString()
                       println("Selected State code ${jsonObject?.getString("code")}")
                       break
                       println("Selected State code Lillu")

                   }
               }
           }

        })


        licencePlateViewModel.licencePlateResponseLiveData.observe(viewLifecycleOwner,
            Observer {

                when(it){

                    is NetworkResult.Loading ->{
                        binding.progressbar.visible()
                    }
                    is NetworkResult.Success ->{
                        binding.progressbar.gone()
                        it.data?.let {

                            val vinResponse= Gson().toJson(it)
                            if (!vinResponse.equals("{}")) {
                                val bundle = Bundle()
                                bundle.putString("vinData", vinResponse)
                                bundle.putString("type", "LicencePlate")
                                val fragment = VehicleSearch()
                                fragment.arguments = bundle
                                requireActivity().supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.bottomNavigationViewFrame, fragment)
                                    .addToBackStack("VINFragment")
                                    .commit()
                            }else{
                                binding.noResultTv1.visible()
                                binding.noResultTv2.visible()

                            }
                            println("Vin Response : ${it}")

                        }

                    }
                    is NetworkResult.Error ->{
                        binding.progressbar.gone()
                        binding.noResultTv1.visible()
                        binding.noResultTv2.visible()
                    }

                }
            })

    }





}
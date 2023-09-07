package com.atd.atdmobileapp.ui.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentVehicleSearchBinding
import com.atd.atdmobileapp.models.keywordsearch.*
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.licenceplate.LicencePlateFragment
import com.atd.atdmobileapp.ui.vehicle.make.MakeFragment
import com.atd.atdmobileapp.ui.vehicle.model.ModelFragment
import com.atd.atdmobileapp.ui.vehicle.oesize.OESizeFragment
import com.atd.atdmobileapp.ui.vehicle.trim.TrimFragment
import com.atd.atdmobileapp.ui.vehicle.year.YearFragment
import com.atd.atdmobileapp.ui.vin.VINFragment
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VehicleSearch : Fragment() {

    private var _binding: FragmentVehicleSearchBinding?= null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private val vehicleViewModel by viewModels<VehicleViewModel>()
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var selectedYear = ""
    private var selectedMake = ""
    private var selectedModel = ""
    private var selectedTrim = ""
    private var selectedOESize = ""
    private var isSearchEnabled: Boolean = false
    private var isResetEnabled: Boolean = false
    private var isMakeEnabled: Boolean = false
    private var isModelEnabled: Boolean = false
    private var isTrimEnabled: Boolean = false
    private var isOESizeEnabled: Boolean = false

    private var yearsList = listOf<String>()
    private lateinit var makeList: List<String>
    private lateinit var modelList: List<String>
    private var trimList: ArrayList<String> = ArrayList()
    private var trimoptionList = listOf<TrimOption>()
    private var isVINRequest: Boolean = false
    private var type :String?="Main"

    private lateinit var vehicleObjToSaveState: VehicleRequest
     var  vinResponse : VinResponse?=null
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentVehicleSearchBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setupHeader()
        bindObservers()

        binding.bottomButtons.viewDivider9.setBackgroundColor(ContextCompat.getColor(requireContext(), theameColor))
        binding.viewDiv1.setBackgroundColor(ContextCompat.getColor(requireContext(), theameColor))
        binding.chooseYearDropDown.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        //VIN Data
        val bundle = this.arguments
        val vinData = bundle?.getString("vinData")
        type = bundle?.getString("type")
        //applying default value if type is null
        if (type.isNullOrEmpty()){
            type = "Main"
        }
        vinData?.let {
            vinResponse  = Gson().fromJson(vinData,VinResponse::class.java)
        vinResponse?.vehicles?.let {
            if (it.size>0){
                binding.chooseYear.text= it?.get(0)?.year ?:""
                binding.chooseMake.text=it?.get(0)?.make?:""
                binding.chooseModel.text=it?.get(0)?.model?:""
                isTrimEnabled=true
                enableTrim()

            }
        }
        vinResponse?.vehicles?.map { it.trims.map { it.trimoptions.map {
            //it.trim.toString()
            trimList.add( it.trim)

        } } }
        }

        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val temp: Boolean? = arguments?.getBoolean(TAG)
        onClickYear()
        onClickMake()
        onClickModel()
        onClickTrim()
        onClickOESize()
        dropDownYearListener()
        dropDownMakeListener()
        dropDownModelListener()
        dropDownTrimListener()
        dropDownOESizeListener()
        getYears()
        if (temp == true){
            setupSavedState()
        }else{
            clearRelatedSharedPrefs()
            disableAll()
        }
        //adding logic to save year, make, model to shared prefs
        val bundle = this.arguments
        val vinData = bundle?.getString("vinData")
        vinData?.let {
            val vinResponse: VinResponse = Gson().fromJson(vinData, VinResponse::class.java)
            vinResponse.vehicles.let {
                if (!it.isNullOrEmpty()) {
                    sharedPrefManager.saveSelectedYear(it[0].year)
                    sharedPrefManager.saveSelectedMake(it[0].make)
                    sharedPrefManager.saveSelectedModel(it[0].model)
                    isVINRequest = true
                }
            }
        }

    }

    private fun getYears() {
        vehicleViewModel.getVehicleYears(VehicleRequest())
    }


    private fun disableAll() {
        binding.viewDiv2.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.viewDiv3.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.viewDiv4.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.viewDiv5.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))

        binding.chooseMakeDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseModelDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseTrimDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseOESizeDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))

        binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_disabled)
        binding.bottomButtons.ivReset.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))

        isMakeEnabled = false
        isModelEnabled = false
        if (trimList.size==0) {
            isTrimEnabled = false

        }  else {
            enableTrim()
            binding.viewDiv1.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            binding.chooseYearDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))

        }
        isOESizeEnabled = false
        isResetEnabled = false
        isSearchEnabled = false

    }

    private fun resetMake(){
        binding.chooseMake.text = ""
        binding.chooseMake.hint = getString(R.string.choose_make)
        sharedPrefManager.removeSelectedMake()
    }

    private fun resetModel(){
        binding.chooseModel.text = ""
        binding.chooseModel.hint = getString(R.string.choose_model)
        binding.viewDiv3.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseModelDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        isModelEnabled = false
        sharedPrefManager.removeSelectedModel()

    }

    private fun resetTrim(){
        binding.chooseTrim.text = ""
        binding.chooseTrim.hint = getString(R.string.choose_trim)
        binding.viewDiv4.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseTrimDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        isTrimEnabled = false
        sharedPrefManager.removeSelectedTrim()
    }

    private fun resetOESize(){
        binding.chooseOESize.text = ""
        binding.chooseOESize.hint = getString(R.string.choose_an_option)
        binding.viewDiv5.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.chooseOESizeDropDown.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        isOESizeEnabled = false
        sharedPrefManager.removeSelectedOESize()
    }

    private fun resetSubmit(){
        binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_disabled)
        isSearchEnabled = false
    }
    private fun clearRelatedSharedPrefs() {
        sharedPrefManager.removeSelectedYear()
        sharedPrefManager.removeSelectedMake()
        sharedPrefManager.removeSelectedModel()
        sharedPrefManager.removeSelectedTrim()
        sharedPrefManager.removeSelectedOESize()
        sharedPrefManager.removeSelectedOESizeObj()
        sharedPrefManager.removeSavedVehicleObj()
    }

    private fun dropDownYearListener() {
        parentFragmentManager.setFragmentResultListener(Constants.YEAR_RESULT, this){_,result->
            selectedYear = result.getString(Constants.SELECTED_YEAR).toString()
            binding.chooseYear.text = selectedYear
            binding.viewDiv2.setBackgroundColor(ContextCompat.getColor(requireContext(),theameColor))
            binding.chooseMakeDropDown.setColorFilter(ContextCompat.getColor(requireContext(),theameColor))
            isMakeEnabled = true
            vehicleViewModel.getVehicleMakes(VehicleRequest(sharedPrefManager.getSelectedYear()))
            enableReset()
            resetMake()
            resetModel()
            resetTrim()
            resetOESize()
            resetSubmit()
        }
    }

    private fun dropDownMakeListener() {
        parentFragmentManager.setFragmentResultListener(Constants.MAKE_RESULT, this){_,result->
            selectedMake = result.getString(Constants.SELECTED_MAKE).toString()
            binding.chooseMake.text = selectedMake
            enableModel()
            vehicleViewModel.getVehicleModel(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake()))
            resetTrim()
            resetOESize()
            resetSubmit()
        }
    }

    private fun enableModel() {
        binding.viewDiv3.setBackgroundColor(ContextCompat.getColor(requireContext(),theameColor))
        binding.chooseModelDropDown.setColorFilter(ContextCompat.getColor(requireContext(),theameColor))
        isModelEnabled = true
        binding.chooseModel.text = ""
    }

    private fun dropDownModelListener() {
        parentFragmentManager.setFragmentResultListener(Constants.MODEL_RESULT, this){_,result->
            selectedModel = result.getString(Constants.SELECTED_MODEL).toString()
            binding.chooseModel.text = selectedModel
            enableTrim()
            vehicleViewModel.getVehicleTrim(VehicleRequest(sharedPrefManager.getSelectedYear(),sharedPrefManager.getSelectedMake(),sharedPrefManager.getSelectedModel()))
            resetOESize()
            resetSubmit()
        }
    }

    private fun enableTrim() {
        binding.viewDiv4.setBackgroundColor(ContextCompat.getColor(requireContext(),theameColor))
        binding.chooseTrimDropDown.setColorFilter(ContextCompat.getColor(requireContext(),theameColor))
        isTrimEnabled = true
        binding.chooseTrim.text = ""
    }

    private fun dropDownTrimListener() {
        parentFragmentManager.setFragmentResultListener(Constants.TRIM_RESULT, this){_,result->
            selectedTrim = result.getString(Constants.SELECTED_TRIM).toString()
            binding.chooseTrim.text = selectedTrim
            //adding logic to see if VIN Request and modify the flow
            if (isVINRequest){
                sharedPrefManager.saveSelectedTrim(selectedTrim)
            }
            enableOESize()
            vehicleViewModel.getVehicleOESize(VehiclePlusSizeRequest(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake(), sharedPrefManager.getSelectedModel(), sharedPrefManager.getSelectedTrim())))

        }
    }

    private fun enableOESize() {
        binding.viewDiv5.setBackgroundColor(ContextCompat.getColor(requireContext(),theameColor))
        binding.chooseOESizeDropDown.setColorFilter(ContextCompat.getColor(requireContext(),theameColor))
        isOESizeEnabled = true
        binding.chooseOESize.text = ""
    }

    private fun dropDownOESizeListener() {
        parentFragmentManager.setFragmentResultListener(Constants.OESIZE_RESULT, this){_,result->
            selectedOESize = result.getString(Constants.SELECTED_OESIZE).toString()
            binding.chooseOESize.text = selectedOESize
            enableSearch()
        }
    }

    private fun enableReset(){
        isResetEnabled = true
        binding.bottomButtons.ivReset.setColorFilter(ContextCompat.getColor(requireContext(),theameColor))
        onClickReset()
    }
    private fun onClickReset(){
        if (isResetEnabled){
            binding.bottomButtons.ivReset.setOnClickListener {
                binding.chooseYear.text = ""
                resetMake()
                resetModel()
                resetTrim()
                resetOESize()
                resetSubmit()
                disableAll()
                clearRelatedSharedPrefs()
            }
        }
    }
    private fun enableSearch() {
        if (theameColor==R.color.red){
            binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled_tirepros)
        }else{
            binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled)
        }
        isSearchEnabled = true
        enableReset()
        onClickSearch()
    }

    private fun onClickSearch() {
        binding.bottomButtons.ivSearch.setOnClickListener {
            var isStaggeredFitment = false
            //Get Search Results
            if (isSearchEnabled){

                val productByFitmentRequest = ProductByFitmentRequest()
                val options = Options()
                val price = Price()
                price.cost = 1
                price.retail = 1
                price.specialdiscount = 1
                price.fet = 1
                price.map = 1
                price.msrp = 1

                val availability = Availability()
                availability.local = 1
                availability.localplus = 1
                availability.nationwide = 1

                val images = Images()
                images.small = 1
                images.medium = 1
                images.large = 1
                images.thumbnail = 1

                val productspec = Productspec()

                options.availability = availability
                options.price = price
                options.images = images
                options.productspec = productspec
                options.includerebates = "true"
                options.includemarketingprograms = "true"

                //checking the default fitment screen is wheels
                val userPref = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
                val fitmentType = userPref.fitmentResults?.lowercase()
                if (fitmentType.equals("wheels")){
                    //adding criteria
                    val criteria = Criteria()
                    criteria.productgroup = listOf("custom wheels")
                    productByFitmentRequest.criteria = criteria
                }

                val vehicle = VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake(), sharedPrefManager.getSelectedModel(), sharedPrefManager.getSelectedTrim(), sharedPrefManager.getSelectedOESize())

                val oeSizeObject: TrimOption = Gson().fromJson(sharedPrefManager.getSelectedOESizeObj(), TrimOption::class.java )
                val staggeredFitment =oeSizeObject.staggeredfitment
                if (staggeredFitment != null) {
                    if (staggeredFitment.equals("yes",true)){
                        vehicle.position = "front"
                        isStaggeredFitment = true
                    }
                }
                productByFitmentRequest.locationnumber = sharedPrefManager.getLocationNumber().toString()
                productByFitmentRequest.vehicle = vehicle
                sharedPrefManager.saveSavedVehicleObj(Gson().toJson(vehicle))
                productByFitmentRequest.options = options
                //adding Vehicle search tap event
                tapVihSearchEvent(productByFitmentRequest, isStaggeredFitment)
                //calling the API
                binding.progressbarVehicle.visible()
                vehicleViewModel.getProductByFitment(productByFitmentRequest)
            }

        }
    }

    private fun tapVihSearchEvent(
        productByFitmentRequest: ProductByFitmentRequest,
        isStaggeredFitment: Boolean
    ) {
        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Vehicle_Search,
            Category.Search_Fitment,
            Action.Click,
            null
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.vehicle,
            vehiclemake = productByFitmentRequest.vehicle?.make,
            vehiclemodel = productByFitmentRequest.vehicle?.model,
            year = productByFitmentRequest.vehicle?.year,
            trim = productByFitmentRequest.vehicle?.trim,
            trimOption = productByFitmentRequest.vehicle?.trimoption,
            isStaggered = isStaggeredFitment
        )

        params = convertSearchNonCriteria(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
        }

    private fun convertSearchNonCriteria(searchNonCriteria: SearchNonCriteria, params: Bundle): Bundle {

        params.putString("type",searchNonCriteria.type)
        params.putString("vehiclemake",searchNonCriteria.vehiclemake)
        params.putString("vehiclemodel",searchNonCriteria.vehiclemodel)
        params.putString("year",searchNonCriteria.year)
        params.putString("trim",searchNonCriteria.trim)
        params.putString("trimOption",searchNonCriteria.trimOption)
        searchNonCriteria.isStaggered?.let { params.putBoolean("isStaggered", it) }

        return params
    }

    private fun onClickYear() {
        val viewsToClick = listOf<View>(binding.chooseYear,binding.chooseYearDropDown,binding.viewDiv1)
        viewsToClick.forEach{view ->
            view.setOnClickListener {
                YearFragment(yearsList).show(requireActivity().supportFragmentManager, YearFragment.TAG)
            }
        }
    }

    private fun onClickMake() {
        val viewsToClick = listOf<View>(binding.chooseMake,binding.chooseMakeDropDown,binding.viewDiv2)
        viewsToClick.forEach{view ->
            view.setOnClickListener {
                if (isMakeEnabled){
                    MakeFragment(makeList).show(requireActivity().supportFragmentManager, MakeFragment.TAG)
                }
            }
        }
    }

    private fun onClickModel() {
        val viewsToClick = listOf<View>(binding.chooseModel,binding.chooseModelDropDown,binding.viewDiv3)
        viewsToClick.forEach{view ->
            view.setOnClickListener {
                if (isModelEnabled){
                    ModelFragment(modelList).show(requireActivity().supportFragmentManager, MakeFragment.TAG)
                }
            }
        }
    }

    private fun onClickTrim() {
        val viewsToClick = listOf<View>(binding.chooseTrim,binding.chooseTrimDropDown,binding.viewDiv4)
        viewsToClick.forEach{view ->
            view.setOnClickListener {
                Toast.makeText(requireActivity(),"trime clicked",Toast.LENGTH_SHORT).show()
                if (isTrimEnabled==true){
                    TrimFragment(trimList.distinct()).show(requireActivity().supportFragmentManager, TrimFragment.TAG)
                }
            }
        }
    }

    private fun onClickOESize() {
        val viewsToClick = listOf<View>(binding.chooseOESize,binding.chooseOESizeDropDown,binding.viewDiv5)
        viewsToClick.forEach{view ->
            view.setOnClickListener {
                if (isOESizeEnabled){
                    OESizeFragment(trimoptionList).show(requireActivity().supportFragmentManager, OESizeFragment.TAG)
                }
            }
        }
    }

    private fun setupHeader() {

        BottomNavigationScreenFragment.tvHeaderText?.text= Constants.VEHICLE_SEARCH
        if (theameColor==R.color.red){
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

        }else{
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)

        }
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            backPressed()
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )
    }
    private fun backPressed() {
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
        var hostFragment : Fragment? =null

        if(type.equals("VIN")){
            hostFragment= VINFragment()
        }else if(type.equals("LicencePlate")){
            hostFragment= LicencePlateFragment()
        } else{
            hostFragment= HomeTabFragment()
        }
        if (hostFragment != null) {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }
    }
    companion object {
       const val TAG = "VehicleSearchFragment"

        fun newInstance(vehicleSaveState: Boolean): VehicleSearch{
            val args = Bundle()
            args.putBoolean(TAG, vehicleSaveState)
            val fragment = VehicleSearch()
            fragment.arguments = args
            return fragment
        }
    }

    private fun bindObservers() {

        //Observer for Years
        vehicleViewModel.vehicleResponseLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    yearsList = it.data?.years ?: listOf("")
                    onClickYear()
//                    adapter.submitList(yearsList)
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

        //observer for Make
        vehicleViewModel.vehicleMakesLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    makeList = it.data?.makes ?: listOf("")
                    handleMakeResponse()
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

            //observer for Model
        vehicleViewModel.vehicleModelLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    modelList = it.data?.models ?: listOf("")
                    handleModelResponse()
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

        //observer for trim
        vehicleViewModel.vehicleTrimLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    println("trimList ==> $trimList")
                    if (trimList.size==0){
                        trimList = (it.data?.trims ?: listOf("")) as ArrayList<String>
                    }else{
                        enableTrim()
                    }
                    handleTrimResponse()

                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

        //observer for OESize
        vehicleViewModel.vehicleOESizeLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    val trimOptions = it.data?.trimoptions
                    if (trimOptions != null) {
                        trimoptionList = trimOptions
                    }
                    handleOESizeResponse()
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

        //observer for productByFitment
        vehicleViewModel.productByFitmentLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    val fitmentType = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java).fitmentResults
                    binding.progressbarVehicle.gone()
                   //need to set data in mainView model and open result fragment with request
                    val bundle= Bundle()
                    bundle.putString(Constants.KEY_TYPE, Constants.KEY_VEHICLE_SEARCH)
                    bundle.putString(Constants.FITMENT_TYPE_PREFS, fitmentType)
                    bundle.putBoolean(Constants.STAGGERED_FITMENT, sharedPrefManager.getStaggeredFitment())
                    println("fwefjwefjwngujgj ${Gson().toJson(it.data)}")
                    println("type -> $type")
                    bundle.putString(Constants.KEY_VEHICLE_SEARCH_RESULT_DATA, Gson().toJson(it.data))
                    when(type){
                        "Main" -> {
                            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Fitment)
                        }
                        "VIN" ->{
                            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_VIN)
                        }
                        "LicencePlate" ->{
                            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_LP)
                        }
                    }
                    val resultsFragment= KeywordSearchResultsFragment()
                    resultsFragment.arguments=bundle
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.bottomNavigationViewFrame, resultsFragment)
                        .addToBackStack("vehicleSearchResultFragment")
                        .commit()
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

    }

    private fun handleMakeResponse() {
        if (arguments?.getBoolean(TAG) == true){
            binding.chooseMake.text = vehicleObjToSaveState.make
            enableModel()
            vehicleViewModel.getVehicleModel(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake()))
        }else if (makeList.size == 1){
            binding.chooseMake.text = makeList[0]
            sharedPrefManager.saveSelectedMake(makeList[0])
            enableModel()
            vehicleViewModel.getVehicleModel(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake()))
        }else{
            onClickMake()
        }
    }

    private fun handleModelResponse() {
        if (arguments?.getBoolean(TAG) == true){
            binding.chooseModel.text = vehicleObjToSaveState.model
            enableTrim()
            vehicleViewModel.getVehicleTrim(VehicleRequest(sharedPrefManager.getSelectedYear(),sharedPrefManager.getSelectedMake(),sharedPrefManager.getSelectedModel()))
        }else if (modelList.size == 1){
            binding.chooseModel.text = modelList[0]
            sharedPrefManager.saveSelectedModel(modelList[0])
            enableTrim()
            vehicleViewModel.getVehicleTrim(VehicleRequest(sharedPrefManager.getSelectedYear(),sharedPrefManager.getSelectedMake(),sharedPrefManager.getSelectedModel()))
        }
        else{
            onClickModel()
        }
    }
    private fun handleTrimResponse() {
        if (arguments?.getBoolean(TAG) == true){
            binding.chooseTrim.text = vehicleObjToSaveState.trim
            enableOESize()
            vehicleViewModel.getVehicleOESize(VehiclePlusSizeRequest(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake(), sharedPrefManager.getSelectedModel(), sharedPrefManager.getSelectedTrim())))
        }else if (trimList.size == 1){
            binding.chooseTrim.text = trimList[0]
            sharedPrefManager.saveSelectedTrim(trimList[0])
            enableOESize()
            vehicleViewModel.getVehicleOESize(VehiclePlusSizeRequest(VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake(), sharedPrefManager.getSelectedModel(), sharedPrefManager.getSelectedTrim())))
        }
        else{
            onClickTrim()
        }
    }
    private fun handleOESizeResponse() {
        val temp1 = mutableListOf<String>()
        trimoptionList.forEach {
                trimOption ->
            trimOption.trimoption?.let {
                temp1.add(trimOption.trimoption)
            }
        }
        if (arguments?.getBoolean(TAG) == true){
            binding.chooseOESize.text = vehicleObjToSaveState.trimoption
            enableSearch()
            arguments?.putBoolean(TAG,false)
        }else if (temp1.size == 1){
            binding.chooseOESize.text = temp1[0]
            sharedPrefManager.saveSelectedOESize(temp1[0])
            val selectedObject = trimoptionList.find { it.trimoption == temp1[0] }
            sharedPrefManager.saveSelectedOESizeObj(Gson().toJson(selectedObject))
            enableSearch()
        }
        else{
            onClickOESize()
        }
    }

    private fun setupSavedState() {
        vehicleObjToSaveState= Gson().fromJson(sharedPrefManager.getSavedVehicleObj(), VehicleRequest::class.java)
        with(vehicleObjToSaveState) {
            binding.chooseYear.text = year
            binding.chooseMake.text = make
            binding.chooseModel.text = model
            binding.chooseTrim.text = trim
            binding.chooseOESize.text = trimoption
            isMakeEnabled = true
            vehicleViewModel.getVehicleMakes(VehicleRequest(sharedPrefManager.getSelectedYear()))

        }
    }



}
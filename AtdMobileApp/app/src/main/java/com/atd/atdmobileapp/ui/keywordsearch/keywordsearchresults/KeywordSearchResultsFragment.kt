package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults

import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentKeywordSearchResuktsBinding
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.Lineitem
import com.atd.atdmobileapp.models.PlaceOrder
import com.atd.atdmobileapp.models.keywordsearch.*
import com.atd.atdmobileapp.models.myquotes.AppliedTaxes
import com.atd.atdmobileapp.models.myquotes.CreateQuoteRequest
import com.atd.atdmobileapp.models.myquotes.Item
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.FilterItem
import com.atd.atdmobileapp.models.productsearch.FilterOptions
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.ui.barcode.BarcodeSearchFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.MyQuotesViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewMyQuotesFragment
import com.atd.atdmobileapp.ui.cart.CartFragment
import com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterFragment
import com.atd.atdmobileapp.ui.keywordsearch.filterandsort.SortFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeyWordSearchFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.ui.product.ProductFragment
import com.atd.atdmobileapp.ui.product.ProductViewModel
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment
import com.atd.atdmobileapp.ui.rebate.RebateFragment
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch
import com.atd.atdmobileapp.ui.vehicle.VehicleViewModel
import com.atd.atdmobileapp.ui.vehicle.positionandsize.PositionFragment
import com.atd.atdmobileapp.ui.vehicle.positionandsize.SizeFragment
import com.atd.atdmobileapp.ui.vehicle.positionandsize.ValueSelectFragment
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.makeFirebaseEventBundle
import com.atd.atdmobileapp.utils.Common.sort
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class KeywordSearchResultsFragment : Fragment() {

    //section declarations
    private var keyword: String?=""
    var _binding : FragmentKeywordSearchResuktsBinding?=null
    val  binding get() =  _binding!!
    var adapter: KeywordSearcheResultAdapter?=null
    private val ViewModel by viewModels<ProductByKeywordViewModel>()
    private val cutOffTimesViewModel by viewModels<CutOffTimesViewModel>()
    private val recentKeywordSearchViewModel by viewModels<RecentKeywordSearchViewModel>()
    private val vehicleViewModel by viewModels<VehicleViewModel>()
    private val myQuotesViewModel by viewModels<MyQuotesViewModel>()
    private lateinit var mainViewModel: MainViewModel
    var type: String?=""
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var oeSizeObject = TrimOption()
    private var oeDiameter = Diameter("","")
    private var searchType: String = "tires"
    private var valueListSuspensionFitment: MutableList<String> = mutableListOf()
    private var mainProductList: List<Product> = emptyList()
    private var productList: List<Product> = emptyList()
    private var preferredBrandList = listOf<String>()
    private var filterOptions: FilterOptions = FilterOptions()
    private var currentSelectedPosition: String = "Front"
    private var currentSelectedSize: String = "All Sizes"
    private var currentSelectedValue: String = ""
    private var currentSelectedSortOption: String = "Availability" //set default value todo
    private var fitmentType: Boolean = true
    private var firstEntryTire: Boolean = false
    private var containsPreferredBrand: Boolean = false
    //adding productByCriteriaView model
    private val productByCriteriaViewModel by viewModels<ProductViewModel>()
    private var criteriaForProductSearchTire = Criteria()
    private var productByCriteriaWheelAccessoriesRequest = ProductByCriteriaRequest()
    private var criteriaForProductSearchWheelAccessories = Criteria()
    private var criteriaForProductSearchSupplies = Criteria()
    private var productByCriteriaSuppliesRequest = ProductByCriteriaRequest()
    private var criteriaForProductSearchTubesAndFlaps = Criteria()
    private var productByCriteriaTubesAndFlapsRequest = ProductByCriteriaRequest()
    private var addOnsRequest = AddOnsRequest()
    private val tpmsRequest = ProductByCriteriaRequest()
    private var criteriaForTpms = Criteria()
    private val permissionViewModel by viewModels<LoginViewModel>()
    var categoryType: String?= ""
    private lateinit var firebaseAnalytics: FirebaseAnalytics



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKeywordSearchResuktsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        binding.placeHolderList.tires.setTextColor(ContextCompat.getColor(requireContext(), theameColor))
        binding.position.backgroundTintList=(ContextCompat.getColorStateList(requireContext(), theameColor))
        binding.suspensionValue.backgroundTintList=(ContextCompat.getColorStateList(requireContext(), theameColor))
        binding.oeSize.backgroundTintList=(ContextCompat.getColorStateList(requireContext(), theameColor))
        binding.bothDiameter.backgroundTintList=(ContextCompat.getColorStateList(requireContext(), theameColor))


        SetTheame()
        sharedPrefManager.getProfileSelected()?.let { permissionViewModel.getCheckPermission(
            it,
            "VIEW_PRODUCT_COSTS"
        ) }


        binding.startNewSearch.setOnClickListener{
            BackPressed()
        }

        binding.ivCVInactive.gone()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        binding.ivCVActive.setOnClickListener {


            //show the cost event
            tapCustomerViewShowEvent(categoryType)
            sharedPrefManager.saveCV(false)
            //to change show cost value in preferences screen
            val tempUserPref: PreferencesConfiguration = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
            tempUserPref.showProductCost = true
            sharedPrefManager.saveUserPreferences(Gson().toJson(tempUserPref))
            adapter?.notifyDataSetChanged()
            binding.ivCVActive.gone()
            binding.ivCVInactive.visible()
        }

        binding.ivCVInactive.setOnClickListener {
            /* binding.ivCVActive.visible()
             binding.ivCVInactive.gone()*/


           // binding.ivCVInactive.background = null
            //hide the cost event
            tapCustomerViewHideEvent(categoryType)
            sharedPrefManager.saveCV(true)
            //to change show cost value in preferences screen
            val tempUserPref: PreferencesConfiguration = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
            tempUserPref.showProductCost = false
            sharedPrefManager.saveUserPreferences(Gson().toJson(tempUserPref))
            adapter?.notifyDataSetChanged()


            if (sharedPrefManager.getCVIntro() == true) {
                CVIntro(binding)
            } else {

                binding.ivCVInactive.text = ""
                binding.ivCVActive.visible()
                binding.ivCVInactive.gone()
            }

        }

        binding.tvLocal.text = sharedPrefManager.getLocal()
        binding.tvLocalPlus.text =sharedPrefManager.getLocalPlus()


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        //updating sort default based on user selection
        val userPreferences = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
        currentSelectedSortOption = userPreferences.sortOrder.toString()

        onClickPosition()
        dropDownListenerForPosition()
        onClickSize()
        dropDownListenerForSize()
        onClickValue()
        dropDownListenerForValue()
        onClickBothDiameter()
        onClickSort()
        dropDownListenerForSortOption()
        onClickFilter()
        dropDownListenerForFilterOptions()

        binding.tvModel.gone()
        val bundle = this.arguments
        keyword = bundle?.getString("keyword")
        type = bundle?.getString(Constants.KEY_TYPE)
        categoryType = bundle?.getString(Constants.CATEGORY_TYPE)

        val productByKeywordRequest = ProductByKeywordRequest()

        getCriteriaFromBundleForTireSearch()
        //adding RequestByCriteria
        val productByCriteriaRequest = ProductByCriteriaRequest()
        productByCriteriaRequest.criteria = criteriaForProductSearchTire

        //getting preferred brands
        preferredBrandList = mainViewModel.getSelectedPreferredBrand()

        sharedPrefManager.getLocationNumber()?.let {

            productByKeywordRequest.locationnumber = it
            //adding location number to request
            productByCriteriaRequest.locationnumber = it
            productByCriteriaWheelAccessoriesRequest.locationnumber = it
            productByCriteriaSuppliesRequest.locationnumber = it
            productByCriteriaTubesAndFlapsRequest.locationnumber = it
            addOnsRequest.locationnumber=it
            tpmsRequest.locationnumber = it

        }

        if (keyword != null) {
            binding.tvModel.visible()
            productByKeywordRequest.keywords = keyword as String
            binding.tvModel.text = keyword.toString()
        }
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

        if (type?.equals(Constants.WHEEL, true) == true) {
            images.medium = null
            price.map = null
            price.msrp = null
            availability.onhand = 1
        } else if (type?.equals(Constants.TIRE_REPAIR) == true) {
            images.medium = null
            price.map = null
            price.msrp = 1
            availability.onhand = 1
        } else if (type?.equals(Constants.TOOLS) == true) {
            images.medium = null
            price.map = null
            price.msrp = 1
            availability.onhand = null
        }else if (type?.equals(Constants.BARCODE_SEARCH) == true) {
            images.medium = null
            price.map = null
            price.msrp = 1
            availability.onhand = 1
        }else if (type?.equals(Constants.REBATES) == true) {
            images.medium = null
            price.map = null
            price.msrp = null
            availability.onhand = 1
        }
        options.availability = availability
        options.price = price
        options.images = images

        val productspec = Productspec()
        options.productspec = productspec
        options.includerebates = "true"
        options.includemarketingprograms = "true"
        if (type?.equals(Constants.TIRE_REPAIR) == true || type?.equals(Constants.TOOLS) == true) {
            options.msrp = "true"
        }
        productByKeywordRequest.options = options
        tpmsRequest.options = options

        setupUI()

        //Logic to make API call based on Request Type
        when (type) {
            Constants.KEY_PRODUCT_BY_CRITERIA -> {
                // Code to execute when the type is criteria
                getCriteriaFromBundleForTireSearch()
                productByCriteriaRequest.criteria = criteriaForProductSearchTire
                productByCriteriaRequest.options = options
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)

            }
            Constants.KEY_PRODUCT_BY_KEYWORD -> {
                // Code to execute when the type is keyword
                println("keyword request ${Gson().toJson(productByKeywordRequest)}")
                ViewModel.getProductByKeyword(productByKeywordRequest)
            }
            Constants.WHEEL -> {
                val bundle = this.arguments
                val criteriaObj: Criteria =
                    Gson().fromJson(bundle?.getString(Constants.WHEEL), Criteria::class.java)
                //criteriaObj.atdfinish = listOf("white")
                productByCriteriaRequest.options = options
                productByCriteriaRequest.criteria = criteriaObj
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)

                println("productByCriteria ==> ${Gson().toJson(productByCriteriaRequest)}")
            }
            Constants.KEY_PRODUCT_BY_CRITERIA_WHEEL_ACCESSORIES -> {
                //Code to execute when the type is wheel Accessories
                getCriteriaFromBundleForWheelAccessoriesSearch()
                productByCriteriaWheelAccessoriesRequest.criteria =
                    criteriaForProductSearchWheelAccessories
                productByCriteriaWheelAccessoriesRequest.options = options
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaWheelAccessoriesRequest)
            }
            Constants.TIRE_REPAIR -> {

                val criteriaObj: Criteria =
                    Gson().fromJson(bundle?.getString(Constants.TIRE_REPAIR), Criteria::class.java)
                productByCriteriaRequest.criteria = criteriaObj
                productByCriteriaRequest.options = options
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)

            }
            Constants.KEY_PRODUCT_BY_CRITERIA_SUPPLIES -> {
                //Code to execute when the type is supplies
                getCriteriaFromBundleForSuppliesSearch()
                productByCriteriaSuppliesRequest.criteria = criteriaForProductSearchSupplies
                productByCriteriaSuppliesRequest.options = options
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaSuppliesRequest)
            }
            Constants.TOOLS -> {

                val criteriaObj: Criteria =
                    Gson().fromJson(bundle?.getString(Constants.TOOLS), Criteria::class.java)
                productByCriteriaRequest.criteria = criteriaObj
                productByCriteriaRequest.options = options
                productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)
            }Constants . KEY_PRODUCT_BY_CRITERIA_TUBES_AND_FLAPS -> {
            //code to execute when the type is tubes and flaps
            getCriteriaFromBundleForTubesAndFlapsSearch()
            productByCriteriaTubesAndFlapsRequest.criteria = criteriaForProductSearchTubesAndFlaps
            productByCriteriaTubesAndFlapsRequest.options = options
            productByCriteriaViewModel.getProductByCriteria(productByCriteriaTubesAndFlapsRequest)


        }Constants.KEY_VEHICLE_SEARCH -> {
            firstEntryTire = true
            setupModelForVehicleSearch()
            binding.vehicleTopList.visible()
            onClickTries()
            onClickWheels()
            onClickTpms()
            onClickSuspension()
            val bundle = this.arguments
            oeSizeObject = Gson().fromJson(sharedPrefManager.getSelectedOESizeObj(), TrimOption::class.java )
            val staggeredFitment =oeSizeObject.staggeredfitment
            if (staggeredFitment != null) {
                if (staggeredFitment.equals("yes",true)){
                    binding.position.visible()
                    binding.oeSize.visible()
                    fitmentType = true
                }else{
                    val temp = oeSizeObject.position?.get(0)?.both?.wheeldiameteroptions?.wheeldiameter
                    if (temp != null && temp.isNotEmpty()){
                        //add logic to show value drop down
                        binding.bothDiameter.visible()
                        fitmentType = false
                    }
                }
            }
            //adding logic to setup as wheel req
            val fitmentPref = bundle?.getString(Constants.FITMENT_TYPE_PREFS)
            if (fitmentPref.equals("wheels", true)){
                //logic to setup as wheels req
                //write logic to setup as wheel
                resetAllPlaceHolderListState()
                binding.placeHolderList.wheels.setTextColor(ContextCompat.getColor(requireContext(),
                    theameColor))
                binding.suspensionValue.gone()
                if (fitmentType){
                    binding.position.visible()
                    binding.oeSize.visible()
                }else{
                    binding.bothDiameter.visible()
                }
                searchType = "wheels"
            }
            if (!oeSizeObject.vehicleid.isNullOrEmpty()){
                //add vehicle id to addOns Obj
                addOnsRequest.vehicleid = oeSizeObject.vehicleid
                //get oeSize by vehicle id
                val getInstallationSpecRequest = ProductByFitmentRequest()
                getInstallationSpecRequest.locationnumber = sharedPrefManager.getLocationNumber().toString()
                val vehicleRequest = VehicleRequest()
                vehicleRequest.vehicleid = oeSizeObject.vehicleid
                getInstallationSpecRequest.vehicle = vehicleRequest
                vehicleViewModel.getInstallationSpecForVehicle(getInstallationSpecRequest)
                makeSuspensionFitmentApiCall()
            }
            val dataStr = bundle?.getString(Constants.KEY_VEHICLE_SEARCH_RESULT_DATA)
            val response = Gson().fromJson(dataStr, ProductByFitmentResponse::class.java)
            binding.rvKeyWordResult.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            handleFitmentResponse(response)
        }Constants.BARCODE_SEARCH -> {

            val criteriaObj: Criteria =
                Gson().fromJson(bundle?.getString(Constants.BARCODE), Criteria::class.java)
            productByCriteriaRequest.criteria = criteriaObj
            productByCriteriaRequest.options = options
            println("Barcode request $productByCriteriaRequest")
            productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)
        }Constants.REBATES->{

            val criteriaObj: Criteria =
                Gson().fromJson(bundle?.getString(Constants.REBATEDATA), Criteria::class.java)
            productByCriteriaRequest.criteria = criteriaObj
            productByCriteriaRequest.options = options
            println("Rebate request $productByCriteriaRequest")
            productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)
        } else -> {
            println("Invalid Key")

        }

        }

        BottomNavigationScreenFragment.tvHeaderText?.text=Constants.Results
       // BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)
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

        return view
    }

    private fun tapCustomerViewShowEvent(categoryType: String?) {
        val searchType = categoryType?: ""
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            "Show hidden product cost"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Show_Cost, params)
    }

    private fun tapCustomerViewHideEvent(categoryType: String?) {

        val searchType = categoryType?: ""
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            "Hide product cost"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Hide_Cost, params)
    }

    private fun SetTheame() {

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
                binding.ivFilter?.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.filter_tirepros))
                binding.ivSorting?.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.sort_tirepros))
                binding.ivCVInactive?.setBackgroundResource(R.drawable.cv_inactive_tirepros)
                binding.ivCVActive?.setBackgroundResource(R.drawable.cv_active_tirepros)

            }else if (it.equals("atdonline",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)
                binding.ivFilter?.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.filter))
                binding.ivSorting?.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.sort))
                binding.ivCVInactive?.setBackgroundResource(R.drawable.cv_inactive)
                binding.ivCVActive?.setBackgroundResource(R.drawable.cv_active)

            }else{

            }
        }

    }

    private fun dropDownListenerForFilterOptions() {
        parentFragmentManager.setFragmentResultListener(Constants.FILTER_RESULT, this){_, result ->
            //add apply filter event
            val searchType = categoryType?: ""
            filterSearchResultEvent(searchType)
            val tempProductsString = result.getString(Constants.FILTER_RESULT).toString()
            val tempList = Gson().fromJson(tempProductsString, ProductByKeywordResponse::class.java)
            val tempFilterCount = result.getString(Constants.FILTER_COUNT)
            if (tempFilterCount?.equals("0") == true){
                binding.tvApprovalNumbersFilter.gone()
                binding.ellipseRedGarageFilter.gone()
            }else{
                binding.tvApprovalNumbersFilter.visible()
                binding.ellipseRedGarageFilter.visible()
                binding.tvApprovalNumbersFilter.text = tempFilterCount
            }
            println("type -> $type")
            updateListBasedOnSearchType(type, tempList.products)
//            adapter?.addProductSearches(tempList.products)
//            adapter?.notifyDataSetChanged()

        }
    }

    private fun filterSearchResultEvent(searchType: String) {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Input,
            "Filter applied"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Filter_Results, params)
    }

    private fun updateListBasedOnSearchType(type: String?, products: List<Product>) {
        println("type -> $type")
        when(type){
            Constants.KEY_PRODUCT_BY_KEYWORD ->{
                binding.tvNumofResults.text=getString(R.string.result_text,products.size.toString())
                if (keyword != null) {
                    binding.tvModel.visible()
                    binding.tvModel.text = keyword.toString()
                }
            }
            Constants.KEY_VEHICLE_SEARCH ->{
                setupModelForVehicleSearch()
                binding.tvNumofResults.text=getString(R.string.result_text,products.size.toString())
            }else ->{
            binding.tvModel.visible()
            binding.tvModel.text = "Product Search"
            binding.tvNumofResults.text=getString(R.string.result_text,products.size.toString())

        }
        }
        productList = products //updating list for sort filter
        if (productList.isEmpty()){
            searchType = "tpms"
            handelZeroProducts()
        }else{
            binding.collapsScreen.visible()
            binding.rvKeyWordResult.visible()
            binding.noResultTv1.gone()
            binding.noResultTv2.gone()
            binding.tvNumofResults.text=getString(R.string.result_text,products.size.toString())
            adapter?.addProductSearches(products)
            adapter?.notifyDataSetChanged()
        }

    }

    private fun onClickFilter() {
        binding.ivFilter.setOnClickListener {
            FilterFragment(mainProductList).show(requireActivity().supportFragmentManager, FilterFragment.TAG)
        }
    }

    private fun dropDownListenerForSortOption() {
        parentFragmentManager.setFragmentResultListener(Constants.SELECTED_SORT_OPTION, this){_, result ->
            //logging apply sort event
            val searchType  = categoryType?: ""
            currentSelectedSortOption = result.getString(Constants.SELECTED_SORT_OPTION).toString()
            sortSearchResultEvent(searchType, currentSelectedSortOption)
            //do with selected option
            val tempList = sort(currentSelectedSortOption, productList, preferredBrandList)
            binding.tvNumofResults.text=getString(R.string.result_text,tempList.size.toString())
            adapter?.addProductSearches(tempList)
            adapter?.notifyDataSetChanged()

        }
    }

    private fun sortSearchResultEvent(searchType: String, value: String) {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Input,
            value //get the sort option selected by user
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Sort_Results, params)
    }

    private fun onClickSort() {
        binding.ivSorting.setOnClickListener {
            SortFragment(currentSelectedSortOption, containsPreferredBrand).show(requireActivity().supportFragmentManager, SortFragment.TAG)
        }
    }

    private fun onClickBothDiameter() {
        binding.bothDiameter.setOnClickListener {
            //get selected position
            val selectedPos = "both"
            val oeDia: String = if (selectedPos.equals("Front",true)){
                oeDiameter.front
            }else{
                oeDiameter.rear
            }
            SizeFragment(oeDia, selectedPos, binding.oeSize.text.toString()).show(requireActivity().supportFragmentManager, SizeFragment.TAG)
        }
    }

    private fun dropDownListenerForValue() {
        parentFragmentManager.setFragmentResultListener(Constants.VALUE_RESULT, this){_, result ->
            currentSelectedValue = result.getString(Constants.VALUE_RESULT).toString()
            binding.suspensionValue.text = currentSelectedValue+"\""
            //calling productByFitment with updated values{}
            clearAdapterList()
            makeFitmentApiCall(false, isSuspensionFitment = true)
        }
    }

    private fun onClickValue() {
        binding.suspensionValue.setOnClickListener {
            ValueSelectFragment(valueListSuspensionFitment, currentSelectedValue).show(requireActivity().supportFragmentManager, ValueSelectFragment.TAG)
        }
    }

    private fun makeSuspensionFitmentApiCall() {
        var fitmentid = ""
        val tempPosition = oeSizeObject.position
        if (oeSizeObject.staggeredfitment.equals("yes",true)){
            if (currentSelectedPosition.equals("front", true)){
                //getting and storing fitment id for front
                fitmentid = tempPosition?.get(0)?.front?.fitmentid.toString()
            }
            if (currentSelectedPosition.equals("rear", true)){
                //getting and storing fitment id for rear
                fitmentid = tempPosition?.get(0)?.rear?.fitmentid.toString()
            }
        }else if (oeSizeObject.staggeredfitment.equals("no",true)){
            //getting and storing fitment id for both
            fitmentid = tempPosition?.get(0)?.both?.fitmentid.toString()
        }
        if (fitmentid.isNotEmpty()){
            vehicleViewModel.getSuspensionFitmentVehicle(fitmentid)
        }

    }

    private fun setupModelForVehicleSearch() {
        binding.tvModel.visible()
        binding.tvModel.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        val stringBuilder = StringBuilder()
        stringBuilder.append(sharedPrefManager.getSelectedYear())
            .append(" ")
            .append(sharedPrefManager.getSelectedMake())
            .append(" ")
            .append(sharedPrefManager.getSelectedModel())

        binding.tvModel.text = stringBuilder.toString()

    }

    private fun dropDownListenerForSize() {
        parentFragmentManager.setFragmentResultListener(Constants.SIZE_RESULT, this){_, result ->
            val selectedSize = result.getString(Constants.SELECTED_SIZE)
            val toWrite = result.getString(Constants.SELECTED_SIZE_TO_USE)
            binding.oeSize.text = selectedSize
            binding.bothDiameter.text = selectedSize
            if (toWrite != null) {
                currentSelectedSize = toWrite
            }
            //log selectPlusEvent ..
            selectPlusEvent(categoryType, currentSelectedPosition, selectedSize)
            //do after position has been changed
            clearAdapterList()
            if (searchType.equals("wheels", true)){
                makeFitmentApiCall(isWheelReq = true, false)
            }else {
                makeFitmentApiCall(isWheelReq = false, false)
            }
        }
    }

    private fun selectPlusEvent(
        categoryType: String?,
        position: String,
        size: String?,
    ) {
        val searchType = categoryType?: ""
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            null
        )
        params.putString("position", position)
        params.putString("size", size)
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Plus_Size, params)
    }

    private fun onClickSize() {
        binding.oeSize.setOnClickListener {
            //get selected position
            val selectedPos = binding.position.text.toString()
            val oeDia: String = if (selectedPos.equals("Front",true)){
                oeDiameter.front
            }else{
                oeDiameter.rear
            }
            SizeFragment(oeDia, selectedPos, binding.oeSize.text.toString()).show(requireActivity().supportFragmentManager, SizeFragment.TAG)
        }
    }

    private fun dropDownListenerForPosition() {
        parentFragmentManager.setFragmentResultListener(Constants.POSITION_SELECTION, this){_, result ->
            val selectedPosition = result.getString(Constants.POSITION_SELECTION)
            binding.position.text = selectedPosition
            if (selectedPosition != null) {
                currentSelectedPosition = selectedPosition
            }
            //calling productByFitment with updated values{}
            clearAdapterList()
            if (searchType.equals("wheels", true)){
                makeFitmentApiCall(isWheelReq = true, false)
            }else
                makeFitmentApiCall(isWheelReq = false, false)
        }
    }

    private fun makeFitmentApiCall(isWheelReq:Boolean, isSuspensionFitment: Boolean) {
        val criteria = Criteria()
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

        if (isWheelReq){
            criteria.productgroup = listOf("custom wheels")
        }
        if (isSuspensionFitment){
            criteria.productgroup = listOf("wheel accessories")
            criteria.categories = listOf("suspension")
            criteria.suspensionsize = listOf(currentSelectedValue)
        }

        options.availability = availability
        options.price = price
        options.images = images
        options.productspec = productspec
        options.includerebates = "true"
        options.includemarketingprograms = "true"

        val vehicle = VehicleRequest(sharedPrefManager.getSelectedYear(), sharedPrefManager.getSelectedMake(), sharedPrefManager.getSelectedModel(), sharedPrefManager.getSelectedTrim(), sharedPrefManager.getSelectedOESize())
        if (currentSelectedSize.equals("All Sizes", true)){
            vehicle.wheeldiameter= ""
        }else if (currentSelectedSize.isNotEmpty()){
            vehicle.wheeldiameter = currentSelectedSize
        }
        vehicle.position = currentSelectedPosition.lowercase()
        val productByFitmentRequest = ProductByFitmentRequest()
        productByFitmentRequest.locationnumber = sharedPrefManager.getLocationNumber().toString()
        productByFitmentRequest.vehicle = vehicle
        productByFitmentRequest.options = options
        productByFitmentRequest.criteria = criteria

        //calling the API
        //Add logic here!!
        binding.collapsScreen.gone()
        binding.rvKeyWordResult.gone()
        binding.noResultTv1.gone()
        binding.noResultTv2.gone()
        binding.progressbar.visible()
        vehicleViewModel.getProductByFitment(productByFitmentRequest)
    }

    private fun onClickPosition() {
        binding.position.setOnClickListener {
            PositionFragment(currentSelectedPosition).show(requireActivity().supportFragmentManager, PositionFragment.TAG)
        }
    }

    private fun resetAllPlaceHolderListState(){
        binding.placeHolderList.tires.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.placeHolderList.wheels.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.placeHolderList.tpms.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
        binding.placeHolderList.suspension.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))

    }
    private fun onClickSuspension() {
        binding.placeHolderList.suspension.setOnClickListener {
            resetAllPlaceHolderListState()
            binding.placeHolderList.suspension.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
            searchType = "suspension"
            //do after click
            binding.collapsScreen.gone()
            binding.rvKeyWordResult.gone()
            binding.progressbar.visible()
            binding.noResultTv1.gone()
            binding.noResultTv2.gone()
            binding.bothDiameter.gone()
            binding.position.gone()
            binding.oeSize.gone()
            binding.suspensionValue.visible()
            //check for null before assign and write logic
            if (valueListSuspensionFitment.isEmpty()){
                binding.suspensionValue.gone()
                handelZeroProducts()
            }else{
                currentSelectedValue = valueListSuspensionFitment[0]
                binding.suspensionValue.text = valueListSuspensionFitment[0]+"\""
                //call API for
                makeFitmentApiCall(isWheelReq = false, true)
            }

        }
    }



    private fun onClickTpms() {
        binding.placeHolderList.tpms.setOnClickListener {
            resetAllPlaceHolderListState()
            binding.placeHolderList.tpms.setTextColor(ContextCompat.getColor(requireContext(),
                theameColor
            ))
            searchType = "tpms"
            //do after click
            binding.collapsScreen.gone()
            binding.rvKeyWordResult.gone()
            binding.progressbar.visible()
            binding.noResultTv1.gone()
            binding.noResultTv2.gone()
            binding.suspensionValue.gone()
            binding.bothDiameter.gone()
            binding.position.gone()
            binding.oeSize.gone()
            vehicleViewModel.getAddOnsForVehicle(addOnsRequest)
        }
    }
    private fun onClickWheels() {
        binding.placeHolderList.wheels.setOnClickListener {
            resetAllPlaceHolderListState()
            binding.placeHolderList.wheels.setTextColor(ContextCompat.getColor(requireContext(),
                theameColor))
            //do after click
            clearAdapterList()
            binding.suspensionValue.gone()
            if (fitmentType){
                binding.position.visible()
                binding.oeSize.visible()
            }else{
                binding.bothDiameter.visible()
            }
            searchType = "wheels"
            makeFitmentApiCall(true, isSuspensionFitment = false)

        }
    }

    private fun onClickTries() {
        binding.placeHolderList.tires.setOnClickListener {
            resetAllPlaceHolderListState()
            binding.suspensionValue.gone()
            if (fitmentType){
                binding.position.visible()
                binding.oeSize.visible()
            }else{
                binding.bothDiameter.visible()
            }
            binding.placeHolderList.tires.setTextColor(ContextCompat.getColor(requireContext(),
                theameColor))
            //do after click
            searchType = "tires"
            makeFitmentApiCall(false, isSuspensionFitment = false)
        }
    }


    private fun CVIntro(binding: FragmentKeywordSearchResuktsBinding) {

        this.binding.ivCVInactive.text=Constants.gotit
        TapTargetView.showFor(requireActivity(),  // `this` is an Activity
            TapTarget.forView(
                this.binding.ivCVInactive,
                "CUSTOMER VIEW",
                "Tap to view or hide product cost amount"
            ) // All options below are optional
                .outerCircleColor(theameColor) // Specify a color for the outer circle
                .outerCircleAlpha(0.96f) // Specify the alpha amount for the outer circle
                .targetCircleColor(android.R.color.white) // Specify a color for the target circle
                .titleTextSize(30) // Specify the size (in sp) of the title text
                .titleTextColor(android.R.color.white) // Specify the color of the title text
                .descriptionTextSize(20) // Specify the size (in sp) of the description text
                .descriptionTextColor(android.R.color.holo_red_dark) // Specify the color of the description text
                .textColor(android.R.color.white) // Specify a color for both the title and description text
                .textTypeface(Typeface.SANS_SERIF) // Specify a typeface for the text
                .dimColor(android.R.color.transparent) // If set, will dim behind the view with 30% opacity of the given color
                .drawShadow(true) // Whether to draw a drop shadow or not
                .cancelable(false) // Whether tapping outside the outer circle dismisses the view
                .tintTarget(true) // Whether to tint the target view's color
                .transparentTarget(false) // Specify whether the target is transparent (displays the content underneath)
                //.icon(Drawable) // Specify a custom drawable to draw as the target
                .targetRadius(60),  // Specify the target radius (in dp)
            object : TapTargetView.Listener() {
                // The listener can listen for regular clicks, long clicks or cancels
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view) // This call is optional
                    //doSomething()
                    sharedPrefManager.saveCVIntro(false)
                    binding.ivCVInactive.text=""
                    binding.ivCVActive.visible()
                    binding.ivCVInactive.gone()
                    binding.ivCVInactive.background= ResourcesCompat.getDrawable(resources, R.drawable.cv_inactive, null)
//                    Toast.makeText(requireActivity(),"Tapped", Toast.LENGTH_SHORT).show()
                }

            })

    }

    private fun setupUI() {
        //section adapter definition
        adapter = KeywordSearcheResultAdapter(::onAddToCartClicked,::isCustomerPickupDelivery,::isFutureDelivery,requireActivity(),arrayListOf(),sharedPrefManager, ::eventLogger, ::callProductDetails)
        binding.rvKeyWordResult.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvKeyWordResult.adapter = adapter
    }

    private fun callProductDetails(bundle: Bundle){
        val productDetailsFragment = ProductDetailsFragment()
        bundle.putString("category", categoryType)
        bundle.putString(Constants.KEY_TYPE,Constants.Results)
        productDetailsFragment.arguments=bundle
       requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, productDetailsFragment)
            .addToBackStack("KeyWordSearchResultsFragment")
            .commit()
    }


    fun BackPressed() {
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener(null)

        when(type){

            Constants.KEY_PRODUCT_BY_KEYWORD->{
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
                val hostFragment = KeyWordSearchFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, hostFragment)
                    .commit()
            }Constants.KEY_VEHICLE_SEARCH ->{
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
            val hostFragment = VehicleSearch.newInstance(true)
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }Constants.BARCODE_SEARCH ->{
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
            val hostFragment = BarcodeSearchFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }Constants.REBATES ->{
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
            val hostFragment = RebateFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }else->{
            BottomNavigationScreenFragment.tvHeaderText?.text= Constants.Product_Search
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)

            val product = ProductFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, product)
                .commit()
        }
        }

        //requireActivity().supportFragmentManager.popBackStack()
        //findNavController().previousBackStackEntry?.destination?.id

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (this.arguments?.getString("type").equals("PDP")){

            val list: List<Product>? =this.arguments?.getSerializable("keyWordSearchResults") as List<Product>?
            if (list != null) {
                productResult(list)
            }
        }


        permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

            when(it){

                is NetworkResult.Success ->{

                    println("orderPermissions ${it.data}")
                    if(it.data.equals("VIEW_PRODUCT_COSTS",true)){
                        if (sharedPrefManager.getCV() == true) {
                            binding.ivCVActive.visible()
                            binding.ivCVInactive.gone()
                        } else {
                            binding.ivCVActive.gone()
                            binding.ivCVInactive.visible()
                        }
                    }else{
                        sharedPrefManager.saveCV(true)
                        binding.ivCVActive.gone()
                        binding.ivCVInactive.gone()

                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)

                }
                is NetworkResult.Loading -> {
                    println("loading?????")

                }
            }
        })

        ViewModel.productByKeywordLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {

                    binding.progressbar.visible()

                    it.data?.let {

                        it.products.let { result -> productResult(result) }

                    }
                }
                is NetworkResult.Error -> {
                    binding.progressbar.gone()

                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }

        //adding for productCriteriaReq
        productByCriteriaViewModel.productByCriteriaResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {


                    it.data?.let {
                        if (searchType.equals("TPMS",true)){
                            setupModelForVehicleSearch()
                            binding.collapsScreen.visible()
                            binding.rvKeyWordResult.visible()
                            binding.rvKeyWordResult.scrollToPosition(0)
                            binding.collapsScreen.setExpanded(true)
                            binding.noResultTv1.gone()
                            binding.noResultTv2.gone()
                            binding.clView.visible()
                            binding.ivFilter.visible()
                            binding.ellipseRedGarageFilter.visible()
                            binding.tvApprovalNumbersFilter.visible()
                            binding.ivSorting.visible()
                            binding.ellipseRedGarage.visible()
                            binding.tvApprovalNumbers.visible()
                            binding.ivCVActive.visible()
                            binding.ivCVInactive.visible()
                            binding.startNewSearch.gone()

                        }
                        binding.progressbar.gone()
                        it.products.let { result ->
                            if (result.size>0) {
                                productResult(result)
                            }else{

                                binding.noResultTv1.visible()
                                binding.noResultTv2.visible()
                                binding.clView.gone()
                                binding.ivFilter.gone()
                                binding.ellipseRedGarageFilter.gone()
                                binding.tvApprovalNumbersFilter.gone()
                                binding.ivSorting.gone()
                                binding.ellipseRedGarage.gone()
                                binding.tvApprovalNumbers.gone()
                                binding.ivCVActive.gone()
                                binding.ivCVInactive.gone()
                                binding.startNewSearch.visible()
                            }
                        }

                    }
                }
                is NetworkResult.Error -> {
                    binding.progressbar.gone()
                    binding.noResultTv1.visible()
                    binding.noResultTv2.visible()
                    binding.clView.gone()
                    binding.ivFilter.gone()
                    binding.ellipseRedGarageFilter.gone()
                    binding.tvApprovalNumbersFilter.gone()
                    binding.ivSorting.gone()
                    binding.ellipseRedGarage.gone()
                    binding.tvApprovalNumbers.gone()
                    binding.ivCVActive.gone()
                    binding.ivCVInactive.gone()
                    binding.startNewSearch.visible()

                    //binding.noResultTv2.text=it.message
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }

        //observer for installation spec
        vehicleViewModel.installationSpecLiveData.observe(viewLifecycleOwner) {
            when (it){
                is NetworkResult.Success -> {
                    oeDiameter = it.data?.diameter ?: Diameter("", "")
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
                    val response = it.data
                    //converting and submitting list to adapter
                    handleFitmentResponse(response)
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {
                }
            }
        }

        //observer for addOns
        vehicleViewModel.addOnsLiveData.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Success ->{
                    it.data?.let { it1 -> handleAddOnsResponse(it1) }
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {

                }
            }
        }

        //observer for Fitment
        vehicleViewModel.suspensionFitmentLiveData.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Success ->{
                    val response = it.data?.suspensionFitmentList
                    if (response != null) {
                        if (!response.isEmpty())
                            response.forEach { suspensionFitment ->
                                valueListSuspensionFitment.add(suspensionFitment.height?.value.toString())
                            }
                    }
                }
                is NetworkResult.Error -> {
                    toast(it.message.toString())
                }
                is NetworkResult.Loading -> {

                }
            }
        }

        //section observer for create retail quote
        myQuotesViewModel.createQuoteLiveData.observe(viewLifecycleOwner){ it ->
            when(it){
                is NetworkResult.Error ->{
                        toast(it.message)
                    showDialogQuote(false)
                }
                is NetworkResult.Loading -> {

                }

                is NetworkResult.Success -> {
                    if (it.data?.retailquote != null){
                        val quoteToSave = Gson().toJson(it.data.retailquote)
                        sharedPrefManager.saveWorkingQuote(quoteToSave, sharedPrefManager.getLocationNumber().toString())
                    }

                    println("Saved Quote ->${Gson().fromJson(sharedPrefManager.getWorkingQuote(sharedPrefManager.getLocationNumber().toString()), Retailquote::class.java)}")
                    showDialogQuote(true)
                }
            }
        }

    }

    private fun handleAddOnsResponse(response: AddOnsResponse) {

        if (response.addons.isNotEmpty()){
            val productNumberList: MutableList<String> = mutableListOf()
            response.addons.forEach { addon ->
                //adding add productNumber with type = tpms
                if (addon.type.equals("TPMS",true)){
                    addon.atdproductnumber?.let { productNumberList.add(it) }
                }
            }
            //add null check on productNumberList
            if (productNumberList.isEmpty()){
                handelZeroProducts()
            }else{
                makeTpmsApiCall(productNumberList)

            }
        }else{
            //handle null response for addons
            handelZeroProducts()
        }
    }

    private fun makeTpmsApiCall(productNumberList: MutableList<String>) {
        criteriaForTpms.atdproductnumber = productNumberList
        tpmsRequest.criteria = criteriaForTpms
        productByCriteriaViewModel.getProductByCriteria(tpmsRequest)
    }

    private fun handleFitmentResponse(response: ProductByFitmentResponse?) {
        setupModelForVehicleSearch()
        binding.collapsScreen.visible()
        binding.rvKeyWordResult.visible()
        binding.rvKeyWordResult.scrollToPosition(0)
        binding.collapsScreen.setExpanded(true)
        binding.noResultTv1.gone()
        binding.noResultTv2.gone()
        val products: MutableList<Product> = mutableListOf()
        if (response != null) {
            for (fitment in response.fitments) {
                for (result in fitment.fitmentresults ?: emptyList()) {
                    products.addAll(
                        result.position.both.products +
                                result.position.front.products +
                                result.position.rear.products
                    )
                }
            }

            if (products.isNotEmpty()){
                products[0].atdproductnumber?.let {
                    addOnsRequest.atdproductnumber = it
                }
            }
        }

        binding.progressbar.gone()
        productResult(products)
        firstEntryTire = false
    }


    private fun productResult(products: List<Product>) {

        if (products.isNotEmpty()){

            productList = products
            mainProductList = products
            if (keyword?.isNotEmpty() == true) {
                val keywordSearchEntity = PreviousKeywordSearchEntity()
                keywordSearchEntity.keyword = keyword.toString()
                recentKeywordSearchViewModel.saveKeyword(keywordSearchEntity)
            }
            val userPreferences = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
            currentSelectedSortOption = userPreferences.sortOrder.toString() //defaulting sort  option to User Selection
            var sortedProducts =sort(currentSelectedSortOption, products, preferredBrandList)
            val userSelectedFilterAvailabilityDefault = userPreferences.availabilityFilter
            getFilterOptions(sortedProducts)
            preferredBrandCheck(sortedProducts)
            //checking if preferred brand exists; if not defaulting sort to Brand
            if(!containsPreferredBrand){
                currentSelectedSortOption = "Brand"
                sortedProducts =sort(currentSelectedSortOption, products, preferredBrandList)
            }
            //applying default Availability filter, before display product first time
            var tempList = filterBasedOnAvailabilityDefault(sortedProducts, userSelectedFilterAvailabilityDefault)
            //applying default Brand Filter
            val userDefaultBrandFilter = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration:: class.java).myBrands
            var countToAddForPreferredBrand = 0
            if(userDefaultBrandFilter.equals("Show Preferred Brands Only", true)){
                //user selected preferred brand only filter list
                val tempForLoopList = mutableListOf<Product>()
                for (brand in preferredBrandList) {
                    val filteredProducts = tempList.filter { product ->
                        product.brand.lowercase() == brand.lowercase()
                    }
                    //assigning tempList with Filter Products by preferred brands
                    tempForLoopList.addAll(filteredProducts)
                }
                tempList = tempForLoopList
                //update filter option to make all preferred brand as selected
                val filterOptionList = mainViewModel.getFilterOptions()
                filterOptionList.PreferredBrands?.forEach { brand ->
                    brand.isSelected = true
                    countToAddForPreferredBrand += 1
                }
                //updating list after selecting all brands
                mainViewModel.setFilterOptions(filterOptionList)

            }
            binding.tvNumofResults.text=getString(R.string.result_text,tempList.size.toString())
            if (tempList.isEmpty()){
                binding.progressbar.gone()
                handelZeroProducts()
            }else{
                adapter?.addProductSearches(tempList)
                adapter?.notifyDataSetChanged()
                binding.progressbar.gone()
                binding.tvApprovalNumbersFilter.text=getString(R.string.filter_text,(1 + countToAddForPreferredBrand).toString()) }
        }else{
            binding.progressbar.gone()
            handelZeroProducts()
        }
    }

    private fun filterBasedOnAvailabilityDefault(sortedProducts: List<Product>, userSelectedFilterAvailabilityDefault: String?): List<Product> {
        //filtering based on default availability
        var filteredProductsAvailability: List<Product> = listOf()
        filteredProductsAvailability = when (userSelectedFilterAvailabilityDefault?.lowercase()) {
            "local" -> sortedProducts.filter { availabilityMatchesProduct(it.availability, "local") }
            "local+" -> sortedProducts.filter { availabilityMatchesProduct(it.availability, "local+") }
            "national" -> sortedProducts.filter { availabilityMatchesProduct(it.availability, "national")
            }
            "all" -> sortedProducts
            else -> emptyList()
        }
        return filteredProductsAvailability
    }
    private fun availabilityMatchesProduct(availability: AvailabilityX, selectedAvailability: String): Boolean {
        return when (selectedAvailability.lowercase()) {
            "local" -> availability.local > 0
            "local+" -> availability.localplus + availability.local > 0
            "national" -> availability.nationwide + availability.localplus + availability.local > 0
            else -> false
        }
    }

    private fun getFilterOptions(sortedProducts: List<Product>) {
        val filterOptionList = FilterOptions()

        val userDefaultAvailabilityFilter = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration:: class.java).availabilityFilter
        //adding default filter options for availability
        val temp1: FilterItem = FilterItem()
        temp1.isSelected = userDefaultAvailabilityFilter.equals("All", true)
        temp1.name = "ALL"
        val temp2: FilterItem = FilterItem()
        temp2.isSelected = userDefaultAvailabilityFilter.equals("Local", true)
        temp2.name = "LOCAL"
        val temp3: FilterItem = FilterItem()
        temp3.isSelected = userDefaultAvailabilityFilter.equals("Local+", true)
        temp3.name = "LOCAL+"
        val temp4: FilterItem = FilterItem()
        temp4.isSelected = userDefaultAvailabilityFilter.equals("National", true)
        temp4.name = "NATIONAL"
        filterOptionList.Availability = listOf(temp1,temp2, temp3, temp4)


        //for size
        val sizeItems = mutableListOf<FilterItem>()
        val tempSizeList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempSizeList.add(product.productspec.size)
        }
        tempSizeList.forEach { size ->
            size?.let {
                sizeItems.add(FilterItem(false, size))
            }
        }
        if (sizeItems.isNotEmpty()){
            filterOptionList.Size = sizeItems
        }


        //for preferred brand
        val preferredBrandItems = mutableListOf<FilterItem>()
        val tempBrandList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempBrandList.add(product.brand)
        }
        tempBrandList.forEach { brand ->
            brand?.let {
                if (preferredBrandList.contains(brand)){
                    preferredBrandItems.add(FilterItem(false, brand))
                }
            }
        }
        if (preferredBrandItems.isNotEmpty()){
            filterOptionList.PreferredBrands = preferredBrandItems
        }


        //for other brands
        val otherBrands = mutableListOf<FilterItem>()
        val tempOtherBrandList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempOtherBrandList.add(product.brand)
        }
        tempOtherBrandList.forEach { brand ->
            brand?.let {
                if (!preferredBrandList.contains(brand)){
                    otherBrands.add(FilterItem(false, brand))
                }
            }
        }
        if (otherBrands.isNotEmpty()){
            filterOptionList.Brands = otherBrands
        }

        //for Style
        val styleItems = mutableListOf<FilterItem>()
        val tempStyleList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempStyleList.add(product.style)
        }
        tempStyleList.forEach {style ->
            style?.let {
                styleItems.add(FilterItem(false, style))
            }
        }
        if (styleItems.isNotEmpty()){
            filterOptionList.Style = styleItems
        }

        //for Speed Rating
        val speedRatingItems =mutableListOf<FilterItem>()
        val tempSpeedRatingList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach {product ->
            tempSpeedRatingList.add(product.productspec.speedrating)
        }
        tempSpeedRatingList.forEach { speed ->
            speed?.let {
                speedRatingItems.add(FilterItem(false, speed))
            }
        }
        if (speedRatingItems.isNotEmpty()){
            filterOptionList.SpeedRating = speedRatingItems
        }

        //for Mileage Warranty
        val mileageWarrantyItems = mutableListOf<FilterItem>()
        val tempMileageList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempMileageList.add(product.productspec.mileagewarranty)
        }
        tempMileageList.forEach { mileage ->
            mileage?.let {
                mileageWarrantyItems.add(FilterItem(false, mileage))
            }
        }
        if (mileageWarrantyItems.isNotEmpty()){
            filterOptionList.MileageWarranty = mileageWarrantyItems
        }

        //for seasonal designation
        val seasonalDesignationItems = mutableListOf<FilterItem>()
        val tempSDList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempSDList.add(product.productspec.winterdesignation)  //here here
        }
        tempSDList.forEach {sd ->
            sd?.let {
                seasonalDesignationItems.add(FilterItem(false, sd))
            }
        }
        if (seasonalDesignationItems.isNotEmpty()){
            filterOptionList.SeasonalDesignation = seasonalDesignationItems
        }

        //for Run Flat
        val runFlatItems = mutableListOf<FilterItem>()
        val tempRunFlatList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            product.productspec.runflat?.let { tempRunFlatList.add(it) }
        }
        tempRunFlatList.forEach { runFlat ->
            runFlat?.let {
                runFlatItems.add(FilterItem(false, runFlat))
            }
        }
        if (tempRunFlatList.isNotEmpty()){
            filterOptionList.RunFlat = runFlatItems
        }

        //for marketing programs
        val mpItems = mutableListOf<FilterItem>()
        val tempToAddMPList: MutableSet<String> = mutableSetOf()
        val tempMPList: MutableSet<List<Marketingprograms>> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempMPList.add(product.marketingprograms)
        }
        tempMPList.forEach { marketingprograms ->
            marketingprograms.forEach {
                    program ->
                tempToAddMPList.add(program.name)
            }
        }
        tempToAddMPList.forEach { name ->
            name?.let {
                mpItems.add(FilterItem(false, name))
            }
        }
        if (mpItems.isNotEmpty()){
            filterOptionList.MarketingPrograms = mpItems
        }

        //for rebates
        val rebatesItems = mutableListOf<FilterItem>()
        val tempToAddRebateList: MutableSet<String> = mutableSetOf()
        val tempList: MutableSet<List<Rebate>> = mutableSetOf()
        sortedProducts.forEach { product ->
            tempList.add(product.rebates)
        }
        tempList.forEach { rebates ->
            rebates.forEach { rebate ->
                rebate.code?.let { tempToAddRebateList.add(it) }
            }
        }
        tempToAddRebateList.forEach { rebate ->
            rebate?.let {
                rebatesItems.add(FilterItem(false, rebate))
            }
        }
        if (rebatesItems.isNotEmpty()){
            filterOptionList.Rebates = rebatesItems
        }

        //for wheel diameter
        val wheelDiameteritems = mutableListOf<FilterItem>()
        val tempWDList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            product.productspec.wheeldiameter?.let { tempWDList.add(it) }
        }
        tempWDList.forEach { wd ->
            wd?.let {
                wheelDiameteritems.add(FilterItem(false, wd))
            }
        }
        if (wheelDiameteritems.isNotEmpty()){
            filterOptionList.WheelDiameter = wheelDiameteritems
        }

        //for wheel width
        val wheelWidthItems = mutableListOf<FilterItem>()
        val tempWWList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            product.productspec.wheelwidth?.let { tempWWList.add(it) }
        }
        tempWWList.forEach { ww ->
            ww?.let {
                wheelWidthItems.add(FilterItem(false, ww))
            }
        }
        if (tempWWList.isNotEmpty()){
            filterOptionList.WheelWidth = wheelWidthItems
        }

        //for bolt pattern
        val boltPatternItems = mutableListOf<FilterItem>()
        val tempBoltPatternList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            product.productspec.boltpattern1?.let { tempBoltPatternList.add(it) }
        }
        tempBoltPatternList.forEach { bp ->
            bp?.let {
                boltPatternItems.add(FilterItem(false, bp))
            }
        }
        if (boltPatternItems.isNotEmpty()){
            filterOptionList.BoltPattern = boltPatternItems
        }

        //for atd finish
        val atdFinishItems = mutableListOf<FilterItem>()
        val tempAtdFinishList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach { product ->
            product.productspec.atdfinish?.let { tempAtdFinishList.add(it) }
        }
        tempAtdFinishList.forEach {finish ->
            finish?.let {
                atdFinishItems.add(FilterItem(false, finish))
            }
        }
        if (atdFinishItems.isNotEmpty()){
            filterOptionList.ATDFinish = atdFinishItems
        }

        //for offset description
        val offsetDesItems = mutableListOf<FilterItem>()
        val tempOffsetDesList: MutableSet<String> = mutableSetOf()
        sortedProducts.forEach {product ->
            product.productspec.offsetdescription?.let { tempOffsetDesList.add(it) }
        }
        tempOffsetDesList.forEach { od ->
            od?.let {
                offsetDesItems.add(FilterItem(false, od))
            }
        }
        if (offsetDesItems.isNotEmpty()){
            filterOptionList.OffsetDescription = offsetDesItems
        }

        //updating main list in main view modal
        mainViewModel.setFilterOptions(filterOptionList)
    }

    private fun handelZeroProducts() {
        when (searchType){

            "tires" ->{
                binding.collapsScreen.gone()
                binding.rvKeyWordResult.gone()
                binding.progressbar.gone()
                binding.noResultTv1.text = getString(R.string.noResTpms)
                binding.noResultTv1.visible()
                binding.noResultTv2.text = getString(R.string.noResSubLine)
                binding.noResultTv2.visible()
                if (firstEntryTire){
                    binding.ivSorting.gone()
                    binding.ivFilter.gone()
                    binding.ivCVInactive.gone()
                    binding.ivCVActive.gone()
                    binding.bothDiameter.gone()
                    binding.startNewSearch.visible()
                    binding.vehicleTopList.gone()
                    binding.position.gone()
                    binding.oeSize.gone()
                    binding.startNewSearch.setOnClickListener {


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
                        val hostFragment = VehicleSearch()
                        requireActivity().supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.bottomNavigationViewFrame, hostFragment)
                            .commit()
                    }
                }
            }

            "wheels" ->{
                binding.collapsScreen.gone()
                binding.rvKeyWordResult.gone()
                binding.progressbar.gone()
                binding.noResultTv1.text = getString(R.string.noResWheel)
                binding.noResultTv1.visible()
                binding.noResultTv2.text = getString(R.string.noResSubLine)
                binding.noResultTv2.visible()
            }

            "tpms" ->{
                binding.collapsScreen.gone()
                binding.rvKeyWordResult.gone()
                binding.progressbar.gone()
                binding.noResultTv1.text = getString(R.string.noResTpms)
                binding.noResultTv1.visible()
                binding.noResultTv2.text = getString(R.string.noResSubLine)
                binding.noResultTv2.visible()
            }

            "suspension" ->{
                binding.collapsScreen.gone()
                binding.rvKeyWordResult.gone()
                binding.progressbar.gone()
                binding.noResultTv1.text = getString(R.string.noResTpms)
                binding.noResultTv1.visible()
                binding.noResultTv2.text = getString(R.string.noResSubLine)
                binding.noResultTv2.visible()
            }

            else ->{

            }

        }
    }

    private fun clearAdapterList(){
        adapter?.addProductSearches(emptyList())
        adapter?.notifyDataSetChanged()
    }

    private fun getCriteriaFromBundleForTireSearch() {
        val bundle = this.arguments
        if (bundle != null) {
            try {
                val criteriaString = bundle.getString(Constants.KEY_PRODUCT_CRITERIA)
                println("Tires request $criteriaString")
                criteriaForProductSearchTire = Gson().fromJson(criteriaString, Criteria::class.java)

            }catch (_: java.lang.Exception){
            }
        }
    }

    private fun getCriteriaFromBundleForWheelAccessoriesSearch() {
        val bundle = this.arguments
        if (bundle != null) {
            try {
                val criteriaString = bundle.getString(Constants.KEY_PRODUCT_CRITERIA_WHEEL_ACCESSORIES)
                criteriaForProductSearchWheelAccessories = Gson().fromJson(criteriaString, Criteria::class.java)
            }catch (_: java.lang.Exception){
            }
        }
    }

    private fun getCriteriaFromBundleForSuppliesSearch() {
        val bundle = this.arguments
        if (bundle != null) {
            try {
                val criteriaString = bundle.getString(Constants.KEY_PRODUCT_CRITERIA_SUPPLIES)
                criteriaForProductSearchSupplies = Gson().fromJson(criteriaString, Criteria::class.java)
            }catch (_: java.lang.Exception){
            }
        }
    }

    private fun getCriteriaFromBundleForTubesAndFlapsSearch() {
        val bundle = this.arguments
        if (bundle != null) {
            try {
                val criteriaString = bundle.getString(Constants.KEY_PRODUCT_CRITERIA_TUBES_AND_FLAPS)
                criteriaForProductSearchTubesAndFlaps = Gson().fromJson(criteriaString, Criteria::class.java)
            }catch (_: java.lang.Exception){
            }
        }
    }

    private fun onAddToCartClicked(cart: Cart){

        binding.progressbar.visible()
        recentKeywordSearchViewModel.getCreatedCartRecordInFireStore(cart).observe(viewLifecycleOwner,
            Observer {cartList->

                val filteredCartList = cartList.filter {
                    it?.userName.equals(sharedPrefManager.getUserName()) &&
                            it?.locationNumber.equals(sharedPrefManager.getLocationNumber())
                }
                val totalQuantity = filteredCartList.sumOf { it!!.quantity }

                println("Updated records $filteredCartList")

                if (totalQuantity > 0) {
                    BottomNavigationScreenFragment.badgeCount?.visible()
                    BottomNavigationScreenFragment.badgeCount?.text = totalQuantity.toString()
                    showDialog()
                } else {
                    BottomNavigationScreenFragment.badgeCount?.gone()
                }

                binding.progressbar.gone()

            })

    }


    private fun isCustomerPickupDelivery(){
        confirmPickupDialog()
    }

    private fun isFutureDelivery(){
        confirmFutureDeliverDialog()
    }

    private fun confirmPickupDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickupalert_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun confirmFutureDeliverDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickupalert_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        val tvHeader = dialog.findViewById(R.id.tvHeader) as TextView
        val tvMessage = dialog.findViewById(R.id.tvMessage) as TextView
        tvHeader.setText(R.string.future_delivery_must_apply_to_all_item_s_in_your_cart)
        tvMessage.setText(R.string.national_delivery_items_are_not_eligible_for_future_and_will_be_removed_from_your_cart)
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showDialog() {
        val dialog = Dialog(requireActivity(), R.style.WideDialog)
        dialog.setContentView(R.layout.addcart_dialog)
        val continueShopping: TextView = dialog.findViewById(R.id.continueShopping)
        val checkOut: TextView = dialog.findViewById(R.id.checkoutNow)
        continueShopping.setOnClickListener {
            dialog.dismiss()
        }
        checkOut.setOnClickListener {
            val cartFragment = CartFragment { data ->
                triggerBadgeCount(data)
            }
            cartFragment.show(requireActivity().supportFragmentManager, CartFragment.TAG)
            //CartFragment(::triggerBadgeCount).show(requireActivity().supportFragmentManager, CartFragment.TAG)
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show()
    }

    private fun showDialogQuote(b: Boolean) {
        val dialog = Dialog(requireActivity(), R.style.WideDialog)
        dialog.setContentView(R.layout.addcart_dialog)
        val cartMessage : TextView = dialog.findViewById(R.id.cartAddedMessage)
        val aadMoreProds: TextView = dialog.findViewById(R.id.continueShopping)
        val goToQuotes: TextView = dialog.findViewById(R.id.checkoutNow)

        cartMessage.text = getString(R.string.product_added)
        aadMoreProds.text = getString(R.string.add_more_prods)
        goToQuotes.text = getString(R.string.go_to_quotes)
        //setting up color
        goToQuotes.setTextColor(ContextCompat.getColor(requireContext(), theameColor))
        goToQuotes.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))


        if (!b){
            cartMessage.text = getString(R.string.save_failed)
            goToQuotes.gone()
            aadMoreProds.text = getString(R.string.ok)
        }
        aadMoreProds.setOnClickListener {
            dialog.dismiss()
        }
        goToQuotes.setOnClickListener {
            val myQuotesFragment = ViewMyQuotesFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, myQuotesFragment)
                .addToBackStack("KeyWordSearchResultsFragment")
                .commit()
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show()
    }

    private fun triggerBadgeCount( data :PlaceOrder){

        val placeOrder = Gson().toJson(data)
        val bundle = Bundle()
        bundle.putString("placeOrder", placeOrder)
        findNavController().navigate(R.id.fragment_keyword_results_to_bottom_noavigation,bundle)

    }

    private fun preferredBrandCheck(products: List<Product>) {
        products.forEach { product ->
            if (preferredBrandList.contains(product.brand)){
                containsPreferredBrand = true
            }
        }
    }

    private fun eventLogger(eventNumber: Int, product: Product, qty: String){
        val searchType = categoryType?: ""
        when(eventNumber){

            0 ->{
                toast("Feature not implemented yet.")
                //Add to Quote Event
                //addQuoteEvent(searchType, product, qty)
            }
            1 ->{
                //View Marketing Prog Event
                println("")
            }
            2 ->{
                //view Rebates Event
                println("")
            }
            3 ->{
                //Add To List Event
                addProdFromProdCardEvent(searchType)

            }
            4 ->{
                //increase qty event
                qtyUpEvent(searchType)
            }
            5 ->{
                //decrease qty event
                qtyDecEvent(searchType)
            }
        }
    }

    //section onClickQuote
    private fun addQuoteEvent(searchType: String, product: Product, qty: String) {

        println("Got Product here as -> ${product.atdproductnumber}")
        //make Create Quote API Call
        val createQuoteRequest = CreateQuoteRequest()
        createQuoteRequest.locationnumber = sharedPrefManager.getLocationNumber().toString()
        val lineItem = Lineitem(product.atdproductnumber, quantity = qty.toInt())
        createQuoteRequest.lineitems = listOf(lineItem)
        println("Request ->${Gson().toJson(createQuoteRequest)}")
        myQuotesViewModel.createRetailQuote(createQuoteRequest)
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Impression,
            "Add to quote"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Add_To_Quote, params)
    }

    private fun addProdFromProdCardEvent(searchType: String) {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            "Add to list"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Add_To_List, params)
    }

    private fun qtyDecEvent(searchType: String) {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            "Quantity decreased"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Quantity_Down, params)
    }

    private fun qtyUpEvent(searchType: String) {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_List,
            searchType,
            Action.Click,
            "Quantity increased"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Quantity_Up, params)

    }




}
package com.atd.atdmobileapp.ui.product.tires

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentTiresBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.addRequestToEventParams
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TiresFragment : Fragment() {


    var _binding : FragmentTiresBinding?= null
    private val binding get() = _binding!!
    private var isBrandSelected = false
    private var isSearchEnabled = false
    private var isResetEnabled = false
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var request : ProductByCriteriaRequest
    private  var  size: List<String>?= null
    private  var brand: List<String>?= null
    private  var winterdesignation: List<String>?= null
    private  var speedrating: List<String>?= null
    private  var mfgproductnumber: List<String>?= null
    private  var atdproductnumber: List<String>?= null
    private  var productgroup: List<String>?= null
    private  var brandList = ArrayList<String>()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()
    private var preferredBrandList = listOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTiresBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        request = ProductByCriteriaRequest()
        productgroup = listOf("")
        binding.tvInst.text =
            buildString {
                append("Please use one or more of the following\ncategories to narrow your search.")

            }

        //onClick for cat dropdown menu
        val viewsToClick = listOf<View>(binding.prodCatDropMenu, binding.prodCaHint, binding.viewDivider2, binding.prodCat )
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                callProdCatDrop()
            }
        }
//        binding.prodCatDropMenu.setOnClickListener{
//            callProdCatDrop()
//        }
//        binding.prodCaHint.setOnClickListener {
//            callProdCatDrop()
//        }
//        binding.viewDivider2.setOnClickListener {
//            callProdCatDrop()
//        }
//        binding.prodCat.setOnClickListener {
//            callProdCatDrop()
//        }

        binding.bottomButtons.ivSearch.setOnClickListener {
            if (isSearchEnabled){
                createRequestBody()
            }
        }
        bindObservers()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()


        //onEditText for tire size
        binding.etTireSize.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.productWarning.visibility = View.VISIBLE

            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    if (s != null) {
                        resetState(true)
                        searchState(true)
                        if ( s.length >=4 ){
                            binding.productWarning.visibility = View.INVISIBLE
                            isBrandSelected = true
                            size = listOf(s.toString())
                            enableBrand()
                            searchState(true)

                        }else if ( s.length == 0){
                            isBrandSelected = false
                            binding.productWarning.visibility = View.INVISIBLE
                            disableBrand()
                            resetState(false)
                            searchState(false)
                        }
                    }
                }catch (e : java.lang.Exception){
                    e.message
                }
            }
        })

        //onClickForBrand
        val viewsToClickBrand = listOf<View>(binding.prodBrandDropMenu, binding.brandsHint, binding.viewDivider4, binding.brands)
        viewsToClickBrand.forEach { view ->
            view.setOnClickListener {
                if (isBrandSelected){
                    selectBrands()
                    enableSpeedAndSeasonal()
                    searchState(true)
                    resetState(true)
                }
            }
        }
//        binding.prodBrandDropMenu.setOnClickListener {
//            if (isBrandSelected){
//                selectBrands()
//                enableSpeedAndSeasonal()
//                searchState(true)
//                resetState(true)
//            }
//        }
//        binding.brandsHint.setOnClickListener {
//            if (isBrandSelected){
//                selectBrands()
//                enableSpeedAndSeasonal()
//                searchState(true)
//                resetState(true)
//            }
//        }

        val viewsToClickSpeedRating = listOf<View>(binding.speedHint, binding.speedDropMenu, binding.sppedRating, binding.viewDivider5)
        //onClick for speed Rating
        viewsToClickSpeedRating.forEach { view ->
            view.setOnClickListener {
                if (isBrandSelected){
                    callSpeedRatingDrop()
                    searchState(true)
                }
                resetState(true)
            }
        }
//        binding.speedDropMenu.setOnClickListener {
//            if (isBrandSelected){
//                callSpeedRatingDrop()
//                searchState(true)
//            }
//            resetState(true)
//        }


        //onClick for SeasonDesg
        val viewsToClickSeasonDesg = listOf<View>(binding.seasonalDesg, binding.seasonalMenu, binding.seasonHint, binding.viewDivider6)
        viewsToClickSeasonDesg.forEach { view ->
            view.setOnClickListener {
                if (isBrandSelected){
                    callSeasonalDesgDrop()
                }
            }
        }
//        binding.seasonalMenu.setOnClickListener {
//            if (isBrandSelected){
//                callSeasonalDesgDrop()
//            }
//        }

        //onclick for Supplier number
        binding.supplierHint.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!= null){
                    if (s.length >0){
                        mfgproductnumber = listOf(s.toString())
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        //onclick for ATD Part number
        binding.atdPartNumberHint.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!= null){
                    if (s.length >0){
                        atdproductnumber = listOf(s.toString())
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        //onClick for reset
        binding.bottomButtons.ivReset.setOnClickListener {
            onReset()
        }

        // Set the result listener for product Cat drop down
        parentFragmentManager.setFragmentResultListener("tireTypeSelection", this) { _, result ->
            val tireType= result.getString("tireType")
            binding.prodCaHint.setTextColor(Color.BLACK)
            binding.prodCaHint.text = tireType

            if (tireType != getString(R.string.passenger_light_truck)){
                when(tireType){
                    getString(R.string.medium_truck) -> {
                        productgroup = listOf(getString(R.string.medium_truck_tires))
                    }

                    getString(R.string.golf_and_atv) -> {
                        productgroup = listOf("small tires")
                    }

                    getString(R.string.trailer) -> {
                        productgroup = listOf("trailer tires")
                    }

                    getString(R.string.farm) -> {
                        productgroup = listOf("farm tires")
                    }

                    getString(R.string.industrial) -> {
                        productgroup = listOf("industrial tires")
                    }

                    getString(R.string.otr_grader_em) -> {
                        productgroup = listOf("otr,grader,em tires")
                    }else ->{
                    productgroup = listOf("")
                }
                }
            }else{
                productgroup = listOf("")
            }
            resetState(true)
        }

        // Set the result listener for speed rating drop down
        parentFragmentManager.setFragmentResultListener(Constants.SPEED_SELECTION, this) { _, result ->
            val selectedCheckboxes = result.getString(Constants.SPEED_RESULT)
            if (selectedCheckboxes != ""){
                binding.speedHint.text = selectedCheckboxes
                speedrating = listOf(selectedCheckboxes.toString())
                binding.speedHint.setTextColor(Color.BLACK)
                resetState(true)
                searchState(true)

            }else{
                binding.speedHint.text = getString(R.string.all)
                binding.speedHint.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            }
            enableSpeedAndSeasonal()
        }

        // Set the result listener for seasonal rating drop down
        parentFragmentManager.setFragmentResultListener(Constants.SEASONAL_SELECTION, this) { _, result ->
            val selectedCheckboxes = result.getString(Constants.SEASONAL_KEY)
            if (selectedCheckboxes != ""){
                binding.seasonHint.text = selectedCheckboxes
                winterdesignation = listOf(selectedCheckboxes.toString())
                binding.seasonHint.setTextColor(Color.BLACK)
                resetState(true)
                searchState(true)

            }else{
                binding.seasonHint.text = getString(R.string.all)
                binding.seasonHint.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            }
            enableSpeedAndSeasonal()
        }

        // Set the result listener for Brands drop down
        parentFragmentManager.setFragmentResultListener(Constants.BRAND_RESULT, this) { _, result ->
            val temp = ArrayList<String>()
            val list1 = mainViewModel.getSelectedPositionsItem()
            list1?.let { temp.addAll(it) }
            val list2 = mainViewModel.getSelectedOtherPositionsItem()
            list2?.let { temp.addAll(it) }
            //got both list of preferred and other brand, merged them together and send it in request
            brandList = ArrayList<String>(LinkedHashSet<String>(temp))
            val brandsHintText = when {
                //displaying only first 3 added brands and showing +n after that
                brandList.size > 3 -> {
                    "${brandList[0]}, ${brandList[1]}, ${brandList[2]} ${getString(R.string.plus)}${brandList.size - 3}${getString(R.string.more)}"
                }
                brandList.size == 0 ->{
                    brandList.joinToString(prefix = "All")
                }
                else -> {
                    brandList.joinToString(separator = ", ")
                }
            }
            binding.brandsHint.text = brandsHintText
            if (brandList.isEmpty()){
                binding.brandsHint.hint = getString(R.string.all)
                binding.brandsHint.setTextColor(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            }else{
                binding.brandsHint.setTextColor(Color.BLACK)
            }

        }

        setUpTheme()
    }

    private fun setUpTheme() {

        binding.prodCatDropMenu.imageTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.viewDivider2.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.viewDivider3.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.viewDivider7.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.viewDivider8.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.bottomButtons.viewDivider9.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
    }

    private fun bindObservers() {
        tiresBrandsViewModel.preferredBrandsLiveData.observe(viewLifecycleOwner, Observer {
            preferredBrandList = it.data?.map { it.value }?.toList()!!
        })
    }

    private fun onReset() {
        if (isResetEnabled){
            resetState(false)
            searchState(false)
            binding.prodCaHint.text = ""
            binding.prodCaHint.hint = getString(R.string.passenger_light)
            binding.etTireSize.text.clear()
            binding.etTireSize.hint = getString(R.string.e_g_2256517_or_225_65r17)
            binding.brandsHint.text = ""
            binding.brandsHint.hint = getString(R.string.all)
            binding.speedHint.hint = getString(R.string.all)
            binding.speedHint.text = ""
            binding.seasonHint.hint = getString(R.string.all)
            binding.supplierHint.text.clear()
            binding.atdPartNumberHint.text.clear()
            binding.supplierHint.hint = getString(R.string.enter_supplier_number)
            binding.atdPartNumberHint.hint = getString(R.string.enter_part_numbner)
            binding.viewDivider4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dusty_gray))
            binding.viewDivider5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dusty_gray))
            binding.viewDivider6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dusty_gray))
            binding.prodBrandDropMenu.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            binding.speedDropMenu.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
            binding.seasonalMenu.setColorFilter(ContextCompat.getColor(requireContext(),R.color.dusty_gray))
                //clearing selected brands
            mainViewModel.clearLiveDataForBrands()

        }
    }

    private fun callSeasonalDesgDrop() {
        SeasonalDesignationFragment().show(requireActivity().supportFragmentManager, SeasonalDesignationFragment.TAG)
    }

    private fun callSpeedRatingDrop() {
        SpeedRatingFragment().show(requireActivity().supportFragmentManager, SpeedRatingFragment.TAG)

    }

    private fun enableSpeedAndSeasonal() {
        binding.speedDropMenu.setColorFilter(ContextCompat.getColor(requireContext(), theameColor))
        binding.viewDivider5.setBackgroundColor(ContextCompat.getColor(requireContext(), theameColor))
        binding.viewDivider6.setBackgroundColor(ContextCompat.getColor(requireContext(), theameColor))
        binding.seasonalMenu.setColorFilter(ContextCompat.getColor(requireContext(), theameColor))
    }

    private fun disableBrand() {
        binding.prodBrandDropMenu.setImageResource(R.drawable.disabled_right_arrow)
        binding.viewDivider4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dusty_gray))
        resetState(false)
        searchState(false)
    }

    private fun enableBrand() {
        binding.prodBrandDropMenu.setColorFilter(ContextCompat.getColor(requireContext(), theameColor))
        binding.viewDivider4.setBackgroundColor(ContextCompat.getColor(requireContext(), theameColor))
    }

    private fun callProdCatDrop() {
        TireTypesFragment().show(requireActivity().supportFragmentManager, TireTypesFragment.TAG)
    }

    private fun createRequestBody() {



        val request = ProductByCriteriaRequest()
        //clearing selected Brands
        mainViewModel.clearLiveDataForBrands()

        //setting up criteria
        val criteria = Criteria()
        if(productgroup?.equals(listOf("")) == false){
            criteria.productgroup = productgroup
        }
        if (size?.equals(listOf("")) == false){
            criteria.size = size
        }
        if (speedrating?.equals(listOf("")) == false){
            criteria.speedrating = speedrating
        }
        if (winterdesignation?.equals(listOf("")) == false){
            criteria.winterdesignation = winterdesignation
        }
        if (brandList?.equals(listOf("")) == false && brandList.isNotEmpty()){
            criteria.brand = brandList
        }
        if (getmfgproductnumber()?.equals(listOf("")) == false){
            criteria.mfgproductnumber = getmfgproductnumber()
        }
        request.criteria = criteria
        tapProdSearchEvent(criteria, SearchType.PRODUCT_SEARCH, "")

        val resultsFragment= KeywordSearchResultsFragment()
        resultsFragment.arguments = Bundle().apply {
            putString(Constants.KEY_TYPE, Constants.KEY_PRODUCT_BY_CRITERIA)
            putString(Constants.CATEGORY_TYPE, Category.Search_Criteria)
            putString(Constants.KEY_PRODUCT_CRITERIA, Gson().toJson(criteria))
        }
        requireActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, resultsFragment,"KeywordSearchResultsFragment")
            .commit()
    }
    private fun tapProdSearchEvent(
        criteria: Criteria,
        searchType: String,
        offsetDesc: String
    ){

        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Search,
            Category.Search_Criteria,
            Action.Click,
            null
        )

        params = addRequestToEventParams(criteria, searchType, params)

        val searchDetails = Common.getAnalyticsSearchCriteria(
            criteria,
            searchType,
            offsetDesc,
            preferredBrandList
        )
        println("Checking searchDetails -> $searchDetails")

        params = Common.convertSearchCriteriaToBundle(searchDetails, params)

        println("Checking update param -> $params")

        firebaseAnalytics.logEvent(
            FirebaseCustomEvents.Search,
            params
        )

    }

    private fun getmfgproductnumber(): List<String>? {
        val mfgNumber = mfgproductnumber
        val atdNumber = atdproductnumber
        return when {
            mfgNumber == null && atdNumber == null -> listOf("") // both null
            mfgNumber != null && mfgNumber.isNotEmpty() && atdNumber != null && atdNumber.isNotEmpty() -> mfgNumber // both not null and not empty
            mfgNumber == null || mfgNumber.isEmpty() -> atdNumber // mfgproductnumber is null or empty
            else -> mfgNumber // atfproductnumber is null or empty
        }
    }

    private fun selectBrands(){
        val tiresBrandFragment = TiresBrandFragment(productgroup?.firstOrNull() //getting first element
            ?.takeIf { it.isNotBlank() }
            ?: getString(R.string.lightTruckTires))
        tiresBrandFragment.show(requireActivity().supportFragmentManager, tiresBrandFragment.tag) //calling TireBrandsFrag
    }

    private fun resetState(state: Boolean) {
        if (state){
            isResetEnabled = true
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset_enabled)
            binding.bottomButtons.ivReset.imageTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        }else{
            isResetEnabled = false
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset)
        }
    }

    private fun searchState(state: Boolean) {
        if (state){
            isSearchEnabled = true
           if (theameColor.equals(R.color.red)){
               binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled_tirepros)
           }else{
               binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled)
           }

        }else{
            isSearchEnabled = false
            binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_disabled)
        }
    }


}
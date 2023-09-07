package com.atd.atdmobileapp.ui.product.wheelaccessories
// WheelAccessoriesFragment
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
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentWheelAccessoriesBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import androidx.lifecycle.Observer
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class WheelAccessoriesFragment : Fragment() {

    private var _binding: FragmentWheelAccessoriesBinding?= null
    private val binding get() = _binding!!
    private var isSearchEnabled = false
    private var isResetEnabled = false
    private var mfgproductnumber: List<String>?= null
    private var atdproductnumber: List<String>?= null
    private var productsubgroup : List<String>?= null
    private var brandList = ArrayList<String>()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var preferredBrandList = listOf<String>()
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWheelAccessoriesBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.wheelAcctvInst.text = getString(R.string.please_use)
        dropDownListenerWheelAccType()
        onClickForWheelAccType()
        onClickBrand()
        onclickReset()
        onClickSubmit()
        editTextWatcherForSupplierNumber()
        editTextWatcherForATDPartNumber()
        dropDownListenerBrand()
        productsubgroup = listOf(getString(R.string.capsLower))
        bindObserver()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()
        themeSetUp()

    }

    private fun themeSetUp() {

        binding.wheelAccviewDivider2.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.wheelAccviewDivider4.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.wheelAccviewDivider7.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.wheelAccviewDivider8.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.bottomButtons.viewDivider9.backgroundTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.wheelAccDropMenu.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.wheelAccBrandDropMenu.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)

    }

    private fun editTextWatcherForATDPartNumber() {
        binding.wheelAccatdPartNumberHint.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!= null){
                    if (s.isNotEmpty()){
                        atdproductnumber = listOf(s.toString())
                        resetState(true)
                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
    private fun editTextWatcherForSupplierNumber() {
        binding.wheelAccsupplierHint.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!= null){
                    if (s.isNotEmpty()){
                        mfgproductnumber = listOf(s.toString())
                        resetState(true)

                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
    private fun onClickForWheelAccType() {
        val viewsToCLick = listOf<View>(binding.wheelAccType, binding.wheelAccviewDivider2, binding.wheelAccDropMenu, binding.tvWheelAccType)
        viewsToCLick.forEach { view ->
            view.setOnClickListener {
                WheelAccessoriesTypeFragment().show(requireActivity().supportFragmentManager, WheelAccessoriesTypeFragment.TAG)
            }
        }
//        binding.wheelAccDropMenu.setOnClickListener {
//            WheelAccessoriesTypeFragment().show(requireActivity().supportFragmentManager, WheelAccessoriesTypeFragment.TAG)
//        }
    }
    private fun onClickBrand(){
        val viewsToCLick = listOf<View>(binding.wheelAccbrands, binding.wheelAccbrandsHint, binding.wheelAccviewDivider4, binding.wheelAccBrandDropMenu)
        viewsToCLick.forEach { view ->
            view.setOnClickListener {
                selectBrands()
                resetState(true)
            }
        }
        //onClickForBrand
//        binding.wheelAccBrandDropMenu.setOnClickListener {
//            selectBrands()
////                searchState(true)
//            resetState(true)
//        }
    }
    private fun onclickReset(){
        binding.bottomButtons.ivReset.setOnClickListener {
            onReset()
        }
    }
    private fun onClickSubmit(){
        binding.bottomButtons.ivSearch.setOnClickListener {
            if (isSearchEnabled){
                makeRequest()
            }
        }
    }
    private fun makeRequest() {

        val request = ProductByCriteriaRequest()

        //clearing selected Brands
        mainViewModel.clearLiveDataForBrands()

        //setting up criteria
        val criteria = Criteria()

        criteria.productgroup = listOf(Constants.WHEEL_ACC_PRODUCT_GROUP)
        if (productsubgroup?.equals((listOf("")))==false){
            criteria.productsubgroup = productsubgroup
        }
        if (brandList != (listOf("")) && brandList.isNotEmpty()){
            criteria.brand = brandList
        }
        if (getmfgproductnumber()?.equals(listOf("")) == false){
            criteria.mfgproductnumber = getmfgproductnumber()
        }
        request.criteria = criteria
        //calling product event
        tapProdSearchEvent(criteria, SearchType.PRODUCT_SEARCH, "")
        val resultsFragment= KeywordSearchResultsFragment()
        resultsFragment.arguments = Bundle().apply {
            putString(Constants.KEY_TYPE, Constants.KEY_PRODUCT_BY_CRITERIA_WHEEL_ACCESSORIES)
            putString(Constants.KEY_PRODUCT_CRITERIA_WHEEL_ACCESSORIES, Gson().toJson(criteria))
            putString(Constants.CATEGORY_TYPE, Category.Search_Criteria)
        }
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, resultsFragment)
            .commit()

    }
    private fun selectBrands() {
        val tiresBrandFragment = TiresBrandFragment(getString(R.string.wheel_accessories))
//        tiresBrandFragment.setProductType(getString(R.string.wheel_accessories))
        tiresBrandFragment.show(requireActivity().supportFragmentManager, tiresBrandFragment.tag) //calling TireBrandsFrag
    }
    private fun dropDownListenerWheelAccType(){
        parentFragmentManager.setFragmentResultListener(Constants.WHEEL_ACC_TYPE, this){_, result ->
            val wheelAccType = result.getString(Constants.WHEEL_ACC_TYPE_KEY)
            println("Got in main frag $wheelAccType")
            binding.wheelAccType.text = wheelAccType
            binding.wheelAccType.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            if (wheelAccType != null) {
                isResetEnabled = true
                resetState(true)
                when(wheelAccType){
                    getString(R.string.capsUpper) -> {
                        productsubgroup = listOf(getString(R.string.capsLower))
                    }

                    getString(R.string.hubcentricRings) -> {
                        productsubgroup = listOf(getString(R.string.hubcentricRingsLower))
                    }

                    getString(R.string.hubCoverLocks) -> {
                        productsubgroup = listOf(getString(R.string.hubCoverLocksLower))
                    }

                    getString(R.string.installKits) -> {
                        productsubgroup = listOf(getString(R.string.installKitsLower))
                    }

                    getString(R.string.lugBolts) -> {
                        productsubgroup = listOf(getString(R.string.lugBoltsLower))
                    }

                    getString(R.string.lugNuts) -> {
                        productsubgroup = listOf(getString(R.string.lugNutsLower))
                    }
                    getString(R.string.toolsAndSockets) ->{
                        productsubgroup = listOf(getString(R.string.toolsAndSocketsLower))
                    }
                    getString(R.string.wheelStuds) -> {
                        productsubgroup = listOf(getString(R.string.wheelStudsLower))
                    }
                    else ->{
                        productsubgroup = listOf(getString(R.string.capsLower))
                    }
                }
            }else{
                productsubgroup = listOf(getString(R.string.capsLower))
            }
        }
    }
    private fun dropDownListenerBrand(){
        parentFragmentManager.setFragmentResultListener(Constants.BRAND_RESULT, this) { _, _ ->
            val selectedPositionsItem = mainViewModel.getSelectedPositionsItem()
            val selectedOtherPositionsItem = mainViewModel.getSelectedOtherPositionsItem()
            brandList = ArrayList((selectedPositionsItem + selectedOtherPositionsItem).toSet())
            val brandsHintText = when {
                brandList.size > 3 -> "${brandList.take(3).joinToString()}, +${brandList.size - 3}${getString(R.string.more)}"
                brandList.isEmpty() -> "All"
                else -> brandList.joinToString()
            }
            with(binding.wheelAccbrandsHint) {
                text = brandsHintText
                hint = if (brandList.isEmpty()) getString(R.string.all) else ""
                setTextColor(if (brandList.isEmpty()) Color.DKGRAY else Color.BLACK)
            }
            searchState(true)
        }
    }
    private fun getmfgproductnumber(): List<String>? {
        val mfgNumber = mfgproductnumber
        val atdNumber = atdproductnumber
        return when {
            mfgNumber == null && atdNumber == null -> listOf("") // both null
            (mfgNumber != null) && mfgNumber.isNotEmpty() && (atdNumber != null) && atdNumber.isNotEmpty() -> mfgNumber // both not null and not empty
            (mfgNumber == null) || mfgNumber.isEmpty() -> atdNumber // mfgproductnumber is null or empty
            else -> mfgNumber // atdproductnumber is null or empty
        }
    }
    private fun resetState(state: Boolean) {
        if (state){
            isResetEnabled = true
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset_enabled)
            binding.bottomButtons.ivReset.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        }else{
            isResetEnabled = false
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset)
        }
    }
    private fun searchState(state: Boolean) {
        if (state){
            isSearchEnabled = true
            if (theameColor==R.color.red) {
                binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled_tirepros)
            } else {
                binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled)
            }
        }else{
            isSearchEnabled = false
            binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_disabled)
        }
    }
    private fun onReset(){
        if (isResetEnabled){
            resetState(false)
            searchState(false)
            binding.wheelAccType.text = getString(R.string.caps)
            binding.wheelAccbrandsHint.text = getString(R.string.all)
            binding.wheelAccsupplierHint.text.clear()
            binding.wheelAccatdPartNumberHint.text.clear()
            binding.wheelAccsupplierHint.hint = getString(R.string.enter_supplier_number)
            binding.wheelAccatdPartNumberHint.hint = getString(R.string.enter_part_numbner)
            //clearing selected brands
            mainViewModel.clearLiveDataForBrands()
        }
    }

    private fun bindObserver() {
        tiresBrandsViewModel.preferredBrandsLiveData.observe(viewLifecycleOwner, Observer {
            preferredBrandList = it.data?.map { it.value }?.toList()!!
        })
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

        params = Common.addRequestToEventParams(criteria, searchType, params)

        val searchDetails = Common.getAnalyticsSearchCriteria(
            criteria,
            searchType,
            offsetDesc,
            preferredBrandList
        )
        params = Common.convertSearchCriteriaToBundle(searchDetails, params)

        firebaseAnalytics.logEvent(
            FirebaseCustomEvents.Search,
            params
        )

    }
}


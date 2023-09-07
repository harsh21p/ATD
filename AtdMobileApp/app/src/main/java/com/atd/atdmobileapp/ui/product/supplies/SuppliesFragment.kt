package com.atd.atdmobileapp.ui.product.supplies

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
import com.atd.atdmobileapp.databinding.FragmentSuppliesBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList
import javax.inject.Inject

@AndroidEntryPoint
class SuppliesFragment : Fragment() {

    private var _binding: FragmentSuppliesBinding? = null
    private val binding get() = _binding!!
    private var isSearchEnabled = false
    private var isResetEnabled = false
    private var mfgproductnumber: List<String>? = null
    private var atdproductnumber: List<String>? = null
    private var productsubgroup: List<String>? = null
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
    ): View? {
        _binding = FragmentSuppliesBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    companion object {
        const val TAG = "SuppliesFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.suppliestvInst.text = getString(R.string.please_use)
        editTextWatcherForSupplierNumber()
        editTextWatcherForATDPartNumber()
        onClickSuppliesType()
        dropDownListenerSuppliesType()
        onClickBrand()
        dropDownListenerBrand()
        onclickReset()
        onClickSubmit()
        bindObserver()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()
        themeSetUp()
    }
    private fun themeSetUp() {

        binding.suppliesviewDivider2.backgroundTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.suppliesviewDivider4.backgroundTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.suppliesviewDivider7.backgroundTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.suppliesviewDivider8.backgroundTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.bottomButtons.viewDivider9.backgroundTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.suppliesDropMenu.imageTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.suppliesBrandDropMenu.imageTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )

    }

    private fun dropDownListenerBrand() {
        parentFragmentManager.setFragmentResultListener(Constants.BRAND_RESULT, this){_, _ ->
            val selectedPositionsItem = mainViewModel.getSelectedPositionsItem()
            val selectedOtherPositionsItem = mainViewModel.getSelectedOtherPositionsItem()
            brandList = ArrayList((selectedPositionsItem + selectedOtherPositionsItem).toSet())
            val brandsHintText = when {
                brandList.size > 3 -> "${brandList.take(3).joinToString()}, +${brandList.size - 3}${getString(R.string.more)}"
                brandList.isEmpty() -> "All"
                else -> brandList.joinToString()
            }
            with(binding.suppliesbrandsHint) {
                text = brandsHintText
                hint = if (brandList.isEmpty()) getString(R.string.all) else ""
                setTextColor(if (brandList.isEmpty()) Color.DKGRAY else Color.BLACK)
            }
            searchState(true)
        }
    }

    private fun dropDownListenerSuppliesType() {
        parentFragmentManager.setFragmentResultListener(
            Constants.SUPPLIES_TYPE,
            this
        ) { _, result ->
            val suppliesType = result.getString(Constants.SUPPLIES_TYPE)
            println("Got Supplies Type as -> $suppliesType")
            binding.suppliesType.text = suppliesType
            binding.suppliesType.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            if (suppliesType != null) {
                isResetEnabled = true
                resetState(true)
                when (suppliesType) {
                    getString(R.string.tmps) -> {
                        productsubgroup = listOf(getString(R.string.tmps_lower))
                    }
                    getString(R.string.wheel_weights) -> {
                        productsubgroup = listOf(getString(R.string.wheel_weights_lower))
                    }
                    else -> {
                        productsubgroup = listOf(getString(R.string.tmps_lower))
                    }
                }
            } else {
                productsubgroup = listOf(getString(R.string.tmps_lower))
            }
        }
    }

    private fun onClickSuppliesType() {
        val viewsToClick = listOf<View>(binding.tvsuppliesType, binding.suppliesType, binding.suppliesviewDivider2, binding.suppliesDropMenu)
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                SuppliesTypeFragment().show(
                    requireActivity().supportFragmentManager,
                    SuppliesTypeFragment.TAG
                )
            }
        }
//        binding.suppliesDropMenu.setOnClickListener {
//            SuppliesTypeFragment().show(
//                requireActivity().supportFragmentManager,
//                SuppliesTypeFragment.TAG
//            )
//        }
    }

    private fun editTextWatcherForATDPartNumber() {
        binding.suppliesatdPartNumberHint.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotEmpty()) {
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
        binding.suppliessupplierHint.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotEmpty()) {
                        mfgproductnumber = listOf(s.toString())
                        resetState(true)

                    }
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun resetState(state: Boolean) {
        if (state) {
            isResetEnabled = true
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset_enabled)
            binding.bottomButtons.ivReset.imageTintList=ContextCompat.getColorStateList(requireContext(),
                BottomNavigationScreenFragment.theameColor
            )
        } else {
            isResetEnabled = false
            binding.bottomButtons.ivReset.setImageResource(R.drawable.product_reset)
        }
    }

    private fun searchState(state: Boolean) {
        if (state) {
            isSearchEnabled = true

            if (BottomNavigationScreenFragment.theameColor ==R.color.red) {
                binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled_tirepros)
            } else {
                binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_enabled)
            }

        } else {
            isSearchEnabled = false
            binding.bottomButtons.ivSearch.setImageResource(R.drawable.product_search_button_disabled)
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

    private fun onClickBrand() {
        val viewsToClick = listOf<View>(binding.suppliesbrands, binding.suppliesbrandsHint, binding.suppliesviewDivider4, binding.suppliesBrandDropMenu)
        viewsToClick.forEach {
            view ->
            view.setOnClickListener {
                selectBrands()
                resetState(true)
            }
        }

//        //onClickForBrand
//        binding.suppliesBrandDropMenu.setOnClickListener {
//            selectBrands()
//            resetState(true)
//        }
    }

    private fun selectBrands() {
        val tiresBrandFragment = TiresBrandFragment(getString(R.string.supplies_lower))
        tiresBrandFragment.show(requireActivity().supportFragmentManager, tiresBrandFragment.tag)
    }

    private fun onclickReset(){
        binding.bottomButtons.ivReset.setOnClickListener {
            onReset()
        }
    }

    private fun onReset() {
        if (isResetEnabled){
            resetState(false)
            searchState(false)
            binding.suppliesType.text = getString(R.string.tmps)
            binding.suppliesbrandsHint.text = getString(R.string.all)
            binding.suppliessupplierHint.text.clear()
            binding.suppliesatdPartNumberHint.text.clear()
            binding.suppliessupplierHint.hint = getString(R.string.enter_supplier_number)
            binding.suppliesatdPartNumberHint.hint = getString(R.string.enter_part_numbner)
            //clearing selected brands
            mainViewModel.clearLiveDataForBrands()
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

        criteria.productgroup = listOf(getString(R.string.supplies_lower))
        criteria.productsubgroup = listOf(getString(R.string.tmps_lower))
        if (productsubgroup?.equals((listOf("")))==false){
            criteria.productsubgroup = productsubgroup
        }
        if (brandList != (listOf("")) && brandList.isNotEmpty()){
            criteria.brand = brandList
        }
        println("brandList $brandList")
        if (getmfgproductnumber()?.equals(listOf("")) == false){
            criteria.mfgproductnumber = getmfgproductnumber()
        }
        request.criteria = criteria
        //calling Event
        tapProdSearchEvent(criteria, SearchType.PRODUCT_SEARCH, "")

        val resultsFragment= KeywordSearchResultsFragment()
        resultsFragment.arguments = Bundle().apply {
            putString(Constants.KEY_TYPE, Constants.KEY_PRODUCT_BY_CRITERIA_SUPPLIES)
            putString(Constants.KEY_PRODUCT_CRITERIA_SUPPLIES, Gson().toJson(criteria))
            putString(Constants.CATEGORY_TYPE, Category.Search_Criteria)
        }
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, resultsFragment)
            .commit()

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
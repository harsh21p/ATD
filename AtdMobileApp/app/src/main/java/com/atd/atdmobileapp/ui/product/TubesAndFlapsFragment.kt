package com.atd.atdmobileapp.ui.product

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentTubesAndFlapsBinding
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
class TubesAndFlapsFragment : Fragment() {

    private var _binding: FragmentTubesAndFlapsBinding?= null
    private val binding get() = _binding!!
    private var isSearchEnabled = false
    private var isResetEnabled = false
    private var mfgproductnumber: List<String>? = null
    private var atdproductnumber: List<String>? = null
    private var style: List<String>? = null
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
        _binding = FragmentTubesAndFlapsBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    companion object {
        const val TAG = "TubesAndFlapsFragment "
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tubesAndFlapstvInst.text = getString(R.string.please_use)
        editTextWatcherForSupplierNumber()
        editTextWatcherForATDPartNumber()
        onClickBrand()
        dropDownListenerBrand()
        onclickReset()
        onRadioButtonStateChange()
        onClickSubmit()
        bindObserver()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()
        themeSetUp()
    }

    private fun onRadioButtonStateChange() {
        binding.tubesAndFlapsTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = binding.tubesAndFlapsTypeRadioGroup.findViewById<RadioButton>(checkedId)
            val buttonText = radioButton.text.toString()
            style = listOf(buttonText.lowercase())
        }
    }

    private fun dropDownListenerBrand() {
        parentFragmentManager.setFragmentResultListener(Constants.BRAND_RESULT, this){ _, _ ->
            val selectedPositionsItem = mainViewModel.getSelectedPositionsItem()
            val selectedOtherPositionsItem = mainViewModel.getSelectedOtherPositionsItem()
            brandList = ArrayList((selectedPositionsItem + selectedOtherPositionsItem).toSet())
            val brandsHintText = when {
                brandList.size > 3 -> "${brandList.take(3).joinToString()}, +${brandList.size - 3}${getString(R.string.more)}"
                brandList.isEmpty() -> "All"
                else -> brandList.joinToString()
            }
            with(binding.tubesAndFlapsbrandsHint) {
                text = brandsHintText
                hint = if (brandList.isEmpty()) getString(R.string.all) else ""
                setTextColor(if (brandList.isEmpty()) android.graphics.Color.DKGRAY else android.graphics.Color.BLACK)
            }
            searchState(true)
        }    }

    private fun editTextWatcherForATDPartNumber() {
        binding.tubesAndFlapsatdPartNumberHint.addTextChangedListener(object : TextWatcher {
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
        binding.tubesAndFlapssupplierHint.addTextChangedListener(object : TextWatcher {
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
                BottomNavigationScreenFragment.theameColor)
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
        val viewsToClick = listOf<View>(binding.tubesAndFlapsbrands, binding.tubesAndFlapsbrandsHint, binding.tubesAndFlapsviewDivider4, binding.tubesAndFlapsBrandDropMenu)
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                selectBrands()
                resetState(true)
            }
        }
        //onClickForBrand
//        binding.tubesAndFlapsBrandDropMenu.setOnClickListener {
//            selectBrands()
//            resetState(true)
//        }
    }

    private fun selectBrands() {
        val tiresBrandFragment = TiresBrandFragment(getString(R.string.tubesAndFlaps))
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
            binding.radioButton.isChecked = true
            binding.tubesAndFlapsbrandsHint.text = getString(R.string.all)
            binding.tubesAndFlapssupplierHint.text.clear()
            binding.tubesAndFlapsatdPartNumberHint.text.clear()
            binding.tubesAndFlapssupplierHint.hint = getString(R.string.enter_supplier_number)
            binding.tubesAndFlapsatdPartNumberHint.hint = getString(R.string.enter_part_numbner)
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

        criteria.productgroup = listOf(getString(R.string.tubesAndFlaps))
        if (style?.firstOrNull() != getString(R.string.both).lowercase()){
            criteria.style = style
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
            putString(Constants.KEY_TYPE, Constants.KEY_PRODUCT_BY_CRITERIA_TUBES_AND_FLAPS)
            putString(Constants.KEY_PRODUCT_CRITERIA_TUBES_AND_FLAPS, Gson().toJson(criteria))
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

    private fun themeSetUp() {

        binding.tubesAndFlapsviewDivider4.backgroundTintList= ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.tubesAndFlapsviewDivider7.backgroundTintList= ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.tubesAndFlapsviewDivider8.backgroundTintList= ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )

        binding.bottomButtons.viewDivider9.backgroundTintList= ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.tubesAndFlapsBrandDropMenu.imageTintList= ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
            binding.radioButton.buttonTintList= ContextCompat.getColorStateList(requireActivity(),
                BottomNavigationScreenFragment.theameColor
            )
            binding.radioButton2.buttonTintList= ContextCompat.getColorStateList(requireActivity(),
                BottomNavigationScreenFragment.theameColor
            )
        binding.radioButton3.buttonTintList= ContextCompat.getColorStateList(requireActivity(),
            BottomNavigationScreenFragment.theameColor
        )


    }

}
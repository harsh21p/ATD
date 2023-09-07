package com.atd.atdmobileapp.ui.product.tirerepair

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentTireRepairBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TireRepairFragment : Fragment() {

    private var brandList: ArrayList<String>?=null
    var _binding : FragmentTireRepairBinding?=null
    val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var preferredBrandList = listOf<String>()
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()
    companion object {
        fun newInstance() = TireRepairFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding= FragmentTireRepairBinding.inflate(inflater,container,false)
       var view:View= _binding!!.root
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.tireRepairFooter.btReset.setOnClickListener {
            binding.brandType.text=requireActivity().resources.getString(R.string.all)
            binding.etSupplierNumber.setText("")
            binding.etAtdPartNumber.setText("")
        }

        setUpTheme()
        bindObserver()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()

        binding.brandType.setOnClickListener {
            TiresBrandFragment(Constants.TIRE_REPAIR).show(requireActivity().supportFragmentManager, TiresBrandFragment.TAG)
        }
        binding.etSupplierNumber.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                s.toString().isNotEmpty().let {

                    if (it) {
                        searchEnable()
                    }else{
                        searchDisable()
                    }

                }
            }


        })

        binding.etAtdPartNumber.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                s.toString().isNotEmpty().let {

                    if (it) {
                        searchEnable()
                    }else{
                        searchDisable()
                    }

                }
            }
        })

        binding.tireRepairFooter.tvProductSearch.setOnClickListener {


            val criteria = Criteria()
            criteria.productgroup= listOf(Constants.TIRE_REPAIR)
            criteria.brand= brandList?.let { it1 -> listToLowerCase(it1) }
            //criteria.mfgproductnumber=getMfgProductNumber()

            tapProdSearchEvent(criteria, SearchType.PRODUCT_SEARCH, "")
            val result : String = Gson().toJson(criteria)
            val bundle = Bundle()
            bundle. putString(Constants.KEY_TYPE, Constants.TIRE_REPAIR)
            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Criteria)
            bundle.putString(Constants.TIRE_REPAIR, result)
            val resultsFragment= KeywordSearchResultsFragment()
            resultsFragment.arguments=bundle
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, resultsFragment)
                .addToBackStack("TireRepairFragment")
                .commit()

        }


        return view
    }

    private fun setUpTheme() {
        
            binding.brandType.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
            binding.ivBrandType.backgroundTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
            binding.etSupplierNumber.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
            binding.etAtdPartNumber.compoundDrawableTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
            binding.tireRepairFooter.viewDivider.backgroundTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
        
    }

    private fun bindObserver() {
        tiresBrandsViewModel.preferredBrandsLiveData.observe(viewLifecycleOwner, Observer {
            preferredBrandList = it.data?.map { it.value }?.toList()!!
        })
    }

    private fun listToLowerCase(names: List<String>): List<String> {
        return names.map { it.lowercase() }
    }

    private fun getMfgProductNumber(): List<String> {
        val mfgNumber = binding.etSupplierNumber.text.toString().lowercase()
        val atdNumber = binding.etAtdPartNumber.text.toString().lowercase()
        return when {
            mfgNumber.isEmpty() && atdNumber.isEmpty() -> listOf("") // both null
            mfgNumber.isNotEmpty() && atdNumber.isNotEmpty() -> listOf(mfgNumber) // both not null and not empty
            mfgNumber.isEmpty() -> listOf(atdNumber)
            else -> listOf(mfgNumber)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(Constants.BRAND_RESULT, this) { _, result ->
            val allBrands = ArrayList<String>()
            val list1 = mainViewModel.getSelectedPositionsItem()
            list1.let { allBrands.addAll(it) }
            val list2 = mainViewModel.getSelectedOtherPositionsItem()
            list2.let { allBrands.addAll(it) }
            //got both list of preferred and other brand, merged them together and send it in request
            brandList = ArrayList<String>(LinkedHashSet<String>(allBrands))
            val selectedBrand = when {
                //displaying only first 3 added brands and showing +n after that
                brandList?.size == 0 ->{
                    brandList?.joinToString(prefix = requireActivity().resources.getString(R.string.all))

                }
                brandList?.size!! > 3 -> {
                    "${brandList!![0]}, ${brandList!![1]}, ${brandList!![2]} ${getString(R.string.plus)}${brandList!!.size - 3}${getString(R.string.more)}"

                }
                else -> {
                    brandList?.joinToString(separator = ", ")

                }
            }

            binding.brandType.text = selectedBrand

            if (!binding.brandType.text.equals(requireActivity().resources.getString(R.string.all))){
                searchEnable()
            }else{
                searchDisable()
            }
            //binding.brandsHint.setTextColor(Color.BLACK)
        }



    }

    private fun searchEnable() {

        binding.tireRepairFooter.btReset.isEnabled=true
        binding.tireRepairFooter.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))

        binding.tireRepairFooter.tvProductSearch.isEnabled=true
        binding.tireRepairFooter.tvProductSearch.backgroundTintList=
            ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tireRepairFooter.tvProductSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
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

    private fun searchDisable() {

            if (binding.brandType.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
                binding.etSupplierNumber.text.toString().equals("")&&
                binding.etAtdPartNumber.text.toString().equals(""))
            {
                binding.tireRepairFooter.btReset.isEnabled=false
                binding.tireRepairFooter.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
                binding.tireRepairFooter.tvProductSearch.isEnabled=false
                binding.tireRepairFooter.tvProductSearch.backgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
                binding.tireRepairFooter.tvProductSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.clearLiveDataForBrands()
        _binding=null

    }


}
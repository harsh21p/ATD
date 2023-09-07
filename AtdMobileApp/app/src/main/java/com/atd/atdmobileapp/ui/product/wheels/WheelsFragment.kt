package com.atd.atdmobileapp.ui.product.wheels

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentWheelsBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.ui.product.wheels.wheeltype.SelectWeelTypeDialogFragment
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WheelsFragment : Fragment() {


    private var brandList: ArrayList<String>?=null
    var _binding : FragmentWheelsBinding?=null
    val binding get() = _binding!!
    private var updateViewModel : UpdateViewModel?=null
    private var productGroup: List<String>? = listOf("custom wheels")
    private var wheelDiameter: List<String>? =null
    private var wheelWidth: List<String>? =null
    private var boltPattern: List<String>? =null
    private var atdFinish: List<String>? =null
    private var winterDesignation: List<String>? =null
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var preferredBrandList = listOf<String>()
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()
    companion object {
        fun newInstance() = WheelsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding= FragmentWheelsBinding.inflate(inflater,container,false)
        val view: View = binding.root
        updateViewModel = ViewModelProvider(this).get(UpdateViewModel::class.java)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        bindObserver()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        tiresBrandsViewModel.getPreferredBrandConfigurationList()

        setUpTheme()
        binding.wheelType.setOnClickListener {



            val diameterValueList = binding.wheelType.text.split(",")
            val  list = ArrayList<String>()
            list.addAll(diameterValueList)


            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(
                updateViewModel!!,
                "WheelType",
                list
            )
            newFragment.show(ft, "dialog")
        }

        binding.diameter.setOnClickListener {

            //Common.SelectOption(wheelTypes,requireActivity(), updateViewModel!!)
            val diameterValueList = binding.diameter.text.split(",")
            val  list = ArrayList<String>()
            list.addAll(diameterValueList)
            list.remove(requireActivity().resources.getString(R.string.all))


            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(updateViewModel!!,"Diameter",list)
            newFragment.show(ft, "dialog")

        }
        binding.tvWidth.setOnClickListener {

            //Common.SelectOption(wheelTypes,requireActivity(), updateViewModel!!)
            val diameterValueList = binding.tvWidth.text.split(",")
            val  list = ArrayList<String>()
            list.addAll(diameterValueList)
            list.remove(requireActivity().resources.getString(R.string.all))


            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(updateViewModel!!,"Width",list)
            newFragment.show(ft, "dialog")

        }

        binding.tvLugsBolts.setOnClickListener {

            //Common.SelectOption(wheelTypes,requireActivity(), updateViewModel!!)
            val finishList = binding.tvLugsBolts.text.toString()
            val  list = ArrayList<String>()
            list.add(finishList)
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(
                updateViewModel!!,
                "LugsBoltsCircle",
                list
            )
            newFragment.show(ft, "dialog")
        }

        binding.tvFinish.setOnClickListener {

            //Common.SelectOption(wheelTypes,requireActivity(), updateViewModel!!)
            val finishList = binding.tvFinish.text.split(",")
            val  list = ArrayList<String>()
            list.addAll(finishList)
            list.remove(requireActivity().resources.getString(R.string.all))
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(
                updateViewModel!!,
                "Finish",
                list
            )
            newFragment.show(ft, "dialog")
        }

        binding.tvOffSetDescription.setOnClickListener {



            val diameterValueList = binding.tvOffSetDescription.text.split(",")
            val  list = ArrayList<String>()
            list.addAll(diameterValueList)


            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(
                updateViewModel!!,
                "offsetDescription",
                list
            )
            newFragment.show(ft, "dialog")
        }

        binding.tvSeasonalDesignation.setOnClickListener {

            val finishList = binding.tvSeasonalDesignation.text.toString()
            val  list = ArrayList<String>()
            list.add(finishList)
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val newFragment: DialogFragment = SelectWeelTypeDialogFragment(
                updateViewModel!!,
                "seasonalDesignation",
                list
            )
            newFragment.show(ft, "dialog")
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

       
        binding.wheelsFooter.btReset.setOnClickListener {
            mainViewModel.clearLiveDataForBrands()
            binding.wheelType.text=requireActivity().resources.getString(R.string.custom_wheel)
            binding.brandType.text=requireActivity().resources.getString(R.string.all)
            binding.diameter.text=requireActivity().resources.getString(R.string.all)
            binding.tvWidth.text=requireActivity().resources.getString(R.string.all)
            binding.tvLugsBolts.text=requireActivity().resources.getString(R.string.all)
            binding.tvFinish.text=requireActivity().resources.getString(R.string.all)
            binding.tvOffSetDescription.text=requireActivity().resources.getString(R.string.all)
            binding.tvSeasonalDesignation.text=requireActivity().resources.getString(R.string.all)
            binding.etSupplierNumber.setText("")
            binding.etAtdPartNumber.setText("")

            binding.tvWidth.isEnabled=false
            binding.tvWidthLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightgreay))
            binding.ivWidthIndecator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)
            binding.tvWidth.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)

            binding.tvFinish.isEnabled=false
            binding.tvFinishLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightgreay))
            binding.ivFinishIndicator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)
            binding.tvFinish.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)

        }

        binding.wheelsFooter.tvProductSearch.setOnClickListener {


            val criteria = Criteria()
            criteria.productgroup=productGroup
            criteria.brand= brandList?.let { it1 -> listToLowerCase(it1) }
            criteria.wheeldiameter=wheelDiameter
            getMfgProductNumber().let {
                if (it.size>0){
                    criteria.mfgproductnumber=getMfgProductNumber()
                }
            }
            criteria.wheelwidth=wheelWidth
            criteria.boltpattern=boltPattern
            atdFinish?.let {

                if (it.size >0) {
                    criteria.atdfinish = atdFinish
                }
            }

            criteria.winterdesignation=winterDesignation

            //calling product event
            tapProdSearchEvent(criteria, SearchType.PRODUCT_SEARCH, "")

            val result : String = Gson().toJson(criteria)
            val bundle = Bundle()
            bundle. putString(Constants.KEY_TYPE, Constants.WHEEL)
            bundle.putString(Constants.WHEEL, result)
            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Criteria)
            val resultsFragment= KeywordSearchResultsFragment()
            resultsFragment.arguments=bundle
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, resultsFragment)
                .addToBackStack("WheelsFragment")
                .commit()

        }

        binding.brandType.setOnClickListener {

            TiresBrandFragment(binding.wheelType.text.toString()).show(requireActivity().supportFragmentManager, TiresBrandFragment.TAG)

        }


        return view
    }

    private fun setUpTheme() {
        binding.wheelType.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivWheelType.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.brandType.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivBrandType.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.diameter.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivDiameter.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvLugsBolts.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivLugsBolts.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.etSupplierNumber.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.etAtdPartNumber.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvOffSetDescription.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivOffSetDescription.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvSeasonalDesignation.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivSeasonalDesignation.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)

    }


    private fun searchEnable() {

        binding.wheelsFooter.btReset.isEnabled=true
        binding.wheelsFooter.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))

        binding.wheelsFooter.tvProductSearch.isEnabled=true
        binding.wheelsFooter.tvProductSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.wheelsFooter.tvProductSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
    }

    private fun searchDisable() {

        if (
            binding.wheelType.text.toString().equals(requireActivity().resources.getString(R.string.custom_wheel))&&
            binding.brandType.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.diameter.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.tvWidth.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.tvLugsBolts.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.tvFinish.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.tvOffSetDescription.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.tvSeasonalDesignation.text.toString().equals(requireActivity().resources.getString(R.string.all))&&
            binding.etSupplierNumber.text.toString().equals("")&&
            binding.etAtdPartNumber.text.toString().equals("")
        ) {
            binding.wheelsFooter.btReset.isEnabled = false
            binding.wheelsFooter.btReset.setTextColor(
                ContextCompat.getColorStateList(
                    requireActivity(),
                    R.color.disableText
                )
            )

            binding.wheelsFooter.tvProductSearch.isEnabled = false
            binding.wheelsFooter.tvProductSearch.backgroundTintList =
                ContextCompat.getColorStateList(requireActivity(), R.color.disable_background)
            binding.wheelsFooter.tvProductSearch.setTextColor(
                ContextCompat.getColorStateList(
                    requireActivity(),
                    R.color.disableText
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateViewModel?.wheelType?.observe(viewLifecycleOwner, {

            binding.wheelType.text=it
            productGroup= listOf(it.lowercase())
        })

        updateViewModel?.getDiametre()?.observe(viewLifecycleOwner, {

            if (it.size>0) {
                wheelDiameter=it
                binding.diameter.text = it.joinToString().trim().replace(" ","")
                binding.tvWidth.isEnabled=true
                binding.tvWidthLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.textview_label))
                binding.ivWidthIndecator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
                binding.tvWidth.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
                searchEnable()
            }else{
                binding.diameter.text=requireActivity().resources.getString(R.string.all)
                binding.tvWidth.isEnabled=false
                binding.tvWidthLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightgreay))
                binding.ivWidthIndecator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)
                binding.tvWidth.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)

            }
        })

        updateViewModel?.diameterWidth?.observe(viewLifecycleOwner, {

            if (it.size>0) {
                wheelWidth=it
                binding.tvWidth.text = it.joinToString().trim().replace(" ","")
            }else{
                binding.tvWidth.text=requireActivity().resources.getString(R.string.all)
            }
        })

        updateViewModel?.lugsBoltsCircle?.observe(viewLifecycleOwner, {

            if (it.trim().isNotEmpty()) {

                boltPattern= listOf(it.lowercase())
                binding.tvLugsBolts.text = it.trim().replace(" ","")
                binding.tvFinish.isEnabled=true
                binding.tvFinishLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.textview_label))
                binding.ivFinishIndicator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
                binding.tvFinish.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)

                searchEnable()
            }else{
                binding.tvLugsBolts.text=requireActivity().resources.getString(R.string.all)
                binding.tvFinish.isEnabled=false
                binding.tvFinishLabel.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightgreay))
                binding.ivFinishIndicator.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)
                binding.tvFinish.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.lightgreay)

            }

        })


        updateViewModel?.wheelFinish?.observe(viewLifecycleOwner, {

            if (it.size>0) {
                atdFinish= listToLowerCase(it)
                binding.tvFinish.text = it.joinToString().trim().replace(" ","")
            }else{
                binding.tvFinish.text=requireActivity().resources.getString(R.string.all)
            }
        })

        updateViewModel?.offsetDescription?.observe(viewLifecycleOwner, {

            if (it.isNotEmpty()) {
                binding.tvOffSetDescription.text = it
            }else{
                binding.tvOffSetDescription.text=requireActivity().resources.getString(R.string.all)
            }
        })
        updateViewModel?.seasonalDesignation?.observe(viewLifecycleOwner, {

            if (it.isNotEmpty()) {
                winterDesignation= listOf(it.lowercase())
                binding.tvSeasonalDesignation.text = it
            }else{
                binding.tvSeasonalDesignation.text=requireActivity().resources.getString(R.string.all)
            }
        })

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

            searchEnable()

            //binding.brandsHint.setTextColor(Color.BLACK)
        }

    }

    private fun listToLowerCase(names: List<String>): List<String> {
        return names.map { it.lowercase() }
    }

    private fun getMfgProductNumber(): List<String> {
        val mfgNumber = binding.etSupplierNumber.text.toString().lowercase()
        val atdNumber = binding.etAtdPartNumber.text.toString().lowercase()
        return when {
            mfgNumber.isEmpty() && atdNumber.isEmpty() -> listOf() // both null
            mfgNumber.isNotEmpty() && atdNumber.isNotEmpty() -> listOf(mfgNumber) // both not null and not empty
            mfgNumber.isEmpty() -> listOf(atdNumber)
            else -> listOf(mfgNumber)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.clearLiveDataForBrands()
        _binding=null

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
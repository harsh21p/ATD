package com.atd.atdmobileapp.ui.keywordsearch.filterandsort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentFilterBinding
import com.atd.atdmobileapp.models.keywordsearch.AvailabilityX
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.productsearch.FilterItem
import com.atd.atdmobileapp.models.productsearch.FilterOptions
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import com.google.gson.Gson
import kotlin.reflect.*

class FilterFragment(private val productList: List<Product>) : DialogFragment() {

    private var _binding: FragmentFilterBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: FilterAdapter
    private lateinit var updatedVersionOfFilterOptions: FilterOptions
    private var type:String = ""
    private lateinit var mainViewModel: MainViewModel
    private lateinit var filterOptions: FilterOptions
    private var listOfFilteredProducts: MutableList<Product> = mutableListOf()
    private var productByKeywordResponse: ProductByKeywordResponse = ProductByKeywordResponse(emptyList())
    private var isClearAllActive: Boolean = false
    private var totalCount:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentFilterBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    companion object {
    const val TAG = "filterFrag"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterOptions = mainViewModel.getFilterOptions()
        updatedVersionOfFilterOptions = filterOptions
        type = getString(R.string.availability)
        adapter = FilterAdapter(type, ::onItemClick, requireActivity())
        setupFilterView()

        expandAndCollapseRecyclerView()
        setupRecyclerViews()
        onClickApply()
        onClickClearAll()

        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun onClickClearAll() {
        binding.tvClearAll.setOnClickListener {
            isClearAllActive = true
            closeAllOtherView()
            updatedVersionOfFilterOptions = mainViewModel.getFilterOptions()
            setAllSelectedToFalse(updatedVersionOfFilterOptions)
            mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
        }
    }


    private fun setAllSelectedToFalse(filterOptions: FilterOptions){
        filterOptions.Availability?.forEach { it.isSelected = false }
        filterOptions.Availability?.forEach {
            if (it.name.equals("All", true)){
                it.isSelected = true
            }
        }
        filterOptions.Size?.forEach { it.isSelected = false }
        filterOptions.PreferredBrands?.forEach { it.isSelected = false }
        filterOptions.Brands?.forEach { it.isSelected = false }
        filterOptions.Style?.forEach { it.isSelected = false }
        filterOptions.SpeedRating?.forEach { it.isSelected = false }
        filterOptions.MileageWarranty?.forEach { it.isSelected = false }
        filterOptions.SeasonalDesignation?.forEach { it.isSelected = false }
        filterOptions.RunFlat?.forEach { it.isSelected = false }
        filterOptions.MarketingPrograms?.forEach { it.isSelected = false }
        filterOptions.Rebates?.forEach { it.isSelected = false }
        filterOptions.WheelWidth?.forEach { it.isSelected = false }
        filterOptions.WheelDiameter?.forEach { it.isSelected = false }
        filterOptions.BoltPattern?.forEach { it.isSelected = false }
        filterOptions.ATDFinish?.forEach { it.isSelected = false }
        filterOptions.OffsetDescription?.forEach { it.isSelected = false }

        makeNoOfSelectionsInvisible()
    }

    private fun onClickApply() {
        binding.filterApply.setOnClickListener {
            if (isClearAllActive){
                listOfFilteredProducts = productList as MutableList<Product>
                setResult()
            }else{
                filterProducts()
                setResult()
            }
            isClearAllActive = false
        }
    }

    private fun setResult() {
        productByKeywordResponse.products = listOfFilteredProducts.distinctBy { it.atdproductnumber } //sending only distinct products
        val result = Bundle().apply {
            putString(Constants.FILTER_RESULT,Gson().toJson(productByKeywordResponse))
            putString(Constants.FILTER_COUNT, totalCount.toString())
        }
        setFragmentResult(Constants.FILTER_RESULT, result)
        dialog?.dismiss()
    }

    private fun filterProducts() {

        var filteredProductsAvailability: List<Product> = listOf()
        val filteredProductsSize: MutableList<Product> = mutableListOf()
        val filteredProductsPreferredBrand: MutableList<Product> = mutableListOf()
        val filteredProductsOtherBrand: MutableList<Product> = mutableListOf()
        val filteredProductsStyle: MutableList<Product> = mutableListOf()
        val filteredProductsSpeedRating: MutableList<Product> = mutableListOf()
        val filteredProductsMileageWarranty: MutableList<Product> = mutableListOf()
        val filteredProductsSeasoanalDesignation: MutableList<Product> = mutableListOf()
        val filteredProductsRunFlat: MutableList<Product> = mutableListOf()
        val filteredProductsMarketingPrograms: MutableList<Product> = mutableListOf()
        val filteredProductsRebates: MutableList<Product> = mutableListOf()
        val filteredWheelDiameter: MutableList<Product> = mutableListOf()
        val filteredWheelWidth: MutableList<Product> = mutableListOf()
        val filteredProductsBoltPattern: MutableList<Product> = mutableListOf()
        val filteredProductsATDFinish: MutableList<Product> = mutableListOf()
        val filteredProductsOffsetDescription: MutableList<Product> = mutableListOf()

        val filterOptions: FilterOptions = mainViewModel.getFilterOptions()

        //filter Product based on selected availability
        if (filterOptions.Availability?.isNotEmpty() == true)   {
            var selectedAvailability = ""
            filterOptions.Availability?.forEach{availability ->
                if (availability.isSelected == true){
                    totalCount += 1
                    selectedAvailability = availability.name.toString()
                }
            }
            filteredProductsAvailability = when (selectedAvailability?.lowercase()) {
                "local" -> productList.filter { availabilityMatchesProduct(it.availability, "local") }
                "local+" -> productList.filter { availabilityMatchesProduct(it.availability, "local+") }
                "national" -> productList.filter { availabilityMatchesProduct(it.availability, "national")
                }
                "all" -> productList
                else -> emptyList()
            }
            println("based on avail ->${filteredProductsAvailability.size}")
        }

        //filter Product based on selected size
        if (filterOptions.Size?.isNotEmpty() == true){
            val selectedSizes: MutableList<String> = mutableListOf()
            filterOptions.Size?.forEach { size->
                if (size?.isSelected == true){
                    totalCount += 1
                    selectedSizes.add(size.name.toString())
                }
            }
            for (product in productList) {
                val lowercaseSize = product.productspec.size?.lowercase()
                if (lowercaseSize != null && selectedSizes.contains(lowercaseSize)) {
                    filteredProductsSize.add(product)
                }
            }
            println("Filtered by size ${filteredProductsSize.size}")

        }

        //filter Product based on selected preferred brands
        if (filterOptions.PreferredBrands?.isNotEmpty() == true){
            val selectedPreferredBrands: MutableList<String> = mutableListOf()
            filterOptions.PreferredBrands?.forEach { pb ->
                if (pb.isSelected == true){
                    totalCount += 1
                    selectedPreferredBrands.add(pb.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercasePB = product.brand?.lowercase()
                if (lowercasePB != null && selectedPreferredBrands.contains(lowercasePB)) {
                    filteredProductsPreferredBrand.add(product)
                }
            }
        }

        //filter Product based on selected Other brands
        if (filterOptions.Brands?.isNotEmpty() == true){
            val selectedOtherBrands: MutableList<String> = mutableListOf()
            filterOptions.Brands?.forEach { brand->
                if (brand.isSelected == true){
                    totalCount += 1
                    selectedOtherBrands.add(brand.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseBrand = product.brand?.lowercase()
                if (lowercaseBrand != null && selectedOtherBrands.contains(lowercaseBrand)) {
                    filteredProductsOtherBrand.add(product)
                }
            }
        }

        //filter Product based on selected style
        if (filterOptions.Style?.isNotEmpty() == true){
            val selectedStyle: MutableList<String> = mutableListOf()
            filterOptions.Style?.forEach { style->
                if (style.isSelected == true){
                    totalCount += 1
                    selectedStyle.add(style.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseStyle = product.style?.lowercase()
                if (lowercaseStyle != null && selectedStyle.contains(lowercaseStyle)) {
                    filteredProductsStyle.add(product)
                }
            }
        }

        //filter Product based on speed rating
        if (filterOptions.SpeedRating?.isNotEmpty() == true){
            val selectedSR: MutableList<String> = mutableListOf()
            filterOptions.SpeedRating?.forEach { sr->
                if (sr.isSelected == true){
                    totalCount += 1
                    selectedSR.add(sr.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseSR = product.productspec.speedrating?.lowercase()
                if (lowercaseSR != null && selectedSR.contains(lowercaseSR)) {
                    filteredProductsSpeedRating.add(product)
                }
            }
        }

        //filter Product based on mileage warranty
        if (filterOptions.MileageWarranty?.isNotEmpty() == true){
            val selectedMW: MutableList<String> = mutableListOf()
            filterOptions.MileageWarranty?.forEach { mw->
                if (mw.isSelected == true){
                    totalCount += 1
                    selectedMW.add(mw.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseMW = product.productspec.mileagewarranty?.lowercase()
                if (lowercaseMW != null && selectedMW.contains(lowercaseMW)) {
                    filteredProductsMileageWarranty.add(product)
                }
            }
        }

        //filter Product based on seasonal designation
        if (filterOptions.SeasonalDesignation?.isNotEmpty() == true){
            val selectedSD: MutableList<String> = mutableListOf()
            filterOptions.SeasonalDesignation?.forEach { sd->
                if (sd.isSelected == true){
                    totalCount += 1
                    selectedSD.add(sd.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseSD = product.productspec.winterdesignation?.lowercase()
                if (lowercaseSD != null && selectedSD.contains(lowercaseSD)) {
                    filteredProductsSeasoanalDesignation.add(product)
                }
            }
        }

        //filter Product based on run flat
        if (filterOptions.RunFlat?.isNotEmpty() == true){
            val selectedRF: MutableList<String> = mutableListOf()
            filterOptions.RunFlat?.forEach { rf->
                if (rf.isSelected == true){
                    totalCount += 1
                    selectedRF.add(rf.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseSD = product.productspec.runflat?.lowercase()
                if (lowercaseSD != null && selectedRF.contains(lowercaseSD)) {
                    filteredProductsRunFlat.add(product)
                }
            }
        }

        //filter Product based on marketing programs
        if (filterOptions.MarketingPrograms?.isNotEmpty() == true){
            val selectedMP: MutableList<String> = mutableListOf()
            filterOptions.MarketingPrograms?.forEach { mp->
                if (mp.isSelected == true){
                    totalCount += 1
                    selectedMP.add(mp.name.toString().lowercase())
                }
            }
            for (product in productList) {
                product.marketingprograms.forEach { mp ->
                    if (selectedMP.contains(mp.name.lowercase())){
                        filteredProductsMarketingPrograms.add(product)
                    }
                }
            }
        }

        //filter Product based on rebates
        if (filterOptions.Rebates?.isNotEmpty() == true){
            val selectedR: MutableList<String> = mutableListOf()
            filterOptions.Rebates?.forEach { r->
                if (r.isSelected == true){
                    totalCount += 1
                    selectedR.add(r.name.toString().lowercase())
                }
            }
            for (product in productList) {
                product.rebates.forEach { r ->
                    if (selectedR.contains(r.code.lowercase())){
                        filteredProductsRebates.add(product)
                    }
                }
            }
        }

        //filter Product based on wheel diameter
        if (filterOptions.WheelDiameter?.isNotEmpty() == true){
            val selectedWD: MutableList<String> = mutableListOf()
            filterOptions.WheelDiameter?.forEach { wd->
                if (wd.isSelected == true){
                    totalCount += 1
                    selectedWD.add(wd.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseWD = product.productspec.wheeldiameter?.lowercase()
                if (lowercaseWD != null && selectedWD.contains(lowercaseWD)) {
                    filteredWheelDiameter.add(product)
                }
            }
        }

        //filter Product based on wheel width
        if (filterOptions.WheelWidth?.isNotEmpty() == true){
            val selectedWD: MutableList<String> = mutableListOf()
            filterOptions.WheelWidth?.forEach { wd->
                if (wd.isSelected == true){
                    totalCount += 1
                    selectedWD.add(wd.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseWD = product.productspec.wheelwidth?.lowercase()
                if (lowercaseWD != null && selectedWD.contains(lowercaseWD)) {
                    filteredWheelWidth.add(product)
                }
            }
        }

        //filter Product based on bolt pattern
        if (filterOptions.BoltPattern?.isNotEmpty() == true){
            val selectedBP: MutableList<String> = mutableListOf()
            filterOptions.BoltPattern?.forEach { bp->
                if (bp.isSelected == true){
                    totalCount += 1
                    selectedBP.add(bp.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseBP = product.productspec.boltpattern1?.lowercase()
                if (lowercaseBP != null && selectedBP.contains(lowercaseBP)) {
                    filteredProductsBoltPattern.add(product)
                }
            }
        }

        //filter Product based on atd finish
        if (filterOptions.ATDFinish?.isNotEmpty() == true){
            val selectedAF: MutableList<String> = mutableListOf()
            filterOptions.ATDFinish?.forEach { atdFinish->
                if (atdFinish.isSelected == true){
                    totalCount += 1
                    selectedAF.add(atdFinish.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseBP = product.productspec.atdfinish?.lowercase()
                if (lowercaseBP != null && selectedAF.contains(lowercaseBP)) {
                    filteredProductsATDFinish.add(product)
                }
            }
        }

        //filter Product based on offset description
        if (filterOptions.OffsetDescription?.isNotEmpty() == true){
            val selectedOD: MutableList<String> = mutableListOf()
            filterOptions.OffsetDescription?.forEach { od->
                if (od.isSelected == true){
                    totalCount += 1
                    selectedOD.add(od.name.toString().lowercase())
                }
            }
            for (product in productList) {
                val lowercaseBP = product.productspec.offsetdescription?.lowercase()
                if (lowercaseBP != null && selectedOD.contains(lowercaseBP)) {
                    filteredProductsOffsetDescription.add(product)
                }
            }
        }


        //generating list of products that full fill all the filters
        val allLists = listOf(
            filteredProductsAvailability,
            filteredProductsSize,
            filteredProductsPreferredBrand,
            filteredProductsOtherBrand,
            filteredProductsStyle,
            filteredProductsSpeedRating,
            filteredProductsMileageWarranty,
            filteredProductsSeasoanalDesignation,
            filteredProductsRunFlat,
            filteredProductsMarketingPrograms,
            filteredProductsRebates,
            filteredWheelDiameter,
            filteredWheelWidth,
            filteredProductsBoltPattern,
            filteredProductsATDFinish,
            filteredProductsOffsetDescription
        )
        val commonProducts = allLists.reduce { acc, list ->
            val intersectedProducts = if (list.isNotEmpty()) {
                acc.filter { product ->
                    list.any { it.atdproductnumber == product.atdproductnumber } // Replace `atdproductnumber` with the desired attribute
                }
            } else {
                acc
            }
            intersectedProducts.toList()
        }
        println("common list ->${commonProducts.size}")
        commonProducts.forEach { product ->
                product?.let { listOfFilteredProducts.add(it) }
            }


    }

    private fun availabilityMatchesProduct(availability: AvailabilityX, selectedAvailability: String): Boolean {
        return when (selectedAvailability.lowercase()) {
            "local" -> availability.local > 0
            "local+" -> availability.localplus + availability.local > 0
            "national" -> availability.nationwide + availability.localplus + availability.local > 0
            else -> false
        }
    }

    private fun setupFilterView() {
        makeNoOfSelectionsInvisible()
        //setting Availability default
        binding.ellipseRedGarage.visible()
        binding.tvApprovalNumbers.visible()
        binding.tvApprovalNumbers.text = "1"
        val list: FilterOptions = mainViewModel.getFilterOptions()
        if (list.Availability == null){
            binding.llAvailability.gone()
        }
        if (list.Size == null){
            binding.llSize.gone()
        }
        if (list.PreferredBrands == null){
            binding.llPrefBrand.gone()
        }
        if (list.Brands == null){
            binding.llOtherBrand.gone()
        }
        if (list.Style == null){
            binding.llStyle.gone()
        }
        if (list.SpeedRating == null){
            binding.llSpeedRating.gone()
        }
        if (list.MileageWarranty == null){
            binding.llMileageWarranty.gone()
        }
        if (list.SeasonalDesignation == null){
            binding.llSeasonalDesignation.gone()
        }
        if (list.RunFlat == null){
            binding.llRunFlat.gone()
        }
        if (list.MarketingPrograms == null){
            binding.llMarketingPrograms.gone()
        }
        if (list.Rebates == null){
            binding.llRebates.gone()
        }
        if (list.WheelDiameter == null){
            binding.llWheelDiameter.gone()
        }
        if (list.WheelWidth == null){
            binding.llWheelWidth.gone()
        }
        if (list.BoltPattern == null){
            binding.llBoltPattern.gone()
        }
        if (list.ATDFinish == null){
            binding.llATDFinish.gone()
        }
        if (list.OffsetDescription == null){
            binding.llOffsetDescription.gone()
        }
    }

    private fun makeNoOfSelectionsInvisible(){

        val count: Int? = updatedVersionOfFilterOptions.Availability?.let { getSelectedCount(it) }
        count?.let {
            if (count>0){
                binding.ellipseRedGarage.visible()
                binding.tvApprovalNumbers.visible()
                binding.tvApprovalNumbers.text = count.toString()
            }else{
                binding.ellipseRedGarage.gone()
                binding.tvApprovalNumbers.gone()
            }
        }

        val count1: Int? = updatedVersionOfFilterOptions.Size?.let { getSelectedCount(it) }
        count1?.let {
            if (count1>0){
                binding.ellipseRedGarageSize.visible()
                binding.tvApprovalNumbersSize.visible()
                binding.tvApprovalNumbersSize.text = count1.toString()
            }else{
                binding.ellipseRedGarageSize.gone()
                binding.tvApprovalNumbersSize.gone()
            }
        }

        val count2: Int? = updatedVersionOfFilterOptions.PreferredBrands?.let { getSelectedCount(it) }
        count2?.let {
            if (count2>0){
                binding.ellipseRedGarageSizePreferredBrand.visible()
                binding.tvApprovalNumbersPrefBrand.visible()
                binding.tvApprovalNumbersPrefBrand.text = count2.toString()
            }else{
                binding.ellipseRedGarageSizePreferredBrand.gone()
                binding.tvApprovalNumbersPrefBrand.gone()
            }
        }

        val count3: Int? = updatedVersionOfFilterOptions.Brands?.let { getSelectedCount(it) }
        count3?.let {
            if (count3>0){
                binding.ellipseRedGarageSizeOtherBrand.visible()
                binding.tvApprovalNumbersOtherBrand.visible()
                binding.tvApprovalNumbersPrefBrand.text = count3.toString()
            }else{
                binding.ellipseRedGarageSizeOtherBrand.gone()
                binding.tvApprovalNumbersOtherBrand.gone()
            }
        }

        val count4: Int? = updatedVersionOfFilterOptions.Style?.let { getSelectedCount(it) }
        count4?.let {
            if (count4>0){
                binding.ellipseRedGarageStyle.visible()
                binding.tvApprovalNumbersStyle.visible()
                binding.tvApprovalNumbersStyle.text = count4.toString()
            }else{
                binding.ellipseRedGarageStyle.gone()
                binding.tvApprovalNumbersStyle.gone()
            }
        }

        val count5: Int? = updatedVersionOfFilterOptions.SpeedRating?.let { getSelectedCount(it) }
        count5?.let {
            if (count5>0){
                binding.ellipseRedGarageSpeedRating.visible()
                binding.tvApprovalNumbersSpeedRating.visible()
                binding.tvApprovalNumbersSpeedRating.text = count5.toString()
            }else{
                binding.ellipseRedGarageSpeedRating.gone()
                binding.tvApprovalNumbersSpeedRating.gone()
            }
        }

        val count6: Int? = updatedVersionOfFilterOptions.MileageWarranty?.let { getSelectedCount(it) }
        count6?.let {
            if (count6>0){
                binding.ellipseRedGarageMileageWarranty.visible()
                binding.tvApprovalNumbersMileageWarranty.visible()
                binding.tvApprovalNumbersMileageWarranty.text = count6.toString()
            }else{
                binding.ellipseRedGarageMileageWarranty.gone()
                binding.tvApprovalNumbersMileageWarranty.gone()
            }
        }

        val count7: Int? = updatedVersionOfFilterOptions.SeasonalDesignation?.let { getSelectedCount(it) }
        count7?.let {
            if (count7>0){
                binding.ellipseRedGarageSeasonalDesignation.visible()
                binding.tvApprovalNumbersSeasonalDesignation.visible()
                binding.tvApprovalNumbersSeasonalDesignation.text = count7.toString()
            }else{
                binding.ellipseRedGarageSeasonalDesignation.gone()
                binding.tvApprovalNumbersSeasonalDesignation.gone()
            }
        }

        val count8: Int? = updatedVersionOfFilterOptions.RunFlat?.let { getSelectedCount(it) }
        count8?.let {
            if (count8>0){
                binding.ellipseRedGarageRunFlat.visible()
                binding.tvApprovalNumbersRunFlat.visible()
                binding.tvApprovalNumbersRunFlat.text = count8.toString()
            }else{
                binding.ellipseRedGarageRunFlat.gone()
                binding.tvApprovalNumbersRunFlat.gone()
            }
        }

        val count9: Int? = updatedVersionOfFilterOptions.MarketingPrograms?.let { getSelectedCount(it) }
        count9?.let {
            if (count9>0){
                binding.ellipseRedGarageMarketingPrograms.visible()
                binding.tvApprovalNumbersMarketingProgram.visible()
                binding.tvApprovalNumbersMarketingProgram.text = count9.toString()
            }else{
                binding.ellipseRedGarageMarketingPrograms.gone()
                binding.tvApprovalNumbersMarketingProgram.gone()
            }
        }

        mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
        val count10: Int? = updatedVersionOfFilterOptions.Rebates?.let { getSelectedCount(it) }
        count10?.let {
            if (count10>0){
                binding.ellipseRedGarageRebates.visible()
                binding.tvApprovalNumbersRebates.visible()
                binding.tvApprovalNumbersRebates.text = count10.toString()
            }else{
                binding.ellipseRedGarageRebates.gone()
                binding.tvApprovalNumbersRebates.gone()
            }
        }

        val count11: Int? = updatedVersionOfFilterOptions.WheelDiameter?.let { getSelectedCount(it) }
        count11?.let {
            if (count11>0){
                binding.ellipseRedGarageWheelDiameter.visible()
                binding.tvApprovalNumbersWheelDiameter.visible()
                binding.tvApprovalNumbersWheelDiameter.text = count11.toString()
            }else{
                binding.ellipseRedGarageWheelDiameter.gone()
                binding.tvApprovalNumbersWheelDiameter.gone()
            }
        }

        val count12: Int? = updatedVersionOfFilterOptions.WheelWidth?.let { getSelectedCount(it) }
        count12?.let {
            if (count12>0){
                binding.ellipseRedGarageWheelWidth.visible()
                binding.tvApprovalNumbersWheelWidth.visible()
                binding.tvApprovalNumbersWheelWidth.text = count12.toString()
            }else{
                binding.ellipseRedGarageWheelWidth.gone()
                binding.tvApprovalNumbersWheelWidth.gone()
            }
        }

        val count13: Int? = updatedVersionOfFilterOptions.BoltPattern?.let { getSelectedCount(it) }
        count13?.let {
            if (count13>0){
                binding.ellipseRedGarageBoltPattern.visible()
                binding.tvApprovalNumbersBoltPattern.visible()
                binding.tvApprovalNumbersBoltPattern.text = count13.toString()
            }else{
                binding.ellipseRedGarageBoltPattern.gone()
                binding.tvApprovalNumbersBoltPattern.gone()
            }
        }

        val count14: Int? = updatedVersionOfFilterOptions.ATDFinish?.let { getSelectedCount(it) }
        count14?.let {
            if (count14>0){
                binding.ellipseRedGarageATDFinish.visible()
                binding.tvApprovalNumbersATDFinish.visible()
                binding.tvApprovalNumbersATDFinish.text = count14.toString()
            }else{
                binding.ellipseRedGarageATDFinish.gone()
                binding.tvApprovalNumbersATDFinish.gone()
            }
        }

        val count15: Int? = updatedVersionOfFilterOptions.OffsetDescription?.let { getSelectedCount(it) }
        count15?.let {
            if (count15>0){
                binding.ellipseRedGarageOffsetDescription.visible()
                binding.tvApprovalNumbersOffsetDescription.visible()
                binding.tvApprovalNumbersOffsetDescription.text = count15.toString()
            }else{
                binding.ellipseRedGarageOffsetDescription.gone()
                binding.tvApprovalNumbersOffsetDescription.gone()
            }
        }
    }

    private fun setupRecyclerViews() {
        binding.rvAvailability.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvAvailability.adapter = adapter

        //for size
        binding.rvSize.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvSize.adapter = adapter

        //for preferredBrand
        binding.rvPrefBrand.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvPrefBrand.adapter = adapter

        //for othersBrand
        binding.rvOtherBrand.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvOtherBrand.adapter = adapter

        //for Style
        binding.rvStyle.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvStyle.adapter = adapter

        //for Speed Rating
        binding.rvSpeedRating.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvSpeedRating.adapter = adapter

        //for mileage warranty
        binding.rvMileageWarranty.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvMileageWarranty.adapter = adapter

        //for seasonal designation
        binding.rvSeasonalDesignation.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvSeasonalDesignation.adapter = adapter

        //for Run Flat
        binding.rvRunFlat.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvRunFlat.adapter = adapter

        //for marketing programs
        binding.rvMarketingPrograms.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvMarketingPrograms.adapter = adapter

        //for rebates
        binding.rvRebates.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvRebates.adapter = adapter

        //for wheel diameter
        binding.rvWheelDiameter.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvWheelDiameter.adapter = adapter

        //for wheel diameter
        binding.rvWheelWidth.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvWheelWidth.adapter = adapter

        //for bolt pattern
        binding.rvBoltPattern.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvBoltPattern.adapter = adapter

        //for atd finish
        binding.rvATDFinish.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvATDFinish.adapter = adapter

        //for offset description
        binding.rvOffsetDescription.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvOffsetDescription.adapter = adapter
    }

    private fun expandAndCollapseRecyclerView(){

        binding.ivAvailability.setOnClickListener {
            if (binding.ivAvailability.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().Availability
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                adapter.notifyDataSetChanged()
                adapter.type = getString(R.string.availability)
                binding.ivAvailability.setImageResource(R.drawable.ic_collapse)
                binding.rvAvailability.visible()
                binding.ivAvailability.tag = getString(R.string.collapse)
            }else {
                binding.ivAvailability.tag = getString(R.string.expand)
                binding.rvAvailability.gone()
                binding.ivAvailability.setImageResource(R.drawable.ic_expand)
            }
        }

        //for size
        binding.ivSize.setOnClickListener {
            if (binding.ivSize.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().Size
                adapter.type = getString(R.string.size)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
//                adapter.submitList(itemList)
                adapter.notifyDataSetChanged()
                binding.ivSize.setImageResource(R.drawable.ic_collapse)
                binding.rvSize.visible()
                binding.ivSize.tag = getString(R.string.collapse)
            }else {
                binding.ivSize.tag = getString(R.string.expand)
                binding.rvSize.gone()
                binding.ivSize.setImageResource(R.drawable.ic_expand)
            }
        }

        //for preferredBrand
        binding.ivPrefBrand.setOnClickListener {
            if (binding.ivPrefBrand.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().PreferredBrands
                adapter.type = getString(R.string.preferred_brands)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
//                adapter.submitList(itemList)
                binding.ivPrefBrand.setImageResource(R.drawable.ic_collapse)
                binding.rvPrefBrand.visible()
                binding.ivPrefBrand.tag = getString(R.string.collapse)
            }else {
                binding.ivPrefBrand.tag = getString(R.string.expand)
                binding.rvPrefBrand.gone()
                binding.ivPrefBrand.setImageResource(R.drawable.ic_expand)
            }
        }

        //for otherBrand
        binding.ivOtherBrand.setOnClickListener {
            if (binding.ivOtherBrand.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().Brands
                adapter.type = getString(R.string.brands)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivOtherBrand.setImageResource(R.drawable.ic_collapse)
                binding.rvOtherBrand.visible()
                binding.ivOtherBrand.tag = getString(R.string.collapse)
            }else {
                binding.ivOtherBrand.tag = getString(R.string.expand)
                binding.rvOtherBrand.gone()
                binding.ivOtherBrand.setImageResource(R.drawable.ic_expand)
            }
        }

        //for style
        binding.ivStyle.setOnClickListener {
            if (binding.ivStyle.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().Style
                adapter.type = getString(R.string.style)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivStyle.setImageResource(R.drawable.ic_collapse)
                binding.rvStyle.visible()
                binding.ivStyle.tag = getString(R.string.collapse)
            }else {
                binding.ivStyle.tag = getString(R.string.expand)
                binding.rvStyle.gone()
                binding.ivStyle.setImageResource(R.drawable.ic_expand)
            }
        }

        //for speed rating
        binding.ivSpeedRating.setOnClickListener {
            if (binding.ivSpeedRating.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().SpeedRating
                adapter.type = getString(R.string.speed_rating)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivSpeedRating.setImageResource(R.drawable.ic_collapse)
                binding.rvSpeedRating.visible()
                binding.ivSpeedRating.tag = getString(R.string.collapse)
            }else {
                binding.ivSpeedRating.tag = getString(R.string.expand)
                binding.rvSpeedRating.gone()
                binding.ivSpeedRating.setImageResource(R.drawable.ic_expand)
            }
        }

        //for mileage warranty
        binding.ivMileageWarranty.setOnClickListener {
            if (binding.ivMileageWarranty.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().MileageWarranty
                adapter.type = getString(R.string.mileage_warranty)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivMileageWarranty.setImageResource(R.drawable.ic_collapse)
                binding.rvMileageWarranty.visible()
                binding.ivMileageWarranty.tag = getString(R.string.collapse)
            }else {
                binding.ivMileageWarranty.tag = getString(R.string.expand)
                binding.rvMileageWarranty.gone()
                binding.ivMileageWarranty.setImageResource(R.drawable.ic_expand)
            }
        }

        //for seasonal designation
        binding.ivSeasonalDesignation.setOnClickListener {
            if (binding.ivSeasonalDesignation.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().SeasonalDesignation
                adapter.type = getString(R.string.seasonal_designation)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivSeasonalDesignation.setImageResource(R.drawable.ic_collapse)
                binding.rvSeasonalDesignation.visible()
                binding.ivSeasonalDesignation.tag = getString(R.string.collapse)
            }else {
                binding.ivSeasonalDesignation.tag = getString(R.string.expand)
                binding.rvSeasonalDesignation.gone()
                binding.ivMileageWarranty.setImageResource(R.drawable.ic_expand)
            }
        }

        //for run flat
        binding.ivRunFlat.setOnClickListener {
            if (binding.ivRunFlat.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().RunFlat
                adapter.type = getString(R.string.run_flat)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivRunFlat.setImageResource(R.drawable.ic_collapse)
                binding.rvRunFlat.visible()
                binding.ivRunFlat.tag = getString(R.string.collapse)
            }else {
                binding.ivRunFlat.tag = getString(R.string.expand)
                binding.rvRunFlat.gone()
                binding.ivRunFlat.setImageResource(R.drawable.ic_expand)
            }
        }

        //for marketing programs
        binding.ivMarketingPrograms.setOnClickListener {
            if (binding.ivMarketingPrograms.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().MarketingPrograms
                adapter.type = getString(R.string.marketing_programs)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivMarketingPrograms.setImageResource(R.drawable.ic_collapse)
                binding.rvMarketingPrograms.visible()
                binding.ivMarketingPrograms.tag = getString(R.string.collapse)
            }else {
                binding.ivMarketingPrograms.tag = getString(R.string.expand)
                binding.rvMarketingPrograms.gone()
                binding.ivMarketingPrograms.setImageResource(R.drawable.ic_expand)
            }
        }

        //for rebates
        binding.ivRebates.setOnClickListener {
            if (binding.ivRebates.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().Rebates
                adapter.type = getString(R.string.rebates)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivRebates.setImageResource(R.drawable.ic_collapse)
                binding.rvRebates.visible()
                binding.ivRebates.tag = getString(R.string.collapse)
            }else {
                binding.ivRebates.tag = getString(R.string.expand)
                binding.rvRebates.gone()
                binding.ivRebates.setImageResource(R.drawable.ic_expand)
            }
        }

        //for wheel diameter
        binding.ivWheelDiameter.setOnClickListener {
            if (binding.ivWheelDiameter.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().WheelDiameter
                adapter.type = getString(R.string.wheel_diameter)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivWheelDiameter.setImageResource(R.drawable.ic_collapse)
                binding.rvWheelDiameter.visible()
                binding.ivWheelDiameter.tag = getString(R.string.collapse)
            }else {
                binding.ivWheelDiameter.tag = getString(R.string.expand)
                binding.rvWheelDiameter.gone()
                binding.ivWheelDiameter.setImageResource(R.drawable.ic_expand)
            }
        }

        //for wheel width
        binding.ivWheelWidth.setOnClickListener {
            if (binding.ivWheelWidth.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().WheelWidth
                adapter.type = getString(R.string.wheel_width)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivWheelWidth.setImageResource(R.drawable.ic_collapse)
                binding.rvWheelWidth.visible()
                binding.ivWheelWidth.tag = getString(R.string.collapse)
            }else {
                binding.ivWheelWidth.tag = getString(R.string.expand)
                binding.rvWheelWidth.gone()
                binding.ivWheelWidth.setImageResource(R.drawable.ic_expand)
            }
        }

        //for bolt pattern
        binding.ivBoltPattern.setOnClickListener {
            if (binding.ivBoltPattern.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().BoltPattern
                adapter.type = getString(R.string.bolt_pattern)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivBoltPattern.setImageResource(R.drawable.ic_collapse)
                binding.rvBoltPattern.visible()
                binding.ivBoltPattern.tag = getString(R.string.collapse)
            }else {
                binding.ivBoltPattern.tag = getString(R.string.expand)
                binding.rvBoltPattern.gone()
                binding.ivBoltPattern.setImageResource(R.drawable.ic_expand)
            }
        }

        //for atd finish
        binding.ivATDFinish.setOnClickListener {
            if (binding.ivATDFinish.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().ATDFinish
                adapter.type = getString(R.string.atd_finish)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivATDFinish.setImageResource(R.drawable.ic_collapse)
                binding.rvATDFinish.visible()
                binding.ivATDFinish.tag = getString(R.string.collapse)
            }else {
                binding.ivATDFinish.tag = getString(R.string.expand)
                binding.rvATDFinish.gone()
                binding.ivATDFinish.setImageResource(R.drawable.ic_expand)
            }
        }

        //for offset description
        binding.ivOffsetDescription.setOnClickListener {
            if (binding.ivOffsetDescription.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptions().OffsetDescription
                adapter.type = getString(R.string.offset_description)
//                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                binding.ivOffsetDescription.setImageResource(R.drawable.ic_collapse)
                binding.rvOffsetDescription.visible()
                binding.ivOffsetDescription.tag = getString(R.string.collapse)
            }else {
                binding.ivOffsetDescription.tag = getString(R.string.expand)
                binding.rvOffsetDescription.gone()
                binding.ivOffsetDescription.setImageResource(R.drawable.ic_expand)
            }
        }
    }


    private fun closeAllOtherView() {
        adapter.clearItems()
//        adapter.submitList(emptyList())
//        adapter.notifyDataSetChanged()
        binding.ivAvailability.tag = getString(R.string.expand)
        binding.rvAvailability.gone()
        binding.ivAvailability.setImageResource(R.drawable.ic_expand)

        binding.ivSize.tag = getString(R.string.expand)
        binding.rvSize.gone()
        binding.ivSize.setImageResource(R.drawable.ic_expand)

        binding.ivPrefBrand.tag = getString(R.string.expand)
        binding.rvPrefBrand.gone()
        binding.ivPrefBrand.setImageResource(R.drawable.ic_expand)

        binding.ivOtherBrand.tag = getString(R.string.expand)
        binding.rvOtherBrand.gone()
        binding.ivOtherBrand.setImageResource(R.drawable.ic_expand)

        binding.ivStyle.tag = getString(R.string.expand)
        binding.rvStyle.gone()
        binding.ivStyle.setImageResource(R.drawable.ic_expand)

        binding.ivSpeedRating.tag = getString(R.string.expand)
        binding.rvSpeedRating.gone()
        binding.ivSpeedRating.setImageResource(R.drawable.ic_expand)

        binding.ivMileageWarranty.tag = getString(R.string.expand)
        binding.rvMileageWarranty.gone()
        binding.ivMileageWarranty.setImageResource(R.drawable.ic_expand)

        binding.ivSeasonalDesignation.tag = getString(R.string.expand)
        binding.rvSeasonalDesignation.gone()
        binding.ivMileageWarranty.setImageResource(R.drawable.ic_expand)

        binding.ivRunFlat.tag = getString(R.string.expand)
        binding.rvRunFlat.gone()
        binding.ivRunFlat.setImageResource(R.drawable.ic_expand)

        binding.ivMarketingPrograms.tag = getString(R.string.expand)
        binding.rvMarketingPrograms.gone()
        binding.ivMarketingPrograms.setImageResource(R.drawable.ic_expand)

        binding.ivRebates.tag = getString(R.string.expand)
        binding.rvRebates.gone()
        binding.ivRebates.setImageResource(R.drawable.ic_expand)

        binding.ivWheelDiameter.tag = getString(R.string.expand)
        binding.rvWheelDiameter.gone()
        binding.ivWheelDiameter.setImageResource(R.drawable.ic_expand)

        binding.ivWheelWidth.tag = getString(R.string.expand)
        binding.rvWheelWidth.gone()
        binding.ivWheelWidth.setImageResource(R.drawable.ic_expand)

        binding.ivBoltPattern.tag = getString(R.string.expand)
        binding.rvBoltPattern.gone()
        binding.ivBoltPattern.setImageResource(R.drawable.ic_expand)

        binding.ivATDFinish.tag = getString(R.string.expand)
        binding.rvATDFinish.gone()
        binding.ivATDFinish.setImageResource(R.drawable.ic_expand)

        binding.ivOffsetDescription.tag = getString(R.string.expand)
        binding.rvOffsetDescription.gone()
        binding.ivOffsetDescription.setImageResource(R.drawable.ic_expand)
    }

    private fun getSelectedCount(item: List<FilterItem>) :Int{
        var count:Int = 0
        item.forEach { it->
            if (it.isSelected == true){
                count += 1
            }
        }
        return count
    }

    private fun onItemClick(type: String, item: FilterItem, position: Int){

        when(type){
            getString(R.string.availability) -> {
                updatedVersionOfFilterOptions.Availability?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)){
                        copyItem.isSelected = item.isSelected
                    }else{
                        copyItem.isSelected = false
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.Availability?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarage.visible()
                        binding.tvApprovalNumbers.visible()
                        binding.tvApprovalNumbers.text = count.toString()
                    }else{
                        binding.ellipseRedGarage.gone()
                        binding.tvApprovalNumbers.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.Availability)
                adapter.notifyItemRangeChanged(0,4)

            }
            getString(R.string.size) ->{
                updatedVersionOfFilterOptions.Size?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.Size?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageSize.visible()
                        binding.tvApprovalNumbersSize.visible()
                        binding.tvApprovalNumbersSize.text = count.toString()
                    }else{
                        binding.ellipseRedGarageSize.gone()
                        binding.tvApprovalNumbersSize.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.Size)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.preferred_brands) ->{
                updatedVersionOfFilterOptions.PreferredBrands?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.PreferredBrands?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageSizePreferredBrand.visible()
                        binding.tvApprovalNumbersPrefBrand.visible()
                        binding.tvApprovalNumbersPrefBrand.text = count.toString()
                    }else{
                        binding.ellipseRedGarageSizePreferredBrand.gone()
                        binding.tvApprovalNumbersPrefBrand.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.PreferredBrands)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.brands) ->{
                updatedVersionOfFilterOptions.Brands?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.Brands?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageSizeOtherBrand.visible()
                        binding.tvApprovalNumbersOtherBrand.visible()
                        binding.tvApprovalNumbersOtherBrand.text = count.toString()
                    }else{
                        binding.ellipseRedGarageSizeOtherBrand.gone()
                        binding.tvApprovalNumbersOtherBrand.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.Brands)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.style) ->{
                updatedVersionOfFilterOptions.Style?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.Style?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageStyle.visible()
                        binding.tvApprovalNumbersStyle.visible()
                        binding.tvApprovalNumbersStyle.text = count.toString()
                    }else{
                        binding.ellipseRedGarageStyle.gone()
                        binding.tvApprovalNumbersStyle.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.Style)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.speed_rating) ->{
                updatedVersionOfFilterOptions.SpeedRating?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.SpeedRating?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageSpeedRating.visible()
                        binding.tvApprovalNumbersSpeedRating.visible()
                        binding.tvApprovalNumbersSpeedRating.text = count.toString()
                    }else{
                        binding.ellipseRedGarageSpeedRating.gone()
                        binding.tvApprovalNumbersSpeedRating.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.SpeedRating)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.mileage_warranty) ->{
                updatedVersionOfFilterOptions.MileageWarranty?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.MileageWarranty?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageMileageWarranty.visible()
                        binding.tvApprovalNumbersMileageWarranty.visible()
                        binding.tvApprovalNumbersMileageWarranty.text = count.toString()
                    }else{
                        binding.ellipseRedGarageMileageWarranty.gone()
                        binding.tvApprovalNumbersMileageWarranty.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.MileageWarranty)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.seasonal_designation) ->{
                updatedVersionOfFilterOptions.SeasonalDesignation?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.SeasonalDesignation?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageSeasonalDesignation.visible()
                        binding.tvApprovalNumbersSeasonalDesignation.visible()
                        binding.tvApprovalNumbersSeasonalDesignation.text = count.toString()
                    }else{
                        binding.ellipseRedGarageSeasonalDesignation.gone()
                        binding.tvApprovalNumbersSeasonalDesignation.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.SeasonalDesignation)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.run_flat) ->{
                updatedVersionOfFilterOptions.RunFlat?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }else{
                            copyItem.isSelected = false
                        }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.RunFlat?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageRunFlat.visible()
                        binding.tvApprovalNumbersRunFlat.visible()
                        binding.tvApprovalNumbersRunFlat.text = count.toString()
                    }else{
                        binding.ellipseRedGarageRunFlat.gone()
                        binding.tvApprovalNumbersRunFlat.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.RunFlat)
                adapter.notifyItemRangeChanged(0,4)

            }
            getString(R.string.marketing_programs) ->{
                updatedVersionOfFilterOptions.MarketingPrograms?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.MarketingPrograms?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageMarketingPrograms.visible()
                        binding.tvApprovalNumbersMarketingProgram.visible()
                        binding.tvApprovalNumbersMarketingProgram.text = count.toString()
                    }else{
                        binding.ellipseRedGarageMarketingPrograms.gone()
                        binding.tvApprovalNumbersMarketingProgram.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.MarketingPrograms)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.rebates) ->{
                updatedVersionOfFilterOptions.Rebates?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.Rebates?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageRebates.visible()
                        binding.tvApprovalNumbersRebates.visible()
                        binding.tvApprovalNumbersRebates.text = count.toString()
                    }else{
                        binding.ellipseRedGarageRebates.gone()
                        binding.tvApprovalNumbersRebates.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.Rebates)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.wheel_diameter) ->{
                updatedVersionOfFilterOptions.WheelDiameter?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.WheelDiameter?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageWheelDiameter.visible()
                        binding.tvApprovalNumbersWheelDiameter.visible()
                        binding.tvApprovalNumbersWheelDiameter.text = count.toString()
                    }else{
                        binding.ellipseRedGarageWheelDiameter.gone()
                        binding.tvApprovalNumbersWheelDiameter.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.WheelDiameter)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.wheel_width) ->{
                updatedVersionOfFilterOptions.WheelWidth?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.WheelWidth?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageWheelWidth.visible()
                        binding.tvApprovalNumbersWheelWidth.visible()
                        binding.tvApprovalNumbersWheelWidth.text = count.toString()
                    }else{
                        binding.ellipseRedGarageWheelWidth.gone()
                        binding.tvApprovalNumbersWheelWidth.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.WheelWidth)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.bolt_pattern) ->{
                updatedVersionOfFilterOptions.BoltPattern?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.BoltPattern?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageBoltPattern.visible()
                        binding.tvApprovalNumbersBoltPattern.visible()
                        binding.tvApprovalNumbersBoltPattern.text = count.toString()
                    }else{
                        binding.ellipseRedGarageBoltPattern.gone()
                        binding.tvApprovalNumbersBoltPattern.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.BoltPattern)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.atd_finish) ->{
                updatedVersionOfFilterOptions.ATDFinish?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.ATDFinish?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageATDFinish.visible()
                        binding.tvApprovalNumbersATDFinish.visible()
                        binding.tvApprovalNumbersATDFinish.text = count.toString()
                    }else{
                        binding.ellipseRedGarageATDFinish.gone()
                        binding.tvApprovalNumbersATDFinish.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.ATDFinish)
                adapter.notifyItemChanged(position)
            }
            getString(R.string.offset_description) ->{
                updatedVersionOfFilterOptions.OffsetDescription?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)) {
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptions(updatedVersionOfFilterOptions)
                val count: Int? = updatedVersionOfFilterOptions.OffsetDescription?.let { getSelectedCount(it) }
                count?.let {
                    if (count>0){
                        binding.ellipseRedGarageOffsetDescription.visible()
                        binding.tvApprovalNumbersOffsetDescription.visible()
                        binding.tvApprovalNumbersOffsetDescription.text = count.toString()
                    }else{
                        binding.ellipseRedGarageOffsetDescription.gone()
                        binding.tvApprovalNumbersOffsetDescription.gone()
                    }
                }
                adapter.submitList(updatedVersionOfFilterOptions.OffsetDescription)
                adapter.notifyItemChanged(position)
            }
        }

    }

}
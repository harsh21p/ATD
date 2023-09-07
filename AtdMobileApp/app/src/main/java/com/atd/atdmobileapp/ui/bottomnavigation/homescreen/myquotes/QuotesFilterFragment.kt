package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentQuotesFilterBinding
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.myquotes.FilterOptionQuotes
import com.atd.atdmobileapp.models.productsearch.FilterItem
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class QuotesFilterFragment : DialogFragment() {

    private var _binding : FragmentQuotesFilterBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: FilterAdapter
    private lateinit var  filterOptionQuotes: FilterOptionQuotes
    private lateinit var mainViewModel: MainViewModel
    private var updatedVersionOfFilterOptionQuotes = FilterOptionQuotes()
    private var isClearAllActive: Boolean = false
    private var isApplyActive: Boolean = false
    private var totalCount: Int = 0
    private var isTabExpandedTagSpecifyDate:Boolean = false
    private var isTabSelectedTagStartDate:Boolean = false
    private var isTabSelectedTagEndDate:Boolean = false
    private var isLastModifiedSelected:Boolean = false
    private var someThingChanged:Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentQuotesFilterBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterOptionQuotes = mainViewModel.getFilterOptionsQuotes()
        updatedVersionOfFilterOptionQuotes = filterOptionQuotes
        val type = getString(R.string.status)
        adapter = FilterAdapter(type, ::onItemClick)

        makeNoOfSelectionsInvisible()
        expandAndCollapseRecyclerView()
        setupRecyclerViews()
        onClickClearAll()
        onClickApply()
        updateApplyStatus()
        setLastModifiedStatus()
        onClickNone()
        onClickLast24Hours()
        onClickLast7Days()
        onClickLast30Days()
        onClickSpecifyDate()
        onClickSelectStartDate()
        onClickSelectEndDate()
        onClickHiddenStartDate()
        onClickHiddenEndDate()

        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }
        setupTheme()
    }
    private fun setupTheme() {
        binding.ivClose.imageTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.tvClearAll.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
        binding.ivStatus.imageTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.ivLastModified.imageTintList= ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.viewDivider2.backgroundTintList= ContextCompat.getColorStateList(requireContext(),R.color.disable_background)
        binding.startDate.tvEndDateQuote.setTextColor(ContextCompat.getColorStateList(requireContext(), theameColor))
        //binding.tvApply.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
       // binding.tvApply.setTextColor(resources.getColor(R.color.disableText))
    }


    private fun setLastModifiedStatus() {
        updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lastModified ->
            when(lastModified.name){

                "None" ->{
                    if (lastModified.isSelected == true){
                      
                            if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivNone.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivNone.setImageResource(R.drawable.radio_selected_red)
                        }
                       
                        binding.ellipseRedGarageLastModified.visible()
                        binding.tvApprovalNumbersLastModified.visible()
                    }
                }
                "Last 24 Hours" ->{
                    if (lastModified.isSelected == true){
                      
                             if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast24Hours.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast24Hours.setImageResource(R.drawable.radio_selected_red)
                        }
                        
                        binding.ellipseRedGarageLastModified.visible()
                        binding.tvApprovalNumbersLastModified.visible()
                    }
                }
                "Last 7 Days" ->{
                    if (lastModified.isSelected == true){
                      
                            if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast7days.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast7days.setImageResource(R.drawable.radio_selected_red)
                        }
                        
                        binding.ellipseRedGarageLastModified.visible()
                        binding.tvApprovalNumbersLastModified.visible()
                    }
                }
                "Last 30 Days" ->{
                    if (lastModified.isSelected == true){
                       
                             if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast30days.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast30days.setImageResource(R.drawable.radio_selected_red)
                        }
                        

                        binding.ellipseRedGarageLastModified.visible()
                        binding.tvApprovalNumbersLastModified.visible()
                    }
                }
                "Specify Date Range" ->{
                    if (lastModified.isSelected == true){
                       
                        if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_selected_red)
                        }
                        binding.ellipseRedGarageLastModified.visible()
                        binding.tvApprovalNumbersLastModified.visible()
                    }
                }
            }
        }
    }

    private fun showHideCountLastModified(case: Boolean){
        if (case){
            binding.ellipseRedGarageLastModified.visible()
            binding.tvApprovalNumbersLastModified.visible()
            isLastModifiedSelected = true
        }else{
            binding.ellipseRedGarageLastModified.gone()
            binding.tvApprovalNumbersLastModified.gone()
            isTabSelectedTagEndDate = false
        }
    }
    private fun onClickLast24Hours() {
        binding.touchFor24Hours.setOnClickListener {
            setFalseStatusLastModified()
            if (binding.ivLast24Hours.tag.equals("selected")){
                binding.ivLast24Hours.setImageResource(R.drawable.radio_unselected)
                binding.ivLast24Hours.tag = "unselected"
                showHideCountLastModified(false)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 24 Hours") == true){
                        lm.isSelected = false
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            }else{
                 if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast24Hours.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast24Hours.setImageResource(R.drawable.radio_selected_red)
                        }
                binding.ivLast24Hours.tag = "selected"
                showHideCountLastModified(true)
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                binding.ivLast30days.setImageResource(R.drawable.radio_unselected)
                binding.ivNone.setImageResource(R.drawable.radio_unselected)
                binding.ivLast7days.setImageResource(R.drawable.radio_unselected)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 24 Hours") == true){
                        lm.isSelected = true
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

                //hide dates
                binding.startDate.root.gone()
                binding.endDate.root.gone()
                isTabExpandedTagSpecifyDate = false
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)

                someThingChanged = true
                isApplyActive = true
               
                    if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }
                
            }
        }
    }

    private fun onClickNone() {
        binding.touchForNone.setOnClickListener {
            setFalseStatusLastModified()
            if (binding.ivNone.tag.equals("selected")){
                binding.ivNone.setImageResource(R.drawable.radio_unselected)
                binding.ivNone.tag = "unselected"

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("None") == true){
                        lm.isSelected = false
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            }else{
                if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivNone.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivNone.setImageResource(R.drawable.radio_selected_red)
                        }
                binding.ivNone.tag = "selected"

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("None") == true){
                        lm.isSelected = true
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

                showHideCountLastModified(true)
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                binding.ivLast30days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast24Hours.setImageResource(R.drawable.radio_unselected)
                binding.ivLast7days.setImageResource(R.drawable.radio_unselected)

                //hide dates
                binding.startDate.root.gone()
                binding.endDate.root.gone()
                isTabExpandedTagSpecifyDate = false
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)

                //enabling apply button
                someThingChanged = true
                isApplyActive = true
                if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }

            }
        }
    }

    private fun setFalseStatusLastModified() {
        updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
            lm.isSelected = false
        }
    }

    private fun onClickLast7Days() {
        binding.touchLast7Days.setOnClickListener {
            setFalseStatusLastModified()
            if (binding.ivLast7days.tag.equals("unselected")){
                if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast7days.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast7days.setImageResource(R.drawable.radio_selected_red)
                        }
                binding.ivLast7days.tag = "selected"
                showHideCountLastModified(true)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 7 Days") == true){
                        lm.isSelected = true
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

                //unselect all other
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                binding.ivLast30days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast24Hours.setImageResource(R.drawable.radio_unselected)
                binding.ivNone.setImageResource(R.drawable.radio_unselected)

                //hide dates
                binding.startDate.root.gone()
                binding.endDate.root.gone()
                isTabExpandedTagSpecifyDate = false
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                //enabling apply button
                someThingChanged = true
                isApplyActive = true
                if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }

            }else{
                binding.ivLast7days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast7days.tag = "unselected"
                showHideCountLastModified(false)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 7 Days") == true){
                        lm.isSelected = false
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            }
        }
    }

    private fun onClickLast30Days() {
        binding.touchForLast30Days.setOnClickListener {
            setFalseStatusLastModified()
            if (binding.ivLast30days.tag.equals("unselected")){
                 if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivLast30days.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivLast30days.setImageResource(R.drawable.radio_selected_red)
                        }
                binding.ivLast30days.tag = "selected"
                showHideCountLastModified(true)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 30 Days") == true){
                        lm.isSelected = true
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

                //unselect all other
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                binding.ivLast7days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast24Hours.setImageResource(R.drawable.radio_unselected)
                binding.ivNone.setImageResource(R.drawable.radio_unselected)
                //hide dates
                binding.startDate.root.gone()
                binding.endDate.root.gone()
                isTabExpandedTagSpecifyDate = false
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                //enabling apply button
                someThingChanged = true
                isApplyActive = true
                if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }

            }else{
                binding.ivLast30days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast30days.tag = "unselected"
                showHideCountLastModified(false)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Last 30 Days") == true){
                        lm.isSelected = false
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            }
        }
    }

    private fun onClickHiddenEndDate() {
        binding.endDate.tvDateToDisplay.setOnClickListener {
            showDatePicker(1)
        }
    }

    private fun onClickHiddenStartDate() {
        binding.startDate.tvDateToDisplay.setOnClickListener {
            showDatePicker(0)
        }
    }

    private fun showDatePicker(index: Int) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        // Create a DatePickerDialog and set the OnDateSetListener
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = formatDate(selectedYear, selectedMonth, selectedDay)
                updateDateTextView(index, formattedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
    private fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val formatter = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
        return formatter.format(calendar.time)
    }

    private fun updateDateTextView(index:Int, selectedDate: String) {
        if (index == 0){
            //updating start
            binding.startDate.tvDateToDisplay.text = selectedDate
        }else{
            //updating end
            binding.endDate.tvDateToDisplay.text = selectedDate
        }
        println("Selected date-> $selectedDate")
    }

    private fun onClickSelectEndDate() {
        val viewsToClick = listOf<View>(binding.endDate.tvEndDateQuote, binding.endDate.imageView)
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                isTabSelectedTagEndDate = if (isTabSelectedTagEndDate){
                    binding.endDate.tvDateToDisplay.gone()
                    false
                }else{
                    binding.endDate.tvDateToDisplay.visible()
                    val time = Calendar.getInstance().time
                    val formatter = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
                    val current = formatter.format(time)
                    binding.endDate.tvDateToDisplay.text = current
                    true
                }
            }
        }
    }

    private fun onClickSelectStartDate() {
        val viewsToClick = listOf<View>(binding.startDate.tvEndDateQuote, binding.startDate.imageView)
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                isTabSelectedTagStartDate = if (isTabSelectedTagStartDate){
                    binding.startDate.tvDateToDisplay.gone()
                    false
                }else{
                    binding.startDate.tvDateToDisplay.visible()
                    val time = Calendar.getInstance().time
                    val formatter = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
                    val current = formatter.format(time)
                    binding.startDate.tvDateToDisplay.text = current
                    true
                }
            }
        }

    }

    private fun onClickSpecifyDate() {
        binding.touchForSpecifyDate.setOnClickListener {
            setFalseStatusLastModified()
            if (isTabExpandedTagSpecifyDate){
                binding.startDate.root.gone()
                binding.endDate.root.gone()
                isTabExpandedTagSpecifyDate = false
                binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_unselected)
                showHideCountLastModified(false)

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Specify Date Range") == true){
                        lm.isSelected = false
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            }else{
                binding.startDate.root.visible()
                binding.endDate.root.visible()
                isTabExpandedTagSpecifyDate = true
                showHideCountLastModified(true)
                if (theameColor.equals(R.color.atd_blue)) {
                            binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_selected)
                        }else{
                            binding.ivSpecifyDateRange.setImageResource(R.drawable.radio_selected_red)
                        }
                //unselect all other options
                binding.ivLast30days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast7days.setImageResource(R.drawable.radio_unselected)
                binding.ivLast24Hours.setImageResource(R.drawable.radio_unselected)
                binding.ivNone.setImageResource(R.drawable.radio_unselected)
                //enabling apply button
                someThingChanged = true
                isApplyActive = true
                if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }

                //update filter options
                updatedVersionOfFilterOptionQuotes.LastModified?.forEach { lm ->
                    if (lm.name?.equals("Specify Date Range") == true){
                        lm.isSelected = true
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

            }
        }
    }

    private fun onClickApply() {
        binding.filterApply.setOnClickListener {
            if (isApplyActive){
                if (isClearAllActive){
//                listOfFilteredProducts = productList as MutableList<Product>
                    setResult()
                }else{
//                filterProducts()
                    setResult()
                }
                isClearAllActive = false
            }
        }
    }

    private fun setResult() {
        val result = Bundle().apply {
        }
        //check and get value for last modified if selected
        when(getLastModifiedValue()){
            1 -> {
                result.putInt(Constants.LAST_MODIFIED_KEY, 1)
            }2 -> {
            result.putInt(Constants.LAST_MODIFIED_KEY, 2)
        }3 -> {
            result.putInt(Constants.LAST_MODIFIED_KEY, 3)
        }4 -> {
            result.putInt(Constants.LAST_MODIFIED_KEY, 4)
            //logic to set selected date range
            result.putString(Constants.START_DATE_SELECTED, binding.startDate.tvDateToDisplay.text.toString())
            result.putString(Constants.END_DATE_SELECTED, binding.endDate.tvDateToDisplay.text.toString())
        }
        }
        setFragmentResult(Constants.FILTER_RESULT_QUOTE, result)
        dialog?.dismiss()
    }

    private fun getLastModifiedValue(): Int {
        if (isLastModifiedSelected){
            if (binding.ivNone.tag.equals("selected")){
                //do not take any value
                return 0
            }else if (binding.ivLast24Hours.tag.equals("selected")){
                //take this value and return
                return 1
            }else if (binding.ivLast7days.tag.equals("selected")){
                //take this value and return
                return 2
            }else if (binding.ivLast30days.tag.equals("selected")){
                //take this value and return
                return 3
            }else if (isTabExpandedTagSpecifyDate){
                //take this value and return
                return 4
            }

        }
        return 999
    }

    private fun onClickClearAll() {
        binding.tvClearAll.setOnClickListener {
            isClearAllActive = true
            closeAllOtherView()
            updatedVersionOfFilterOptionQuotes = mainViewModel.getFilterOptionsQuotes()
            setAllSelectedToFalse(updatedVersionOfFilterOptionQuotes)
            mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)
            if (someThingChanged){
                isApplyActive = true
                if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }
            }else{
                isApplyActive = false
                binding.filterApply.setImageResource(R.drawable.gray_apply_quote)
            }
            setFalseStatusLastModified()
            //remove count last modified
            binding.ellipseRedGarageLastModified.gone()
            binding.tvApprovalNumbersLastModified.gone()

        }
    }

    private fun setAllSelectedToFalse(filterOptions: FilterOptionQuotes) {

        filterOptions.Status?.forEach { status ->
            status.isSelected = false
        }

        filterOptions.ModifiedBy?.forEach { status ->
            status.isSelected = false
        }
        filterOptions.LastModified?.forEach { status ->
            status.isSelected = false
        }
        filterOptions.CreatedBy?.forEach { status ->
            status.isSelected = false
        }

        makeNoOfSelectionsInvisible()
    }


    private fun makeNoOfSelectionsInvisible() {
        var localTotal :Int? = 0
        val count: Int? = updatedVersionOfFilterOptionQuotes.Status?.let { getSelectedCount(it) }
        count?.let {
            if (count>0){
                binding.ellipseRedGarage.visible()
                binding.tvApprovalNumbers.visible()
                binding.tvApprovalNumbers.text = count.toString()
                someThingChanged = true
            }else{
                binding.ellipseRedGarage.gone()
                binding.tvApprovalNumbers.gone()
            }
        }


        localTotal = count
        totalCount = localTotal ?: 0
    }

    private fun setupRecyclerViews() {
        binding.rvStatus.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvStatus.adapter = adapter

    }


    private fun expandAndCollapseRecyclerView() {
        binding.llStatus.setOnClickListener{
            if (binding.ivStatus.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                val itemList = mainViewModel.getFilterOptionsQuotes().Status
                adapter.submitList(itemList)
                if (itemList != null) {
                    adapter.setData(itemList)
                }
                adapter.submitList(filterOptionQuotes.Status)
                adapter.notifyItemRangeChanged(0, 99)
                adapter.type = getString(R.string.status)
                binding.ivStatus.setImageResource(R.drawable.ic_collapse)
                binding.rvStatus.visible()
                binding.ivStatus.tag = getString(R.string.collapse)
            }else {
                binding.ivStatus.tag = getString(R.string.expand)
                binding.rvStatus.gone()
                binding.ivStatus.setImageResource(R.drawable.ic_expand)
            }
        }

        //for Last Modified
        binding.touchForLastModified.setOnClickListener{
            if (binding.ivLastModified.tag.equals(getString(R.string.expand))){
                closeAllOtherView()
                binding.ivLastModified.setImageResource(R.drawable.ic_collapse)
                binding.expandableLayoutLastModified.visible()
                binding.ivLastModified.tag = getString(R.string.collapse)
            }else {
                binding.ivLastModified.tag = getString(R.string.expand)
                binding.expandableLayoutLastModified.gone()
                binding.ivLastModified.setImageResource(R.drawable.ic_expand)
            }
        }

    }

    private fun onItemClick(type: String, item:FilterItem, position: Int){

        //enabling apply button
        isApplyActive = true
        someThingChanged = true
        if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }
        when(type){
            getString(R.string.status) ->{
                updatedVersionOfFilterOptionQuotes.Status?.forEach { copyItem ->
                    if (copyItem.name.equals(item.name)){
                        copyItem.isSelected = item.isSelected
                    }
                }
                mainViewModel.setFilterOptionsQuotes(updatedVersionOfFilterOptionQuotes)

                //updating count
                makeNoOfSelectionsInvisible()

                //updating list
                adapter.submitList(updatedVersionOfFilterOptionQuotes.Status)
                adapter.notifyItemChanged(position)

                //update Apply Button Status
                updateApplyStatus()
            }
        }
    }

    private fun updateApplyStatus() {
        println("totalCount $totalCount isApplyActibe $isApplyActive")
        isApplyActive = if (totalCount<=0){
            binding.filterApply.setImageResource(R.drawable.gray_apply_quote)
            false
        }else{
            if (theameColor.equals(R.color.atd_blue)) {
                    binding.filterApply.setImageResource(R.drawable.apply_blue)
                }else{
                    binding.filterApply.setImageResource(R.drawable.apply_red)
                }
            true

        }
        someThingChanged = true
    }

    private fun getSelectedCount(item: List<FilterItem>) :Int{
        var count:Int = 0
        item.forEach { it->
            if (it.isSelected == true){
                count += 1
                totalCount +=1
            }
        }
        return count
    }

    private fun closeAllOtherView() {
        binding.ivStatus.tag = getString(R.string.expand)
        binding.rvStatus.gone()
        binding.ivStatus.setImageResource(R.drawable.ic_expand)

        //for last modified
        binding.ivLastModified.tag = getString(R.string.expand)
//        binding.rvLastModified.gone()
        binding.expandableLayoutLastModified.gone()
        binding.ivLastModified.setImageResource(R.drawable.ic_expand)
    }

    companion object {
        const val TAG = "quoteFilterFrag"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}
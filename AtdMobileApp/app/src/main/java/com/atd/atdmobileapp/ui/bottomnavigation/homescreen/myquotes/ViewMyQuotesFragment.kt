package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentViewMyQuotesBinding
import com.atd.atdmobileapp.models.keywordsearch.*
import com.atd.atdmobileapp.models.myquotes.*
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.FilterItem
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment
import com.atd.atdmobileapp.ui.product.ProductViewModel
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class ViewMyQuotesFragment : Fragment() {

    private var _binding : FragmentViewMyQuotesBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private val myQuotesViewModel by viewModels<MyQuotesViewModel>()
//    private lateinit var adapter : MyQuotesAdapter
    private lateinit var adapter : ViewQuotesAdapter
    private lateinit var retailQuote: MutableList<Retailquote>
    private lateinit var quoteStatus: List<String>
    private var filterOptionQuotes = FilterOptionQuotes()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var speechRecognizer: SpeechRecognizer
    private val productByCriteriaViewModel by viewModels<ProductViewModel>()
    private lateinit var  quote : Retailquote



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentViewMyQuotesBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setUpTheme()
        return binding.root
    }

    private fun setUpTheme() {

        if (theameColor==R.color.red){
            binding.filterQuotes.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.filter_tirepros))
            binding.printQuotes.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.print_icon_tirepros))
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

        }else{
            binding.filterQuotes.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.filter))
            binding.printQuotes.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.print_icon))
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)

        }

        binding.ivKeywordSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),
            theameColor
        )
        binding.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)

        if (theameColor ==R.color.red) {
            binding.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.red_baseline_rectangle_24)
        }else{
            binding.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.baseline_rectangle_24)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireActivity())
        setupUI()
        noQuotesUISetup()
        onClickShopForProducts()
        getQuotes()
        getStatus()
        bindObservers()
        onEditForSearch()
        onclickFilter()
        dropDownListenerFilterOptions()
        getTextFromSpeech()
    }

    private fun dropDownListenerFilterOptions() {
        parentFragmentManager.setFragmentResultListener(Constants.FILTER_RESULT_QUOTE, this){ _, result ->
            //getting result form filter screen
            val userSelectedFilterOptionQuotes = mainViewModel.getFilterOptionsQuotes()
            val tempStatusList : MutableList<String> = mutableListOf()
            userSelectedFilterOptionQuotes.Status?.forEach { status ->
                if (status.isSelected == true){
                    tempStatusList.add(status.name.toString())
                }
            }
            if (tempStatusList.contains("All Statuses")){
//                adapter.addQuotes(retailQuote)
                adapter.submitList(retailQuote)
                adapter.notifyItemRangeChanged(0, adapter.itemCount)
//                adapter.notifyDataSetChanged()
                //updating total count
                binding.searchNumbers.text=getString(R.string.quotes_search_numbers,retailQuote.size.toString())

            }else {
                //getting result bundle
                val userLastModifiedSelection = result.getInt(Constants.LAST_MODIFIED_KEY)
                var startDate = ""
                var endDate = ""
                if (userLastModifiedSelection == 4) {
                    startDate = result.getString(Constants.START_DATE_SELECTED, "")
                    endDate = result.getString(Constants.END_DATE_SELECTED, "")
                }
                filterQuotesBasedOnUserFilterSelection(
                    userSelectedFilterOptionQuotes,
                    userLastModifiedSelection,
                    startDate,
                    endDate
                )
            }
        }
    }

    private fun filterQuotesBasedOnUserFilterSelection(
        userSelectedFilterOptionQuotes: FilterOptionQuotes,
        userLastModifiedSelection: Int,
        startDate: String,
        endDate: String
    ) {
        val filterQuotes : MutableList<Retailquote> = mutableListOf()

        val filteredQuotesStatus: MutableList<Retailquote> = mutableListOf()

        if (userSelectedFilterOptionQuotes.Status?.isNotEmpty() == true){
            val selectedStatus: MutableList<String> = mutableListOf()
            userSelectedFilterOptionQuotes.Status?.forEach { status ->
                if (status.isSelected == true){
                    //get add to total count
                    selectedStatus.add(status.name?.lowercase().toString())
                }
            }
            for (quote in retailQuote){
                val lowercaseStatus = quote.quoteinfo.status.lowercase()
                if (selectedStatus.contains(lowercaseStatus)){
                    filteredQuotesStatus.add(quote)
                }
            }
        }
        //filter based on dates
        val filteredQuotesByDate = filterByDate(retailQuote.toMutableList(), userLastModifiedSelection, startDate, endDate)

        val allLists = listOf(
            filteredQuotesStatus,
            filteredQuotesByDate
        )

    // Filter non-empty lists from allLists
        val nonEmptyLists = allLists.filter { it.isNotEmpty() }

    // If all lists are empty, commonProducts will also be empty
        val commonProducts = if (nonEmptyLists.isNotEmpty()) {
            nonEmptyLists.reduce { acc, list ->
                val intersectedProducts = acc.filter { quote ->
                    list.any { it.retailquoteid == quote.retailquoteid } // Replace `retailquoteid` with the desired attribute
                }
                intersectedProducts.toList().toMutableList()
            }
        } else {
            mutableListOf() // Return an empty list if all lists are empty
        }

        commonProducts.forEach { quote ->
            quote.let { filterQuotes.add(it) }
        }

//        adapter.addQuotes(filterQuotes)
        adapter.submitList(filterQuotes)
        adapter.notifyItemRangeChanged(0, adapter.itemCount)
        //updating total count
//        adapter.notifyDataSetChanged()
        binding.searchNumbers.text=getString(R.string.quotes_search_numbers,filterQuotes.size.toString())


    }

    private fun filterByDate(
        filterQuotes: MutableList<Retailquote>,
        userLastModifiedSelection: Int,
        startDate: String,
        endDate: String
    ): MutableList<Retailquote> {
        val filteredQuotes: MutableList<Retailquote> = mutableListOf()
        when (userLastModifiedSelection){
            1 ->{
                //24 hours
                val temp : MutableList<Retailquote> = mutableListOf()
                filterQuotes.forEach { retailQuote ->
                    if (retailQuote.quoteinfo.createdon.isNotEmpty()){
                        if (isWithinLast24Hours(retailQuote.quoteinfo.createdon)){
                            temp.add(retailQuote)
                            filteredQuotes.add(retailQuote)
                        }
                    }
                }
            }2 ->{
                //7 days
            val temp : MutableList<Retailquote> = mutableListOf()
            filterQuotes.forEach { retailQuote ->
                if (retailQuote.quoteinfo.createdon.isNotEmpty()){
                    if (isWithinLast7Days(retailQuote.quoteinfo.createdon)){
                        temp.add(retailQuote)
                        filteredQuotes.add(retailQuote)
                    }
                }
            }
            }3 ->{
                //30 days
            val temp : MutableList<Retailquote> = mutableListOf()
            filterQuotes.forEach { retailQuote ->
                if (retailQuote.quoteinfo.createdon.isNotEmpty()){
                    if (isWithinLast30Days(retailQuote.quoteinfo.createdon)){
                        temp.add(retailQuote)
                        filteredQuotes.add(retailQuote)
                    }
                }
            }
            }4 ->{
                //custom range
            val temp : MutableList<Retailquote> = mutableListOf()
            if (startDate.isNotBlank() && startDate.isNotEmpty() && endDate.isNotEmpty() && endDate.isNotBlank()){
                filterQuotes.forEach { retailQuote ->
                    if (retailQuote.quoteinfo.createdon.isNotEmpty()){
                        if (isWithinCustomDateRange(retailQuote.quoteinfo.createdon, startDate, endDate)) {
                            temp.add(retailQuote)
                            filteredQuotes.add(retailQuote)
                        }
                    }
                }
            }else{
                toast("Please select the date range again.")
                return filterQuotes
            }
            }
            0 ->{
                //User selected None send all
                return filterQuotes
            }

        }
        //printing quotes filtered by date
        return filteredQuotes
    }

    private fun isWithinLast24Hours(createdOnString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val createdOnDate = dateFormat.parse(createdOnString)
        val currentDate = Date()
        val timeDifference = currentDate.time - createdOnDate.time
        val twentyFourHoursInMillis = 24 * 60 * 60 * 1000
        return timeDifference <= twentyFourHoursInMillis
    }

    private fun isWithinLast7Days(createdOnString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val createdOnDate = dateFormat.parse(createdOnString)
        val currentDate = Date()
        val timeDifference = currentDate.time - createdOnDate.time
        val sevenDaysInMillis = 7 * 24 * 60 * 60 * 1000
        return timeDifference <= sevenDaysInMillis
    }

    private fun isWithinLast30Days(createdOnString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val createdOnDate = dateFormat.parse(createdOnString)
        val currentDate = Date()
        val timeDifference = currentDate.time - createdOnDate.time

        val daysDifference = TimeUnit.MILLISECONDS.toDays(timeDifference)
        return daysDifference <= 30
    }

    private fun isWithinCustomDateRange(createdOnString: String, startDateString: String, endDateString: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val createdOnDate = dateFormat.parse(createdOnString)

        // Parse the start and end date provided by the user in "MMMM d, yyyy" format
        val customDateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
        val startDate = customDateFormat.parse(startDateString)
        val endDate = customDateFormat.parse(endDateString)

        // Add 1 day to the end date to include the entire range (inclusive)
        val endDateWithOneDayAdded = Date(endDate.time + TimeUnit.DAYS.toMillis(1))

        // Check if the "createdon" date is within the custom date range (inclusive)
        return createdOnDate in startDate..endDateWithOneDayAdded
    }

    private fun onclickFilter() {
        binding.filterQuotes.setOnClickListener {
            //send or set
            mainViewModel.setFilterOptionsQuotes(filterOptionQuotes)
            QuotesFilterFragment().show(requireActivity().supportFragmentManager, QuotesFilterFragment.TAG)
        }
    }

    private fun onEditForSearch() {
        binding.tvQuotesSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(searchKeyword: Editable?) {
                if (!searchKeyword?.trim().isNullOrEmpty()){
                    filterQuotes(searchKeyword?.trim().toString())
                }
            }
        })
    }

    private fun filterQuotes(keyword: String?) {
        val filteredQuotes: List<Retailquote> = retailQuote.filter { retailQuote ->
            retailQuote.consumerinfo.firstname.contains(keyword.toString(), true) ||
                    retailQuote.consumerinfo.lastname.contains(keyword.toString(), true) ||
                    retailQuote.quoteinfo.createdon.contains(keyword.toString(), true) ||
                    retailQuote.retailquoteid.contains(keyword.toString(), true) ||
                    retailQuote.quoteinfo.createdbyuserid.contains(keyword.toString(), true)
        }
//        adapter.addQuotes(filteredQuotes)
        adapter.submitList(filteredQuotes)
        adapter.notifyItemRangeChanged(0, adapter.itemCount)
//        adapter.notifyDataSetChanged()
        binding.searchNumbers.text=getString(R.string.quotes_search_numbers,filteredQuotes.size.toString())

    }

    private fun getStatus() {

        myQuotesViewModel.getRetailQuoteStatus(sharedPrefManager.getLocationNumber().toString())
    }

    private fun getQuotes() {
        val myOrderRequest = MyQuotesRequest()
        myOrderRequest.locationnumber=sharedPrefManager.getLocationNumber().toString()
        myOrderRequest.startdate=""
        myOrderRequest.enddate=""
        myQuotesViewModel.getMyQuotess(myOrderRequest)
        binding.noResults.gone()
        binding.progressbar.visible()
    }

    private fun bindObservers() {
        myQuotesViewModel.myQuotesResponseLiveData.observe(viewLifecycleOwner) { quoteData ->
            when (quoteData) {
                is NetworkResult.Success -> {
                    binding.progressbar.gone()
                    binding.withResults.visible()

                    quoteData.data?.let {

                        if (it.retailquote.isNotEmpty()) {

                            it.retailquote.let { it1 -> retailQuote = it1.toMutableList() }
//                            adapter.addQuotes(retailQuote)
                            //get saved working quotes if any
                            val toAddQuote = getWorkingQuotes()
                            if (toAddQuote != null) {
                                retailQuote.add(0, toAddQuote)
                            }
                            adapter.submitList(retailQuote)
                            adapter.notifyItemRangeChanged(0, adapter.itemCount)
                            //updating search result numbers
                            binding.searchNumbers.text=getString(R.string.quotes_search_numbers,retailQuote.size.toString())
//                            adapter.notifyDataSetChanged()
                        }else{
                            //get saved working quotes if any
                            retailQuote = mutableListOf()
                            val toAddQuote = getWorkingQuotes()
                            if (toAddQuote != null) {
                                retailQuote.add(0, toAddQuote)
                            }
                            if (retailQuote.isEmpty()){
                                noQuotesUISetup()
                            }else{
                                adapter.submitList(retailQuote)
                                adapter.notifyItemRangeChanged(0, adapter.itemCount)
                                //updating search result numbers
                                binding.searchNumbers.text=getString(R.string.quotes_search_numbers,retailQuote.size.toString())
                            }
                        }

                    }
                }
                is NetworkResult.Error -> {
                    binding.progressbar.gone()
                    binding.withResults.gone()
                    binding.noResults.visible()

                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }

        //for quote status
        myQuotesViewModel.quotesStatusLiveData.observe(viewLifecycleOwner) { quoteStatusData ->
            when (quoteStatusData) {
                is NetworkResult.Success -> {

                    val temp = quoteStatusData.data?.status
                    if (temp != null) {
                        quoteStatus = temp
                        val tempQuoteList = mutableListOf<FilterItem>()
                        quoteStatus.forEach { status ->
                            tempQuoteList.add(FilterItem(false, status))
                        }
                        tempQuoteList.add(FilterItem(false, "All Statuses"))
                        tempQuoteList.sortBy { filterItem ->
                            filterItem.name
                        }
                        filterOptionQuotes.Status = tempQuoteList

                        //for last modified
                        val lastModifiedList = mutableListOf<FilterItem>()
                        lastModifiedList.add(FilterItem(false, "None"))
                        lastModifiedList.add(FilterItem(false, "Last 24 Hours"))
                        lastModifiedList.add(FilterItem(false, "Last 7 Days"))
                        lastModifiedList.add(FilterItem(false, "Last 30 Days"))
                        lastModifiedList.add(FilterItem(false, "Specify Date Range"))
                        filterOptionQuotes.LastModified = lastModifiedList
                    }

                }
                is NetworkResult.Error -> {
                    println("ERROR?????" + quoteStatusData.message)


                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                }
            }
        }

        //adding for productCriteriaReq
        productByCriteriaViewModel.productByCriteriaResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {

                    println("it ->${it.data?.products}")
                    val fragment = EditQuoteFragment()
                    val result = Bundle()
                    result.putString(Constants.QUOTE_TO_SEND, Gson().toJson(quote))
                    result.putString(Constants.QUOTE_PRODUCT_TO_SEND, Gson().toJson(it.data))
                    result.putStringArrayList(Constants.QUOTE_STATUS_TO_SEND, ArrayList(quoteStatus))
                    fragment.arguments = result
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.bottomNavigationViewFrame, fragment)
                        .commit()
                }
                is NetworkResult.Error -> {

                    toast(it.message)

                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }
    }

    //section converting logic
    private fun getWorkingQuotes(): Retailquote? {
        val quote = Gson().fromJson(sharedPrefManager.getWorkingQuote(sharedPrefManager.getLocationNumber().toString()), Retailquote::class.java)
        if(quote != null){
            val quoteInfo = Quoteinfo("","","","","Working")
            quote.quoteinfo = quoteInfo
            val customerInfo = Consumerinfo("","Customer","Name")
            quote.consumerinfo = customerInfo
            quote.retailquoteid = ""
            val items :MutableList<Item> = mutableListOf()
            quote
            return quote
        }
        return null
    }

    private fun noQuotesUISetup() {
        binding.noResults.visible()
        binding.withResults.gone()
    }

    private fun onClickShopForProducts() {

        binding.shopForProducts.setOnClickListener {
            BottomNavigationScreenFragment.tvHeaderText?.text=""
            sharedPrefManager.getProfileSelected()?.let {
                if (it.equals("tirepros",true)){
                    BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)

                }else if (it.equals("atdonline",true)){
                    BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)


                } else {

                }
            }


            val hostFragment = HomeTabFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }
    }

    private fun setupUI() {
        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.my_quotes)
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            backPressed()
        }

//        adapter= MyQuotesAdapter(arrayListOf(), ::onClickQuote)
        adapter= ViewQuotesAdapter(::onClickQuote,requireActivity())

        binding.rvMyQuotes.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        binding.rvMyQuotes.adapter = adapter
    }

    private fun backPressed() {
        BottomNavigationScreenFragment.tvHeaderText?.text=""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)

            }else if (it.equals("atdonline",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)


            } else {

            }
        }
        val hostFragment = MyGarageFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .addToBackStack(null)
            .commit()

    }

    companion object {
        const val TAG = "ViewMyQuotesFragment"
    }

    private fun getTextFromSpeech() {
        binding.voiceLL.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.RECORD_AUDIO),
                    Constants.REQUEST_CODE
                )

            } else {
                performVoiceSearch()
            }
        }
    }

    private fun performVoiceSearch() {
        val speechDialog = AlertDialog.Builder(requireActivity(), R.style.WideDialog)

        val view: View =
            LayoutInflater.from(requireActivity()).inflate(R.layout.speech_layout, null)
        speechDialog.setView(view)

        val close = view.findViewById<ImageView>(R.id.ivClose)
        val tvHeader = view.findViewById<TextView>(R.id.tvHeader)
        val tvContent = view.findViewById<TextView>(R.id.tvSpeechToText)
        val ivWave = view.findViewById<ImageView>(R.id.ivWave)
        val ivMic = view.findViewById<TextView>(R.id.ivMic)
        val dialog = speechDialog.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialog.show()

        close.setOnClickListener {
            speechRecognizer.stopListening()
            dialog.dismiss()
            binding.tvQuotesSearch.setText(" ")

        }
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        ivMic.setOnClickListener {
            ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
            speechRecognizer.startListening(speechRecognizerIntent)
        }
        speechRecognizer.startListening(speechRecognizerIntent)
        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {

                tvHeader.text = getString(R.string.listening)
                ivMic.text = ""
                ivWave.visible()
                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_active)
                Glide.with(requireActivity()).asGif().load(R.raw.atd_mic_animation).into(ivWave)

            }

            override fun onBeginningOfSpeech() {
                tvHeader.text = getString(R.string.listening)
            }

            override fun onRmsChanged(rmsdB: Float) {


            }

            override fun onBufferReceived(buffer: ByteArray?) {

            }

            override fun onEndOfSpeech() {
                tvHeader.text = getString(R.string.searching)
                delayTimer(dialog)

            }

            override fun onError(error: Int) {

                tvHeader.text = getString(R.string.trayagain)
                ivMic.text = getString(R.string.tap_mic_search)

                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
                Glide.with(requireActivity()).load(R.drawable.wave).into(ivWave)

            }

            override fun onResults(results: Bundle?) {

                ivMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.mic_inactive)
                ivWave.gone()

                val data: ArrayList<String> =
                    results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                tvContent.text = data[0]
                binding.tvQuotesSearch.setText(tvContent.text.toString())

            }

            override fun onPartialResults(partialResults: Bundle?) {

                val data: ArrayList<String> =
                    partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
                tvContent.text = data[0]
                binding.tvQuotesSearch.setText(tvContent.text.toString())

            }

            override fun onEvent(eventType: Int, params: Bundle?) {

            }
        })
    }

    private fun delayTimer(alertDialog: AlertDialog) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                alertDialog.dismiss()
                timer.cancel()
            }
        }, 1500)
    }

//section onClickQuoteAdapter
    private fun onClickQuote(quote: Retailquote){
        this@ViewMyQuotesFragment.quote = quote
        println("Got Quote here ${quote.consumerinfo.firstname}")
        //calling products-by-criteria
        val productByCriteriaRequest = ProductByCriteriaRequest()
        val criteriaForProductSearchTire = Criteria()
        val listOfProductNumbers: MutableList<String> = mutableListOf()
        with(quote){
            if (items.isNullOrEmpty()){
                //mostly working status
                println("Came here ${consumerinfo.firstname}")
                products?.forEach { product ->
                    listOfProductNumbers.add(product.atdproductnumber)
                }
            }else{
                items.forEach { item ->
                    item.atdproductnumber?.let { listOfProductNumbers.add(it) }
                }
            }
        }
//        quote.items.forEach { item ->
//            item.atdproductnumber?.let { listOfProductNumbers.add(it) }
//        }
        criteriaForProductSearchTire.atdproductnumber = listOfProductNumbers
        productByCriteriaRequest.criteria = criteriaForProductSearchTire
        val options = Options()
        val price = Price()
        price.cost = 0
        price.retail = 0
        price.specialdiscount = 0
        price.fet = 0
        price.map = 0
        price.msrp = 0


        val availability = Availability()
        availability.local = 0
        availability.localplus = 0
        availability.nationwide = 0


        val images = Images()
        images.small = 1
        images.medium = 1
        images.large = 1
        images.thumbnail = 1

        options.availability = availability
        options.price = price
        options.images = images

        val productspec = Productspec()
        options.productspec = productspec
        options.includerebates = "false"
        options.includemarketingprograms = "false"
        productByCriteriaRequest.options = options
        productByCriteriaRequest.locationnumber = sharedPrefManager.getLocationNumber().toString()
        println("Request ->${Gson().toJson(productByCriteriaRequest)}")
        productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)


//        val fragment = EditQuoteFragment()
//        val result = Bundle()
//        result.putString(Constants.QUOTE_TO_SEND, Gson().toJson(quote))
//        fragment.arguments = result
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.bottomNavigationViewFrame, fragment)
//            .commit()
    }
}
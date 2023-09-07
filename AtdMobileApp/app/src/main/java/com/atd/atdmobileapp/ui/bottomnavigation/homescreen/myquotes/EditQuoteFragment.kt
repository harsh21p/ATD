package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentEditQuoteBinding
import com.atd.atdmobileapp.models.State
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.myquotes.Item
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.models.myquotes.SubTotalAddOns
import com.atd.atdmobileapp.models.myquotes.UpdateRequestBody
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class EditQuoteFragment : DialogFragment() {

    private var _binding: FragmentEditQuoteBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var retailquote: Retailquote
    private lateinit var productResponse: ProductByKeywordResponse
    private lateinit var quoteStatus : List<String>
    private lateinit var quoteFeesServicesAdapter: EditQuoteFeesAdapter
    private lateinit var quoteSubTotalFeeAdapter: EditQuoteSubTotalAdapter
    private lateinit var quoteProductParentAdapter: ProductParentAdapter
    private lateinit var quoteCommentAdapter : CommentsAdapter
    private lateinit var statusAdapter: StatusAdapter
    private var isStatusModified: Boolean = false
    private var isCommentAdded: Boolean = false
    private var commentToBeAdded = ""
    private var isConsumerInfoChanged: Boolean = false
    private var isSendToEmailClicked: Boolean = false
    private val myQuotesViewModel by viewModels<MyQuotesViewModel>()
    private val stateList = mutableListOf<State>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        _binding = FragmentEditQuoteBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        //getting bundle
        val result = arguments
        val quote = result?.getString(Constants.QUOTE_TO_SEND)
        val products = result?.getString(Constants.QUOTE_PRODUCT_TO_SEND)
        val statusList = result?.getStringArrayList(Constants.QUOTE_STATUS_TO_SEND)
        if (quote!= null){
            println("Quote ->${Gson().fromJson(quote, Retailquote::class.java)}")
            retailquote = Gson().fromJson(quote, Retailquote::class.java)
            retailquote.quoteaddons
        }
        if (products != null){
            productResponse = Gson().fromJson(products, ProductByKeywordResponse::class.java)
        }
        if (statusList != null){
            quoteStatus = statusList.toList()
        }

        makeStateList()
        bindObservers()

        if (retailquote.quoteinfo.status.equals("Working", true)){
            //section handle Working Status
            hideNotRequiredViews()
            showRequiredViewsWorkingQuotes()
            setupRecyclerViews()
            submitInitialListsForWorkingQuote()
        }else{
            setupQuoteDetails()
            setupRecyclerViews()
            submitInitialLists()
            onClickProducts()
            onclickCustomers()
            onClickViewComments()
            productClicked()
            onClickStatus()
            onClickAction()
            onClickUpdate()
            onClickForQuoteActionOptions()
        }
    }

    private fun onClickForQuoteActionOptions() {
        binding.emailQuote.setOnClickListener {
            //check if consumer required info exists
            if(checkRequiredInfo()){
                //we have everything
                isSendToEmailClicked = true
                makeUpdateAPICall()

            }else{
                //show dialogue box to fill required info
                showDialogEmail(2)
            }
        }

        binding.deleteQuote.setOnClickListener {
            //check if consumer required info exists
            if(checkRequiredInfo()){
                //we have everything
                //open delete dialogue frag
                DeleteQuoteFragment(retailquote, ::successQuoteDelete).show(requireActivity().supportFragmentManager, DeleteQuoteFragment.TAG)

            }else{
                //show dialogue box to fill required info
                showDialogEmail(2)
            }
        }
    }

    private fun successQuoteDelete(){
        backPressed()
    }

    private fun checkRequiredInfo(): Boolean {
        var isEmpty = true
        val fn = retailquote.consumerinfo.firstname
        val ln = retailquote.consumerinfo.lastname
        val email = retailquote.consumerinfo.email
        val phone = retailquote.consumerinfo.phone
        println("fn -> $fn,ln -> $ln,email -> $email,phone -> $phone, ")
        if (fn.isEmpty() || ln.isEmpty() || email.isEmpty() || phone.isNullOrEmpty()){
            isEmpty = false
        }
        return isEmpty
    }

    private fun makeStateList() {
        val inputStream = resources.openRawResource(R.raw.states)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val jsonString = String(buffer, Charsets.UTF_8)

        val jsonArray = JSONArray(jsonString)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val state = State(jsonObject.getString("value"), jsonObject.getString("code"))
            stateList.add(state)
        }
        println("StateList ->$stateList")
    }

    private fun onClickUpdate() {
        binding.ivUpdate.setOnClickListener {
            //for consumerInfo and comment add
            if (isConsumerInfoChanged || isCommentAdded){
                makeUpdateAPICall()
            }
        }
    }

    private fun bindObservers() {
        myQuotesViewModel.updateQuoteLiveData.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Error -> {
                    toast(it.message)
                }

                is NetworkResult.Loading -> {

                }
                is NetworkResult.Success -> {
                    if(isSendToEmailClicked){
                        isSendToEmailClicked = false
                        //show dialogue for email sent
                        showDialogEmail(1)
                        expandCloseQuoteAction()
                    }else{
                        showDialog()
                    }
                }
            }
        }
    }

    private fun showRequiredViewsWorkingQuotes() {
        binding.llProducts.visible()
        binding.tvEmailText.visible()
        binding.etEmailText.visible()
    }

    private fun hideNotRequiredViews() {
        binding.tvDate.gone()
        binding.tvQuotedBy.gone()
        binding.tvQuoteNumber.gone()
        binding.viewS.gone()
        binding.clTop.gone()
    }

    private fun onClickAction() {
        binding.tvQuoteAction.setOnClickListener {
            expandCloseQuoteAction()
        }
    }

    private fun expandCloseQuoteAction() {
        if (binding.llQuoteActions.tag.equals(getString(R.string.expand))) {
            binding.llQuoteActions.visible()
            binding.llQuoteActions.bringToFront()
            binding.llQuoteActions.tag = getString(R.string.collapse)
        } else {
            if (binding.llQuoteActions.tag.equals(getString(R.string.collapse))) {
                binding.llQuoteActions.gone()
                binding.llQuoteActions.tag = getString(R.string.expand)
            }
        }
    }

    private fun onClickStatus() {
        val viewsToClick = listOf<View>(binding.dropDownStatus, binding.tvStatus, binding.ivStatusQuote)
        viewsToClick.forEach { view ->
            view.setOnClickListener {
                if (binding.rvStatus.tag.equals(getString(R.string.expand))){
                    binding.rvStatus.visible()
                    binding.rvStatus.tag = getString(R.string.collapse)
                }else{
                    if (binding.rvStatus.tag.equals(getString(R.string.collapse))){
                        binding.rvStatus.gone()
                        binding.rvStatus.tag = getString(R.string.expand)
                    }
                }
            }
        }
    }

    private fun onClickViewComments() {
        binding.tvComments.setOnClickListener {
            if (binding.tvComments.tag.equals(getString(R.string.expand))){
                binding.rvComments.visible()
                binding.tvComments.tag = getString(R.string.collapse)
                binding.tvComments.background = ContextCompat.getDrawable(requireContext(), R.drawable.comments_expended)
                //TODO need to set scroll to bottom
                binding.nestedScrollQuotes.smoothScrollTo(0, binding.nestedScrollQuotes.height)
            }else{
                binding.rvComments.gone()
                binding.tvComments.tag = getString(R.string.expand)
                binding.tvComments.background = ContextCompat.getDrawable(requireContext(), R.drawable.quotes_comments)

            }
        }
    }

    private fun setupQuoteDetails() {
        setStatus()
        setComments()
        binding.tvQuoteNumber.text = buildString {
            append(getString(R.string.quote))
            append(" ")
            append(retailquote.retailquoteid)
        }
        binding.tvQuotedBy.text = buildString {
            append(getString(R.string.quoted_by))
            append(retailquote.quoteinfo.createdbyuserid)
        }
        binding.tvDate.text = formatDateString(retailquote.quoteinfo.createdon)

    }

    private fun setComments() {
        binding.rvComments.gone()
        if (retailquote.quotecomments.isNotEmpty()){
            binding.tvComments.text = buildString {
                append("View Previous Comments(${retailquote.quotecomments.size})")
            }
        }else{
            binding.tvComments.gone()
        }
    }

    private fun formatDateString(inputDate: String?): String {
        if (inputDate.isNullOrEmpty()) {
            return "Invalid Date"
        }

        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            val date: Date = inputFormat.parse(inputDate) as Date
            val outputFormat = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
            outputFormat.format(date)
        } catch (e: ParseException) {
            "Invalid Date"
        }
    }


    private fun setStatus() {
        val statusDrawableMap = mapOf(
            "Converted" to R.drawable.green,
            "Closed" to R.drawable.red,
            "Deleted" to R.drawable.red
        )

        val defaultDrawableResId = R.drawable.yellow

        val status = retailquote.quoteinfo.status
        val drawableResId = statusDrawableMap[status] ?: defaultDrawableResId
        binding.ivStatusQuote.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                drawableResId
            )
        )
        binding.tvStatus.text = retailquote.quoteinfo.status
    }

    private fun onclickCustomers() {
        binding.tvCustomerInfo.setOnClickListener {
            binding.tvCustomerInfo.setTextColor(ContextCompat.getColor(requireContext(), theameColor))
            binding.tvProducts.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            customerInfoClicked()
        }
    }

    private fun onClickProducts() {
        binding.tvProducts.setOnClickListener {
            binding.tvProducts.setTextColor(ContextCompat.getColor(requireContext(), theameColor))
            binding.tvCustomerInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            productClicked()
        }
    }

    private fun customerInfoClicked() {
        binding.llProducts.gone()
        binding.llCustomer.visible()
        setupCustomerView()
        setupOnEditForConsumerDetail()
    }

    private fun setupOnEditForConsumerDetail() {
        binding.etFirstName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    binding.tvWarningFirstName.gone()
                    retailquote.consumerinfo.firstname = s.toString()
                }else{
                    binding.tvWarningFirstName.visible()
                }
            }

        })

        //for last name
        binding.etLastName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    binding.tvWarningLastName.gone()
                    retailquote.consumerinfo.lastname = s.toString()
                }else{
                    binding.tvWarningLastName.visible()
                }
            }

        })

        //for email
        binding.etEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    binding.tvWarningEmail.gone()
                    retailquote.consumerinfo.email = s.toString()
                }else{
                    binding.tvWarningEmail.visible()
                }
            }

        })

        //for phone
        binding.etPhone.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    binding.tvWarningPhone.gone()
                    retailquote.consumerinfo.phone = s.toString()
                }else{
                    binding.tvWarningPhone.visible()
                }
            }

        })

        //for street address
        binding.etStreetAddress.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    retailquote.consumerinfo.address1 = s.toString()
                }
            }

        })

        //for apt, suite
        binding.etAptSuite.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    retailquote.consumerinfo.address2 = s.toString()
                }
            }

        })

        //for zipcode
        binding.etZipCode.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    retailquote.consumerinfo.zipcode = s.toString()
                }
            }

        })

        //for city
        binding.etCity.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isConsumerInfoChanged = true
                if (s.toString().isNotEmpty()){
                    retailquote.consumerinfo.zipcode = s.toString()
                }
            }

        })

        //for state
        binding.etState.setOnClickListener {
            SelectStateFragment(stateList, ::onStateClicked, binding.etState.text.toString()).show(requireActivity().supportFragmentManager, SelectStateFragment.TAG)
        }
    }

    private fun onStateClicked(item: State){
        isConsumerInfoChanged = true
        binding.etState.text = item.value
        if (item.value.isNotEmpty()){
            retailquote.consumerinfo.state = item.code
        }
    }

    private fun setupCustomerView() {
        binding.etFirstName.setText(retailquote.consumerinfo.firstname)
        if (retailquote.consumerinfo.firstname.isNotEmpty()){
            binding.tvWarningFirstName.gone()
        }

        binding.etLastName.setText(retailquote.consumerinfo.lastname)
        if (retailquote.consumerinfo.lastname.isNotEmpty()){
            binding.tvWarningLastName.gone()
        }

        binding.etEmail.setText(retailquote.consumerinfo.email)
        if (retailquote.consumerinfo.email.isNotEmpty()){
            binding.tvWarningEmail.gone()
        }

        binding.etPhone.setText(retailquote.consumerinfo.phone)
        if (retailquote.consumerinfo.phone?.isNotEmpty() == true){
            binding.tvWarningPhone.gone()
        }

        binding.etStreetAddress.setText(retailquote.consumerinfo.address1)
        binding.etAptSuite.setText(retailquote.consumerinfo.address2)
        binding.etZipCode.setText(retailquote.consumerinfo.zipcode)
        binding.etCity.setText(retailquote.consumerinfo.city)
        binding.etState.setText(retailquote.consumerinfo.state)
    }


    private fun productClicked() {
        binding.llCustomer.gone()
        binding.llProducts.visible()
        commentUpdateListener()
        submitInitialLists()
    }

    private fun commentUpdateListener() {
        //for comments
        binding.etComments.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isCommentAdded = true
                if (s.toString().isNotEmpty()){
                    commentToBeAdded = s.toString()
                }
            }

        })
    }


    private fun submitInitialLists() {
        quoteFeesServicesAdapter.submitList(retailquote.quoteaddons)

        //for subtotal
        val  temp : MutableList<SubTotalAddOns> = retailquote.quotesummary.subtotaladdons.toMutableList()
        temp.add(SubTotalAddOns(name = "Subtotal", linetotal = retailquote.quotesummary.subtotal.replace("$","").replace(",","").toFloat()))
        temp.add(SubTotalAddOns(name = "Tax", linetotal = retailquote.quotesummary.taxtotal.replace("$","").replace(",","").toFloat()))
        temp.add(SubTotalAddOns(name = "TOTAL", linetotal = retailquote.quotesummary.total.replace("$","").replace(",","").toFloat()))

        quoteSubTotalFeeAdapter.submitList(temp)

        println("Products as ->${Gson().toJson(productResponse.products)}")
        println("Size  ->${productResponse.products.size}")
        quoteProductParentAdapter.submitList(productResponse.products)
        quoteProductParentAdapter.addItem(item = retailquote.items as MutableList<Item>)

        quoteCommentAdapter.submitList(retailquote.quotecomments)

        statusAdapter.submitList(quoteStatus)

    }

    private fun submitInitialListsForWorkingQuote() {
        quoteFeesServicesAdapter.submitList(retailquote.quoteaddons)

        //for subtotal
        val  temp : MutableList<SubTotalAddOns> =  mutableListOf()//retailquote.quotesummary.subtotaladdons.toMutableList()
//        temp.add(SubTotalAddOns(name = "Subtotal", linetotal = retailquote.quotesummary.subtotal.replace("$","").replace(",","").toFloat()))
//        temp.add(SubTotalAddOns(name = "Tax", linetotal = retailquote.quotesummary.taxtotal.replace("$","").replace(",","").toFloat()))
//        temp.add(SubTotalAddOns(name = "TOTAL", linetotal = retailquote.quotesummary.total.replace("$","").replace(",","").toFloat()))

        quoteSubTotalFeeAdapter.submitList(temp)

        println("Products as in working q->${Gson().toJson(productResponse.products)}")
        println("Size in working ->${productResponse.products.size}")
        quoteProductParentAdapter.isWorkingQuote = true
        quoteProductParentAdapter.submitList(productResponse.products)
        quoteProductParentAdapter.addItem(item = mutableListOf())

//        quoteProductParentAdapter.addItem(item = retailquote.items as MutableList<Item>)

        quoteCommentAdapter.submitList(retailquote.quotecomments)

        statusAdapter.submitList(quoteStatus)

    }

    private fun setupRecyclerViews() {
        quoteFeesServicesAdapter = EditQuoteFeesAdapter()
        binding.rcQuoteFees.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rcQuoteFees.adapter = quoteFeesServicesAdapter
        binding.rcQuoteFees.isNestedScrollingEnabled = false

        //for subtotal
        quoteSubTotalFeeAdapter = EditQuoteSubTotalAdapter()
        binding.rvSubTotalFeesServices.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvSubTotalFeesServices.adapter = quoteSubTotalFeeAdapter
        binding.rvSubTotalFeesServices.isNestedScrollingEnabled = false

        //for product parent
        quoteProductParentAdapter = ProductParentAdapter()
        binding.rcItem.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rcItem.adapter = quoteProductParentAdapter
        binding.rcItem.isNestedScrollingEnabled = false

        //for comments
        quoteCommentAdapter = CommentsAdapter()
        binding.rvComments.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.rvComments.adapter = quoteCommentAdapter
        binding.rvComments.isNestedScrollingEnabled = false

        //for status
        statusAdapter = StatusAdapter(::onClickQuotesStatus)
        binding.rvStatus.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvStatus.adapter = statusAdapter
        binding.rvStatus.bringToFront()


    }

    private fun setupUI() {
        binding.tvProducts.setTextColor(ContextCompat.getColor(requireContext(), theameColor))
        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.quotes_details)
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            backPressed()
        }


        if (theameColor==R.color.atd_blue){
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)
            binding.ivSearch.setImageResource(R.drawable.add_to_cart_quotes)
        }else{
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
            binding.ivSearch.setImageResource(R.drawable.add_to_cart_quotes_tirepros)
        }
        binding.ivUpdate.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.dropDownStatus.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.ivDropDownQuoteAction.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.etComments.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.etEmailText.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.tvComments.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view1.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view2.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view3.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view4.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view5.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view6.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view7.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view8.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view9.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view11.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.view22.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.viewDivider9.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.viewS.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.ivStateIndicator.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
       binding.deleteQuote.setTextColor(ContextCompat.getColorStateList(requireContext(), theameColor))
       binding.emailQuote.backgroundTintList=(ContextCompat.getColorStateList(requireContext(), theameColor))

    }

    private fun onClickQuotesStatus(item: String){
        binding.tvStatus.text = item
        binding.ivStatusQuote.setImageResource(setStatusImage(item))
        binding.rvStatus.gone()
        isStatusModified = true
        //make the API call to update
        makeUpdateAPICall()
    }

    private fun makeUpdateAPICall() {
        val requestBody = makeUpdateRequestBody()
        //making API call
        println("Trial print req ->${Gson().toJson(requestBody)}")
        myQuotesViewModel.updateRetailQuote(requestBody)
    }

    private fun makeUpdateRequestBody(): UpdateRequestBody {

        val requestBody = UpdateRequestBody()

        requestBody.locationnumber = sharedPrefManager.getLocationNumber().toString()

        //setting phone no and area code
        val consumerInfo = retailquote.consumerinfo
        val (areaCode, phoneNumberPart) = extractAreaCodeAndNumber(retailquote.consumerinfo.phone)
        consumerInfo.areacode = areaCode
        consumerInfo.phone = phoneNumberPart
        requestBody.consumerinfo = consumerInfo ///consumer info updated


        requestBody.quoteid = retailquote.retailquoteid
        //check is status is changed
        if (isStatusModified){
            requestBody.quotestatus = binding.tvStatus.text.toString()
        }
        //to add change for comment and consumerinfo
        //consumer info updated in requestBody.consumerinfo = consumerInfo

        //adding comment
        if (isCommentAdded){
            requestBody.quotecomment = commentToBeAdded
        }

        //adding send email
        if (isSendToEmailClicked){
            requestBody.sendemailtoconsumer = true
        }

        return requestBody
    }

    private fun extractAreaCodeAndNumber(phoneNumber: String?): Pair<String, String> {
        // Return empty strings if phoneNumber is null
        if (phoneNumber == null) {
            return Pair("", "")
        }

        // Remove non-digit characters from the phone number
        val digitsOnly = phoneNumber.replace(Regex("\\D"), "")

        // Extract the area code (first 3 digits) and phone number (last 7 digits)
        val areaCode = if (digitsOnly.length >= 3) digitsOnly.substring(0, 3) else ""
        val phoneNumberPart = if (digitsOnly.length >= 10) {
            val part = digitsOnly.substring(3, 10)
            "${part.substring(0, 3)}-${part.substring(3, 7)}"
        } else {
            ""
        }

        return Pair(areaCode, phoneNumberPart)
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
        val fragment = ViewMyQuotesFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, fragment)
            .commit()
    }

    private fun setStatusImage(status: String): Int {
        val statusDrawableMap = mapOf(
            "Converted" to R.drawable.green,
            "Closed" to R.drawable.red,
            "Deleted" to R.drawable.red
        )

        val defaultDrawableResId = R.drawable.yellow

        val status = status
        return statusDrawableMap[status] ?: defaultDrawableResId
    }

    companion object {
        const val TAG = "editQuoteFragment"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun showDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_quotes_saved)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialog.findViewById(R.id.tvYes) as TextView
        okText.setOnClickListener {
            backPressed()
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showDialogEmail(case: Int) {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_quotes_saved)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val okText = dialog.findViewById(R.id.tvYes) as TextView
        val titleText = dialog.findViewById(R.id.tvTitle) as TextView
        val descp = dialog.findViewById(R.id.tvDescription) as TextView
        when(case){
            1 -> {
                titleText.text = getString(R.string.success_quotes)
                descp.text = getString(R.string.mail_sent)
            }

            2-> {
                titleText.text = getString(R.string.email_qupte)
                descp.text = buildString {
        append("All required customer information must be\nentered to complete this function.")
    }
            }
        }
        okText.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
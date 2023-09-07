package com.atd.atdmobileapp. ui.bottomnavigation.homescreen.myorders

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentMyOrdersSearchBinding
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.Orderstatuse
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdLogo
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.StringToDate
import com.atd.atdmobileapp.utils.Common.StringToPreviousDate
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@AndroidEntryPoint
class MyOrdersSearchFragment() : Fragment() {


    var fromDate:Int=0
    lateinit var selectedSearchItem: TextView
    var _binding : FragmentMyOrdersSearchBinding?=null
    private val binding get() = _binding!!
    var orderstatuses: List<Orderstatuse>? =null
    var filterOrderstatuses: List<Orderstatuse>? =null
    lateinit var   adapter : MyOrdersSearchAdapter
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private val myOrdersViewModel by viewModels<MyOrdersViewModel>()

    var startDateValue: String? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        _binding= FragmentMyOrdersSearchBinding.inflate(inflater,container,false)
        val root : View = binding.root
        orderstatuses= listOf()
        filterOrderstatuses= listOf()


        setupUI()
        sharedPrefManager.getLocationNumber()?.let {

            val myOrderRequest = MyOrderRequest()
            myOrderRequest.locationnumber=sharedPrefManager.getLocationNumber().toString()
            myOrdersViewModel.getMyOrders(myOrderRequest)
            binding.progressbar.visibility = View.VISIBLE

        }

        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.my_orders)

        atdLogo?.setOnClickListener {
            BackPressed()
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.ivKeywordSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.rlSearch.background=ContextCompat.getDrawable(requireContext(),R.drawable.red_baseline_rectangle_24)
                binding.rlSearchDates.background=ContextCompat.getDrawable(requireContext(),R.drawable.red_baseline_rectangle_24)
                binding.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.tvOrdersPlacesList.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.tvLast7Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
                binding.tvLast30Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
                binding.tvLast90Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
                binding.tvDateRange.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

            }else if (it.equals("atdonline",true)){
                binding.ivKeywordSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.rlSearch.background=ContextCompat.getDrawable(requireContext(),R.drawable.baseline_rectangle_24)
                binding.rlSearchDates.background=ContextCompat.getDrawable(requireContext(),R.drawable.baseline_rectangle_24)
                binding.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.tvOrdersPlacesList.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.tvLast7Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue))
                binding.tvLast30Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue))
                binding.tvLast90Days.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue))
                binding.tvDateRange.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue))
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

            }else{
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

            }
        }


        binding.tvOrdersPlacesList.setOnClickListener {

            if ( binding.llSearchOptions.visibility==View.GONE) {
                binding.llSearchOptions.visible()
                binding.tvOrdersPlacesList.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.arrow_up,
                    0
                )
            }else{
                binding.llSearchOptions.gone()
                binding.tvOrdersPlacesList.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.arrow_down,
                    0
                )
            }
            sharedPrefManager.getProfileSelected()?.let {
                if (it.equals("tirepros",true)){
                    binding.tvOrdersPlacesList.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)

                }else if (it.equals("atdonline",true)){
                    binding.tvOrdersPlacesList.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)

                }

        }
        }
        binding.tvLast7Days.setOnClickListener {
            selectSearchOption(binding.tvLast7Days,7)
        }
        binding.tvLast30Days.setOnClickListener {
            selectSearchOption(binding.tvLast30Days,30)
        }
        binding.tvLast90Days.setOnClickListener {
            selectSearchOption(binding.tvLast90Days,90)
        }
        binding.tvDateRange.setOnClickListener {
            //selectSearchOption(binding.tvDateRange,0)
            dateRangeSearch()
        }

        binding.tvKeywordSearch.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(searchWord: Editable?) {

                if (searchWord?.trim()?.length!! >0) {
                    filterOrderstatuses = orderstatuses?.filter { orders ->
                        orders.customerponumber.lowercase().contains(searchWord.toString().lowercase())
                                || orders.confirmationnumber.lowercase().contains(searchWord.toString().lowercase())
                    }


                    filterOrderstatuses?.let {
                        if (it.size>0) {
                            addOrders(it, searchWord.toString())
                        }else{
                            binding.noData.text="There are no search results that much with ${'"'}${searchWord}${'"'}"
                            binding.noData.visible()
                            binding.noData2.visible()
                            adapter.addOrders(it)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }else{
                    selectSearchOption(selectedSearchItem,fromDate)
                }

            }
        })

        binding.tvShopForProducts.setOnClickListener {
           BackPressed()
        }

        return root
    }

    private fun dateRangeSearch() {

        binding.llSearchOptions.gone()
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.dialog_date_range)
        val cancel : TextView= dialog.findViewById(R.id.btReset)
        val apply : TextView= dialog.findViewById(R.id.tvProductSearch)
        val tvStartDate : TextView= dialog.findViewById(R.id.tvStartDate)
        val tvStartDateValue : TextView= dialog.findViewById(R.id.tvStartDateValue)
        val tvEndDate : TextView= dialog.findViewById(R.id.tvEndDate)
        val tvEndDateValue : TextView= dialog.findViewById(R.id.tvEndDatevalue)
        val tvErrorMessage : TextView= dialog.findViewById(R.id.tvErrorMessage)

        tvStartDate.setOnClickListener {
            startDateValue=null
            datePicker(tvStartDateValue,tvEndDateValue,tvEndDate,"startDate",apply,tvErrorMessage)
        }

        tvEndDate.setOnClickListener {

            if (startDateValue==null&&!tvStartDateValue.text.equals("")){
                val parser = SimpleDateFormat("dd-MM-yyyy")
                val formatter = SimpleDateFormat("MMMM dd ,yyyy")
                startDateValue = parser.format(formatter.parse(tvStartDateValue.text.toString()))
                println("startDateValue $startDateValue")
            }
            datePicker(tvStartDateValue,tvEndDateValue,tvEndDate,"endDate",apply,tvErrorMessage)
        }
        cancel.text="Cancel"
        apply.text="Apply"
        cancel.isEnabled=true
        tvEndDate.isEnabled=false

        apply.isEnabled=false
        apply.setTextColor(ContextCompat.getColor(
            requireActivity(),
            R.color.disableText
        ))
        cancel.setTextColor(ContextCompat.getColor(
            requireActivity(),
            R.color.atd_blue
        ))

        apply.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.disable_background))

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){

                cancel.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.red
                ))
                tvStartDate.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.red
                ))
                tvStartDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.red))

                tvEndDate.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.atd_disable_red
                ))
                tvEndDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.atd_disable_red))

            }else if (it.equals("atdonline",true)){

                cancel.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.atd_blue
                ))
                tvStartDate.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.atd_blue
                ))
                tvStartDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.atd_blue))

                tvEndDate.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.atd_blue_disable
                ))
                tvEndDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.atd_blue_disable))


            }

        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }

        apply.setOnClickListener {

            val parser = SimpleDateFormat("yyyy-MM-dd")
            val formatter = SimpleDateFormat("MMMM dd ,yyyy")
            val startDateValue = parser.format(formatter.parse(tvStartDateValue.text.toString()))
            val endDateValue = parser.format(formatter.parse(tvEndDateValue.text.toString()))
            println("Date $startDateValue $endDateValue")

            sharedPrefManager.getLocationNumber()?.let {

                binding.progressbar.visibility = View.VISIBLE

                val orderReq= JSONObject()
                orderReq.put("locationnumber",sharedPrefManager.getLocationNumber().toString())
                val criteriaReq= JSONObject()

                val startArray= JSONArray()
                startArray.put(startDateValue)
                val endArray= JSONArray()
                endArray.put(endDateValue)

                criteriaReq.put("end date",endArray)
                criteriaReq.put("start date",startArray)
                orderReq.put("criteria",criteriaReq)

                val body: RequestBody = RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    orderReq.toString()
                )
                myOrdersViewModel.getDateRangeOrders(body)
                OrdersData()

                println("orders data ==> $orderReq")
                dialog.dismiss()
                binding.tvLast7Days.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.white))
                binding.tvLast30Days.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.white))
                binding.tvLast90Days.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.white))

                sharedPrefManager.getProfileSelected()?.let {
                    if (it.equals("tirepros",true)){
                        binding.tvDateRange.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.red))
                        binding.tvDateRange.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))
                        binding.tvLast7Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
                        binding.tvLast30Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
                        binding.tvLast90Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))

                    }else if (it.equals("atdonline",true)){

                        binding.tvDateRange.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.atd_blue))
                        binding.tvDateRange.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))
                        binding.tvLast7Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.atd_blue))
                        binding.tvLast30Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.atd_blue))
                        binding.tvLast90Days.setTextColor(ContextCompat.getColor(requireActivity(), R.color.atd_blue))


                    }
                }


            }
        }
        dialog.show()
    }

    fun datePicker(
        startdate: TextView,
        tvEndDateValue: TextView,
        tvEndDate: TextView,
        type: String,
        apply: TextView,
        tvErrorMessage: TextView,
    ){

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(requireActivity(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            val month : Int = monthOfYear.toInt()+1
            val selecteDate : String = ("" + month + "/" + dayOfMonth + "/" + year)
            val parser = SimpleDateFormat("MM/dd/yyyy")
            val formatter = SimpleDateFormat("MMMM dd ,yyyy")
            val output = formatter.format(parser.parse(selecteDate))
            if (type.equals("startDate",true)){
                startDateValue=(""+dayOfMonth+"-"+month+"-"+year)
                tvEndDateValue.text=""
                startdate.text=output
                tvEndDate.isEnabled=true

                sharedPrefManager.getProfileSelected()?.let {
                    if (it.equals("tirepros",true)){
                        tvEndDate.setTextColor(ContextCompat.getColor(
                            requireActivity(),
                            R.color.red
                        ))
                        tvEndDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.red))

                    }else if (it.equals("atdonline",true)){
                        tvEndDate.setTextColor(ContextCompat.getColor(
                            requireActivity(),
                            R.color.atd_blue
                        ))
                        tvEndDate.compoundDrawableTintList = ColorStateList.valueOf(resources.getColor(R.color.atd_blue))

                    }
                }
                apply.isEnabled=false
                apply.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.disableText
                ))
                apply.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.disable_background))
            }else{


                tvEndDateValue.text=output

                apply.isEnabled=true
                apply.setTextColor(ContextCompat.getColor(
                    requireActivity(),
                    R.color.white
                ))

                sharedPrefManager.getProfileSelected()?.let {
                    if (it.equals("tirepros",true)){
                        apply.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.red))

                    }else if (it.equals("atdonline",true)){
                        apply.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.atd_blue))
                    }
                }

                val endDateValue=(""+dayOfMonth+"-"+month+"-"+year)
                var enddate: Date? = null
                var strdate: Date? = null

                try {
                    val sdf = SimpleDateFormat("dd-MM-yyyy")
                    enddate = sdf.parse(endDateValue)
                    strdate=sdf.parse(startDateValue)

                } catch (e: ParseException) {
                    e.printStackTrace()
                }
                val diff : Long = enddate?.time!! - strdate?.time!!
                val days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
                if (days>90){

                    tvErrorMessage.visible()
                    tvErrorMessage.text=Constants.date_range_90
                    apply.isEnabled=false
                    apply.setTextColor(ContextCompat.getColor(
                        requireActivity(),
                        R.color.disableText
                    ))
                    apply.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.disable_background))
                }else{
                    tvErrorMessage.gone()
                }
            }


           println("selected date "+selecteDate)
        }, year, month, day)

        //set min date in calender to disable unnecessary dates
        if (startDateValue!=null) {
            var date: Date? = null

            try {
                val sdf = SimpleDateFormat("dd-MM-yyyy")
                date = sdf.parse(startDateValue)
                dpd.getDatePicker().minDate = date?.time!!
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }

        //set max date in calender to disable unnecessary dates
        dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
        dpd.setCancelable(false)
        dpd.show()

    }


    private fun selectSearchOption(selectedSearchItem: TextView, fromDate: Int) {

        this.selectedSearchItem=selectedSearchItem
        this.fromDate =fromDate
        binding.tvLast7Days.setBackgroundColor(
            ContextCompat.getColor(
                requireActivity(),
                R.color.white
            )
        )

        binding.tvLast30Days.setBackgroundColor(
            ContextCompat.getColor(
                requireActivity(),
                R.color.white
            )
        )

        binding.tvLast90Days.setBackgroundColor(
            ContextCompat.getColor(
                requireActivity(),
                R.color.white
            )
        )

        binding.tvDateRange.setBackgroundColor(
            ContextCompat.getColor(
                requireActivity(),
                R.color.white
            )
        )

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){

                binding.tvLast7Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )
                binding.tvLast30Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )
                binding.tvLast90Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )
                binding.tvDateRange.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )
                selectedSearchItem.setBackgroundColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )

            }else if (it.equals("atdonline",true)){
                binding.tvLast7Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.atd_blue
                    )
                )
                binding.tvLast30Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.atd_blue
                    )
                )
                binding.tvLast90Days.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.atd_blue
                    )
                )
                binding.tvDateRange.setTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.atd_blue
                    )
                )
                selectedSearchItem.setBackgroundColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.atd_blue
                    )
                )
            }
        }



        binding.tvOrdersPlacesList.text = selectedSearchItem.text.toString()

        selectedSearchItem.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))
        binding.llSearchOptions.gone()
        binding.tvOrdersPlacesList.setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.arrow_down,
            0
        )
        filterOrderstatuses= orderstatuses?.filter { dates -> StringToDate(dates.dateplaced).after(StringToPreviousDate(fromDate)) && StringToDate(dates.dateplaced).before(StringToPreviousDate(-1)) }

        filterOrderstatuses?.let { addOrders(it, fromDate.toString()) }

        println("filter Data : $orderstatuses ")

    }


    fun BackPressed() {

        /*atdLogo?.setOnClickListener(null)
        BottomNavigationScreenFragment.tvHeaderText?.text=""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)
                println("logo ===> $it")

            }else if (it.equals("atdonline",true)){
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)
                println("logo ===> $it")


            }
        }*/
       /* val hostFragment = HomeTabFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()*/
        findNavController().navigate(R.id.action_myordersSearchFragment_to_BottomNavigation)

    }

    private fun setupUI() {
        adapter= MyOrdersSearchAdapter(arrayListOf(),requireActivity())
        binding.rvMyOrders.layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        binding.rvMyOrders.adapter = adapter
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myOrdersViewModel.myOrderResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it.data?.let {

                        if (it.orderstatuses.size>0) {
                            orderstatuses = it.orderstatuses
                            selectSearchOption(binding.tvLast7Days, 7)
                        }else{
                            binding.tvSearch.gone()
                            binding.rlSearch.gone()
                            binding.rlSearchDates.gone()
                            binding.rvMyOrders.gone()
                            binding.noData.visible()
                            binding.noData2.visible()
                            binding.ivNoOrders.visible()
                            binding.tvShopForProducts.visible()


                        }


                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)
                    binding.progressbar.visibility = View.GONE

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    binding.progressbar.visibility = View.VISIBLE
                }
            }
        })


    }

    private fun OrdersData() {

        myOrdersViewModel.myOrderDateRangeResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it.data?.let {

                        addDateRangeOrders(it.orderstatuses)
                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)
                    binding.progressbar.visibility = View.GONE

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    binding.progressbar.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun addOrders(orderstatuse: List<Orderstatuse>, days: String) {

        filterOrderstatuses=orderstatuse
        filterOrderstatuses?.let {
            if (it.size>0) {
                binding.noData.gone()
                binding.noData2.gone()
                adapter.addOrders(it)
                adapter.notifyDataSetChanged()
            }else{

                binding.noData.text="There are no orders from the last $days days."
                binding.noData.visible()
                binding.noData2.visible()
                adapter.addOrders(it)
                adapter.notifyDataSetChanged()

            }
        }
    }

    private fun addDateRangeOrders(orderstatuse: List<Orderstatuse>) {

        binding.tvOrdersPlacesList.text=Constants.dateRange

        orderstatuse?.let {
            if (it.size>0) {
                binding.noData.gone()
                binding.noData2.gone()
                adapter.addOrders(it)
                adapter.notifyDataSetChanged()
            }else{

                binding.noData.text="No Results found. Please try again"
                binding.noData.visible()
                binding.noData2.visible()
                adapter.addOrders(it)
                adapter.notifyDataSetChanged()

            }
        }
    }



}
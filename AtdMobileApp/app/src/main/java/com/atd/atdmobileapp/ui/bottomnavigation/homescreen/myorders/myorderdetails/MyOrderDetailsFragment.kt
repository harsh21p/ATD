package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.databinding.AlertBinding
import com.atd.atdmobileapp.databinding.FragmentMyOrderDetailsBinding
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.approveorder.ApproveOrder
import com.atd.atdmobileapp.models.keywordsearch.*
import com.atd.atdmobileapp.models.myapprovals.Orderapproval
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.badgeCount
import com.atd.atdmobileapp.ui.bottomnavigation.ConfigLocationViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersSearchFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.ProductByKeywordViewModel
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import javax.inject.Inject

@AndroidEntryPoint
class MyOrderDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = MyOrderDetailsFragment()
    }

    private var showToast: Boolean=false
    private var theameColor: Int= R.color.black
    var location: String?=null
     var confirmationNumber: String?=null
    private lateinit var adapter: MyOrdersDetailsAdapter
    private lateinit var approvalDetailsAdapter: ApprovalOrderDetailsAdapter
    var _binding : FragmentMyOrderDetailsBinding?=null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MyOrderDetailsViewModel>()
    private val submitApprovalsViewModel by viewModels<SubmitApprovalsViewModel>()
    private val permissionViewModel by viewModels<LoginViewModel>()
    var orderStatus:String?=null
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    private var keyWords : ArrayList<String>? = null
    private val productByKeywordViewModel by viewModels<ProductByKeywordViewModel>()
    private val recentKeywordSearchViewModel by viewModels<RecentKeywordSearchViewModel>()
    private val configLocationViewModel by viewModels<ConfigLocationViewModel> ()
    var backDestination=""

    @Inject
    lateinit var myOrderApi: OrderApi

     var approvalOrderDetails:String?=null
    var orderApproval: Orderapproval?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding= FragmentMyOrderDetailsBinding.inflate(inflater,container,false)
        val root : View = binding.root


        sharedPrefManager.getProfileSelected()?.let { permissionViewModel.getCheckPermission(it,"APPROVE_ORDERS") }
        permissionViewModel.getPermissionList()
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                theameColor=R.color.red
                binding.tvPrintOrder.background= ContextCompat.getDrawable(requireActivity(),R.drawable.carved_background_24_tireprose)
            }else if (it.equals("atdonline",true)){
                theameColor=R.color.atd_blue
                binding.tvPrintOrder.background= ContextCompat.getDrawable(requireActivity(),R.drawable.carved_background_24)

            }
        }
        setupUI()
        setUpTheme()

         location= sharedPrefManager?.getLocationNumber()?.toString()

        val bundle = this.arguments
         confirmationNumber= bundle?.getString("confirmationNumber")
         orderStatus= bundle?.getString("orderStatus")
        approvalOrderDetails= bundle?.getString("orderDetails")
         backDestination= bundle?.getString(Constants.KEY_TYPE).toString()
        approvalOrderDetails?.let {

            orderApproval=Gson().fromJson(it,Orderapproval::class.java)
            orderApproval?.let {
                setupApprovalsUI()
                ApproveOrderDetails(it)
                binding.ordersSubmitFoote.clApproveCancel.visible()
                enable()
                binding.tvOrderAgain.inVisible()
                binding.tvPrintOrder.gone()

                binding.ordersSubmitFoote.tvApprove.setOnClickListener {

                        binding.progressbar.visible()
                        val request = ApproveOrder()
                        request.cartid= orderApproval?.cartid.toString()
                        request.locationnumber= location.toString()
                        request.approvalstatus="true"
                        request.comments=""
                        Approve(request,"approve")

                }

                binding.ordersSubmitFoote.btReset.setOnClickListener {
                    val rejectDialog = Dialog(requireActivity(),R.style.WideDialog)
                    rejectDialog.setContentView(R.layout.reject_dialog)
                    rejectDialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
                    val cancel : TextView = rejectDialog.findViewById(R.id.cancel)
                    val reject : TextView = rejectDialog.findViewById(R.id.reject)
                    val comments : EditText = rejectDialog.findViewById(R.id.etComments)

                    cancel.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
                    reject.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
                    cancel.setOnClickListener {
                        rejectDialog.dismiss()
                    }
                    reject.setOnClickListener {

                        binding.progressbar.visible()
                            val request = ApproveOrder()
                            request.cartid=orderApproval?.cartid.toString()
                            request.locationnumber=location.toString()
                            request.approvalstatus="false"
                            request.comments=comments.text.toString()
                            Approve(request,"reject")
                        rejectDialog.dismiss()

                    }
                    rejectDialog.show()
                }

            }

        }
        val orderRequest = OrderDetailsRequest(confirmationNumber,location)

        viewModel.getOrderDetails(orderRequest)
        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.order_details)
        BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed(backDestination)
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed(backDestination)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )


        binding.tvOrderAgain.setOnClickListener{
            //Add to cart
             showToast= true

            keyWords?.map {

                getProductDetails(it)
            }

        }

        return root
    }

    private fun getProductDetails(keyword: String) {

        val productByKeywordRequest = ProductByKeywordRequest()
        productByKeywordRequest.locationnumber = sharedPrefManager?.getLocationNumber().toString()
        productByKeywordRequest.keywords = keyword
        val options = Options()
        options.includemarketingprograms="true"
        options.includerebates="true"

        val availability = Availability()
        availability.local = 1
        availability.localplus = 1
        availability.nationwide = 1
        options.availability=availability

        val price = Price()
        price.cost = 1
        price.retail = 1
        price.specialdiscount = 1
        price.fet = 1
        price.map = 1
        price.msrp = 1
        options.price=price

        val images = Images()
        images.small = 1
        images.medium = 1
        images.large = 1
        options.images=images
        productByKeywordRequest.options=options

        productByKeywordViewModel.getProductByKeywordWithResults(productByKeywordRequest).observe(viewLifecycleOwner,
            Observer {
                when (it) {
                    is NetworkResult.Success -> {

                        binding.progressbar.gone()

                        it.data?.products?.get(0)?.let {product->

                            if(sharedPrefManager.getDeliveryDefault().toString() == "Pickup" && sharedPrefManager.getSelectedDelivery() == null){
                                if(product.quantity!!.toInt() >product.availability.local.toInt()){
                                    isCustomerPickupDelivery()
                                    return@let
                                }
                            } else if (sharedPrefManager.getSelectedDelivery() != null && sharedPrefManager.getSelectedDelivery() =="Pickup"){
                                if(product.quantity!!.toInt() > product.availability.local.toInt()){
                                    isCustomerPickupDelivery()
                                    return@let

                                }
                            }

                                val quantity: Int? = product?.quantity?.let { it }?:1
                                val addCartDetails = Cart(product.brand, product.style, product.productgroup,quantity!!.toInt(),
                                    product?.images?.thumbnail?.image?.get(0)?.url.toString(),product.mfgproductnumber,product.atdproductnumber,sharedPrefManager.getUserName().toString(),sharedPrefManager.getLocationNumber().toString(), Common.currentDateTime(), "")

                                recentKeywordSearchViewModel.getCreatedCartRecordInFireStore(addCartDetails).observe(viewLifecycleOwner,
                                    Observer {cartList->

                                        val filteredCartList = cartList.filter {
                                            it?.userName.equals(sharedPrefManager.getUserName()) &&
                                                    it?.locationNumber.equals(sharedPrefManager.getLocationNumber())
                                        }
                                        val totalQuantity = filteredCartList.sumOf { it!!.quantity }

                                        println("Updated records $filteredCartList")

                                        if (totalQuantity > 0) {
                                            badgeCount?.visibility = View.VISIBLE
                                            badgeCount?.text = totalQuantity.toString()
                                            if (showToast) {
                                                successToast("Items added to cart successfully")
                                            }
                                            showToast=false
                                        } else {
                                            badgeCount?.visibility = View.GONE
                                        }
                                    })
                        }
                    }
                    is NetworkResult.Error -> {
                        binding.progressbar.gone()

                    }
                    is NetworkResult.Loading -> {
                        binding.progressbar.visible()
                    }
                }
            })
    }

    private fun isCustomerPickupDelivery() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickupalert_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }


    private fun setUpTheme() {
        binding.divider.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.divider2.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvOrderAgain.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvPrintOrder.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        BottomNavigationScreenFragment.atdLogo?.compoundDrawableTintList = ContextCompat.getColorStateList(requireActivity(),theameColor)
    }

    fun enable(){

        binding.ordersSubmitFoote.btReset.isEnabled=true
        binding.ordersSubmitFoote.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.ordersSubmitFoote.tvApprove.isEnabled=true
        binding.ordersSubmitFoote.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ordersSubmitFoote.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
    }

    private fun Approve(request: ApproveOrder, type: String) {


        submitApprovalsViewModel.ApproveOrder(request).observe(viewLifecycleOwner,
            Observer {
                when(it) {
                    is NetworkResult.Success -> {
                        it?.data?.let {


                            val alert = Dialog(requireActivity(),R.style.WideDialog)
                            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                            val alertBinding = AlertBinding.inflate(inflater)
                            alert.setContentView(alertBinding.root)
                            alert.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
                            alert.setCancelable(false)
                            alertBinding.alertOK.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
                            if (type.equals("approve", true)) {
                                alertBinding.alertTitle.setText("Success")
                                alertBinding.alertMessage.setText("You approved 1 order")
                            } else {
                                alertBinding.alertTitle.setText("Order Rejected")
                                alertBinding.alertMessage.setText("You rejected 1 order")
                            }
                            alertBinding.alertOK.setOnClickListener {
                                alert.dismiss()
                                BackPressed(Constants.SUBMITAPPROVALS)
                            }

                            alert.show()
                            binding.progressbar.gone()
                        }
                    }
                    is NetworkResult.Error -> {

                        val alert= AlertDialog.Builder(requireActivity())
                        alert.setMessage(it?.message)
                        alert.setPositiveButton("OK", DialogInterface.OnClickListener{
                                dialog, which ->
                            dialog.dismiss()
                        })
                        alert.show()
                        binding.progressbar.gone()

                    }
                    is NetworkResult.Loading -> {
                        binding.progressbar.visible()
                    }
                }

            })

    }


    fun BackPressed(backDestination: String?) {

        var fragment:Fragment? = null
        if (backDestination.equals(Constants.SUBMITAPPROVALS)){
            fragment= SubmitApprovalsFragment()
        }else if (backDestination.equals(Constants.MY_ORDERS)){
            findNavController().navigate(R.id.action_myordersDetailsFragment_to_BottomNavigation)
        }else if (backDestination.equals(Constants.MY_ORDERS_SEARCH)){
            fragment= MyOrdersSearchFragment()
        }

        if (fragment != null) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.bottomNavigationViewFrame,fragment)
                .addToBackStack(null)
                .commit()
        }
       // requireActivity().supportFragmentManager.popBackStack()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

            when(it){

                is NetworkResult.Success ->{

                   val orderPermissions=it.data
                    //APPROVE_ORDERS
                    println("orderPermissions $orderPermissions")
                    println("backDestination $backDestination")

                    if(orderPermissions?.equals("APPROVE_ORDERS",true) == true){
                        if (backDestination.equals(Constants.MY_ORDERS)||backDestination.equals(Constants.MY_ORDERS_SEARCH)){
                            binding.ordersSubmitFoote.clApproveCancel.gone()
                        }else{
                            binding.ordersSubmitFoote.clApproveCancel.visible()
                        }
                    }else{
                        binding.ordersSubmitFoote.clApproveCancel.gone()
                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)


                }
                is NetworkResult.Loading -> {
                    println("loading?????")

                }
            }
        })

        viewModel.orderDetailsResponse.observe(viewLifecycleOwner, Observer {

            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it?.data?.let {

                       it?.let {

                           if (approvalOrderDetails==null){
                               UpdateResult(it)
                           }
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

    private fun ApproveOrderDetails(result: Orderapproval) {

        println("order details ==>  $result")

        binding.tvOrderStatus.text=result.status
        if (result.status.equals(Constants.PENDING_APPROVAL,true)){
            binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);
            binding.tvOrderStatus.text="Pending"
        }
        else if (result.status.equals(Constants.OPEN,true)){
            binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

        }else if (result.status.equals(Constants.CLOSE,true)){
            binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0);

        }else if (result.status.equals(Constants.CANCELLED,true)){

            binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0);
        }

        binding.tvOrderDate.text= result?.dateplaced?.toString()
            ?.let { Common.getMonthNameDayYear(it) }
        binding.tvConfirmation.text="${Constants.SUBMITTED_BY}${result?.submittedby?:""}"

        if (result?.orderdetails?.ordertotal?.toDouble()!! <0){
            binding.tvConfirmation.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
        }
       // binding.tvConsumerName.text="${Constants.SUBMITTED_BY}${result?.submittedby?:""}"
        binding.tvPO.text="${Constants.PO}${result?.orderdetails?.customernumber?:""}"
        val subTotal : Double = (result?.orderdetails?.ordertotal!! - result?.orderdetails?.freight!!)
        binding.tvSubtotalValue.text= "${Constants.Dollar}"+roundOffDecimal(subTotal)
        binding.tvFreightValue.text="${Constants.Dollar}"+roundOffDecimal(result?.orderdetails?.freight)
        binding.tvTotalValue.text="${Constants.Dollar}"+roundOffDecimal(result?.orderdetails?.ordertotal)
        val datePlaced= result?.dateplaced?.toString()
        val comments=result.orderdetails?.customercomments.toString()

        result?.orderdetails?.orderdetaillines?.let {
            if (it.size>0) {
                binding.tvInvoice.inVisible()
               // binding.tvInvoice.text="${Constants.Invoice}${result?.orderdetails?.orderdetaillines?.get(0)?.fulfillments?.get(0)?.invoicenumber?:""}"
                binding.tvTotal.text="Total (${it.sumOf { it.product.quantity }} Items)"
                if (datePlaced != null) {
                    approvalDetailsAdapter.addOrders(it,datePlaced,comments,result.status)
                }
                approvalDetailsAdapter.notifyDataSetChanged()
            }

        }

    }

    fun roundOffDecimal(number: Double): String {

        val formatter: NumberFormat = NumberFormat.getNumberInstance()
        formatter.setMinimumFractionDigits(2)
        formatter.setMaximumFractionDigits(2)
        val output: String = formatter.format(number)

        return output
    }

    private fun UpdateResult(result: OrderDetailsResponse) {
        keyWords = arrayListOf()
        result?.orderstatusdetail?.orderdetaillines?.map {

            keyWords?.add(it.atdproductnumber)
        }
        result?.orderstatusdetail?.orderdetaillines?.let {

            if (it.size>0){
                if (it.get(0).fulfillments.size>0){
                    binding.tvOrderStatus.text= result?.orderstatusdetail?.orderdetaillines?.get(0)?.fulfillments?.get(0)?.status.toString()

                    if (binding.tvOrderStatus.text.toString().equals(Constants.OPEN,true)){
                        binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

                    }else if (binding.tvOrderStatus.text.toString().equals(Constants.CLOSE,true)){
                        binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0);

                    }else if (binding.tvOrderStatus.text.toString().equals(Constants.CANCELLED,true)){

                        binding.tvOrderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0);
                    }
                }
            }
        }


        binding.tvOrderDate.text= result?.orderstatusdetail?.dateplaced?.toString()
            ?.let { Common.getMonthNameDayYear(it) }
        binding.tvConfirmation.text="${Constants.Conf}${result?.orderstatusdetail?.confirmationnumber?:""}"

        if (result?.orderstatusdetail?.ordertotal?.toDouble()!! <0){
            binding.tvConfirmation.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.red))
        }
       // binding.tvConsumerName.text="${Constants.ConsumerName}${result?.orderstatusdetail?.consumername?:""}"
        binding.tvPO.text="${Constants.PO}${result?.orderstatusdetail?.customerponumber?:""}"
        val subTotal:Double= (result?.orderstatusdetail?.ordertotal!! - result?.orderstatusdetail?.freight!!)
        binding.tvSubtotalValue.text= "${Constants.Dollar}"+roundOffDecimal(subTotal)
        binding.tvFreightValue.text="${Constants.Dollar}"+roundOffDecimal(result.orderstatusdetail.freight)
        binding.tvTotalValue.text="${Constants.Dollar}"+roundOffDecimal(result.orderstatusdetail.ordertotal)
       val datePlaced= result?.orderstatusdetail?.dateplaced?.toString()
        val comments=result.orderstatusdetail.customercomments
        result?.orderstatusdetail?.orderdetaillines?.let {
            if (it.size>0) {
                binding.tvInvoice.text="${Constants.Invoice}${result?.orderstatusdetail?.orderdetaillines?.get(0)?.fulfillments?.get(0)?.invoicenumber?:""}"

                if (datePlaced != null) {
                    adapter.addOrders(it,datePlaced,comments,location,confirmationNumber)
                }
                adapter.notifyDataSetChanged()
            }

        }

    }

    private fun setupUI() {
        adapter= MyOrdersDetailsAdapter(arrayListOf(),myOrderApi)
        binding.rvOrderItemLine.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)

        binding.rvOrderItemLine.adapter = adapter
    }

    private fun setupApprovalsUI() {
        approvalDetailsAdapter= ApprovalOrderDetailsAdapter(arrayListOf())
        binding.rvOrderItemLine.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)

        binding.rvOrderItemLine.adapter = approvalDetailsAdapter
    }


}
package com.atd.atdmobileapp.ui.cart.quantityanddelivery

import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentQuantityAndDeliveryBinding
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.ui.cart.deliverydayandwindow.DeliveryDayAndWindowFragment
import com.atd.atdmobileapp.utils.*
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class QuantityAndDeliveryFragment() : DialogFragment() {

    private var _binding: FragmentQuantityAndDeliveryBinding? = null
    private val binding get() = _binding!!
    private val quantityAndDeliveryViewModel by viewModels<QuantityAndDeliveryViewModel>()
    private var cartItem: CartItem? = null
    private var qty: Int = 0
    private var atdProductNumber: String = ""
    private lateinit var mainViewModel: MainViewModel
    private var selectedDeliveryTypeAfterConfirm :String?= null
    private var needByDate :String? =null
    private var futureDayFlag :Boolean =false
    private var futureWindowFlag :Boolean =false

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    private lateinit var onSaveClick: () -> Unit
    constructor( onSaveClick: () -> Unit) : this() {
        this.onSaveClick = onSaveClick
    }
    companion object {
        const val TAG = "QuantityAndDeliveryFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentQuantityAndDeliveryBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainViewModel.cartItemDetails.observe(viewLifecycleOwner) { it ->
            cartItem = it
            cartItem?.let {
                binding.tvBrandStyle.text = it.brand + it.style
                binding.tvDescriptionAndBrandStyle.text = it.description + it.brand + it.style
                binding.tvCostValue.text = it.cost
                binding.tvSupplierValue.text = it.supplier
                binding.tvQtyValue.text = it.quantity.toString()
                qty = it.quantity
                atdProductNumber = it.supplier
            }
            requestForStandardDelivery(qty)
        }
        binding.tvLocal.text = sharedPrefManager.getLocal()
        binding.tvLocalPlus.text = sharedPrefManager.getLocalPlus()
        increaseQuantity()
        decreaseQuantity()
        save()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backPressed()
        updateTheme()
        bindObservers()
        selectDateForFutureDayWindow()
        selectDateForFutureDay()
        selectDeliverDay()
        selectedDeliveryDayWindow()
        selectDeliveryType()
        updateDeliveryOptions()
    }

    private fun updateTheme(){
        when (sharedPrefManager.getProfileSelected()) {
            Constants.TIRE_PROS -> {
                val color = ContextCompat.getColor(binding.root.context, R.color.red)
                binding.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.tvSave.setTextColor(color)
                binding.tvQtyValue.setTextColor(color)
                binding.tvQtyValue.setBackgroundResource(R.drawable.light_carved_background_24_tirepros)
                binding.ivDecrease.setImageResource(R.drawable.decrese_tirepros)
                binding.ivIncrease.setImageResource(R.drawable.increse_tirepros)

            }
            Constants.ATD_ONLINE -> {
                val color = ContextCompat.getColor(binding.root.context, R.color.atd_blue)
                binding.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.tvSave.setTextColor(color)
                binding.tvQtyValue.setTextColor(color)
                binding.tvQtyValue?.setBackgroundResource(R.drawable.light_carved_background_24)
                binding.ivDecrease.setImageResource(R.drawable.decrese)
                binding.ivIncrease.setImageResource(R.drawable.increse)
            }
        }
    }

    private fun requestForStandardDelivery(qty :Int){

        val listItem = listOf<Lineitem>(
            Lineitem(
                atdProductNumber,
                qty,
                "cheapest_freight",
                1
            )
        )
        val order = Order(
            "testpo", "testcomment",
            "true", "d", "false", listItem
        )
        val cartRequest = CartRequest(sharedPrefManager.getLocationNumber().toString(), order)
        val shippingMethodRequest = ShippingMethodRequest(
            atdProductNumber,
            sharedPrefManager.getLocationNumber().toString(),
            qty.toString()
        )
        quantityAndDeliveryViewModel.fetchDataParallelly(
            sharedPrefManager.getLocationNumber().toString(), shippingMethodRequest, cartRequest
        )
    }

    private fun requestForFutureDelivery(qty :Int){

        val listItem = listOf<Lineitem>(
            Lineitem(
                atdProductNumber,
                qty,
                "cheapest_freight",
                0
            )
        )
        val order = Order(
            "testpo", "testcomment",
            "true", "d", "false", listItem
        )
        val cartRequest = CartRequest(sharedPrefManager.getLocationNumber().toString(), order)
        val shippingMethodRequest = ShippingMethodRequest(
            atdProductNumber,
            sharedPrefManager.getLocationNumber().toString(),
            qty.toString()
        )
        quantityAndDeliveryViewModel.fetchDataParallelly(
            sharedPrefManager.getLocationNumber().toString(), shippingMethodRequest, cartRequest
        )
    }

    private fun requestForPickup(qty: Int){
        val listItem = listOf<Lineitem>(
            Lineitem(
                atdProductNumber,
                qty,
                "cheapest_freight",
                0
            )
        )
        val order = Order(
            "testpo", "testcomment",
            "false", "d", "true", listItem
        )
        val cartRequest = CartRequest(sharedPrefManager.getLocationNumber().toString(), order)
        val shippingMethodRequest = ShippingMethodRequest(
            atdProductNumber,
            sharedPrefManager.getLocationNumber().toString(),
            qty.toString()
        )
        quantityAndDeliveryViewModel.fetchDataParallelly(
            sharedPrefManager.getLocationNumber().toString(), shippingMethodRequest, cartRequest
        )
    }



    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }


    private fun bindObservers() {
        getCartDetails()
        getShippingDetails()
        getCustomerDetails()
        fireStoreUpdateStatus()
        deleteUpdateStatus()
    }

    fun convertAmount(amount: String): String {
        val decimalFormat = DecimalFormat("#,###,##0.00")
        return "$" + decimalFormat.format(amount.toDouble())
    }

    private fun getCartDetails(){
        quantityAndDeliveryViewModel.cartDetailsLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is NetworkResult.Success -> {
                    if(binding.tvQtyValue.text.toString().isNotEmpty()) {
                        val totalCost = it.data?.order?.orderlines?.first()?.cost?.times(
                            binding.tvQtyValue.text.toString().toDouble()
                        )
                        binding.tvSubtotalValue.text = convertAmount(totalCost.toString())
                    }
                }
                is NetworkResult.Error -> {
                    errorToast(it.message)
                }
                is NetworkResult.Loading -> {
                }
            }
        })
    }

    private fun getCustomerDetails(){
        quantityAndDeliveryViewModel.customerDetailsLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is NetworkResult.Success -> {
                    if(it.data?.customer?.isdeliveryon == true) {
                        futureDayFlag = true
                    } else {
                        futureDayFlag = false

                    }
                    if (it.data?.customer?.isdeliveryby == true){
                         futureWindowFlag =true
                        //binding.llEditDeliveryDateForWindow.visible()
                    }else {
                        futureWindowFlag =false

                    }
                }
                is NetworkResult.Error -> {
                    errorToast(it.message)
                }
                is NetworkResult.Loading -> {
                }
            }
        })

    }

    private fun showFutureOptions(){
        if(futureDayFlag){
            binding.llChooseFutureDeliveryDay.visible()
        }else {
            binding.llChooseFutureDeliveryDay.gone()
            binding.llEditDeliveryDateForDay.gone()
        }

        if(futureWindowFlag){
            binding.llFutureDelivery.visible()
        }else {
            binding.llFutureDelivery.gone()
            binding.llEditDeliveryDateForWindow.gone()
        }

    }

    private fun getShippingDetails(){
        quantityAndDeliveryViewModel.shippingDetailsLiveData.observe( viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.progressbar.gone()
            when (it) {
                is NetworkResult.Success -> {
                    var totalQty =0
                    var totalLocalAndLocalPlusQty =0
                    var totalFutureDeliveryDayQty =0
                    var totalLocalQtyForPickup =0
                    var totalNationalQty =0
                    var totalBackOrderQty =0
                    it.data?.sources?.map {
                        val sourceType = it.sourcetype
                        val status = it.status
                        totalQty += it.quantity.toInt()
                        if(sharedPrefManager.getDeliveryDefault() == Constants.PICKUP &&
                            (sharedPrefManager.getSelectedDelivery() == Constants.PICKUP  || sharedPrefManager.getSelectedDelivery() == null) &&
                            (selectedDeliveryTypeAfterConfirm == null ||  selectedDeliveryTypeAfterConfirm == Constants.PICKUP )){

                            if (sourceType.equals("LOCAL")){
                                totalLocalQtyForPickup += it.quantity.toInt()
                                binding.llLocal.visible()
                                binding.tvLocalQty.text =
                                    "QTY: " + totalLocalQtyForPickup+ "/" + totalLocalQtyForPickup
                                binding.tvLocalDelivery.visible()
                                binding.llStandardDelivery.visible()
                                val freightCost = it.shippingmethod.first().freightcost.toDouble()
                                val expectedDeliveryDate =
                                    it.shippingmethod.first().expecteddeliverydate
                                if (freightCost != 0.0) {
                                    binding.tvStandardDeliveryCost.visible()
                                    binding.tvStandardDeliveryCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvStandardDeliveryCost.gone()
                                }
                                binding.llEstimateStandardDelivery.visible()
                                binding.tvEstimateStandardDeliveryValue.text =
                                    formatDateAndTime(expectedDeliveryDate)
                            }
                            validateDeliveryDefault()
                            showFutureOptions()
                            binding.tvSubTotalText.text = "Item Subtotal* (" + totalLocalQtyForPickup + " items)"
                            binding.tvQtyValue.text = totalLocalQtyForPickup.toString()


                        } else if (sharedPrefManager.getDeliveryDefault() ==Constants.PICKUP  && sharedPrefManager.getSelectedDelivery() ==Constants.DELIVERY  &&
                            selectedDeliveryTypeAfterConfirm == Constants.PICKUP ){

                            if (sourceType.equals("LOCAL")){
                                totalLocalQtyForPickup += it.quantity.toInt()
                                binding.llLocal.visible()
                                binding.tvLocalQty.text =
                                    "QTY: " + totalLocalQtyForPickup+ "/" + totalLocalQtyForPickup
                                binding.tvLocalDelivery.visible()
                                binding.llStandardDelivery.visible()
                                val freightCost = it.shippingmethod.first().freightcost.toDouble()
                                val expectedDeliveryDate =
                                    it.shippingmethod.first().expecteddeliverydate
                                if (freightCost != 0.0) {
                                    binding.tvStandardDeliveryCost.visible()
                                    binding.tvStandardDeliveryCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvStandardDeliveryCost.gone()
                                }
                                binding.llEstimateStandardDelivery.visible()
                                binding.tvEstimateStandardDeliveryValue.text =
                                    formatDateAndTime(expectedDeliveryDate)
                            }
                            validateDeliveryDefault()
                            showFutureOptions()
                            binding.tvSubTotalText.text = "Item Subtotal* (" + totalLocalQtyForPickup + " items)"
                            binding.tvQtyValue.text = totalLocalQtyForPickup.toString()
                            binding.llNational.gone()
                            binding.llBackOrder.gone()
                            binding.llPartyGround.gone()
                            binding.llPartyGroundDelivery.gone()
                            binding.tvNationalDelivery.gone()

                        } else if (sharedPrefManager.getDeliveryDefault() == Constants.DELIVERY  &&
                            (selectedDeliveryTypeAfterConfirm == Constants.PICKUP || sharedPrefManager.getSelectedDelivery() == Constants.PICKUP) ){
                            if (sourceType.equals("LOCAL")){
                                totalLocalQtyForPickup += it.quantity.toInt()
                                binding.llLocal.visible()
                                binding.tvLocalQty.text =
                                    "QTY: " + totalLocalQtyForPickup+ "/" + totalLocalQtyForPickup
                                binding.tvLocalDelivery.visible()
                                binding.llStandardDelivery.visible()
                                val freightCost = it.shippingmethod.first().freightcost.toDouble()
                                val expectedDeliveryDate =
                                    it.shippingmethod.first().expecteddeliverydate
                                if (freightCost != 0.0) {
                                    binding.tvStandardDeliveryCost.visible()
                                    binding.tvStandardDeliveryCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvStandardDeliveryCost.gone()
                                }
                                binding.llEstimateStandardDelivery.visible()
                                binding.tvEstimateStandardDeliveryValue.text =
                                    formatDateAndTime(expectedDeliveryDate)
                            }
                            binding.tvSubTotalText.text = "Item Subtotal* (" + totalLocalQtyForPickup + " items)"
                            binding.tvQtyValue.text = totalLocalQtyForPickup.toString()
                            binding.llCustomerPickup.visible()
                            binding.llNational.gone()
                            binding.llBackOrder.gone()
                            binding.llPartyGround.gone()
                            binding.llPartyGroundDelivery.gone()
                            binding.tvNationalDelivery.gone()

                        } else if (selectedDeliveryTypeAfterConfirm != null &&
                            (selectedDeliveryTypeAfterConfirm == Constants.IS_DELIVERY_ON || selectedDeliveryTypeAfterConfirm == Constants.IS_DELIVERY_BY) ||
                            (sharedPrefManager.getSelectedDelivery() ==Constants.IS_DELIVERY_ON|| sharedPrefManager.getSelectedDelivery() ==Constants.IS_DELIVERY_BY)){

                            if ((sourceType.equals("LOCAL") || sourceType.equals("REST_LOCALPLUS")) && !status.equals("BACKORDERED")) {
                                totalFutureDeliveryDayQty += it.quantity.toInt()
                                binding.llLocal.visible()
                                binding.llCustomerPickup.visible()
                                binding.tvLocalQty.text =
                                    "QTY: " + totalFutureDeliveryDayQty + "/" + totalFutureDeliveryDayQty
                                binding.tvLocalDelivery.visible()
                                binding.llStandardDelivery.visible()
                                val freightCost = it.shippingmethod.first().freightcost.toDouble()
                                val expectedDeliveryDate =
                                    it.shippingmethod.first().expecteddeliverydate
                                if (freightCost != 0.0) {
                                    binding.tvStandardDeliveryCost.visible()
                                    binding.tvStandardDeliveryCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvStandardDeliveryCost.gone()
                                }
                                binding.llEstimateStandardDelivery.gone()

                            }
                            binding.llNational.gone()
                            binding.llBackOrder.gone()
                            binding.tvNationalDelivery.gone()
                            binding.llPartyGround.gone()
                            binding.llPartyGroundDelivery.gone()

                            binding.tvSubTotalText.text = "Item Subtotal* (" + totalFutureDeliveryDayQty + " items)"
                            binding.tvQtyValue.text = totalFutureDeliveryDayQty.toString()
                            showFutureOptions()

                        } else {
                            if ((sourceType.equals("LOCAL") || sourceType.equals("REST_LOCALPLUS")) && !status.equals("BACKORDERED")) {
                                totalLocalAndLocalPlusQty += it.quantity.toInt()
                                binding.llLocal.visible()
                                binding.tvLocalQty.text =
                                    "QTY: " + totalLocalAndLocalPlusQty + "/" + binding.tvQtyValue.text.toString()
                                binding.tvLocalDelivery.visible()
                                binding.llStandardDelivery.visible()
                                binding.llCustomerPickup.visible()
                                val freightCost = it.shippingmethod.first().freightcost.toDouble()
                                val expectedDeliveryDate =
                                    it.shippingmethod.first().expecteddeliverydate
                                if (freightCost != 0.0) {
                                    binding.tvStandardDeliveryCost.visible()
                                    binding.tvStandardDeliveryCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvStandardDeliveryCost.gone()
                                }
                                binding.llEstimateStandardDelivery.visible()
                                binding.tvEstimateStandardDeliveryValue.text =
                                    formatDateAndTime(expectedDeliveryDate)
                                //validateDeliveryDefault()
                                showFutureOptions()

                            } else if (sourceType.equals("NATIONAL") || sourceType.equals("REST_NATIONAL")) {
                                totalNationalQty += it.quantity.toInt()
                                binding.llNational.visible()
                                binding.tvNationalQty.text =
                                    "QTY: " + totalNationalQty + "/" + binding.tvQtyValue.text.toString()
                                binding.tvNationalDelivery.visible()
                                binding.llPartyGround.visible()
                                val freightCost = calculateFreightCostForNational(it.shippingmethod)
                                if (freightCost != 0.0) {
                                    binding.tvPartyGroundCost.visible()
                                    binding.tvPartyGroundCost.text = "(+$" + freightCost + ")"
                                } else {
                                    binding.tvPartyGroundCost.gone()
                                }
                                val deliveryDate = it.shippingmethod.first().expecteddeliverydate
                                binding.llPartyGroundDelivery.visible()
                                binding.tvPartyGroundDeliveryDate.text =
                                    formatDateAndTime(deliveryDate)
                            } else if (status.equals("BACKORDERED")) {
                                totalBackOrderQty += it.quantity.toInt()
                                binding.llBackOrder.visible()
                                binding.tvBackOrderQty.text =
                                    "QTY: " + totalBackOrderQty + "/" + binding.tvQtyValue.text.toString()
                                binding.llBackOrderMessage.visible()
                            }
                            binding.tvSubTotalText.text = "Item Subtotal* (" + totalQty + " items)"
                        }
                    }
                }
                is NetworkResult.Error -> {
                    errorToast(it.message)
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        })

    }


    private fun updateDeliveryOptions(){
        val handler = Handler()
        handler.postDelayed({
        when(sharedPrefManager.getSelectedDelivery()){
            Constants.PICKUP ->{
                //binding.ivCustomerPickup.setImageResource(R.drawable.radio_selected)
                updateRadioButtons(binding.ivCustomerPickup)
                binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
                binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
                binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
                binding.llEditDeliveryDateForWindow.gone()
                binding.llEditDeliveryDateForDay.gone()

            }
            Constants.DELIVERY ->{
               // binding.ivStandardDelivery.setImageResource(R.drawable.radio_selected)
                updateRadioButtons(binding.ivStandardDelivery)
                binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
                binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
                binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
                binding.llEditDeliveryDateForWindow.gone()
                binding.llEditDeliveryDateForDay.gone()
            }
            Constants.IS_DELIVERY_ON ->{
                binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
                binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
                binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
                //binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_selected)
                updateRadioButtons(binding.ivChooseFutureDeliveryDay)
                binding.llEditDeliveryDateForWindow.gone()
                binding.llEditDeliveryDateForDay.visible()
            }
            Constants.IS_DELIVERY_BY ->{
                binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
                binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
                //binding.ivFutureDelivery.setImageResource(R.drawable.radio_selected)
                updateRadioButtons(binding.ivFutureDelivery)
                binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
                binding.llEditDeliveryDateForWindow.visible()
                binding.llEditDeliveryDateForDay.gone()
            }
            else ->{
                //highlight default delivery
            }
        }
        }, 2000)
    }

    private fun updateRadioButtons(imageView: ImageView){
        when (sharedPrefManager.getProfileSelected()) {
            Constants.TIRE_PROS -> {
                imageView.setImageResource(R.drawable.radio_selected_red)
            }
            Constants.ATD_ONLINE -> {
                imageView.setImageResource(R.drawable.radio_selected)
            }
        }
    }

    private fun validateDeliveryDefault() {
        if (sharedPrefManager.getDeliveryDefault()?.equals("Pickup") == true && (selectedDeliveryTypeAfterConfirm == null || selectedDeliveryTypeAfterConfirm == "Pickup")) {
            binding.llCustomerPickup.visible()
            // binding.ivCustomerPickup.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivCustomerPickup)
            binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)


        } else {
//            binding.llCustomerPickup.gone()
            //binding.ivStandardDelivery.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivStandardDelivery)
            binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
        }
    }

    private fun selectDeliveryType(){
        binding.llStandardDelivery.setOnClickListener {
            //binding.ivStandardDelivery.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivStandardDelivery)
            binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
            binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
            binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
            requestForStandardDelivery(binding.tvQtyValue.text.toString().toInt())
            selectedDeliveryTypeAfterConfirm =Constants.DELIVERY
            binding.llEditDeliveryDateForWindow.gone()
            binding.llEditDeliveryDateForDay.gone()
        }
        binding.llCustomerPickup.setOnClickListener {
            confirmPickupDialog()
        }
    }

    private fun selectDateForFutureDayWindow() {
        binding.tvEditDeliveryDateForWindowValue.setOnClickListener {
            mainViewModel.setSelectedCalendarView(CalendarViewType.FUTURE_WINDOW)
            val deliveryDayAndWindowFragment = DeliveryDayAndWindowFragment (
                onApplyClick = { selectedDates ->
                    binding.tvEditDeliveryDateForWindowValue.text =formatDates(selectedDates) + " >"
                    needByDate = selectedDates.last().date.toString()
                },
                onCancel = {
                 // binding.ivStandardDelivery.setImageResource(R.drawable.radio_selected)
                    updateRadioButtons(binding.ivStandardDelivery)
                  binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
                    binding.llEditDeliveryDateForWindow.gone()
                }
            )
            deliveryDayAndWindowFragment.show(requireActivity().supportFragmentManager, DeliveryDayAndWindowFragment.TAG)
        }
    }

    private fun selectDateForFutureDay(){
        binding.tvEditDeliveryDateForDayValue.setOnClickListener {
            mainViewModel.setSelectedCalendarView(CalendarViewType.FUTURE_DAY)
            val deliveryDayAndWindowFragment = DeliveryDayAndWindowFragment (
                onApplyClick = { selectedDates ->
                    needByDate = selectedDates.last().date.toString()
                    binding.tvEditDeliveryDateForDayValue.text =formatDates(selectedDates) + " >"
                },
                onCancel = {
                   // binding.ivStandardDelivery.setImageResource(R.drawable.radio_selected)
                    updateRadioButtons(binding.ivStandardDelivery)
                    binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
                    binding.llEditDeliveryDateForDay.gone()
                }
            )
            deliveryDayAndWindowFragment.show(requireActivity().supportFragmentManager, DeliveryDayAndWindowFragment.TAG)
        }
    }

    private fun formatDates(calendarDays :List<CalendarDay>) :String{
        val formattedDates = calendarDays.map { calendarDay ->
            val localDate = calendarDay.date
            val calendar = Calendar.getInstance()
            calendar.set(localDate.year, localDate.monthValue - 1, localDate.dayOfMonth)
            val dayOfWeek = SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.time)
            val month = SimpleDateFormat("MMM", Locale.getDefault()).format(calendar.time)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            "$dayOfWeek, $month $dayOfMonth"
        }
        val resultText = if (formattedDates.size > 1) {
            "${formattedDates.first()} - ${formattedDates.last()}"
        } else {
            formattedDates.first()
        }
        return resultText
    }

    private fun selectDeliverDay(){
        binding.llChooseFutureDeliveryDay.setOnClickListener {
            confirmFutureDeliverDayDialog()
        }
    }

    private fun selectedDeliveryDayWindow(){
        binding.llFutureDelivery.setOnClickListener {
            confirmFutureDeliverDayWindowDialog()
        }
    }

    private fun confirmFutureDeliverDayDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickup_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvConfirm = dialog.findViewById(R.id.tvConfirm) as TextView
        val tvMessage = dialog.findViewById(R.id.tvMessage) as TextView
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        val tvHeader = dialog.findViewById(R.id.tvHeader) as TextView
        tvMessage.setText(R.string.national_delivery_items_are_not_eligible_for_future_and_will_be_removed_from_your_cart)
        tvHeader.setText(R.string.future_delivery_must_apply_to_all_item_s_in_your_cart)
        tvConfirm.setText(R.string.yes_remove_item_s_and_select_future_delivery)
        tvConfirm.setOnClickListener {
            //binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivChooseFutureDeliveryDay)
            binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
            binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
            binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
            selectedDeliveryTypeAfterConfirm =Constants.IS_DELIVERY_ON
            binding.llEditDeliveryDateForDay.visible()
            requestForFutureDelivery(binding.tvQtyValue.text.toString().toInt())
            dialog.dismiss()
        }
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun confirmFutureDeliverDayWindowDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickup_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvConfirm = dialog.findViewById(R.id.tvConfirm) as TextView
        val tvMessage = dialog.findViewById(R.id.tvMessage) as TextView
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        val tvHeader = dialog.findViewById(R.id.tvHeader) as TextView
        tvMessage.setText(R.string.national_delivery_items_are_not_eligible_for_future_and_will_be_removed_from_your_cart)
        tvHeader.setText(R.string.future_delivery_must_apply_to_all_item_s_in_your_cart)
        tvConfirm.setText(R.string.yes_remove_item_s_and_select_future_delivery)
        tvConfirm.setOnClickListener {
            //binding.ivFutureDelivery.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivFutureDelivery)
            binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
            binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
            binding.ivCustomerPickup.setImageResource(R.drawable.radio_unselected)
            selectedDeliveryTypeAfterConfirm =Constants.IS_DELIVERY_BY
            binding.llEditDeliveryDateForWindow.visible()
            requestForFutureDelivery(binding.tvQtyValue.text.toString().toInt())
            dialog.dismiss()
        }
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun calculateFreightCostForNational(shippingList: List<Shippingmethod>) :Double {
        var sum = 0.0
        for (shippingMethod in shippingList) {
            if (shippingMethod.name == "Ground") {
                sum += shippingMethod.freightcost.toDouble()
            }
        }
        return sum
    }

    private fun increaseQuantity(){
        binding.ivIncrease.setOnClickListener {
            val qtyValue = binding.tvQtyValue.text.toString()
            val newValue =qtyValue.toInt() +1
            if(newValue <= 50) {
                binding.tvQtyValue.text = newValue.toString()
                hideViews()
                delayTimer(newValue)
            }
        }
    }

    private fun decreaseQuantity(){
        binding.ivDecrease.setOnClickListener {
            val qtyValue = binding.tvQtyValue.text.toString()
            if (qtyValue.toInt()>0) {
                val newValue = qtyValue.toInt() - 1
                if(newValue !=0) {
                    binding.tvQtyValue.text = newValue.toString()
                    hideViews()
                    delayTimer(newValue)
                }
            }
        }
    }

    private fun hideViews(){
        binding.llLocal.gone()
        binding.tvLocalDelivery.gone()
        binding.llStandardDelivery.gone()

        binding.llNational.gone()
        binding.tvNationalDelivery.gone()
        binding.llPartyGround.gone()

        binding.llBackOrder.gone()
        binding.llBackOrderMessage.gone()
    }

    private fun showDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_delete_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialog.findViewById(R.id.tvYes) as TextView
        val title = dialog.findViewById(R.id.tvTitle) as TextView
        val description = dialog.findViewById(R.id.tvDescription) as TextView
        val cancel = dialog.findViewById(R.id.tvCancel) as TextView
        title.text = getString(R.string.save_changes)
        description.text = getString(R.string.confirm_changes)
        okText.setOnClickListener {
            if(selectedDeliveryTypeAfterConfirm != null) {
                sharedPrefManager.saveSelectedDelivery(selectedDeliveryTypeAfterConfirm)
            }
            if(needByDate != null){
                sharedPrefManager.saveNeedByDate(needByDate)
            }
           if( binding.tvQtyValue.text.toString().toInt() == 0){
               val documentName =
                   sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber() + "-" + cartItem!!.supplier
               quantityAndDeliveryViewModel.deleteRecord(documentName)
           }else {
               val cart = Cart(
                   cartItem!!.brand,
                   cartItem!!.style,
                   cartItem!!.description,
                   binding.tvQtyValue.text.toString().toInt(),
                   cartItem!!.productImage,
                   cartItem!!.supplier,
                   cartItem!!.supplier,
                   sharedPrefManager.getUserName().toString(),
                   sharedPrefManager.getLocationNumber().toString(),
                   cartItem!!.createdDate,
                   Common.currentDateTime()
               )
               quantityAndDeliveryViewModel.updateQuantity(
                   cart,
                   binding.tvQtyValue.text.toString().toInt()
               )
           }
            dialog.dismiss()
        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun deleteUpdateStatus(){
        quantityAndDeliveryViewModel.deleteStatus.observe(viewLifecycleOwner) {
           if(it){
               dismiss()
               onSaveClick()
           }
        }
    }

    private fun fireStoreUpdateStatus(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                quantityAndDeliveryViewModel.updateFireStoreFlow.collect { success ->
                    binding.progressbar.gone()
                    when (success) {
                        is NetworkResult.Loading -> {
                            binding.progressbar.visible()
                        }
                        is NetworkResult.Success -> {
                            binding.progressbar.gone()
                            dismiss()
                            onSaveClick()
                        }
                        is NetworkResult.Error -> {

                        }
                    }
                }
            }
        }
    }


    private fun delayTimer(newValue:Int) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if(sharedPrefManager.getDeliveryDefault() != null && sharedPrefManager.getDeliveryDefault().toString() != "Pickup") {
                    requestForStandardDelivery(newValue)
                }else {
                    requestForPickup(newValue)
                }
                timer.cancel()
            }
        }, 400)
    }

    private fun save(){
        binding.tvSave.setOnClickListener {
            showDialog()
        }
    }

    private fun confirmPickupDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pickup_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val tvConfirm = dialog.findViewById(R.id.tvConfirm) as TextView
        val tvCancel = dialog.findViewById(R.id.tvCancel) as TextView
        tvConfirm.setOnClickListener {
            //binding.ivCustomerPickup.setImageResource(R.drawable.radio_selected)
            updateRadioButtons(binding.ivCustomerPickup)
            binding.ivStandardDelivery.setImageResource(R.drawable.radio_unselected)
            binding.ivFutureDelivery.setImageResource(R.drawable.radio_unselected)
            binding.ivChooseFutureDeliveryDay.setImageResource(R.drawable.radio_unselected)
            selectedDeliveryTypeAfterConfirm =Constants.PICKUP
            requestForPickup(binding.tvQtyValue.text.toString().toInt())
            dialog.dismiss()
        }
        tvCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun formatDateAndTime(dateTimeString:String) :String{
        if(!dateTimeString.isNullOrBlank()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val formatter = DateTimeFormatter.ofPattern("EEE, MMM d", Locale.ENGLISH)
                val localDateTime =
                    LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME)
                return formatter.format(localDateTime)
            }
        }
        return ""
    }

    override fun onResume() {
        super.onResume()
        binding.progressbar.gone()
    }

    private fun backPressed() {
        binding.ivBack.setOnClickListener {
            dismiss()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
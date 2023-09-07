package com.atd.atdmobileapp.ui.cart.checkout

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentCheckoutBinding
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.ui.cart.CartFragment
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.getParcelableArray
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class CheckoutFragment : DialogFragment() {

    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!
    private var previousDialogFragment: DialogFragment? = null
    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    var checkoutListener: CheckoutListener? = null
    private val checkoutViewModel by viewModels<CheckoutViewModel>()
    private var poNumber: String = ""
    private var cartListItem = listOf<CartItem>()
    private lateinit var valuesToDisplay: CartDisplayValue
    private var listItems = listOf<LineitemCheckout>()
    private var listOfDeleteCartItems = mutableListOf<DeleteCartItems>()
    private var totalFreight = 0.0
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    var isFlag :Boolean = false
    var pickupFlag = false
    companion object {
        const val TAG = "CheckoutFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        cartListItem = getCartItems()!!
        valuesToDisplay = getValuesToDisplay()!!
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        binding.tvPlaceOrder.isClickable =false
        placeOrder()
        getListOfLineItems()
        bindObserver()
        //sharedPrefManager.savePORegex("[0-9]+")
        enablePlaceOrder()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateTheme()
        setupLocationDetails()
        validatePoNumber()
        selectFreightCharges()
        backPressed()


    }

    private fun setupLocationDetails() {
        val locationAddress = sharedPrefManager.getSelectedLocation()

        sharedPrefManager?.getLocationNumber()?.let {
            binding.tvLocationNumber.text = getString(R.string.location_number) + it
        }
        val dcDetails = Gson().fromJson(locationAddress, DCDetails::class.java)
        val tempLocation = dcDetails.distributioncenter.address.address1 + "\n" +
                dcDetails.distributioncenter.address.city + "," +
                dcDetails.distributioncenter.address.state + ", " +
                dcDetails.distributioncenter.address.zipcode + " "
        binding.tvLocationAddress.text = tempLocation

        val tempDc =
            dcDetails.distributioncenter.address.city + " (#" + dcDetails.distributioncenter.servicingdc + ")"
        binding.tvCity.text = tempDc

    }

    private fun validatePoNumber() {
        if (sharedPrefManager.getPoRequired().equals("Y")) {
            if (sharedPrefManager.getPORegex() != "" && sharedPrefManager.getPORegex() != null) {
                if (binding.etPoNumber.text.toString().matches(Regex(sharedPrefManager.getPORegex().toString()))) {
                    enablePlaceOrder()
                } else {
                    binding.ivPoError.visible()
                    binding.tvPoErrorMsg.visible()
                }
            } else {
                enablePlaceOrder()
            }
        } else {
            enablePlaceOrderIfPoValueIsN()
        }
    }

    private fun enablePlaceOrderIfPoValueIsN(){
        if (totalFreight > 0) {
            binding.tvFreightMsg.visible()
            binding.tvFreightCheckMsg.visible()
            binding.ivFreightCheck.visible()
        }else {
            binding.tvFreightMsg.gone()
            binding.tvFreightCheckMsg.gone()
            binding.ivFreightCheck.gone()
            isFlag = true
            when (sharedPrefManager.getProfileSelected()){
                Constants.TIRE_PROS -> {
                    binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                    binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                }
                Constants.ATD_ONLINE -> {
                    binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                    binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                }
            }
        }
    }

    private fun placeOrder() {
        if (sharedPrefManager.getDeliveryDefault()
                .toString() == "Pickup" && sharedPrefManager.getSelectedDelivery() == null
        ) {
            pickupFlag = true
        } else if (sharedPrefManager.getSelectedDelivery() != null && sharedPrefManager.getSelectedDelivery() == "Pickup") {
            pickupFlag = true
        } else {
            pickupFlag = false
        }
            binding.tvPlaceOrder.setOnClickListener {
                if(isFlag) {
                val orderCheckout = OrderCheckout(
                    binding.etConsumerName.text.toString(),
                    binding.etComments.text.toString(),
                    binding.etPoNumber.text.toString(),
                    listItems,
                    "d",
                    pickupFlag.toString(),
                    localplus = if (pickupFlag){"false"}else{"true"}
                )
                val needByDate = sharedPrefManager.getNeedByDate()
                if (needByDate != null) {
                    checkoutViewModel.placeOrderWithDate(
                        CheckoutRequestWithDate(
                            sharedPrefManager.getLocationNumber().toString(),
                            orderCheckout,
                            needByDate
                        )
                    )
                    tapPlaceOrderEvent()
                } else {

                    checkoutViewModel.placeOrder(
                        CheckoutRequest(
                            sharedPrefManager.getLocationNumber().toString(), orderCheckout
                        )
                    )
                    tapPlaceOrderEvent()
                }
            }
        }
    }

    private fun tapPlaceOrderEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            screen = Screen.Checkout,
            category = Category.Cart,
            action = Action.Click,
            label = "Place order"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Checkout)
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Place_Order, params)
    }

    private fun getCartItems(): List<CartItem>? {
        return mainViewModel.cartItems.value
    }

    private fun getValuesToDisplay(): CartDisplayValue?{
        return mainViewModel.cartValuesToDisplay.value
    }

    private fun getListOfLineItems() {
        val list = mutableListOf<LineitemCheckout>()
        listOfDeleteCartItems.clear()
        var count = 1
        var totalSubtotal = 0.0
        var totalQuantity = 0
        var quickShip =true
        cartListItem.map {
            if ((sharedPrefManager.getSelectedDelivery() != null && (sharedPrefManager.getSelectedDelivery() == "isdeliveryon") ||
                (sharedPrefManager.getSelectedDelivery() == "isdeliveryby")) || pickupFlag){
                quickShip = false
            }
            list.add(LineitemCheckout(it.supplier, count, it.quantity, quickShip, "cheapest_freight"))
            count++
            totalSubtotal += it.itemSubtotal.replace(",", "").removePrefix("$").toDouble()
            totalFreight += it.freight
            totalQuantity += it.quantity
            listOfDeleteCartItems.add(DeleteCartItems(it.supplier, sharedPrefManager.getUserName().toString(),sharedPrefManager.getLocationNumber().toString()))
        }
        binding.tvSubtotalValue.text =  convertAmount(valuesToDisplay.subTotalValue.toString()) //convertAmount( totalSubtotal.toString())
        binding.tvFreight.text =  convertAmount(valuesToDisplay.freightValue.toString()) //convertAmount( totalFreight.toString())
        binding.tvTotalQty.text = totalQuantity.toString()
        binding.tvTotalValue.text = convertAmount(valuesToDisplay.orderTotal.toString()) //convertAmount( (totalSubtotal + totalFreight).toString())
        listItems = list
    }

    private fun updateTheme(){
        when (sharedPrefManager.getProfileSelected()) {
            Constants.TIRE_PROS -> {

                val color = ContextCompat.getColor(binding.root.context, R.color.red)
                binding.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.ivCity.setImageResource(R.drawable.addreshome_tirepros)
                binding.viewConsumerName.setBackgroundColor(color)
                binding.viewPoNumber.setBackgroundColor(color)
                binding.etComments.setBackgroundDrawable(resources.getDrawable(R.drawable.comments_background_tirepros))
            }
            Constants.ATD_ONLINE -> {
                val color = ContextCompat.getColor(binding.root.context, R.color.atd_blue)
                binding.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.ivCity.setImageResource(R.drawable.addreshome)
                binding.viewConsumerName.setBackgroundColor(color)
                binding.viewPoNumber.setBackgroundColor(color)
                binding.etComments.setBackgroundDrawable(resources.getDrawable(R.drawable.comments_background))

            }
        }
    }

     private fun convertAmount(amount: String): String {
        val decimalFormat = DecimalFormat("#,###,##0.00")
        return "$" + decimalFormat.format(amount.toDouble())
    }

    override fun onResume() {
        super.onResume()
        binding.progressbar.gone()
    }

    private fun bindObserver() {
        var isFirstLoading = true
        var isLoading = false
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                checkoutViewModel.placeOrderFlow.collect {
                    when (it) {
                        is NetworkResult.Success -> {
                            hideProgressBar()
                            val confirmationNumber = it.data?.order?.confirmationnumber
                            val currentTime = Date()
                            val dateFormatter =
                                SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
                            val formattedTime = dateFormatter.format(currentTime)
                            val placeOrder = PlaceOrder(
                                confirmationNumber.toString(),
                                binding.etConsumerName.text.toString(),
                                binding.etPoNumber.text.toString(),
                                formattedTime,
                                data = it.data,
                                cartListItem = cartListItem
                            )
                            checkoutViewModel.deleteRecord(listOfDeleteCartItems)
                            sharedPrefManager.removeSelectedDelivery()
                            sharedPrefManager.removeNeedByDate()
                            dismiss()
                            checkoutListener?.onDataTransferred(placeOrder)
                        }
                        is NetworkResult.Error -> {
                            hideProgressBar()
                            toast(it.message.toString())
                        }
                        is NetworkResult.Loading -> {
                            if (isFirstLoading) {
                                isFirstLoading = false
                                isLoading = true
                            } else {
                                if (isLoading) {
                                    binding.tvPlaceOrder.isClickable = false
                                    showProgressBar()
                                } else {
                                    hideProgressBar()
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private fun selectFreightCharges() {
        binding.ivFreightCheck.setOnClickListener {
            if(!sharedPrefManager.getPORegex().isNullOrBlank()) {
                if(binding.etPoNumber.text.toString().matches(Regex(sharedPrefManager.getPORegex().toString()))){
                    if (binding.ivFreightCheck.tag.equals("false")) {
                        binding.ivFreightCheck.setImageResource(R.drawable.checkbox_selected)
                        binding.ivFreightCheck.tag = "true"
                        if (binding.etPoNumber.text.toString() != "") {
                            binding.tvPlaceOrder.isClickable = true
                            isFlag = true
                            when (sharedPrefManager.getProfileSelected()){
                                Constants.TIRE_PROS -> {
                                    binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                    binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                }
                                Constants.ATD_ONLINE -> {
                                    binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                    binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                }
                            }
                        }
                    } else {
                        binding.ivFreightCheck.setImageResource(R.drawable.checkbox_unselected)
                        binding.ivFreightCheck.tag = "false"
                        if (binding.etPoNumber.text.toString() != "") {
                            binding.tvPlaceOrder.isClickable = false
                            isFlag = false
                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.dim_gray))
                        }
                    }
                }

            } else {
                if (binding.ivFreightCheck.tag.equals("false")) {
                    binding.ivFreightCheck.setImageResource(R.drawable.checkbox_selected)
                    binding.ivFreightCheck.tag = "true"
                    if (binding.etPoNumber.text.toString() != "") {
                        binding.tvPlaceOrder.isClickable = true
                        isFlag = true
                        when (sharedPrefManager.getProfileSelected()){
                            Constants.TIRE_PROS -> {
                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                            }
                            Constants.ATD_ONLINE -> {
                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                            }
                        }
                    } else {
                        //po is not mandatory
                        binding.tvPlaceOrder.isClickable = true
                        isFlag = true
                        when (sharedPrefManager.getProfileSelected()){
                            Constants.TIRE_PROS -> {
                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                            }
                            Constants.ATD_ONLINE -> {
                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                            }
                        }
                    }
                } else {
                    binding.ivFreightCheck.setImageResource(R.drawable.checkbox_unselected)
                    binding.ivFreightCheck.tag = "false"
                    if (binding.etPoNumber.text.toString() != "") {
                        binding.tvPlaceOrder.isClickable = false
                        isFlag = false
                        binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                        binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.dim_gray))
                    } else {
                        //for po number is not mandatory if checkbox unchecked...
                        binding.tvPlaceOrder.isClickable = false
                        isFlag = false
                        binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                        binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.dim_gray))
                    }
                }
            }
        }
    }

    private fun isFreightMessageEnabled(){
        if (totalFreight > 0) {
            binding.tvFreightMsg.visible()
            binding.tvFreightCheckMsg.visible()
            binding.ivFreightCheck.visible()
        }else {
            binding.tvFreightMsg.gone()
            binding.tvFreightCheckMsg.gone()
            binding.ivFreightCheck.gone()
        }
    }


    private fun enablePlaceOrder() {
        val editTexts = listOf(binding.etPoNumber)
        isFreightMessageEnabled()
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val et1 = binding.etPoNumber.text.toString().trim()
                    if(!sharedPrefManager.getPORegex().isNullOrBlank()) {
                        if (et1.isNotEmpty() && et1.matches(Regex(sharedPrefManager.getPORegex().toString()))) {
                            binding.ivPoError.gone()
                            binding.tvPoErrorMsg.gone()
                            if (totalFreight > 0) {
                                binding.tvFreightMsg.visible()
                                binding.tvFreightCheckMsg.visible()
                                binding.ivFreightCheck.visible()
                                if (binding.ivFreightCheck.tag.equals("true")) {
                                    binding.tvPlaceOrder.isClickable = true
                                    when (sharedPrefManager.getProfileSelected()){
                                        Constants.TIRE_PROS -> {
                                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                        }
                                        Constants.ATD_ONLINE -> {
                                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                        }
                                    }
                                    isFlag = true
                                    poNumber = et1
                                }
                            } else {
                                binding.tvFreightMsg.gone()
                                binding.tvFreightCheckMsg.gone()
                                binding.ivFreightCheck.gone()
                                binding.tvPlaceOrder.isClickable = true
                                when (sharedPrefManager.getProfileSelected()){
                                    Constants.TIRE_PROS -> {
                                        binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                        binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                    }
                                    Constants.ATD_ONLINE -> {
                                        binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                        binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                    }
                                }
                                isFlag = true
                                poNumber = et1
                            }
                        } else {
                            binding.ivPoError.visible()
                            binding.tvPoErrorMsg.visible()
                            isFlag = false
                            binding.tvPlaceOrder.isClickable = false
                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.dim_gray))
                        }
                    } else {
                            if (et1.isNotEmpty()) {
                                if (totalFreight > 0) {
                                    binding.tvFreightMsg.visible()
                                    binding.tvFreightCheckMsg.visible()
                                    binding.ivFreightCheck.visible()
                                    if (binding.ivFreightCheck.tag.equals("true")) {
                                        binding.tvPlaceOrder.isClickable = true
                                        when (sharedPrefManager.getProfileSelected()){
                                            Constants.TIRE_PROS -> {
                                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                            }
                                            Constants.ATD_ONLINE -> {
                                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                            }
                                        }
                                        isFlag = true
                                        poNumber = et1
                                    }
                                } else {
                                    binding.tvFreightMsg.gone()
                                    binding.tvFreightCheckMsg.gone()
                                    binding.ivFreightCheck.gone()
                                    binding.tvPlaceOrder.isClickable = true
                                    when (sharedPrefManager.getProfileSelected()){
                                        Constants.TIRE_PROS -> {
                                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                        }
                                        Constants.ATD_ONLINE -> {
                                            binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                            binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.white))
                                        }
                                    }
                                    isFlag = true
                                    poNumber = et1
                                }
                            } else {

                                isFlag = false
                                binding.tvPlaceOrder.isClickable = false
                                binding.tvPlaceOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                                binding.tvPlaceOrder.setTextColor(resources.getColor(R.color.dim_gray))
                            }
                    }


                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int, after: Int,
                ) {
                }

                override fun afterTextChanged(
                    s: Editable,
                ) {
                }
            })
        }
    }


    private fun showProgressBar() {
        binding.progressbar.visible()
    }

    private fun hideProgressBar() {
        binding.progressbar.gone()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun backPressed() {
        binding.ivBack.setOnClickListener {
            dismiss()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        previousDialogFragment =
            parentFragmentManager.findFragmentByTag(CartFragment.TAG) as? DialogFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface CheckoutListener {
        fun onDataTransferred(data: PlaceOrder)
    }


}
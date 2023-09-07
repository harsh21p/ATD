package com.atd.atdmobileapp.ui.cart

import android.app.Dialog
import android.content.res.ColorStateList

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentCartBinding
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.cart.checkout.CheckoutFragment
import com.atd.atdmobileapp.ui.cart.quantityanddelivery.QuantityAndDeliveryFragment
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.getEcomProductsFormCartDetails
import com.atd.atdmobileapp.utils.Common.makeFirebaseEventBundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment() : DialogFragment() ,
    CheckoutFragment.CheckoutListener {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val cartViewModel by viewModels<CartViewModel>()
    private var filterList = mutableListOf<Cart?>()
    private var cartItemList = mutableListOf<CartItem>()
    private lateinit var cartAdapter: CartAdapter
    private  var transferredData: PlaceOrder ? =null
    private lateinit var mainViewModel: MainViewModel
    private var fetTotal: Double = 0.0
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private val permissionViewModel by viewModels<LoginViewModel>()
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private var triggerBadgeCount: ((data: PlaceOrder) -> Unit)? = null
    constructor(triggerBadgeCount: (data: PlaceOrder) -> Unit) : this() {
        this.triggerBadgeCount = triggerBadgeCount
    }

    companion object{
        const val TAG ="CartFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        cartAdapter = CartAdapter(::onDeleteCart, ::onQuantityAndEditClick,sharedPrefManager)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        sharedPrefManager.getProfileSelected()?.let { permissionViewModel.getCheckPermission(
            it,
            "VIEW_PRODUCT_COSTS"
        ) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLocationDetails.text = "Location # " + sharedPrefManager.getLocationNumber()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = cartAdapter
        cartViewModel.getAllCartRecords(sharedPrefManager.getUserName().toString(), sharedPrefManager.getLocationNumber().toString())
        bindObservers()
        backPressed()
        binding.tvLocal.text = sharedPrefManager.getLocal()
        binding.tvLocalPlus.text = sharedPrefManager.getLocalPlus()
        checkOutClick()
        binding.tvCheckoutNow.isClickable =false
        binding.tvContinueShopping.isClickable =false
        onClickSearchIcon()
        updateTheme()
        permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

            when(it){

                is NetworkResult.Success ->{
                    if(it.data.equals("VIEW_PRODUCT_COSTS",true)){

                        cartAdapter.checkProductCost(true)
                        cartAdapter.notifyDataSetChanged()
                    }else{
                        cartAdapter.checkProductCost(false)
                        cartAdapter.notifyDataSetChanged()

                    }
                }
                is NetworkResult.Error -> {
                    toast(it.message)


                }
                is NetworkResult.Loading -> {

                }
            }
        })

    }

    private fun onClickSearchIcon() {
        binding.cardHeader.ivSearch.setOnClickListener {
            replaceWithHomeTabFrag()
        }
    }

    private fun replaceWithHomeTabFrag() {
        dialog?.dismiss()
        BottomNavigationScreenFragment.tvHeaderText?.text = ""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros", true)) {
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)

            } else if (it.equals("atdonline", true)) {
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

    private fun bindObservers() {
        cartViewModel.userLiveData.observe(viewLifecycleOwner) { cart ->
            filterList = cart.filter {
                it?.userName.equals(sharedPrefManager.getUserName()) && it?.locationNumber.equals(
                    sharedPrefManager.getLocationNumber()
                )
            } as MutableList<Cart?>
            updateView(filterList)
        }
        cartViewModel.loadingLiveData.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) binding.progressbar.visible() else binding.progressbar.gone()
        }
        cartViewModel.cartResponseLiveData.observe(viewLifecycleOwner) {
            binding.progressbar.gone()
            when (it) {
                is NetworkResult.Success -> {
                    binding.tvCheckoutNow.isClickable =true
                    binding.tvContinueShopping.isClickable =true
                    val cartResponse = it.data
                    println("it.data...."+it.data)
                    cartItemList.clear()
                    fetTotal =0.0
                     var subTotal: Double = 0.0
                    var quantity: Int = 0
                    var quantityBackOrder: Int = 0
                    var quantityBackOrderString = ""
                    val orderTotal = cartResponse?.order?.ordertotal.toString().toDouble()
                    cartResponse?.order?.orderlines?.map { lineItem ->
                        val iterator = filterList.iterator()
                        while (iterator.hasNext()) {
                            val cart = iterator.next()
                            if (cart?.atdProductNumber == lineItem.atdproductnumber) {
                                subTotal += lineItem.linetotal
                                fetTotal += lineItem.fet
                                val cost = convertAmount( lineItem.cost.toString())
                                val fet = " + " + convertAmount(lineItem.fet.toString()) + " FET"
                                val itemSubTotal = convertAmount( lineItem.linetotal.toString())
                                var freight: Double = 0.0
                                lineItem.fulfillments.map { fulfillment ->
                                    freight += fulfillment.freight
                                    when (fulfillment.status) {
                                        "KILLED" -> {
                                            quantity = lineItem.quantityordered - fulfillment.qty
                                            if (quantity == 0) {
                                                // Delete the record
                                                val documentName =
                                                    sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber() + "-" + lineItem.atdproductnumber
                                                cartViewModel.deleteUser(documentName)
                                                iterator.remove()
                                                return@map
                                            }
                                        }
                                        "BACKORDERED" -> {
                                            quantity = lineItem.quantityordered
                                            quantityBackOrder = fulfillment.qty
                                            quantityBackOrderString = " Backordered"
                                        }
                                        "FILLED" -> {
                                            quantity = lineItem.quantityordered
                                            quantityBackOrder =0
                                        }
                                    }
                                }
                                cartItemList.add(
                                    CartItem(
                                        cart.brand, cart.style, cart.description, quantity,
                                        quantityBackOrder, quantityBackOrderString, cart.productImage,
                                        cart.atdProductNumber, cost, fet, freight,itemSubTotal, lineItem.discontinued
                                    )
                                )
                               // binding.tvFreightValue.text = convertAmount(freight.toString())
                                binding.tvTotalValue.text = convertAmount(orderTotal.toString())
                                val distinctListItem=removeDuplicateCart(cartItemList)
                                setCartItems(distinctListItem, orderTotal)
                                setBadgeCount(getTotalQuantity(distinctListItem))
                                cartAdapter.submitList(distinctListItem)
                                visitCartScreenEvent(distinctListItem)
                                cartAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
                is NetworkResult.Error -> {
                    toast(it.message)
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }
        cartViewModel.deleteStatus.observe(viewLifecycleOwner) {
            if (it) {
                cartViewModel.getAllCartRecords(sharedPrefManager.getUserName().toString(), sharedPrefManager.getLocationNumber().toString())
            }
        }
    }

    private fun visitCartScreenEvent(cartItems: MutableList<CartItem>) {
        val atdProduct = getEcomProductsFormCartDetails(cartItems)
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            screen = Screen.Cart,
            action = Action.Impression,
            category = Category.Cart,
            label = "Cart view"
        )
        val toReturn = Common.getParcelableArrayViewCart(atdProduct)
        params.putParcelableArray(FirebaseAnalytics.Param.ITEMS, toReturn.toTypedArray())
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_CART, params)
    }

    private fun setCartItems(items: List<CartItem>, orderTotal: Double) {
        mainViewModel.cartItems.value = items
        var totalFreight =0.0
        items.map {
            totalFreight +=it.freight
        }
        binding.tvFreightValue.text = convertAmount(totalFreight.toString())
        binding.tvSubTotalValue.text = convertAmount((orderTotal-totalFreight).toString())
        mainViewModel.cartValuesToDisplay.value = CartDisplayValue(
            orderTotal = orderTotal,
            freightValue = totalFreight,
            subTotalValue = orderTotal - totalFreight
        )
    }

    private fun formatNumber(number: Double): String {
        return String.format("$%.2f", number)
    }

    fun convertAmount(amount: String): String {
        val decimalFormat = DecimalFormat("#,###,##0.00")
        return "$" + decimalFormat.format(amount.toDouble())
    }

    private fun removeDuplicateCart(cartItemList: List<CartItem>) :MutableList<CartItem>{
        val distinctCartItemList = cartItemList.distinctBy {
            it.supplier to it.quantityBackOrder
        }.toMutableList()

        distinctCartItemList.removeIf { item ->
            item.quantityBackOrder == 0 &&
                    distinctCartItemList.any {
                        it.supplier == item.supplier &&
                                it.quantityBackOrder != 0
                    }
        }
        return distinctCartItemList.toMutableList()
    }

    fun getTotalQuantity(cartItemList: List<CartItem>): Int {
        var totalQuantity = 0
        for (cartItem in cartItemList) {
            totalQuantity += cartItem.quantity
        }
        return totalQuantity
    }

    private fun updateView(value: List<Cart?>) {
        if (value.isEmpty()) {
            binding.tvLocal.inVisible()
            binding.tvLocalPlus.gone()
            binding.tvSubTotal.gone()
            binding.tvSubTotalValue.gone()
            binding.tvFreight.gone()
            binding.tvFreightValue.gone()
            binding.tvTotal.gone()
            binding.tvTotalValue.gone()
            binding.recyclerView.gone()
            binding.buttonRow.gone()
            binding.ivEmptyCart.visible()
            binding.tvCartEmpty.visible()
            binding.tvCartHint.visible()
            setBadgeCount(0)
        } else {
            binding.tvLocal.visible()
            binding.tvLocalPlus.visible()
            binding.tvSubTotal.visible()
            binding.tvSubTotalValue.visible()
            binding.tvFreight.visible()
            binding.tvFreightValue.visible()
            binding.tvTotal.visible()
            binding.tvTotalValue.visible()
            binding.recyclerView.visible()
            binding.buttonRow.visible()
            binding.ivEmptyCart.gone()
            binding.tvCartEmpty.gone()
            binding.tvCartHint.gone()

            val order = Order(
                "testpo", "testcomment",
                "true", "d", "false", prepareListOfLineItems(value)
            )
            val cartRequest = CartRequest(sharedPrefManager.getLocationNumber().toString(), order)
            println("reqn ->${Gson().toJson(cartRequest)}")
            cartViewModel.getCartDetails(cartRequest)
        }
    }

    private fun prepareListOfLineItems(value: List<Cart?>): List<Lineitem> {
        return value.map { it ->
            Lineitem(
                it?.atdProductNumber.toString(),
                it?.quantity!!.toInt(),
                "cheapest_freight",
                1
            )
        }
    }

    private fun onDeleteCart(supplier: String) {
        val documentName =
            sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber() + "-" + supplier
        showDialog(documentName, supplier)
    }

    private fun onQuantityAndEditClick(cartItem: CartItem){
        mainViewModel.updateCartItemDetails(cartItem)
        val quantityAndDeliveryFragment = QuantityAndDeliveryFragment {
            onSaveClick()
        }
        quantityAndDeliveryFragment.show(parentFragmentManager, QuantityAndDeliveryFragment.TAG)
    }

    private fun onSaveClick(){
        cartViewModel.getAllCartRecords(sharedPrefManager.getUserName().toString(),sharedPrefManager.getLocationNumber().toString())
    }

    private fun checkOutClick(){
        binding.tvCheckoutNow.setOnClickListener {
            val checkoutFragment = CheckoutFragment()
            checkoutFragment.checkoutListener = this
            checkoutFragment.show(requireActivity().supportFragmentManager, CheckoutFragment.TAG)
        }
    }
    override fun onDataTransferred(data: PlaceOrder) {
        transferredData = data
        dismiss()
    }

    private fun showDialog(documentId: String, supplier: String) {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_delete_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialog.findViewById(R.id.tvYes) as TextView
        val cancel = dialog.findViewById(R.id.tvCancel) as TextView
        okText.setOnClickListener {
            cartViewModel.deleteUser(documentId)
            //trying to retrieve cartItem with supplier number
            val productBeingDeleted = cartItemList.firstOrNull { it.supplier.equals(supplier, true) }
            //add deleteFromCart Event
            delProdFromCartEvent(productBeingDeleted)
            dialog.dismiss()
        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun delProdFromCartEvent(productBeingDeleted: CartItem?) {
        val params  = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            screen = Screen.Cart,
            action = Action.Click,
            category = Category.Cart,
            label = "Item removed"
        )
        var atdProduct:MutableList<EcomProduct> = mutableListOf()
        if (productBeingDeleted != null){
            atdProduct = getEcomProductsFormCartDetails(mutableListOf(productBeingDeleted))
        }
        val toReturn = Common.getParcelableArrayViewCart(atdProduct)
        params.putParcelableArray(FirebaseAnalytics.Param.ITEMS, toReturn.toTypedArray())
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Remove_From_Cart, params)
    }


    private fun setBadgeCount(count: Int) {
        if (count > 0) {
            binding.cardHeader.badgeCount.visibility = View.VISIBLE
            binding.cardHeader.badgeCount.text = count.toString()
            BottomNavigationScreenFragment.badgeCount?.visible()
            BottomNavigationScreenFragment.badgeCount?.text=count.toString()
            binding.tvSubTotal.text = "Subtotal ( "+count.toString() +" items) (includes " +formatNumber(fetTotal) +"FET)"
        } else {
            BottomNavigationScreenFragment.badgeCount?.text=count.toString()
            BottomNavigationScreenFragment.badgeCount?.gone()
            binding.cardHeader.badgeCount.visibility = View.GONE
        }
    }

    private fun updateTheme(){
        when (sharedPrefManager.getProfileSelected()) {
            Constants.TIRE_PROS -> {

                val color = ContextCompat.getColor(binding.root.context, R.color.red)
                binding.cardHeader.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.cardHeader.ivSearch.imageTintList = ColorStateList.valueOf(color)
                binding.cardHeader.ivCart.imageTintList = ColorStateList.valueOf(color)
                binding.tvCheckoutNow.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                binding.tvCheckoutNow.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
                binding.tvContinueShopping.setBackgroundDrawable(resources.getDrawable(R.drawable.carved_background_24_tireprose))
                binding.tvContinueShopping.setTextColor(color)
            }
            Constants.ATD_ONLINE -> {
                val color = ContextCompat.getColor(binding.root.context, R.color.atd_blue)
                binding.cardHeader.ivBack.imageTintList = ColorStateList.valueOf(color)
                binding.cardHeader.ivSearch.imageTintList = ColorStateList.valueOf(color)
                binding.cardHeader.ivCart.imageTintList = ColorStateList.valueOf(color)
                binding.tvCheckoutNow.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                binding.tvCheckoutNow.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
                binding.tvContinueShopping.setBackgroundDrawable(resources.getDrawable(R.drawable.carved_background_24))
                binding.tvContinueShopping.setTextColor(color)
            }
        }
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun backPressed() {
        binding.cardHeader.ivBack.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


    override fun dismiss() {
        dialog.let {
            it?.dismiss()
            transferredData?.let { it1 -> triggerBadgeCount?.let { it2 -> it2(it1) } }

        }
    }

}
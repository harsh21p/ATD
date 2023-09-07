package com.atd.atdmobileapp.ui.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentHomeScreenBinding
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest
import com.atd.atdmobileapp.models.locationconfig.Locationconfiguration
import com.atd.atdmobileapp.ui.bottomnavigation.account.AccountFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment
import com.atd.atdmobileapp.ui.cart.CartFragment
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.utils.Common.setDefaultUserPrefs
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.atd.atdmobileapp.utils.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BottomNavigationScreenFragment : Fragment() , BottomNavigationView.OnNavigationItemSelectedListener{


    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    var _binding : FragmentHomeScreenBinding? =null
    val binding get() = _binding!!
   private val configLocationViewModel by viewModels<ConfigLocationViewModel> ()
   private val rmdConfigLocationViewModel by viewModels<RMDConfigLocationViewModel> ()
    private var localCutOff = ""
    private var localPlusCutOff =""
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    var logo : Int=R.drawable.atdheader
    private val permissionViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    companion object {


        var atdLogo: TextView? =null
        var tvHeaderText: TextView? =null
        var atdHeader: RelativeLayout? =null
        var atdFooter: BottomNavigationView? =null
        var badgeCount :TextView?=null
        var theameColor : Int=R.color.atd_blue
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root
       // val view =inflater.inflate(R.layout.fragment_home_screen, container, false)
        atdLogo = binding.ivAtdLogo
        tvHeaderText = binding.tvHeaderText
        atdHeader = binding.atdHeader
        atdFooter = binding.bottomNavigationView
        badgeCount=binding.badgeCount


        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){

                logo=R.drawable.tp_mobile_logo
                theameColor=R.color.red
            }else if (it.equals("atdonline",true)){

                logo=R.drawable.atdheader
                theameColor=R.color.atd_blue

            }
        }

        SetUpTheme()
        onClickSearchIcon()

        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
       // binding.bottomNavigationView.setItemIconTintList(null);
        binding.bottomNavigationView.setSelectedItemId(R.id.home);

        sharedPrefManager?.getLocationNumber()?.let {
            val locationConfigRequest = ConfigLocationRequest(it)
            configLocationViewModel.ConfigLocations(locationConfigRequest)
        }
        configLocationViewModel.getMyOrders(sharedPrefManager.getLocationNumber().toString())

        //Adding logic to check if user prefs exists
        checkAndSetDefaultUserPreferences()

        binding.tvSaveOrder.setOnClickListener {

            toast("not yet implemented")
        }
         return root
    }

    private fun onClickSearchIcon() {
        binding.ivSearch.setOnClickListener {
            //trying to fins current displayed frag
            val fragManager = requireActivity().supportFragmentManager
            val containerId = R.id.bottomNavigationViewFrame
            val targetFrag = fragManager.findFragmentById(containerId)
            if (targetFrag is HomeTabFragment && targetFrag.isVisible){
                //we are on home tab already do nothing
            }else{
                //replace current frag with homeTabFrag
                replaceWithHomeTabFrag()
            }
        }
    }

    private fun replaceWithHomeTabFrag() {
        tvHeaderText?.text = ""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros", true)) {
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)

            } else if (it.equals("atdonline", true)) {
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)


            } else {

            }
        }
        val hostFragment = HomeTabFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }

    private fun SetUpTheme() {
        binding.ivAtdCart.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.ivSearch.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        tvHeaderText?.text=""
        atdLogo?.setCompoundDrawablesWithIntrinsicBounds( logo, 0, 0, 0);
        atdLogo?.setOnClickListener(null)
    }

    private fun checkAndSetDefaultUserPreferences() {
        if (sharedPrefManager.getUserPreferences().isNullOrEmpty()){
            val defaultUserPrefsToSave = setDefaultUserPrefs()
            //saving default prefs in sahred perf manager
            sharedPrefManager.saveUserPreferences(Gson().toJson(defaultUserPrefsToSave))
        }
    }

    val hostFragment = HomeTabFragment()
    val garageFragment = MyGarageFragment()
    val accountFragment = AccountFragment()

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        SetUpTheme()

        when (item.itemId)
        {
            R.id.home -> {

                binding.ClOrder.gone()
                binding.bottomNavigationViewFrame.visible()
                requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, hostFragment)
                    .commit();

                return true
            }
        R.id.myGarage -> {
            binding.ClOrder.gone()

            binding.bottomNavigationViewFrame.visible()
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, garageFragment)
                .commit();

            return true

        }
        R.id.account -> {
            binding.ClOrder.gone()

            binding.bottomNavigationViewFrame.visible()
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, accountFragment)
                .commit();
            return true

        }

        }
        return false
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartPage()
        configLocationViewModel.configLocationLivedata.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    it?.data?.let {
                        println("it.locat>>>$it")
                        savePoRequireAndPoRegex(it.locationconfigurations)
                            rmdConfigLocationViewModel.saveConfigLocation(it)
                    }
                }
                is NetworkResult.Error -> {
                }
                is NetworkResult.Loading -> {

                }
            }
        })
        SaveCutOffTimes()
        updateBadgeCount()

        parentFragmentManager.setFragmentResultListener(Constants.OESIZE_RESULT, this){_,result->
           //do something
        }
    }

    private fun SaveCutOffTimes(){
        configLocationViewModel.cutOffDatesResponseLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    it.data?.let {
                        if (it?.cutofftimes?.isNotEmpty() == true) {
                            if (it.cutofftimes.get(0).sourcetype.equals("LOCAL", true)) {

                                val cutOffDate = it?.cutofftimes[0]?.cutoffdate?.toString()
                                val deliveryDate = it?.cutofftimes[0]?.deliverdate?.toString()
                                sharedPrefManager.saveLocalPlusTime(it?.cutofftimes[0]?.cutofftime?.toString()
                                    ?.let { it1 -> Common.CutOffTime(it1) }.toString())
                                 localCutOff =
                                    "LOCAL : Order by ${
                                        it?.cutofftimes?.get(0)?.cutofftime?.toString()
                                            ?.let { it1 -> Common.CutOffTime(it1) }} ${
                                        cutOffDate?.let { it1 -> Common.getMonthDay(it1) }
                                    } for delivery ${deliveryDate?.let { it1 ->
                                        Common.getMonthDay(
                                            it1
                                        )
                                    }}"
                            }

                            if (it?.cutofftimes?.get(1)?.sourcetype?.toString().equals("LOCALPLUS", true)) {

                                val cutOffDate = it?.cutofftimes[1]?.cutoffdate?.toString()
                                val deliveryDate = it?.cutofftimes[1]?.deliverdate?.toString()
                                if (!cutOffDate.isNullOrBlank()&&!deliveryDate.isNullOrBlank()){
                                    sharedPrefManager.saveLocalPlusTime(it?.cutofftimes[1]?.cutofftime?.toString()
                                        ?.let { it1 -> Common.CutOffTime(it1) }.toString())
                                    localPlusCutOff=
                                        "LOCAL+ : Order by ${it?.cutofftimes[1]?.cutofftime?.toString()
                                            ?.let { it1 -> Common.CutOffTime(it1) }} ${
                                            cutOffDate?.let { it1 -> Common.getMonthDay(it1) }
                                        } for delivery ${deliveryDate?.let { it1 ->
                                            Common.getMonthDay(
                                                it1
                                            )
                                        }}"
                                }
                            }
                        }
                    }
                    sharedPrefManager.saveLocal(localCutOff)
                    sharedPrefManager.saveLocalPlus(localPlusCutOff)
                }
                is NetworkResult.Error -> {

                }
                is NetworkResult.Loading -> {

                }
            }
        }
    }

    private fun savePoRequireAndPoRegex(LocationConfigList: List<Locationconfiguration>) {
        LocationConfigList.map {
            if(it.configuration == "PORegex"){
                sharedPrefManager.savePORegex(it.value)
            }else if (it.configuration == "PO Required"){
                sharedPrefManager.savePoRequired(it.value)
            }
            if (it.configuration =="DELIVERY_DEFAULT"){
                println("delivery default value..."+it.value)
                sharedPrefManager.saveDeliveryDefault(it.value)
            }
        }
    }


    private fun updateBadgeCount() {

        configLocationViewModel.getAllCartRecords().observe(viewLifecycleOwner) { cartList ->
            val filteredCartList = cartList.filter {
                it?.userName.equals(sharedPrefManager.getUserName()) &&
                        it?.locationNumber.equals(sharedPrefManager.getLocationNumber())
            }
            val totalQuantity = getTotalQuantity(filteredCartList)
            setBadgeCount(totalQuantity)
        }
    }

    private fun setBadgeCount(count: Int) {
        if (count > 0) {
            binding.badgeCount.visibility = View.VISIBLE
            binding.badgeCount.text = count.toString()
        } else {
            binding.badgeCount.visibility = View.GONE
        }
    }

    private fun getTotalQuantity(cartList: List<Cart?>): Int {
        var totalQuantity = 0
        for (cartItem in cartList) {
            totalQuantity += cartItem!!.quantity
        }
        return totalQuantity
    }

    private fun triggerBadgeCount(data :PlaceOrder){
        updateBadgeCount()
        if(data != null){
            waitToast("Please wait as we are fetching your record")

            binding.ClOrder.visible()
            binding.bottomNavigationViewFrame.gone()
            binding.tvLocationNumber.text =getString(R.string.location_number) + sharedPrefManager.getLocationNumber()
            binding.tvOrderConfirmation.text ="Order Confirmation # "+data.OrderConfirmation
            binding.tvConsumerName.text ="Consumer Name: "+data.ConsumerName
            binding.tvPo.text ="PO #: "+data.Po
            binding.tvDate.text ="Date Placed: "+data.datePlace
            checkPlaceOrderStatus(data)
            CoroutineScope(Dispatchers.Main).launch {
                binding.tvViewOrder.isEnabled=false
                binding.tvViewOrder.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
                binding.progressbar.visible()
                delay(10000)
                binding.progressbar.gone()
                binding.tvViewOrder.isEnabled=true
                binding.tvViewOrder.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
            }
            binding.tvViewOrder.setOnClickListener {

                binding.ClOrder.gone()
                binding.bottomNavigationViewFrame.visible()

                sharedPrefManager.getProfileSelected()?.let { permissionViewModel.getCheckPermission(it,"APPROVE_ORDERS") }
                permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

                    when(it){

                        is NetworkResult.Success ->{


                           val orderPermissions=it.data
                            //APPROVE_ORDERS
                            println("orderPermissions $orderPermissions")
                            if(orderPermissions?.equals(Constants.APPROVE_ORDERS,true) == true){

                                val fragment = MyOrderDetailsFragment()
                                var bundle=Bundle()
                                bundle.putString("confirmationNumber",data.OrderConfirmation)
                                bundle.putString("orderStatus","")
                                bundle.putString(Constants.KEY_TYPE,Constants.MY_ORDERS)
                                fragment.arguments=bundle
                                requireActivity().supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.bottomNavigationViewFrame, fragment)
                                    .addToBackStack("MyOrderFragment")
                                    .commit()

                            }else{

                                val fragment = SubmitApprovalsFragment()
                                requireActivity().supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.bottomNavigationViewFrame, fragment)
                                    .addToBackStack("MyApprovalsFragment")
                                    .commit()
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



                }

        } else {
            binding.ClOrder.gone()
            binding.bottomNavigationViewFrame.visible()
        }

    }

    private fun checkPlaceOrderStatus(data: PlaceOrder) {
        if(sharedPrefManager.getProfileSelected().equals(Constants.ATD_ONLINE) ){
            if( sharedPrefManager.getApproveOrdersAtdOnline() != null){
                binding.tvOrder.text = getString(R.string.order_complete)
                binding.tvOrderMessage.text = getString(R.string.your_order_will_appear_shortly)
                //add order success event
                data.cartListItem?.let { orderSuccessEvent(data.data, it, true) }
            }else{
                binding.tvOrder.text = getString(R.string.order_submitted_for_approval)
                binding.tvOrderMessage.text = getString(R.string.your_order_will_appear_in_my_orders_momentarily)
                data.cartListItem?.let { orderSuccessEvent(data.data, it, false) }
            }

        }else if(sharedPrefManager.getProfileSelected().equals(Constants.TIRE_PROS)) {
            if(sharedPrefManager.getApproveOrdersTirePros() != null){
                binding.tvOrder.text = getString(R.string.order_complete)
                binding.tvOrderMessage.text = getString(R.string.your_order_will_appear_shortly)
                //add order success event
                data.cartListItem?.let { orderSuccessEvent(data.data, it, true) }
            }else{
                binding.tvOrder.text = getString(R.string.order_submitted_for_approval)
                binding.tvOrderMessage.text = getString(R.string.your_order_will_appear_in_my_orders_momentarily)
                data.cartListItem?.let { orderSuccessEvent(data.data, it, false) }

            }
        }

    }
    private fun orderSuccessEvent(data: CheckoutResponse?, cartListItem: List<CartItem>, isPlaceOrder: Boolean) {
        val complexParams = data?.order?.let { Common.getEcomPurchaseItems(order = it, cartItems = cartListItem) }

        val arrayList: ArrayList<EcomPurchaseItem> = ArrayList()
        if (complexParams != null) {
            arrayList.addAll(complexParams)
        }

        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Order_Confirmation,
            Category.Place_Order,
            Action.Impression,
            label = if (isPlaceOrder){
                "Order placed"
            }else{
                "Order Pending"
            }
        )

        val toReturn = Common.getParcelableArray(complexParams)
        params.putParcelableArray(FirebaseAnalytics.Param.ITEMS, toReturn.toTypedArray())
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.PURCHASE, params)
    }
    private fun cartPage(){
        val placeOrder= this.arguments?.getString("placeOrder")
        if (placeOrder!=null){
            val placeOrderObject= Gson().fromJson(placeOrder,PlaceOrder::class.java)
            triggerBadgeCount(placeOrderObject)
            println("placeOrder==> $placeOrder")
        }
        binding.ivAtdCart.setOnClickListener {
            val cartFragment = CartFragment { data ->
                triggerBadgeCount(data)
            }
            cartFragment.show(requireActivity().supportFragmentManager, CartFragment.TAG)
            tapCartIconEvent()
        }
    }

    private fun tapCartIconEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Any,
            Category.Cart,
            Action.Click,
            "Cart icon"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Header_Nav, params)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null

    }



}
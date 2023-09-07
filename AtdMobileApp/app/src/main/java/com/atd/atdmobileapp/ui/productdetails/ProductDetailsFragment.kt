package com.atd.atdmobileapp.ui.productdetails

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentProductDetailsBinding
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.PlaceOrder
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.mylist.Productlists
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.cart.CartFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.ui.mylists.MyListDetailsFragment
import com.atd.atdmobileapp.ui.product.ProductViewModel
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import javax.inject.Inject


@AndroidEntryPoint
class ProductDetailsFragment() : Fragment() {


    private var themeColor: Int=R.color.black
    private lateinit var dimensionsAdapter: ProductAttributesAdapter
    private lateinit var capacityAdapter: ProductAttributesAdapter
    private lateinit var performanceAdapter: ProductAttributesAdapter
    private lateinit var precisionAdapter: ProductAttributesAdapter
    private lateinit var productInformationAdapter: ProductAttributesAdapter
    private lateinit var safetyAdapter: ProductAttributesAdapter
    private lateinit var weatherAdapter: ProductAttributesAdapter
    private lateinit var lugsAdapter: ProductAttributesAdapter
    private lateinit var finishAdapter: ProductAttributesAdapter
    var _binding : FragmentProductDetailsBinding?=null
    private val binding get() = _binding!!
    private val productViewModel by viewModels<ProductViewModel>()
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    private val recentKeywordSearchViewModel by viewModels<RecentKeywordSearchViewModel>()

    private val permissionViewModel by viewModels<LoginViewModel>()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var searchType: String
    private  var type: String?=""


    companion object {
        fun newInstance() = ProductDetailsFragment()
       lateinit var tvDimentions:TextView
       lateinit var tvPerformance:TextView
        lateinit var tvPrecision:TextView
        lateinit var tvSafety:TextView
        lateinit var tvWeather:TextView
        lateinit var tvProductInformation:TextView
        lateinit var tvSize:TextView
        lateinit var tvFinish:TextView
        lateinit var tvFitment:TextView
        lateinit var tvLugs:TextView
        lateinit var tvWheelHub:TextView
    }

    var bundle: Bundle?=null

    lateinit var product : Product
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding= FragmentProductDetailsBinding.inflate(inflater,container,false)



        sharedPrefManager.getProfileSelected()?.let {
            permissionViewModel.getCheckPermission(it, "VIEW_PRODUCT_COSTS")

            if (it.equals("tirepros",true)){
                themeColor=R.color.red
            }else if (it.equals("atdonline",true)){
                themeColor=R.color.atd_blue
            }
        }.also {
            setUpTheme(themeColor)
        }
        productViewModel.getOtherBrands(BrandsRequest(sharedPrefManager.getLocationNumber().toString()))
        bundle= this.arguments
        val details = bundle?.getString("productDetails")
        searchType = bundle?.getString("category") ?: ""
        type = bundle?.getString(Constants.KEY_TYPE) ?: ""

        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        product = Gson().fromJson(details,Product::class.java)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
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

        tvDimentions= binding.tvDimensions
        tvPerformance= binding.tvPerformance
        tvPrecision= binding.tvPrecision
        tvSafety= binding.tvSafety
        tvWeather= binding.tvWeather
        tvProductInformation= binding.tvProductInformation
        tvSize= binding.tvSize
        tvFinish= binding.tvFinish
        tvFitment= binding.tvFitment
        tvLugs= binding.tvLugs
        tvWheelHub= binding.tvWheelHub


        tvDimentions.gone()
        binding.rvDimensions.gone()
        tvPerformance.gone()
        binding.rvPerformance.gone()
        tvPrecision.gone()
        binding.rvPrecision.gone()
        tvSafety.gone()
        binding.rvSafety.gone()
        tvWeather.gone()
        binding.rvWeather.gone()
        tvProductInformation.gone()
        binding.rvProductInformation.gone()
        tvSize.gone()
        binding.rvSize.gone()
        tvFinish.gone()
        binding.rvFinish.gone()
        tvFitment.gone()
        binding.rvFitment.gone()
        tvLugs.gone()
        binding.rvLugs.gone()
        tvWheelHub.gone()
        binding.rvWheelHub.gone()

        setupUI(product)

        binding.tvProductName.text=product?.brand+" "+product?.style?.toString()
        Glide.with(requireActivity())
            .load(product?.images?.large?.image?.get(0)?.url)
            .placeholder(R.drawable.image_not_available)
            .error(R.drawable.image_not_available)
            .into(binding.ivProduct)

        var productGroup:String=""
        if (product?.productgroup?.lowercase()?.contains("wheels",true) == true){

                productGroup="${product?.productspec?.size?.trim().toString()} ${product?.productspec?.offset?.trim().toString()}"
                binding.tvProductGroup.text=productGroup.replace("null","")
        }else if (product?.productgroup?.lowercase()?.contains("tires",true) == true){

            productGroup="${product?.productspec?.size?.trim().toString()} ${product?.productspec?.loadindex?.trim().toString()}${product?.productspec?.speedrating?.trim().toString()} ${product?.productspec?.utqg?.trim().toString()}"
            binding.tvProductGroup.text=productGroup.replace("null","")

        }else if (product?.productgroup?.lowercase()?.contains("supplies ",true) == true){

            productGroup="${product?.productspec?.size?.trim().toString()}"
            binding.tvProductGroup.text=productGroup.replace("null","")

        }else{

        }

        if (product?.price?.retail!! >0) {
            binding.tvRetailPrice.text =
                Constants.Dollar + product?.price?.retail?.let { roundOffDecimal(it) }.toString()
        }else{
            binding.tvRetailPrice.gone()
        }
        product?.price?.fet?.let {
            if(it!=0.0)  binding.tvFet.text=Constants.Dollar+ roundOffDecimal(it)+" FET" else  binding.tvFet.gone()
        }
        product?.price?.map?.let {

            if(it!=0.0)  binding.tvMap.text= Constants.Dollar+roundOffDecimal(it)+" MAP" else  binding.tvMap.gone()
        }
        product?.price?.cost?.let {
                if(it>0){
                    binding.tvCost.visible()
                    binding.tvCost.text= Constants.Dollar+roundOffDecimal(it)+" Cost"
                }
            }

        product?.availability?.local?.let {

            if(it<=0) {
                binding.tvLocalValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
            }else {
                binding.tvLocalValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.green))
            }
            if(it>98) binding.tvLocalValue.text="99+" else binding.tvLocalValue.text= it.toString()

        }

        product?.availability?.localplus?.let {

            if(it<=0) {
                binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
            }else {
                binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.green))
            }
            if(it>98) binding.tvLocalPlusValue.text="99+" else binding.tvLocalPlusValue.text= it.toString()

        }

        product?.availability?.nationwide?.let {

            if(it<=0) {
                binding.tvNationalValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
            }else {

                binding.tvNationalValue.setTextColor(ContextCompat.getColor(requireActivity(), R.color.green))
            }
            if(it>98)  binding.tvNationalValue.text="99+" else  binding.tvNationalValue.text= it.toString()

        }

        binding.tvOutofTheDoor.gone()
        if (product?.productgroup?.lowercase()?.contains("tire",true) == true){

            binding.tvWarranty.text="Warranty"
            binding.tvSupplier.text="Supplier #"
            binding.tvSidewall.text="Sidewall"
            binding.tvWarrantyValue.text= product?.productspec?.mileagewarranty?.toString()
            binding.tvSidewallValue.text= product?.productspec?.sidewall?.toString()
            binding.tvSupplierValue.text= product?.mfgproductnumber?.toString()


        }else if (product?.productgroup?.lowercase()?.contains("wheel",true) == true) {

            binding.tvWarranty.text="Bolt Pattern"
            binding.tvSidewall.text="Finish"
            binding.tvWarrantyValue.text=product?.productspec?.boltpattern1?.toString()
            binding.tvSidewallValue.text=product?.productspec?.atdfinish?.toString()

        }else if (product?.productgroup?.lowercase()?.contains("supplies",true) == true) { //supplies
            binding.tvSupplier.text="Supplier #"
            binding.tvSupplierValue.text= product?.mfgproductnumber?.toString()


        }else  { //supplies
            binding.tvSupplier.text="Supplier #"
            binding.tvSupplierValue.text= product?.mfgproductnumber?.toString()

        }

        product?.marketingprograms?.size?.let {
            if(it>0) binding.ivMrktprgm.visible() else binding.ivMrktprgm.gone()
        }
        if (product?.valuebuysproduct==true) binding.ivValueBuys.visible() else binding.ivValueBuys.gone()
        if (product?.productspec?.winterdesignation?.lowercase()?.contains("3 peak",true) == true) binding.iv3Peak.visible() else binding.iv3Peak.gone()
        if (product?.productspec?.winterdesignation?.lowercase()?.contains("winter",true) == true) binding.ivWinter.visible() else binding.ivWinter.gone()

        product?.rebates?.size?.let {
            if(it>0) binding.tvRebate.visible() else binding.tvRebate.gone()
        }


        product?.marketingprograms?.size?.let {
            if(it >0){
                product?.marketingprograms?.get(0)?.programid?.lowercase().let {

                    if (it != null) {
                        if (it.contains("total-access")) binding.ivtotalAccess.visible() else binding.ivtotalAccess.gone()
                    }
                }
            }
        }


        if (product?.productspec?.hubcentricflag?.isNotEmpty() == true) binding.ivHubcentric.visible() else binding.ivHubcentric.gone()


        binding.llProductModel.setOnClickListener {
            var productKeyDialog = Dialog(requireActivity(), R.style.WideDialog)
            productKeyDialog.setContentView(R.layout.search_results_icon_key)
            var closeDialog: ImageView = productKeyDialog.findViewById(R.id.closeDialog)
            closeDialog.setOnClickListener {
                productKeyDialog.dismiss()
            }
            productKeyDialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
            productKeyDialog.show()
        }

        binding.tvProductName.setOnClickListener {
        if (binding.llProductCard.isVisible) {
            binding.llProductCard.gone()
        }else{
            binding.llProductCard.visible()
        }
        }

        binding.ivCVInactive.inVisible()


        binding.ivCVActive.setOnClickListener {

            //show the cost event
            tapCustomShowProdEvent()
            product?.price?.cost?.let {

               if( it>0 ) {
                   if (binding.tvCost.text.trim().isNotEmpty()) {
                       binding.tvCost.visible()
                   }
                   if (binding.tvMap.text.trim().isNotEmpty()) {
                       binding.tvMap.visible()
                   }
                   binding.tvOutofTheDoor.visible()
                   binding.tvCost.text = "${product?.price?.cost?.toString()} Cost"
                   binding.ivCVInactive.visible()
                   binding.ivCVActive.gone()
               }
            }


        }
        binding.ivCVInactive.setOnClickListener {

            //hide the cost event
            tapCustomHideProdEvent()
            binding.tvCost.gone()
            binding.tvMap.gone()
            binding.tvOutofTheDoor.gone()
            binding.ivCVInactive.inVisible()
            binding.ivCVActive.visible()

        }
        var quantity=binding.QtyValu.text.toString().toInt()
        binding.increaseQty.setOnClickListener {
            userQtyUpEvent()
            quantity+=1
            binding.QtyValu.setText(quantity.toString())
        }
        binding.decreaseQty.setOnClickListener {
            userQtyDownEvent()
            if (quantity>1) {
                quantity-=1
                binding.QtyValu.setText(quantity.toString())
            }
        }



        binding.tvAddCart.setOnClickListener {

            binding.progressbar.visible()
            if (binding.QtyValu.text.toString().toInt()>0) {
                if (sharedPrefManager.getDeliveryDefault().toString() == "Pickup" && sharedPrefManager.getSelectedDelivery() == null) {
                    if (binding.QtyValu.text.toString().toInt() > product.availability.local.toInt()) {
                        isCustomerPickupDelivery()
                        return@setOnClickListener

                    }

                } else if (sharedPrefManager.getSelectedDelivery() != null && sharedPrefManager.getSelectedDelivery() == "Pickup") {
                    if (binding.QtyValu.text.toString().toInt() > product.availability.local.toInt()) {
                        isCustomerPickupDelivery()
                        return@setOnClickListener
                    }

                }

                        val addCartDetails = Cart(
                            product.brand,
                            product.style,
                            binding.tvProductGroup.text.toString(),
                            binding.QtyValu.text.toString().toInt(),
                            product?.images?.thumbnail?.image?.get(0)?.url.toString(),
                            product.mfgproductnumber,
                            product.atdproductnumber,
                            sharedPrefManager.getUserName().toString(),
                            sharedPrefManager.getLocationNumber().toString(),
                            Common.currentDateTime(),
                            ""
                        )
                        onAddToCartClicked(addCartDetails)


            }
        }
        return binding.root
    }

    private fun setUpTheme(themeColor: Int) {

        binding.tvProductName.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.QtyValu?.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvAddToQuote?.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvViewMarketingPrograms?.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvViewRebates?.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvAddToList?.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvAddCart.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
        BottomNavigationScreenFragment.tvHeaderText?.text= Constants.Product_Details

        if (themeColor==R.color.red) {
            binding.tvProductName.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.rectangle_tirepros)
            binding.decreaseQty?.setBackgroundResource(R.drawable.decrese_tirepros)
            binding.increaseQty?.setBackgroundResource(R.drawable.increse_tirepros)
            binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24_tirepros)
            binding.ivCVInactive?.setBackgroundResource(R.drawable.cv_inactive_tirepros)
            binding.ivCVActive?.setBackgroundResource(R.drawable.cv_active_tirepros)
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)

        }else if (themeColor==R.color.atd_blue) {
            binding.tvProductName.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.rectangle)
            binding.decreaseQty?.setBackgroundResource(R.drawable.decrese)
            binding.increaseQty?.setBackgroundResource(R.drawable.increse)
            binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24)
            binding.ivCVInactive?.setBackgroundResource(R.drawable.cv_inactive)
            binding.ivCVActive?.setBackgroundResource(R.drawable.cv_active)
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)

        }

    }

    fun roundOffDecimal(number: Double): String {

        val formatter: NumberFormat = NumberFormat.getNumberInstance()
        formatter.setMinimumFractionDigits(2)
        formatter.setMaximumFractionDigits(2)
        val output: String = formatter.format(number)

        return output
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
        binding.progressbar.gone()

    }


    private fun userQtyDownEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Click,
            "Quantity decreased"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Quantity_Down, params)
    }

    private fun userQtyUpEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Click,
            "Quantity increased"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Quantity_Up, params)
    }

    private fun tapCustomHideProdEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Click,
            "Hide product cost"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Hide_Cost, params)
    }

    private fun tapCustomShowProdEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Click,
            "Show hidden product cost"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Show_Cost, params)

    }

    private fun onAddToCartClicked(cart: Cart){

        recentKeywordSearchViewModel.getCreatedCartRecordInFireStore(cart).observe(viewLifecycleOwner,
            Observer {cartList->

                val filteredCartList = cartList.filter {
                    it?.userName.equals(sharedPrefManager.getUserName()) &&
                            it?.locationNumber.equals(sharedPrefManager.getLocationNumber())
                }
                val totalQuantity = filteredCartList.sumOf { it!!.quantity }

                println("Updated records $filteredCartList")

                if (totalQuantity > 0) {
                    BottomNavigationScreenFragment.badgeCount?.visible()
                    BottomNavigationScreenFragment.badgeCount?.text = totalQuantity.toString()
                    showDialog()
                } else {
                    BottomNavigationScreenFragment.badgeCount?.gone()
                }

                binding.progressbar.gone()

            })

    }

    private fun showDialog() {
        val dialog = Dialog(requireActivity(), R.style.WideDialog)
        dialog.setContentView(R.layout.addcart_dialog)
        val continueShopping: TextView = dialog.findViewById(R.id.continueShopping)
        val checkOut: TextView = dialog.findViewById(R.id.checkoutNow)
        continueShopping.setOnClickListener {
            dialog.dismiss()
        }
        checkOut.setOnClickListener {
            val cartFragment = CartFragment { data ->
                triggerBadgeCount(data)
            }
            cartFragment.show(requireActivity().supportFragmentManager, CartFragment.TAG)
            //CartFragment(::triggerBadgeCount).show(requireActivity().supportFragmentManager, CartFragment.TAG)
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show()
    }
    private fun triggerBadgeCount( data :PlaceOrder){

        val placeOrder = Gson().toJson(data)
        val bundle = Bundle()
        bundle.putString("placeOrder", placeOrder)
        findNavController().navigate(R.id.fragment_keyword_results_to_bottom_noavigation,bundle)

    }

    private fun setupUI(product: Product) {

        var productGroupType= ""
        if (product?.productgroup?.lowercase()?.contains("tire",true) == true) {

            binding.rvDimensions.visible()
            binding.rvPerformance.visible()
            binding.rvPrecision.visible()
            binding.rvSafety.visible()
            binding.rvWeather.visible()
            binding.rvProductInformation.visible()
            binding.rvSize.visible()
            productGroupType="tire"
        }else if (product?.productgroup?.lowercase()?.contains("wheel",true) == true) {

            binding.rvDimensions.visible()
            binding.rvPerformance.visible()
            binding.rvFinish.visible()
            binding.rvFitment.visible()
            binding.rvLugs.visible()
            binding.rvProductInformation.visible()
            binding.rvWheelHub.visible()
            binding.rvSize.visible()
            productGroupType="wheel"

        }else if (product?.productgroup?.lowercase()?.contains("Wheel Accessories",true) == true ){
            productGroupType="Wheel Accessories"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("Caps",true) == true){
            productGroupType="Caps"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if (  product?.productgroup?.lowercase()?.contains("Hub Cover Locks",true) == true){
            productGroupType="Hub Cover Locks"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()

        }
        else if ( product?.productgroup?.lowercase()?.contains("Install Kits",true) == true){
            productGroupType="Install Kits"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()

        }
        else if ( product?.productgroup?.lowercase()?.contains("Lug Bolts",true) == true) {
            productGroupType="Lug Bolts"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()

        }
        else if ( product?.productgroup?.lowercase()?.contains("Wheels Access Tools",true) == true) {
            productGroupType="Wheels Access Tools"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()

        }
        else if ( product?.productgroup?.lowercase()?.contains("Wheel Studs",true) == true) {
            productGroupType="Wheel Studs"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()

        }
        else if ( product?.productgroup?.lowercase()?.contains("Wheel Valve Stem",true) == true) {
            productGroupType="Wheel Valve Stem"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("TPMS",true) == true) {
            productGroupType="TPMS"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("Wheel Weights",true) == true) {
            productGroupType="Wheel Weights"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("Tubes & Flaps",true) == true) {
            productGroupType="Tubes & Flaps"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("Tire Repair",true) == true) {
            productGroupType="Tire Repair"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }
        else if ( product?.productgroup?.lowercase()?.contains("Tools",true) == true) {
            productGroupType="Tools"
            binding.rvProductInformation.visible()
            binding.rvDimensions.visible()
        }


        val dimensionList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Dimensions).asList())
        dimensionsAdapter = ProductAttributesAdapter(requireActivity(), dimensionList, product,productGroupType)
        binding.rvDimensions.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvDimensions.adapter = dimensionsAdapter


        val performanceList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Performance).asList())
        performanceAdapter = ProductAttributesAdapter(
            requireActivity(),
            performanceList,
            product,
            productGroupType
        )
        binding.rvPerformance.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvPerformance.adapter = performanceAdapter


        val precisionList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Precision).asList())
        precisionAdapter = ProductAttributesAdapter(
            requireActivity(),
            precisionList,
            product,
            productGroupType
        )
        binding.rvPrecision.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvPrecision.adapter = precisionAdapter


        val productInformationList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.ProductInformation).asList())
        productInformationAdapter = ProductAttributesAdapter(
            requireActivity(),
            productInformationList,
            product,
            productGroupType
        )
        binding.rvProductInformation.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvProductInformation.adapter = productInformationAdapter


        val safetyList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Safety).asList())
        safetyAdapter = ProductAttributesAdapter(
            requireActivity(),
            safetyList,
            product,
            productGroupType
        )
        binding.rvSafety.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvSafety.adapter = safetyAdapter

        val weatherList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Weather).asList())
        weatherAdapter = ProductAttributesAdapter(
            requireActivity(),
            weatherList,
            product,
            productGroupType
        )
        binding.rvWeather.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvWeather.adapter = weatherAdapter


        val lugsList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Lugs).asList())
        lugsAdapter = ProductAttributesAdapter(
            requireActivity(),
            lugsList,
            product,
            productGroupType
        )
        binding.rvLugs.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvLugs.adapter = lugsAdapter

        val finishList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Finish).asList())
        finishAdapter = ProductAttributesAdapter(
            requireActivity(),
            finishList,
            product,
            productGroupType
        )
        binding.rvFinish.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvFinish.adapter = finishAdapter


        val wheelHub =ArrayList<String>(requireActivity().resources.getStringArray(R.array.WheelHub).asList())
       val wheelHubAdapter = ProductAttributesAdapter(
           requireActivity(),
           wheelHub,
           product,
           productGroupType
       )
        binding.rvWheelHub.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvWheelHub.adapter = wheelHubAdapter

        val fitment =ArrayList<String>(requireActivity().resources.getStringArray(R.array.Fitment).asList())
        val fitmentAdapter = ProductAttributesAdapter(
            requireActivity(),
            fitment,
            product,
            productGroupType
        )
        binding.rvFitment.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvFitment.adapter = fitmentAdapter


        val sizeList =ArrayList<String>(requireActivity().resources.getStringArray(R.array.size).asList())
        val sizeAdapter = ProductAttributesAdapter(
            requireActivity(),
            sizeList,
            product,
            productGroupType
        )
        binding.rvSize.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL, false
        )

        binding.rvSize.adapter = sizeAdapter

       binding.tvAddToList.setOnClickListener {
           addProdListEvent()
            Toast.makeText(activity,"This feature is not yet implemented", Toast.LENGTH_SHORT).show()
        }
        binding.tvAddToQuote.setOnClickListener {
            addQuoteFromProdEvent()
            Toast.makeText(activity,"This feature is not yet implemented", Toast.LENGTH_SHORT).show()
        }
       binding.tvViewRebates.setOnClickListener {
           binding.llProductCard.gone()
            val mrktDialog= AlertDialog.Builder(activity, R.style.WideDialog)

            val view : View = LayoutInflater.from(activity)
                .inflate(R.layout.marketing_programs,null)

            val linearLayout : LinearLayout = view.findViewById(R.id.llMarketingPrograms)


            val close : TextView = view.findViewById(R.id.tvClose)
            val viewOnAspire : TextView = view.findViewById(R.id.tvViewOnAspire)
           close.setTextColor(ContextCompat.getColorStateList(requireContext(),
               BottomNavigationScreenFragment.theameColor
           ))
           viewOnAspire.setTextColor(ContextCompat.getColorStateList(requireContext(),
               BottomNavigationScreenFragment.theameColor
           ))
            val tvMarketingPrograms : TextView = view.findViewById(R.id.tvMarketingPrograms)
            tvMarketingPrograms.text=Constants.CONSUMER_REBATE
            viewOnAspire.text=Constants.DOWNLOAD
            mrktDialog.setView(view)
            val dialog = mrktDialog.create()
            close.setOnClickListener {
                dialog.dismiss()
            }


            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            product.rebates?.let { rebates ->


                if (rebates.size > 0) {

                    val textView = TextView(activity)
                    textView.setLayoutParams(params)
                    textView.setText(rebates.get(0).description)
                    linearLayout.addView(textView)
                    viewOnAspire.setOnClickListener {

                        val url = rebates.get(0).url
                        val webIntent = Intent(Intent.ACTION_VIEW)
                        webIntent.data = Uri.parse(url)
                        requireActivity().startActivity(webIntent)
                    }
                } else {
                    val textView = TextView(activity)
                    textView.layoutParams = params
                    textView.text = "No rebates available"
                    linearLayout.addView(textView)
                }

            }


            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.show()

        }


       binding.tvViewMarketingPrograms.setOnClickListener {
            binding.llProductCard.gone()

            val mrktDialog= AlertDialog.Builder(activity, R.style.WideDialog)

            val view : View = LayoutInflater.from(activity)
                .inflate(R.layout.marketing_programs,null)

            val linearLayout : LinearLayout = view.findViewById(R.id.llMarketingPrograms)


            val close : TextView = view.findViewById(R.id.tvClose)
            val viewOnAspire : TextView = view.findViewById(R.id.tvViewOnAspire)
           close.setTextColor(ContextCompat.getColorStateList(requireContext(),
               BottomNavigationScreenFragment.theameColor
           ))
           viewOnAspire.setTextColor(ContextCompat.getColorStateList(requireContext(),
               BottomNavigationScreenFragment.theameColor
           ))
            mrktDialog.setView(view)
            val dialog = mrktDialog.create()
            close.setOnClickListener {
                dialog.dismiss()
            }

           viewOnAspire.setText("View on APEX")
           viewOnAspire.setOnClickListener{


               // val url = "https://atdrewards.aspireawards.com/"
               val url = "https://atdapex.channel-fusion.com/"
               val webIntent = Intent(Intent.ACTION_VIEW)
               webIntent.data = Uri.parse(url)
               startActivity(webIntent)
               dialog.dismiss()
           }
            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            product.marketingprograms?.let {

                if (it.size>0){

                    for (i in 0 until it.size) {
                        val textView = TextView(activity)
                        textView.setLayoutParams(params)
                        textView.setText(it.get(i).name)
                        linearLayout.addView(textView)
                    }
                }else{
                    val textView = TextView(activity)
                    textView.layoutParams= params
                    textView.text="No Marketing Programs"
                    linearLayout.addView(textView)
                }
            }


            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.show()

        }
    }

    private fun addProdListEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Click,
            "Add to list"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Add_To_List, params)
    }

    private fun addQuoteFromProdEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Details,
            searchType,
            Action.Impression,
            "Add to quote"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Add_To_Quote, params)
    }

    private fun BackPressed() {

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener(null)

        val list: ArrayList<Product>? =bundle?.getSerializable("keyWordSearchResults") as ArrayList<Product>?

        if (type.equals(Constants.Results)){
            val bundle= Bundle()
            bundle.putSerializable("keyWordSearchResults",list)
            bundle.putString("type","PDP")
            val productDetailsFragment = KeywordSearchResultsFragment()
            productDetailsFragment.arguments=bundle
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, productDetailsFragment)
                .addToBackStack("KeyWordSearchResultsFragment")
                .commit()
        }else if (type.equals(Constants.MY_LIST_DETAILS)){

             var productlists: Productlists?=null
            productlists =  this.arguments?.getSerializable("productlists") as Productlists
            val arguments= Bundle()
            arguments.putSerializable("productlists",productlists)
            val hostFragment = MyListDetailsFragment()
            hostFragment.arguments=arguments
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()

        }else{
            requireActivity().supportFragmentManager.popBackStack()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

            when(it){

                is NetworkResult.Success ->{

                    println("orderPermissions ${it.data}")
                    if(it.data.equals("VIEW_PRODUCT_COSTS",true)){

                            binding.ivCVActive.gone()
                            binding.ivCVInactive.visible()

                    }else{
                        binding.ivCVActive.gone()
                        binding.ivCVInactive.gone()
                        binding.tvCost.gone()
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

        productViewModel.brandsLiveData.observe(viewLifecycleOwner, Observer {

            when (it) {
                is NetworkResult.Success -> {

                    binding.progressbar.gone()

                    it.data?.let {


                        it.brandgroups.map {  it.brands.let {
                            binding.ivBrand.visible()
                            it.filter { it.name.equals(product.brand,true) }.map {
                                println("Brands SUCCESS?????" +it)
                                Glide.with(requireActivity())
                                .load(it.brandlogo)
                                .into(binding.ivBrand)
                            }
                        }
                    }}
                }
                is NetworkResult.Error -> {
                    println("ERROR?????" + it.message)
                    binding.progressbar.gone()

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    binding.progressbar.visible()
                }
            }

        })
    }



}
package com.atd.atdmobileapp.ui.mylists

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentMyListDetailsBinding
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.keywordsearch.*
import com.atd.atdmobileapp.models.mylist.MyListResponse
import com.atd.atdmobileapp.models.mylist.Productlists
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdLogo
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.tvHeaderText
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel
import com.atd.atdmobileapp.ui.product.ProductViewModel
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment
import com.atd.atdmobileapp.ui.vin.BarcodeFragment
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@AndroidEntryPoint
class MyListDetailsFragment : Fragment() {

    private var sequencenumber: Int=0
    private var productData: Productlists?=null
    private lateinit var adapter: MyListDetailsAdapter
    var _binding : FragmentMyListDetailsBinding?=null
    val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    lateinit var selectedProfile:String
     var themeColor: Int=R.color.black
    lateinit var atdproductnumberList: MutableList<String>
    private val productByCriteriaViewModel by viewModels<ProductViewModel>()
    private val recentKeywordSearchViewModel by viewModels<RecentKeywordSearchViewModel>()
    private val myListViewModel by viewModels<MyListViewModel>()
    private var selectedList : ArrayList<Product>?=null
    private var originalList : List<Product>?=null
    private val CAMERA_PERMISSION_REQUEST: Int=123

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding= FragmentMyListDetailsBinding.inflate(inflater,container,false)
        sharedPrefManager.saveBarcode("")
        selectedList= arrayListOf()
        atdproductnumberList= mutableListOf()
         sharedPrefManager?.getProfileSelected()?.let {

            if (it.equals("tirepros",true)){
                themeColor=R.color.red
            }else if (it.equals("atdonline",true)){
                themeColor=R.color.atd_blue
            }
        }


        println("productlists ==> ${this.arguments?.getSerializable("productlists")}")
        productData =  this.arguments?.getSerializable("productlists") as Productlists
        productData?.products?.map {

            it.atdproductnumber?.let { it1 -> atdproductnumberList.add(it1) }

        }
        println("atdproductnumberList $atdproductnumberList")

        setUpTheme()
        binding.tvName.text= productData?.name
        //binding.tvTotalItems.text=(productlist.products.size).toString()+" Total"+"("+"0 Items"+")"
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        atdLogo?.setOnClickListener {
            onBackPressed()
        }
        binding.etProductNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(etProductNumber: Editable?) {

                if (etProductNumber.toString().isNotEmpty()){
                        binding.tvAddProduct.isEnabled=true
                        binding.tvAddProduct.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
                        binding.tvAddProduct.setTextColor( ContextCompat.getColorStateList(requireActivity(),R.color.white))
                }else{
                    binding.tvAddProduct.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
                    binding.tvAddProduct.setTextColor( ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
                    binding.tvAddProduct.isEnabled=false

                }
            }
        })


        binding.tvAddProduct.setOnClickListener {

            atdproductnumberList?.let {
                if (it.size>0){

                    if (binding.etProductNumber.text.toString().trim() in it){

                        val alertDialog= Dialog(requireActivity())
                        alertDialog.setContentView(R.layout.list_name_update)
                        val listName= alertDialog.findViewById<EditText>(R.id.etComments)
                        val header= alertDialog.findViewById<TextView>(R.id.tvHeader)
                        val cancel= alertDialog.findViewById<TextView>(R.id.cancel)
                        val save= alertDialog.findViewById<TextView>(R.id.save)
                        val tvNote= alertDialog.findViewById<TextView>(R.id.tvNote)

                        header.setText(Constants.Duplicate_Item)
                        cancel.setText(Constants.CANCEL)
                        save.setText(Constants.Yes)
                        var increasedQuantity:Int?= 0
                        originalList?.map {
                            if (it.atdproductnumber.trim().equals(binding.etProductNumber.text.toString().trim())){
                                increasedQuantity=it.quantity?.times(2)
                                tvNote.setText("Product #${binding.etProductNumber.text.toString()} is already in the list. Would you like to update the quantity from ${it.quantity} to $increasedQuantity")

                            }
                        }
                        cancel.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
                        save.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
                        listName.gone()
                        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                        cancel.setOnClickListener {
                            alertDialog.dismiss()
                        }

                        save.setOnClickListener {

                            productData?.products?.map {
                                if (it.atdproductnumber.equals(binding.etProductNumber.text.toString().trim())){
                                    it.quantity=increasedQuantity
                                    originalList?.let {
                                        productResult(it)

                                    }
                                }
                            }
                            alertDialog.dismiss()
                        }


                        alertDialog.show()
                    }else{
                        addItem("")
                    }
                }else{
                    addItem("")
                }
            }

        }

        binding.tvListActions.setOnClickListener {

            if (binding.llListActions.visibility==View.VISIBLE){
                binding.llListActions.gone()
                binding.tvListActions.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0)

            }else{
                binding.tvListActions.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0)
                binding.llListActions.visible()
            }
        }

        binding.tvEditList.setOnClickListener {

            binding.tvEditList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
            binding.tvPrintList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvRenameList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvDeleteList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)

            binding.tvEditList.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
            binding.tvPrintList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvRenameList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvDeleteList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))

            binding.llListActions.gone()
            val arguments= Bundle()
            arguments.putSerializable("productlists",productData)
            arguments.putString(Constants.KEY_TYPE,Constants.EDIT)
            val hostFragment = CreateMyListFragment()
            hostFragment.arguments=arguments
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }
        binding.tvPrintList.setOnClickListener {

            binding.tvEditList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvPrintList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
            binding.tvRenameList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvDeleteList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)

            binding.tvEditList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvPrintList.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
            binding.tvRenameList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvDeleteList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.llListActions.gone()
        }
        binding.tvRenameList.setOnClickListener {

            binding.tvEditList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvPrintList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvRenameList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
            binding.tvDeleteList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)

            binding.tvEditList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvPrintList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvRenameList.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
            binding.tvDeleteList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.llListActions.gone()

            renameDialog()
        }
        binding.tvDeleteList.setOnClickListener {

            binding.tvEditList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvPrintList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvRenameList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.white)
            binding.tvDeleteList.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)

            binding.tvEditList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvPrintList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvRenameList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
            binding.tvDeleteList.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
            binding.llListActions.gone()
            deleteDialog(Constants.LIST)

        }



        atdproductnumberList.let{

           if( it.size>0) {
               binding.tvAddItemDes.gone()
               binding.tvNoDataAvailable.gone()
               getProductDetails(it)
           }else{

               productResult(arrayListOf())
           }

        }

        setupUI()

        binding.tvRemoveAddCart.btReset.setOnClickListener {

            deleteDialog(Constants.ITEM)
        }

        binding.tvRemoveAddCart.tvApprove.setOnClickListener {

            selectedList?.map {product->


                binding.progressbar.visible()
                if(sharedPrefManager.getDeliveryDefault().toString() == "Pickup" && sharedPrefManager.getSelectedDelivery() == null){
                    if(product.quantity!!.toInt() >product.availability.local.toInt()){
                        isCustomerPickupDelivery()
                        return@map
                    }
                } else if (sharedPrefManager.getSelectedDelivery() != null && sharedPrefManager.getSelectedDelivery() =="Pickup"){
                    if(product.quantity!!.toInt() > product.availability.local.toInt()){
                        isCustomerPickupDelivery()
                        return@map
                    }
                }


                if (product.quantity!!>0) {
                    val quantity: Int? = product?.quantity?.let { it } ?: 1
                    val addCartDetails = Cart(
                        product.brand,
                        product.style,
                        product.productgroup,
                        quantity!!.toInt(),
                        product?.images?.thumbnail?.image?.get(0)?.url.toString(),
                        product.mfgproductnumber,
                        product.atdproductnumber,
                        sharedPrefManager.getUserName().toString(),
                        sharedPrefManager.getLocationNumber().toString(),
                        Common.currentDateTime(),
                        ""
                    )

                    recentKeywordSearchViewModel.getCreatedCartRecordInFireStore(addCartDetails)
                        .observe(viewLifecycleOwner,
                            Observer { cartList ->

                                val filteredCartList = cartList.filter {
                                    it?.userName.equals(sharedPrefManager.getUserName()) &&
                                            it?.locationNumber.equals(sharedPrefManager.getLocationNumber())
                                }
                                val totalQuantity = filteredCartList.sumOf { it!!.quantity }

                                println("Updated records $filteredCartList")

                                if (totalQuantity > 0) {
                                    BottomNavigationScreenFragment.badgeCount?.visible()
                                    BottomNavigationScreenFragment.badgeCount?.text =
                                        totalQuantity.toString()
                                    successToast("Items added to cart successfully")
                                } else {
                                    BottomNavigationScreenFragment.badgeCount?.gone()
                                }

                                binding.progressbar.gone()

                            })
                }else{
                    binding.progressbar.gone()
                }




            }

        }

        binding.tvSelectAll.setOnClickListener {
            binding.tvDiSelectAll.visible()
            binding.tvSelectAll.gone()
            adapter.selectAll(true)
            adapter.notifyDataSetChanged()
        }
        binding.tvDiSelectAll.setOnClickListener {
            binding.tvDiSelectAll.gone()
            binding.tvSelectAll.visible()
            adapter.selectAll(false)
            adapter.notifyDataSetChanged()
            selectedList!!.clear()
        }

        binding.ivAddProduct.setOnClickListener{

            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startBarcodeScanner()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST
                )
            }
        }
        return binding.root

    }

    private fun startBarcodeScanner() {
        val intent = Intent(requireActivity(), BarcodeFragment::class.java)
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        sharedPrefManager.getBarcode()?.let {

            if (!it.equals("")){
                if (it.length<11){
                    val barcode = "000"+it
                    binding.etProductNumber.setText(barcode)

                }else if (it.length<12){
                    val barcode = "00"+it
                    binding.etProductNumber.setText(barcode)

                }else if (it.length<13){
                    val barcode = "0"+it
                    binding.etProductNumber.setText(barcode)

                }else {
                    binding.etProductNumber.setText(it)

                }
            }
        }
        BottomNavigationScreenFragment.atdHeader?.visible()
        BottomNavigationScreenFragment.atdFooter?.visible()
    }

    private fun callProductDetails(bundle: Bundle){
        val productDetailsFragment = ProductDetailsFragment()
        bundle.putString("category", "List Details")
        bundle?.putSerializable("productlists",productData)
        bundle.putString(Constants.KEY_TYPE,Constants.MY_LIST_DETAILS)
        productDetailsFragment.arguments=bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, productDetailsFragment)
            .addToBackStack("KeyWordSearchResultsFragment")
            .commit()
    }
    private fun isCustomerPickupDelivery() {
        binding.progressbar.gone()
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


    private fun addItem(listName: String) {

        val name= productData?.name!!
        if (listName.isNotBlank()) { productData?.name=listName }

        if (binding.etProductNumber.text.toString().trim().isNotBlank()) {

            val product = com.atd.atdmobileapp.models.mylist.Product()
            product.atdproductnumber = binding.etProductNumber.text.toString().trim()
            product.quantity = 1
            product.sequencenumber = sequencenumber + 1
            productData!!.products?.add(product)
        }
        if (productData!!.recurringstartdate.equals(null)){
            productData!!.recurringstartdate=Common.currentDate()
        }
        val locationNumber:String= sharedPrefManager.getLocationNumber().toString()
        val MyListRequest= MyListResponse()
        MyListRequest.productlist=productData
        println("productData==> ${Gson().toJson(MyListRequest)}")

        myListViewModel.updateMyList(locationNumber,name,MyListRequest).observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {

                when(it){
                    is NetworkResult.Loading ->{

                        binding.progressbar.visible()
                    }
                    is NetworkResult.Success ->{

                        it?.data?.let {
                            binding.etProductNumber.setText("")
                            println("List resp ${it}")
                            binding.tvName.text=it.productlist?.name
                            atdproductnumberList.clear()
                            it.productlist?.products?.map {
                                it.atdproductnumber?.let { it1 -> atdproductnumberList.add(it1) }

                            }
                            atdproductnumberList?.let{

                                if( it.size>0) {
                                    getProductDetails(it)
                                }

                            }
                            binding.progressbar.gone()

                        }
                    }
                    is NetworkResult.Error ->{
                        binding.progressbar.gone()
                        if (binding.etProductNumber.text.toString().toString().isNotBlank()) {
                            waitToast("No results found. Please try again")
                        }else{ waitToast(it.message) }
                    }
                }
            })

        view?.hideSoftInput()

    }

    fun deleteDialog(type: String) {

        val alertDialog= Dialog(requireActivity())
        alertDialog.setContentView(R.layout.reject_dialog)
        val edittext= alertDialog.findViewById<EditText>(R.id.etComments)
        val header= alertDialog.findViewById<TextView>(R.id.tvHeader)
        val cancel= alertDialog.findViewById<TextView>(R.id.cancel)
        val delete= alertDialog.findViewById<TextView>(R.id.reject)
        val tvNote= alertDialog.findViewById<TextView>(R.id.tvNote)
        tvNote.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.textview_label))

        header.setText(Constants.DELETE_ITEM)
        cancel.setText(Constants.CANCEL)
        delete.setText(Constants.DELETE)
        if (type.equals(Constants.ITEM)) {
            tvNote.setText(Constants.DELETE_ITEM_FROM_LIST)
        }else if (type.equals(Constants.LIST)){
            tvNote.setText(Constants.DELETE_LIST_TITLE)
        }
        cancel.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        delete.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        edittext.gone()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        cancel.setOnClickListener {
            alertDialog.dismiss()
        }

        delete.setOnClickListener {

            DeleteItem(type)
            alertDialog.dismiss()

        }
        alertDialog.show()
    }

    fun renameDialog(){
        val alertDialog= Dialog(requireActivity())
        alertDialog.setContentView(R.layout.list_name_update)
        val listName= alertDialog.findViewById<EditText>(R.id.etComments)
        val header= alertDialog.findViewById<TextView>(R.id.tvHeader)
        val cancel= alertDialog.findViewById<TextView>(R.id.cancel)
        val save= alertDialog.findViewById<TextView>(R.id.save)
        val tvNote= alertDialog.findViewById<TextView>(R.id.tvNote)

        header.setText(Constants.LISTNAME)
        cancel.setText(Constants.CANCEL)
        save.setText(Constants.SAVE)
        tvNote.setText(Constants.CHOOSE_A_NAME)
        cancel.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        save.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        listName.setHint(Constants.MY_LIST_NAME)
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        cancel.setOnClickListener {
            alertDialog.dismiss()
        }

        save.setOnClickListener {

            if (listName.text.toString().isNotEmpty()){

                addItem(listName.text.toString())
                alertDialog.dismiss()
                listName.setText("")
            }

        }


        alertDialog.show()
    }


    private fun DeleteItem(type: String) {

        if (type.equals(Constants.ITEM)) {
            selectedList?.let {

                if (it.size > 0) {
                    it.forEach { product ->
                        myListViewModel.deleteItemFromList(
                            sharedPrefManager?.getLocationNumber().toString(),
                            productData?.name!!,
                            product.atdproductnumber
                        ).observe(viewLifecycleOwner,
                            Observer {
                                when (it) {
                                    is NetworkResult.Success -> {
                                        binding.progressbar.gone()
                                        it.data?.let {

                                            if (it.listproductdeleted == true) {
                                                selectedList?.remove(product)
                                                atdproductnumberList.remove(product.atdproductnumber)
                                                successToast(Constants.ITEM_SUCCESSFULLY_DELETED)
                                                CoroutineScope(Dispatchers.IO).launch {
                                                    atdproductnumberList.let { atdproduct ->

                                                        if (atdproduct.size > 0) {
                                                            getProductDetails(atdproduct)
                                                        } else {
                                                            productResult(arrayListOf())
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }
                                    is NetworkResult.Error -> {
                                        binding.progressbar.gone()
                                        waitToast(it.message)

                                    }
                                    is NetworkResult.Loading -> {
                                        binding.progressbar.visible()
                                    }
                                }
                            })
                    }
                }
            }
        }
        else if (type.equals(Constants.LIST)){
            myListViewModel.deleteList(
                sharedPrefManager?.getLocationNumber().toString(),
                productData?.name!!
            ).observe(viewLifecycleOwner,
                Observer {
                    when (it) {
                        is NetworkResult.Success -> {
                            binding.progressbar.gone()
                            it.data?.let {

                                if (it.listdeleted == true) {

                                    successToast(Constants.ITEM_SUCCESSFULLY_DELETED)
                                    onBackPressed()
                                }

                            }
                        }
                        is NetworkResult.Error -> {
                            binding.progressbar.gone()
                            waitToast(it.message)

                        }
                        is NetworkResult.Loading -> {
                            binding.progressbar.visible()
                        }
                    }
                })

        }

    }

    private fun getProductDetails(atdproductnumber: List<String>) {

        val productByCriteriaRequest = ProductByCriteriaRequest()
        productByCriteriaRequest.locationnumber= sharedPrefManager?.getLocationNumber().toString()
        val option = Options()
        val availability = Availability()
        availability.local=1
        availability.localplus=1
        availability.nationwide=1
        option.availability=availability

        val price = Price()
        price.cost=1
        price.retail=1
        price.specialdiscount=1
        price.fet=1
        price.map=null
        price.msrp=null
        option.price=price

        val images = Images()
        images.thumbnail=1
        images.small=1
        images.large=1
        option.images=images

        val productspec= Productspec()
        option.productspec=productspec
        val criteria = Criteria()
        criteria.atdproductnumber= atdproductnumber
        productByCriteriaRequest.criteria=criteria
        productByCriteriaRequest.options=option

        println("request ==> ${Gson().toJson(productByCriteriaRequest)}")
        productByCriteriaViewModel.getProductByCriteria(productByCriteriaRequest)

    }

    private fun setupUI() {
        adapter= MyListDetailsAdapter(arrayListOf(),requireActivity(),::updateItems,themeColor,::callProductDetails)
        binding.rvList.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)
        binding.rvList.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productByCriteriaViewModel.productByCriteriaResponse.observe(viewLifecycleOwner, Observer {

            when (it) {
                is NetworkResult.Success -> {
                    binding.progressbar.gone()
                    it.data?.let {

                        it.products?.let { result -> productResult(result) }

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

    private fun productResult(result: List<Product>) {

        val flow = flow {

            val list = result

            list?.map{product->
                productData?.products?.map {
                    if (it.atdproductnumber.equals(product.atdproductnumber)){
                        product.quantity=it.quantity
                    }
                }

            }
            emit(list)
        }.flowOn(Dispatchers.IO)

        CoroutineScope(Dispatchers.Main).launch{

            flow.collect{
                updateItems(it.size,0,null,"")
                if (it.size>0){
                    binding.tvAddItemDes.gone()
                    binding.tvNoDataAvailable.gone()
                    binding.tvSelectAll.visible()
                    println("product result $it")
                    sequencenumber= it.size
                    originalList=it
                    adapter.Update(it as ArrayList<Product>)
                    adapter.notifyDataSetChanged()
                }else{
                    binding.tvSelectAll.gone()
                    binding.tvDiSelectAll.gone()
                    binding.tvAddItemDes.visible()
                    binding.tvNoDataAvailable.visible()
                    adapter.Update(it as ArrayList<Product>)
                    adapter.notifyDataSetChanged()
                }
            }
        }

    }

    private fun updateItems(
        totalSize: Int,
        itemSize: Int,
        product: Product?,
        type: String,
    ) {

        binding.tvTotalItems.text="${totalSize.toString()} Total ($itemSize Items)"

        CoroutineScope(Dispatchers.IO).launch {
            product?.let {product->
                if (type.equals("true")){
                    if (selectedList!!.size==0){
                        selectedList?.add(product)
                    }else {
                        if (product !in selectedList!!) selectedList?.add(product)else {}


                    }
                }else if (type.equals("false")){

                    if (product in selectedList!!) selectedList?.remove(product) else { }

                }else{}
            }

            async(Dispatchers.Main) {
            selectedList?.let {

                println("selectedList ${it.size}")
                if (it.size>0) {
                    binding.tvDiSelectAll.visible()
                    binding.tvSelectAll.gone()
                    enable()
                } else {
                    if (binding.tvNoDataAvailable.visibility!=View.VISIBLE){
                        binding.tvDiSelectAll.gone()
                        binding.tvSelectAll.visible()
                        disable()
                    }

                }

            }
            }

            println("selected List ==> ${selectedList?.size}")

        }



    }

    fun enable(){

            binding.tvRemoveAddCart.btReset.isEnabled=true
            binding.tvRemoveAddCart.tvApprove.isEnabled=true
            binding.tvRemoveAddCart.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            binding.tvRemoveAddCart.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
            binding.tvRemoveAddCart.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
    }

    fun disable(){

        binding.tvRemoveAddCart.btReset.isEnabled=false
        binding.tvRemoveAddCart.tvApprove.isEnabled=false
        binding.tvRemoveAddCart.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
        binding.tvRemoveAddCart.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
        binding.tvRemoveAddCart.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.lightgreay))
    }

    private fun onBackPressed() {

        tvHeaderText?.text=requireActivity().resources.getString(R.string.my_lists)


        val hostFragment = MyListFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }



    fun setUpTheme() {

        tvHeaderText?.text=requireActivity().resources.getString(R.string.list_details)
        binding.tvRemoveAddCart.btReset.text=requireActivity().resources.getString(R.string.remove)
        binding.tvRemoveAddCart.tvApprove.text=requireActivity().resources.getString(R.string.add_to_cart)
        binding.tvRemoveAddCart.viewDivider.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
        binding.ivAddProduct.imageTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
        binding.etProductNumber.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),themeColor)
        binding.tvListActions.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
        binding.tvSelectAll.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvDiSelectAll.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvEditList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvPrintList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvRenameList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
        binding.tvDeleteList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))

        if (themeColor==R.color.atd_blue){
            atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)
        }else if (themeColor==R.color.red){
            atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
        }

    }


}
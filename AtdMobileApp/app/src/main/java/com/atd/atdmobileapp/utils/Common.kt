package com.atd.atdmobileapp.utils

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.preferences.Item
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.models.preferences.ProductItems
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Common {

    fun currentDate() : String{

        val c1: Calendar = Calendar.getInstance()
        val today = c1.time
        var df = SimpleDateFormat("YYYY-MM-dd")
        val todayDate: String = df.format(today)
        return todayDate
    }

    fun StringToPreviousDate(date: Int) : Date {
        val c1: Calendar = Calendar.getInstance()
        c1.add(Calendar.DAY_OF_YEAR, -date)
        val oneMonth = c1.time
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val todayDate: String = parser.format(oneMonth)

        val date :Date = parser.parse(todayDate);
        println("String Date :$todayDate , Date : $date")

        return date
    }
    fun currentDateTime() : String{

        val c1: Calendar = Calendar.getInstance()
        val today = c1.time
        var df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val todayDate: String = df.format(today)
        return todayDate
    }

    fun currentTime() : String{

        val date = Date()
        var df = SimpleDateFormat("hh:mm")
        val c1: Calendar = Calendar.getInstance()
        val currentTime: String = df.format(date)

        return currentTime
    }

    fun tomorrowDate() : String{

        val c1: Calendar = Calendar.getInstance()
        c1.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrow = c1.time
        var df = SimpleDateFormat("YYYY-MM-dd")
        val tomorrowDate: String = df.format(tomorrow)
        return tomorrowDate
    }
    fun tomorrowDateTime() : String{

        val c1: Calendar = Calendar.getInstance()
        c1.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrow = c1.time
        var df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val tomorrowDate: String = df.format(tomorrow)
        return tomorrowDate
    }
    fun yesterday() : String{

        val c1: Calendar = Calendar.getInstance()
        c1.add(Calendar.DAY_OF_YEAR, -1)
        val tomorrow = c1.time
        var df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val tomorrowDate: String = df.format(tomorrow)
        return tomorrowDate
    }

    fun getTime(time:String) : String{

        val date = Date(time)
        var df = SimpleDateFormat("hh:mm")
        val currentTime: String = df.format(date)

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
        val output = formatter.format(parser.parse("2018-12-14T09:55:00"))

        return currentTime
    }

    fun getMonthDay(date:String) : String{

        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("MMM-dd")
        val output = formatter.format(parser.parse(date))

        var cdate= currentDate()
        if (date.equals(currentDate(),true)){
            return ""
        }else if (date.equals(tomorrowDate(),true)){
            return "on tomorrow"
        }else{
            return "on "+output
        }


    }
    fun getYearMonthDay(date:String) : String{

        val parser = SimpleDateFormat("MM/dd/yyyy")
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val output = formatter.format(parser.parse(date))

        return output
    }

    fun getYearMonthDayforSlashSeperator(date:String) : String{

        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("MM/dd/yyyy")
        val output = formatter.format(parser.parse(date))

        return output
    }

    fun StringToDate(date: String) : Date {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date :Date = parser.parse(date);

        println("String Date -> $date")
        return date
    }
    fun getMonthNameDayYear(date:String) : String{

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val formatter = SimpleDateFormat("MMM dd, yyyy")
        val output = formatter.format(parser.parse(date))


        if (date.equals(currentDateTime(),true)){
            return "Today"
        }else if (date.equals(tomorrowDateTime(),true)){
            return "Tomorrow"
        }else{
            return output
        }


    }
    fun getApprovalMonthNameDayYear(date:String) : String{

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val formatter = SimpleDateFormat("MMM dd, yyyy")
        val today = SimpleDateFormat("hh:mm a")
        val output = formatter.format(parser.parse(date))


        if (date.equals(currentDateTime(),true)){
            return today.format(parser.parse(date))
        }else if (date.equals(yesterday(),true)){
            return "yesterday"
        }else{
            return output
        }


    }


    fun TimeOffSet(): String{
        val mCalendar: Calendar = GregorianCalendar()
        val mTimeZone = mCalendar.timeZone
        val mGMTOffset = mTimeZone.rawOffset

         val result=   TimeUnit.HOURS.convert(mGMTOffset.toLong(), TimeUnit.MILLISECONDS)


        return result.toString()
    }

    fun CutOffTime(time: String):String{


        var offset : List<String> = time.split("-")
        var requiredoffset : List<String> = offset[0].split(":")

        var actualTime: List<String> =offset[1].split(":")
        var requiretime=""
        if (actualTime[0].toInt()< TimeOffSet().toInt()){
            requiretime=(requiredoffset[0].toInt()+1).toString()+":"+requiredoffset[1]
        }else{
            requiretime = offset[0]
        }


        val parser = SimpleDateFormat("hh:mm")
        val formatter = SimpleDateFormat("hh:mm a")
        val output = formatter.format(parser.parse(requiretime))

        println("Actual offset: ${actualTime[0]} ,Actual offset: ${TimeOffSet()} ,required time : $output")

        return output
    }

    fun largeImage(url:String,activity: FragmentActivity){

        var dialog = Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.large_image)
        var ivLargeImage:ImageView = dialog.findViewById(R.id.ivLargeImage)
        var closeDialog:ImageView = dialog.findViewById(R.id.closeDialog)
        var progressbar: ProgressBar = dialog.findViewById(R.id.progressbar)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.white);
        progressbar.visible()
        Glide.with(activity)
            .load(url)
            .placeholder(R.drawable.image_not_available)
            .error(R.drawable.image_not_available)
            .into(ivLargeImage)

        closeDialog.setOnClickListener {
            dialog.dismiss()
        }
        progressbar.gone()
        dialog.show()
    }


    fun sort(sortType: String, products: List<Product>, preferredBrandList: List<String>): List<Product>{

        when (sortType){
            "Availability" ->{
                //sorting based on Availability
                return products.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
            }
            "Availability, Cost Low to High" ->{
                val temp = products.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp.sortedBy { product ->
                    product.price.cost
                }
            }
            "Availability, Cost High to Low" ->{
                val temp = products.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp.sortedByDescending { product ->
                    product.price.cost
                }
            }
            "Availability, Retail Low to High" ->{
                val temp = products.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp.sortedBy { product ->
                    product.price.retail
                }
            }
            "Availability, Retail High to Low" ->{
                val temp = products.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp.sortedByDescending { product ->
                    product.price.retail
                }
            }
            "Brand" ->{
                return products.sortedBy { product ->
                    product.brand
                }
            }
            "Cost Low to High" -> {

                return products.sortedBy { product ->
                    product.price.cost
                }

            }
            "Cost High to Low" ->{
                return products.sortedByDescending { product ->
                    product.price.cost
                }
            }
            "Retail Low to High" ->{
                return products.sortedBy { product ->
                    product.price.retail
                }
            }
            "Retail High to Low" ->{
                return products.sortedByDescending { product ->
                    product.price.retail
                }
            }
            "Preferred Brands" -> {
                return sortByPreferredBrand(preferredBrandList, products)
            }
            "Preferred Brands/Availability/Cost Low to High" ->{
                val temp = sortByPreferredBrand(preferredBrandList, products)
                val temp1 = temp.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp1.sortedBy { product ->
                    product.price.cost
                }
            }
            "Preferred Brands/Availability/Cost High to Low" ->{
                val temp = sortByPreferredBrand(preferredBrandList, products)
                val temp1 = temp.sortedByDescending { product ->
                    product.availability.local + product.availability.localplus + product.availability.nationwide
                }
                return temp1.sortedByDescending { product ->
                    product.price.cost
                }
            }
            else ->{
                return products
            }
        }


    }

    private fun sortByPreferredBrand(preferredBrandList: List<String>, products: List<Product>): MutableList<Product> {
        val sortedProducts = mutableListOf<Product>()
        val nonPreferredProducts = mutableListOf<Product>()
        val sortedPreferredBrandList = preferredBrandList.sorted()
        println("sortedPreferredBrandList ->$sortedPreferredBrandList")
        val sortedProductsByBrands = products.sortedBy { product ->
            product.brand
        }
        for (brand in sortedPreferredBrandList) {
            val filteredProducts = sortedProductsByBrands.filter { product ->
                product.brand == brand
            }
            sortedProducts.addAll(filteredProducts)
        }


        nonPreferredProducts.addAll(sortedProductsByBrands.filter { product ->
            product.brand !in sortedPreferredBrandList
        })

        sortedProducts.addAll(nonPreferredProducts)
        return sortedProducts
    }

    fun setDefaultUserPrefs(): PreferencesConfiguration {
        val preferencesConfiguration = PreferencesConfiguration()
        preferencesConfiguration.showProductCost = true
        preferencesConfiguration.orderCutOff = true
        preferencesConfiguration.startOfBusiness = true
        preferencesConfiguration.startTime = "8:00 AM"
        preferencesConfiguration.endOfBusiness = true
        preferencesConfiguration.endTime = "17:00 PM"
        preferencesConfiguration.businessDays = mutableListOf("mon","tue","wed","thu", "fri")
        preferencesConfiguration.fitmentResults = "Tires"
        preferencesConfiguration.myBrands = "Show All Brands"
        preferencesConfiguration.availabilityFilter = "Local+"
        preferencesConfiguration.sortOrder = "Brand"

        val itemsDefault: List<Item> = listOf(
            Item("Passenger Tire", "passenger tires", 4),
            Item("Light Truck Tire", "light truck tires", 4),
            Item("Medium Truck Tire", "medium truck tires", 4),
            Item("Small Tire", "small tires", 2),
            Item("Trailer Tire", "trailer tires", 2),
            Item("Farm Tire", "farm tires", 2),
            Item("Industrial Tire", "industrial tires", 2),
            Item("OTR, Grader, EM Tires", "otr,grader,em tires", 2),
            Item("Tubes and Flaps", "tubes and flaps", 1),
            Item("AG Wheels", "ag wheels", 4),
            Item("Steel Wheels", "steel wheels", 4),
            Item("Custom Wheels", "custom wheels", 4),
            Item("Tire Repair", "tire repair", 1),
            Item("Wheel Accessories", "wheel accessories", 1),
            Item("Supplies", "supplies", 1),
            Item("Tools", "tools", 1)
        )

        preferencesConfiguration.productItems = ProductItems("add to cart/retail quote", itemsDefault)

        return preferencesConfiguration
    }

    fun makeFirebaseEventBundle(firebaseAnalytics: FirebaseAnalytics,
                                sharedPrefManager: SharedPrefManager,
                                screen: String,
                                category: String,
                                action: String,
                                label: String?): Bundle {
        val params = Bundle()
        params.putString("screen", screen)
        params.putString("category", category)
        params.putString("action", action)
        params.putString("label", label)

        setUserPropertiesFirebaseAnalytics(firebaseAnalytics, sharedPrefManager)
        return params
    }


    private fun setUserPropertiesFirebaseAnalytics(
        firebaseAnalytics: FirebaseAnalytics,
        sharedPrefManager: SharedPrefManager
    ) {

        val username = sharedPrefManager.getUserName()?.takeIf { it.isNotBlank() }
        firebaseAnalytics.setUserProperty("username", username)

        val accountLevel = sharedPrefManager.getUserRole()?.takeIf { it.isNotBlank() }
        firebaseAnalytics.setUserProperty("accountLevel", accountLevel)

        val persona = sharedPrefManager.getProfileSelected()?.takeIf { it.isNotBlank() }
        firebaseAnalytics.setUserProperty("persona", persona)

        val localDC = sharedPrefManager.getServicingdcNumber()?.takeIf { it.isNotBlank() }
        firebaseAnalytics.setUserProperty("localDC", localDC)

        val location = sharedPrefManager.getLocationNumber()?.takeIf { it.isNotBlank() }
        firebaseAnalytics.setUserProperty("location", location)

        //add more user params
    }

    fun getAnalyticsSearchCriteria(
        criteria: Criteria,
        searchType: String,
        offsetDesc: String,
        preferredBrandList: List<String>
    ): SearchCriteria {
        val searchDetails: SearchCriteria = SearchCriteria()
        searchDetails.type = SearchType.criteria
        searchDetails.brandsSelected = criteria.brand?.joinToString()
        searchDetails.category = searchType
        searchDetails.supplierNumber = criteria.mfgproductnumber?.joinToString()
        searchDetails.productNumber = criteria.atdproductnumber?.joinToString()
        searchDetails.tires_subCategory = criteria.productgroup?.joinToString()
        searchDetails.tires_size = criteria.size?.joinToString()
        searchDetails.tires_speedRating = criteria.speedrating?.joinToString()
        searchDetails.tires_seasonalDesignation = criteria.winterdesignation?.joinToString()
        searchDetails.wheels_wheelType = criteria.productgroup?.joinToString()
        searchDetails.wheels_diameter = criteria.wheeldiameter?.joinToString()
        searchDetails.wheels_width = criteria.wheelwidth?.joinToString()
        searchDetails.wheels_lugBolt = criteria.boltpattern?.joinToString()
        searchDetails.wheels_finish = criteria.atdfinish?.joinToString()
        searchDetails.wheels_offset = offsetDesc
        searchDetails.wheels_seasonalDesignation = criteria.winterdesignation?.joinToString()
        searchDetails.accesories_type = criteria.productsubgroup?.joinToString()
        searchDetails.supplies_type = criteria.productsubgroup?.joinToString()
        searchDetails.tubes_type = criteria.style?.joinToString()
        searchDetails.preferredBrandAvailable = preferredBrandList.isNotEmpty()
        searchDetails.selectPreferredBrand = criteria.brand?.any { element -> preferredBrandList.contains(element) }
        return searchDetails
    }

    fun convertSearchCriteriaToBundle(searchCriteria: SearchCriteria, params: Bundle): Bundle {

        with(searchCriteria) {
            params.putString("type", type)
            params.putString("category", category)
            params.putBoolean("preferredBrandAvailable", preferredBrandAvailable ?: false)
            params.putBoolean("selectPreferredBrand", selectPreferredBrand ?: false)
            params.putString("brandsSelected", brandsSelected)
            params.putString("supplierNumber", supplierNumber)
            params.putString("productNumber", productNumber)
            params.putString("tires_subCategory", tires_subCategory)
            params.putString("tires_size", tires_size)
            params.putString("tires_speedRating", tires_speedRating)
            params.putString("tires_seasonalDesignation", tires_seasonalDesignation)
            params.putString("wheels_wheelType", wheels_wheelType)
            params.putString("wheels_diameter", wheels_diameter)
            params.putString("wheels_width", wheels_width)
            params.putString("wheels_lugBolt", wheels_lugBolt)
            params.putString("wheels_finish", wheels_finish)
            params.putString("wheels_offset", wheels_offset)
            params.putString("wheels_seasonalDesignation", wheels_seasonalDesignation)
            params.putString("accesories_type", accesories_type)
            params.putString("supplies_type", supplies_type)
            params.putString("tubes_type", tubes_type)
        }

        return params
    }


    fun addRequestToEventParams(criteria: Criteria, searchType: String,params:Bundle): Bundle {

        params.putString("product_category", searchType)
        params.putString("brands", criteria.brand?.joinToString())
        params.putString("tire_size", criteria.size?.joinToString())
        params.putString("wheel_type", criteria.productgroup?.joinToString())
        params.putString("atd_part_number", criteria.atdproductnumber?.joinToString())
        params.putString("supplier_number", criteria.mfgproductnumber?.joinToString())

        return params

    }

    fun convertSearchNonCriteriaToBundle(searchNonCriteria: SearchNonCriteria, params: Bundle): Bundle {

        with(searchNonCriteria) {
            params.putString("type", type)
            params.putString("year", year)
            params.putString("vehiclemake", vehiclemake)
            params.putString("vehiclemodel", vehiclemodel)
            params.putString("trim", trim)
            params.putString("trimOption", trimOption)
            isStaggered?.let { params.putBoolean("isStaggered", it) }
            params.putString("searchTerm", searchTerm)
            params.putString("frontSize", frontSize)
            params.putString("rearSize", rearSize)
            params.putString("barcodeNumber", barcodeNumber)
            params.putString("vinNumber", vinNumber)
            params.putString("region", region)

        }

        return params
    }

    fun getEcomProductFromAtdProduct(atdProduct: Product, index: Int): EcomProduct{
        val ecomProduct = EcomProduct()
        with(atdProduct){
            ecomProduct.item_id = atdproductnumber
            ecomProduct.item_name = style
            ecomProduct.item_brand = brand
            ecomProduct.item_category = productgroup
            ecomProduct.quantity = quantity
            ecomProduct.currency = "USD"
            ecomProduct.index= index
            ecomProduct.item_variant = productspec.size
            ecomProduct.price= price.cost
            ecomProduct.promotion_id= rebates[0].code
            ecomProduct.cost = price.cost.toString()
            ecomProduct.retail = price.retail.toString()
            ecomProduct.map = price.map.toString()
            ecomProduct.hasRebates = rebates.size
            ecomProduct.availability = availability
        }

        return ecomProduct
    }

    fun twoDecimal(number: Double): String {

        val formatter: NumberFormat = NumberFormat.getNumberInstance()
        formatter.setMinimumFractionDigits(2)
        formatter.setMaximumFractionDigits(2)
        val output: String = formatter.format(number)

        return output
    }

    fun getEcomPurchase(order: OrderXXX): EcomPurchase {

        val orderDetailsX = getOrderDetails(order)

        return EcomPurchase(
            transaction_id = order.confirmationnumber,
            currency = "USD",
            shipping = orderDetailsX.shipping,
            value = order.ordertotal,
            tax = orderDetailsX.tax,
            totalItems = order.orderlines.size,
            totalQuantity = orderDetailsX.totalQuantity
        )
    }

    private fun getOrderDetails(order: OrderXXX) : OrderDetailsX {

        var shipping = 0
        var tax = 0
        var totalQuantity = 0
        order.orderlines.forEach { singleItem->
            //fright
             singleItem.fulfillments.forEach { fulfillmentX ->
                shipping = (shipping + fulfillmentX.freight).toInt()
            }

            //tax
            tax += singleItem.fet.toInt()

            //quantity
            totalQuantity += singleItem.quantityordered
        }

        return OrderDetailsX(shipping = shipping, tax = tax, totalQuantity = totalQuantity)
    }

    private fun getEcomPurchaseItem(
        order: OrderlineX,
        orderDetailsX: OrderDetailsX,
        cartItem: CartItem
    ): EcomPurchaseItem {
        return EcomPurchaseItem(
            freight = orderDetailsX.shipping,
            item_brand = cartItem.brand,
            item_id = order.atdproductnumber,
            item_name = cartItem.style,
            //item_category =  need to get atdProductGroup
            //item_variant = need to get atd productspec size
            lineItemNum = order.cartlinenumber,
            price = order.cost,
            quantity = order.quantityordered,
            sku = order.atdproductnumber,
            tax = orderDetailsX.tax,
            total = order.linetotal,
            //not possible as of NS need to check here
            status = "",
            shippingDC = "",
            shippingMethod = ""
        )
    }

    fun getEcomPurchaseItems(order: OrderXXX, cartItems: List<CartItem>): MutableList<EcomPurchaseItem> {
        val purchaseItems = mutableListOf<EcomPurchaseItem>()
        val orderDetail = getOrderDetails(order)

        order.orderlines.forEach { singleOrder ->
            val cartItem = cartItems.find { cartItem ->
                cartItem.supplier.equals(singleOrder.atdproductnumber, true)
            }
            val purchaseItem = cartItem?.let {
                getEcomPurchaseItem(
                    singleOrder,
                    orderDetail,
                    it
                )
            }
            if(purchaseItem != null) {
                purchaseItems.add(purchaseItem)
            }
        }

        return purchaseItems
    }

    fun getParcelableArray(items: MutableList<EcomPurchaseItem>?): MutableList<Bundle> {

        val toReturn : MutableList<Bundle> = mutableListOf()
        items?.forEach { item->
            val bundle = Bundle()
            with(bundle) {
                putString(FirebaseAnalytics.Param.ITEM_ID, item.item_id)
                putString(FirebaseAnalytics.Param.ITEM_NAME, item.item_name)
                item.quantity?.toDouble()?.let { putDouble(FirebaseAnalytics.Param.QUANTITY, it) }
                putString(FirebaseAnalytics.Param.ITEM_BRAND, item.item_brand)
                putString(FirebaseAnalytics.Param.CURRENCY, "USD")
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, item.item_category)
                putString(FirebaseAnalytics.Param.ITEM_VARIANT, item.item_variant)
                item.tax?.let { putDouble(FirebaseAnalytics.Param.TAX, it.toDouble()) }
                item.price?.let { putDouble(FirebaseAnalytics.Param.PRICE, it.toDouble()) }
                item.lineItemNum?.let { putDouble("lineItemNum", it.toDouble()) }
                putString("sku", item.sku)
                item.total?.let { putDouble("total", it.toDouble()) }
                putString("status", item.status)
                item.freight?.let { putDouble("freight", it.toDouble()) }
                putString("shippingMethod", item.shippingMethod)
                putString("shippingDC", item.shippingDC)


            }
            //add bundle to list
            toReturn.add(bundle)
        }
        return toReturn

    }



    fun getEcomProductsFormCartDetails(cartItems: MutableList<CartItem>): MutableList<EcomProduct> {
        val ecomProducts = mutableListOf<EcomProduct>()
        var index = 0
        cartItems.forEach { cartItem ->
            val ecomProduct = getEcomProductFormCartDetail(cartItem, index)
            if (!ecomProduct.item_id.isNullOrBlank()){
                ecomProducts.add(ecomProduct)
                index += 1
            }
        }
        return ecomProducts
    }

    private fun getEcomProductFormCartDetail(item: CartItem, index: Int): EcomProduct {
        return EcomProduct(
            item_id = item.supplier,
            item_name = item.style,
            item_brand = item.brand,
//            item_category = need to add atd product group
//            promotion_id = need to add rebate
//            item_variant = need to add size
            currency = "USD",
            index = index,
            price = item.cost.replace("$","").toFloat(),
//            retail = need to add retail
//            map = need to add map
//            hasRebates = need to add rebates
//            availability = need to add availability
        )
    }
    fun getParcelableArrayViewCart(items: MutableList<EcomProduct>?): MutableList<Bundle> {

        val toReturn : MutableList<Bundle> = mutableListOf()
        items?.forEach { item->
            val bundle = Bundle()
            with(bundle) {
                putString(FirebaseAnalytics.Param.ITEM_ID, item.item_id)
                putString(FirebaseAnalytics.Param.ITEM_NAME, item.item_name)
                item.quantity?.toDouble()?.let { putDouble(FirebaseAnalytics.Param.QUANTITY, it) }
                putString(FirebaseAnalytics.Param.ITEM_BRAND, item.item_brand)
                putString(FirebaseAnalytics.Param.CURRENCY, "USD")
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, item.item_category)
                putString(FirebaseAnalytics.Param.ITEM_VARIANT, item.item_variant)
                item.price?.let { putDouble(FirebaseAnalytics.Param.PRICE, it.toDouble()) }
//                item.tax?.let { putDouble(FirebaseAnalytics.Param.TAX, it.toDouble()) }
//                item.lineItemNum?.let { putDouble("lineItemNum", it.toDouble()) }
//                putString("sku", item.sku)
//                item.total?.let { putDouble("total", it.toDouble()) }
//                putString("status", item.status)
//                item.freight?.let { putDouble("freight", it.toDouble()) }
//                putString("shippingMethod", item.shippingMethod)
//                putString("shippingDC", item.shippingDC)


            }
            //add bundle to list
            toReturn.add(bundle)
        }
        return toReturn

    }
}
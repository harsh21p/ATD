package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.KeywordSearchResultItemBinding
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.models.preferences.ProductItems
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide
import com.google.gson.Gson
import java.text.NumberFormat
import kotlin.reflect.KFunction3


class KeywordSearcheResultAdapter(
    val onAddToCartClicked: (Cart) -> Unit,
    val isCustomerPickupDelivery: () -> Unit,
    val isFutureDelivery:() -> Unit,
    var activity: FragmentActivity,
    private val productSearches: ArrayList<Product>,
    sharedPrefManager: SharedPrefManager,
    val eventLogger: KFunction3<Int, Product, String, Unit>,
    val callProductFrag: (Bundle) -> Unit
) : RecyclerView.Adapter<KeywordSearcheResultAdapter.DataViewHolder>() {


    var selectedPosition = -1
    var lastSelectedPosition = -1
     var sharedPrefManager=sharedPrefManager
    class DataViewHolder(
        val binding: KeywordSearchResultItemBinding,
        val onAddToCartClicked: (Cart) -> Unit,
        val isCustomerPickupDelivery:() -> Unit,
        val isFutureDelivery:() -> Unit,
        private val listOfItems: ProductItems?,
        val eventLogger: KFunction3<Int, Product, String, Unit>,
        val callProductFrag: (Bundle) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            product: Product,
            activity: FragmentActivity,
            sharedPrefManager: SharedPrefManager,
            productSearches: ArrayList<Product>,

            ) {


            sharedPrefManager.getProfileSelected()?.let {
                if (it.equals("tirepros",true)){
                    binding.decreaseQty?.setBackgroundResource(R.drawable.decrese_tirepros)
                    binding.increaseQty?.setBackgroundResource(R.drawable.increse_tirepros)
                    binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24_tirepros)
                    binding.tvRebate?.setBackgroundResource(R.drawable.light_carved_background_24_tirepros)
                    binding.tvAddCart?.backgroundTintList= ContextCompat.getColorStateList(activity,R.color.red)
                    binding.tvAddToQuote.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.tvViewMarketingPrograms.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.tvViewRebates.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.tvAddToList.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.ivDottedMenu.imageTintList=ContextCompat.getColorStateList(activity,R.color.red)
                    binding.ivDottedMenu2.imageTintList=ContextCompat.getColorStateList(activity,R.color.red)
                    binding.tvAddToQuote.compoundDrawableTintList=ContextCompat.getColorStateList(activity,R.color.red)
                    binding.QtyValu?.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.tvProductName?.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))
                    binding.tvRebate?.setTextColor(ContextCompat.getColorStateList(activity,R.color.red))

                }else if (it.equals("atdonline",true)){
                    binding.decreaseQty?.setBackgroundResource(R.drawable.decrese)
                    binding.increaseQty?.setBackgroundResource(R.drawable.increse)
                    binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24)
                    binding.tvRebate?.setBackgroundResource(R.drawable.light_carved_background_24)
                    binding.tvAddCart?.backgroundTintList= ContextCompat.getColorStateList(activity,R.color.atd_blue)
                    binding.tvAddToQuote.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.tvViewMarketingPrograms.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.tvViewRebates.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.tvAddToList.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.ivDottedMenu.imageTintList=ContextCompat.getColorStateList(activity,R.color.atd_blue)
                    binding.ivDottedMenu2.imageTintList=ContextCompat.getColorStateList(activity,R.color.atd_blue)
                    binding.tvAddToQuote.compoundDrawableTintList=ContextCompat.getColorStateList(activity,R.color.atd_blue)
                    binding.QtyValu?.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.tvProductName?.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))
                    binding.tvRebate?.setTextColor(ContextCompat.getColorStateList(activity,R.color.atd_blue))

                }else{

                }
            }


            binding.tvProductName.text=product.brand +"\n"+product?.style?.toString()
            binding.tvProductModel.gone()
            binding.tvProductName.setOnClickListener {
                val bundle= Bundle()
                val productDetails= Gson().toJson(product)
                bundle.putString("productDetails",productDetails)
                bundle.putSerializable("keyWordSearchResults",productSearches)
//                val productDetailsFragment = ProductDetailsFragment()
                //bundle.putString("category", categoryType)
                //productDetailsFragment.arguments=bundle
                callProductFrag(bundle)
            }
            var productGroup:String=""
            if (product?.productgroup?.lowercase()?.contains("custom wheels",true) == true){

                product?.productspec?.let {
                    productGroup="${product?.productspec?.size?.trim().toString()} ${product?.productspec?.offset?.trim().toString()}"
                    binding.tvProductGroup.text=productGroup.replace("null","")
                }
            }else{
                productGroup="${product?.productspec?.size?.trim().toString()} ${product?.productspec?.loadindex?.trim().toString()}${product?.productspec?.speedrating?.uppercase()?.trim().toString()} ${product?.productspec?.treadwear?.trim().toString()} ${product?.productspec?.temperaturerating?.trim().toString()} ${product?.productspec?.tractionrating?.trim().toString()}"
                binding.tvProductGroup.text=productGroup.replace("null","")

            }


            //setting up qty based on product grp
            val currentProductGroup = product.productgroup
            listOfItems?.items?.forEach { item->
                if (item.code.equals(currentProductGroup, true)){
                    item.quantity?.let { binding.QtyValu.setText(it.toString()) }
                    return@forEach
                }
            }

            product?.availability?.local?.let {

                if(it<=0) {
                    binding.tvLocalValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
                }else {
                    binding.tvLocalValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
                }
                if(it>98) binding.tvLocalValue.text="99+" else binding.tvLocalValue.text= it.toString()

                }

            product?.availability?.localplus?.let {

                if(it<=0) {
                    binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
                }else {
                    binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
                }
                if(it>98) binding.tvLocalPlusValue.text="99+" else binding.tvLocalPlusValue.text= it.toString()

            }

            product?.availability?.nationwide?.let {

                if(it<=0) {
                    binding.tvNationalValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
                }else {

                    binding.tvNationalValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
                }
                if(it>98)  binding.tvNationalValue.text="99+" else  binding.tvNationalValue.text= it.toString()

            }


            binding.tvSupplierValue.text= product?.mfgproductnumber?.toString()

            product?.price?.retail?.let {
                if (it!=0.0) {
                    binding.tvRetailPrice.visible()
                    binding.tvRetailPrice.text = Constants.Dollar + roundOffDecimal(it)
                } else {
                    binding.tvRetailPrice.gone()
                }
            }


            product?.price?.fet?.let {
                if(it!=0.0)  binding.tvFet.text= Constants.Dollar+roundOffDecimal(it)+" FET" else  binding.tvFet.gone()
                }
            product?.price?.map?.let {
                if(it!=0.0)  binding.tvMap.text=Constants.Dollar+ roundOffDecimal(it) +" MAP" else  binding.tvMap.gone()

            }

            binding.tvCost.gone()
            if (sharedPrefManager.getCV() == false){
                product?.price?.cost?.let {
                    if(it>0){
                        binding.tvCost.visible()
                        binding.tvCost.text= Constants.Dollar+roundOffDecimal(it)+" Cost"
                }
            }
            }else {
                binding.tvCost.gone()
            }
            binding.tvOutofTheDoor.gone()

            if (product?.productgroup?.lowercase()?.contains("tires",true) == true){
                binding.tvWarrantyValue.visible()
                binding.tvWarranty.visible()
                binding.tvSidewallValue.visible()
                binding.tvSidewall.visible()
                binding.tvWarrantyValue.text= product.productspec.mileagewarranty
                binding.tvSidewallValue.text= product.productspec.sidewall

            }else if (product?.productgroup?.lowercase()?.contains("wheels",true) == true) {

                binding.tvWarrantyValue.visible()
                binding.tvWarranty.visible()
                binding.tvSidewallValue.visible()
                binding.tvSidewall.visible()
                binding.tvWarranty.text="Bolt Pattern"
                binding.tvSidewall.text="Finish"
                binding.tvWarrantyValue.text=product.productspec.boltpattern1
                binding.tvSidewallValue.text=product.productspec.atdfinish

            }else{
                binding.tvWarrantyValue.gone()
                binding.tvWarranty.gone()
                binding.tvSidewallValue.gone()
                binding.tvSidewall.gone()
            }



                Glide.with(activity)
                .load(product?.images?.thumbnail?.image?.get(0)?.url)
                .placeholder(R.drawable.image_not_available)
                .error(R.drawable.image_not_available)
                .into(binding.ivProduct)

            binding.ivProduct.setOnClickListener {

                product?.images?.large?.image?.get(0)?.url?.let { it1 -> Common.largeImage(it1,activity) }
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
            //outTheDoor.text= product.price.cost.toString()+" Out the Door"
            binding.llProductIcon.setOnClickListener {

                var productKeyDialog = Dialog(activity, R.style.WideDialog)
                productKeyDialog.setContentView(R.layout.search_results_icon_key)
                var closeDialog: ImageView = productKeyDialog.findViewById(R.id.closeDialog)
                closeDialog.setOnClickListener {
                    productKeyDialog.dismiss()
                }
                productKeyDialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
                productKeyDialog.show()
            }

            var quantity=binding.QtyValu.text.toString().toInt()
            binding.increaseQty.setOnClickListener {
                eventLogger(4, product, binding.QtyValu.text.toString())
                quantity+=1
                if(quantity <= 50) {
                    binding.QtyValu.setText(quantity.toString())
                }
            }
            binding.decreaseQty.setOnClickListener {
                eventLogger(5, product, binding.QtyValu.text.toString())
                if (quantity>1) {
                    quantity-=1
                    binding.QtyValu.setText(quantity.toString())
                }
            }

                binding.tvAddCart.setOnClickListener {
                    if(sharedPrefManager.getDeliveryDefault().toString() == "Pickup" && sharedPrefManager.getSelectedDelivery() == null){
                        if(binding.QtyValu.text.toString().toInt() > binding.tvLocalValue.text.toString().replace("+","").toInt()){
                            isCustomerPickupDelivery()
                            return@setOnClickListener
                        }
                    } else if (sharedPrefManager.getSelectedDelivery() != null && sharedPrefManager.getSelectedDelivery() =="Pickup"){
                        if(binding.QtyValu.text.toString().toInt() > binding.tvLocalValue.text.toString().replace("+","").toInt()){
                            isCustomerPickupDelivery()
                            return@setOnClickListener
                        }
                    } else if (sharedPrefManager.getSelectedDelivery() != null && (sharedPrefManager.getSelectedDelivery() =="isdeliveryon" ||
                                sharedPrefManager.getSelectedDelivery() =="isdeliveryby") ){
                        if(binding.QtyValu.text.toString().toInt() > (binding.tvLocalValue.text.toString().replace("+","").toInt() +binding.tvLocalPlusValue.text.toString().replace("+","").toInt() )){
                            isFutureDelivery()
                            return@setOnClickListener
                        }
                    }
                    val addCartDetails = Cart(product.brand, product.style, binding.tvProductGroup.text.toString(),binding.QtyValu.text.toString().toInt(),
                        product?.images?.thumbnail?.image?.get(0)?.url.toString(),product.mfgproductnumber,product.atdproductnumber,sharedPrefManager.getUserName().toString(),sharedPrefManager.getLocationNumber().toString(), Common.currentDateTime(), "")
                     onAddToCartClicked(addCartDetails)
            }



        }


        fun roundOffDecimal(number: Double): String {

            val formatter: NumberFormat = NumberFormat.getNumberInstance()
            formatter.setMinimumFractionDigits(2)
            formatter.setMaximumFractionDigits(2)
            val output: String = formatter.format(number)

            return output
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = KeywordSearchResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //getting user preferences
        val userPreferences: PreferencesConfiguration = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
        val listOfItems = userPreferences.productItems
        return DataViewHolder(binding,onAddToCartClicked, isCustomerPickupDelivery,isFutureDelivery,listOfItems, eventLogger, callProductFrag)
    }
       /* DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.keyword_search_result_item, parent, false))*/

    override fun getItemCount(): Int {

            return productSearches.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(productSearches[position],activity, sharedPrefManager,productSearches)

        holder.binding.ivDottedMenu.setOnClickListener {
            lastSelectedPosition = selectedPosition;
            selectedPosition = holder.adapterPosition
            notifyItemChanged(lastSelectedPosition);
            notifyItemChanged(selectedPosition);

        }

        if (selectedPosition == holder.adapterPosition) {
            holder.binding.llDottedMenu.visible()
        } else {
            holder.binding.llDottedMenu.gone()
        }

        holder.binding.tvAddToQuote.setOnClickListener {
            eventLogger(0, productSearches[position], holder.binding.QtyValu.text.toString())

        }
        holder.binding.ivDottedMenu2.setOnClickListener{
            holder.binding.llDottedMenu.gone()
        }

        holder.binding.tvViewRebates.setOnClickListener {
            eventLogger(2, productSearches[position], holder.binding.QtyValu.text.toString())
            holder.binding.llDottedMenu.gone()
            val mrktDialog= AlertDialog.Builder(activity, R.style.WideDialog)

            val view : View = LayoutInflater.from(activity)
                .inflate(R.layout.marketing_programs,null)

            val linearLayout : LinearLayout = view.findViewById(R.id.llMarketingPrograms)


            val close : TextView = view.findViewById(R.id.tvClose)
            val viewOnAspire : TextView = view.findViewById(R.id.tvViewOnAspire)
            close.setTextColor(ContextCompat.getColorStateList(activity,theameColor))
            viewOnAspire.setTextColor(ContextCompat.getColorStateList(activity,theameColor))
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
            productSearches.get(position).rebates?.let { rebates ->


                if (rebates.size > 0) {

                    val textView = TextView(activity)
                    textView.setLayoutParams(params)
                    textView.setText(rebates.get(0).description)
                    linearLayout.addView(textView)
                    viewOnAspire.setOnClickListener {

                        val url = rebates.get(0).url
                        val webIntent = Intent(Intent.ACTION_VIEW)
                        webIntent.data = Uri.parse(url)
                        activity.startActivity(webIntent)
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


        holder.binding.tvViewMarketingPrograms.setOnClickListener {
            eventLogger(1, productSearches[position], holder.binding.QtyValu.text.toString())
            holder.binding.llDottedMenu.gone()

            val mrktDialog= AlertDialog.Builder(activity, R.style.WideDialog)

            val view : View = LayoutInflater.from(activity)
                .inflate(R.layout.marketing_programs,null)

            val linearLayout : LinearLayout = view.findViewById(R.id.llMarketingPrograms)


            val close : TextView = view.findViewById(R.id.tvClose)
            val viewOnAspire : TextView = view.findViewById(R.id.tvViewOnAspire)
            mrktDialog.setView(view)
            val dialog = mrktDialog.create()
            close.setOnClickListener {
                dialog.dismiss()
            }
            viewOnAspire.setText("View on APEX")
            close.setTextColor(ContextCompat.getColorStateList(activity,theameColor))
            viewOnAspire.setTextColor(ContextCompat.getColorStateList(activity,theameColor))
            viewOnAspire.setOnClickListener{


               // val url = "https://atdrewards.aspireawards.com/"
                val url = "https://atdapex.channel-fusion.com/"
                val webIntent = Intent(Intent.ACTION_VIEW)
                webIntent.data = Uri.parse(url)
                activity.startActivity(webIntent)
                dialog.dismiss()
            }
            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            productSearches.get(position).marketingprograms?.let {

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


        holder.binding.tvAddToList.setOnClickListener {
            eventLogger(3, productSearches[position], holder.binding.QtyValu.text.toString())
            Toast.makeText(activity,"This feature is not yet implemented",Toast.LENGTH_SHORT).show()
        }


    }

    fun addProductSearches(productSearches: List<Product>) {
        this.productSearches.apply {
            clear()
            addAll(productSearches)
        }

    }





}
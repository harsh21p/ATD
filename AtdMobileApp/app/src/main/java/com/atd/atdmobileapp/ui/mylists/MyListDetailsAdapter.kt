package com.atd.atdmobileapp.ui.mylists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.MyListDetailsChildItemsBinding
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.bumptech.glide.Glide
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KFunction4

class MyListDetailsAdapter(
    var productList: ArrayList<Product>,
    val activity: FragmentActivity,
    val updateItems: KFunction4<Int, Int, Product?, String, Unit>,
    val themeColor: Int,
    val callProductDetails: (Bundle) -> Unit
) : RecyclerView.Adapter<MyListDetailsAdapter.ViewHolder>() {

    var items:Int=0
    var selectAll:Boolean?=null
    var increasedQuantity:Int?= 0
    var atdProductNumber:String= ""
    class ViewHolder(val binding:  MyListDetailsChildItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(themeColor: Int, activity: FragmentActivity) {
            binding.cbProduct.buttonTintList= ContextCompat.getColorStateList(activity,themeColor)
            binding.decreaseQty.backgroundTintList= ContextCompat.getColorStateList(activity,themeColor)
            binding.increaseQty.backgroundTintList= ContextCompat.getColorStateList(activity,themeColor)
            binding.tvProductModel.setTextColor( ContextCompat.getColorStateList(activity,themeColor))
            binding.QtyValu.setTextColor( ContextCompat.getColorStateList(activity,themeColor))

            if (themeColor==R.color.red){
                binding.QtyValu.background= ContextCompat.getDrawable(activity,R.drawable.light_carved_background_24_tirepros)
            }else if (themeColor==R.color.atd_blue){
                binding.QtyValu.background= ContextCompat.getDrawable(activity,R.drawable.light_carved_background_24)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = MyListDetailsChildItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(themeColor,activity)

        holder.binding.tvProductModel.text= (productList.get(position)?.brand+" "+productList.get(position)?.style).replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
        }
        holder.binding.tvProductModel.setOnClickListener {
            val bundle= Bundle()
            val productDetails= Gson().toJson(productList.get(0))
            bundle.putString("productDetails",productDetails)
            bundle.putSerializable("keyWordSearchResults",productList)
//                val productDetailsFragment = ProductDetailsFragment()
            //bundle.putString("category", categoryType)
            //productDetailsFragment.arguments=bundle
            callProductDetails(bundle)
        }
        var productGroup:String=""
        if (productList.get(position)?.productgroup?.lowercase()?.contains("custom wheels",true) == true){

            productList.get(position)?.productspec?.let {
                productGroup="${it.size?.trim().toString()} ${it.offset?.trim().toString()}"
                holder.binding.tvProductGroup.text=productGroup.replace("null","")
            }
        }else{
            productGroup="${productList.get(position)?.productspec?.size?.trim().toString()} ${productList.get(position)?.productspec?.loadindex?.trim().toString()}${productList.get(position)?.productspec?.speedrating?.uppercase()?.trim().toString()} ${productList.get(position)?.productspec?.treadwear?.trim().toString()} ${productList.get(position)?.productspec?.temperaturerating?.trim().toString()}${productList.get(position)?.productspec?.tractionrating?.trim().toString()}"
            holder.binding.tvProductGroup.text=productGroup.replace("null","")

        }

        holder.binding.tvProductNum.text="Product #: "+productList.get(position)?.atdproductnumber

        productList.get(position)?.availability?.local?.let {

            if(it<=0) {
                holder.binding.tvLocalValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
            }else {
                holder.binding.tvLocalValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
            }
            if(it>98) holder.binding.tvLocalValue.text="99+" else holder.binding.tvLocalValue.text= it.toString()

        }

        productList.get(position)?.availability?.localplus?.let {

            if(it<=0) {
                holder.binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
            }else {
                holder.binding.tvLocalPlusValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
            }
            if(it>98) holder.binding.tvLocalPlusValue.text="99+" else holder.binding.tvLocalPlusValue.text= it.toString()

        }

        productList.get(position)?.availability?.nationwide?.let {

            if(it<=0) {
                holder.binding.tvNationalValue.setTextColor(ContextCompat.getColor(activity, R.color.red))
            }else {

                holder.binding.tvNationalValue.setTextColor(ContextCompat.getColor(activity, R.color.green))
            }
            if(it>98) holder.binding.tvNationalValue.text="99+" else  holder.binding.tvNationalValue.text= it.toString()

        }


        Glide.with(activity)
            .load(productList.get(position)?.images?.thumbnail?.image?.get(0)?.url)
            .placeholder(R.drawable.image_not_available)
            .error(R.drawable.image_not_available)
            .into(holder.binding.ivProduct)

        holder.binding.tvCost.text= "$${productList.get(position).price.cost} /Unit"


        var quantity=productList.get(position).quantity?:0
        holder.binding.QtyValu.setText(quantity.toString())

        holder.binding.increaseQty.setOnClickListener {
            quantity+=1
            if(quantity <= 50) {
                items+=1
                productList[position].quantity=quantity
                if (holder.binding.cbProduct.isChecked) {
                    updateItems(productList.size,items,productList[position],"true")
                }else{
                    updateItems(productList.size, items, null, "")

                }
                holder.binding.QtyValu.setText(quantity.toString())
            }
        }
        holder.binding.decreaseQty.setOnClickListener {

            if (quantity>0) {
                quantity-=1
                productList[position].quantity=quantity
                items-=1
                if (holder.binding.cbProduct.isChecked) {
                    updateItems(productList.size,items,productList[position],"true")
                }else{
                    updateItems(productList.size, items, null, "")
                }

                holder.binding.QtyValu.setText(quantity.toString())
            }
        }

        holder.binding.cbProduct.setOnClickListener{

            if (holder.binding.cbProduct.isChecked){
                updateItems(productList.size,items,productList[position],"true")
            }else{
                updateItems(productList.size,items,productList[position],"false")

            }
        }

        if (selectAll==true){
            holder.binding.cbProduct.isChecked=true
            updateItems(productList.size,items,productList[position],"true")

        }else if (selectAll==false){
            holder.binding.cbProduct.isChecked=false
            updateItems(productList.size,items,productList[position],"false")
        }

        if (productList.get(position).quantity!=null) {
            items = productList.sumOf { it.quantity!! }
            updateItems(productList.size,items,null,"")
        }else{
            updateItems(productList.size,0,null,"")
        }


    }

    fun Update(result: ArrayList<Product>) {

        this.productList= result
    }

    fun selectAll(selectAll: Boolean) {
       this.selectAll=selectAll
    }

    fun updateQuantity(increasedQuantity: Int?, atdProductNumber: String) {
        this.increasedQuantity=increasedQuantity
        this.atdProductNumber=atdProductNumber
    }
}
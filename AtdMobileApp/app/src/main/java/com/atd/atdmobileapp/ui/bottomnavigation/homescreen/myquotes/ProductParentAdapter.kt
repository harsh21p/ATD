package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.QuoteDetailsProductItemBinding
import  com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.myquotes.Childaddon
import com.atd.atdmobileapp.models.myquotes.Item
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*


class ProductParentAdapter : ListAdapter<Product, ProductParentAdapter.ViewHolder>(FilterOptionsCallback()) {


    private var itemsList: MutableList<Item> = mutableListOf()
    var isWorkingQuote: Boolean = false

    inner class ViewHolder(private val binding: QuoteDetailsProductItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Product){
            if (isWorkingQuote){
                showWorkingQuoteIcons()
            }
            binding.tvProductName.text = buildString {
                append(item.brand)
                append(" ")
                append(item.style)
            }

            Glide.with(binding.root.context)
                .load(item?.images?.thumbnail?.image?.get(0)?.url)
                .placeholder(R.drawable.image_not_available)
                .error(R.drawable.image_not_available)
                .into(binding.ivProduct)

            binding.tvProductModel.text = buildString {
                item.productspec.size?.let {
                    append(it.uppercase())
                    append(" ")
                }

                append(item.productspec.loadindex ?: "")
                append(" ")

                item.productspec.speedrating?.let {
                    append(it.uppercase())
                    append(" ")
                }

                append(item.productspec.treadwear ?: "")
                append(" ")

                item.productspec.temperaturerating?.let {
                    append(it.uppercase())
                }

                item.productspec.tractionrating?.let {
                    append(it.uppercase())
                    append(" ")
                }

            }


            binding.tvProductGroup.text = buildString {
                append("ATD Part #: ")
                append(item.atdproductnumber)
            }


            //setting up child rv
            binding.rvChildProudctItem.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false )
            binding.rvChildProudctItem.setHasFixedSize(true)
            val adapter = ProductChildAdapter()
            binding.rvChildProudctItem.adapter = adapter
            var childaddon : MutableList<Childaddon> = mutableListOf()
            itemsList.forEach { item1 ->
                if (item1.atdproductnumber.equals(item.atdproductnumber, true)){
                    if(item1.childaddons != null){
                        childaddon = item1.childaddons.toMutableList()
                        binding.productQtyValue.text = item1.quantity.toString()
                        binding.tvSubLineTotal.text = buildString {
                            append(formatCurrency(item1.unitprice.toString()))
                            append(" ea.")
                        }
                        binding.tvLineTotal.text = formatCurrency(item1.linetotal.toString())
                    }
                }
            }
            adapter.submitList(childaddon)
        }

        private fun showWorkingQuoteIcons() {
            //hiding not required icons
            binding.productQty.gone()
            binding.productQtyValue.gone()

            binding.editItemFee.visible()
            binding.increaseQty.visible()
            binding.QtyValue.visible()
            binding.decreaseQty.visible()
            binding.deleteProduct.visible()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuoteDetailsProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.atdproductnumber == newItem.atdproductnumber
        }


    }

    fun addItem(item: MutableList<Item>){
        itemsList = item
    }

    fun formatCurrency(amountString: String): String {
        val locale: Locale = Locale.getDefault()
        val amount = try {
            amountString.toDouble()
        } catch (e: NumberFormatException) {
            // Handle invalid input gracefully (e.g., non-numeric strings)
            return ""
        }

        val currencyFormat = NumberFormat.getCurrencyInstance(locale)
        currencyFormat.minimumFractionDigits = 2
        currencyFormat.maximumFractionDigits = 2

        return currencyFormat.format(amount)
    }
}
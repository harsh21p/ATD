package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.QuoteFeesServicesCustomLayoutBinding
import com.atd.atdmobileapp.models.myquotes.Childaddon
import java.text.NumberFormat
import java.util.*

class ProductChildAdapter : ListAdapter<Childaddon, ProductChildAdapter.ViewHolder>(FilterOptionsCallback()) {

    inner class ViewHolder(private val binding: QuoteFeesServicesCustomLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Childaddon){
           binding.serviceName.text = item.name
            binding.serviceQty.text = item.quantity.toString()
            binding.serviceRetailCost.text = formatCurrency(item.unitprice.toString())
            binding.serviceTotalCost.text = formatCurrency(item.linetotal.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuoteFeesServicesCustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<Childaddon>() {
        override fun areItemsTheSame(oldItem: Childaddon, newItem: Childaddon): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Childaddon, newItem: Childaddon): Boolean {
            return oldItem.name == newItem.name
        }


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
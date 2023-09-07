package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.QuoteFeesServicesCustomLayoutBinding
import com.atd.atdmobileapp.models.myquotes.Quoteaddon
import java.text.NumberFormat
import java.util.*

class EditQuoteFeesAdapter() : ListAdapter<Quoteaddon, EditQuoteFeesAdapter.ViewHolder>(FilterOptionsCallback()) {


    inner class ViewHolder(private val binding: QuoteFeesServicesCustomLayoutBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(quoteAddOn: Quoteaddon, position: Int){
            binding.serviceName.text = quoteAddOn.name
            binding.serviceQty.text = buildString {
                append("QTY ")
                append(quoteAddOn.quantity)
            }
            binding.serviceRetailCost.text = formatCurrency(quoteAddOn.unitprice.toString())

            binding.serviceTotalCost.text = formatCurrency(quoteAddOn.linetotal.toString())

        }

    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<Quoteaddon>() {
        override fun areItemsTheSame(oldItem: Quoteaddon, newItem: Quoteaddon): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Quoteaddon, newItem: Quoteaddon): Boolean {
            return oldItem.description == newItem.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuoteFeesServicesCustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("Item here ${getItem(position)}")
        holder.bind(getItem(position), position)
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
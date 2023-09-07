package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.QuotesSubtotalFeesServicesCustomLayoutBinding
import com.atd.atdmobileapp.models.myquotes.SubTotalAddOns
import com.atd.atdmobileapp.models.productsearch.FilterItem
import java.text.NumberFormat
import java.util.*

class EditQuoteSubTotalAdapter: ListAdapter<SubTotalAddOns, EditQuoteSubTotalAdapter.VieHolder>(FilterOptionsCallback()) {

    inner class VieHolder(private val binding: QuotesSubtotalFeesServicesCustomLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: SubTotalAddOns, position: Int){
            binding.subtotalFeesName.text = item.name
            binding.tvSubTotal.text = formatCurrency(item.linetotal.toString())
        }

    }
    private class FilterOptionsCallback : DiffUtil.ItemCallback<SubTotalAddOns>() {
        override fun areItemsTheSame(oldItem: SubTotalAddOns, newItem: SubTotalAddOns): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SubTotalAddOns, newItem: SubTotalAddOns): Boolean {
            return oldItem.name==newItem.name
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VieHolder {
       val binding = QuotesSubtotalFeesServicesCustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VieHolder(binding)
    }

    override fun onBindViewHolder(holder: VieHolder, position: Int) {
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
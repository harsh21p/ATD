package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.StatusCustomLayoutBinding

class StatusAdapter(private val onClick: (String) -> Unit) : ListAdapter<String, StatusAdapter.ViewHolder>(YearDiffCallback()) {

    inner class ViewHolder(private val binding: StatusCustomLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: String){
            binding.textView2.text = item
            binding.iv.setImageResource(setStatus(item))

            binding.root.setOnClickListener {
                onClick(item)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StatusCustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class YearDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private fun setStatus(status: String): Int {
        val statusDrawableMap = mapOf(
            "Converted" to R.drawable.green,
            "Closed" to R.drawable.red,
            "Deleted" to R.drawable.red
        )

        val defaultDrawableResId = R.drawable.yellow

        val status = status
        return statusDrawableMap[status] ?: defaultDrawableResId
    }

}
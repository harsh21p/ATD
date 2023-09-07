package com.atd.atdmobileapp.ui.vehicle.positionandsize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class ValueAdapter(private val sendValue: (String) -> Unit, private val currentSelectedValue: String) : ListAdapter<String, ValueAdapter.ViewHolder>(ValueDiffCallback()) {


    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(value: String){
            binding.yearTextView.text = value+"\""
            binding.root.setOnClickListener{
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                sendValue(value)
            }
            if (value.equals(currentSelectedValue, true)){
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    private class ValueDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
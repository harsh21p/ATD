package com.atd.atdmobileapp.ui.vehicle.oesize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class OESizeAdapter(private val sendOESize: (String) -> Unit, private val selectedOESize: String?) : ListAdapter<String, OESizeAdapter.ViewHolder>(OEDiffCallback()) {

    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(size: String) {
            if (size == selectedOESize){
                binding.yearTextView.text = size
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendOESize(size)
                }
            }else{
                binding.yearTextView.text = size
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendOESize(size)
                }
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

    private class OEDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
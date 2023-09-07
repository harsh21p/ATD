package com.atd.atdmobileapp.ui.vehicle.trim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class TrimAdapter(private val sendTrim: (String) -> Unit, private val selectedTrim: String?) : ListAdapter<String, TrimAdapter.TrimViewHolder>(TrimDiffCallback()) {


    inner class TrimViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(trim: String) {
            if (trim == selectedTrim){
                binding.yearTextView.text = trim
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendTrim(trim)
                }
            }else{
                binding.yearTextView.text = trim
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendTrim(trim)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrimViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrimViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrimViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class TrimDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
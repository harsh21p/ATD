package com.atd.atdmobileapp.ui.vehicle.year

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class YearsAdapter(
    private val sendYear: (String) -> Unit,
    private val selectedYear: String?
) : ListAdapter<String, YearsAdapter.YearViewHolder>(YearDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YearViewHolder, position: Int) {
        val year = getItem(position)
        holder.bind(year)
    }

    inner class YearViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(year: String) {
            if (year == selectedYear){
                binding.yearTextView.text = year
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                binding.root.setOnClickListener {
                    sendYear(year)
                }
            }else{
                binding.yearTextView.text = year
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendYear(year)
                }
            }
        }
    }

    private class YearDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}


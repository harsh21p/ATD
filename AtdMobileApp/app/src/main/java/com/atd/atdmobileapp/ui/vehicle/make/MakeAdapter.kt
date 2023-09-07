package com.atd.atdmobileapp.ui.vehicle.make

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class MakeAdapter(
    private val sendMake: (String) -> Unit,
    private val selectedMake: String?
    ) : ListAdapter<String, MakeAdapter.MakeViewHolder>(YearDiffCallback()) {


    inner class MakeViewHolder(private val binding: CustomLayoutYearsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(make: String) {
            if (make == selectedMake){
                binding.yearTextView.text = make
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                binding.root.setOnClickListener {
                    sendMake(make)
                }
            }else{
                binding.yearTextView.text = make
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendMake(make)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        val make = getItem(position)
        holder.bind(make)

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
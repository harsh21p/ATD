package com.atd.atdmobileapp.ui.vehicle.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class ModelAdapter(private val sendModel: (String) -> Unit, private val selectedModel: String?) : ListAdapter<String, ModelAdapter.ModelViewHolder>(ModelDiffCallback()) {


    inner class ModelViewHolder(private val binding: CustomLayoutYearsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: String) {
            if (model == selectedModel){
                binding.yearTextView.text = model
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendModel(model)
                }
            }else{
                binding.yearTextView.text = model
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
                binding.root.setOnClickListener {
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                    sendModel(model)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    private class ModelDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
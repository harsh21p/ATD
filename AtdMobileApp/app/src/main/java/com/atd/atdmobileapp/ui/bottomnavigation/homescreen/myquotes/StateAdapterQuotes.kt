package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding
import com.atd.atdmobileapp.models.State

class StateAdapterQuotes(private val onClick: (State) -> Unit, private val selectedSate: String) : ListAdapter<State, StateAdapterQuotes.ViewHolder>(FilterOptionsCallback()) {


    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: State){
            binding.yearTextView.text = item.value

            //checking if prev selected state
            if (item.value.equals(selectedSate, true) || item.code.equals(selectedSate, true)){
                binding.radioButtonYear.setImageResource(R.drawable.radio_selected)
            }

            binding.root.setOnClickListener {
                binding.radioButtonYear.setImageResource(R.drawable.radio_selected)
                onClick(item)
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

    private class FilterOptionsCallback : DiffUtil.ItemCallback<State>() {
        override fun areItemsTheSame(oldItem: State, newItem: State): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: State, newItem: State): Boolean {
            return oldItem.code == newItem.code
        }


    }
}
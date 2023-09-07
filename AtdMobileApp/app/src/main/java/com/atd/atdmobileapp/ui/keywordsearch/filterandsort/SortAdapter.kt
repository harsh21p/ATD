package com.atd.atdmobileapp.ui.keywordsearch.filterandsort

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding

class SortAdapter(var previousSelectedOption: Any?, private val onClick: (String) -> Unit) : ListAdapter<String, SortAdapter.ViewHolderSort>(SortOptionsCallback()) {

//    var currentSelection: String = ""

    inner class ViewHolderSort(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(option: String, position: Int){
            binding.yearTextView.text = option

            if (option.equals(previousSelectedOption.toString(), true)){
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
            }else{
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)

            }

            binding.root.setOnClickListener {
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
//                currentSelection = option
                onClick(option)
            }
            //write logic to replace other imageviews with R.drawable.unselected_radio_button

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSort {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderSort(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderSort, position: Int) {
        holder.bind(getItem(position), position)
    }

    private class SortOptionsCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
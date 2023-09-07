package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment

class DeleteQuoteAdapter(private val onClick: (String) -> Unit,val requireActivity: FragmentActivity) : ListAdapter<String, DeleteQuoteAdapter.ViewHolder>(FilterOptionsCallback()) {

    var prevSelection = ""

    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: String){
            binding.yearTextView.text = item
            if (item == prevSelection){
                if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue){
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                }else{
                    binding.radioButtonYear.setImageResource(R.drawable.radio_selected_red)
                }
            }else{
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
            }

            binding.root.setOnClickListener {
                if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue){
                    binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
                }else{
                    binding.radioButtonYear.setImageResource(R.drawable.radio_selected_red)
                }
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


    private class FilterOptionsCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }


    }

}
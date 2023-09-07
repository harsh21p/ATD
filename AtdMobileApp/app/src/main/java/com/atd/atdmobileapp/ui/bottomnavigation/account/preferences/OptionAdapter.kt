package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment


class OptionAdapter(private val send: (String) -> Unit,val requireActivity: FragmentActivity) : ListAdapter<String, OptionAdapter.ViewHolder>(YearDiffCallback()) {

    var previousSelection: String = ""

    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: String, position: Int){
            binding.yearTextView.text = item

            if (item.equals(previousSelection, true)){
                if (BottomNavigationScreenFragment.theameColor==R.color.red){
                    binding.radioButtonYear.setImageResource(R.drawable.radio_selected_red)
                }else{
                    binding.radioButtonYear.setImageResource(R.drawable.radio_selected)
                }
            }else{
                binding.radioButtonYear.setImageResource(R.drawable.unselected_radio_button)
            }

            binding.root.setOnClickListener {
                //send back selected year
                send(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomLayoutYearsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
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
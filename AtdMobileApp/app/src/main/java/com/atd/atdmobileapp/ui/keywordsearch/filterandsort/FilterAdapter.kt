package com.atd.atdmobileapp.ui.keywordsearch.filterandsort

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding
import com.atd.atdmobileapp.databinding.NestedItemBinding
import com.atd.atdmobileapp.models.productsearch.FilterItem
import com.atd.atdmobileapp.utils.visible

class FilterAdapter(
    var type: String,
    private val onClick: (String, FilterItem, Int) -> Unit,
    private val context: FragmentActivity,
    private var filterItems: List<FilterItem> = emptyList()
) : ListAdapter<FilterItem, FilterAdapter.ViewHolder>(FilterOptionsCallback()) {

    inner class ViewHolder(private val binding: NestedItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:FilterItem, position: Int){
            if (type == context.getString(R.string.availability) || type.equals(context.getString(R.string.run_flat), true)){
                binding.nestedItemTv.text = item.name
                if (item.name.equals("y", true)){
                    binding.nestedItemTv.text = "Yes"
                }
                if (item.name.equals("n", true)){
                    binding.nestedItemTv.text = "No"
                }
                if (item.isSelected == true){
                    binding.ivUncheck.visible()
                    binding.ivUncheck.setImageResource(R.drawable.selected_radio_button)
                }else{
                    binding.ivUncheck.visible()

                    binding.ivUncheck.setImageResource(R.drawable.unselected_radio_button)
                }

                binding.root.setOnClickListener {
                    if (item.isSelected == true){
                        binding.ivUncheck.visible()

                        binding.ivUncheck.setImageResource(R.drawable.unselected_radio_button)
                        item.isSelected = false
                        onClick(type, item, position)
                    }else{
                        binding.ivUncheck.visible()

                        binding.ivUncheck.setImageResource(R.drawable.selected_radio_button)
                        item.isSelected = true
                        onClick(type, item, position)
                    }
                }

            }else{
                binding.nestedItemTv.text = item.name?.uppercase()

                if (item.isSelected == true){
                    binding.ivUncheck.visible()

                    binding.ivUncheck.setImageResource(R.drawable.checkbox_selected)
                }else{
                    binding.ivUncheck.visible()

                    binding.ivUncheck.setImageResource(R.drawable.checkbox_unselected)
                }

                binding.root.setOnClickListener {
                    if (item.isSelected == true){
                        binding.ivUncheck.visible()

                        binding.ivUncheck.setImageResource(R.drawable.checkbox_unselected)
                        item.isSelected = false
                        onClick(type, item, position)
                    }else{
                        binding.ivUncheck.visible()

                        binding.ivUncheck.setImageResource(R.drawable.checkbox_selected)
                        item.isSelected = true
                        onClick(type, item, position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NestedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item in filterItems) {
            holder.bind(item, position)
        }
    }

    fun clearItems(){
        filterItems = emptyList()
        submitList(filterItems)
    }

    fun setData(newItems: List<FilterItem>) {
        filterItems = newItems
        submitList(filterItems)
    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<FilterItem>() {
        override fun areItemsTheSame(oldItem: FilterItem, newItem: FilterItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FilterItem, newItem: FilterItem): Boolean {
            return oldItem.name.equals(newItem.name)
        }

    }

}
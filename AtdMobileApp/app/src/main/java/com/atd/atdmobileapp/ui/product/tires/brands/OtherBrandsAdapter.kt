package com.atd.atdmobileapp.ui.product.tires.brands

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.NestedItemBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.utils.visible
import java.util.*
import kotlin.collections.HashSet

class OtherBrandsAdapter(
    private val onSelectOtherBrandClicked: (Set<String>, Set<Int>) -> Unit,
   val requireActivity: FragmentActivity
) :
    ListAdapter<String, OtherBrandsAdapter.NestedViewHolder>(ComparatorDiffUtil()) {

    private val rowIndex = HashSet<Int>()
    private val selectedItems = mutableSetOf<String>()
    private val selectedPositions = mutableSetOf<Int>()

    private var originalItems = listOf<String>()
    private var filteredItems = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        val binding = NestedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NestedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        val brand = getItem(position)
        brand?.let {
            holder.bind(it, position)
        }
    }

    inner class NestedViewHolder(private val binding: NestedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(brand: String, position: Int) {
            binding.ivUncheck.visible()
            binding.nestedItemTv.text = brand
            if (selectedPositions.contains(position)){
                if (BottomNavigationScreenFragment.theameColor==R.color.red){
                    binding.ivUncheck.setImageResource(R.drawable.checkbox_selected_tirepros)
                }else{
                    binding.ivUncheck.setImageResource(R.drawable.checkbox_selected)
                }
            }else{
                binding.ivUncheck.setImageResource(R.drawable.checkbox_unselected)
            }
            binding.root.setOnClickListener {
                if (!rowIndex.contains(position)) {
                    rowIndex.add(position)
                    selectedItems.add(brand)
                    selectedPositions.add(position)
                } else {
                    rowIndex.remove(position)
                    selectedItems.remove(brand)
                    selectedPositions.remove(position)
                }

                if (selectedPositions.contains(position)){
                    if (BottomNavigationScreenFragment.theameColor==R.color.red){
                        binding.ivUncheck.setImageResource(R.drawable.checkbox_selected_tirepros)
                    }else{
                        binding.ivUncheck.setImageResource(R.drawable.checkbox_selected)
                    }
                }else{
                    binding.ivUncheck.setImageResource(R.drawable.checkbox_unselected)
                }
                onSelectOtherBrandClicked(selectedItems, getSelectedPositions())
            }
        }
    }

    fun clearSelectedViews() {
        selectedPositions.clear()
        selectedItems.clear()
        notifyDataSetChanged()
    }

    fun setSelectedViews(selectedPositions: Set<Int>, selectedItems:kotlin.collections.Set<String>) {
        this.selectedPositions.clear()
        this.selectedItems.clear()
        this.selectedPositions.addAll(selectedPositions)
        this.selectedItems.addAll(selectedItems)

        notifyDataSetChanged()
    }

    fun setItems(items: List<String>) {
        originalItems = items
        filterItems("")
    }

    fun filterItems(query: String) {
        val lowercaseQuery = query.lowercase(Locale.getDefault())
        filteredItems = if (query.isEmpty()) {
            originalItems
        } else {
            originalItems.filter { it.lowercase(Locale.getDefault()).contains(lowercaseQuery) }
        }
        notifyDataSetChanged()
    }

    private fun getSelectedPositions(): Set<Int> {
        val selectedPositions = mutableSetOf<Int>()
        selectedItems.forEach { selectedItem ->
            val position = originalItems.indexOf(selectedItem)
            if (position != -1) {
                selectedPositions.add(position)
            }
        }
        return selectedPositions
    }

    override fun getItemCount(): Int = filteredItems.size

    override fun getItem(position: Int): String = filteredItems[position]

    class ComparatorDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
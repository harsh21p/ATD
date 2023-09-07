package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.PreferencesCustomQuantityLayoutBinding
import com.atd.atdmobileapp.models.preferences.Item
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment

class QuantityAdapter(private val sendQty: (List<Item>) -> Unit,val requireActivity: FragmentActivity) : ListAdapter<Item, QuantityAdapter.ViewHolder>(YearDiffCallback()) {

    private var localItemList: List<Item> = emptyList()

    inner class ViewHolder(private val binding: PreferencesCustomQuantityLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item){
            binding.title.text = item.value
            binding.QtyValu.text = item.quantity.toString()
            binding.QtyValu?.setTextColor(ContextCompat.getColorStateList(requireActivity,BottomNavigationScreenFragment.theameColor))
            if (BottomNavigationScreenFragment.theameColor== R.color.red){
                binding.increaseQty?.setBackgroundResource(R.drawable.increse_tirepros)
                binding.decreaseQty?.setBackgroundResource(R.drawable.decrese_tirepros)
                binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24_tirepros)
            }else{
                binding.increaseQty?.setBackgroundResource(R.drawable.increse)
                binding.decreaseQty?.setBackgroundResource(R.drawable.decrese)
                binding.QtyValu?.setBackgroundResource(R.drawable.light_carved_background_24)
            }
            binding.decreaseQty.setOnClickListener {
                var temp = item.quantity
                if (temp != null) {
                    temp -= 1
                }
                if (temp != null) {
                    if (temp>0){
                        binding.QtyValu.text = temp.toString()
                        val index:Int = localItemList.indexOf(item)
                        localItemList[index].quantity = temp
                        setData(localItemList)
                        sendQty(localItemList)
                    }
                }
            }

            binding.increaseQty.setOnClickListener {
                var temp = item.quantity
                if (temp != null) {
                    temp += 1
                }
                binding.QtyValu.text = temp.toString()
                val index:Int = localItemList.indexOf(item)
                localItemList[index].quantity = temp
                setData(localItemList)
                sendQty(localItemList)
            }
        }
    }


    fun setData(itemList: List<Item>){
        localItemList = itemList
        submitList(localItemList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PreferencesCustomQuantityLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item in localItemList){
            holder.bind(item)
        }
    }

    private class YearDiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.quantity == newItem.quantity
        }

    }
}

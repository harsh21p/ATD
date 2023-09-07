package com.atd.atdmobileapp.ui.mylists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.SelectOptionItemBinding

class FrequencyAdapter(
    private val list: ArrayList<String>,
    private val selectedItem: (String) -> Unit,
    private val selectedItem1: String,
    private val color: Int?,
    private val requireActivity: FragmentActivity
) : RecyclerView.Adapter<FrequencyAdapter.ViewHolder>() {

    private var lastCheckedPosition = -1

    class ViewHolder(val binding: SelectOptionItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {

        val binding = SelectOptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (selectedItem1.equals(list.get(position),false)){
            holder.binding.rbWheelType.isChecked=true
            holder.binding.rbWheelType.buttonTintList=
                color?.let { ContextCompat.getColorStateList(requireActivity, it) }

        }
        holder.binding.rbWheelType.setText(list.get(position))

        holder.binding.rbWheelType.setOnClickListener {
            this.selectedItem(list.get(position))
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }


}
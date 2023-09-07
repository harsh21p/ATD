package com.atd.atdmobileapp.ui.product.wheels.wheeltype

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.SelectOptionItemBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel

class WheelsTypeAdapter(
    private val list: ArrayList<String>,
    val updateViewModel: UpdateViewModel,
    val dialog: Dialog,
    val selectedList: ArrayList<String>,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<WheelsTypeAdapter.ViewHolder>() {

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


        selectedList.map {
            if (list.get(position).toString().trim().equals( it,false)){
                holder.binding.rbWheelType.isChecked=true
            }
        }
        holder.binding.rbWheelType.setText(list.get(position))

        holder.binding.rbWheelType.buttonTintList=ContextCompat.getColorStateList(requireActivity,BottomNavigationScreenFragment.theameColor)
        holder.binding.rbWheelType.setOnClickListener {
            val copyOfLastCheckedPosition = lastCheckedPosition
            lastCheckedPosition = holder.adapterPosition
            notifyItemChanged(copyOfLastCheckedPosition)
            notifyItemChanged(lastCheckedPosition)
            updateViewModel.wheelType(list.get(position))
            holder.binding.rbWheelType.setChecked(position == lastCheckedPosition);
            dialog.dismiss()
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }


}
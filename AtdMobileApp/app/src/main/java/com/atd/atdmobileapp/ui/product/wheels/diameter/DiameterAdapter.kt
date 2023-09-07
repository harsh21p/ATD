package com.atd.atdmobileapp.ui.product.wheels.wheeltype

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.DiameterOptionItemBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem
import com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel

class DiameterAdapter(
    private val list: ArrayList<String>,
    val updateViewModel: UpdateViewModel,
    val dialog: Dialog,
    val requireActivity: OnClickItem,
    var CheckedItemsList: ArrayList<String>,
    val requireActivity1: FragmentActivity
) : RecyclerView.Adapter<DiameterAdapter.ViewHolder>() {

    var CheckedItems: ArrayList<String>?=null
    init {
        CheckedItems= ArrayList<String>()
    }

    class ViewHolder(val binding: DiameterOptionItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {

        val binding = DiameterOptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.rbWheelType.setText(list.get(position))
       // holder.binding.rbWheelType.setChecked(position == lastCheckedPosition);


        holder.binding.rbWheelType.buttonTintList= ContextCompat.getColorStateList(requireActivity1, BottomNavigationScreenFragment.theameColor)

        for (i in 0 until CheckedItemsList!!.size){

            if ((list.get(position).toString().trim()==( CheckedItemsList!!.get(i)).toString().trim())){
                holder.binding.rbWheelType.isChecked=true

            }
        }


        holder.binding.rbWheelType.setOnClickListener {

            if (holder.binding.rbWheelType.isChecked==true) {
                CheckedItemsList.add(list.get(position).toString().trim())
                requireActivity.ClickItem(CheckedItemsList.size.toString(), false)
            }else if (holder.binding.rbWheelType.isChecked==false) {
                var removeData = list.get(position).toString().trim()
                CheckedItemsList.remove(removeData)
                requireActivity.ClickItem(CheckedItemsList.size.toString(), false)


            }
           // dialog.dismiss()
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

    fun clearAll() {

        CheckedItemsList.removeAll(CheckedItemsList)
        requireActivity.ClickItem("All", false)


    }

    fun addAll() {

            updateViewModel.sendDiameter(CheckedItemsList)
            requireActivity.BackPressed()


    }

    fun CheckedItemm(checkedList: ArrayList<String>?) {

        if (checkedList != null) {
            CheckedItemsList=checkedList
        }
    }


}
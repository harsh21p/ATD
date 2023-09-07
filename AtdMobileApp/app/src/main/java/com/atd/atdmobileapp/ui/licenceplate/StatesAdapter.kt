package com.atd.atdmobileapp.ui.licenceplate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.SelectOptionItemBinding
import org.json.JSONArray
import kotlin.reflect.KFunction1

class StatesAdapter(
    val update: KFunction1<String, Unit>,
    private val list: JSONArray
) : RecyclerView.Adapter<StatesAdapter.ViewHolder>() {


     var selectedItem : String=""
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





        if (list.getJSONObject(position).getString("value")==selectedItem){
            holder.binding.rbWheelType.isChecked=true
        }else{
            holder.binding.rbWheelType.isChecked=false

        }

        holder.binding.rbWheelType.setText(list.getJSONObject(position).getString("value"))

        holder.binding.rbWheelType.setOnClickListener {

            holder.binding.rbWheelType.setChecked(true);
            update(list.getJSONObject(position).getString("value"))
        }
    }

    override fun getItemCount(): Int {

        return list.length()
    }

    fun SelectedItem(selectedItem: String) {
       this.selectedItem=selectedItem
    }


}
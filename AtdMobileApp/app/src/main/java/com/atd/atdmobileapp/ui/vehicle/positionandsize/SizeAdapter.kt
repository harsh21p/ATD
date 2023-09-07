package com.atd.atdmobileapp.ui.vehicle.positionandsize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding
import kotlin.reflect.KFunction2

class SizeAdapter(
    private val sendSize: KFunction2<String, String, Unit>,
    private val oeDia: String,
    private val prevSelectedSize: String
) : ListAdapter<String, SizeAdapter.ViewHolder>(SizeDiffCallback()) {

    inner class ViewHolder(private val binding: CustomLayoutYearsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(size : String){
            var toSend:String = size
            if (!toSend.equals("All Sizes", true)){
                binding.yearTextView.text = toSend +"\""
            }else binding.yearTextView.text = toSend
            try {
                val sizeInt = size.toInt()
                val oeDiaInt = oeDia.toFloat().toInt()
                println("size to int->$sizeInt \n oeDia to int ->$oeDiaInt")
                if (sizeInt == oeDiaInt){
                    toSend = size +  "\" (OE)"
                    binding.yearTextView.text = toSend

                }else if (sizeInt > oeDiaInt){
                    toSend = size +"\""+ " (+${sizeInt-oeDiaInt})"
                    binding.yearTextView.text = toSend
                }
            }catch (e: Exception){
                println(e.message)
            }
            if (toSend.equals(prevSelectedSize,true)){
                binding.radioButtonYear.setImageResource(R.drawable.selected_radio_button)
            }
            binding.root.setOnClickListener{
                //send data back
                sendSize(toSend, size)
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

    private class SizeDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}
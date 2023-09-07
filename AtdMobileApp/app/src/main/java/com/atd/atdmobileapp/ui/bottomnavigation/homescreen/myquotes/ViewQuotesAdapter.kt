package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.MyquotesItemBinding
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment

class ViewQuotesAdapter(
    private val onClick: (Retailquote) -> Unit,
   val requireActivity: FragmentActivity
) : ListAdapter<Retailquote, ViewQuotesAdapter.ViewHolder>(FilterOptionsCallback()) {


    inner class ViewHolder(val binding: MyquotesItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(retailquote: Retailquote){

            binding.name.text=retailquote.consumerinfo.firstname+" "+retailquote.consumerinfo.lastname


            binding.orderStatus.text=retailquote.quoteinfo.status

            if (retailquote.quoteinfo.status.trim().equals("Open",true)
                ||retailquote.quoteinfo.status.trim().equals("Contacted",true)
                ||retailquote.quoteinfo.status.trim().equals("Working",true)){
                binding.orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

            }else if (retailquote.quoteinfo.status.trim().equals("Converted",true)){
                binding.orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0);

            }else if (retailquote.quoteinfo.status.trim().equals("Closed",true)){

                binding.orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0);
            }
            binding.quoteNum.text="Quote #: "+retailquote.retailquoteid
            binding.datePlaced.text=retailquote.quoteinfo.createdon
            binding.quotedBy.text="Quoted by: "+retailquote.quoteinfo.createdbyuserid


            itemView.setOnClickListener {
                onClick(retailquote)
            }

        }


    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<Retailquote>() {
        override fun areItemsTheSame(oldItem: Retailquote, newItem: Retailquote): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Retailquote, newItem: Retailquote): Boolean {
            return oldItem.retailquoteid == newItem.retailquoteid
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyquotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.name.setTextColor(ContextCompat.getColorStateList(requireActivity, BottomNavigationScreenFragment.theameColor))

    }
}
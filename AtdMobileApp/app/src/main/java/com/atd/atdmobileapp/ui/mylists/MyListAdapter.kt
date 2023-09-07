package com.atd.atdmobileapp.ui.mylists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.MylistChildItemsBinding
import com.atd.atdmobileapp.models.mylist.Productlists
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import kotlin.reflect.KFunction1


class MyListAdapter(
    val actvity: FragmentActivity,
    var myList: List<Productlists>,
    val sharedPrefManager: SharedPrefManager,
    val MyListDetails: KFunction1<Productlists, Unit>
) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {




    class ViewHolder(val binding: MylistChildItemsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(productlists: Productlists) {

            binding.tvName.text=productlists.name

            val totalItems= productlists.products?.size
            binding.tvTotalItems.text=totalItems.toString()+" "+Constants.Total_Items


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = MylistChildItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){

                holder.binding.tvName.setTextColor(
                    ContextCompat.getColorStateList(actvity,
                        R.color.red))
                holder.binding.ivProducts.setImageDrawable(ContextCompat.getDrawable(actvity, R.drawable.right_arrow_tirepros))

            }else if (it.equals("atdonline",true)){

                holder.binding.tvName.setTextColor(
                    ContextCompat.getColorStateList(actvity,
                        R.color.atd_blue))
                holder.binding.ivProducts.setImageDrawable(ContextCompat.getDrawable(actvity, R.drawable.right_arrow))

            }else{

            }
        }

        holder.bind(myList[position])

        holder.binding.root.setOnClickListener {

            MyListDetails(myList.get(position))

        }

    }

    fun updateData(myList: List<Productlists>) {
        this.myList=myList
    }
}
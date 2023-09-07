package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.ApprovalsItemBinding
import com.atd.atdmobileapp.models.myapprovals.Orderapproval
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsFragment
import com.atd.atdmobileapp.utils.Common
import com.atd.atdmobileapp.utils.Common.twoDecimal
import com.atd.atdmobileapp.utils.Constants
import com.google.gson.Gson


class MyApprovalsAdapter(
    private val Orders: ArrayList<Orderapproval>,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<MyApprovalsAdapter.DataViewHolder>() {

    private var showAll: Boolean=false


    class DataViewHolder(val binding: ApprovalsItemBinding, val requireActivity: FragmentActivity) : RecyclerView.ViewHolder(binding.root) {



        fun bind(orderApproval: Orderapproval) {

            binding.tvSubmittedBy.setTextColor(
                ContextCompat.getColorStateList(requireActivity,
                    BottomNavigationScreenFragment.theameColor
                ))
            binding.tvSubmittedBy.text="Submitted by "+orderApproval.submittedby
            binding.total.text= "Total: $"+twoDecimal(orderApproval.orderdetails.ordertotal)
            binding.datePlaced.text=orderApproval?.dateplaced?.toString()
                ?.let { Common.getApprovalMonthNameDayYear(it) }

            binding.tvSubmittedBy.setOnClickListener {

                val orderDetails= Gson().toJson(orderApproval)
                val fragment = MyOrderDetailsFragment()
                var bundle= Bundle()
                bundle.putString("orderDetails",orderDetails)
                bundle.putString(Constants.KEY_TYPE, Constants.SUBMITAPPROVALS)
                fragment.arguments=bundle
                requireActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("MyOrderFragment")
                    .commit()
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val binding= ApprovalsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding,requireActivity)

    }

    override fun getItemCount(): Int {
        if (Orders.size>3){
            return 3
        }else{
            return Orders.size
        }
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position])
    }

    fun addApprovals(Orders: List<Orderapproval>) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }

    }

    fun viewAll(showAll:Boolean){

        this.showAll=showAll
    }

}
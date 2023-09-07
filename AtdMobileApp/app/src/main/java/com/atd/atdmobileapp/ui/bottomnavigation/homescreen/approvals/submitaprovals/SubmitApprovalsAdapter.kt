package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.SubmitApprovalsBinding
import com.atd.atdmobileapp.models.myapprovals.Orderapproval
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsFragment
import com.atd.atdmobileapp.utils.Common
import com.atd.atdmobileapp.utils.Common.twoDecimal
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import com.google.gson.Gson


class SubmitApprovalsAdapter(
    val requiresActivity:  FragmentActivity,
    private val Orders: ArrayList<Orderapproval>,
    val approve: ApproveData
) : RecyclerView.Adapter<SubmitApprovalsAdapter.DataViewHolder>() {

    private var sellectAll: Boolean=false
    private var checkBoxVisible: Boolean=false


    class DataViewHolder(val binding: SubmitApprovalsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(orderApproval: Orderapproval, requiresActivity: FragmentActivity) {

            binding.cbSubmittedBy.buttonTintList=(ContextCompat.getColorStateList(requiresActivity,theameColor))
            binding.tvSubmittedBy.setTextColor(ContextCompat.getColorStateList(requiresActivity,theameColor))

            binding.tvDate.text= orderApproval?.dateplaced?.toString()
                ?.let { Common.getApprovalMonthNameDayYear(it) }

            binding.tvSubmittedBy.text= orderApproval?.submittedby?.toString()
            binding.tvTotalAmounts.text="Total: $"+twoDecimal(orderApproval.orderdetails.ordertotal)

            var totalItems=0
            var Items=0
            orderApproval?.orderdetails?.orderdetaillines?.map {
                totalItems+=it.product.quantity
                Items+=1
            }
            binding.tvTotalItems.text= Items.toString()+" Total "+"("+totalItems+" Items)"
           val adapter= orderApproval?.orderdetails?.orderdetaillines?.let {
               SubmitApprovalsProductDetailsAdapter(
                   it
               )
           }
            binding.rvProductDetails.layoutManager = LinearLayoutManager(binding.root.context,
                RecyclerView.VERTICAL,false)
            binding.rvProductDetails.adapter = adapter

            binding.tvSubmittedBy.setOnClickListener {

                val orderDetails=Gson().toJson(orderApproval)
                val fragment = MyOrderDetailsFragment()
                var bundle= Bundle()
                bundle.putString("orderDetails",orderDetails)
                bundle.putString(Constants.KEY_TYPE,Constants.SUBMITAPPROVALS)
                fragment.arguments=bundle
                requiresActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("MyOrderFragment")
                    .commit()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding= SubmitApprovalsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DataViewHolder(binding)
    }


    override fun getItemCount(): Int {

            return Orders.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position],requiresActivity)

        if (sellectAll){
            holder.binding.cbSubmittedBy.isChecked=true
            approve.ApproveData(true,Orders.get(position).cartid)
        }else{
            holder.binding.cbSubmittedBy.isChecked=false
            approve.ApproveData(false,Orders.get(position).cartid)

        }

        if (checkBoxVisible==true){
            holder.binding.cbSubmittedBy.visible()
        }else{
            holder.binding.cbSubmittedBy.gone()
        }

        holder.binding.cbSubmittedBy.setOnClickListener{

            if (holder.binding.cbSubmittedBy.isChecked){

                approve.ApproveData(true,Orders.get(position).cartid)
            }else{
                approve.ApproveData(false,Orders.get(position).cartid)
            }
        }
    }

    fun addApprovals(Orders: List<Orderapproval>) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }

    }

    fun sellectAll(sellectAll:Boolean){

        this.sellectAll=sellectAll
    }

    fun checkBoxVisible(checkBoxVisible: Boolean) {
        this.checkBoxVisible=checkBoxVisible
    }

}
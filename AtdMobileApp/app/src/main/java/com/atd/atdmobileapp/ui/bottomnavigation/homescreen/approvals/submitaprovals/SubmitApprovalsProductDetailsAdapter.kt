package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.SubmitApprovalsProductUiBinding
import com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem


class SubmitApprovalsProductDetailsAdapter(private val Orders: List<OrderDetaillinesItem>) : RecyclerView.Adapter<SubmitApprovalsProductDetailsAdapter.DataViewHolder>() {


    class DataViewHolder(val binding: SubmitApprovalsProductUiBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(orderApproval: OrderDetaillinesItem) {
            binding.tvProductName.text=orderApproval?.product?.productname
            binding.tvSupplier.text= "Supplier: #"+orderApproval?.product?.mfgproductnumber
            binding.tvQuantity.text= "Qty: "+orderApproval?.product?.quantity.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding= SubmitApprovalsProductUiBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {

            return Orders.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position])

    }


}
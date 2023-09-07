package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.databinding.OrderDetailsItemBinding
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse
import com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem
import com.atd.atdmobileapp.utils.Common
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import retrofit2.Response


class ApprovalOrderDetailsAdapter(
    private val Orders: ArrayList<OrderDetaillinesItem>
) : RecyclerView.Adapter<ApprovalOrderDetailsAdapter.DataViewHolder>() {

   lateinit var datePlaced:String
   lateinit var comments:String
   lateinit var status:String

    class DataViewHolder(val binding: OrderDetailsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        
        
        fun bind(
            orderdetaillines: OrderDetaillinesItem,

            datePlaced: String,
            comments: String,

            status: String,

            ) {



            orderdetaillines?.product?.productname.let {

                if (!it.isNullOrEmpty()){
                    binding.tvProductTitle.text=it
                }else{
                    binding.tvProductTitle.gone()
                }

            }
             status?.let {
                 if (!it.isNullOrEmpty()){
                     if (it.equals(Constants.PENDING_APPROVAL,true)){
                         binding.tvProductStatus.text="Pending"
                     }else{
                         binding.tvProductStatus.text=it
                     }
                 }else{
                     binding.tvProductStatus.gone()
                 }
             }
            if (status.equals(Constants.PENDING_APPROVAL,true)){

                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

            }
            else if (status.equals(Constants.OPEN,true)){
                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

            }else if (status.equals(Constants.CLOSE,true)){
                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0);

            }else if (status.equals(Constants.CANCELLED,true)){

                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0);
            }

             orderdetaillines?.product?.cost?.toString().let {
                 if (!it.isNullOrEmpty()){
                     binding.tvProductCost.text="$"+it.replace("$","")
                 }else{
                     binding.tvProductCost.gone()
                 }
                 }

             datePlaced?.let {

            if (!it.isNullOrEmpty()) {
                binding.tvProductDate.text =Common.getMonthNameDayYear(it)
            }else{
                binding.tvProductDate.gone()
            }
            }

            orderdetaillines?.product?.quantity?.toString().let {
                if (!it.isNullOrEmpty()&&it!="0"){
                    binding.tvQtntyValue.text=it
                }else{
                    binding.tvQtntyValue.gone()
                    binding.tvQtnty.gone()
                }
            }

            if (orderdetaillines.sourcelines.size>0) {
                orderdetaillines?.sourcelines?.get(0)?.estimateddeliverydate?.toString().let {
                    if (!it.isNullOrEmpty()) {
                        binding.tvDeliveryDateValue.text = Common.getMonthNameDayYear(it)
                    } else {
                        binding.tvDeliveryDateValue.gone()
                        binding.tvDeliveryDate.gone()
                    }
                }
                orderdetaillines?.sourcelines?.get(0)?.selectedshipmethod?.toString().let {
                    if (!it.isNullOrEmpty()) {
                        binding.tvMethodValue.text = it
                    } else {
                        binding.tvMethodValue.gone()
                        binding.tvMethod.gone()
                    }
                }
                orderdetaillines?.sourcelines?.get(0)?.sourcedc?.let {
                    if (!it.isNullOrEmpty()) {
                        binding.tvDcValue.text = it
                    } else {
                        binding.tvDcValue.gone()
                        binding.tvDc.gone()
                    }
                }
            }

            orderdetaillines?.product?.atdproductnumber?.toString().let {
                if (!it.isNullOrEmpty()){
                    binding.tvSupplierValue.text=it
                }else{
                    binding.tvSupplierValue.gone()
                    binding.tvSupplier.gone()
                }
            }

            comments?.let {
                if (!it.isNullOrEmpty() && !it.trim().equals("null")){
                    binding.tvCustomerCommentsValue.text=it
                }else{
                    binding.tvCustomerCommentsValue.gone()
                    binding.tvCustomerComments.gone()
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        
       val binding = OrderDetailsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       
        return  DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        
            return Orders.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position],datePlaced,comments,status)
    }

    fun addOrders(
        Orders: List<OrderDetaillinesItem>,
        datePlaced:String,
        comments:String,
        status:String?
    ) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }
        this.datePlaced=datePlaced
        this.comments=comments

        if (status != null) {
            this.status=status
        }

    }

    

}
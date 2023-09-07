package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.databinding.OrderDetailsItemBinding
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse
import com.atd.atdmobileapp.models.orderdetails.Orderdetailline
import com.atd.atdmobileapp.utils.Common
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response


class MyOrdersDetailsAdapter(
    private val Orders: ArrayList<Orderdetailline>,
    val orderApi: OrderApi
) : RecyclerView.Adapter<MyOrdersDetailsAdapter.DataViewHolder>() {

   lateinit var datePlaced:String
   lateinit var comments:String
   lateinit var location:String
   lateinit var confirmationNumber:String
   /*@Inject
   lateinit var myOrderApi: OrderApi*/

    //comments:String
    class DataViewHolder(val binding: OrderDetailsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        
        
        fun bind(
            orderdetaillines: Orderdetailline,
            orderApi: OrderApi,
            datePlaced: String,
            comments: String,
            location: String,
            confirmationNumber: String,

            ) {



            if (orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.OPEN,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.ATAC,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Transmit,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.LoadingTruck,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Processing,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.ReadyForPickUp,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.AwaitReturn,true)
            ){
                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);
            }else if (orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.CLOSE,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Returned,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.PickedUp,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Delivered,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Shipped,true)
            ){
                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0)
            }else if (orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.CANCELLED,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Backordered,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.InvalidShipping,true)||
                orderdetaillines?.fulfillments?.get(0)?.status?.toString().equals(Constants.Rejected,true)
            ){
                binding.tvProductStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0)
            }

            orderdetaillines?.description?.let {

                if (!it.isNullOrEmpty()){
                    binding.tvProductTitle.text=it
                }else{
                    binding.tvProductTitle.gone()
                }

            }
             orderdetaillines?.fulfillments?.get(0)?.status?.let {
                 if (!it.isNullOrEmpty()){

                     if (it.equals(Constants.PENDING_APPROVAL,true)){
                         binding.tvProductStatus.text="Pending"
                     } else {
                         binding.tvProductStatus.text=it
                     }
                 }else{
                     binding.tvProductStatus.gone()
                 }
             }

             orderdetaillines?.cost?.toString().let {
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

            orderdetaillines?.fulfillments?.get(0)?.quantity?.toString().let {
                if (!it.isNullOrEmpty()&&it!="0"){
                    binding.tvQtntyValue.text=it
                }else{
                    binding.tvQtntyValue.gone()
                    binding.tvQtnty.gone()
                }
            }

            orderdetaillines?.fulfillments?.get(0)?.actualdeliverydate?.toString().let {
                if (!it.isNullOrEmpty()){
                    binding.tvDeliveryDateValue.text=it
                }else{
                    binding.tvDeliveryDateValue.gone()
                    binding.tvDeliveryDate.gone()
                }
            }
            orderdetaillines?.fulfillments?.get(0)?.shipmethod?.toString().let {
                if (!it.isNullOrEmpty()){
                    binding.tvMethodValue.text=it
                }else{
                    binding.tvMethodValue.gone()
                    binding.tvMethod.gone()
                }
            }
            orderdetaillines?.atdproductnumber?.toString().let {
                if (!it.isNullOrEmpty()){
                    binding.tvSupplierValue.text=it
                }else{
                    binding.tvSupplierValue.gone()
                    binding.tvSupplier.gone()
                }
            }

            orderdetaillines?.fulfillments?.get(0)?.sourcetypedc?.let {
                if (!it.isNullOrEmpty()){
                    binding.tvDcValue.text=it
                }else{
                    binding.tvDcValue.gone()
                    binding.tvDc.gone()
                }
            }
            comments?.let {
                if (!it.isNullOrEmpty()){
                    binding.tvCustomerCommentsValue.text=it
                }else{
                    binding.tvCustomerCommentsValue.gone()
                    binding.tvCustomerComments.gone()
                }
            }


            var returnItemAvailability= ItemReturnAvailableDetailsRequest()
            returnItemAvailability.locationnumber= location
            returnItemAvailability.confirmationnumber= confirmationNumber
            returnItemAvailability.atdproductnumber=orderdetaillines?.atdproductnumber?.toString()
            returnItemAvailability.ordernumber=orderdetaillines?.fulfillments?.get(0)?.ordernumber?.toString()



            CoroutineScope(Dispatchers.IO).launch {


                val request= async {
                    orderApi.getReturnDetails(returnItemAvailability)
                }
                val  result = request.await()

                launch(Dispatchers.Main) {
                ReturnItemAvailability(result)
            }
            }


        }

        private fun ReturnItemAvailability(result: Response<ItemReturnAvailableResponse>) {

            if (result.isSuccessful){


                println("return result : ${result.body()}")
                if (result.body()?.returnablequantity!=0){
                    binding.tvReturn.visible()
                }else{
                    binding.tvReturn.gone()

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
        holder.bind(Orders[position],orderApi,datePlaced,comments,location,confirmationNumber)
    }

    fun addOrders(Orders: List<Orderdetailline>,datePlaced:String,comments:String,location:String?,confirmationNumber:String?) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }
        this.datePlaced=datePlaced
        this.comments=comments
        if (location != null) {
            this.location=location
        }
        if (confirmationNumber != null) {
            this.confirmationNumber=confirmationNumber
        }

    }

    

}
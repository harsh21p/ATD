package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.models.myordersdata.Orderstatuse
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsFragment
import com.atd.atdmobileapp.utils.Common.getMonthNameDayYear
import com.atd.atdmobileapp.utils.Constants


class MyOrdersSearchAdapter(
    private val Orders: ArrayList<Orderstatuse>,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<MyOrdersSearchAdapter.DataViewHolder>() {

    private var showAll: Boolean=false


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  tvCnfNum:TextView = itemView.findViewById(R.id.tvCnfNum)
        var  orderStatus:TextView = itemView.findViewById(R.id.orderStatus)
        var  orderNum:TextView = itemView.findViewById(R.id.orderNum)
        var  datePlaced:TextView = itemView.findViewById(R.id.datePlaced)

        fun bind(orderstatuse: Orderstatuse, requireActivity: FragmentActivity) {

            tvCnfNum.setTextColor(
                ContextCompat.getColorStateList(requireActivity,
                    BottomNavigationScreenFragment.theameColor
                ))


            tvCnfNum.text=Constants.Conf+orderstatuse.confirmationnumber
            orderStatus.text=orderstatuse.status

            if (orderstatuse.status.equals(Constants.OPEN,true)){
                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0)

            }else if (orderstatuse.status.equals(Constants.CLOSE,true)){
                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0)

            }else if (orderstatuse.status.equals(Constants.CANCELLED,true)){

                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0)
            }
            orderNum.text=Constants.PO+orderstatuse.customerponumber
            datePlaced.text=getMonthNameDayYear(orderstatuse.dateplaced)
            tvCnfNum.setOnClickListener {
                val fragment = MyOrderDetailsFragment()
                var bundle= Bundle()
                bundle.putString("confirmationNumber",orderstatuse.confirmationnumber)
                bundle.putString("orderStatus",orderstatuse.status)
                bundle.putString(Constants.KEY_TYPE,Constants.MY_ORDERS_SEARCH)
                fragment.arguments=bundle
                requireActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("MyOrderSearchFragment")
                    .commit()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false))

    override fun getItemCount(): Int {

            return Orders.size

    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position],requireActivity)
    }

    fun addOrders(Orders: List<Orderstatuse>) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }

    }

    fun viewAll(showAll:Boolean){

        this.showAll=showAll
    }

}
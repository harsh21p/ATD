package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment


class MyQuotesAdapter(private val Orders: ArrayList<Retailquote>,val requireActivity: FragmentActivity) : RecyclerView.Adapter<MyQuotesAdapter.DataViewHolder>() {

    private var showAll: Boolean=false


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var  name:TextView = itemView.findViewById(R.id.name)
        var  orderStatus:TextView = itemView.findViewById(R.id.orderStatus)
        var  quoteBy:TextView = itemView.findViewById(R.id.quotedBy)
        var  quoteNum:TextView = itemView.findViewById(R.id.quoteNum)
        var  datePlaced:TextView = itemView.findViewById(R.id.datePlaced)

        fun bind(retailquote: Retailquote) {

            name.text=retailquote.consumerinfo.firstname+" "+retailquote.consumerinfo.lastname
            orderStatus.text=retailquote.quoteinfo.status

            if (retailquote.quoteinfo.status.trim().equals("Open",true)
                ||retailquote.quoteinfo.status.trim().equals("Contacted",true)){
                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.yellow, 0, 0, 0);

            }else if (retailquote.quoteinfo.status.trim().equals("Converted",true)){
                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.green, 0, 0, 0);

            }else if (retailquote.quoteinfo.status.trim().equals("Closed",true)){

                orderStatus.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red, 0, 0, 0);
            }
        quoteNum.text="Quote #: "+retailquote.retailquoteid
        datePlaced.text=retailquote.quoteinfo.createdon
            quoteBy.text="Quoted by: "+retailquote.companyinfo.contactname


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.myquotes_item, parent, false))

    override fun getItemCount(): Int {
        if (Orders.size>2){
            var size:Int=0
            if (showAll==true){
                size=Orders.size
            }else{
                size=3
            }
            return size
        }else{
            return Orders.size
        }
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(Orders[position])
        holder.name.setTextColor(
            ContextCompat.getColorStateList(requireActivity,
                BottomNavigationScreenFragment.theameColor
            ))
    }

    fun addQuotes(Orders: List<Retailquote>) {
        this.Orders.apply {
            clear()
            addAll(Orders)
        }

    }

    fun viewAll(showAll:Boolean){

        this.showAll=showAll
    }

}
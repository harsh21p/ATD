package com.atd.atdmobileapp.ui.bottomnavigation.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor

class AccountAdapter(
    title: Array<String>,
    icons: Array<Int>,
    listner: RecyclerViewClickListener,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<AccountAdapter.viewHolder>() {


    var title = title
    var icons = icons
    var mlistner = listner

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_icon_account : ImageView = itemView.findViewById(R.id.iv_icon_account)
        var tv_menu_item_name_account : TextView = itemView.findViewById(R.id.tv_menu_item_name_garage)
        var iv_right_arrow_account : ImageView = itemView.findViewById(R.id.imageView13_garage)
        var imageView13_garage : ImageView = itemView.findViewById(R.id.imageView13_garage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder =
        viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout_account_rc,parent,false))

    override fun getItemCount(): Int {
        return title.size
    }



    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.tv_menu_item_name_account.text = title[position]
        holder.iv_icon_account.setImageResource(icons[position])
        holder.iv_icon_account.imageTintList= ContextCompat.getColorStateList(requireActivity, theameColor)
        holder.imageView13_garage.imageTintList= ContextCompat.getColorStateList(requireActivity, theameColor)

        if (title[position] == "Log Out"){
            holder.iv_right_arrow_account.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            println("Clicked -> "+title[position]+" in account Screen")
            mlistner.onItemClick(holder.itemView,title[position])
        }


    }
}
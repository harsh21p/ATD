package com.atd.atdmobileapp.ui.bottomnavigation.mygarage

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

class MyGarageAdapter(
    title: Array<String>,
    descriptions: Array<String>,
    icons: Array<Int>,
    noOfApprovals: Int,
    listner: RecyclerViewClickListner,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<MyGarageAdapter.ViewHolder>() {

        var title_list = title
        var descriptions_list = descriptions
        var icon_list = icons
        var noOfApprovals = noOfApprovals
        var listner = listner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout_my_garage_rc,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to view holder here
        //Setting the title and list
        holder.tv_menu_item_name_garage.text = title_list[position]
        holder.textView5_garage.text = descriptions_list[position]
        holder.imageView12_garage.setImageResource(icon_list[position])
        holder.imageView12_garage.imageTintList= ContextCompat.getColorStateList(requireActivity,
            BottomNavigationScreenFragment.theameColor
        )

        holder.imageView13_garage.imageTintList= ContextCompat.getColorStateList(requireActivity,
            BottomNavigationScreenFragment.theameColor
        )
        if (title_list[position] == "Approvals"){
            holder.ellipse_red_garage.visibility = View.VISIBLE
            holder.ellipse_red_garage.text = noOfApprovals.toString()
        }

        //setting up click listeners for row
        holder.itemView.setOnClickListener {
            println(
                "clicked -> " + title_list[position]
            )
            //sending callback to fragment MyGarage
            listner.onItemClick(holder.itemView, title_list[position])
        }

    }

    override fun getItemCount(): Int {
        return title_list.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imageView12_garage : ImageView = itemView.findViewById(R.id.imageView12_garage)
        var ellipse_red_garage : TextView = itemView.findViewById(R.id.ellipse_red_garage)
        var imageView13_garage : ImageView = itemView.findViewById(R.id.imageView13_garage)
        var tv_menu_item_name_garage : TextView = itemView.findViewById(R.id.tv_menu_item_name_garage)
        var textView5_garage : TextView = itemView.findViewById(R.id.textView5_garage)


    }

}
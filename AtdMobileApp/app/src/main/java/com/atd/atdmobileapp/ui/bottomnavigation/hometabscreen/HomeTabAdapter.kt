package com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.ApprovalsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.MyQuotsFragment

class HomeTabAdapter(var context : Context, var fm: FragmentManager, var totalTabs :Int ) :
    FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
       return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyOrdersFragment()
            }
            1 -> {
                MyQuotsFragment()
            }
            2 -> {
                ApprovalsFragment()
            }
            else -> {
                HomeTabFragment()

            }
        }
    }
}
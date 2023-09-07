package com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.databinding.RecentItemBinding
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor

class KeywordRecentSearchesAdapter(
    private val recentSearches: ArrayList<PreviousKeywordSearchEntity>,
    val clickItem: OnClickItem,
    val requireActivity: FragmentActivity
) : RecyclerView.Adapter<KeywordRecentSearchesAdapter.DataViewHolder>() {

    private lateinit var binding:RecentItemBinding
    var mClickListener: OnClickItem? = null
    init {

        mClickListener= clickItem
    }

    private var showAll: Boolean=false

    class DataViewHolder(binding: RecentItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        binding = RecentItemBinding.inflate(inflater, parent, false)

        return DataViewHolder(binding)
    }




    override fun getItemCount(): Int {

            return recentSearches.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {


        binding.tvSearchItem.compoundDrawableTintList= ContextCompat.getColorStateList(requireActivity,
            theameColor
        )
        binding.tvSearchItem.text=recentSearches.get(position).keyword

        binding.tvSearchItem.setOnClickListener {

            mClickListener!!.ClickItem(recentSearches.get(position).keyword, true)
        }
    }

    fun addRecentSearches(Searches: List<PreviousKeywordSearchEntity>) {
        this.recentSearches.apply {
            clear()
            addAll(Searches)
        }

    }


}
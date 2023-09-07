package com.atd.atdmobileapp.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.ProductTopListItemBinding
import com.atd.atdmobileapp.models.productsearch.Title
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import kotlin.reflect.KFunction3

class ProductAdapter(
    private val titleClickListener: KFunction3<Title, Int, Int, Unit>
) : ListAdapter<Title, ProductAdapter.ProductViewHolder>(DiffUtil()) {

    var positionOfTitleSeleted: Int = -1

    inner class ProductViewHolder(private val binding: ProductTopListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(title: Title,position: Int) {


            if (title.isSelected){
                if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue) {
                    binding.ivBackGround.setImageResource(R.drawable.product_blue_background)
                }else{
                    binding.ivBackGround.setImageResource(R.drawable.product_red_background)
                }
                binding.ivIcon.setImageResource(title.iconSelected)
                positionOfTitleSeleted = position
            }else{
                if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue) {
                    binding.ivBackGround.setImageResource(R.drawable.product_grey_back_ground)
                }else{
                    binding.ivBackGround.setImageResource(R.drawable.product_light_red_background)

                }
                binding.ivBackGround.setImageResource(R.drawable.product_grey_back_ground)
                binding.ivIcon.setImageResource(title.icon)
            }
            binding.tvName.text = title.name

            val viewsToClick = listOf<View>(binding.ivIcon, binding.tvName)
//            binding.ivIcon.setOnClickListener{
//            viewsToClick.forEach { view ->
//               view.setOnClickListener{
//                   binding.ivBackGround.setImageResource(R.drawable.product_blue_background)
//                   binding.ivIcon.setImageResource(title.iconSelected)
//                   title.isSelected = true
//                   titleClickListener(title,position,positionOfTitleSeleted)
//                   positionOfTitleSeleted = position
//            }
//
//            }
            binding.root.setOnClickListener {

                if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue) {
                    binding.ivBackGround.setImageResource(R.drawable.product_blue_background)
                }else{
                    binding.ivBackGround.setImageResource(R.drawable.product_red_background)
                }
                binding.ivIcon.setImageResource(title.iconSelected)
                title.isSelected = true
                titleClickListener(title,position,positionOfTitleSeleted)
                positionOfTitleSeleted = position
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductTopListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val title = getItem(position)
        holder.bind(title,position)
    }

    class DiffUtil : ItemCallback<Title>() {
        override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem.isSelected == newItem.isSelected
        }

        override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem == newItem
        }

    }
}

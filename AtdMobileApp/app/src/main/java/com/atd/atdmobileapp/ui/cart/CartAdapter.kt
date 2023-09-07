package com.atd.atdmobileapp.ui.cart


import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CartItemBinding
import com.atd.atdmobileapp.models.CartItem
import com.atd.atdmobileapp.utils.*
import com.bumptech.glide.Glide

class CartAdapter(
    private val onDeleteCart: (String) -> Unit,
    private val onQuantityAndEditClick: (CartItem) -> Unit,
    private val prefManager: SharedPrefManager,
) : ListAdapter<CartItem, CartAdapter.CartHolder>(ComparatorDiffUtil()) {

    var CostVisibilityCheck:Boolean = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartHolder(binding)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val location = getItem(position)
        location?.let {
            holder.bind(it, position)
        }
    }

    fun checkProductCost(CostVisibilityCheck: Boolean) {
        this.CostVisibilityCheck=CostVisibilityCheck
    }

    inner class CartHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cart: CartItem, position: Int) {

            if (CostVisibilityCheck==true){
                binding.tvCost.visible()
                binding.tvCostValue.visible()
            }else{
                binding.tvCost.gone()
                binding.tvCostValue.gone()
            }
            val supplier = cart.supplier
            binding.tvBrand.text = cart.brand
            binding.tvStyle.text = cart.style
            binding.tvDescription.text = cart.description
            binding.tvCostValue.text = cart.cost
            binding.tvFret.text = cart.fet
            binding.tvItemSubTotalValue.text = cart.itemSubtotal
            if (cart.quantityBackOrder == 0) {
                binding.tvQuantityValue.text = cart.quantity.toString()
            } else if (cart.quantity == cart.quantityBackOrder) {
                binding.tvQuantityValue.text =
                    cart.quantityBackOrder.toString() + cart.quantityBackOrderString
            } else {
                binding.tvQuantityValue.text =
                    cart.quantity.toString() + " , " + cart.quantityBackOrder + cart.quantityBackOrderString
            }
            if (cart.discontinued) binding.tvDiscontinued.visible() else binding.tvDiscontinued.inVisible()
            binding.ivDelete.setOnClickListener {
                onDeleteCart(supplier)
            }
            if (!cart.productImage.isNullOrEmpty() && cart.productImage !="null") {
                Glide.with(binding.ivProduct)
                    .load(cart.productImage)
                    .into(binding.ivProduct)
            } else {
                binding.ivProduct.setImageResource(R.drawable.image_not_available)
            }
            binding.clEditQuantity.setOnClickListener {
                onQuantityAndEditClick(cart)
            }

            when (prefManager.getProfileSelected()) {
                Constants.TIRE_PROS -> {
                    val color = ContextCompat.getColor(binding.root.context, R.color.red)
                    binding.tvBrand.setTextColor(color)
                    binding.tvStyle.setTextColor(color)
                    binding.tvEditQuantityAndDelivery.setTextColor(color)
                    binding.ivDelete.imageTintList = ColorStateList.valueOf(color)
                    binding.ivRightArrow.imageTintList = ColorStateList.valueOf(color)
                }
                Constants.ATD_ONLINE -> {
                    val color = ContextCompat.getColor(binding.root.context, R.color.atd_blue)
                    binding.tvBrand.setTextColor(color)
                    binding.tvStyle.setTextColor(color)
                    binding.tvEditQuantityAndDelivery.setTextColor(color)
                    binding.ivDelete.imageTintList = ColorStateList.valueOf(color)
                    binding.ivRightArrow.imageTintList = ColorStateList.valueOf(color)
                }
            }

        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem == newItem
        }
    }
}
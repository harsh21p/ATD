package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentOptionBinding
import com.atd.atdmobileapp.models.preferences.Item
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.gone

class OptionFragment(
    private val type: String,
    private val storedUserPreferences: PreferencesConfiguration,
    private val sendToFrag: (String, String) -> Unit,
    private val sendQtyToFrag: (List<Item>) -> Unit
) : DialogFragment() {

    private var _binding: FragmentOptionBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: OptionAdapter
    private lateinit var qtyAdapter: QuantityAdapter
    private lateinit var itemListToSend: List<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOptionBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    companion object {
        const val TAG = "optionFrag"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }

        binding.ivCloseTireType.imageTintList=(ContextCompat.getColorStateList(requireActivity(),BottomNavigationScreenFragment.theameColor))
        binding.tvSave.setTextColor(ContextCompat.getColorStateList(requireActivity(),BottomNavigationScreenFragment.theameColor))
        binding.tvSave.setOnClickListener {
            sendQtyToFrag(itemListToSend)
            dialog?.dismiss()
        }

        when(type){

            Constants.PREFERENCES_FITMENT ->{
                binding.tvPricing.text = getString(R.string.fitment_results_default)
                binding.tvSave.gone()
                adapter.previousSelection = storedUserPreferences.fitmentResults.toString()
                adapter.submitList(listOf("Tires", "Wheels"))
            }

            Constants.PREFERENCES_MY_BRANDS ->{
                binding.tvPricing.text = getString(R.string.my_brands_default)
                binding.tvSave.gone()
                adapter.previousSelection = storedUserPreferences.myBrands.toString()
                adapter.submitList(listOf("Show All Brands", "Show Preferred Brands Only"))
            }

            Constants.PREFERENCES_AVAILABILITY_FILTER ->{
                binding.tvPricing.text = getString(R.string.availability_filter_default)
                binding.tvSave.gone()
                adapter.previousSelection = storedUserPreferences.availabilityFilter.toString()
                adapter.submitList(listOf("All", "Local", "Local+", "National"))
            }

            Constants.PREFERENCES_SORT_ORDER ->{
                binding.tvPricing.text = getString(R.string.sort_order_default)
                binding.tvSave.gone()
                adapter.previousSelection = storedUserPreferences.sortOrder.toString()
                val list =  requireActivity().resources.getStringArray(R.array.sortOptions);
                val optionList = ArrayList<String>(list.asList())
                adapter.submitList(optionList)
            }

            Constants.PREFERENCES_ADD_TO_CART ->{
                binding.tvPricing.text = getString(R.string.add_to_cart_retail_quote)
                binding.optionRV.adapter = qtyAdapter
                storedUserPreferences.productItems?.items?.let { qtyAdapter.setData(it) }
            }

        }
    }

    private fun setupRecyclerView() {
        binding.optionRV.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = OptionAdapter(::onClick,requireActivity())
        qtyAdapter = QuantityAdapter(::onClickQty,requireActivity())
        binding.optionRV.adapter = adapter
    }

    private fun onClick(item: String){
        //got selected Item here send back to frag
        sendToFrag(item, type)
        dialog?.dismiss()
    }

    private fun onClickQty(item: List<Item>){
        //got update quantities as
        itemListToSend = item

    }

}
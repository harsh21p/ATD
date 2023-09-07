package com.atd.atdmobileapp.ui.keywordsearch.filterandsort

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSortBinding
import com.atd.atdmobileapp.utils.Constants

class SortFragment(private val currentSelectedSortOption: String, private val containsPreferredBrand: Boolean) : DialogFragment() {

    private var _binding: FragmentSortBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: SortAdapter
    private var selectedSortOption: String = currentSelectedSortOption

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSortBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    companion object {
       const val TAG = "sortFragment"
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


        val list =  requireActivity().resources.getStringArray(R.array.sortOptions);
        val optionList = ArrayList<String>(list.asList())
        if (!containsPreferredBrand){
            optionList.remove("Preferred Brands")
            optionList.remove("Preferred Brands/Availability/Cost Low to High")
            optionList.remove("Preferred Brands/Availability/Cost High to Low")
        }
        adapter.submitList(optionList)

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }

        binding.applySort.setOnClickListener {
            setResult()
        }
    }


    private fun setupRecyclerView() {
        binding.rvSort.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = SortAdapter(selectedSortOption, ::onClick)
        binding.rvSort.adapter = adapter
    }

    private fun onClick(option: String){
        adapter.previousSelectedOption = option
        selectedSortOption = option
        adapter.notifyDataSetChanged()
    }

    private fun setResult(){
        val result = Bundle().apply {
            putString(Constants.SELECTED_SORT_OPTION, selectedSortOption)
        }
        setFragmentResult(Constants.SELECTED_SORT_OPTION,result)
        dialog?.dismiss()
    }
}
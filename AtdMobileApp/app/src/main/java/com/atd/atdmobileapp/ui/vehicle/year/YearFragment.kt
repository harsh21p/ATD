package com.atd.atdmobileapp.ui.vehicle.year

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
import com.atd.atdmobileapp.databinding.FragmentYearBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class YearFragment(private val yearsList: List<String>) : DialogFragment() {

    private var _binding: FragmentYearBinding?= null
    private val binding get()= _binding!!
    private lateinit var adapter: YearsAdapter
    private lateinit var selectedYear: String
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        _binding = FragmentYearBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        setupRecyclerView()
        adapter.submitList(yearsList)
        selectedYear = ""
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }

    companion object {
        const val TAG = "yearFragment"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun setupRecyclerView() {
        binding.rvYears.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = YearsAdapter(::onYearClicked, sharedPrefManager.getSelectedYear())
        binding.rvYears.adapter = adapter
    }

    private fun onYearClicked(year :String){
        selectedYear = year
        sharedPrefManager.saveSelectedYear(year)
        setResult()
    }

    private fun setResult(){
        val result = Bundle().apply {
            putString(Constants.SELECTED_YEAR, selectedYear)
        }
        setFragmentResult(Constants.YEAR_RESULT,result)
        dialog?.dismiss()
    }


}
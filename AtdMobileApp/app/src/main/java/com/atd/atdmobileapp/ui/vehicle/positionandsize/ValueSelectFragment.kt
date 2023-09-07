package com.atd.atdmobileapp.ui.vehicle.positionandsize

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
import com.atd.atdmobileapp.databinding.FragmentValueSelectBinding
import com.atd.atdmobileapp.utils.Constants

class ValueSelectFragment(
    private var valueListSuspensionFitment: MutableList<String>,
    private val currentSelectedValue: String
) : DialogFragment() {

    private var _binding: FragmentValueSelectBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: ValueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentValueSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "valueFrag"
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

        binding.ivCloseValue.setOnClickListener {
            dialog?.dismiss()
        }
        setupRecyclerView()
        if (valueListSuspensionFitment != null) {
            valueListSuspensionFitment = valueListSuspensionFitment.map { it.toFloat() }
                .sorted()
                .map { it.toString() } as MutableList<String>
        }
        adapter.submitList(valueListSuspensionFitment)
    }

    private fun setupRecyclerView() {
        binding.rvValue.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = ValueAdapter(::onValueClicked, currentSelectedValue)
        binding.rvValue.adapter = adapter
    }

    private fun onValueClicked(value : String){
        println("Got item clicked as ->$value")
        val result = Bundle().apply {
            putString(Constants.VALUE_RESULT, value)
        }
        setFragmentResult(Constants.VALUE_RESULT,result)
        dialog?.dismiss()
    }
}
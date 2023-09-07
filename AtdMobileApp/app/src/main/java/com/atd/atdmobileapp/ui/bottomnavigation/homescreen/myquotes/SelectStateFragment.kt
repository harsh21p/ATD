package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSelectStateBinding
import com.atd.atdmobileapp.models.State

class SelectStateFragment(
    private val stateList: MutableList<State>,
    private val onClick: (State) -> Unit,
    private val selectedSate: String
) : DialogFragment() {

    private var _binding: FragmentSelectStateBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: StateAdapterQuotes

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSelectStateBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun setupRecyclerView() {
        binding.rvYears.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = StateAdapterQuotes(::onStateClicked, selectedSate)
        binding.rvYears.adapter = adapter
        adapter.submitList(stateList)
    }

    companion object {
        const val TAG = "selectStateTAG"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun onStateClicked(item: State){
        onClick(item)
        dialog?.dismiss()
    }
}
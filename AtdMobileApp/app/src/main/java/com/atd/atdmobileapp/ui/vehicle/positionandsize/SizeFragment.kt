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
import com.atd.atdmobileapp.databinding.FragmentSizeBinding
import com.atd.atdmobileapp.models.vehicle.TrimOption
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SizeFragment(private val oeDia: String, private val selectedPos: String, private val selectedSize: String) : DialogFragment() {

    private var _binding: FragmentSizeBinding?= null
    private val binding get() = _binding!!
    private lateinit var adapter: SizeAdapter
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentSizeBinding.inflate(inflater, container, false)
        return binding.root

    }

    companion object {
        const val TAG = "sizeFrag"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }

        setupRecyclerView()
        //logic to retrieve list of diameter to display
        val tempTrimOption : TrimOption= Gson().fromJson(sharedPrefManager.getSelectedOESizeObj(), TrimOption::class.java )
        var wheelDiameters = when (selectedPos) {
            "Front" -> tempTrimOption.position?.mapNotNull { it.front?.wheeldiameteroptions?.wheeldiameter }
                ?.flatten()
            "Rear" -> tempTrimOption.position?.mapNotNull { it.rear?.wheeldiameteroptions?.wheeldiameter }
                ?.flatten()
            "both" -> tempTrimOption.position?.mapNotNull { it.both?.wheeldiameteroptions?.wheeldiameter }
                ?.flatten()
            else -> emptyList()
        }
        if (wheelDiameters != null) {
            wheelDiameters = wheelDiameters.map { it.toInt() }
                .sorted()
                .map { it.toString() }
        }
        wheelDiameters = listOf("All Sizes") + (wheelDiameters ?: emptyList())

        adapter.submitList(wheelDiameters)

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun setupRecyclerView() {
        binding.rvSize.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = SizeAdapter(::onSizeClicked, oeDia, selectedSize)
        binding.rvSize.adapter = adapter
    }

    private fun onSizeClicked(toDisplaysize : String, toWrite : String){
        println("Got item clicked as ->$toDisplaysize")
        val result = Bundle().apply {
            putString(Constants.SELECTED_SIZE, toDisplaysize)
            putString(Constants.SELECTED_SIZE_TO_USE, toWrite)
        }
        setFragmentResult(Constants.SIZE_RESULT,result)
        dialog?.dismiss()
    }
}
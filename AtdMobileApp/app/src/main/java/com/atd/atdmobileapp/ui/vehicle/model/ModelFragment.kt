package com.atd.atdmobileapp.ui.vehicle.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentModelBinding
import com.atd.atdmobileapp.models.vehicle.VehicleRequest
import com.atd.atdmobileapp.ui.vehicle.VehicleViewModel
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.atd.atdmobileapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ModelFragment(private val modelList: List<String>) : DialogFragment() {

    private var _binding: FragmentModelBinding?= null
    private val binding get()= _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var selectedModel = ""
    private lateinit var adapter: ModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentModelBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        setupRecyclerView()
        return binding.root
    }



    companion object {
       const val TAG = "modelFragment"
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
        adapter.submitList(modelList)
        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }


    private fun onModelClicked(model :String){
        selectedModel = model
        sharedPrefManager.saveSelectedModel(model)
        setResult()
    }

    private fun setResult() {
        val result = Bundle().apply {
            putString(Constants.SELECTED_MODEL, selectedModel)
        }
        setFragmentResult(Constants.MODEL_RESULT,result)
        dialog?.dismiss()
    }

    private fun setupRecyclerView() {
        binding.rvModel.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = ModelAdapter(::onModelClicked, sharedPrefManager.getSelectedModel())
        binding.rvModel.adapter = adapter
    }
}
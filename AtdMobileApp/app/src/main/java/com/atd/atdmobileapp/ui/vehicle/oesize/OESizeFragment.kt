package com.atd.atdmobileapp.ui.vehicle.oesize

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
import com.atd.atdmobileapp.databinding.FragmentOESizeBinding
import com.atd.atdmobileapp.models.vehicle.TrimOption
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OESizeFragment(private val trimoptionList: List<TrimOption>) : DialogFragment() {

    private var _binding: FragmentOESizeBinding?= null
    private val binding get() = _binding!!
    private lateinit var OESize: String
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var adapter: OESizeAdapter
    private var selectedObject: TrimOption?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentOESizeBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    companion object {
      const val TAG = "oesizeFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val trimOptionsList = mutableListOf<String>()
        trimoptionList.forEach {
            trimOption ->
            trimOption.trimoption?.let {

                trimOptionsList.add(trimOption.trimoption)
            }
        }
        adapter.submitList(trimOptionsList)

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun onOESizeClicked(size :String){
        OESize = size
        selectedObject = trimoptionList.find { it.trimoption == OESize }
        println("Here is ->${Gson().toJson(selectedObject)}")
        sharedPrefManager.saveSelectedOESize(OESize)
        sharedPrefManager.saveSelectedOESizeObj(Gson().toJson(selectedObject))
        setResult()

    }

    private fun setupRecyclerView() {
        binding.rvOESize.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = OESizeAdapter(::onOESizeClicked, sharedPrefManager.getSelectedOESize())
        binding.rvOESize.adapter = adapter
    }

    private fun setResult(){
        val result = Bundle().apply {
            putString(Constants.SELECTED_OESIZE, OESize)
        }
        setFragmentResult(Constants.OESIZE_RESULT,result)
        dialog?.dismiss()
    }
}
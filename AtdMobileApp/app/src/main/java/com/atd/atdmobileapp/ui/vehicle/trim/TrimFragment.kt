package com.atd.atdmobileapp.ui.vehicle.trim

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
import com.atd.atdmobileapp.databinding.FragmentTrimBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TrimFragment(private val trimList: List<String>) : DialogFragment() {

    private var _binding: FragmentTrimBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private var selectedTrim = ""
    private lateinit var adapter: TrimAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        _binding = FragmentTrimBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    companion object {
       const val TAG = "trimFragment"
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

        adapter.submitList(trimList)

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }


    private fun setupRecyclerView(){
        binding.rvTrim.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = TrimAdapter(::onTrimSelected, sharedPrefManager.getSelectedTrim())
        binding.rvTrim.adapter = adapter
    }

    private fun onTrimSelected(trim: String){
        selectedTrim = trim
        sharedPrefManager.saveSelectedTrim(selectedTrim)
        setResult()
    }

    private fun setResult() {
        val result = Bundle().apply {
            putString(Constants.SELECTED_TRIM, selectedTrim)
        }
        setFragmentResult(Constants.TRIM_RESULT,result)
        dialog?.dismiss()
    }
}
package com.atd.atdmobileapp.ui.vehicle.make

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
import com.atd.atdmobileapp.databinding.FragmentMakeBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MakeFragment(private  val makeList: List<String>) : DialogFragment() {

    private var _binding: FragmentMakeBinding?= null
    private val binding get()= _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var adapter :MakeAdapter
    private var selectedMake = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentMakeBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        setRecyclerView()
        return binding.root
    }

    companion object {
        const val TAG = "MakeFragment"
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
        println("Passing Value as -> ${sharedPrefManager.getSelectedYear()}")
       adapter.submitList(makeList)

        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun setRecyclerView(){
        binding.rvMake.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        adapter = MakeAdapter(::onMakeClicked, sharedPrefManager.getSelectedMake())
        binding.rvMake.adapter = adapter

    }


    private fun onMakeClicked(make :String){
        selectedMake = make
        sharedPrefManager.saveSelectedMake(selectedMake)
        setResult()
    }

    private fun setResult() {
        val result = Bundle().apply {
            putString(Constants.SELECTED_MAKE, selectedMake)
        }
        setFragmentResult(Constants.MAKE_RESULT,result)
        dialog?.dismiss()
    }

}
package com.atd.atdmobileapp.ui.mylists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentFrequencyDialogBinding
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FrequencyDialog(val selectedItem: String) : DialogFragment() {


    var _binding : FragmentFrequencyDialogBinding?=null
    val binding get()= _binding!!
    var mainViewModel : MainViewModel?=null
    var color:Int?=null
    private var profileSelected:String?=""
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NORMAL,
            android.R.style.Theme_Light_NoTitleBar_Fullscreen);
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFrequencyDialogBinding.inflate(inflater,container,false)
        profileSelected= sharedPrefManager?.getProfileSelected()?.toString()
        if (profileSelected.equals("tirepros",true)) {
             color=R.color.red
        }else if (profileSelected.equals("atdonline",true)) {
            color=R.color.atd_blue
        }

        color?.let {
            binding.closeDialog.imageTintList= ContextCompat.getColorStateList(requireActivity(),it)
        }
        mainViewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.rvList.layoutManager = LinearLayoutManager(
            activity,
            RecyclerView.VERTICAL, false
        )

        var wheels =  requireActivity().getResources().getStringArray(R.array.frequencyList);
        var wheelTypes = ArrayList<String>(wheels.asList())
        val adapter = FrequencyAdapter(wheelTypes,::selectedItem,selectedItem,color,requireActivity())
        binding.rvList.adapter = adapter
        adapter.notifyDataSetChanged()
        return binding.root
    }

    fun selectedItem(item :String){

        mainViewModel?.setFrequencyState(item)

        dialog?.dismiss()
    }



}
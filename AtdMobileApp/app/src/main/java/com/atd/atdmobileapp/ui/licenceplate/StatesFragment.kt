package com.atd.atdmobileapp.ui.licenceplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.databinding.FragmentStatesBinding
import org.json.JSONArray
import javax.inject.Inject


class StatesFragment(val jsonArray: JSONArray) : DialogFragment() {

    private var _binding: FragmentStatesBinding?= null
    private val binding get() = _binding!!
    lateinit var mainViewModel: MainViewModel

    var adapter : StatesAdapter?=null
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

        _binding= FragmentStatesBinding.inflate(inflater,container,false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        // Inflate the layout for this fragment

        binding.rvList.layoutManager = LinearLayoutManager(
            activity,
            RecyclerView.VERTICAL, false
        )
         adapter = StatesAdapter(::UpdateData,jsonArray)
        binding.rvList.adapter = adapter
       // adapter.notifyDataSetChanged()
        binding.closeDialog.setOnClickListener {

            dialog?.dismiss()
        }
        return binding.root
    }

    fun UpdateData(value:String){

        println("Selected State $value")
        dialog?.dismiss()
        mainViewModel.setLicencePlateState(value)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel?.licencePlateState?.observe(viewLifecycleOwner, Observer {

            println("livedata State $it")
            it?.let {
                adapter?.SelectedItem(it)
                adapter?.notifyDataSetChanged()
            }
        })
    }

}
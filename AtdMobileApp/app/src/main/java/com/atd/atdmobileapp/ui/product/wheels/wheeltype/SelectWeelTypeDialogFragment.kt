package com.atd.atdmobileapp.ui.product.wheels.wheeltype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.SelectOptionListBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem
import com.atd.atdmobileapp.ui.product.wheels.lugsboltscircles.LugsBoltsCircleAdapter
import com.atd.atdmobileapp.ui.product.wheels.offsetdescription.OffsetDescriptionAdapter
import com.atd.atdmobileapp.ui.product.wheels.seasonaldescription.SeasonalDesignationAdapter
import com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible

/**
 * A simple [Fragment] subclass.
 * Use the [DiameterDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectWeelTypeDialogFragment(
    var updateViewModel: UpdateViewModel,
    val typeOfAdapter: String,
    val selectedList: ArrayList<String>
) : DialogFragment(),OnClickItem{

    private lateinit var adapter: WheelsWidthAdapter
    private lateinit var diameterAdapter: DiameterAdapter
    var _binding : SelectOptionListBinding?=null
    val binding get() = _binding!!



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
        // Inflate the layout for this fragment

        _binding= SelectOptionListBinding.inflate(inflater, container, false)
        val view: View = binding.root
       // updateViewModel = ViewModelProvider(this).get(UpdateViewModel::class.java)



        binding.rvList.layoutManager = LinearLayoutManager(
            activity,
            RecyclerView.VERTICAL, false
        )
        if (typeOfAdapter.equals("WheelType",true)) {
            binding.tvClearAll.gone()
            binding.bottomBorder.gone()
            binding.tvApply.gone()
            binding.title.text="Wheel Types"
            var wheels =  requireActivity().getResources().getStringArray(R.array.wheelType);
            var wheelTypes = ArrayList<String>(wheels.asList())
            val adapter = WheelsTypeAdapter(wheelTypes, updateViewModel!!, dialog!!,selectedList,requireActivity())
            binding.rvList.adapter = adapter
            adapter.notifyDataSetChanged()
        } else if (typeOfAdapter.equals("Diameter",true)){

            var diameterArray =  requireActivity().getResources().getStringArray(R.array.diameter);
            var diameterList = ArrayList<String>(diameterArray.asList())

            binding.tvClearAll.visible()
            binding.bottomBorder.visible()
            binding.tvApply.visible()
            binding.title.text="Diameter"
            diameterAdapter = DiameterAdapter(diameterList, updateViewModel!!, dialog!!, this , selectedList,requireActivity())
            binding.rvList.adapter = diameterAdapter

            binding.tvClearAll.setOnClickListener {

                diameterAdapter.clearAll()
                diameterAdapter.notifyDataSetChanged()
            }

            binding.tvApply.setOnClickListener {


                diameterAdapter.addAll()
                diameterAdapter.notifyDataSetChanged()
            }

        }else if (typeOfAdapter.equals("Width",true)){

            var widthArray =  requireActivity().getResources().getStringArray(R.array.wheel_width);
            var widthList = ArrayList<String>(widthArray.asList())

            binding.tvClearAll.visible()
            binding.bottomBorder.visible()
            binding.tvApply.visible()
            binding.title.text="Width"
            adapter = WheelsWidthAdapter(widthList, updateViewModel!!, dialog!!, this , selectedList,requireActivity())
            binding.rvList.adapter = adapter

            binding.tvClearAll.setOnClickListener {

                 adapter.clearAll()
                adapter.notifyDataSetChanged()
                }

                binding.tvApply.setOnClickListener {
                adapter.addAll()
                adapter.notifyDataSetChanged()
                }


        }else if (typeOfAdapter.equals("LugsBoltsCircle",true)) {
            binding.tvClearAll.gone()
            binding.bottomBorder.gone()
            binding.tvApply.gone()
            binding.title.text="Lugs/Bolts Circle"
            var lugsBolts =  requireActivity().getResources().getStringArray(R.array.lugsbolts);
            var lugsBoltsList = ArrayList<String>(lugsBolts.asList())
            val adapter = LugsBoltsCircleAdapter(lugsBoltsList, updateViewModel!!, dialog!!,selectedList,requireActivity())
            binding.rvList.adapter = adapter
            adapter.notifyDataSetChanged()
        } else if (typeOfAdapter.equals("Finish",true)) {
            var finishArray =  requireActivity().getResources().getStringArray(R.array.finish);
            var finishList = ArrayList<String>(finishArray.asList())

            binding.tvClearAll.visible()
            binding.bottomBorder.visible()
            binding.tvApply.visible()
            binding.title.text="Finish"
           val adapter = FinishAdapter(finishList, updateViewModel!!, dialog!!, this , selectedList,requireActivity())
            binding.rvList.adapter = adapter

            binding.tvClearAll.setOnClickListener {

                adapter.clearAll()
                adapter.notifyDataSetChanged()
            }

            binding.tvApply.setOnClickListener {
                adapter.addAll()
                adapter.notifyDataSetChanged()
            }
        }
        else if (typeOfAdapter.equals("offsetDescription",true)) {
            var finishArray =  requireActivity().getResources().getStringArray(R.array.offsetDescription);
            var finishList = ArrayList<String>(finishArray.asList())

            binding.tvClearAll.gone()
            binding.bottomBorder.gone()
            binding.tvApply.gone()
            binding.title.text="Offset Description"
            val adapter = OffsetDescriptionAdapter(finishList, updateViewModel!!, dialog!! , selectedList,requireActivity())
            binding.rvList.adapter = adapter

        }else if (typeOfAdapter.equals("seasonalDesignation",true)) {
            var finishArray =  requireActivity().getResources().getStringArray(R.array.seasonalDesignation);
            var finishList = ArrayList<String>(finishArray.asList())

            binding.tvClearAll.gone()
            binding.bottomBorder.gone()
            binding.tvApply.gone()
            binding.title.text="Offset Description"
            val adapter = SeasonalDesignationAdapter(finishList, updateViewModel!!, dialog!! , selectedList,requireActivity())
            binding.rvList.adapter = adapter

        }



        binding.closeDialog.setOnClickListener {

            dialog?.dismiss()
        }


        setupTheme()

        return view
    }

    private fun setupTheme() {

       // binding.tvApply.backgroundTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.tvClearAll.setTextColor(ContextCompat.getColorStateList(requireActivity(), theameColor))
        binding.closeDialog.imageTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun ClickItem(diameterValue: String, b: Boolean) {

        if (!diameterValue.equals("0")|| diameterValue.equals("All")){
            binding.tvApply.setTextColor(ContextCompat.getColor(requireActivity(),R.color.white))
            binding.tvApply.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
            binding.tvApply.isEnabled=true
        }else{
            binding.tvApply.setTextColor(ContextCompat.getColor(requireActivity(),R.color.disableText))
            binding.tvApply.backgroundTintList= ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
        }
    }

    override fun BackPressed() {

        dialog?.dismiss()
    }


}
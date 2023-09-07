package com.atd.atdmobileapp.ui.product.tires

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSeasonalDesignationBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.utils.Constants


class SeasonalDesignationFragment : DialogFragment() {
    var _binding : FragmentSeasonalDesignationBinding?= null
    private val binding get() = _binding!!
    private var checkBoxes = mutableListOf<CheckBox>()
    companion object {
        const val TAG = "SeasonalDesignationFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentSeasonalDesignationBinding.inflate(inflater, container, false)
        return binding.root
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


        checkBoxes.add(binding.cb1)
        checkBoxes.add(binding.cb2)
        checkBoxes.add(binding.cb3)

        checkBoxes.map {checkBox ->

            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

                if (isChecked){
                    checkBox.buttonTintList= ContextCompat.getColorStateList(requireContext(),
                        BottomNavigationScreenFragment.theameColor
                    )
                }else{
                    checkBox.buttonTintList= ContextCompat.getColorStateList(requireContext(), R.color.dim_gray)
                }
            }

        }
        //onclick for clear all
        binding.tvClearAll.setOnClickListener {
//            checkBoxes.clear()
            onClearAllPress()

        }

        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }



        binding.seasonalDesgapply.setOnClickListener {
            val selectedCheckboxes = mutableListOf<String>()
            for (checkBox in checkBoxes) {
                if (checkBox.isChecked) {
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }
            val result = Bundle().apply {
                putString(Constants.SEASONAL_KEY,selectedCheckboxes.joinToString())
            }
            setFragmentResult(Constants.SEASONAL_SELECTION, result)
            dialog?.dismiss()        }

        themeSetup()
    }

    private fun themeSetup() {

        binding.ivClose.imageTintList=ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.tvClearAll.setTextColor(ContextCompat.getColorStateList(requireContext(),
            BottomNavigationScreenFragment.theameColor
        ))
        binding.viewDivider2.backgroundTintList=ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)
        binding.seasonalDesgapply.backgroundTintList=ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)

    }

    private fun onClearAllPress(){
        for (cb in checkBoxes)
            cb.isChecked = false
    }

}
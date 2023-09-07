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
import com.atd.atdmobileapp.databinding.FragmentSpeedRatingBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.Constants

class SpeedRatingFragment : DialogFragment() {

    var _binding : FragmentSpeedRatingBinding?= null
    private val binding get() = _binding!!
    private val checkBoxes = mutableListOf<CheckBox>()

    companion object {
        const val TAG = "SpeedRatingFragment"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentSpeedRatingBinding.inflate(inflater, container, false)
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


        for (i in 1..22) {
            val checkBox = binding::class.java.getField("cb$i").get(binding) as CheckBox
            checkBoxes.add(checkBox)
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

                if (isChecked){
                    checkBox.buttonTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
                }else{
                    checkBox.buttonTintList=ContextCompat.getColorStateList(requireContext(), R.color.dim_gray)
                }
            }
        }

        //onclick for clear all
        binding.tvClearAll.setOnClickListener {
            onClearAllPress()

        }

        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }

        binding.speedRatingapply.setOnClickListener {
            val selectedCheckboxes = mutableListOf<String>()
            for (checkBox in checkBoxes) {
                if (checkBox.isChecked) {
                    selectedCheckboxes.add(checkBox.text.toString())

                }
            }
            val result = Bundle().apply {
                putString(Constants.SPEED_RESULT,selectedCheckboxes.joinToString())
            }
            setFragmentResult(Constants.SPEED_SELECTION, result)
            dialog?.dismiss()

        }

        setUpTheme()

    }

    private fun setUpTheme() {
        binding.ivClose.imageTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.tvClearAll.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
        binding.viewDivider2.backgroundTintList=ContextCompat.getColorStateList(requireContext(), theameColor)
        binding.speedRatingapply.backgroundTintList=ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)


    }

    private fun onClearAllPress(){
        for (cb in checkBoxes)
            cb.isChecked = false
    }

}
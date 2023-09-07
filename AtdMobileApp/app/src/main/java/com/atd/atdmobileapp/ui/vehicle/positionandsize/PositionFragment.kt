package com.atd.atdmobileapp.ui.vehicle.positionandsize

import android.os.Bundle
import com.atd.atdmobileapp.utils.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentPositionBinding

class PositionFragment(private val prevSelectedPosition: String) : DialogFragment() {

    private var _binding: FragmentPositionBinding?= null
    private val binding get() =  _binding!!
    private var radioButtons = mutableListOf<RadioButton>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
       _binding = FragmentPositionBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
       const val TAG = "PositionFrag"
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

        binding.ivCloseDiameter.setOnClickListener {
            dialog?.dismiss()
        }

        radioButtons.add(binding.radioButton)
        radioButtons.add(binding.radioButton2)

        for (cb in radioButtons){
            if (cb.text.contentEquals(prevSelectedPosition,true)){
                cb.isChecked = true
            }
        }

        binding.tireTypeRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            val buttonText = radioButton.text.toString()
            println("Got button clicked as -> ${buttonText}")

            val result = Bundle().apply {
                putString(Constants.POSITION_SELECTION, buttonText)
            }
            setFragmentResult(Constants.POSITION_SELECTION, result)
            dialog?.dismiss()
        }
    }
}
package com.atd.atdmobileapp.ui.product.tires

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentTireTypesBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor


class TireTypesFragment : DialogFragment() {
    var _binding : FragmentTireTypesBinding?=null
    private val binding get() = _binding!!


    companion object {
        const val TAG = "TireTypesFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentTireTypesBinding.inflate(inflater, container, false)
        println("Created bew TiresType Frag")

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


        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
        binding.tireTypeRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            val buttonText = radioButton.text.toString()
            println("Got button clicked as -> ${buttonText}")



            // Send the button text back to the host fragment
            val result = Bundle().apply {
                putString("tireType", buttonText)
            }
            setFragmentResult("tireTypeSelection", result)
            dialog?.dismiss()        }

        setUpTheme()
    }

    private fun setUpTheme() {
        binding.radioButton.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton2.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton3.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton4.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton5.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton6.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.radioButton7.buttonTintList=ContextCompat.getColorStateList(requireContext(),theameColor)
        binding.ivCloseTireType.imageTintList=ContextCompat.getColorStateList(requireContext(),theameColor)

    }


}
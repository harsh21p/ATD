package com.atd.atdmobileapp.ui.product.wheelaccessories

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
import com.atd.atdmobileapp.databinding.FragmentWheelAccessoriesTypeBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.Constants


class WheelAccessoriesTypeFragment : DialogFragment() {

    private var _binding: FragmentWheelAccessoriesTypeBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentWheelAccessoriesTypeBinding.inflate(inflater, container, false)
        return binding.root
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
                putString(Constants.WHEEL_ACC_TYPE_KEY, buttonText)
            }
            setFragmentResult(Constants.WHEEL_ACC_TYPE, result)
            dialog?.dismiss()
        }

        setupTheme()
    }

    private fun setupTheme() {

        binding.radioButton.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton2.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton3.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton4.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton5.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton6.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton7.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.radioButton8.buttonTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }


    companion object{
        const val TAG = "WheelAccessoriesType"
    }


}
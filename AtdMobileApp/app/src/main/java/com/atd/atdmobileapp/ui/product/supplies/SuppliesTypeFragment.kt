package com.atd.atdmobileapp.ui.product.supplies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSuppliesTypeBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.utils.Constants


class SuppliesTypeFragment : DialogFragment() {


    private var _binding: FragmentSuppliesTypeBinding?= null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        _binding = FragmentSuppliesTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "SuppliesTypeFragment"
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
        binding.ivClosesuppliesType.setOnClickListener {
            dialog?.dismiss()
        }

        binding.suppliesTypeRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            val buttonText = radioButton.text.toString()
            println("Got button clicked as -> ${buttonText}")

            // Send the button text back to the host fragment
            val result = Bundle().apply {
                putString(Constants.SUPPLIES_TYPE, buttonText)
            }
            setFragmentResult(Constants.SUPPLIES_TYPE, result)
            dialog?.dismiss()
        }

        setupTheme()
    }

    private fun setupTheme() {
        binding.radioButton.buttonTintList= ContextCompat.getColorStateList(requireActivity(),
            BottomNavigationScreenFragment.theameColor
        )
        binding.radioButton2.buttonTintList= ContextCompat.getColorStateList(requireActivity(),
            BottomNavigationScreenFragment.theameColor
        )
    }
}
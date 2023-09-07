package com.atd.atdmobileapp.ui.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentProductDeliveryBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductDeliveryFragment : Fragment() {
    private var _binding : FragmentProductDeliveryBinding? =null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDeliveryBinding.inflate(inflater, container, false)
        binding.tvFinish.setOnClickListener {
            onBoardingFinished()
        }
        return binding.root
    }

    private fun onBoardingFinished(){
        sharedPrefManager.saveOnBoardingStatus(Constants.ONBOARDING)
        findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}
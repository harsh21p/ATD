package com.atd.atdmobileapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atd.atdmobileapp.databinding.FragmentOnBoardingBinding
import com.atd.atdmobileapp.ui.onboarding.pages.ProductDeliveryFragment
import com.atd.atdmobileapp.ui.onboarding.pages.StreamLinedSearchFragment
import com.atd.atdmobileapp.ui.onboarding.pages.WelcomeToATDFragment

class OnBoardingFragment : Fragment() {
    private var _binding : FragmentOnBoardingBinding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(
            WelcomeToATDFragment(),
            StreamLinedSearchFragment(),
            ProductDeliveryFragment( )
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewpager.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}
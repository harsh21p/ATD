package com.atd.atdmobileapp.ui.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentStreamLinedSearchBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StreamLinedSearchFragment : Fragment() {
    private var _binding : FragmentStreamLinedSearchBinding? =null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStreamLinedSearchBinding.inflate(inflater, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        binding.tvNextStreamLinedSearch.setOnClickListener{
            viewPager?.currentItem = 2
        }
        skipOnBoarding()
        return binding.root
    }

    private fun skipOnBoarding(){
        binding.tvSkip.setOnClickListener {
            sharedPrefManager.saveOnBoardingStatus(Constants.ONBOARDING)
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}
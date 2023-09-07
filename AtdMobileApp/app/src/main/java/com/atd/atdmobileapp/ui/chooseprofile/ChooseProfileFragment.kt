package com.atd.atdmobileapp.ui.chooseprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentChooseProfileBinding
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChooseProfileFragment : Fragment() {

    private var _binding: FragmentChooseProfileBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseProfileBinding.inflate(inflater, container, false)
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSelectedProfile()
    }

    private fun getSelectedProfile(){
        binding.ivAtdMobileLogo.setOnClickListener {
            sharedPrefManager.saveProfileSelected(Constants.ATD_ONLINE )
            logEvents(Constants.ATD_ONLINE)
            findNavController().navigate(R.id.action_chooseProfileFragment_to_selectLocation)
        }
        binding.ivAtdTPLogo.setOnClickListener {
            sharedPrefManager.saveProfileSelected(Constants.TIRE_PROS )
            logEvents(Constants.TIRE_PROS)
            findNavController().navigate(R.id.action_chooseProfileFragment_to_selectLocation)
        }
    }
    private fun logEvents( profileType :String){
//        val bundle = Bundle()
//        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, profileType)
//        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Select_Profile,
            Category.Login,
            Action.Click,
            "Select Persona"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Select_Persona, params)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.atd.atdmobileapp.ui.rebate

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentLicencePlateBinding
import com.atd.atdmobileapp.databinding.FragmentRebateBinding
import com.atd.atdmobileapp.models.productsearch.Criteria
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RebateFragment : Fragment() {

    private var _binding: FragmentRebateBinding?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding= FragmentRebateBinding.inflate(inflater,container,false)

        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.rebate_search)
        BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.keyword_back, 0, 0, 0)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }

        firebaseAnalytics  = FirebaseAnalytics.getInstance(requireContext())
        landsRebateFormEvent()
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.etFrontTire.backgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.etRearTire.backgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(),R.color.red)

            }else if (it.equals("atdonline",true)){

                binding.etFrontTire.backgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.etRearTire.backgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)

            }
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )

        binding.etFrontTire.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                if (s.toString().trim().length>=3 ){
                    enable()
                }else{
                    disable()
                }
            }
        })
        binding.tvSearch.setOnClickListener {

          val criteria =Criteria()
            val size = arrayListOf<String>()
            size.add(binding.etFrontTire.text.toString())
            if (!binding.etRearTire.text.toString().trim().equals("")) {
                size.add(binding.etRearTire.text.toString())
            }
            criteria.size=size
            submitRebateFormEvent(binding.etFrontTire.text.toString(), binding.etRearTire.text.toString())
            val response= Gson().toJson(criteria)
            val bundle =Bundle()
            bundle.putString(Constants.REBATEDATA,response)
            bundle.putString(Constants.KEY_TYPE,Constants.REBATES)
            bundle.putString(Constants.CATEGORY_TYPE, Category.Search_Rebate)
            val fragment = KeywordSearchResultsFragment()
            fragment.arguments=bundle
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, fragment)
                .addToBackStack("VINFragment")
                .commit()
        }
        disable()

        return binding.root
    }

    private fun submitRebateFormEvent(frontSize: String, rearSize: String) {
        var params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Rebate_Search,
            Category.Search_Rebate,
            Action.Click,
            null
        )

        val searchNonCriteria = SearchNonCriteria(
            type = SearchType.sizeByRebate,
            frontSize = frontSize
        )

        if (rearSize.trim() != ""){
            searchNonCriteria.rearSize = rearSize.trim()
        }

        params = Common.convertSearchNonCriteriaToBundle(searchNonCriteria, params)

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Search, params)
    }

    private fun landsRebateFormEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Rebate_Search,
            Category.Search_Rebate,
            Action.Impression,
            "View rebate search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Rebate_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }


    fun enable(){

        binding.tvSearch.isEnabled=true
        binding.tvSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.etRearTire.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.red)
                binding.tvSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
            }else if (it.equals("atdonline",true)){
                binding.etRearTire.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.atd_blue)
                binding.tvSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
            }
        }

        binding.tvRearTire.setTextColor(ContextCompat.getColorStateList(requireActivity(), R.color.black))
        binding.etRearTire.isEnabled = true
    }

    fun disable(){

        binding.tvSearch.isEnabled = false
        binding.tvSearch.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.disable_background)
        binding.tvSearch.setTextColor(ContextCompat.getColorStateList(requireActivity(), R.color.disableText))

        binding.tvRearTire.setTextColor(ContextCompat.getColorStateList(requireActivity(), R.color.disableText))
        binding.etRearTire.isEnabled = false
        binding.etRearTire.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.disableText)

    }

    private fun BackPressed() {
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener(null)
        BottomNavigationScreenFragment.tvHeaderText?.text=""
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)
                println("logo ===> $it")

            }else if (it.equals("atdonline",true)){
                BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)
                println("logo ===> $it")


            }
        }
        val hostFragment = HomeTabFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()

    }


}
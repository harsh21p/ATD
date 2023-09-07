package com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSubHomeBinding
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.ui.barcode.BarcodeSearchFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeyWordSearchFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.ApprovalsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.HomeViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.MyQuotsFragment
import com.atd.atdmobileapp.ui.licenceplate.LicencePlateFragment

import com.atd.atdmobileapp.ui.product.ProductFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.ui.rebate.RebateFragment
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch
import com.atd.atdmobileapp.ui.vin.VINFragment
import com.atd.atdmobileapp.utils.*


import com.google.android.material.tabs.TabLayout
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeTabFragment : Fragment() {

    var _binding : FragmentSubHomeBinding?=null
    val  binding get() = _binding!!
    private val homeViewModel by viewModels<HomeViewModel>()
    private val tiresBrandsViewModel by viewModels<TiresBrandsViewModel>()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        _binding = FragmentSubHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


         binding.myOrders.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.myOrders.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))

        binding.locationLayout.ivKeywordSearch.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.locationLayout.voiceLL.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.locationLayout.tvAddress2.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)

        if (theameColor==R.color.red) {
            binding.locationLayout.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.red_baseline_rectangle_24)
        }else{
            binding.locationLayout.rlSearch.background =
                ContextCompat.getDrawable(requireActivity(), R.drawable.baseline_rectangle_24)
        }

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        })
        sharedPrefManager?.getServicingdcNumber()?.let {

            homeViewModel.getLocation(it)

        }

        sharedPrefManager?.getLocationNumber()?.let {

            binding.locationLayout.tvLocation.text="Location#"+it

        }

        tiresBrandsViewModel.getPreferredBrandConfigurationList()
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())

        landsOnHomeScreenEvent()

        val hostFragment = MyOrdersFragment()
        val quotes = MyQuotsFragment()
        val approvals = ApprovalsFragment()
        val product = ProductFragment()
        val vehicle = VehicleSearch()
        val barcode = BarcodeSearchFragment()
        val vinFragment = VINFragment()
        val licencePlate = LicencePlateFragment()
        val rebate = RebateFragment()


        requireActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.homeTabScreens, hostFragment)
            .commit();

        binding.tvRebates.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, rebate)
                .addToBackStack("HomeTabFragment")
                .commit()
        }

        binding.tvLicencePlate.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, licencePlate)
                .addToBackStack("HomeTabFragment")
                .commit()
        }
        binding.tvBarCode.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, barcode)
                .addToBackStack("HomeTabFragment")
                .commit()
        }
        binding.tvVin.setOnClickListener {

            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, vinFragment)
                .commit()

        }
        binding.myOrders.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.homeTabScreens, hostFragment)
                .commit()
            binding.myQuotes.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            binding.myQuotes.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))
            binding.approvals.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            binding.approvals.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))
            binding.myOrders.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
            binding.myOrders.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))

        }

        binding.myQuotes.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.homeTabScreens, quotes)
                .commit()

            binding.myQuotes.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
            binding.myQuotes.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
            binding.approvals.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            binding.approvals.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))
            binding.myOrders.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.black)
            binding.myOrders.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))

        }

        binding.approvals.setOnClickListener {
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.homeTabScreens, approvals)
                .commit()
            binding.myQuotes.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            binding.myQuotes.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))
            binding.approvals.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), theameColor)
            binding.approvals.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
            binding.myOrders.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(), R.color.black)
            binding.myOrders.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))

        }

        //adding code for onClick listener for product
        binding.product.setOnClickListener{
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, product)
                .commit()
        }

        //adding onClick for vehicle
        binding.vehicle.setOnClickListener {
            //adding vehicle search visit event
            visitVihSearchEvent()
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, vehicle)
                .addToBackStack("HomeTabFragment")
                .commit()
        }
        return root

    }

    private fun visitVihSearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Vehicle_Search,
            Category.Search_Fitment,
            Action.Impression,
            "View vehicle search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Vehicle_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    private fun landsOnHomeScreenEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Home,
            Category.Navigation,
            Action.Impression,
            "Viewed home screen"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Home)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)

    }

    private fun BackPressed() {

        val intent = Intent()
        intent.action= Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags= Intent.FLAG_ACTIVITY_CLEAR_TOP
        requireActivity().startActivity(intent)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.locationLayout.tvKeywordSearch.setOnFocusChangeListener { view, b ->

            if (b){
                var bundle= Bundle()
                bundle.putString("address1",binding.locationLayout.tvAddress.getText().toString())
                bundle.putString("address2",binding.locationLayout.tvAddress2.getText().toString())

                //adding keyword search event
                visitKeySearchEvent()
                val searchFragment= KeyWordSearchFragment()
                searchFragment.arguments=bundle
                requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, searchFragment)
                    .commit();
            }
        }

        binding.locationLayout.rlSearch.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("address1",binding.locationLayout.tvAddress.getText().toString())
            bundle.putString("address2",binding.locationLayout.tvAddress2.getText().toString())

            val searchFragment= KeyWordSearchFragment()
            searchFragment.arguments=bundle
            requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, searchFragment)
                .commit();
        }


        homeViewModel.locationResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)

                    it?.data?.let {

                        binding.locationLayout.tvAddress.text =
                            it.distributioncenter.address.address1 +"\n"+
                                    it.distributioncenter.address.city +","+
                                    it.distributioncenter.address.state +" "+
                                    it.distributioncenter.address.zipcode +" "

                        binding.locationLayout.tvAddress2.text=  it.distributioncenter.address.city +" (#"+it.distributioncenter.servicingdc+")"
                    }
                    //saving location details to sharedPrefs
                    //need to add location number dynamically
                    sharedPrefManager.saveSelectedLocation(it.data)
                    //binding.progressbar.visibility = View.GONE

                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)
                    //binding.progressbar.visibility = View.GONE

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    //binding.progressbar.visibility = View.VISIBLE
                }
            }
        })

        //observer for preferred brands
        tiresBrandsViewModel.preferredBrandsLiveData.observe(viewLifecycleOwner, Observer {
            val preferredBrandList = it.data?.map { it.value }?.toList()!!
            mainViewModel.setPreferredBrand(preferredBrandList)
        })
    }

    private fun visitKeySearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Keyword_Search,
            Category.Search_Keyword,
            Action.Impression,
            "View keyword search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Keyword_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }


}
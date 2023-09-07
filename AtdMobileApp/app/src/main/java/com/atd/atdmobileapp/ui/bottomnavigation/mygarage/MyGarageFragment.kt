package com.atd.atdmobileapp.ui.bottomnavigation.mygarage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentMyGarageBinding
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersSearchFragment
import com.atd.atdmobileapp.ui.mylists.MyListFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewMyQuotesFragment
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MyGarageFragment : Fragment(), RecyclerViewClickListner{

    var _binding : FragmentMyGarageBinding?=null
    private val binding get() = _binding!!
    private val myGarageViewModel by viewModels<MyGarageViewModel>()
    lateinit var adapter : MyGarageAdapter
    private val approvalViewModel by viewModels<MyApprovalsViewModel>()

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyGarageBinding.inflate(inflater, container, false)
        val root : View = binding.root
        sharedPrefManager?.getLocationNumber()?.let {
            approvalViewModel.getMyApprovals(it.lowercase())

        }

        binding.imageView2.imageTintList= ContextCompat.getColorStateList(requireContext(),theameColor)
        setupLocationDetails()
        setupUI()
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        approvalViewModel.myApprovalResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("approvals --> "+it.data)
                    binding.progressbar.visibility = View.GONE

                    it?.data?.orderapprovals?.let {

                        sharedPrefManager.saveApprovalsSize(it.size?:0)
                        setupUI()
                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)
                    binding.progressbar.visibility = View.GONE

                }
                is NetworkResult.Loading -> {
                    println("loading?????")
                    binding.progressbar.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun setupLocationDetails(){
        //retrieving saved location
        val location_address = sharedPrefManager.getSelectedLocation()

        //setting up location number
        sharedPrefManager?.getLocationNumber()?.let {
            binding.tvLocationNum.text = getString(R.string.location_number)+it
        }
        println(location_address)
        val dcDetails = Gson().fromJson(location_address, DCDetails::class.java)
//        binding.tvLocationAddress.text = dcDetails.distributioncenter.address.address1
        dcDetails?.let {
            val temp_location = dcDetails.distributioncenter.address.address1 +"\n"+
                    dcDetails.distributioncenter.address.city +","+
                    dcDetails.distributioncenter.address.state +" "+
                    dcDetails.distributioncenter.address.zipcode +" "
            binding.tvLocationAddress.text = temp_location
            val temp_dc = dcDetails.distributioncenter.address.city +" (#"+dcDetails.distributioncenter.servicingdc+")"
            binding.tvCity.text = temp_dc
        }





    }

    private fun setupUI() {
        var title = arrayOf("My Orders", "My Quotes", "My Lists", "Approvals")

        var descriptions = arrayOf("See the status of all orders placed", "View and share quotes with customers.", "Keep favorites saved in one location", "Review orders for approval")

        var icons = arrayOf(R.drawable.garage_cart, R.drawable.garage_quotes, R.drawable.garage_lists, R.drawable.garage_approvals)

        var noOfApprovals = sharedPrefManager.getApprovals()
        adapter= MyGarageAdapter(title,descriptions,icons,noOfApprovals,this,requireActivity())
        binding.recyclerViewGarage.layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        binding.recyclerViewGarage.adapter = adapter
    }


    //got the tab clicked for Adapter here
    override fun onItemClick(view: View, tabName: String) {
        println("Data came here $tabName")
        //Need to navigate to another fragment
        when(tabName){

            "My Orders"->{
                val fragment= MyOrdersSearchFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .commit()
            }

            "Approvals"->{
                val fragment= SubmitApprovalsFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("MyGarageFragment")
                    .commit()
            }

            "My Quotes" ->{
                val fragment = ViewMyQuotesFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .commit()
            }

            "My Lists"->{
                val fragment= MyListFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomNavigationViewFrame, fragment)
                    .addToBackStack("MyGarageFragment")
                    .commit()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

}
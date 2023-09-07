package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders

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
import com.atd.atdmobileapp.databinding.FragmentMyOrdersBinding
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.models.myordersdata.Orderstatuse
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyOrdersFragment() : Fragment() {


    lateinit var orderstatuse :ArrayList<Orderstatuse>
    var _binding : FragmentMyOrdersBinding?=null
    private val binding get() = _binding!!
    lateinit var   adapter : MyOrdersAdapter
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private val myOrdersViewModel by viewModels<MyOrdersViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding= FragmentMyOrdersBinding.inflate(inflater,container,false)
        val root : View = binding.root


        if (theameColor==R.color.red) {
            binding.viewAll.background = ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.carved_background_24_tireprose
            )
        }else{
            binding.viewAll.background = ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.carved_background_24
            )
        }
        binding.viewAll.setTextColor(ContextCompat.getColorStateList(requireActivity(), theameColor))

        orderstatuse= arrayListOf()
        setupUI()
        sharedPrefManager?.getLocationNumber()?.let {

            val myOrderRequest = MyOrderRequest()
            myOrderRequest.locationnumber= sharedPrefManager.getLocationNumber().toString()
            myOrdersViewModel.getMyOrders(myOrderRequest)
            binding.progressbar.visibility = View.VISIBLE

        }


        return root
    }
    private fun setupUI() {
        adapter= MyOrdersAdapter(arrayListOf(),requireActivity())
        binding.rvMyOrders.layoutManager = LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
        binding.rvMyOrders.adapter = adapter
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOrdersViewModel.myOrderResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it?.data?.let {

                            orderstatuse -> addOrders(orderstatuse)

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

        binding.viewAll.setOnClickListener {

            val fragment= MyOrdersSearchFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, fragment)
                .commit();

        }
    }

    private fun addOrders(orderstatuse: MyOrdersData) {

        orderstatuse?.orderstatuses?.let {
            if (it.size>0) {
                if (it.size > 3) {
                    binding.viewAll.visibility = View.VISIBLE
                } else {
                    binding.viewAll.visibility = View.GONE

                }
                adapter.addOrders(it)
                adapter.notifyDataSetChanged()
            }else{
                binding.noData.visibility=View.VISIBLE
            }

        }

    }


}
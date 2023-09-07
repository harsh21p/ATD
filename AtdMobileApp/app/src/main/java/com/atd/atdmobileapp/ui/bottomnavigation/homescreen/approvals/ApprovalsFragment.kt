package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals

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
import com.atd.atdmobileapp.databinding.FragmentApprovalsBinding
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsFragment
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ApprovalsFragment : Fragment() {

    var _binding : FragmentApprovalsBinding? = null
    val binding get() = _binding!!

    lateinit var adapter : MyApprovalsAdapter

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

        _binding= FragmentApprovalsBinding.inflate(inflater,container,false)
        val view: View = binding.root

        if (BottomNavigationScreenFragment.theameColor == R.color.red) {
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
        binding.viewAll.setTextColor(
            ContextCompat.getColorStateList(requireActivity(),
                BottomNavigationScreenFragment.theameColor
            ))

        setupUI()

        sharedPrefManager?.getLocationNumber()?.let {

            approvalViewModel.getMyApprovals(it)
            binding.progressbar.visibility = View.VISIBLE
        }



        return view
    }

    private fun setupUI() {
        adapter= MyApprovalsAdapter(arrayListOf(),requireActivity())
        binding.rvMyApprovals.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)
        binding.rvMyApprovals.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        approvalViewModel.myApprovalResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it?.data?.let {

                            orderstatuse -> addApprovals(orderstatuse)

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

            val fragment = SubmitApprovalsFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, fragment)
                .addToBackStack("MyApprovalsFragment")
                .commit()
        }
    }

    private fun addApprovals(orderstatuse: MyApprovalsData) {

        orderstatuse?.orderapprovals?.let {
            sharedPrefManager.saveApprovalsSize(it.size)
            if (it.size>0) {
                //adding number of Approvals to SharedPrefs
                if (it.size > 3) {
                    binding.viewAll.visibility = View.VISIBLE
                } else {
                    binding.viewAll.visibility = View.GONE

                }
                adapter.addApprovals(it)
                adapter.notifyDataSetChanged()

            }else{
                binding.noData.visibility=View.VISIBLE
            }
        }
    }

}
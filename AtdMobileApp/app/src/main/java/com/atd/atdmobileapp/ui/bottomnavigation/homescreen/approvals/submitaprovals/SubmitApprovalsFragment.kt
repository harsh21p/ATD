package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.AlertBinding
import com.atd.atdmobileapp.databinding.FragmentSubmitBinding
import com.atd.atdmobileapp.models.Permissions
import com.atd.atdmobileapp.models.approveorder.ApproveOrder
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsViewModel
import com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SubmitApprovalsFragment : Fragment(),ApproveData {


    private var showStatus: Boolean = false
    private lateinit var adapter: SubmitApprovalsAdapter
    var _binding : FragmentSubmitBinding? = null
    val binding get() = _binding!!
    lateinit var permissions:Permissions
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    companion object {
        fun newInstance() = SubmitApprovalsFragment()
    }
    var approveList=ArrayList<String>()
    private val approvalViewModel by viewModels<MyApprovalsViewModel>()

    private val permissionViewModel by viewModels<LoginViewModel>()
    private val submitApprovalsViewModel by viewModels<SubmitApprovalsViewModel>()
    var orderPermissions :String?=null
    lateinit var locationNumber:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding= FragmentSubmitBinding.inflate(inflater,container,false)
        val view: View = binding.root

        setUpTheme()
        binding.ordersSubmitFoote.clApproveCancel.gone()
        sharedPrefManager.getProfileSelected()?.let { permissionViewModel.getCheckPermission(it,"APPROVE_ORDERS") }
        //permissionViewModel.getPermissionList()
        BottomNavigationScreenFragment.tvHeaderText?.text=requireActivity().resources.getString(R.string.approvals)
        BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)

        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(),object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                BackPressed()
            }

        })
        //enable()
        setupUI()
        sharedPrefManager?.getLocationNumber()?.let {

            locationNumber=it
            approvalViewModel.getMyApprovals(it.lowercase())
            binding.progressbar.visibility = View.VISIBLE
        }

        binding.tvSelectAll.setOnClickListener {

            if (binding.tvSelectAll.text.equals(resources.getString(R.string.select_all))) {
                binding.tvSelectAll.text=resources.getString(R.string.di_select_all)
                adapter.sellectAll(true)
                adapter.notifyDataSetChanged()
                enable()
            }else{
                binding.tvSelectAll.text=resources.getString(R.string.select_all)
                adapter.sellectAll(false)
                adapter.notifyDataSetChanged()
                disable()
            }
        }
        binding.ordersSubmitFoote.tvApprove.setOnClickListener {


            var count=0
            approveList.map {
                count++
                if (count==approveList.size){
                    showStatus=true
                }
                val request = ApproveOrder()
                request.cartid=it
                request.locationnumber=locationNumber
                request.approvalstatus="true"
                request.comments=""
                Approve(request,"approve")
            }

        }

        binding.ordersSubmitFoote.btReset.setOnClickListener {
            val rejectDialog = Dialog(requireActivity(),R.style.WideDialog)
            rejectDialog.setContentView(R.layout.reject_dialog)
            rejectDialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
            val cancel : TextView = rejectDialog.findViewById(R.id.cancel)
            val reject : TextView = rejectDialog.findViewById(R.id.reject)
            val comments : EditText = rejectDialog.findViewById(R.id.etComments)
            cancel.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
            reject.setTextColor(ContextCompat.getColorStateList(requireContext(),theameColor))
            cancel.setOnClickListener {
                rejectDialog.dismiss()
            }
            reject.setOnClickListener {
                var count=0
                approveList.map {

                    count++
                    if (count==approveList.size){
                        showStatus=true
                    }
                    val request = ApproveOrder()
                    request.cartid=it
                    request.locationnumber=locationNumber
                    request.approvalstatus="false"
                    request.comments=comments.text.toString()
                    Approve(request, "reject")
                    rejectDialog.dismiss()
                }

            }
            rejectDialog.show()
        }
        return view

    }

    private fun setUpTheme() {
       // binding.tvSelectAll.compoundDrawableTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
        binding.tvSelectAll.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.black))
    }

    private fun Approve(request: ApproveOrder, type: String) {

        submitApprovalsViewModel.ApproveOrder(request).observe(viewLifecycleOwner,
            Observer {
                when(it) {
                    is NetworkResult.Success -> {
                        it?.data?.let {

                            if(showStatus) {

                                val alert = Dialog(requireActivity(),R.style.WideDialog)
                                val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                                val alertBinding = AlertBinding.inflate(inflater)
                                alert.setContentView(alertBinding.root)
                                alert.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
                                alert.setCancelable(false)
                                alertBinding.alertOK.setTextColor(ContextCompat.getColorStateList(requireContext(),
                                    theameColor))
                                if (type.equals("approve", true)) {
                                    alertBinding.alertTitle.setText("Success")
                                    alertBinding.alertMessage.setText("You approved ${approveList.size} order")
                                } else {
                                    alertBinding.alertTitle.setText("Order Rejected")
                                    alertBinding.alertMessage.setText("You rejected ${approveList.size} order")
                                }
                                alertBinding.alertOK.setOnClickListener {
                                    alert.dismiss()
                                    sharedPrefManager?.getLocationNumber()?.let {
                                        locationNumber = it
                                        approvalViewModel.getMyApprovals(it.lowercase())
                                        binding.progressbar.visibility = View.VISIBLE
                                    }

                                }

                                alert.show()

                                binding.progressbar.gone()
                                showStatus=false
                            }
                        }
                    }
                    is NetworkResult.Error -> {

                        val alert= AlertDialog.Builder(requireActivity())
                        alert.setMessage(it?.message)
                        alert.setPositiveButton("OK",DialogInterface.OnClickListener{
                                dialog, which ->
                            dialog.dismiss()
                        })
                        alert.show()
                        binding.progressbar.gone()

                    }
                    is NetworkResult.Loading -> {
                        binding.progressbar.visible()
                    }
                }

            })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        approvalViewModel.myApprovalResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("approvals --> "+it.data)
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

        permissionViewModel.checkPermission.observe(viewLifecycleOwner, Observer {

            when(it){

                is NetworkResult.Success ->{

                    orderPermissions=it.data
                    //APPROVE_ORDERS
                    println("orderPermissions $orderPermissions")
                    if(orderPermissions?.equals("APPROVE_ORDERS",true) == true){
                        binding.tvSelectAll.visible()
                        binding.ordersSubmitFoote.clApproveCancel.visible()
                        adapter.checkBoxVisible(true)
                    }else{

                        binding.tvSelectAll.gone()
                        binding.ordersSubmitFoote.clApproveCancel.gone()
                        adapter.checkBoxVisible(false)
                    }
                }
                is NetworkResult.Error -> {
                    println("ERROR?????"+it.message)


                }
                is NetworkResult.Loading -> {
                    println("loading?????")

                }
            }
        })


    }

    private fun setupUI() {
        adapter= SubmitApprovalsAdapter(requireActivity(),arrayListOf(),this@SubmitApprovalsFragment)
        binding.rvMyApprovals.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)
        binding.rvMyApprovals.adapter = adapter
    }

    fun BackPressed() {

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
        //requireActivity().supportFragmentManager.popBackStack()
        val hostFragment = MyGarageFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }

private fun addApprovals(orderstatuse: MyApprovalsData) {

    orderstatuse?.orderapprovals?.let {
        sharedPrefManager.saveApprovalsSize(it.size)

        if (it.size>0) {
            //adding number of Approvals to SharedPrefs
            binding.rvMyApprovals.visible()
            //binding.tvSelectAll.visible()
            binding.tvPendingApprovals.visible()
            binding.ordersSubmitFoote.viewDivider.visible()
            binding.ordersSubmitFoote.tvApprove.visible()
            binding.ordersSubmitFoote.btReset.visible()
            adapter.addApprovals(it)
            adapter.notifyDataSetChanged()

        }else{
            binding.noReviewImg.visible()
            binding.tvNoReview.visible()
            binding.tvSelectAll.gone()
            binding.tvPendingApprovals.gone()
            binding.rvMyApprovals.gone()
            binding.ordersSubmitFoote.viewDivider.gone()
            binding.ordersSubmitFoote.tvApprove.gone()
            binding.ordersSubmitFoote.btReset.gone()
            if (orderPermissions==null){
                binding.tvNoReview.text=Constants.no_approvals
            }
            //binding.noData.visibility=View.VISIBLE
        }
    }
}


   fun enable(){

       binding.ordersSubmitFoote.btReset.isEnabled=true
       binding.ordersSubmitFoote.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
       binding.ordersSubmitFoote.viewDivider.backgroundTintList=(ContextCompat.getColorStateList(requireActivity(),theameColor))
       binding.ordersSubmitFoote.tvApprove.isEnabled=true
       binding.ordersSubmitFoote.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),theameColor)
       binding.ordersSubmitFoote.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
   }

    fun disable(){
        approveList= arrayListOf()
        binding.ordersSubmitFoote.btReset.isEnabled=false
        binding.ordersSubmitFoote.btReset.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
        binding.ordersSubmitFoote.viewDivider.backgroundTintList=(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.ordersSubmitFoote.tvApprove.isEnabled = false
        binding.ordersSubmitFoote.tvApprove.backgroundTintList =
            ContextCompat.getColorStateList(requireActivity(), R.color.disable_background)
        binding.ordersSubmitFoote.tvApprove.setTextColor(
            ContextCompat.getColorStateList(
                requireActivity(),
                R.color.disableText
            )
        )
    }

    override fun ApproveData(approve: Boolean, cartid: String) {

        if (approve){
            approveList.add(cartid)
        }else{
            approveList.size.let {
                if (it>0) {
                    approveList.remove(cartid)
                }
            }
        }

        if (approveList.size>0){
            enable()
            binding.tvSelectAll.text=resources.getString(R.string.di_select_all)
        }else{
            disable()
        }
    }
}





package com.atd.atdmobileapp.ui.mylists

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentCreateMyListBinding
import com.atd.atdmobileapp.models.mylist.CreateListRequest
import com.atd.atdmobileapp.models.mylist.MyListResponse
import com.atd.atdmobileapp.models.mylist.Productlist
import com.atd.atdmobileapp.models.mylist.Productlists
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdLogo
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.tvHeaderText
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class CreateMyListFragment : Fragment() {

    private  var recurringfrequencytype: String="DAYS"
    private var rgReoccuringOrderText: String="No"
    private var rgReoccuringOrderStatus: Boolean=false
    var _binding : FragmentCreateMyListBinding?=null
    val binding get()= _binding!!
    lateinit var profileSelected:String
    var mainViewModel : MainViewModel?=null
    private var rbSharedData:String="No"
    val myListViewModel by viewModels<MyListViewModel> ()
    @Inject
    lateinit var sharedPrefManager:SharedPrefManager
    private var productData: Productlists?=null
    private var type:String=""
    var themeColor: Int=R.color.black
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateMyListBinding.inflate(inflater,container,false)

        profileSelected= sharedPrefManager?.getProfileSelected().toString()
        if (profileSelected.equals("tirepros",true)){
            themeColor=R.color.red
        }else if (profileSelected.equals("atdonline",true)) {
            themeColor=R.color.atd_blue
        }
        setUpTheme(profileSelected)
        mainViewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        println("productlists ==> ${this.arguments?.getSerializable("productlists")}")
        type= this.arguments?.getString(Constants.KEY_TYPE) as String

        if (type.equals(Constants.EDIT)){
            productData =  this.arguments?.getSerializable("productlists") as Productlists

            binding.SubmitFooter.tvApprove.text="SAVE"
            binding.etListName.setText(productData?.name)

            productData?.recurringstartdate?.let {
                binding.etNextOrderDate.setText(Common.getYearMonthDayforSlashSeperator(it))
            }

            productData?.recurringfrequencytype?.let {

                binding.etFrequency.setText(it)
            }
            if ("READ".contains(productData?.sharelist.toString())){
                rbSharedData = "READ"
                binding.rbReadOnly.isChecked=true
                binding.rbReadOnly.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            }else if ("WRITE".contains(productData?.sharelist.toString())){
                rbSharedData = "WRITE"
                binding.rbEditable.isChecked=true
                binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                binding.rbEditable.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }else if ("NO".contains(productData?.sharelist.toString())){
                rbSharedData = "NO"
                binding.rbNo.isChecked=true
                binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }

            if (productData?.recurring==true){
                rgReoccuringOrderStatus=true
                binding.rbYes.isChecked=true
                binding.rbYes.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                yesClickedEnable()
             binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
            }else {
                noClickedEnable()
                binding.rbReOccuringNo.isChecked=true
                rgReoccuringOrderStatus=false
                binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }


        }
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                onBackPressed()
            }
        })

        atdLogo?.setOnClickListener {
            onBackPressed()
        }

        binding.SubmitFooter.btReset.setOnClickListener {
            onBackPressed()
        }

        binding.SubmitFooter.tvApprove.setOnClickListener {
            if (type.equals(Constants.EDIT)) {
                updateList()
            }else if(type.equals(Constants.ADD)){
                createList()
            }
        }


        binding.rbSharedList.setOnCheckedChangeListener(object : OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

                val radioButton = group!!.findViewById(checkedId) as RadioButton
                if (radioButton.text.toString().contains("Read")){
                    rbSharedData = "READ"
                }else if (radioButton.text.toString().contains("Editable")){
                    rbSharedData = "WRITE"
                }else{
                    rbSharedData = "NO"
                }
                println("checked id ${rbSharedData}")

                if(binding.rbReadOnly==radioButton){
                   binding.rbReadOnly.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                   binding.rbEditable.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                   binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
               }else if( binding.rbEditable==radioButton){
                   binding.rbReadOnly.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                   binding.rbEditable.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                   binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
               }else{
                   binding.rbReadOnly.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                   binding.rbEditable.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                   binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
               }
            }
        })


        binding.rgReoccuringOrder.setOnCheckedChangeListener(object : OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

                val radioButton = group!!.findViewById(checkedId) as RadioButton
                 rgReoccuringOrderText = radioButton.text.toString().trim()

                if (radioButton.text.toString().trim().equals("Yes",true)){
                    rgReoccuringOrderStatus=true
                }else{
                    rgReoccuringOrderStatus=false
                }

                    if( binding.rbYes==radioButton){
                        binding.rbYes.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                        binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        yesClickedEnable()
                    }else{
                        binding.rbYes.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                        noClickedEnable()
                    }

            }
        })

        binding.etListName.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(listName: Editable?) {

               listName?.let {

                   if (it.toString().trim().isNotEmpty() && rgReoccuringOrderText.equals("No")){
                       enable()
                   }else if (it.toString().trim().isNotEmpty() && rgReoccuringOrderText.equals("Yes") && binding.etNextOrderDate.text.toString().length>8){
                       enable()
                   } else{
                       disable()
                   }
               }


            }
        })

        binding.etNextOrderDate.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(requireActivity(), DatePickerDialog.OnDateSetListener{view, year, monthOfYear, dayOfMonth ->

                val month : Int = monthOfYear.toInt()+1
                var selecteDate: String?=""
                if (month<10){
                     selecteDate  = ("0" + month + "/" + dayOfMonth + "/" + year)
                }
                binding.etNextOrderDate.setText(selecteDate)
                selecteDate?.let {

                    if (binding.etListName.text.toString().trim().isNotEmpty() && rgReoccuringOrderStatus==true && it.toString().trim().length>8){
                        enable()
                    } else{
                        disable()
                    }
                }
            }, year, month, day)

            dpd.getDatePicker().minDate=System.currentTimeMillis();
            dpd.show()
        }

        binding.ivFrequency.setOnClickListener {
            showFrequencyDialog()
        }
        binding.etFrequency.setOnClickListener {
            showFrequencyDialog()
        }
        return binding.root
    }

    private fun updateList() {

        val locationNum= sharedPrefManager?.getLocationNumber()
        val request = MyListResponse()
        val productlist= Productlists()
        productlist.name=binding.etListName.text.toString()
        productlist.sharelist=rbSharedData
        productlist.recurring=rgReoccuringOrderStatus
        if (rgReoccuringOrderStatus==true){
            productlist.recurringstartdate=Common.getYearMonthDay(binding.etNextOrderDate.text.toString())
            productlist.recurringfrequencytype=recurringfrequencytype
        }else{
            productlist.recurringstartdate=Common.currentDate()
            productlist.recurringfrequencytype="DAYS"
        }
        productlist.recurringfrequency=null
        productlist.uid=productData?.uid
        //productlist.products= productData?.products!!
        request.productlist=productlist


        println("productData==> ${Gson().toJson(request)}")

        myListViewModel.updateMyList(locationNum!!, productlist?.name!!,request).observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {

                when(it){
                    is NetworkResult.Loading ->{

                        binding.progressbar.visible()
                    }
                    is NetworkResult.Success ->{

                        it?.data?.productlist?.let {

                            binding.progressbar.gone()
                            val arguments= Bundle()
                            arguments.putSerializable("productlists",it)
                            val hostFragment = MyListDetailsFragment()
                            hostFragment.arguments=arguments
                            requireActivity().supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                                .commit()
                        }
                        toast("Updated Successfully")
                    }
                    is NetworkResult.Error ->{
                        binding.progressbar.gone()
                        errorToast(it.message)
                    }
                }
            })



    }

    private fun showFrequencyDialog() {

        val ft: FragmentTransaction = childFragmentManager.beginTransaction()
        FrequencyDialog(binding.etFrequency.text.toString()).show(ft,"dialog")

    }

    private fun createList() {

        val request = CreateListRequest()
        request.locationnumber=sharedPrefManager?.getLocationNumber().toString()
        val productlist= Productlist()
        productlist.name=binding.etListName.text.toString()
        productlist.sharelist=rbSharedData
        productlist.recurring=rgReoccuringOrderStatus
        if (rgReoccuringOrderStatus==true){
            productlist.recurringstartdate=Common.getYearMonthDay(binding.etNextOrderDate.text.toString())
            productlist.recurringfrequencytype=recurringfrequencytype

        }else{
            productlist.recurringstartdate=Common.currentDate()
            productlist.recurringfrequencytype=null
        }
        productlist.recurringfrequency=1
        request.productlist=productlist

        println("createListResp ${Gson().toJson(request)}")
        myListViewModel.saveMyList(request.locationnumber,request).observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {

                when(it){
                    is NetworkResult.Loading ->{

                        binding.progressbar.visible()
                    }
                    is NetworkResult.Success ->{

                        if (it?.data?.listcreated==true){
                            println("List resp ${it?.data}")
                            binding.progressbar.gone()
                            onBackPressed()
                        }
                    }
                    is NetworkResult.Error ->{
                        binding.progressbar.gone()
                        errorToast(it.message)
                    }
                }
            })

        println("CreatedList req :$request")
    }

    private fun noClickedEnable() {

        binding.tvNextOrderDate.gone()
        binding.etNextOrderDate.gone()
        binding.tvFrequency.gone()
        binding.etFrequency.gone()
        binding.ivFrequency.gone()
        if (binding.etListName.text.toString().trim().isNotEmpty()){
            enable()
        }else{
            disable()
        }
    }

    private fun yesClickedEnable() {
        binding.tvNextOrderDate.visible()
        binding.etNextOrderDate.visible()
        binding.tvFrequency.visible()
        binding.etFrequency.visible()
        binding.ivFrequency.visible()
        if (binding.etNextOrderDate.text.toString().length>8 && binding.etListName.text.toString().trim().isNotEmpty()){
            enable()
        }else{
            disable()
        }
    }

    fun enable(){

        if (profileSelected.equals("tirepros",true)){


            binding.SubmitFooter.tvApprove.isEnabled=true
            binding.SubmitFooter.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
            binding.SubmitFooter.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))

        }else if (profileSelected.equals("atdonline",true)){

            binding.SubmitFooter.tvApprove.isEnabled=true
            binding.SubmitFooter.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
            binding.SubmitFooter.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))
        }
    }

    fun disable(){

            binding.SubmitFooter.tvApprove.isEnabled=false
            binding.SubmitFooter.tvApprove.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
            binding.SubmitFooter.tvApprove.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))
    }

    fun setUpTheme(profileSelected: String?) {

        binding.SubmitFooter.btReset.text="CANCEL"
        binding.SubmitFooter.tvApprove.text="CREATE LIST"
        binding.tvNextOrderDate.gone()
        binding.etNextOrderDate.gone()
        binding.tvFrequency.gone()
        binding.etFrequency.gone()
        binding.ivFrequency.gone()
        binding.SubmitFooter.btReset.isEnabled=true

        tvHeaderText?.text=requireActivity().resources.getString(R.string.create_list)

            if (profileSelected.equals("tirepros",true)){
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
                binding.etListName.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.etNextOrderDate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.etFrequency.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.ivFrequency.imageTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.SubmitFooter.btReset.setTextColor(ContextCompat.getColor(requireActivity(),R.color.red))
                binding.SubmitFooter.viewDivider.setBackgroundColor(ContextCompat.getColor(requireActivity(),R.color.red))
                binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)
                binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.red)

            }else if (profileSelected.equals("atdonline",true)){

                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)
                binding.etListName.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.etNextOrderDate.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.etFrequency.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.ivFrequency.imageTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.SubmitFooter.btReset.setTextColor(ContextCompat.getColor(requireActivity(),R.color.atd_blue))
                binding.rbReOccuringNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.rbNo.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.atd_blue)
                binding.SubmitFooter.viewDivider.setBackgroundColor(ContextCompat.getColor(requireActivity(),R.color.atd_blue))

            }else{

            }

    }

    private fun onBackPressed() {

        if (type.equals(Constants.ADD)) {
            val hostFragment = MyListFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }
        if (type.equals(Constants.EDIT)){
            val arguments= Bundle()
            arguments.putSerializable("productlists",productData)
            val hostFragment = MyListDetailsFragment()
            hostFragment.arguments=arguments
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.bottomNavigationViewFrame, hostFragment)
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel?.frequency?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it.isNotEmpty()){

                if (it.equals("Daily",true)){
                    recurringfrequencytype="DAYS"
                }else if (it.equals("Weekly",true)){
                    recurringfrequencytype="WEEKS"
                }else if (it.equals("Monthly",true)){
                    recurringfrequencytype="MONTHS"
                }else if (it.equals("Quarterly",true)){
                    recurringfrequencytype="QUARTERS"
                }else if (it.equals("Annually",true)){
                    recurringfrequencytype="YEARS"
                }
                binding.etFrequency.setText(it)
            }
        })

    }

}
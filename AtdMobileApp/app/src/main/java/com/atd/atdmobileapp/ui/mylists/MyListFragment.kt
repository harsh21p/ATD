package com.atd.atdmobileapp.ui.mylists

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentMyListBinding
import com.atd.atdmobileapp.models.mylist.Productlists
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdLogo
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.tvHeaderText
import com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment
import com.atd.atdmobileapp.utils.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyListFragment : Fragment() {

    private var themeColor: Int=R.color.black
    private var originalFilteredKey: String=""

    @Inject
    lateinit var sharedPrefManager:SharedPrefManager

    var _binding: FragmentMyListBinding?=null
    val binding get() = _binding!!
    lateinit var adapter:MyListAdapter
    private val viewModel by viewModels<MyListViewModel>()
    private var myListResponse: List<Productlists>?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding= FragmentMyListBinding.inflate(inflater,container,false)
        myListResponse= listOf()
        sharedPrefManager?.getLocationNumber()?.let {
            viewModel.getMyList(it)
        }
        setUpTheme()
        setUpUI()
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                onBackPressed()
            }
        })

        atdLogo?.setOnClickListener {
            onBackPressed()
        }


        binding.tvCreateList.setOnClickListener {
            addList()
        }

        binding.tvCreateAList.setOnClickListener {
            addList()
        }


        binding.ivSorting.setOnClickListener{
            val dialog = Dialog(requireActivity(),android.R.style.Theme_Light_NoTitleBar_Fullscreen)
            dialog.setContentView(R.layout.mylist_sorting)
            val rgListName= dialog.findViewById<RadioGroup>(R.id.rgListName)
            val aToz= dialog.findViewById<RadioButton>(R.id.rbAtoZ)
            val zToa= dialog.findViewById<RadioButton>(R.id.rbZtoA)
            val highTolow= dialog.findViewById<RadioButton>(R.id.rbHighToLow)
            val lowToHigh= dialog.findViewById<RadioButton>(R.id.rbLowToHigh)
            val cancel= dialog.findViewById<TextView>(R.id.btReset)
            val closeDialog= dialog.findViewById<ImageView>(R.id.closeDialog)
            val clearAll= dialog.findViewById<TextView>(R.id.tvClearAll)
            val apply= dialog.findViewById<TextView>(R.id.tvApprove)

            cancel.apply {
                isAllCaps=true
            }
            apply.apply {
                isAllCaps=true
            }
            cancel.text=Constants.CANCEL
            apply.text=Constants.APPLY
            cancel.isEnabled=true
            cancel.setTextColor(ContextCompat.getColor(requireActivity(),themeColor))
            clearAll.setTextColor(ContextCompat.getColor(requireActivity(),themeColor))
            closeDialog.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)

            if (originalFilteredKey.equals(resources.getString(R.string.atoz)))
            {
                aToz.isChecked=true
                aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }else if (originalFilteredKey.equals(resources.getString(R.string.ztoa))) {
                zToa.isChecked=true
                zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }else if (originalFilteredKey.equals(resources.getString(R.string.hightTolow))) {
                highTolow.isChecked=true
                highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }else if (originalFilteredKey.equals(resources.getString(R.string.lowToHigh))) {
                lowToHigh.isChecked=true
                lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
            }
             var checkedValue: String=""
            rgListName.setOnCheckedChangeListener(object : OnCheckedChangeListener{
                override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

                    apply.isEnabled=true
                    apply.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                    apply.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.white))

                    val radioButton = group?.findViewById(checkedId) as RadioButton
                    checkedValue = radioButton.text.toString().trim()

                    if (checkedValue.equals(resources.getString(R.string.atoz))){

                        myListResponse= myListResponse?.sortedBy { it.name }

                            aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                            zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)

                           }else if (checkedValue.equals(resources.getString(R.string.ztoa))){

                        myListResponse= myListResponse?.sortedByDescending { it.name }
                        aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                        highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)

                    }else if (checkedValue.equals(resources.getString(R.string.hightTolow))){

                        myListResponse= myListResponse?.sortedByDescending { it.products?.size }
                        aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
                        lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)

                    }else if (checkedValue.equals(resources.getString(R.string.lowToHigh))){

                        myListResponse= myListResponse?.sortedBy { it.products?.size }
                        aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                        lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)

                    }



                }
            })


            apply.setOnClickListener {
                originalFilteredKey=checkedValue
                updateData(myListResponse)
                dialog.dismiss()
            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            closeDialog.setOnClickListener {
                dialog.dismiss()
            }
            clearAll.setOnClickListener {


                aToz.isChecked=false
                zToa.isChecked=false
                highTolow.isChecked=false
                lowToHigh.isChecked=false
                aToz.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                zToa.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                highTolow.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)
                lowToHigh.buttonTintList=ContextCompat.getColorStateList(requireActivity(),R.color.black)

                apply.isEnabled=false
                apply.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),R.color.disable_background)
                apply.setTextColor(ContextCompat.getColorStateList(requireActivity(),R.color.disableText))

            }

            dialog.show()
        }


        return binding.root
    }

    private fun addList() {
        val hostFragment = CreateMyListFragment()
        val arguments= Bundle()
        arguments.putString(Constants.KEY_TYPE,Constants.ADD)
        hostFragment.arguments=arguments
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.myListLiveData.observe(viewLifecycleOwner, Observer {

            when(it){
                is NetworkResult.Loading ->{

                    binding.progressbar.visible()
                }
                is NetworkResult.Success ->{
                    binding.progressbar.gone()

                    it?.data?.productlists?.let {

                        updateData(it)
                    }

                }
                is NetworkResult.Error ->{
                    binding.progressbar.gone()
                    errorToast(it.message)
                }
            }
        })
    }

    private fun updateData(myListResponse: List<Productlists>?) {


        if (myListResponse != null) {

            if (myListResponse.size >0) {
                this.myListResponse= myListResponse
                binding.tvCreateAList.gone()
                binding.tvNoList.gone()
                binding.ivNoList.gone()
                binding.ivSorting.visible()
                binding.tvCreateList.visible()
                binding.rvList.visible()
                adapter.updateData(myListResponse)
                adapter.notifyDataSetChanged()
            }else{
                binding.tvCreateAList.visible()
                binding.tvNoList.visible()
                binding.ivNoList.visible()
                binding.ivSorting.gone()
                binding.tvCreateList.gone()
                binding.rvList.gone()
            }

        }

    }

    private fun setUpUI() {
        adapter= MyListAdapter(requireActivity(), arrayListOf(),sharedPrefManager,::MyListDetails)
        binding.rvList.layoutManager= LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        binding.rvList.adapter=adapter
    }

    fun MyListDetails(productlists: Productlists){

        val arguments= Bundle()
        arguments.putSerializable("productlists",productlists)
        val hostFragment = MyListDetailsFragment()
        hostFragment.arguments=arguments
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()

    }
    fun setUpTheme(){

        tvHeaderText?.text=requireActivity().resources.getString(R.string.my_lists)
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                themeColor=R.color.red
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_red_arrow, 0, 0, 0)
                binding.tvCreateList.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.baseline_add_24_tirepros,0)
                binding.ivSorting.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.sort_tirepros))


            }else if (it.equals("atdonline",true)){
                themeColor=R.color.atd_blue
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_arrow, 0, 0, 0)
                binding.tvCreateList.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.baseline_add_24,0)
                binding.ivSorting.setImageDrawable(ContextCompat.getDrawable(requireActivity(),R.drawable.sort))

            }else{

            }
        }
        binding.tvCreateAList.backgroundTintList=ContextCompat.getColorStateList(requireActivity(),themeColor)
        binding.tvCreateList.setTextColor(ContextCompat.getColorStateList(requireActivity(),themeColor))
    }

    private fun onBackPressed() {
        tvHeaderText?.text=""
        atdLogo?.setOnClickListener(null)
        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tp_mobile_logo, 0, 0, 0)

            }else if (it.equals("atdonline",true)){

                atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)

            }else{

            }
        val hostFragment = MyGarageFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottomNavigationViewFrame, hostFragment)
            .commit()
    }

    }

}
package com.atd.atdmobileapp.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentProductBinding
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.productsearch.Title
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment
import com.atd.atdmobileapp.ui.product.ProductAdapter
import com.atd.atdmobileapp.ui.product.ProductViewModel
import com.atd.atdmobileapp.ui.product.supplies.SuppliesFragment
import com.atd.atdmobileapp.ui.product.tirerepair.TireRepairFragment
import com.atd.atdmobileapp.ui.product.tires.TiresFragment
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel
import com.atd.atdmobileapp.ui.product.tools.ToolsFragment
import com.atd.atdmobileapp.ui.product.wheels.WheelsFragment
import com.atd.atdmobileapp.ui.product.wheelaccessories.WheelAccessoriesFragment
import com.atd.atdmobileapp.ui.product.wheelaccessories.WheelAccessoriesTypeFragment
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductFragment : Fragment() {


    var _binding : FragmentProductBinding?=null
    private val binding get() = _binding!!
    private lateinit var productAdapter : ProductAdapter
    private var objects : MutableList<Title> = mutableListOf()
    private val productViewModel by viewModels<ProductViewModel>()
    private var tiresFrag = TiresFragment()
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)

        BottomNavigationScreenFragment.tvHeaderText?.text= Constants.Product_Search
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener {
            BackPressed()
        }
        setUpTheme()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        visitProdSearchEvent()

        val title = arrayOf("Tires", "Wheels", "Wheel"+"\n"+"Accessories", "Supplies","Tubes &"+" \n"+"Flaps","Tire Repair","Tools")
        val icons = arrayOf(
            R.drawable.product_tire,
            R.drawable.product_wheel,
            R.drawable.product_wheel_acc ,
            R.drawable.product_supplies,
            R.drawable.product_tubes_flaps,
            R.drawable.product_tire_repair,
            R.drawable.product_tools
        )
        val iconSelectedList = arrayOf(
            R.drawable.product_tyre_selected,
            R.drawable.product_wheel_selected,
            R.drawable.product_wheel_acc_selected ,
            R.drawable.product_supplies_selected,
            R.drawable.product_tubes_flaps_selected,
            R.drawable.product_tire_repair_selected,
            R.drawable.product_tools_selected
        )

        for (i in title.indices) {
            val name = title[i]
            val icon = icons[i]
            val iconSelected = iconSelectedList[i]
            objects.add(Title(name, icon,iconSelected,false))
        }
        objects[0].isSelected = true
        productAdapter = ProductAdapter(::onTopTitleItemClicked)
        binding.rcProduct.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        productAdapter.submitList(objects)
        binding.rcProduct.adapter = productAdapter

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                BackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(), onBackPressedCallback
        )
        return binding.root
    }

    private fun setUpTheme() {

        if (BottomNavigationScreenFragment.theameColor==R.color.atd_blue) {
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.keyword_back,
                0,
                0,
                0
            )
        }else{
            BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.left_red_arrow,
                0,
                0,
                0
            )
        }

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

    private fun loadTireFrag() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragLayout, tiresFrag)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadTireFrag()
        productViewModel.getOtherBrands(BrandsRequest(sharedPrefManager.getLocationNumber().toString()))

    }

    private fun onTopTitleItemClicked(title: Title, position: Int, positionOfTitleSelected: Int) {
        //updating icon upon selection
        if (position!= positionOfTitleSelected) {
            objects[position].isSelected = true
            objects[positionOfTitleSelected].isSelected = false
            productAdapter.notifyItemChanged(positionOfTitleSelected)
            when (title.name) {
                getString(R.string.tires) -> {
                    // Code to execute when the title is "Tires"
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, tiresFrag)
                        .addToBackStack(null)
                        .commit()
                }
                getString(R.string.wheels) -> {
                    val wheelsFragment = WheelsFragment()
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, wheelsFragment)
                        .commit()
                    // Code to execute when the title is "Wheels"
                }
                getString(R.string.wheel) + "\n" + getString(R.string.acc) -> {
                    // Code to execute when the title is "Accessories"
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, WheelAccessoriesFragment())
                        .commit()
                }
                getString(R.string.supplies) -> {
                    // Code to execute when the title is "Supplies"
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, SuppliesFragment())
                        .commit()
                }
                getString(R.string.tube) + " \n" + getString(R.string.flaps) -> {
                    // Code to execute when the title is "Tubes & Flaps"
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, TubesAndFlapsFragment(), TubesAndFlapsFragment.TAG)
                        .commit()
                }
                getString(R.string.tire_repair) -> {
                    val tiresRepairFragment = TireRepairFragment()
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, tiresRepairFragment)
                        .commit()
                }
                getString(R.string.tools) -> {
                    val toolsFragment = ToolsFragment()
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragLayout, toolsFragment)
                        .commit()
                }
            }
        }

    }

    private fun visitProdSearchEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Product_Search,
            Category.Search_Criteria,
            Action.Impression,
            "View product search form"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Product_Search)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

}
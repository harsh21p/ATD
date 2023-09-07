package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentMyQuotsBinding
import com.atd.atdmobileapp.models.myordersdata.Orderstatuse
import com.atd.atdmobileapp.models.myquotes.MyQuotesData
import com.atd.atdmobileapp.models.myquotes.MyQuotesRequest
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.NetworkResult
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MyQuotsFragment : Fragment() {

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    lateinit var myQuotes :ArrayList<Orderstatuse>
     var _binding : FragmentMyQuotsBinding? = null
    val binding get() = _binding!!
    lateinit var   adapter : MyQuotesAdapter
    private val myOrdersViewModel by viewModels<MyQuotesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMyQuotsBinding.inflate(inflater,container,false)
        val view : View = binding.root

        if (theameColor == R.color.red) {
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
               theameColor
            ))

        val date = Date()
        var df = SimpleDateFormat("YYYY-MM-dd")
        val c1: Calendar = Calendar.getInstance()
        val currentDate: String = df.format(date) // get current date here


        // now add 30 day in Calendar instance

        // now add 30 day in Calendar instance
        c1.add(Calendar.DAY_OF_YEAR, -30)
        df = SimpleDateFormat("yyyy-MM-dd")
        val resultDate: Date = c1.getTime()
        val fromDate: String = df.format(resultDate)

        println("Date : "+currentDate+" - "+fromDate)
        myQuotes= arrayListOf()
        setupUI()
        sharedPrefManager?.getLocationNumber()?.let {

            val myOrderRequest = MyQuotesRequest()
            myOrderRequest.locationnumber=sharedPrefManager.getLocationNumber().toString()
            myOrderRequest.startdate=""
            myOrderRequest.enddate=""
            myOrdersViewModel.getMyQuotess(myOrderRequest)
            binding.progressbar.visibility = View.VISIBLE
        }




        return view
    }
    private fun setupUI() {
        adapter= MyQuotesAdapter(arrayListOf(),requireActivity())
        binding.rvMyQuotes.layoutManager = LinearLayoutManager(requireActivity(),
            RecyclerView.VERTICAL,false)
        binding.rvMyQuotes.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOrdersViewModel.myQuotesResponseLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResult.Success -> {
                    println("SUCCESS?????"+it.data)
                    binding.progressbar.visibility = View.GONE

                    it?.data?.let {

                            quotesData -> addQuotes(quotesData)

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
            binding.progressbar.visibility = View.VISIBLE
            adapter.viewAll(true)
            adapter.notifyDataSetChanged()
            binding.progressbar.visibility = View.GONE


        }
    }


    private fun addQuotes(quotesData: MyQuotesData) {

        quotesData?.retailquote?.let {
            if (it.size>0) {
                if (it.size > 3) {
                    binding.viewAll.visibility = View.VISIBLE
                } else {
                    binding.viewAll.visibility = View.GONE

                }
                adapter.addQuotes(it)
                adapter.notifyDataSetChanged()
            }else{
                binding.noData.visibility=View.VISIBLE
            }

        }

    }

    private fun onClickQuote(quote: Retailquote){

    }
}
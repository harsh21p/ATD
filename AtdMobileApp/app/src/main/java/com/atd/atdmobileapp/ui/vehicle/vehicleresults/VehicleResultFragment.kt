package com.atd.atdmobileapp.ui.vehicle.vehicleresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentVehicleResultBinding
import com.atd.atdmobileapp.utils.Constants

class VehicleResultFragment : Fragment() {

    private var _binding: FragmentVehicleResultBinding?= null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding =FragmentVehicleResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
      const val TAG = "VehicleResultFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments

        if (bundle != null) {
            println("Got data here as ->${bundle.getString(Constants.KEY_VEHICLE_SEARCH_RESULT_DATA,"Empty")}")
        }

    }
}
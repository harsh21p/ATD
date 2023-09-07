package com.atd.atdmobileapp.ui.selectlocation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.SelectLocationItemBinding
import com.atd.atdmobileapp.models.Location
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager

class SelectLocationAdapter(
    private val onSelectLocationClicked: (Location) -> Unit,
    private val prefManager: SharedPrefManager,
    private var selectedLocation: Location?
) : ListAdapter<Location, SelectLocationAdapter.SelectLocationHolder>(ComparatorDiffUtil()) {

    //private var selectedItem: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectLocationHolder {
        val binding = SelectLocationItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SelectLocationHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectLocationHolder, position: Int) {
        val location = getItem(position)
        location?.let {
            holder.bind(it, position)
        }
    }

    inner class SelectLocationHolder(private val binding: SelectLocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: Location, position: Int) {
            binding.tvLocationNameAndServingDc.text =
                location.locationname.plus(" | ").plus("#").plus(location.servicingdc)
            binding.tvLocationNumber.text = "#".plus(location.locationnumber)
            binding.tvLocationAddress.text = location.address.address1
            binding.tvCityStateZipcode.text =
                location.address.city.plus(" ").plus(location.address.state)
                    .plus(" ").plus(location.address.zipcode)

            binding.root.setOnClickListener {
                selectedLocation = location // Update the selectedLocation
                notifyDataSetChanged() // Notify adapter to update UI

                onSelectLocationClicked(location)
            }

            if (selectedLocation == location) {
                if (prefManager.getProfileSelected() == Constants.TIRE_PROS) {
                    binding.ivRadio.setImageResource(R.drawable.radio_selected_red)
                } else {
                    binding.ivRadio.setImageResource(R.drawable.radio_selected)
                }
            } else {
                binding.ivRadio.setImageResource(R.drawable.radio_unselected)
            }
        }
    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }
    }
}

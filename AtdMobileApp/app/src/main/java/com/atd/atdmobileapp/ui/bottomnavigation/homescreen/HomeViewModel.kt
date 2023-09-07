package com.atd.atdmobileapp.ui.bottomnavigation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.repository.LocationRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val locationRepository: LocationRepository) :ViewModel() {


    val locationResponseLiveData : LiveData<NetworkResult<DCDetails>>
        get() = locationRepository.DistributioncenterLiveData
    fun getLocation(dcNumber:String){
        viewModelScope.launch {
            locationRepository.getLocation(dcNumber)
        }
    }
}
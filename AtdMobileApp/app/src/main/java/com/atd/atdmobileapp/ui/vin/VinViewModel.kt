package com.atd.atdmobileapp.ui.vin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.repository.VehiclesRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VinViewModel @Inject constructor(private val vehiclesRepository: VehiclesRepository) :ViewModel(){

    private val handler = CoroutineExceptionHandler { _, exception ->
        vehiclesRepository._vinResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vinResponseLiveData : LiveData<NetworkResult<VinResponse>>
    get() = vehiclesRepository._vinResponseLiveData
    fun getVinDetails(fitmentid: String ){
        viewModelScope.launch(handler){
            vehiclesRepository.getVIN(fitmentid)
        }
    }

}
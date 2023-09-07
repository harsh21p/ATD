package com.atd.atdmobileapp.ui.licenceplate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.repository.VehiclesRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LicencePlateViewModel @Inject constructor(private val vehiclesRepository: VehiclesRepository) :ViewModel(){

    private val handler = CoroutineExceptionHandler { _, exception ->
        vehiclesRepository._licensePlateResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val licencePlateResponseLiveData : LiveData<NetworkResult<LicencePlateResponse>>
    get() = vehiclesRepository._licensePlateResponseLiveData

    fun getLicencePlateDetails(state: String,licencePlate: String ) {
        viewModelScope.launch(handler){
            vehiclesRepository.getLicencePlate(state,licencePlate)
        }

    }

}
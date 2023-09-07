package com.atd.atdmobileapp.ui.selectlocation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.SelectLocationResponse
import com.atd.atdmobileapp.repository.LocationRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class SelectLocationViewModel @Inject constructor(private val locationRepository: LocationRepository) :ViewModel() {


    private val handler = CoroutineExceptionHandler { _, exception ->
        selectedLocationLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val selectedLocationLiveData : MutableLiveData<NetworkResult<SelectLocationResponse>>
    get() = locationRepository.selectedLocationLiveData
    fun getLocationsToSave(){
        val rootObject = JSONObject()
        rootObject.put("criteria",JSONObject())
        viewModelScope.launch(handler) {
            locationRepository.getLocationsToSave(rootObject)
        }
    }

}
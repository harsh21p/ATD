package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.LocationApi
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.models.SelectLocationResponse
import com.atd.atdmobileapp.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(private val locationApi: LocationApi) {

    private val _DistributioncenterLiveData = MutableLiveData<NetworkResult<DCDetails>>()
    val DistributioncenterLiveData :LiveData<NetworkResult<DCDetails>>
    get() = _DistributioncenterLiveData

    val selectedLocationLiveData = MutableLiveData<NetworkResult<SelectLocationResponse>>()
    suspend fun getLocation(dcNumber:String){
        _DistributioncenterLiveData.postValue(NetworkResult.Loading())
        val response =locationApi.getLocations(dcNumber)
        handleResponse(response)
    }


    private fun handleResponse(response: Response<DCDetails>) {
        if (response.isSuccessful && response.body() != null) {
            _DistributioncenterLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _DistributioncenterLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _DistributioncenterLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getLocationsToSave(jsonBody :JSONObject){
        selectedLocationLiveData.postValue(NetworkResult.Loading())
        val response =locationApi.getLocationsToSave(jsonBody)
        if (response.isSuccessful && response.body() != null) {
            selectedLocationLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            selectedLocationLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            selectedLocationLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

}
package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.LocationApi
import com.atd.atdmobileapp.models.keywordsearch.CutOffTimesData
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class CutOffDateRepository @Inject constructor(private val locationApi: LocationApi) {

    private val _CutOffDatesLiveData = MutableLiveData<NetworkResult<CutOffTimesData>>()
    val cutOffDatesLiveData :LiveData<NetworkResult<CutOffTimesData>>
    get() = _CutOffDatesLiveData
    suspend fun getCutOffDates(locationNum:String){
        _CutOffDatesLiveData.postValue(NetworkResult.Loading())
        val response =locationApi.getCutOffTimes(locationNum)
        handleResponse(response)
    }


    private fun handleResponse(response: Response<CutOffTimesData>) {
        if (response.isSuccessful && response.body() != null) {
            _CutOffDatesLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _CutOffDatesLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _CutOffDatesLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
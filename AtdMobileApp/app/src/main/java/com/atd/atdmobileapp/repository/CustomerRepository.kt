package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.CustomerApi
import com.atd.atdmobileapp.models.CustomerDetailsResponse
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class CustomerRepository @Inject constructor(private val customerApi: CustomerApi) {

    private val _customerDetailsLiveData = MutableLiveData<NetworkResult<CustomerDetailsResponse>>()
    val customerDetailsLiveData :LiveData<NetworkResult<CustomerDetailsResponse>>
    get() = _customerDetailsLiveData
    suspend fun getCustomerDetails(locationNumber:String){
        _customerDetailsLiveData.postValue(NetworkResult.Loading())
        val response =customerApi.getCustomerDetails(locationNumber)
        handleResponse(response)
    }

   suspend fun handleResponse(response: Response<CustomerDetailsResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _customerDetailsLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            _customerDetailsLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            _customerDetailsLiveData.postValue(NetworkResult.Error("something went wrong"))
        }

    }
}
package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class MyOrderDetailsRepository @Inject constructor(private val myOrderApi: OrderApi ) {

    private val _OrderLiveData = MutableLiveData<NetworkResult<OrderDetailsResponse>>()
    val myOrderDetailsLiveData :LiveData<NetworkResult<OrderDetailsResponse>>
    get() = _OrderLiveData
    suspend fun getOrderDetails(myOrderRequest: OrderDetailsRequest){
        _OrderLiveData.postValue(NetworkResult.Loading())
        val response =myOrderApi.getOrderDetails(myOrderRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<OrderDetailsResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _OrderLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _OrderLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _OrderLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
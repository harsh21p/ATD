package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class OrderReturnAvailableDetailsRepository @Inject constructor(private val myOrderApi: OrderApi ) {

    private val _OrderLiveData = MutableLiveData<NetworkResult<ItemReturnAvailableResponse>>()
    val itemReturnAvailableData :LiveData<NetworkResult<ItemReturnAvailableResponse>>
    get() = _OrderLiveData
    suspend fun getOrderReturnDetails(myOrderRequest: ItemReturnAvailableDetailsRequest){
        _OrderLiveData.postValue(NetworkResult.Loading())
        val response =myOrderApi.getReturnDetails(myOrderRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<ItemReturnAvailableResponse>) {
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
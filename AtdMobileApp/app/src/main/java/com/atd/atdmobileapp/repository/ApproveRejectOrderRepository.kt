package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.approveorder.ApproveOrder
import com.atd.atdmobileapp.models.approveorder.ApproveResponse
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ApproveRejectOrderRepository @Inject constructor(private val myOrderApi: OrderApi ) {

    private val _ApproveOrderLiveData = MutableLiveData<NetworkResult<ApproveResponse>>()
    val myApproveOrderLiveData :LiveData<NetworkResult<ApproveResponse>>
    get() = _ApproveOrderLiveData
    suspend fun ApproveOrders(myOrderRequest: ApproveOrder){
        _ApproveOrderLiveData.postValue(NetworkResult.Loading())
       CoroutineScope(Dispatchers.IO).launch {

           val request =async(Dispatchers.IO) {
               myOrderApi.approveOrder(myOrderRequest)
           }
           handleResponse(request.await())
       }
    }

    private fun handleResponse(response: Response<ApproveResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _ApproveOrderLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _ApproveOrderLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _ApproveOrderLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class MyApprovalsRepository @Inject constructor(private val myOrderApi: OrderApi ) {

    private val _ApprovalLiveData = MutableLiveData<NetworkResult<MyApprovalsData>>()
    val myApprovalLiveData :LiveData<NetworkResult<MyApprovalsData>>
    get() = _ApprovalLiveData
    suspend fun getMyApproval(locationNumber: String){
        _ApprovalLiveData.postValue(NetworkResult.Loading())
        val response =myOrderApi.getMyApprovals(locationNumber)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<MyApprovalsData>) {
        if (response.isSuccessful && response.body() != null) {
            _ApprovalLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _ApprovalLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _ApprovalLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
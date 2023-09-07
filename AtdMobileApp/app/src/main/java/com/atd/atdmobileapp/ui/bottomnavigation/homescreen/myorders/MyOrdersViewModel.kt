package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.repository.MyOrderRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import org.json.JSONObject
import javax.inject.Inject
@HiltViewModel
class  MyOrdersViewModel @Inject constructor(private val myOrderRepository: MyOrderRepository) :ViewModel() {


    val myOrderResponseLiveData : LiveData<NetworkResult<MyOrdersData>>
        get() = myOrderRepository.myOrderLiveData

    val myOrderDateRangeResponseLiveData : LiveData<NetworkResult<MyOrdersData>>
        get() = myOrderRepository.myOrderDateRangeResponseLiveData
    fun getMyOrders(myOrderRequest: MyOrderRequest){
        viewModelScope.launch {
            myOrderRepository.getMyOrders(myOrderRequest)
        }
    }

    fun getDateRangeOrders(myOrderRequest: RequestBody){
        viewModelScope.launch {
            myOrderRepository.getDateRangeOrders(myOrderRequest)
        }
    }
}
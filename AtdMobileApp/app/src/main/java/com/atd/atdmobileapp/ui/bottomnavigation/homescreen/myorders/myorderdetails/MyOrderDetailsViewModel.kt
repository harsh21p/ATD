package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse
import com.atd.atdmobileapp.repository.MyOrderDetailsRepository
import com.atd.atdmobileapp.repository.OrderReturnAvailableDetailsRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyOrderDetailsViewModel @Inject constructor( val myOrderDetailsRepository: MyOrderDetailsRepository,val itemReturnAvailableResponse:OrderReturnAvailableDetailsRepository) : ViewModel() {

    val orderDetailsResponse : LiveData<NetworkResult<OrderDetailsResponse>>
    get() = myOrderDetailsRepository.myOrderDetailsLiveData

     val orderReturnAvalableLiveData : LiveData<NetworkResult<ItemReturnAvailableResponse>>
    get() = itemReturnAvailableResponse.itemReturnAvailableData
    fun getOrderDetails(myOrderRequest: OrderDetailsRequest){

        viewModelScope.launch {

            myOrderDetailsRepository.getOrderDetails(myOrderRequest)
        }
    }

     fun getOrderReturnDetails(myOrderRequest: ItemReturnAvailableDetailsRequest){

         viewModelScope.launch {
             itemReturnAvailableResponse.getOrderReturnDetails(myOrderRequest)
         }
    }
}
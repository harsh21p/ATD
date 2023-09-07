package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class MyOrderRepository @Inject constructor(private val myOrderApi: OrderApi) {

    private val _OrderLiveData = MutableLiveData<NetworkResult<MyOrdersData>>()
    private val _OrderDateRangeLiveData = MutableLiveData<NetworkResult<MyOrdersData>>()
    val myOrderLiveData: LiveData<NetworkResult<MyOrdersData>>
        get() =  _OrderLiveData

    val  myOrderDateRangeResponseLiveData : LiveData<NetworkResult<MyOrdersData>>
        get() = _OrderDateRangeLiveData
    val cartResponseLiveData = MutableLiveData<NetworkResult<CartResponse>>()
    private val _cartDetailsLiveData =
        MutableLiveData<NetworkResult<CartResponse>>()

    val cartDetailsLiveData: LiveData<NetworkResult<CartResponse>>
        get() = _cartDetailsLiveData

    private val _placeOrderFlow =
        MutableStateFlow<NetworkResult<CheckoutResponse>>(NetworkResult.Loading())
    val placeOrderFlow: StateFlow<NetworkResult<CheckoutResponse>>
        get() = _placeOrderFlow

    suspend fun getMyOrders(myOrderRequest: MyOrderRequest) {
        _OrderLiveData.postValue(NetworkResult.Loading())
        val response = myOrderApi.getMyOrders(myOrderRequest)
        handleResponse(response)
    }

    suspend fun getDateRangeOrders(myOrderRequest: RequestBody) {
        _OrderDateRangeLiveData.postValue(NetworkResult.Loading())
        val response = myOrderApi.getDateRangeOrders(myOrderRequest)
        handleDateRangeOrdersResponse(response)
    }
    private fun handleResponse(response: Response<MyOrdersData>) {
        if (response.isSuccessful && response.body() != null) {
            _OrderLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _OrderLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _OrderLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    private fun handleDateRangeOrdersResponse(response: Response<MyOrdersData>) {
        if (response.isSuccessful && response.body() != null) {
            _OrderDateRangeLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _OrderDateRangeLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _OrderDateRangeLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getCartDetails(cartRequest: CartRequest) {
        cartResponseLiveData.postValue(NetworkResult.Loading())
        val response = myOrderApi.getCartDetails(cartRequest)
        handleCartResponse(response)
    }

    private fun handleCartResponse(response: Response<CartResponse>) {
        if (response.isSuccessful && response.body() != null) {
            cartResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            cartResponseLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            cartResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getPreviewOrder(cartRequest: CartRequest) {
        _cartDetailsLiveData.postValue(NetworkResult.Loading())
        println("cart>>>>>"+cartRequest)
        val response = myOrderApi.getCartDetails(cartRequest)
        handleCartResponseFlow(response)
    }

    private suspend fun handleCartResponseFlow(response: Response<CartResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _cartDetailsLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _cartDetailsLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _cartDetailsLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun placeOrder(checkoutRequest: CheckoutRequest){
        _placeOrderFlow.emit(NetworkResult.Loading())
        val response = myOrderApi.placeOrder(checkoutRequest)
        handlePlaceOrderFlow(response)
    }


    private suspend fun handlePlaceOrderFlow(response: Response<CheckoutResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _placeOrderFlow.emit(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _placeOrderFlow.emit(NetworkResult.Error("There was an issue placing your order, please try again"))
        } else {
            _placeOrderFlow.emit(NetworkResult.Error("There was an issue placing your order, please try again"))
        }
    }

    suspend fun placeOrderWithDate(checkoutRequestWithDate: CheckoutRequestWithDate){
        _placeOrderFlow.emit(NetworkResult.Loading())
        val response = myOrderApi.placeOrderWithDate(checkoutRequestWithDate)
        handlePlaceOrderFlow(response)
    }


}
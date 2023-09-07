package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.DeliveriesApi
import com.atd.atdmobileapp.models.DeliveryDayRequest
import com.atd.atdmobileapp.models.DeliveryDaysResponse
import com.atd.atdmobileapp.models.ShippingMethodRequest
import com.atd.atdmobileapp.models.ShippingMethodResponse
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class DeliveriesRepository @Inject constructor(private val deliveriesApi: DeliveriesApi) {

    private val _shippingDetailsLiveData = MutableLiveData<NetworkResult<ShippingMethodResponse>>()
    val shippingDetailsLiveData :LiveData<NetworkResult<ShippingMethodResponse>>
    get() = _shippingDetailsLiveData

    private val _deliveryDaysLiveData = MutableLiveData<NetworkResult<DeliveryDaysResponse>>()
    val deliveryDaysLiveData :LiveData<NetworkResult<DeliveryDaysResponse>>
        get() = _deliveryDaysLiveData

    suspend fun getShippingDetails(shippingMethodRequest: ShippingMethodRequest){
        _shippingDetailsLiveData.postValue(NetworkResult.Loading())
        val response =deliveriesApi.getShippingDetails(shippingMethodRequest)
        handleResponse(response)
    }

    suspend fun handleResponse(response: Response<ShippingMethodResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _shippingDetailsLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            _shippingDetailsLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            _shippingDetailsLiveData.postValue(NetworkResult.Error("something went wrong"))
        }

    }

    suspend fun getDeliveryDays(deliveryDayRequest: DeliveryDayRequest){
        _deliveryDaysLiveData.postValue(NetworkResult.Loading())
        val response =deliveriesApi.getDeliveryDays(deliveryDayRequest)
        handleResponseDeliverDays(response)
    }

    suspend fun handleResponseDeliverDays(response: Response<DeliveryDaysResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _deliveryDaysLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            _deliveryDaysLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            _deliveryDaysLiveData.postValue(NetworkResult.Error("something went wrong"))
        }

    }


}
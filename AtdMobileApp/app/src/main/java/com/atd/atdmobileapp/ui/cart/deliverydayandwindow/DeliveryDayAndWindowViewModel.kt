package com.atd.atdmobileapp.ui.cart.deliverydayandwindow


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.repository.CustomerRepository
import com.atd.atdmobileapp.repository.DeliveriesRepository
import com.atd.atdmobileapp.repository.MyOrderRepository
import com.atd.atdmobileapp.utils.FirestoreRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeliveryDayAndWindowViewModel @Inject constructor(private val deliveriesRepository: DeliveriesRepository) : ViewModel() {


    val deliveryDaysLiveData =deliveriesRepository.deliveryDaysLiveData
    fun getDeliveryDays(deliveryDayRequest: DeliveryDayRequest){
        viewModelScope.launch() {
            deliveriesRepository.getDeliveryDays(deliveryDayRequest)
        }
    }
}
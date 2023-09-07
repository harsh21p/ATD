package com.atd.atdmobileapp.ui.cart.quantityanddelivery


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
class QuantityAndDeliveryViewModel @Inject constructor( private val deliveriesRepository: DeliveriesRepository,
                                                        private val customerRepository: CustomerRepository,
                                                        private val myOrderRepository: MyOrderRepository,
                                                        private val firestoreRepository: FirestoreRepository
) : ViewModel() {

    val  customerDetailsLiveData = customerRepository.customerDetailsLiveData
    val  shippingDetailsLiveData = deliveriesRepository.shippingDetailsLiveData
    val  cartDetailsLiveData = myOrderRepository.cartDetailsLiveData
    val deleteStatus: MutableLiveData<Boolean> = MutableLiveData()

    val updateFireStoreFlow: MutableStateFlow<NetworkResult<String>> = MutableStateFlow(NetworkResult.Loading())



    fun fetchDataParallelly(locationNumber: String, shippingMethodRequest: ShippingMethodRequest, cartRequest: CartRequest) {
        viewModelScope.launch() {
            val cartDetailsDeferred = async { myOrderRepository.getPreviewOrder(cartRequest) }
            val shippingDetailsDeferred = async { deliveriesRepository.getShippingDetails(shippingMethodRequest) }
            val customerDetailsDeferred = async { customerRepository.getCustomerDetails(locationNumber) }
            cartDetailsDeferred.await()
            shippingDetailsDeferred.await()
            customerDetailsDeferred.await()
        }
    }

    fun updateQuantity(cart: Cart, quantity: Int) {
        viewModelScope.launch {
            updateFireStoreFlow.emit(NetworkResult.Loading())
            try {
                firestoreRepository.updateCartQuantity(cart, quantity)
                updateFireStoreFlow.emit(NetworkResult.Success("success"))
            } catch (e: Exception) {
                updateFireStoreFlow.emit(NetworkResult.Error(e.message))
            }
        }
    }

    fun deleteRecord(documentName: String) {
        viewModelScope.launch {
            try {
                val success = firestoreRepository.deleteRecord(documentName)
                deleteStatus.postValue(success)
            } catch (e: Exception) {
                deleteStatus.postValue(false)
            }
        }
    }
}
package com.atd.atdmobileapp.ui.cart.checkout


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.api.OrderApi
import com.atd.atdmobileapp.models.CheckoutRequest
import com.atd.atdmobileapp.models.CheckoutRequestWithDate
import com.atd.atdmobileapp.models.DeleteCartItems
import com.atd.atdmobileapp.repository.MyOrderRepository
import com.atd.atdmobileapp.utils.FirestoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor( private val myOrderRepository: MyOrderRepository,private val firestoreRepository: FirestoreRepository) : ViewModel() {

    val  placeOrderFlow = myOrderRepository.placeOrderFlow
    val deleteStatus: MutableLiveData<Boolean> = MutableLiveData()
    fun placeOrder(checkoutRequest: CheckoutRequest){
        viewModelScope.launch {
            myOrderRepository.placeOrder(checkoutRequest)
        }
    }

    fun placeOrderWithDate(checkoutRequestWithDate: CheckoutRequestWithDate){
        viewModelScope.launch {
            myOrderRepository.placeOrderWithDate(checkoutRequestWithDate)
        }
    }

    fun deleteRecord(cartItemsToDelete: List<DeleteCartItems>) {
        viewModelScope.launch {
            try {
                for (cartItem in cartItemsToDelete) {
                    val documentName = "${cartItem.userName}-${cartItem.locationNumber}-${cartItem.atdproductnumber}"
                    val success = firestoreRepository.deleteRecord(documentName)
                    deleteStatus.postValue(success)
                }
            } catch (e: Exception) {
                deleteStatus.postValue(false)
            }
        }
    }
}
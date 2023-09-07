package com.atd.atdmobileapp.ui.cart


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.CartRequest
import com.atd.atdmobileapp.models.CartResponse
import com.atd.atdmobileapp.repository.MyOrderRepository
import com.atd.atdmobileapp.utils.FirestoreRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val firestoreRepository: FirestoreRepository, private val orderRepository: MyOrderRepository) :
    ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        cartResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val cartResponseLiveData : MutableLiveData<NetworkResult<CartResponse>>
    get() = orderRepository.cartResponseLiveData

    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val deleteStatus: MutableLiveData<Boolean> = MutableLiveData()
    val userLiveData = MutableLiveData<MutableList<Cart?>>()
    fun getCartDetails(cartRequest: CartRequest){
        viewModelScope.launch(handler) {
            orderRepository.getCartDetails(cartRequest)
        }
    }

    fun getAllCartRecords(userName :String, locationNumber :String) {
        viewModelScope.launch {
            try {
                loadingLiveData.postValue(true)
                val user = firestoreRepository.getRecordsBaseOnUserDetails(userName,locationNumber)
                println(">>>>"+user.size)
                userLiveData.postValue(user.toMutableList())
            }finally{
                loadingLiveData.postValue(false)
            }
        }
    }


    fun deleteUser(documentName: String) {
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
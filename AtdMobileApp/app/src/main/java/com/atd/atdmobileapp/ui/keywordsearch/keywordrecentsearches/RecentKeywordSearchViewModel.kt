package com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.repository.*
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.utils.FirestoreRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class  RecentKeywordSearchViewModel @Inject constructor(private val rdbKeywordSearchRepository: RDBKeywordSearchRepository,private val firestoreRepository: FirestoreRepository) :ViewModel() {


    val keywordResponseLiveData : LiveData<NetworkResult<List<PreviousKeywordSearchEntity>>>
        get() = rdbKeywordSearchRepository.productByKeywordResponse

    val userCartData = MutableLiveData<MutableList<Cart?>>()

    fun getMyKeywords(){
        viewModelScope.launch {
            rdbKeywordSearchRepository.getKeywordResp()
        }
    }

    fun saveKeyword(Keyword: PreviousKeywordSearchEntity){

        viewModelScope.launch {
            rdbKeywordSearchRepository.saveKeyword(Keyword)
        }
    }

    fun createCartRecordInFireStore(cart: Cart) {
        viewModelScope.launch {
            firestoreRepository.createCart(cart)
        }
    }

    fun getCreatedCartRecordInFireStore(cart: Cart) : LiveData<MutableList<Cart?>> {

        viewModelScope.launch {
            firestoreRepository.createCart(cart)
        }

        return getAllCartRecords()
    }
    fun getAllCartRecords() : LiveData<MutableList<Cart?>> {
        val userLiveData = MutableLiveData<MutableList<Cart?>>()
        viewModelScope.launch {
            delay(2000)
            val user = firestoreRepository.getRecords()
            userLiveData.postValue(user.toMutableList())

        }
        return userLiveData
    }


}
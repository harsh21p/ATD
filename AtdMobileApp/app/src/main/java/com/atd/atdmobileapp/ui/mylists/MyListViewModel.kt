package com.atd.atdmobileapp.ui.mylists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.mylist.CreateListRequest
import com.atd.atdmobileapp.models.mylist.DeleteItemResp
import com.atd.atdmobileapp.models.mylist.MyListResponse
import com.atd.atdmobileapp.repository.*
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import javax.inject.Inject
@HiltViewModel
class MyListViewModel @Inject constructor(private val Repository: MyListRepository) :ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        Repository._myListResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }

    private val deleteHandler = CoroutineExceptionHandler { _, exception ->
        Repository._deleteResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }

    val deleteItemResponse : LiveData<NetworkResult<DeleteItemResp>>
    get() = Repository.deleteResponseLiveData

    val myListLiveData : LiveData<NetworkResult<MyListResponse>>
        get() = Repository.myListResponseLiveData
    fun getMyList(locationNumber: String){
        viewModelScope.launch(handler) {
            Repository.getMyList(locationNumber)
        }
    }

     fun saveMyList(location: String,request : CreateListRequest) : LiveData<NetworkResult<MyListResponse>> {


        viewModelScope.launch(handler) {
            Repository.saveMyList(location,request)
        }

        return myListLiveData
    }

    fun updateMyList(location: String, listName: String, request: MyListResponse) : LiveData<NetworkResult<MyListResponse>> {


        viewModelScope.launch(handler) {
            Repository.updateMyList(location,listName,request)
        }

        return myListLiveData
    }

     fun deleteItemFromList(location: String, listName: String, productNumber: String):LiveData<NetworkResult<DeleteItemResp>>{

         viewModelScope.launch(deleteHandler) {
             Repository.DeleteItemFromList(location,listName,productNumber)
         }

         return deleteItemResponse
    }

    fun deleteList(location: String, listName: String):LiveData<NetworkResult<DeleteItemResp>>{

        viewModelScope.launch(deleteHandler) {
            Repository.deleteList(location,listName)
        }

        return deleteItemResponse
    }
}
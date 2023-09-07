package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.ListApi
import com.atd.atdmobileapp.models.ErrorResponse
import com.atd.atdmobileapp.models.mylist.CreateListRequest
import com.atd.atdmobileapp.models.mylist.DeleteItemResp
import com.atd.atdmobileapp.models.mylist.MyListResponse
import com.atd.atdmobileapp.utils.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class MyListRepository @Inject constructor(private val listApi: ListApi) {

    val _myListResponseLiveData = MutableLiveData<NetworkResult<MyListResponse>>()
    val myListResponseLiveData :LiveData<NetworkResult<MyListResponse>>
    get() = _myListResponseLiveData

    val _deleteResponseLiveData = MutableLiveData<NetworkResult<DeleteItemResp>>()
    val deleteResponseLiveData :LiveData<NetworkResult<DeleteItemResp>>
        get() = _deleteResponseLiveData
    suspend fun getMyList(location: String){
        _myListResponseLiveData.postValue(NetworkResult.Loading())
        val response =listApi.getList(location)
        handleResponse(response)
    }

    suspend fun saveMyList(location: String,request : CreateListRequest){

        _myListResponseLiveData.postValue(NetworkResult.Loading())
        CoroutineScope(Dispatchers.IO).launch {
            val response= async(Dispatchers.IO) { listApi.saveList(location,request) }
            handleSavedResponse(response.await())
        }
    }

    suspend fun updateMyList(location: String, listName: String, request: MyListResponse){

        _myListResponseLiveData.postValue(NetworkResult.Loading())
        CoroutineScope(Dispatchers.IO).launch {
            val response= async(Dispatchers.IO) { listApi.updateList(location,listName,request) }
            handleUpdateResponse(response.await())
        }
    }
    suspend fun DeleteItemFromList(location: String, listName: String, productNumber: String){

        _deleteResponseLiveData.postValue(NetworkResult.Loading())
        CoroutineScope(Dispatchers.IO).launch {
            val response= async(Dispatchers.IO) { listApi.DeleteItemFromList(location,listName,productNumber) }
            handleDeleteResponse(response.await())
        }
    }

    suspend fun deleteList(location: String, listName: String){

        _deleteResponseLiveData.postValue(NetworkResult.Loading())
        CoroutineScope(Dispatchers.IO).launch {
            val response= async(Dispatchers.IO) { listApi.deleteList(location,listName) }
            handleDeleteResponse(response.await())
        }
    }

    private fun handleDeleteResponse(response: Response<DeleteItemResp>) {
        if (response.isSuccessful && response.body() != null) {

          /*  val res= JSONObject(response.body()!!.charStream().toString())
            res.getBoolean("listproductdeleted")*/
            _deleteResponseLiveData.postValue(NetworkResult.Success(response.body()))

        } else if (response.errorBody() != null) {

            if (response.code()===400) {
                val errorResponse = Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                _deleteResponseLiveData.postValue(NetworkResult.Error(errorResponse.errorMessage))
            }else{
                _deleteResponseLiveData.postValue(NetworkResult.Error("something went wrong"))

            }
        } else {
            _deleteResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    private fun handleUpdateResponse(response: Response<MyListResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _myListResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {

            if (response.code()===400) {
                val errorResponse = Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                _myListResponseLiveData.postValue(NetworkResult.Error(errorResponse.errorMessage))
            }else{
                _myListResponseLiveData.postValue(NetworkResult.Error("something went wrong"))

            }
        } else {
            _myListResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    private fun handleSavedResponse(response: Response<MyListResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _myListResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {

            if (response.code()===400) {
                val errorResponse = Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                _myListResponseLiveData.postValue(NetworkResult.Error("A list with the same name already exists Please choose another name."))
            }else{
                _myListResponseLiveData.postValue(NetworkResult.Error("something went wrong"))

            }
        } else {
            _myListResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    private fun handleResponse(response: Response<MyListResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _myListResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {

                val errorResponse = Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
                _myListResponseLiveData.postValue(NetworkResult.Error(errorResponse.errorMessage))

        } else {
            _myListResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
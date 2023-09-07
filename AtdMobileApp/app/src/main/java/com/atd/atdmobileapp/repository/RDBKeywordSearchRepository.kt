package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class RDBKeywordSearchRepository @Inject constructor(val dao : PreviousKeywordSearchDAO) {


    fun saveKeyword(Keyword: PreviousKeywordSearchEntity) = CoroutineScope(Dispatchers.IO).launch{dao.Insert(Keyword)}

    fun updateKeyword(Keyword: PreviousKeywordSearchEntity) = dao.Update(Keyword)


    private val _productByKeywordResponseLiveData = MutableLiveData<NetworkResult<List<PreviousKeywordSearchEntity>>>()
    val productByKeywordResponse : LiveData<NetworkResult<List<PreviousKeywordSearchEntity>>>
        get() = _productByKeywordResponseLiveData
    suspend fun getKeywordResp(){
        CoroutineScope(Dispatchers.IO).launch{

            _productByKeywordResponseLiveData.postValue(NetworkResult.Loading())
            val response = async(Dispatchers.IO) {
                dao.getKeyWordList()
            }
            handleResponse(response.await())
        }

    }
    private fun handleResponse(response: List<PreviousKeywordSearchEntity>) {
        if (response != null) {
            _productByKeywordResponseLiveData.postValue(NetworkResult.Success(response))
        }  else {
            _productByKeywordResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

}
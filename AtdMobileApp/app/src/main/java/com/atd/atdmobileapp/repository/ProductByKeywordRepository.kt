package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.ProductsApi
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ProductByKeywordRepository @Inject constructor(private val productApi: ProductsApi) {

    private val _productByKeywordResponseLiveData = MutableLiveData<NetworkResult<ProductByKeywordResponse>>()
    val productByKeywordResponse :LiveData<NetworkResult<ProductByKeywordResponse>>
    get() = _productByKeywordResponseLiveData
    suspend fun getProductByKeyword(productByKeywordRequest: ProductByKeywordRequest){
        _productByKeywordResponseLiveData.postValue(NetworkResult.Loading())
        CoroutineScope(Dispatchers.IO).launch {
            val response =async(Dispatchers.IO) {  productApi.getProductByKeyword(productByKeywordRequest) }
            handleResponse(response.await())
        }

    }


    private fun handleResponse(response: Response<ProductByKeywordResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _productByKeywordResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _productByKeywordResponseLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _productByKeywordResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
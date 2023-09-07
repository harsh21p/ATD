package com.atd.atdmobileapp.repository

import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.ProductsApi
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class ProductByCriteriaRepository @Inject constructor(private val productApi: ProductsApi) {
    val _productByCriteriaResponseLiveData = MutableLiveData<NetworkResult<ProductByKeywordResponse>>()
    suspend fun getProductByCriteria(productByCriteriaRequest: ProductByCriteriaRequest){
        _productByCriteriaResponseLiveData.postValue(NetworkResult.Loading())
        val response = productApi.getProductByCriteria(productByCriteriaRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<ProductByKeywordResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

}
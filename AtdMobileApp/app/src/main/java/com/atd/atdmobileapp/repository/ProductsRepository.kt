package com.atd.atdmobileapp.repository


import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.ProductsApi
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.BrandsResponse
import com.atd.atdmobileapp.models.ErrorResponse
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.utils.NetworkResult
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsApi: ProductsApi) {

     val tiresBrandsLiveData = MutableLiveData<NetworkResult<BrandsResponse>>()
    suspend fun getBrandsForTires(brandsRequest: BrandsRequest){
        tiresBrandsLiveData.postValue(NetworkResult.Loading())
        val response =productsApi.getBrandsForTires(brandsRequest)
        handleBrandsResponse(response)
    }

    private fun handleBrandsResponse(response: Response<BrandsResponse>) {
            if (response.isSuccessful && response.body() != null) {
                tiresBrandsLiveData.postValue(NetworkResult.Success(response.body()))
            } else if (response.errorBody() != null) {
                tiresBrandsLiveData.postValue(NetworkResult.Error("something went wrong"))
            } else if (response.body() == null) {
                tiresBrandsLiveData.postValue(NetworkResult.Error("something went wrong"))
            }

    }

    val _productByCriteriaResponseLiveData = MutableLiveData<NetworkResult<ProductByKeywordResponse>>()
    suspend fun getProductByCriteria(productByCriteriaRequest: ProductByCriteriaRequest){
        _productByCriteriaResponseLiveData.postValue(NetworkResult.Loading())
        val response = productsApi.getProductByCriteria(productByCriteriaRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<ProductByKeywordResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorResponse = Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Error(errorResponse.errorMessage))

        } else {
            _productByCriteriaResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }


}
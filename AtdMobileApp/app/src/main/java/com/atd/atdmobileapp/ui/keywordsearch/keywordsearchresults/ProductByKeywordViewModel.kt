package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.repository.*
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductByKeywordViewModel @Inject constructor(private val Repository: ProductByKeywordRepository) :ViewModel() {


    val productByKeywordLiveData : LiveData<NetworkResult<ProductByKeywordResponse>>
        get() = Repository.productByKeywordResponse
    fun getProductByKeyword(productByKeywordRequest: ProductByKeywordRequest){
        viewModelScope.launch {
            Repository.getProductByKeyword(productByKeywordRequest)
        }
    }

    fun getProductByKeywordWithResults(productByKeywordRequest: ProductByKeywordRequest) :  LiveData<NetworkResult<ProductByKeywordResponse>>{
        viewModelScope.launch {
            Repository.getProductByKeyword(productByKeywordRequest)
        }

        return productByKeywordLiveData
    }
}
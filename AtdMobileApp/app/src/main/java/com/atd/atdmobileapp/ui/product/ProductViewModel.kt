package com.atd.atdmobileapp.ui.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.BrandsResponse
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import com.atd.atdmobileapp.repository.ProductsRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productsRepository: ProductsRepository) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        productByCriteriaResponse.postValue(NetworkResult.Error(exception.message))
    }

    val productByCriteriaResponse : MutableLiveData<NetworkResult<ProductByKeywordResponse>>
        get() = productsRepository._productByCriteriaResponseLiveData

    val brandsLiveData : MutableLiveData<NetworkResult<BrandsResponse>>
        get() = productsRepository.tiresBrandsLiveData



    fun getProductByCriteria(productByCriteriaRequest: ProductByCriteriaRequest){
        viewModelScope.launch {
            productsRepository.getProductByCriteria(productByCriteriaRequest)
        }
    }

    fun getOtherBrands(brandsRequest: BrandsRequest){
        viewModelScope.launch(handler) {
            productsRepository.getBrandsForTires(brandsRequest)
        }
    }

}
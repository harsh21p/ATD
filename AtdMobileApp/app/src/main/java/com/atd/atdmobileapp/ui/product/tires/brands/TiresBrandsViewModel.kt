package com.atd.atdmobileapp.ui.product.tires.brands

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.BrandsResponse
import com.atd.atdmobileapp.models.locationconfig.Locationconfiguration
import com.atd.atdmobileapp.repository.LocationConfigurationRepository
import com.atd.atdmobileapp.repository.ProductsRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class TiresBrandsViewModel @Inject constructor(private val productsRepository: ProductsRepository, private val locationConfigurationRepository: LocationConfigurationRepository ) :ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        tiresBrandsLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val tiresBrandsLiveData : MutableLiveData<NetworkResult<BrandsResponse>>
    get() = productsRepository.tiresBrandsLiveData

    val preferredBrandsLiveData : MutableLiveData<NetworkResult<List<Locationconfiguration>>>
        get() = locationConfigurationRepository.preferredBrandsLiveData
    fun getOtherBrands(brandsRequest: BrandsRequest){
        viewModelScope.launch(handler) {
            productsRepository.getBrandsForTires(brandsRequest)
        }
    }

    fun getPreferredBrandConfigurationList(){
        viewModelScope.launch(Dispatchers.IO) {
            locationConfigurationRepository.getPreferredBrandConfigurationList()
        }
    }

}
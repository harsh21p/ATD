package com.atd.atdmobileapp.ui.bottomnavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.Cart
import com.atd.atdmobileapp.models.keywordsearch.CutOffTimesData
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse
import com.atd.atdmobileapp.repository.ConfigLocationRepository
import com.atd.atdmobileapp.repository.CutOffDateRepository
import com.atd.atdmobileapp.utils.FirestoreRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigLocationViewModel @Inject constructor(private val configLocationRepository: ConfigLocationRepository,
                                                  private val firestoreRepository: FirestoreRepository,
                                                  private val cutOffDateRepository: CutOffDateRepository) : ViewModel() {

    val configLocationLivedata : LiveData<NetworkResult<ConfigLocationResponse>>
    get() = configLocationRepository.configLocationsResponse

    val cutOffDatesResponseLiveData : LiveData<NetworkResult<CutOffTimesData>>
        get() = cutOffDateRepository.cutOffDatesLiveData

    fun ConfigLocations(configLocationRequest: ConfigLocationRequest){

        viewModelScope.launch {
            configLocationRepository.getConfigLocations(configLocationRequest)
        }
    }

    fun getAllCartRecords() : LiveData<MutableList<Cart?>> {
        val userLiveData = MutableLiveData<MutableList<Cart?>>()
        viewModelScope.launch {
                val user = firestoreRepository.getRecords()
                userLiveData.postValue(user.toMutableList())
        }
        return userLiveData
    }

    fun getMyOrders(locationNum: String){
        viewModelScope.launch {
            cutOffDateRepository.getCutOffDates(locationNum)
        }
    }

}
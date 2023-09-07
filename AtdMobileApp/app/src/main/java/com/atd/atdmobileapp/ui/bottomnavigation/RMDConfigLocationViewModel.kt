package com.atd.atdmobileapp.ui.bottomnavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse
import com.atd.atdmobileapp.repository.*
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class  RMDConfigLocationViewModel @Inject constructor(private val rdbConfigLocationsRepository: RDBConfigLocationsRepository) :ViewModel() {


    val keywordResponseLiveData : LiveData<NetworkResult<List<ConfigLocationEntity>>>
        get() = rdbConfigLocationsRepository.configLocationResponse
    fun getMyKeywords(){
        viewModelScope.launch {
            rdbConfigLocationsRepository.getConfigLocationResp()
        }
    }

    fun saveConfigLocation(entity: ConfigLocationResponse){

        viewModelScope.launch {
            rdbConfigLocationsRepository.saveConfigLocations(entity)
        }
    }
}
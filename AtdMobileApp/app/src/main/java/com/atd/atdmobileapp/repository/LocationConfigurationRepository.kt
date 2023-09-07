package com.atd.atdmobileapp.repository

import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.models.locationconfig.Locationconfiguration
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO
import com.atd.atdmobileapp.utils.NetworkResult
import javax.inject.Inject

class LocationConfigurationRepository @Inject constructor( private val configLocationsDAO: ConfigLocationsDAO) {

    val preferredBrandsLiveData = MutableLiveData<NetworkResult<List<Locationconfiguration>>>()
    suspend fun getPreferredBrandConfigurationList(){
        val response =configLocationsDAO.getPreferredBrandConfigurationList()
        preferredBrandsLiveData.postValue(NetworkResult.Success(response))
    }
}
package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class RDBConfigLocationsRepository @Inject constructor(val dao : ConfigLocationsDAO) {


    fun saveConfigLocations(location: ConfigLocationResponse)
        {
            CoroutineScope(Dispatchers.IO).launch {

                location?.locationconfigurations?.map {
                    var configLocationEntity = ConfigLocationEntity()
                    configLocationEntity.configuration=it.configuration
                    configLocationEntity.value=it.value
                    dao.Insert(configLocationEntity)
                }

            }
        }

   // fun updateKeyword(Keyword: ConfigLocationEntity) = dao.Update(Keyword)


    private val _ConfigLocationResponseLiveData = MutableLiveData<NetworkResult<List<ConfigLocationEntity>>>()
    val configLocationResponse : LiveData<NetworkResult<List<ConfigLocationEntity>>>
        get() = _ConfigLocationResponseLiveData
    
    suspend fun getConfigLocationResp(){
        CoroutineScope(Dispatchers.IO).launch{

            _ConfigLocationResponseLiveData.postValue(NetworkResult.Loading())
            val response = async(Dispatchers.IO) {
                dao.getConfigLocationList()
            }
            handleResponse(response.await())
        }

    }
    private fun handleResponse(response: List<ConfigLocationEntity>) {
        if (response != null) {
            _ConfigLocationResponseLiveData.postValue(NetworkResult.Success(response))
        }  else {
            _ConfigLocationResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

}
package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.UserApi
import com.atd.atdmobileapp.models.UserResponse
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi) {

     val userResponseLiveData = MutableLiveData<NetworkResult<UserResponse>>()

    private val _configLocationsResponseLiveData = MutableLiveData<NetworkResult<ConfigLocationResponse>>()
    val configLocationsResponse :LiveData<NetworkResult<ConfigLocationResponse>>
        get() = _configLocationsResponseLiveData
    suspend fun loginUser(userName:String){
        userResponseLiveData.postValue(NetworkResult.Loading())
        val response =userApi.login(userName)
        handleResponse(response)
    }
    suspend fun getConfigLocations(location:ConfigLocationRequest){
        _configLocationsResponseLiveData.postValue(NetworkResult.Loading())
        val response =userApi.getLocationsConfigure(location)
        handleConfigLocationResponse(response)
    }



    private fun handleResponse(response: Response<UserResponse>) {
            if (response.isSuccessful && response.body() != null) {
                userResponseLiveData.postValue(NetworkResult.Success(response.body()))
            } else if (response.errorBody() != null) {
                println("Login Error ${response.code()} ${response.message()}")
                userResponseLiveData.postValue(NetworkResult.Error("${response.code()} ${response.message()}"))
            } else if (response.body() == null) {
                userResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
            }

    }

    private fun handleConfigLocationResponse(response: Response<ConfigLocationResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _configLocationsResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            _configLocationsResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            _configLocationsResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }

    }
}
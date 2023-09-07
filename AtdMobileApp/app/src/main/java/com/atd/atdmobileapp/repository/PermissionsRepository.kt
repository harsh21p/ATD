package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class PermissionsRepository @Inject constructor(private val permissionsDAO: PermissionsDAO) {

    val permissionsLiveData = MutableLiveData<NetworkResult<String>>()
    val _permissionsLiveData : LiveData<NetworkResult<String>>
        get() = permissionsLiveData
    suspend fun getCheckPermission(profileSelected: String, filter: String) {
        val response = permissionsDAO.getApprovePermission(filter,profileSelected)
        permissionCheckResponse(response)
        permissionsLiveData.postValue(NetworkResult.Success(response))
    }
    private fun permissionCheckResponse(response: String) {
        if (response != null) {
            permissionsLiveData.postValue(NetworkResult.Success(response))
        }  else {
            permissionsLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    fun savePermissions(permission: PermissionEntity) = CoroutineScope(Dispatchers.IO).launch{permissionsDAO.Insert(permission)}


    private val _permissionsListLiveData = MutableLiveData<NetworkResult<List<PermissionEntity>>>()
    val permissionsListLiveData : LiveData<NetworkResult<List<PermissionEntity>>>
        get() = _permissionsListLiveData
    suspend fun getPermissions(){
        CoroutineScope(Dispatchers.IO).launch{

            _permissionsListLiveData.postValue(NetworkResult.Loading())
            val response = async(Dispatchers.IO) {
                permissionsDAO.getPermissions()
            }
            handleResponse(response.await())
        }

    }
    private fun handleResponse(response: List<PermissionEntity>) {
        if (response != null) {
            _permissionsListLiveData.postValue(NetworkResult.Success(response))
        }  else {
            _permissionsListLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }


    suspend fun deletePermissions(){

           permissionsDAO.deleteAll()


    }
}
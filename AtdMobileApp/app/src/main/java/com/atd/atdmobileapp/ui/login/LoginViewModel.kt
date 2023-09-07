package com.atd.atdmobileapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.UserResponse
import com.atd.atdmobileapp.repository.PermissionsRepository
import com.atd.atdmobileapp.repository.UserRepository
import com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository,private val permissionsRepository: PermissionsRepository, val atdRoomDatabase: ATDRoomDatabase) :ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        userResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val userResponseLiveData : MutableLiveData<NetworkResult<UserResponse>>
    get() = userRepository.userResponseLiveData

    val checkPermission : LiveData<NetworkResult<String>>
    get()=permissionsRepository._permissionsLiveData

    val permissionList : LiveData<NetworkResult<List<PermissionEntity>>>
        get()=permissionsRepository.permissionsListLiveData
    fun loginUser(userName:String){
        viewModelScope.launch(handler) {
            userRepository.loginUser(userName)
        }
    }

    fun getCheckPermission(profileSelected: String, filter: String) {
        viewModelScope.launch(handler) {
            permissionsRepository.getCheckPermission(profileSelected,filter)
        }
    }
    fun getPermissionList(){
        viewModelScope.launch(handler) {
            permissionsRepository.getPermissions()
        }
    }

    //permissionsListLiveData
    fun savePermissions(permission: PermissionEntity){

        viewModelScope.launch(handler) {
            permissionsRepository.savePermissions(permission)
        }
    }


    fun deleteRoomDatabase(){
        viewModelScope.launch(handler) {
            atdRoomDatabase.clearTables()
        }
    }

}
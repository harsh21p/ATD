package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.repository.MyApprovalsRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MyApprovalsViewModel @Inject constructor(private val myOrderRepository: MyApprovalsRepository) :ViewModel() {


    val myApprovalResponseLiveData : LiveData<NetworkResult<MyApprovalsData>>
        get() = myOrderRepository.myApprovalLiveData
    fun getMyApprovals(locationNumber: String){
        viewModelScope.launch {
            myOrderRepository.getMyApproval(locationNumber)
        }
    }
}
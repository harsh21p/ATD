package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.approveorder.ApproveOrder
import com.atd.atdmobileapp.models.approveorder.ApproveResponse
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.repository.ApproveRejectOrderRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubmitApprovalsViewModel @Inject constructor(val approveRejectOrderRepository: ApproveRejectOrderRepository) : ViewModel() {

    val myApprovalResponseLiveData : LiveData<NetworkResult<ApproveResponse>>
        get() = approveRejectOrderRepository.myApproveOrderLiveData
    fun ApproveOrder(approveOrder: ApproveOrder) : LiveData<NetworkResult<ApproveResponse>>{
        viewModelScope.launch {
            approveRejectOrderRepository.ApproveOrders(approveOrder)
        }

        return myApprovalResponseLiveData
    }
}
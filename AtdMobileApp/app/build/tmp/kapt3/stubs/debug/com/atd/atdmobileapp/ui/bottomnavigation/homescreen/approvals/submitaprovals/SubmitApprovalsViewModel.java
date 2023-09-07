package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/SubmitApprovalsViewModel;", "Landroidx/lifecycle/ViewModel;", "approveRejectOrderRepository", "Lcom/atd/atdmobileapp/repository/ApproveRejectOrderRepository;", "(Lcom/atd/atdmobileapp/repository/ApproveRejectOrderRepository;)V", "getApproveRejectOrderRepository", "()Lcom/atd/atdmobileapp/repository/ApproveRejectOrderRepository;", "myApprovalResponseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/approveorder/ApproveResponse;", "getMyApprovalResponseLiveData", "()Landroidx/lifecycle/LiveData;", "ApproveOrder", "approveOrder", "Lcom/atd/atdmobileapp/models/approveorder/ApproveOrder;", "app_debug"})
public final class SubmitApprovalsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.repository.ApproveRejectOrderRepository approveRejectOrderRepository = null;
    
    @javax.inject.Inject
    public SubmitApprovalsViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.ApproveRejectOrderRepository approveRejectOrderRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.repository.ApproveRejectOrderRepository getApproveRejectOrderRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.approveorder.ApproveResponse>> getMyApprovalResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.approveorder.ApproveResponse>> ApproveOrder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.approveorder.ApproveOrder approveOrder) {
        return null;
    }
}
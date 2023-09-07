package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersViewModel;", "Landroidx/lifecycle/ViewModel;", "myOrderRepository", "Lcom/atd/atdmobileapp/repository/MyOrderRepository;", "(Lcom/atd/atdmobileapp/repository/MyOrderRepository;)V", "myOrderDateRangeResponseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrdersData;", "getMyOrderDateRangeResponseLiveData", "()Landroidx/lifecycle/LiveData;", "myOrderResponseLiveData", "getMyOrderResponseLiveData", "getDateRangeOrders", "", "myOrderRequest", "Lokhttp3/RequestBody;", "getMyOrders", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrderRequest;", "app_debug"})
public final class MyOrdersViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository = null;
    
    @javax.inject.Inject
    public MyOrdersViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> getMyOrderResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> getMyOrderDateRangeResponseLiveData() {
        return null;
    }
    
    public final void getMyOrders(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myordersdata.MyOrderRequest myOrderRequest) {
    }
    
    public final void getDateRangeOrders(@org.jetbrains.annotations.NotNull
    okhttp3.RequestBody myOrderRequest) {
    }
}
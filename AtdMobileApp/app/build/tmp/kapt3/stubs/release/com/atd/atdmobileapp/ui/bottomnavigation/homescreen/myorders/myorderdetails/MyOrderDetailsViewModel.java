package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/myorderdetails/MyOrderDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "myOrderDetailsRepository", "Lcom/atd/atdmobileapp/repository/MyOrderDetailsRepository;", "itemReturnAvailableResponse", "Lcom/atd/atdmobileapp/repository/OrderReturnAvailableDetailsRepository;", "(Lcom/atd/atdmobileapp/repository/MyOrderDetailsRepository;Lcom/atd/atdmobileapp/repository/OrderReturnAvailableDetailsRepository;)V", "getItemReturnAvailableResponse", "()Lcom/atd/atdmobileapp/repository/OrderReturnAvailableDetailsRepository;", "getMyOrderDetailsRepository", "()Lcom/atd/atdmobileapp/repository/MyOrderDetailsRepository;", "orderDetailsResponse", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/orderdetails/OrderDetailsResponse;", "getOrderDetailsResponse", "()Landroidx/lifecycle/LiveData;", "orderReturnAvalableLiveData", "Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableResponse;", "getOrderReturnAvalableLiveData", "getOrderDetails", "", "myOrderRequest", "Lcom/atd/atdmobileapp/models/orderdetails/OrderDetailsRequest;", "getOrderReturnDetails", "Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableDetailsRequest;", "app_release"})
public final class MyOrderDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.repository.MyOrderDetailsRepository myOrderDetailsRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.repository.OrderReturnAvailableDetailsRepository itemReturnAvailableResponse = null;
    
    @javax.inject.Inject
    public MyOrderDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyOrderDetailsRepository myOrderDetailsRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.OrderReturnAvailableDetailsRepository itemReturnAvailableResponse) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.repository.MyOrderDetailsRepository getMyOrderDetailsRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.repository.OrderReturnAvailableDetailsRepository getItemReturnAvailableResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse>> getOrderDetailsResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse>> getOrderReturnAvalableLiveData() {
        return null;
    }
    
    public final void getOrderDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest myOrderRequest) {
    }
    
    public final void getOrderReturnDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest myOrderRequest) {
    }
}
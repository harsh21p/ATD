package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/atd/atdmobileapp/repository/DeliveriesRepository;", "", "deliveriesApi", "Lcom/atd/atdmobileapp/api/DeliveriesApi;", "(Lcom/atd/atdmobileapp/api/DeliveriesApi;)V", "_deliveryDaysLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/DeliveryDaysResponse;", "_shippingDetailsLiveData", "Lcom/atd/atdmobileapp/models/ShippingMethodResponse;", "deliveryDaysLiveData", "Landroidx/lifecycle/LiveData;", "getDeliveryDaysLiveData", "()Landroidx/lifecycle/LiveData;", "shippingDetailsLiveData", "getShippingDetailsLiveData", "getDeliveryDays", "", "deliveryDayRequest", "Lcom/atd/atdmobileapp/models/DeliveryDayRequest;", "(Lcom/atd/atdmobileapp/models/DeliveryDayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShippingDetails", "shippingMethodRequest", "Lcom/atd/atdmobileapp/models/ShippingMethodRequest;", "(Lcom/atd/atdmobileapp/models/ShippingMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "Lretrofit2/Response;", "(Lretrofit2/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponseDeliverDays", "app_release"})
public final class DeliveriesRepository {
    private final com.atd.atdmobileapp.api.DeliveriesApi deliveriesApi = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.ShippingMethodResponse>> _shippingDetailsLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.DeliveryDaysResponse>> _deliveryDaysLiveData = null;
    
    @javax.inject.Inject
    public DeliveriesRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.DeliveriesApi deliveriesApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.ShippingMethodResponse>> getShippingDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.DeliveryDaysResponse>> getDeliveryDaysLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getShippingDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.ShippingMethodRequest shippingMethodRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object handleResponse(@org.jetbrains.annotations.NotNull
    retrofit2.Response<com.atd.atdmobileapp.models.ShippingMethodResponse> response, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDeliveryDays(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.DeliveryDayRequest deliveryDayRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object handleResponseDeliverDays(@org.jetbrains.annotations.NotNull
    retrofit2.Response<com.atd.atdmobileapp.models.DeliveryDaysResponse> response, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
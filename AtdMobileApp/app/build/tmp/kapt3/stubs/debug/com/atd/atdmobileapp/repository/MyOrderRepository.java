package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0019\u0010\'\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0019\u0010*\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0016\u0010+\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-H\u0002J\u001f\u0010.\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-H\u0002J\u001f\u00101\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0-H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0016\u00102\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-H\u0002J\u0019\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u000205H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\u0019\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/atd/atdmobileapp/repository/MyOrderRepository;", "", "myOrderApi", "Lcom/atd/atdmobileapp/api/OrderApi;", "(Lcom/atd/atdmobileapp/api/OrderApi;)V", "_OrderDateRangeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrdersData;", "_OrderLiveData", "_cartDetailsLiveData", "Lcom/atd/atdmobileapp/models/CartResponse;", "_placeOrderFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/atd/atdmobileapp/models/CheckoutResponse;", "cartDetailsLiveData", "Landroidx/lifecycle/LiveData;", "getCartDetailsLiveData", "()Landroidx/lifecycle/LiveData;", "cartResponseLiveData", "getCartResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "myOrderDateRangeResponseLiveData", "getMyOrderDateRangeResponseLiveData", "myOrderLiveData", "getMyOrderLiveData", "placeOrderFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getPlaceOrderFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getCartDetails", "", "cartRequest", "Lcom/atd/atdmobileapp/models/CartRequest;", "(Lcom/atd/atdmobileapp/models/CartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDateRangeOrders", "myOrderRequest", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyOrders", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrderRequest;", "(Lcom/atd/atdmobileapp/models/myordersdata/MyOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviewOrder", "handleCartResponse", "response", "Lretrofit2/Response;", "handleCartResponseFlow", "(Lretrofit2/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDateRangeOrdersResponse", "handlePlaceOrderFlow", "handleResponse", "placeOrder", "checkoutRequest", "Lcom/atd/atdmobileapp/models/CheckoutRequest;", "(Lcom/atd/atdmobileapp/models/CheckoutRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrderWithDate", "checkoutRequestWithDate", "Lcom/atd/atdmobileapp/models/CheckoutRequestWithDate;", "(Lcom/atd/atdmobileapp/models/CheckoutRequestWithDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MyOrderRepository {
    private final com.atd.atdmobileapp.api.OrderApi myOrderApi = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> _OrderLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> _OrderDateRangeLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> cartResponseLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> _cartDetailsLiveData = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CheckoutResponse>> _placeOrderFlow = null;
    
    @javax.inject.Inject
    public MyOrderRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.OrderApi myOrderApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> getMyOrderLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> getMyOrderDateRangeResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> getCartResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> getCartDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CheckoutResponse>> getPlaceOrderFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMyOrders(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myordersdata.MyOrderRequest myOrderRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDateRangeOrders(@org.jetbrains.annotations.NotNull
    okhttp3.RequestBody myOrderRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.myordersdata.MyOrdersData> response) {
    }
    
    private final void handleDateRangeOrdersResponse(retrofit2.Response<com.atd.atdmobileapp.models.myordersdata.MyOrdersData> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCartDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CartRequest cartRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleCartResponse(retrofit2.Response<com.atd.atdmobileapp.models.CartResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPreviewOrder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CartRequest cartRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object handleCartResponseFlow(retrofit2.Response<com.atd.atdmobileapp.models.CartResponse> response, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CheckoutRequest checkoutRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object handlePlaceOrderFlow(retrofit2.Response<com.atd.atdmobileapp.models.CheckoutResponse> response, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object placeOrderWithDate(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CheckoutRequestWithDate checkoutRequestWithDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
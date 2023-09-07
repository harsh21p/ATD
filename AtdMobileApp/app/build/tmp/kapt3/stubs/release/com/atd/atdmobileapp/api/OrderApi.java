package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020 H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\b\b\u0001\u0010\u0005\u001a\u00020$H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J!\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\'H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/atd/atdmobileapp/api/OrderApi;", "", "approveOrder", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/approveorder/ApproveResponse;", "request", "Lcom/atd/atdmobileapp/models/approveorder/ApproveOrder;", "(Lcom/atd/atdmobileapp/models/approveorder/ApproveOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCartDetails", "Lcom/atd/atdmobileapp/models/CartResponse;", "cartRequest", "Lcom/atd/atdmobileapp/models/CartRequest;", "(Lcom/atd/atdmobileapp/models/CartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDateRangeOrders", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrdersData;", "myOrderRequest", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyApprovals", "Lcom/atd/atdmobileapp/models/myapprovals/MyApprovalsData;", "locationNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyOrders", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrderRequest;", "(Lcom/atd/atdmobileapp/models/myordersdata/MyOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderDetails", "Lcom/atd/atdmobileapp/models/orderdetails/OrderDetailsResponse;", "Lcom/atd/atdmobileapp/models/orderdetails/OrderDetailsRequest;", "(Lcom/atd/atdmobileapp/models/orderdetails/OrderDetailsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReturnDetails", "Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableResponse;", "Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableDetailsRequest;", "(Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableDetailsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "Lcom/atd/atdmobileapp/models/CheckoutResponse;", "Lcom/atd/atdmobileapp/models/CheckoutRequest;", "(Lcom/atd/atdmobileapp/models/CheckoutRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrderWithDate", "Lcom/atd/atdmobileapp/models/CheckoutRequestWithDate;", "(Lcom/atd/atdmobileapp/models/CheckoutRequestWithDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface OrderApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/order-status")
    public abstract java.lang.Object getMyOrders(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.myordersdata.MyOrderRequest myOrderRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/order-status")
    public abstract java.lang.Object getDateRangeOrders(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    okhttp3.RequestBody myOrderRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myordersdata.MyOrdersData>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/order/order-approval-status/{locationNumber}")
    public abstract java.lang.Object getMyApprovals(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myapprovals.MyApprovalsData>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/preview-order")
    public abstract java.lang.Object getCartDetails(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.CartRequest cartRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.CartResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/order-status-detail")
    public abstract java.lang.Object getOrderDetails(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/rma-return/get-returnable-quantity")
    public abstract java.lang.Object getReturnDetails(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/order-approval/approve-order")
    public abstract java.lang.Object approveOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.approveorder.ApproveOrder request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.approveorder.ApproveResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/place-order")
    public abstract java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.CheckoutRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.CheckoutResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/order/place-order")
    public abstract java.lang.Object placeOrderWithDate(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.CheckoutRequestWithDate request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.CheckoutResponse>> continuation);
}
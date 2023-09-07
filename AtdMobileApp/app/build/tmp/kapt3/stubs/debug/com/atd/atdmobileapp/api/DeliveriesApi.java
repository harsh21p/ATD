package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/atd/atdmobileapp/api/DeliveriesApi;", "", "getDeliveryDays", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/DeliveryDaysResponse;", "body", "Lcom/atd/atdmobileapp/models/DeliveryDayRequest;", "(Lcom/atd/atdmobileapp/models/DeliveryDayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShippingDetails", "Lcom/atd/atdmobileapp/models/ShippingMethodResponse;", "Lcom/atd/atdmobileapp/models/ShippingMethodRequest;", "(Lcom/atd/atdmobileapp/models/ShippingMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface DeliveriesApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/delivery/shipping-methods")
    public abstract java.lang.Object getShippingDetails(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.ShippingMethodRequest body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.ShippingMethodResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/delivery/route/delivery-days")
    public abstract java.lang.Object getDeliveryDays(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.DeliveryDayRequest body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.DeliveryDaysResponse>> continuation);
}
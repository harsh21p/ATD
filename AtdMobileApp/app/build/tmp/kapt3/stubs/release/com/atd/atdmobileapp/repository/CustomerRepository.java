package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/atd/atdmobileapp/repository/CustomerRepository;", "", "customerApi", "Lcom/atd/atdmobileapp/api/CustomerApi;", "(Lcom/atd/atdmobileapp/api/CustomerApi;)V", "_customerDetailsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/CustomerDetailsResponse;", "customerDetailsLiveData", "Landroidx/lifecycle/LiveData;", "getCustomerDetailsLiveData", "()Landroidx/lifecycle/LiveData;", "getCustomerDetails", "", "locationNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "Lretrofit2/Response;", "(Lretrofit2/Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class CustomerRepository {
    private final com.atd.atdmobileapp.api.CustomerApi customerApi = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CustomerDetailsResponse>> _customerDetailsLiveData = null;
    
    @javax.inject.Inject
    public CustomerRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.CustomerApi customerApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CustomerDetailsResponse>> getCustomerDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCustomerDetails(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object handleResponse(@org.jetbrains.annotations.NotNull
    retrofit2.Response<com.atd.atdmobileapp.models.CustomerDetailsResponse> response, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
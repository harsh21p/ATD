package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0002J\u0019\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/atd/atdmobileapp/repository/UserRepository;", "", "userApi", "Lcom/atd/atdmobileapp/api/UserApi;", "(Lcom/atd/atdmobileapp/api/UserApi;)V", "_configLocationsResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationResponse;", "configLocationsResponse", "Landroidx/lifecycle/LiveData;", "getConfigLocationsResponse", "()Landroidx/lifecycle/LiveData;", "userResponseLiveData", "Lcom/atd/atdmobileapp/models/UserResponse;", "getUserResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getConfigLocations", "", "location", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationRequest;", "(Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleConfigLocationResponse", "response", "Lretrofit2/Response;", "handleResponse", "loginUser", "userName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class UserRepository {
    private final com.atd.atdmobileapp.api.UserApi userApi = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.UserResponse>> userResponseLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse>> _configLocationsResponseLiveData = null;
    
    @javax.inject.Inject
    public UserRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.UserApi userApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.UserResponse>> getUserResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse>> getConfigLocationsResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loginUser(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getConfigLocations(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.UserResponse> response) {
    }
    
    private final void handleConfigLocationResponse(retrofit2.Response<com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse> response) {
    }
}
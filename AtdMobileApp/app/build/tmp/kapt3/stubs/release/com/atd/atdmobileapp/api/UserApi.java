package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/atd/atdmobileapp/api/UserApi;", "", "getLocationsConfigure", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationResponse;", "location", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationRequest;", "(Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/atd/atdmobileapp/models/UserResponse;", "userName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface UserApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/user/users-by-username")
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "username")
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.UserResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/user/location-configurations")
    public abstract java.lang.Object getLocationsConfigure(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse>> continuation);
}
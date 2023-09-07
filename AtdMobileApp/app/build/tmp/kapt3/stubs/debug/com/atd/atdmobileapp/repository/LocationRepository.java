package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cH\u0002R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/atd/atdmobileapp/repository/LocationRepository;", "", "locationApi", "Lcom/atd/atdmobileapp/api/LocationApi;", "(Lcom/atd/atdmobileapp/api/LocationApi;)V", "DistributioncenterLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "getDistributioncenterLiveData", "()Landroidx/lifecycle/LiveData;", "_DistributioncenterLiveData", "Landroidx/lifecycle/MutableLiveData;", "selectedLocationLiveData", "Lcom/atd/atdmobileapp/models/SelectLocationResponse;", "getSelectedLocationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getLocation", "", "dcNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationsToSave", "jsonBody", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "Lretrofit2/Response;", "app_debug"})
public final class LocationRepository {
    private final com.atd.atdmobileapp.api.LocationApi locationApi = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.homescreenlocations.DCDetails>> _DistributioncenterLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.SelectLocationResponse>> selectedLocationLiveData = null;
    
    @javax.inject.Inject
    public LocationRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.LocationApi locationApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.homescreenlocations.DCDetails>> getDistributioncenterLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.SelectLocationResponse>> getSelectedLocationLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocation(@org.jetbrains.annotations.NotNull
    java.lang.String dcNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.homescreenlocations.DCDetails> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocationsToSave(@org.jetbrains.annotations.NotNull
    org.json.JSONObject jsonBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
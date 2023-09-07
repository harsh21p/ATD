package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/api/LocationApi;", "", "getCutOffTimes", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/keywordsearch/CutOffTimesData;", "dcNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocations", "Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "getLocationsToSave", "Lcom/atd/atdmobileapp/models/SelectLocationResponse;", "body", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface LocationApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/location/distribution-center/{dcNumber}")
    public abstract java.lang.Object getLocations(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "dcNumber")
    java.lang.String dcNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.homescreenlocations.DCDetails>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/location/location-by-criteria")
    public abstract java.lang.Object getLocationsToSave(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    org.json.JSONObject body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.SelectLocationResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/location/cut-off-times/{locationnumber}")
    public abstract java.lang.Object getCutOffTimes(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationnumber")
    java.lang.String dcNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.keywordsearch.CutOffTimesData>> continuation);
}
package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/atd/atdmobileapp/repository/RDBConfigLocationsRepository;", "", "dao", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "(Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;)V", "_ConfigLocationResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationEntity;", "configLocationResponse", "Landroidx/lifecycle/LiveData;", "getConfigLocationResponse", "()Landroidx/lifecycle/LiveData;", "getDao", "()Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "getConfigLocationResp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "saveConfigLocations", "location", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationResponse;", "app_release"})
public final class RDBConfigLocationsRepository {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO dao = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity>>> _ConfigLocationResponseLiveData = null;
    
    @javax.inject.Inject
    public RDBConfigLocationsRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO getDao() {
        return null;
    }
    
    public final void saveConfigLocations(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse location) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity>>> getConfigLocationResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getConfigLocationResp(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(java.util.List<com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity> response) {
    }
}
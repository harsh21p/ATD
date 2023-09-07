package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/repository/LocationConfigurationRepository;", "", "configLocationsDAO", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "(Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;)V", "preferredBrandsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/models/locationconfig/Locationconfiguration;", "getPreferredBrandsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getPreferredBrandConfigurationList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LocationConfigurationRepository {
    private final com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO configLocationsDAO = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.models.locationconfig.Locationconfiguration>>> preferredBrandsLiveData = null;
    
    @javax.inject.Inject
    public LocationConfigurationRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO configLocationsDAO) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.models.locationconfig.Locationconfiguration>>> getPreferredBrandsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPreferredBrandConfigurationList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
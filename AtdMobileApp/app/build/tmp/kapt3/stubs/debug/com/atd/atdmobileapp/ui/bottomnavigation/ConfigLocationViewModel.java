package com.atd.atdmobileapp.ui.bottomnavigation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00170\nJ\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/ConfigLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "configLocationRepository", "Lcom/atd/atdmobileapp/repository/ConfigLocationRepository;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "cutOffDateRepository", "Lcom/atd/atdmobileapp/repository/CutOffDateRepository;", "(Lcom/atd/atdmobileapp/repository/ConfigLocationRepository;Lcom/atd/atdmobileapp/utils/FirestoreRepository;Lcom/atd/atdmobileapp/repository/CutOffDateRepository;)V", "configLocationLivedata", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationResponse;", "getConfigLocationLivedata", "()Landroidx/lifecycle/LiveData;", "cutOffDatesResponseLiveData", "Lcom/atd/atdmobileapp/models/keywordsearch/CutOffTimesData;", "getCutOffDatesResponseLiveData", "ConfigLocations", "", "configLocationRequest", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationRequest;", "getAllCartRecords", "", "Lcom/atd/atdmobileapp/models/Cart;", "getMyOrders", "locationNum", "", "app_debug"})
public final class ConfigLocationViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.ConfigLocationRepository configLocationRepository = null;
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    private final com.atd.atdmobileapp.repository.CutOffDateRepository cutOffDateRepository = null;
    
    @javax.inject.Inject
    public ConfigLocationViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.ConfigLocationRepository configLocationRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.CutOffDateRepository cutOffDateRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse>> getConfigLocationLivedata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.CutOffTimesData>> getCutOffDatesResponseLiveData() {
        return null;
    }
    
    public final void ConfigLocations(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest configLocationRequest) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> getAllCartRecords() {
        return null;
    }
    
    public final void getMyOrders(@org.jetbrains.annotations.NotNull
    java.lang.String locationNum) {
    }
}
package com.atd.atdmobileapp.ui.bottomnavigation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/RMDConfigLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "rdbConfigLocationsRepository", "Lcom/atd/atdmobileapp/repository/RDBConfigLocationsRepository;", "(Lcom/atd/atdmobileapp/repository/RDBConfigLocationsRepository;)V", "keywordResponseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationEntity;", "getKeywordResponseLiveData", "()Landroidx/lifecycle/LiveData;", "getMyKeywords", "", "saveConfigLocation", "entity", "Lcom/atd/atdmobileapp/models/locationconfig/ConfigLocationResponse;", "app_debug"})
public final class RMDConfigLocationViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.RDBConfigLocationsRepository rdbConfigLocationsRepository = null;
    
    @javax.inject.Inject
    public RMDConfigLocationViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.RDBConfigLocationsRepository rdbConfigLocationsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity>>> getKeywordResponseLiveData() {
        return null;
    }
    
    public final void getMyKeywords() {
    }
    
    public final void saveConfigLocation(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse entity) {
    }
}
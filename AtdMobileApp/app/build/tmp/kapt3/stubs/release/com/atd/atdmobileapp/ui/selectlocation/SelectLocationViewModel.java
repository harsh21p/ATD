package com.atd.atdmobileapp.ui.selectlocation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "locationRepository", "Lcom/atd/atdmobileapp/repository/LocationRepository;", "(Lcom/atd/atdmobileapp/repository/LocationRepository;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "selectedLocationLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/SelectLocationResponse;", "getSelectedLocationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getLocationsToSave", "", "app_release"})
public final class SelectLocationViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.LocationRepository locationRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    
    @javax.inject.Inject
    public SelectLocationViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.LocationRepository locationRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.SelectLocationResponse>> getSelectedLocationLiveData() {
        return null;
    }
    
    public final void getLocationsToSave() {
    }
}
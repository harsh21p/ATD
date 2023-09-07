package com.atd.atdmobileapp.ui.licenceplate;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/atd/atdmobileapp/ui/licenceplate/LicencePlateViewModel;", "Landroidx/lifecycle/ViewModel;", "vehiclesRepository", "Lcom/atd/atdmobileapp/repository/VehiclesRepository;", "(Lcom/atd/atdmobileapp/repository/VehiclesRepository;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "licencePlateResponseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/licenceplate/LicencePlateResponse;", "getLicencePlateResponseLiveData", "()Landroidx/lifecycle/LiveData;", "getLicencePlateDetails", "", "state", "", "licencePlate", "app_release"})
public final class LicencePlateViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.VehiclesRepository vehiclesRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    
    @javax.inject.Inject
    public LicencePlateViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.VehiclesRepository vehiclesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse>> getLicencePlateResponseLiveData() {
        return null;
    }
    
    public final void getLicencePlateDetails(@org.jetbrains.annotations.NotNull
    java.lang.String state, @org.jetbrains.annotations.NotNull
    java.lang.String licencePlate) {
    }
}
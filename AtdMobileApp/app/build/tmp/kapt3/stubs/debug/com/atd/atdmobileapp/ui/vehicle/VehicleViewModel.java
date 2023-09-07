package com.atd.atdmobileapp.ui.vehicle;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020*2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020*2\u0006\u00105\u001a\u000206J\u000e\u00108\u001a\u00020*2\u0006\u00105\u001a\u000209J\u000e\u0010:\u001a\u00020*2\u0006\u00105\u001a\u000206J\u000e\u0010;\u001a\u00020*2\u0006\u00105\u001a\u000206R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b \u0010\nR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\nR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\nR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\nR\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/VehicleViewModel;", "Landroidx/lifecycle/ViewModel;", "vehiclesRepository", "Lcom/atd/atdmobileapp/repository/VehiclesRepository;", "(Lcom/atd/atdmobileapp/repository/VehiclesRepository;)V", "addOnsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/vehicle/AddOnsResponse;", "getAddOnsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handlerForAddOns", "handlerForGetInstallationSpec", "handlerForMakes", "handlerForModel", "handlerForOESize", "handlerForProductByFitment", "handlerForSuspensionFitment", "handlerForTrim", "installationSpecLiveData", "Lcom/atd/atdmobileapp/models/vehicle/InstallationSpecResponse;", "getInstallationSpecLiveData", "productByFitmentLiveData", "Lcom/atd/atdmobileapp/models/vehicle/ProductByFitmentResponse;", "getProductByFitmentLiveData", "suspensionFitmentLiveData", "Lcom/atd/atdmobileapp/models/vehicle/SuspensionFitmentResponse;", "getSuspensionFitmentLiveData", "vehicleMakesLiveData", "Lcom/atd/atdmobileapp/models/vehicle/VehicleResponse;", "getVehicleMakesLiveData", "vehicleModelLiveData", "getVehicleModelLiveData", "vehicleOESizeLiveData", "getVehicleOESizeLiveData", "vehicleResponseLiveData", "getVehicleResponseLiveData", "vehicleTrimLiveData", "getVehicleTrimLiveData", "getAddOnsForVehicle", "", "addOnsRequest", "Lcom/atd/atdmobileapp/models/vehicle/AddOnsRequest;", "getInstallationSpecForVehicle", "productByFitmentRequest", "Lcom/atd/atdmobileapp/models/vehicle/ProductByFitmentRequest;", "getProductByFitment", "getSuspensionFitmentVehicle", "fitmentid", "", "getVehicleMakes", "vehicleRequest", "Lcom/atd/atdmobileapp/models/vehicle/VehicleRequest;", "getVehicleModel", "getVehicleOESize", "Lcom/atd/atdmobileapp/models/vehicle/VehiclePlusSizeRequest;", "getVehicleTrim", "getVehicleYears", "app_debug"})
public final class VehicleViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.VehiclesRepository vehiclesRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForMakes = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForModel = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForTrim = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForOESize = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForProductByFitment = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForGetInstallationSpec = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForAddOns = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handlerForSuspensionFitment = null;
    
    @javax.inject.Inject
    public VehicleViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.VehiclesRepository vehiclesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleMakesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleModelLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleTrimLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleOESizeLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.ProductByFitmentResponse>> getProductByFitmentLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.InstallationSpecResponse>> getInstallationSpecLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.AddOnsResponse>> getAddOnsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.SuspensionFitmentResponse>> getSuspensionFitmentLiveData() {
        return null;
    }
    
    public final void getVehicleYears(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest) {
    }
    
    public final void getVehicleMakes(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest) {
    }
    
    public final void getVehicleModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest) {
    }
    
    public final void getVehicleTrim(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest) {
    }
    
    public final void getVehicleOESize(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehiclePlusSizeRequest vehicleRequest) {
    }
    
    public final void getProductByFitment(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.ProductByFitmentRequest productByFitmentRequest) {
    }
    
    public final void getInstallationSpecForVehicle(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.ProductByFitmentRequest productByFitmentRequest) {
    }
    
    public final void getAddOnsForVehicle(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.AddOnsRequest addOnsRequest) {
    }
    
    public final void getSuspensionFitmentVehicle(@org.jetbrains.annotations.NotNull
    java.lang.String fitmentid) {
    }
}
package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J!\u00102\u001a\u00020*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\u0019\u00107\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010;\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010<\u001a\u00020*2\u0006\u00108\u001a\u00020=H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0019\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u000204H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ\u0019\u0010C\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010D\u001a\u00020*2\u0006\u0010A\u001a\u000204H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ\u0019\u0010E\u001a\u00020*2\u0006\u00108\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0016\u0010F\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0HH\u0002J\u0016\u0010I\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00120HH\u0002J\u0016\u0010J\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0HH\u0002J\u0016\u0010K\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170HH\u0002J\u0016\u0010L\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0HH\u0002J\u0016\u0010M\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0HH\u0002J\u0016\u0010N\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0HH\u0002J\u0016\u0010O\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0HH\u0002J\u0016\u0010P\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0HH\u0002J\u0016\u0010Q\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0HH\u0002J\u0016\u0010R\u001a\u00020*2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0HH\u0002R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\nR\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006S"}, d2 = {"Lcom/atd/atdmobileapp/repository/VehiclesRepository;", "", "vehiclesApi", "Lcom/atd/atdmobileapp/api/VehiclesApi;", "(Lcom/atd/atdmobileapp/api/VehiclesApi;)V", "_licensePlateResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/licenceplate/LicencePlateResponse;", "get_licensePlateResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_vinResponseLiveData", "Lcom/atd/atdmobileapp/models/vehicle/VinResponse;", "get_vinResponseLiveData", "addOnsLiveData", "Lcom/atd/atdmobileapp/models/vehicle/AddOnsResponse;", "getAddOnsLiveData", "installationSpecLiveData", "Lcom/atd/atdmobileapp/models/vehicle/InstallationSpecResponse;", "getInstallationSpecLiveData", "licensePlateResponseLiveData", "getLicensePlateResponseLiveData", "productByFitmentLiveData", "Lcom/atd/atdmobileapp/models/vehicle/ProductByFitmentResponse;", "getProductByFitmentLiveData", "suspensionFitmentLiveData", "Lcom/atd/atdmobileapp/models/vehicle/SuspensionFitmentResponse;", "getSuspensionFitmentLiveData", "vehicleModelLiveData", "Lcom/atd/atdmobileapp/models/vehicle/VehicleResponse;", "getVehicleModelLiveData", "vehicleOESizeLiveData", "getVehicleOESizeLiveData", "vehicleTrimlLiveData", "getVehicleTrimlLiveData", "vehiclesMakeLiveData", "getVehiclesMakeLiveData", "vehiclesYearLiveData", "getVehiclesYearLiveData", "vinResponseLiveData", "getVinResponseLiveData", "getAddOns", "", "addOnsRequest", "Lcom/atd/atdmobileapp/models/vehicle/AddOnsRequest;", "(Lcom/atd/atdmobileapp/models/vehicle/AddOnsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstallationSpecForVehicleId", "productByFitmentRequest", "Lcom/atd/atdmobileapp/models/vehicle/ProductByFitmentRequest;", "(Lcom/atd/atdmobileapp/models/vehicle/ProductByFitmentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLicencePlate", "state", "", "numberPlate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMakesForVehicles", "vehicleRequest", "Lcom/atd/atdmobileapp/models/vehicle/VehicleRequest;", "(Lcom/atd/atdmobileapp/models/vehicle/VehicleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getModelForVehicles", "getOESizeForVehicles", "Lcom/atd/atdmobileapp/models/vehicle/VehiclePlusSizeRequest;", "(Lcom/atd/atdmobileapp/models/vehicle/VehiclePlusSizeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByFitment", "getSuspensionFitment", "vehicleid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrimForVehicles", "getVIN", "getYearsForVehicles", "handleAddOnsResponse", "response", "Lretrofit2/Response;", "handleGetInstallationSpecResponse", "handleLicencePlateResponse", "handleProductByFitmentResponse", "handleSuspensionFitmentResponse", "handleVINResponse", "handleVehicleMakeResponse", "handleVehicleModelResponse", "handleVehicleOESizeResponse", "handleVehicleTrimResponse", "handleVehicleYearResponse", "app_release"})
public final class VehiclesRepository {
    private final com.atd.atdmobileapp.api.VehiclesApi vehiclesApi = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> vehiclesYearLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> vehiclesMakeLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> vehicleModelLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> vehicleTrimlLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> vehicleOESizeLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.ProductByFitmentResponse>> productByFitmentLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.InstallationSpecResponse>> installationSpecLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.AddOnsResponse>> addOnsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.SuspensionFitmentResponse>> suspensionFitmentLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VinResponse>> vinResponseLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse>> licensePlateResponseLiveData = null;
    
    @javax.inject.Inject
    public VehiclesRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.VehiclesApi vehiclesApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehiclesYearLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehiclesMakeLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleModelLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VehicleResponse>> getVehicleTrimlLiveData() {
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getYearsForVehicles(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVehicleYearResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VehicleResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMakesForVehicles(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVehicleMakeResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VehicleResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getModelForVehicles(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVehicleModelResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VehicleResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTrimForVehicles(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleRequest vehicleRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVehicleTrimResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VehicleResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOESizeForVehicles(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehiclePlusSizeRequest vehicleRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVehicleOESizeResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VehicleResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getProductsByFitment(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.ProductByFitmentRequest productByFitmentRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleProductByFitmentResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.ProductByFitmentResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getInstallationSpecForVehicleId(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.ProductByFitmentRequest productByFitmentRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleGetInstallationSpecResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.InstallationSpecResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAddOns(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.AddOnsRequest addOnsRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleAddOnsResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.AddOnsResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSuspensionFitment(@org.jetbrains.annotations.NotNull
    java.lang.String vehicleid, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleSuspensionFitmentResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.SuspensionFitmentResponse> response) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VinResponse>> getVinResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.vehicle.VinResponse>> get_vinResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getVIN(@org.jetbrains.annotations.NotNull
    java.lang.String vehicleid, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleVINResponse(retrofit2.Response<com.atd.atdmobileapp.models.vehicle.VinResponse> response) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse>> getLicensePlateResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse>> get_licensePlateResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLicencePlate(@org.jetbrains.annotations.NotNull
    java.lang.String state, @org.jetbrains.annotations.NotNull
    java.lang.String numberPlate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleLicencePlateResponse(retrofit2.Response<com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse> response) {
    }
}
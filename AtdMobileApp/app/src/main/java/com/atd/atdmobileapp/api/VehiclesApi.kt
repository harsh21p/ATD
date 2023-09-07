package com.atd.atdmobileapp.api

import com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.models.vehicle.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VehiclesApi {

    @POST("/rs/3_6/fitment/year")
    suspend fun getYearsForVehicles(@Body body: VehicleRequest) : Response<VehicleResponse>

    @POST("/rs/3_6/fitment/make")
    suspend fun getMakesForVehicles(@Body body: VehicleRequest) : Response<VehicleResponse>

    @POST("/rs/3_6/fitment/model")
    suspend fun getModelsForVehicles(@Body body: VehicleRequest) : Response<VehicleResponse>

    @POST("/rs/3_6/fitment/trim")
    suspend fun getTrimsForVehicles(@Body body: VehicleRequest) : Response<VehicleResponse>

    @POST("/rs/3_6/fitment/plus-size")
    suspend fun getOESizeForVehicles(@Body body: VehiclePlusSizeRequest) : Response<VehicleResponse>

    @POST("/rs/3_6/fitment/product-by-fitment")
    suspend fun getProductByFitment(@Body body: ProductByFitmentRequest) : Response<ProductByFitmentResponse>

    @POST("/rs/3_6/fitment/installation-spec")
    suspend fun getInstallationSpec(@Body body: ProductByFitmentRequest) : Response<InstallationSpecResponse>

    @POST("/rs/3_6/fitment/addons")
    suspend fun getAddOns(@Body body: AddOnsRequest) : Response<AddOnsResponse>

    @GET("/rs/3_6/fitment/suspension-fitments/{vehicleid}")
    suspend fun getSuspensionFitment(@Path("vehicleid") vehicleid: String) : Response<SuspensionFitmentResponse>

    @GET("/rs/3_6/fitment/vehicle-by-vin/{VINnumber}")
    suspend fun getVINDetails(@Path("VINnumber") vehicleid: String) : Response<VinResponse>

    //https://mblqa.atdconnect.com/rs/3_6/fitment/vehicle-by-license-plate/{STATE}/{plateNumber}

    @GET("/rs/3_6/fitment/vehicle-by-license-plate/{STATE}/{plateNumber}")
    suspend fun getLicencePlateDetails(@Path("STATE") STATE: String,@Path("plateNumber") plateNumber: String) : Response<LicencePlateResponse>

}
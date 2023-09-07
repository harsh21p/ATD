package com.atd.atdmobileapp.repository

import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.VehiclesApi
import com.atd.atdmobileapp.models.licenceplate.LicencePlateResponse
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class VehiclesRepository @Inject constructor(private val vehiclesApi: VehiclesApi) {

    val vehiclesYearLiveData = MutableLiveData<NetworkResult<VehicleResponse>>()
    val vehiclesMakeLiveData = MutableLiveData<NetworkResult<VehicleResponse>>()
    val vehicleModelLiveData = MutableLiveData<NetworkResult<VehicleResponse>>()
    val vehicleTrimlLiveData = MutableLiveData<NetworkResult<VehicleResponse>>()
    val vehicleOESizeLiveData = MutableLiveData<NetworkResult<VehicleResponse>>()
    val productByFitmentLiveData = MutableLiveData<NetworkResult<ProductByFitmentResponse>>()
    val installationSpecLiveData = MutableLiveData<NetworkResult<InstallationSpecResponse>>()
    val addOnsLiveData = MutableLiveData<NetworkResult<AddOnsResponse>>()
    val suspensionFitmentLiveData = MutableLiveData<NetworkResult<SuspensionFitmentResponse>>()

    suspend fun getYearsForVehicles(vehicleRequest: VehicleRequest){
        vehiclesYearLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getYearsForVehicles(vehicleRequest)
        handleVehicleYearResponse(response)
    }

    private fun handleVehicleYearResponse(response: Response<VehicleResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vehiclesYearLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vehiclesYearLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vehiclesYearLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getMakesForVehicles(vehicleRequest: VehicleRequest){
        vehiclesMakeLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getMakesForVehicles(vehicleRequest)
        handleVehicleMakeResponse(response)
    }

    private fun handleVehicleMakeResponse(response: Response<VehicleResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vehiclesMakeLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vehiclesMakeLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vehiclesMakeLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getModelForVehicles(vehicleRequest: VehicleRequest){
        vehicleModelLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getModelsForVehicles(vehicleRequest)
        handleVehicleModelResponse(response)
    }

    private fun handleVehicleModelResponse(response: Response<VehicleResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vehicleModelLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vehicleModelLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vehicleModelLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getTrimForVehicles(vehicleRequest: VehicleRequest){
        vehicleTrimlLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getTrimsForVehicles(vehicleRequest)
        handleVehicleTrimResponse(response)
    }

    private fun handleVehicleTrimResponse(response: Response<VehicleResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vehicleTrimlLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vehicleTrimlLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vehicleTrimlLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getOESizeForVehicles(vehicleRequest: VehiclePlusSizeRequest){
        vehicleOESizeLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getOESizeForVehicles(vehicleRequest)
        handleVehicleOESizeResponse(response)
    }

    private fun handleVehicleOESizeResponse(response: Response<VehicleResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vehicleOESizeLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vehicleOESizeLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vehicleOESizeLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getProductsByFitment(productByFitmentRequest: ProductByFitmentRequest){
        productByFitmentLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getProductByFitment(productByFitmentRequest)
        handleProductByFitmentResponse(response)
    }

    private fun handleProductByFitmentResponse(response: Response<ProductByFitmentResponse>) {
        if (response.isSuccessful && response.body() != null) {
            productByFitmentLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            productByFitmentLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            productByFitmentLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getInstallationSpecForVehicleId(productByFitmentRequest: ProductByFitmentRequest){
        installationSpecLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getInstallationSpec(productByFitmentRequest)
        handleGetInstallationSpecResponse(response)
    }

    private fun handleGetInstallationSpecResponse(response: Response<InstallationSpecResponse>) {
        if (response.isSuccessful && response.body() != null) {
            installationSpecLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            installationSpecLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            installationSpecLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getAddOns(addOnsRequest: AddOnsRequest){
        addOnsLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getAddOns(addOnsRequest)
        handleAddOnsResponse(response)
    }

    private fun handleAddOnsResponse(response: Response<AddOnsResponse>) {
        if (response.isSuccessful && response.body() != null) {
            addOnsLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            addOnsLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            addOnsLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getSuspensionFitment(vehicleid: String){
        suspensionFitmentLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getSuspensionFitment(vehicleid)
        handleSuspensionFitmentResponse(response)
    }

    private fun handleSuspensionFitmentResponse(response: Response<SuspensionFitmentResponse>) {
        if (response.isSuccessful && response.body() != null) {
            suspensionFitmentLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            suspensionFitmentLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            suspensionFitmentLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }


    val vinResponseLiveData = MutableLiveData<NetworkResult<VinResponse>>()
    val _vinResponseLiveData get() = vinResponseLiveData

    suspend fun getVIN(vehicleid: String){
        vinResponseLiveData.postValue(NetworkResult.Loading())
        val response = vehiclesApi.getVINDetails(vehicleid)
        handleVINResponse(response)
    }

    private fun handleVINResponse(response: Response<VinResponse>) {
        if (response.isSuccessful && response.body() != null) {
            vinResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            vinResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            vinResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }


    val licensePlateResponseLiveData = MutableLiveData<NetworkResult<LicencePlateResponse>>()
    val _licensePlateResponseLiveData get() = licensePlateResponseLiveData

    suspend fun getLicencePlate(state: String,numberPlate:String){
        licensePlateResponseLiveData.postValue(NetworkResult.Loading())

        CoroutineScope(Dispatchers.IO).launch {

            val response = async(Dispatchers.IO) {vehiclesApi.getLicencePlateDetails(state,numberPlate)}
            handleLicencePlateResponse(response.await())
        }

    }

    private fun handleLicencePlateResponse(response: Response<LicencePlateResponse>) {
        if (response.isSuccessful && response.body() != null) {
            licensePlateResponseLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            licensePlateResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        } else if (response.body() == null) {
            licensePlateResponseLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}
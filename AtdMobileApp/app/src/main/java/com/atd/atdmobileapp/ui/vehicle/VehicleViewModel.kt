package com.atd.atdmobileapp.ui.vehicle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.vehicle.*
import com.atd.atdmobileapp.repository.VehiclesRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(private val vehiclesRepository: VehiclesRepository) :ViewModel(){

    private val handler = CoroutineExceptionHandler { _, exception ->
        vehicleResponseLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vehicleResponseLiveData: MutableLiveData<NetworkResult<VehicleResponse>>
    get() = vehiclesRepository.vehiclesYearLiveData

    private val handlerForMakes = CoroutineExceptionHandler { _, exception ->
        vehicleMakesLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vehicleMakesLiveData: MutableLiveData<NetworkResult<VehicleResponse>>
    get() = vehiclesRepository.vehiclesMakeLiveData

    private val handlerForModel = CoroutineExceptionHandler { _, exception ->
        vehicleModelLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vehicleModelLiveData: MutableLiveData<NetworkResult<VehicleResponse>>
        get() = vehiclesRepository.vehicleModelLiveData

    private val handlerForTrim = CoroutineExceptionHandler { _, exception ->
        vehicleTrimLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vehicleTrimLiveData: MutableLiveData<NetworkResult<VehicleResponse>>
        get() = vehiclesRepository.vehicleTrimlLiveData

    private val handlerForOESize = CoroutineExceptionHandler { _, exception ->
        vehicleOESizeLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val vehicleOESizeLiveData: MutableLiveData<NetworkResult<VehicleResponse>>
        get() = vehiclesRepository.vehicleOESizeLiveData

    private val handlerForProductByFitment = CoroutineExceptionHandler { _, exception ->
        productByFitmentLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val productByFitmentLiveData: MutableLiveData<NetworkResult<ProductByFitmentResponse>>
        get() = vehiclesRepository.productByFitmentLiveData

    private val handlerForGetInstallationSpec = CoroutineExceptionHandler { _, exception ->
        installationSpecLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val installationSpecLiveData: MutableLiveData<NetworkResult<InstallationSpecResponse>>
        get() = vehiclesRepository.installationSpecLiveData

    private val handlerForAddOns = CoroutineExceptionHandler { _, exception ->
        addOnsLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val addOnsLiveData: MutableLiveData<NetworkResult<AddOnsResponse>>
        get() = vehiclesRepository.addOnsLiveData

    private val handlerForSuspensionFitment = CoroutineExceptionHandler { _, exception ->
        suspensionFitmentLiveData.postValue(NetworkResult.Error(exception.message))
    }
    val suspensionFitmentLiveData: MutableLiveData<NetworkResult<SuspensionFitmentResponse>>
        get() = vehiclesRepository.suspensionFitmentLiveData

    fun getVehicleYears(vehicleRequest: VehicleRequest){
        viewModelScope.launch(handler) {
            vehiclesRepository.getYearsForVehicles(vehicleRequest)
        }
    }

    fun getVehicleMakes(vehicleRequest: VehicleRequest){
        viewModelScope.launch(handlerForMakes){
            vehiclesRepository.getMakesForVehicles(vehicleRequest)
        }
    }

    fun getVehicleModel(vehicleRequest: VehicleRequest){
        viewModelScope.launch(handlerForModel){
            vehiclesRepository.getModelForVehicles(vehicleRequest)
        }
    }

    fun getVehicleTrim(vehicleRequest: VehicleRequest){
        viewModelScope.launch(handlerForTrim){
            vehiclesRepository.getTrimForVehicles(vehicleRequest)
        }
    }

    fun getVehicleOESize(vehicleRequest: VehiclePlusSizeRequest){
        viewModelScope.launch(handlerForOESize){
            vehiclesRepository.getOESizeForVehicles(vehicleRequest)
        }
    }

    fun getProductByFitment(productByFitmentRequest: ProductByFitmentRequest){
        viewModelScope.launch(handlerForProductByFitment){
            vehiclesRepository.getProductsByFitment(productByFitmentRequest)
        }
    }

    fun getInstallationSpecForVehicle(productByFitmentRequest: ProductByFitmentRequest){
        viewModelScope.launch(handlerForGetInstallationSpec){
            vehiclesRepository.getInstallationSpecForVehicleId(productByFitmentRequest)
        }
    }

    fun getAddOnsForVehicle(addOnsRequest: AddOnsRequest){
        viewModelScope.launch(handlerForAddOns){
            vehiclesRepository.getAddOns(addOnsRequest)
        }
    }

    fun getSuspensionFitmentVehicle(fitmentid: String ){
        viewModelScope.launch(handlerForSuspensionFitment){
            vehiclesRepository.getSuspensionFitment(fitmentid)
        }
    }

}
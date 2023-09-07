package com.atd.atdmobileapp.ui.bottomnavigation.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val sharedPrefManager: SharedPrefManager) : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _locationDetails = MutableLiveData<LocationDetails>()
    val locationDetails: LiveData<LocationDetails>
        get() = _locationDetails

    private var _dcDetails = MutableLiveData<DCDetails>()
    val dcDetails : LiveData<DCDetails>
        get() = _dcDetails


    init {
        _username.value = getUsername()
        _locationDetails.value = getLocationDetails()
        _dcDetails.value = getDcDeatils()
    }

    private fun getUsername(): String {
        var username: String
        try {
            var encodedString = sharedPrefManager.getToken().toString()
            encodedString = encodedString.substring(6)
            val decodedBytes = android.util.Base64.decode(encodedString, android.util.Base64.DEFAULT)
            val decodedString = String(decodedBytes)
            val separatorIndex = decodedString.indexOf(":")
            username = decodedString.substring(0, separatorIndex)
        } catch (e: java.lang.Exception) {
            println("Error while retrying username")
            username = ""
        }
        return username
    }

    private fun getDcDeatils(): DCDetails? {
        val locationAddress = sharedPrefManager.getSelectedLocation()
        println(locationAddress)
        val dcDetails = Gson().fromJson(locationAddress, DCDetails::class.java)


        return dcDetails
    }

    private fun getLocationDetails(): LocationDetails {
        val locationAddress = sharedPrefManager.getSelectedLocation()
        println(locationAddress)
        val dcDetails = Gson().fromJson(locationAddress, DCDetails::class.java)
        val location = dcDetails.distributioncenter.address.address1 + "\n" +
                dcDetails.distributioncenter.address.city + "," +
                dcDetails.distributioncenter.address.state + " " +
                dcDetails.distributioncenter.address.zipcode + " "

        val dc = dcDetails.distributioncenter.address.city + " (#" + dcDetails.distributioncenter.servicingdc + ")"

        return LocationDetails(location, dc, dcDetails)
    }

    data class LocationDetails(val location: String, val dc: String, val dcDetails: DCDetails)

}

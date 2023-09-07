package com.atd.atdmobileapp.ui.product.wheels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UpdateViewModel: ViewModel() {

    val wheelType = MutableLiveData<String>()
    val offsetDescription = MutableLiveData<String>()
    val seasonalDesignation = MutableLiveData<String>()
    val lugsBoltsCircle = MutableLiveData<String>()
    val diameter = MutableLiveData<ArrayList<String>>()
    val diameterWidth = MutableLiveData<ArrayList<String>>()
    val wheelFinish = MutableLiveData<ArrayList<String>>()
    val diameterList= ArrayList<String>()

    // function to send message
    fun wheelType(result: String) {
        wheelType.value = result
    }
    fun sendDiameter(result: ArrayList<String>) {
       // diameterList.removeAll { it == value }

        diameter.value = result
    }

    /*fun removeDiameter(result: String) {

        diameterList.removeAll { it == result }

        diameter.value = diameterList
    }*/
    fun getDiametre() :LiveData<ArrayList<String>>{

        return diameter
    }

    fun sendDiameterWidth(result: ArrayList<String>) {
        // diameterList.removeAll { it == value }

        diameterWidth.value = result
    }

    fun addLugsBoltsCircle(result: String) {

        lugsBoltsCircle.value=result
    }

    fun sendWheelFinish(result:  ArrayList<String>) {
      wheelFinish.value=result
    }

    fun offsetDescription(result: String) {

        offsetDescription.value=result
    }

    fun seasonalDesignation(result: String) {

        seasonalDesignation.value=result
    }
}
package com.atd.atdmobileapp.models

data class ShippingMethodResponse(
    val atdproductnumber: String,
    val sources: List<Source>
)
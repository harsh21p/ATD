package com.atd.atdmobileapp.models.vehicle

data class AddOnsRequest(
    var locationnumber: String?= null,
    var atdproductnumber: String?= null,
    val quantity: String = "4",
    var vehicleid: String?= null
)

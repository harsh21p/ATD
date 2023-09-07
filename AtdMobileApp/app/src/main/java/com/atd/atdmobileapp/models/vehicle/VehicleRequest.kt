package com.atd.atdmobileapp.models.vehicle

data class VehicleRequest(
    val year: String?= null,
    val make: String?= null,
    val model: String?= null,
    val trim: String?= null,
    val trimoption: String?= null,
    var position: String?= null,
    var vehicleid: String?= null,
    var wheeldiameter: String?= null
)

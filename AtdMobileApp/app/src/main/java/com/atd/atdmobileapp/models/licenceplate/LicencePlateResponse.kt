package com.atd.atdmobileapp.models.licenceplate

data class LicencePlateResponse(
    var licenseplatenumber: String,
    var licenseplatestate: String,
    var vehicles: List<Vehicle>
)
package com.atd.atdmobileapp.models.vehicle

data class VehicleResponse(
    val years: List<String>?= null,
    val makes: List<String>?= null,
    val models: List<String>?= null,
    val trims: List<String>?= null,
    val trimoptions: List<TrimOption>?= null
)

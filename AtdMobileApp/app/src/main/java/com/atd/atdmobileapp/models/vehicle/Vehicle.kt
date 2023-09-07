package com.atd.atdmobileapp.models.vehicle

data class Vehicle(
    var make: String,
    var model: String,
    var trims: List<Trim>,
    var year: String
)
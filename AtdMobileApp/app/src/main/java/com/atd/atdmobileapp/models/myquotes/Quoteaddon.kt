package com.atd.atdmobileapp.models.myquotes

data class Quoteaddon(
    val appliedtaxes: List<Any>,
    val applyper: String,
    val childaddons: List<Any>,
    val description: String,
    val entrynumber: String,
    val linetotal: Number,
    val name: String,
    val quantity: Number,
    val taxamount: Number,
    val type: String,
    val unitprice: Number,
    val vehicleinfo: VehicleinfoX
)
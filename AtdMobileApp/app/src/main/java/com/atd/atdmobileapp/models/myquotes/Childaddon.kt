package com.atd.atdmobileapp.models.myquotes

data class Childaddon(
    val appliedtaxes: List<Any>?= null,
    val applyper: String?= null,
    val description: String?= null,
    val entrynumber: String?= null,
    val linetotal: Double?= null,
    val name: String?= null,
    val quantity: Int?= null,
    val taxamount: Int?= null,
    val type: String?= null,
    val unitprice: Double?= null,
    val vehicleinfo: VehicleinfoX?= null
)
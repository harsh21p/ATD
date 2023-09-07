package com.atd.atdmobileapp.models.myquotes

data class Item(
    val appliedtaxes: List<AppliedTaxes> ?=null,
    val applyper: String?=null,
    val atdproductnumber: String?=null,
    val childaddons: List<Childaddon>?=null,
    val description: String?=null,
    val entrynumber: String?=null,
    val linetotal: Double?=null,
    val name: String?=null,
    val quantity: Int?=null,
    val taxamount: Number?=null,
    val type: String?=null,
    val unitprice: Double?=null,
    val vehicleinfo: VehicleinfoX?=null
)
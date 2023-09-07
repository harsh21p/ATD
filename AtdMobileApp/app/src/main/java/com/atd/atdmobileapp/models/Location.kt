package com.atd.atdmobileapp.models

data class Location(
    val address: Address,
    val customernumber: String,
    val localplusdcs: List<String>,
    val locationattributes: List<Any>,
    val locationlogourl: String,
    val locationname: String,
    val locationnumber: String,
    val phonenumber: String,
    val servicingdc: String
)
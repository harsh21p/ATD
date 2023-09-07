package com.atd.atdmobileapp.models

data class FulfillmentX(
    val estimateddelivery: String,
    val freight: Double,
    val qty: Int,
    val shipmethod: String,
    val sourcedc: String,
    val sourcedcname: String,
    val status: String
)
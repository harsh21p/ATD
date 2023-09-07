package com.atd.atdmobileapp.models

data class Fulfillment(
    val freight: Double,
    val qty: Int,
    val sourcedc: String,
    val sourcedcname: String,
    val status: String
)
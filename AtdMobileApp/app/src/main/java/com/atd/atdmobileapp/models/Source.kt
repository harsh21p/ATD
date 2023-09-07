package com.atd.atdmobileapp.models

data class Source(
    val quantity: String,
    val shippingmethod: List<Shippingmethod>,
    val sourcedc: String,
    val sourcedcname: String,
    val sourcetype: String,
    val status: String
)
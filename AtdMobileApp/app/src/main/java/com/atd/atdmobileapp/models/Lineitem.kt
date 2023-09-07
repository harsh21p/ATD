package com.atd.atdmobileapp.models

data class Lineitem(
    val atdproductnumber: String?= null,
    val quantity: Int?= null,
    val shippingmethod: String?= null,
    val quickship: Int?= null
)
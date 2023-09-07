package com.atd.atdmobileapp.models

data class LineitemCheckout(
    val atdproductnumber: String,
    val cartlinenumber: Int,
    val quantity: Int,
    val quickship: Boolean,
    val shippingmethod: String
)
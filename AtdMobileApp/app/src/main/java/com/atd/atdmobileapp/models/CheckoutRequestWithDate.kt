package com.atd.atdmobileapp.models

data class CheckoutRequestWithDate(
    val locationnumber: String,
    val order: OrderCheckout,
    val needbydate: String
)

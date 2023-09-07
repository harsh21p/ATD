package com.atd.atdmobileapp.models



data class CheckoutRequest(
    var locationnumber: String,
    var order: OrderCheckout
)
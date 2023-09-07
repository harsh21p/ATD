package com.atd.atdmobileapp.models

data class PlaceOrder(
    val OrderConfirmation: String,
    val ConsumerName: String ="",
    val Po: String,
    val datePlace :String,
    val data: CheckoutResponse?= null,
    val cartListItem: List<CartItem>?= null
)
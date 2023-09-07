package com.atd.atdmobileapp.models


data class OrderCheckout(
    val consumername: String,
    val customercomment: String,
    val customerponumber: String,
    val lineitems: List<LineitemCheckout>,
    val ordertype: String,
    val pickup: String,
    val localplus :String,
)
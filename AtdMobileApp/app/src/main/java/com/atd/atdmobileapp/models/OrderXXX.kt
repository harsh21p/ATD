package com.atd.atdmobileapp.models

data class OrderXXX(
    val confirmationnumber: String,
    val consumerdata: ConsumerdataX,
    val customercomment: String,
    val customerponumber: String,
    val localplus: Boolean,
    val orderlines: List<OrderlineX>,
    val ordertotal: Double,
    val ordertype: String,
    val pickup: Boolean
)
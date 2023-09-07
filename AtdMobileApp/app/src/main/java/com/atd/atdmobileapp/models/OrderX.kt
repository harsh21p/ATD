package com.atd.atdmobileapp.models

data class OrderX(
    val consumerdata: Consumerdata,
    val consumername: Any,
    val customercomment: Any,
    val customerponumber: String,
    val fillkill: String,
    val localplus: Boolean,
    val needbydate: Any,
    val orderlines: List<Orderline>,
    val ordertotal: Any? =0.00,
    val ordertype: String,
    val pickup: Boolean,
    val thresholdmessage: Any
)
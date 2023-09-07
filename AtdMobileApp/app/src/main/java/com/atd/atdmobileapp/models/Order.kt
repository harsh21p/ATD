package com.atd.atdmobileapp.models

data class Order(
    val customercomment: String,
    val customerponumber: String,
    val localplus: String,
    val ordertype: String,
    val pickup: String,
    val lineitems: List<Lineitem>
)


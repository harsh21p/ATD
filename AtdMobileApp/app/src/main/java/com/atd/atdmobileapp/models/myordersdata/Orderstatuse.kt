package com.atd.atdmobileapp.models.myordersdata

data class Orderstatuse(
    val confirmationnumber: String,
    val customerponumber: String,
    val dateplaced: String,
    val invoicenumbers: List<Any>,
    val ordernumbers: List<String>,
    val ordertotal: Double,
    val status: String
)
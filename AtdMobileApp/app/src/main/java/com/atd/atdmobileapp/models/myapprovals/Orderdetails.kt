package com.atd.atdmobileapp.models.myapprovals


data class Orderdetails(
    val customeraddress: String,
    val customercomments: String,
    val customername: String,
    val customernumber: String,
    val freight: Double,
    val locationnumber: String,
    val orderdetaillines: List<OrderDetaillinesItem>,
    val ordertotal: Double,
    val subtotal: String
)
package com.atd.atdmobileapp.models.orderdetails

data class Orderdetailline(
    var atdproductnumber: String,
    var billto: String,
    var cartlinenumber: Int,
    var cost: Double,
    var description: String,
    var fet: Double,
    var fulfillments: List<Fulfillment>,
    var quantity: Int
)
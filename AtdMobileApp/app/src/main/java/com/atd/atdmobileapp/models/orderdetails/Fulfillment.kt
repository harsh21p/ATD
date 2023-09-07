package com.atd.atdmobileapp.models.orderdetails

data class Fulfillment(
    var carriername: String,
    var deliveryreceiptnumber: String,
    var linetotal: Double,
    var ordernumber: String,
    var quantity: Int,
    var quantitybackordered: Int,
    var quantityreturnable: Int,
    var quantityshipped: Int,
    var shipmethod: String,
    var sourcetype: String,
    var sourcetypedc: String,
    var status: String,
    var trackingurl: String,
    var invoicenumber: String,
    var actualdeliverydate: String,
)
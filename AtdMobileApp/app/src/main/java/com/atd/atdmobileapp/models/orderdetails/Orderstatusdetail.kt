package com.atd.atdmobileapp.models.orderdetails

data class Orderstatusdetail(
    var approvedby: String,
    var confirmationnumber: String,
    var consumername: String,
    var customercomments: String,
    var customerponumber: String,
    var dateplaced: String,
    var freight: Double,
    var locationnumber: String,
    var orderdetaillines: List<Orderdetailline>,
    var ordertotal: Double,
    var pickup: String,
    var taxes: Double
)
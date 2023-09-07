package com.atd.atdmobileapp.models

data class Customer(
    val accessshiptohome: String,
    val customerclass: Customerclass,
    val customergroup: Customergroup,
    val deliverynotification: String,
    val enableautoreplenishment: String,
    val enablecustomerinventory: String,
    val isactive: String,
    val isdeliveryby: Boolean,
    val isdeliveryon: Boolean,
    val name: String,
    val number: String,
    val shipmentnotification: String,
    val type: String
)
package com.atd.atdmobileapp.models.mylist

data class Productlist(
    var name: String?="",
    var products: List<Product>?=null,
    var recurring: Boolean?=false,
    var recurringfrequency: Int?=null,
    var recurringfrequencytype: String?="",
    var recurringstartdate: String?="",
    var sharelist: String?=""
)
package com.atd.atdmobileapp.models.mylist

import java.io.Serializable

data class Product(
    var atdproductnumber: String?=null,
    var quantity: Int?=null,
    var sequencenumber: Int?=null
)  : Serializable
package com.atd.atdmobileapp.models.mylist

import java.io.Serializable

data class Productlists(
    var name: String?=null,
    var nextoccurencedate: String?=null,
    var products: ArrayList<Product>?=null,
    var recurring: Boolean?=null,
    var recurringfrequency: Int?=null,
    var recurringfrequencytype: String??=null,
    var recurringstartdate: String?=null,
    var sharelist: String?=null,
    var uid: String?=null,
)  : Serializable
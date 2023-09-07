package com.atd.atdmobileapp.models.myquotes

data class Consumerinfo(
    var email: String,
    var firstname: String,
    var lastname: String,
    var phone: String?=null,
    var address1: String?=null,
    var address2: String?=null,
    val city: String?=null,
    var zipcode: String?=null,
    var state: String?=null,
    var areacode: String?= null
)

//,"","","","","",""
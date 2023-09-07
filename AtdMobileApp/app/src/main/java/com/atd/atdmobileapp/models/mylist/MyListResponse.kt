package com.atd.atdmobileapp.models.mylist

data class MyListResponse(
    val listcreated : Boolean?=null,
    var productlist:Productlists?=null,
    var productlists: List<Productlists>?=null
)
package com.atd.atdmobileapp.models.myapprovals

data class Orderapproval(
    val cartid: String,
    val dateplaced: String,
    val orderdetails: Orderdetails,
    val status: String,
    val submittedby: String
)
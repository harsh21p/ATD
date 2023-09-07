package com.atd.atdmobileapp.models.myapprovals

data class Sourceline(
    var estimateddeliverydate: String,
    var selectedshipmethod: String,
    var sourcedc: String,
    var sourcedccity: String,
    var sourcedcstate: String,
    var sourcelinetotal: Double,
    var sourcequantity: Int
)
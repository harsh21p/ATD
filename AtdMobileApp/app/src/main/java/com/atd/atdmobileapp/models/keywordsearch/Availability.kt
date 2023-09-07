package com.atd.atdmobileapp.models.keywordsearch

data class Availability(
    var local: Int=0,
    var localplus: Int=0,
    var nationwide: Int=0,
    var onhand: Int?=null
)
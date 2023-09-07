package com.atd.atdmobileapp.models.itemreturndetails

data class ItemReturnAvailableDetailsRequest(
    var atdproductnumber: String?="",
    var confirmationnumber: String?="",
    var locationnumber: String?="",
    var ordernumber: String?=""
)
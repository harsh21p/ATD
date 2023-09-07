package com.atd.atdmobileapp.models.myquotes

data class Quoteinfo(
    val createdbyuserid: String,
    val createdon: String,
    val deletedbyuserid: String,
    val reasonfordelete: String,
    var status: String
)
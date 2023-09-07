package com.atd.atdmobileapp.models

data class OrderlineX(
    val addons: List<Any>,
    val atdproductnumber: String,
    val billto: String,
    val cartlinenumber: Int,
    val cost: Float,
    val description: String,
    val discontinued: Boolean,
    val fet: Double,
    val fulfillments: List<FulfillmentX>,
    val linetotal: Double,
    val quantityordered: Int,
    val quickship: Boolean,
    val replaced: Boolean,
    val statusmessages: List<Any>
)
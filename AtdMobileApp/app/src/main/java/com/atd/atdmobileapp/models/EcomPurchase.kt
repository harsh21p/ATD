package com.atd.atdmobileapp.models

data class EcomPurchase(
    var transaction_id: String?= null,
    var currency: String?= null,
    var shipping: Number?= null,
    var tax: Number?= null,
    var value: Number?= null,
    var totalItems: Number?= null,
    var totalQuantity: Number ?= null
)

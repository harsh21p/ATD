package com.atd.atdmobileapp.models

data class CartDisplayValue(
    var orderTotal: Double ?= null,
    var freightValue: Double ?= null,
    var subTotalValue: Double? =null
)

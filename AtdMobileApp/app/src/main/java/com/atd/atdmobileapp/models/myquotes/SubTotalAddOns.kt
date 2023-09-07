package com.atd.atdmobileapp.models.myquotes

data class SubTotalAddOns(
    var entrynumber: Number ?= null,
    var name: String ?= null,
    var description: String ?= null,
    var quantity: Number ?= null,
    var unitprice: Number ?= null,
    var linetotal: Number ?= null,
    var type: String ?= null,
    var applyper: String ?= null,
    var taxamount: Number ?= null,
    var vehicleinfo: VehicleinfoX ?= null,
    var appliedtaxes: Any ?= null

    )

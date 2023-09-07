package com.atd.atdmobileapp.models.productsearch

data class FilterOptions(
    var Availability: List<FilterItem> ?= null,
    var Size: List<FilterItem> ?= null,
    var PreferredBrands: List<FilterItem> ?= null,
    var Brands: List<FilterItem> ?= null,
    var Style: List<FilterItem> ?= null,
    var SpeedRating: List<FilterItem> ?= null,
    var MileageWarranty: List<FilterItem> ?= null,
    var SeasonalDesignation: List<FilterItem> ?= null,
    var RunFlat: List<FilterItem> ?= null,
    var MarketingPrograms: List<FilterItem> ?= null,
    var Rebates: List<FilterItem> ?= null,
    var WheelDiameter: List<FilterItem> ?= null,
    var WheelWidth: List<FilterItem> ?= null,
    var BoltPattern: List<FilterItem> ?= null,
    var ATDFinish: List<FilterItem> ?= null,
    var OffsetDescription: List<FilterItem> ?= null,
    )

class FilterItem(
    var isSelected: Boolean ?= false,
    var name: String ?= ""
)

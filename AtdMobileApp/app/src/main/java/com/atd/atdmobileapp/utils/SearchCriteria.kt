package com.atd.atdmobileapp.utils

data class SearchCriteria(
    var type: String?= null,
    var category: String?= null,
    var preferredBrandAvailable: Boolean?= null,
    var selectPreferredBrand: Boolean?= null,
    var brandsSelected: String?= null,
    var supplierNumber: String?= null,
    var productNumber: String?= null,
    var tires_subCategory: String?= null,
    var tires_size: String?= null,
    var tires_speedRating: String?= null,
    var tires_seasonalDesignation: String?= null,
    var wheels_wheelType: String?= null,
    var wheels_diameter: String?= null,
    var wheels_width: String?= null,
    var wheels_lugBolt: String?= null,
    var wheels_finish: String?= null,
    var wheels_offset: String?= null,
    var wheels_seasonalDesignation: String?= null,
    var accesories_type: String?= null,
    var supplies_type: String?= null,
    var tubes_type: String?= null
)
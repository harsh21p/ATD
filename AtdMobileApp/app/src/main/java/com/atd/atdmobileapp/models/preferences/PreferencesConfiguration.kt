package com.atd.atdmobileapp.models.preferences

data class PreferencesConfiguration(
    var showProductCost: Boolean?= null,
    var orderCutOff: Boolean?= null,
    var startOfBusiness: Boolean?= null,
    var startTime: String?= null,
    var endOfBusiness: Boolean?= null,
    var endTime: String?= null,
    var businessDays: MutableList<String>?= null,
    var availabilityFilter: String?= null,
    var myBrands: String?= null,
    var fitmentResults: String?= null,
    var productItems: ProductItems?= null,
    var visualizerOn: Boolean?= null,
    var suspensionOn: Boolean?= null,
    var sortOrder: String?= null,
    var sortOrderApiCode: String?= null
)



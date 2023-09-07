package com.atd.atdmobileapp.models.keywordsearch

data class Options(
    var availability: Availability? =null,
    var images: Images? =null,
    var includemarketingprograms: String="",
    var msrp: String?=null,
    var includerebates: String="",
    var price: Price? =null,
    var productspec: Productspec? =null
)
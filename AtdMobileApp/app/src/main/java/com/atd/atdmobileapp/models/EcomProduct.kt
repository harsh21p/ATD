package com.atd.atdmobileapp.models

import com.atd.atdmobileapp.models.keywordsearch.AvailabilityX

data class EcomProduct(

    var item_id: String?= null,
    var item_name: String?= null,
    var quantity: Number?= null,
    var affiliation: String?= null,
    var coupon: String?= null,
    var discount: Number?= null,
    var index: Number?= null,
    var item_brand: String?= null,
    var item_category: String?= null,
    var item_list_name: String?= null,
    var item_list_id: String?= null,
    var item_variant: String?= null,
    var price: Number?= null,
    var currency: String?= null,
    var promotion_id: String?= null,
    var promotion_name: String?= null,
    var cost: String?= null,
    var retail: String?= null,
    var map: String?= null,
    var hasRebates: Number?= null,
    var availability: AvailabilityX?= null
    )
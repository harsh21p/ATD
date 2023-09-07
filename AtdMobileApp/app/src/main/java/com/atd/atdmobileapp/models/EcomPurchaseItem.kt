package com.atd.atdmobileapp.models

data class EcomPurchaseItem(
    var item_id: String?= null,
    var item_name: String?= null,
    var quantity: Number?= null,
    var item_brand: String?= null,
    var currency: String= "USD",
    var item_category: String?= null,
    var item_variant: String?= null,
    var tax: Number?= null, //fet
    var price: Number?= null, //unit price
    var lineItemNum: Number?= null,
    var sku: String?= null,
    var total: Number?= null,
    var status: String?= null,
    var freight: Number?= null,
    var shippingMethod: String?= null,
    var shippingDC: String?= null
)

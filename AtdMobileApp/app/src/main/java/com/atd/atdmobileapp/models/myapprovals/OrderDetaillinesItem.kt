package com.atd.atdmobileapp.models.myapprovals

data class OrderDetaillinesItem(
    var billto: String,
    var cartlinenumber: Int,
    var product: Product,
    var sourcelines: List<Sourceline>
)
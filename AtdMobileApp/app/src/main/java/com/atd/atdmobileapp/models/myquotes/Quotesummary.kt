package com.atd.atdmobileapp.models.myquotes

data class Quotesummary(
    val subtotal: String,
    val subtotaladdons: List<SubTotalAddOns>,
    val taxtotal: String,
    val total: String
)
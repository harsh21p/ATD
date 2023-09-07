package com.atd.atdmobileapp.models.myquotes

import com.atd.atdmobileapp.models.keywordsearch.Product

data class Retailquote(
    val companyinfo: Companyinfo,
    var consumerinfo: Consumerinfo,
    val items: List<Item>,
    val quoteaddons: List<Quoteaddon>,
    val quotecomments: List<QuoteComment>,
    var quoteinfo: Quoteinfo,
    val quotesummary: Quotesummary,
    var retailquoteid: String,
    var products: List<Product>?= null
)
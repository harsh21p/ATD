package com.atd.atdmobileapp.models.keywordsearch

import java.io.Serializable

data class ProductByKeywordResponse(
    var products: List<Product>
) : Serializable
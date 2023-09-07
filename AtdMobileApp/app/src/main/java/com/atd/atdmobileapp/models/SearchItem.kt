package com.atd.atdmobileapp.models

import com.atd.atdmobileapp.models.keywordsearch.PriceX
import com.atd.atdmobileapp.models.keywordsearch.Product
import com.atd.atdmobileapp.models.keywordsearch.ProductspecX

data class SearchItem(
    val product: Product,
    val isVisualizerAvailable: Boolean?= null,
    val oeProduct: Boolean?= null,
    val title: String?= null,
    val details: Any?= null,
    val productspec: ProductspecX?= null,
    val productgroup: String?= null,
    val price: PriceX ?=null,
    val imageThumbUrl: String?= null,
    val imageProductUrl: String?= null,
    val defaultQuantity: Number?= null,
    val cardElipsisState: Boolean?= null
)

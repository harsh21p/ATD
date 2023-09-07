package com.atd.atdmobileapp.models.productsearch

import com.atd.atdmobileapp.models.keywordsearch.Options

data class ProductByCriteriaRequest(var locationnumber: String="",
                                    var options: Options? =null,
                                    var criteria: Criteria? =null
)

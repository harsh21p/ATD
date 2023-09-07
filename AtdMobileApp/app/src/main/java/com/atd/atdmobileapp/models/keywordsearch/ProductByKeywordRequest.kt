package com.atd.atdmobileapp.models.keywordsearch

data class ProductByKeywordRequest(
    var keywords: String="",
    var locationnumber: String="",
    var options: Options? =null
)
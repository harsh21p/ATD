package com.atd.atdmobileapp.api

import com.atd.atdmobileapp.models.Brandgroup
import com.atd.atdmobileapp.models.BrandsRequest
import com.atd.atdmobileapp.models.BrandsResponse
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest
import com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse
import com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductsApi {
    @POST("/rs/3_6/product/brands")
    suspend fun getBrandsForTires(@Body body: BrandsRequest) : Response<BrandsResponse>
    @POST("/rs/3_6/product/product-by-keyword")
    suspend fun getProductByKeyword( @Body Request: ProductByKeywordRequest) : Response<ProductByKeywordResponse>
    @POST("/rs/3_6/product/product-by-criteria")
    suspend fun getProductByCriteria( @Body Request: ProductByCriteriaRequest) : Response<ProductByKeywordResponse>
}
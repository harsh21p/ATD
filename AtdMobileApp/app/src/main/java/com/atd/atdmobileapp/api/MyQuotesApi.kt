package com.atd.atdmobileapp.api


import com.atd.atdmobileapp.models.myquotes.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface MyQuotesApi {


   // https://mblqa.atdconnect.com/rs/3_6/order/order-status
   /* @Headers("Accept: application/json",
            "clientId: ATD_TEST_01",
            "clientWebsite: atdonline")*/
    //https://mblqa.atdconnect.com/rs/3_6/retail-quote/fetch-retail-quote
    @POST("/rs/3_6/retail-quote/fetch-retail-quote")
    suspend fun getMyQuotess( @Body myOrderRequest: MyQuotesRequest) : Response<MyQuotesData>

    @GET("/rs/3_6/retail-quote/retail-quote-statuses/{locationNumber}")
    suspend fun getRetailQuoteStatus(@Path("locationNumber") locationNumber: String) : Response<QuoteStatusResponse>

    @POST("/rs/3_6/retail-quote/create-retail-quote")
    suspend fun createRetailQuote( @Body createQuoteRequest: CreateQuoteRequest) : Response<CreateRetailQuoteResponse>

    @POST("/rs/3_6/retail-quote/update-retail-quote")
    suspend fun updateRetailQuote(@Body updateRequestBody: UpdateRequestBody): Response<MyQuotesData>
}
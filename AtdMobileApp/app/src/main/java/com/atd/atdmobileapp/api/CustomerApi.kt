package com.atd.atdmobileapp.api

import com.atd.atdmobileapp.models.CustomerDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerApi {
    @GET("/rs/3_6/customer/customers-by-location/{locationNumber}")
    suspend fun getCustomerDetails(@Path("locationNumber") locationNumber: String) : Response<CustomerDetailsResponse>
}
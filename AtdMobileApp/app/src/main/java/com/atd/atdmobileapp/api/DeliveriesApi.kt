package com.atd.atdmobileapp.api


import com.atd.atdmobileapp.models.DeliveryDayRequest
import com.atd.atdmobileapp.models.DeliveryDaysResponse
import com.atd.atdmobileapp.models.ShippingMethodRequest
import com.atd.atdmobileapp.models.ShippingMethodResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DeliveriesApi {
    @POST("/rs/3_6/delivery/shipping-methods")
    suspend fun getShippingDetails(@Body body: ShippingMethodRequest) : Response<ShippingMethodResponse>

    @POST("/rs/3_6/delivery/route/delivery-days")
    suspend fun getDeliveryDays(@Body body: DeliveryDayRequest) : Response<DeliveryDaysResponse>
}
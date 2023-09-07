package com.atd.atdmobileapp.api


import com.atd.atdmobileapp.models.*
import com.atd.atdmobileapp.models.approveorder.ApproveOrder
import com.atd.atdmobileapp.models.approveorder.ApproveResponse
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableDetailsRequest
import com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse
import com.atd.atdmobileapp.models.myapprovals.MyApprovalsData
import com.atd.atdmobileapp.models.myordersdata.MyOrderRequest
import com.atd.atdmobileapp.models.myordersdata.MyOrdersData
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsRequest
import com.atd.atdmobileapp.models.orderdetails.OrderDetailsResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface OrderApi {

    @POST("/rs/3_6/order/order-status")
    suspend fun getMyOrders(@Body myOrderRequest: MyOrderRequest): Response<MyOrdersData>

    @POST("/rs/3_6/order/order-status")
    suspend fun getDateRangeOrders(@Body myOrderRequest: RequestBody): Response<MyOrdersData>

    //https://mblqa.atdconnect.com/rs/3_6/order/order-approval-status/118425
    @GET("/rs/3_6/order/order-approval-status/{locationNumber}")
    suspend fun getMyApprovals(@Path("locationNumber") locationNumber: String): Response<MyApprovalsData>

    @POST("/rs/3_6/order/preview-order")
    suspend fun getCartDetails(@Body cartRequest: CartRequest): Response<CartResponse>

    //https://mblqa.atdconnect.com/rs/3_6/order/order-status-detail
    @POST("/rs/3_6/order/order-status-detail")
    suspend fun getOrderDetails(@Body request: OrderDetailsRequest): Response<OrderDetailsResponse>

    //https://mblqa.atdconnect.com/rs/3_6/rma-return/get-returnable-quantity
    @POST("/rs/3_6/rma-return/get-returnable-quantity")
    suspend fun getReturnDetails(@Body request: ItemReturnAvailableDetailsRequest): Response<ItemReturnAvailableResponse>


    // https://mblqa.atdconnect.com/rs/3_6/order/order-approval/approve-order
    @POST("/rs/3_6/order/order-approval/approve-order")
    suspend fun approveOrder(@Body request: ApproveOrder): Response<ApproveResponse>

    @POST("/rs/3_6/order/place-order")
    suspend fun placeOrder(@Body request: CheckoutRequest): Response<CheckoutResponse>

    @POST("/rs/3_6/order/place-order")
    suspend fun placeOrderWithDate(@Body request: CheckoutRequestWithDate): Response<CheckoutResponse>
}
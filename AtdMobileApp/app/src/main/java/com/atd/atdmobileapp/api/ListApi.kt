package com.atd.atdmobileapp.api

import androidx.room.Delete
import com.atd.atdmobileapp.models.mylist.CreateListRequest
import com.atd.atdmobileapp.models.mylist.DeleteItemResp
import com.atd.atdmobileapp.models.mylist.MyListResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListApi {
    //https://mbl.atdconnect.com/rs/3_6/list/118425
    @GET("/rs/3_6/list/{locationNumber}")
    suspend fun getList(@Path("locationNumber") locationNumber: String) : Response<MyListResponse>

    @POST("/rs/3_6/list/{locationNumber}")
    suspend fun saveList(@Path("locationNumber") locationNumber: String, @Body request:CreateListRequest) : Response<MyListResponse>

    //ist/{locationnumber}/{list name}

    @PUT("/rs/3_6/list/{locationNumber}/{listname}")
    suspend fun updateList(@Path("locationNumber") locationNumber: String, @Path("listname") listname: String, @Body request: MyListResponse) : Response<MyListResponse>

    // /rs/3_6/list/{locationnumber}/{list name}/{productnumber_to_delete}
    @DELETE("/rs/3_6/list/{locationNumber}/{listname}/{productnumber_to_delete}")
    suspend fun DeleteItemFromList(@Path("locationNumber") locationNumber: String, @Path("listname") listname: String, @Path("productnumber_to_delete") productnumber: String) : Response<DeleteItemResp>

    @DELETE("/rs/3_6/list/{locationNumber}/{listname}")
    suspend fun deleteList(@Path("locationNumber") locationNumber: String, @Path("listname") listname: String) : Response<DeleteItemResp>

}
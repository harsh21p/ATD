package com.atd.atdmobileapp.api

import com.atd.atdmobileapp.models.UserResponse
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationRequest
import com.atd.atdmobileapp.models.locationconfig.ConfigLocationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {
    @GET("/rs/3_6/user/users-by-username")
    suspend fun login( @Query("username") userName :String) :Response<UserResponse>

    @POST("/rs/3_6/user/location-configurations")
    suspend fun getLocationsConfigure(@Body location: ConfigLocationRequest) :Response<ConfigLocationResponse>
}
package com.atd.atdmobileapp.api

import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.models.keywordsearch.CutOffTimesData
import com.atd.atdmobileapp.models.SelectLocationResponse
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LocationApi {

    //https://ws.atdconnect.com/rs/3_6/location/distribution-center/070
    @GET("/rs/3_6/location/distribution-center/{dcNumber}")
    suspend fun getLocations( @Path("dcNumber") dcNumber :String) : Response<DCDetails>

    @POST("/rs/3_6/location/location-by-criteria")
    suspend fun getLocationsToSave(@Body body: JSONObject) :Response<SelectLocationResponse>

    // https://mblqa.atdconnect.com/rs/3_6/location/cut-off-times/118425
    @GET("/rs/3_6/location/cut-off-times/{locationnumber}")
    suspend fun getCutOffTimes( @Path("locationnumber") dcNumber :String) : Response<CutOffTimesData>



}
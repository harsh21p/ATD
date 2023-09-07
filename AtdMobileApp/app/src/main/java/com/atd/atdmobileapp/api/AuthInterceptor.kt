package com.atd.atdmobileapp.api

import android.content.Context
import android.net.ConnectivityManager
import com.atd.atdmobileapp.BuildConfig
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.NoInternetException
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class AuthInterceptor @Inject constructor(@ApplicationContext context: Context) :Interceptor {

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private val applicationContext = context

    override fun intercept(chain: Interceptor.Chain): Response {
        val request =chain.request().newBuilder()
        val token =sharedPrefManager.getToken()
        request.addHeader(Constants.AUTHORIZATION, token)
        request.addHeader(Constants.CLIENTID,Constants.ATD_MOBILE)
     //   request.addHeader("clientWebsite","atdonline")
        if(!isInternetAvailable())
            //throw NoInternetException(Constants.IS_INTERNET_AVAILABLE)
           return createErrorResponse(Constants.IS_INTERNET_AVAILABLE)
        return try {
            chain.proceed(request.build())
        } catch (e: SocketTimeoutException) {
            //throw TimeoutException("Request timed out. Please try again.")
            return createErrorResponse("Request timed out. Please try again.")
        }
    }

    private fun createErrorResponse(errorMessage: String): Response {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }

        return Response.Builder()
            .code(408)
            .message(errorMessage)
            .protocol(Protocol.HTTP_1_1)
            .request(Request.Builder().url(baseUrl).build())
            .body(ResponseBody.create(null, errorMessage))
            .build()
    }

    private fun isInternetAvailable() :Boolean{
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager
        connectivityManager.activeNetwork.also {
            return it != null
        }
    }
}
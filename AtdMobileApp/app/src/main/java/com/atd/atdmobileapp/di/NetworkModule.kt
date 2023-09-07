package com.atd.atdmobileapp.di

import android.app.Application
import android.content.Context
import com.atd.atdmobileapp.BuildConfig
import com.atd.atdmobileapp.api.*
import com.atd.atdmobileapp.utils.CertificateHelper
import com.atd.atdmobileapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        level = HttpLoggingInterceptor.Level.HEADERS
    }

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
    @Singleton
    @Provides
    fun provideCertificateHelper(context: Context): CertificateHelper {
        return CertificateHelper(context)
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder():Retrofit.Builder{
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(authInterceptor: AuthInterceptor,certificateHelper: CertificateHelper) :OkHttpClient{
        val trustManagers = certificateHelper.createTrustManagers()
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagers, null)
        return OkHttpClient().newBuilder()
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            //.sslSocketFactory(sslContext.socketFactory, trustManagers[0] as X509TrustManager)
            .build()
    }


    @Singleton
    @Provides
    fun provideUserApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) :UserApi {
        return retrofitBuilder
            .client(okHttpClient)
            .build().create(UserApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLocationApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) :LocationApi {
        return retrofitBuilder
            .client(okHttpClient)
            .build().create(LocationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOrderApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : OrderApi {

        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(OrderApi::class.java)
    }

    @Singleton
    @Provides
    fun provideQuotesApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : MyQuotesApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(MyQuotesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideListApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : ListApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(ListApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductsApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : ProductsApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(ProductsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideVehiclesApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : VehiclesApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(VehiclesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCustomerApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : CustomerApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(CustomerApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDeliveriesApi(retrofitBuilder: Retrofit.Builder ,okHttpClient: OkHttpClient) : DeliveriesApi {
        val baseUrl = when (BuildConfig.BUILD_TYPE) {
            "release" -> BuildConfig.BASE_URL
            "debug" -> BuildConfig.BASE_URL
            "dev" -> BuildConfig.BASE_URL
            "qa" -> BuildConfig.BASE_URL
            "xat" -> BuildConfig.BASE_URL
            else -> BuildConfig.BASE_URL
        }
        return retrofitBuilder
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build().create(DeliveriesApi::class.java)
    }

}
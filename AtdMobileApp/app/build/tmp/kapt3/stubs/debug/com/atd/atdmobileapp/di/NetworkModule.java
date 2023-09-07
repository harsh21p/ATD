package com.atd.atdmobileapp.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\"\u001a\u00020\u000fH\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/atd/atdmobileapp/di/NetworkModule;", "", "()V", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideApplicationContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "provideCertificateHelper", "Lcom/atd/atdmobileapp/utils/CertificateHelper;", "context", "provideCustomerApi", "Lcom/atd/atdmobileapp/api/CustomerApi;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideDeliveriesApi", "Lcom/atd/atdmobileapp/api/DeliveriesApi;", "provideListApi", "Lcom/atd/atdmobileapp/api/ListApi;", "provideLocationApi", "Lcom/atd/atdmobileapp/api/LocationApi;", "provideOkhttpClient", "authInterceptor", "Lcom/atd/atdmobileapp/api/AuthInterceptor;", "certificateHelper", "provideOrderApi", "Lcom/atd/atdmobileapp/api/OrderApi;", "provideProductsApi", "Lcom/atd/atdmobileapp/api/ProductsApi;", "provideQuotesApi", "Lcom/atd/atdmobileapp/api/MyQuotesApi;", "provideRetrofitBuilder", "provideUserApi", "Lcom/atd/atdmobileapp/api/UserApi;", "provideVehiclesApi", "Lcom/atd/atdmobileapp/api/VehiclesApi;", "app_debug"})
@dagger.Module
public final class NetworkModule {
    private final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    
    public NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final android.content.Context provideApplicationContext(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.utils.CertificateHelper provideCertificateHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final retrofit2.Retrofit.Builder provideRetrofitBuilder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final okhttp3.OkHttpClient provideOkhttpClient(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.AuthInterceptor authInterceptor, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.CertificateHelper certificateHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.UserApi provideUserApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.LocationApi provideLocationApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.OrderApi provideOrderApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.MyQuotesApi provideQuotesApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.ListApi provideListApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.ProductsApi provideProductsApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.VehiclesApi provideVehiclesApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.CustomerApi provideCustomerApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.atd.atdmobileapp.api.DeliveriesApi provideDeliveriesApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder, @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
}
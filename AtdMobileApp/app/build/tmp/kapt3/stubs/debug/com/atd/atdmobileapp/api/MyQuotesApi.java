package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/atd/atdmobileapp/api/MyQuotesApi;", "", "createRetailQuote", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/myquotes/CreateRetailQuoteResponse;", "createQuoteRequest", "Lcom/atd/atdmobileapp/models/myquotes/CreateQuoteRequest;", "(Lcom/atd/atdmobileapp/models/myquotes/CreateQuoteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyQuotess", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesData;", "myOrderRequest", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesRequest;", "(Lcom/atd/atdmobileapp/models/myquotes/MyQuotesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRetailQuoteStatus", "Lcom/atd/atdmobileapp/models/myquotes/QuoteStatusResponse;", "locationNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRetailQuote", "updateRequestBody", "Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;", "(Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MyQuotesApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/retail-quote/fetch-retail-quote")
    public abstract java.lang.Object getMyQuotess(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.myquotes.MyQuotesRequest myOrderRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/retail-quote/retail-quote-statuses/{locationNumber}")
    public abstract java.lang.Object getRetailQuoteStatus(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myquotes.QuoteStatusResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/retail-quote/create-retail-quote")
    public abstract java.lang.Object createRetailQuote(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.myquotes.CreateQuoteRequest createQuoteRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myquotes.CreateRetailQuoteResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/retail-quote/update-retail-quote")
    public abstract java.lang.Object updateRetailQuote(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.myquotes.UpdateRequestBody updateRequestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> continuation);
}
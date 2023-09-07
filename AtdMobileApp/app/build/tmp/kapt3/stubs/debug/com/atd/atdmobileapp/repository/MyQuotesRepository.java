package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0%H\u0002J\u0016\u0010&\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%H\u0002J\u0016\u0010\'\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%H\u0002J\u0016\u0010(\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0%H\u0002J\u0019\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/atd/atdmobileapp/repository/MyQuotesRepository;", "", "myQuotesApi", "Lcom/atd/atdmobileapp/api/MyQuotesApi;", "(Lcom/atd/atdmobileapp/api/MyQuotesApi;)V", "_QuotesLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesData;", "createQuotesLiveData", "Lcom/atd/atdmobileapp/models/myquotes/CreateRetailQuoteResponse;", "getCreateQuotesLiveData", "()Landroidx/lifecycle/MutableLiveData;", "myQuotesLiveData", "Landroidx/lifecycle/LiveData;", "getMyQuotesLiveData", "()Landroidx/lifecycle/LiveData;", "quotesStatusLiveData", "Lcom/atd/atdmobileapp/models/myquotes/QuoteStatusResponse;", "getQuotesStatusLiveData", "updateQuoteLiveData", "getUpdateQuoteLiveData", "createRetailQuote", "", "createQuoteRequest", "Lcom/atd/atdmobileapp/models/myquotes/CreateQuoteRequest;", "(Lcom/atd/atdmobileapp/models/myquotes/CreateQuoteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyQuotes", "myQuotesRequest", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesRequest;", "(Lcom/atd/atdmobileapp/models/myquotes/MyQuotesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRetailQuoteStatus", "locationNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "Lretrofit2/Response;", "handleResponseCreateQuote", "handleResponseQuoteStatus", "handleResponseUpdateQuote", "updateRetailQuote", "updateRequestBody", "Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;", "(Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MyQuotesRepository {
    private final com.atd.atdmobileapp.api.MyQuotesApi myQuotesApi = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> _QuotesLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.QuoteStatusResponse>> quotesStatusLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.CreateRetailQuoteResponse>> createQuotesLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> updateQuoteLiveData = null;
    
    @javax.inject.Inject
    public MyQuotesRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.MyQuotesApi myQuotesApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> getMyQuotesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.QuoteStatusResponse>> getQuotesStatusLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.CreateRetailQuoteResponse>> getCreateQuotesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> getUpdateQuoteLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMyQuotes(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.MyQuotesRequest myQuotesRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.myquotes.MyQuotesData> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRetailQuoteStatus(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponseQuoteStatus(retrofit2.Response<com.atd.atdmobileapp.models.myquotes.QuoteStatusResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createRetailQuote(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.CreateQuoteRequest createQuoteRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponseCreateQuote(retrofit2.Response<com.atd.atdmobileapp.models.myquotes.CreateRetailQuoteResponse> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateRetailQuote(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.UpdateRequestBody updateRequestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponseUpdateQuote(retrofit2.Response<com.atd.atdmobileapp.models.myquotes.MyQuotesData> response) {
    }
}
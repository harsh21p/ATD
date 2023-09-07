package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u00a8\u0006 "}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/MyQuotesViewModel;", "Landroidx/lifecycle/ViewModel;", "myQuotesRepository", "Lcom/atd/atdmobileapp/repository/MyQuotesRepository;", "(Lcom/atd/atdmobileapp/repository/MyQuotesRepository;)V", "createQuoteLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/myquotes/CreateRetailQuoteResponse;", "getCreateQuoteLiveData", "()Landroidx/lifecycle/LiveData;", "myQuotesResponseLiveData", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesData;", "getMyQuotesResponseLiveData", "quotesStatusLiveData", "Lcom/atd/atdmobileapp/models/myquotes/QuoteStatusResponse;", "getQuotesStatusLiveData", "updateQuoteLiveData", "getUpdateQuoteLiveData", "createRetailQuote", "", "createQuoteRequest", "Lcom/atd/atdmobileapp/models/myquotes/CreateQuoteRequest;", "getMyQuotess", "myQuotesRequest", "Lcom/atd/atdmobileapp/models/myquotes/MyQuotesRequest;", "getRetailQuoteStatus", "locationNumber", "", "updateRetailQuote", "updateRequestBody", "Lcom/atd/atdmobileapp/models/myquotes/UpdateRequestBody;", "app_release"})
public final class MyQuotesViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.MyQuotesRepository myQuotesRepository = null;
    
    @javax.inject.Inject
    public MyQuotesViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyQuotesRepository myQuotesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> getMyQuotesResponseLiveData() {
        return null;
    }
    
    public final void getMyQuotess(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.MyQuotesRequest myQuotesRequest) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.QuoteStatusResponse>> getQuotesStatusLiveData() {
        return null;
    }
    
    public final void getRetailQuoteStatus(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.CreateRetailQuoteResponse>> getCreateQuoteLiveData() {
        return null;
    }
    
    public final void createRetailQuote(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.CreateQuoteRequest createQuoteRequest) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.myquotes.MyQuotesData>> getUpdateQuoteLiveData() {
        return null;
    }
    
    public final void updateRetailQuote(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.UpdateRequestBody updateRequestBody) {
    }
}
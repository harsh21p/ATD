package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tR \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/atd/atdmobileapp/repository/RDBKeywordSearchRepository;", "", "dao", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;", "(Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;)V", "_productByKeywordResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchEntity;", "getDao", "()Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;", "productByKeywordResponse", "Landroidx/lifecycle/LiveData;", "getProductByKeywordResponse", "()Landroidx/lifecycle/LiveData;", "getKeywordResp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "saveKeyword", "Lkotlinx/coroutines/Job;", "Keyword", "updateKeyword", "app_release"})
public final class RDBKeywordSearchRepository {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO dao = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity>>> _productByKeywordResponseLiveData = null;
    
    @javax.inject.Inject
    public RDBKeywordSearchRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO getDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveKeyword(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity Keyword) {
        return null;
    }
    
    public final void updateKeyword(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity Keyword) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity>>> getProductByKeywordResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getKeywordResp(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity> response) {
    }
}
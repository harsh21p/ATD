package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0002R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/atd/atdmobileapp/repository/ProductByCriteriaRepository;", "", "productApi", "Lcom/atd/atdmobileapp/api/ProductsApi;", "(Lcom/atd/atdmobileapp/api/ProductsApi;)V", "_productByCriteriaResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordResponse;", "get_productByCriteriaResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getProductByCriteria", "", "productByCriteriaRequest", "Lcom/atd/atdmobileapp/models/productsearch/ProductByCriteriaRequest;", "(Lcom/atd/atdmobileapp/models/productsearch/ProductByCriteriaRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "response", "Lretrofit2/Response;", "app_release"})
public final class ProductByCriteriaRepository {
    private final com.atd.atdmobileapp.api.ProductsApi productApi = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> _productByCriteriaResponseLiveData = null;
    
    @javax.inject.Inject
    public ProductByCriteriaRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.ProductsApi productApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> get_productByCriteriaResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getProductByCriteria(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest productByCriteriaRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse> response) {
    }
}
package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/atd/atdmobileapp/api/ProductsApi;", "", "getBrandsForTires", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/BrandsResponse;", "body", "Lcom/atd/atdmobileapp/models/BrandsRequest;", "(Lcom/atd/atdmobileapp/models/BrandsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductByCriteria", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordResponse;", "Request", "Lcom/atd/atdmobileapp/models/productsearch/ProductByCriteriaRequest;", "(Lcom/atd/atdmobileapp/models/productsearch/ProductByCriteriaRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductByKeyword", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordRequest;", "(Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface ProductsApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/product/brands")
    public abstract java.lang.Object getBrandsForTires(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.BrandsRequest body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.BrandsResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/product/product-by-keyword")
    public abstract java.lang.Object getProductByKeyword(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest Request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/product/product-by-criteria")
    public abstract java.lang.Object getProductByCriteria(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest Request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> continuation);
}
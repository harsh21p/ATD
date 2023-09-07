package com.atd.atdmobileapp.ui.product;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/ProductViewModel;", "Landroidx/lifecycle/ViewModel;", "productsRepository", "Lcom/atd/atdmobileapp/repository/ProductsRepository;", "(Lcom/atd/atdmobileapp/repository/ProductsRepository;)V", "brandsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/BrandsResponse;", "getBrandsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "productByCriteriaResponse", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordResponse;", "getProductByCriteriaResponse", "getOtherBrands", "", "brandsRequest", "Lcom/atd/atdmobileapp/models/BrandsRequest;", "getProductByCriteria", "productByCriteriaRequest", "Lcom/atd/atdmobileapp/models/productsearch/ProductByCriteriaRequest;", "app_debug"})
public final class ProductViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.ProductsRepository productsRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    
    @javax.inject.Inject
    public ProductViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.ProductsRepository productsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> getProductByCriteriaResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.BrandsResponse>> getBrandsLiveData() {
        return null;
    }
    
    public final void getProductByCriteria(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.productsearch.ProductByCriteriaRequest productByCriteriaRequest) {
    }
    
    public final void getOtherBrands(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.BrandsRequest brandsRequest) {
    }
}
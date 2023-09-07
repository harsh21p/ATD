package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordsearchresults/ProductByKeywordViewModel;", "Landroidx/lifecycle/ViewModel;", "Repository", "Lcom/atd/atdmobileapp/repository/ProductByKeywordRepository;", "(Lcom/atd/atdmobileapp/repository/ProductByKeywordRepository;)V", "productByKeywordLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordResponse;", "getProductByKeywordLiveData", "()Landroidx/lifecycle/LiveData;", "getProductByKeyword", "", "productByKeywordRequest", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordRequest;", "getProductByKeywordWithResults", "app_debug"})
public final class ProductByKeywordViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.ProductByKeywordRepository Repository = null;
    
    @javax.inject.Inject
    public ProductByKeywordViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.ProductByKeywordRepository Repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> getProductByKeywordLiveData() {
        return null;
    }
    
    public final void getProductByKeyword(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest productByKeywordRequest) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse>> getProductByKeywordWithResults(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordRequest productByKeywordRequest) {
        return null;
    }
}
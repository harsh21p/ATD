package com.atd.atdmobileapp.ui.product.tires.brands;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/tires/brands/TiresBrandsViewModel;", "Landroidx/lifecycle/ViewModel;", "productsRepository", "Lcom/atd/atdmobileapp/repository/ProductsRepository;", "locationConfigurationRepository", "Lcom/atd/atdmobileapp/repository/LocationConfigurationRepository;", "(Lcom/atd/atdmobileapp/repository/ProductsRepository;Lcom/atd/atdmobileapp/repository/LocationConfigurationRepository;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "preferredBrandsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/models/locationconfig/Locationconfiguration;", "getPreferredBrandsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "tiresBrandsLiveData", "Lcom/atd/atdmobileapp/models/BrandsResponse;", "getTiresBrandsLiveData", "getOtherBrands", "", "brandsRequest", "Lcom/atd/atdmobileapp/models/BrandsRequest;", "getPreferredBrandConfigurationList", "app_release"})
public final class TiresBrandsViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.ProductsRepository productsRepository = null;
    private final com.atd.atdmobileapp.repository.LocationConfigurationRepository locationConfigurationRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    
    @javax.inject.Inject
    public TiresBrandsViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.ProductsRepository productsRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.LocationConfigurationRepository locationConfigurationRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.BrandsResponse>> getTiresBrandsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.models.locationconfig.Locationconfiguration>>> getPreferredBrandsLiveData() {
        return null;
    }
    
    public final void getOtherBrands(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.BrandsRequest brandsRequest) {
    }
    
    public final void getPreferredBrandConfigurationList() {
    }
}
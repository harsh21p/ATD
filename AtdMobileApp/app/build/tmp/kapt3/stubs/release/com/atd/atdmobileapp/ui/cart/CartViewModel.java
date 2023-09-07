package com.atd.atdmobileapp.ui.cart;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00150\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "orderRepository", "Lcom/atd/atdmobileapp/repository/MyOrderRepository;", "(Lcom/atd/atdmobileapp/utils/FirestoreRepository;Lcom/atd/atdmobileapp/repository/MyOrderRepository;)V", "cartResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/CartResponse;", "getCartResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "deleteStatus", "", "getDeleteStatus", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "loadingLiveData", "getLoadingLiveData", "userLiveData", "", "Lcom/atd/atdmobileapp/models/Cart;", "getUserLiveData", "deleteUser", "", "documentName", "", "getAllCartRecords", "userName", "locationNumber", "getCartDetails", "cartRequest", "Lcom/atd/atdmobileapp/models/CartRequest;", "app_release"})
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    private final com.atd.atdmobileapp.repository.MyOrderRepository orderRepository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loadingLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> userLiveData = null;
    
    @javax.inject.Inject
    public CartViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyOrderRepository orderRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> getCartResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoadingLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getDeleteStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> getUserLiveData() {
        return null;
    }
    
    public final void getCartDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CartRequest cartRequest) {
    }
    
    public final void getAllCartRecords(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull
    java.lang.String documentName) {
    }
}
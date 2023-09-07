package com.atd.atdmobileapp.ui.cart.checkout;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/checkout/CheckoutViewModel;", "Landroidx/lifecycle/ViewModel;", "myOrderRepository", "Lcom/atd/atdmobileapp/repository/MyOrderRepository;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "(Lcom/atd/atdmobileapp/repository/MyOrderRepository;Lcom/atd/atdmobileapp/utils/FirestoreRepository;)V", "deleteStatus", "Landroidx/lifecycle/MutableLiveData;", "", "getDeleteStatus", "()Landroidx/lifecycle/MutableLiveData;", "placeOrderFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/CheckoutResponse;", "getPlaceOrderFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteRecord", "", "cartItemsToDelete", "", "Lcom/atd/atdmobileapp/models/DeleteCartItems;", "placeOrder", "checkoutRequest", "Lcom/atd/atdmobileapp/models/CheckoutRequest;", "placeOrderWithDate", "checkoutRequestWithDate", "Lcom/atd/atdmobileapp/models/CheckoutRequestWithDate;", "app_release"})
public final class CheckoutViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository = null;
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CheckoutResponse>> placeOrderFlow = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteStatus = null;
    
    @javax.inject.Inject
    public CheckoutViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CheckoutResponse>> getPlaceOrderFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getDeleteStatus() {
        return null;
    }
    
    public final void placeOrder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CheckoutRequest checkoutRequest) {
    }
    
    public final void placeOrderWithDate(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CheckoutRequestWithDate checkoutRequestWithDate) {
    }
    
    public final void deleteRecord(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.DeleteCartItems> cartItemsToDelete) {
    }
}
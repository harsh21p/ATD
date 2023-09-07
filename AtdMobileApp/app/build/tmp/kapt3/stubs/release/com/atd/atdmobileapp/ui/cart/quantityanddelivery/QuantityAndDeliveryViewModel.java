package com.atd.atdmobileapp.ui.cart.quantityanddelivery;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001eJ\u001e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\r0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006/"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/quantityanddelivery/QuantityAndDeliveryViewModel;", "Landroidx/lifecycle/ViewModel;", "deliveriesRepository", "Lcom/atd/atdmobileapp/repository/DeliveriesRepository;", "customerRepository", "Lcom/atd/atdmobileapp/repository/CustomerRepository;", "myOrderRepository", "Lcom/atd/atdmobileapp/repository/MyOrderRepository;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "(Lcom/atd/atdmobileapp/repository/DeliveriesRepository;Lcom/atd/atdmobileapp/repository/CustomerRepository;Lcom/atd/atdmobileapp/repository/MyOrderRepository;Lcom/atd/atdmobileapp/utils/FirestoreRepository;)V", "cartDetailsLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/CartResponse;", "getCartDetailsLiveData", "()Landroidx/lifecycle/LiveData;", "customerDetailsLiveData", "Lcom/atd/atdmobileapp/models/CustomerDetailsResponse;", "getCustomerDetailsLiveData", "deleteStatus", "Landroidx/lifecycle/MutableLiveData;", "", "getDeleteStatus", "()Landroidx/lifecycle/MutableLiveData;", "shippingDetailsLiveData", "Lcom/atd/atdmobileapp/models/ShippingMethodResponse;", "getShippingDetailsLiveData", "updateFireStoreFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getUpdateFireStoreFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "deleteRecord", "", "documentName", "fetchDataParallelly", "locationNumber", "shippingMethodRequest", "Lcom/atd/atdmobileapp/models/ShippingMethodRequest;", "cartRequest", "Lcom/atd/atdmobileapp/models/CartRequest;", "updateQuantity", "cart", "Lcom/atd/atdmobileapp/models/Cart;", "quantity", "", "app_release"})
public final class QuantityAndDeliveryViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.DeliveriesRepository deliveriesRepository = null;
    private final com.atd.atdmobileapp.repository.CustomerRepository customerRepository = null;
    private final com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository = null;
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CustomerDetailsResponse>> customerDetailsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.ShippingMethodResponse>> shippingDetailsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> cartDetailsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> updateFireStoreFlow = null;
    
    @javax.inject.Inject
    public QuantityAndDeliveryViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.DeliveriesRepository deliveriesRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.CustomerRepository customerRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyOrderRepository myOrderRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CustomerDetailsResponse>> getCustomerDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.ShippingMethodResponse>> getShippingDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.CartResponse>> getCartDetailsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getDeleteStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> getUpdateFireStoreFlow() {
        return null;
    }
    
    public final void fetchDataParallelly(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.ShippingMethodRequest shippingMethodRequest, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CartRequest cartRequest) {
    }
    
    public final void updateQuantity(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Cart cart, int quantity) {
    }
    
    public final void deleteRecord(@org.jetbrains.annotations.NotNull
    java.lang.String documentName) {
    }
}
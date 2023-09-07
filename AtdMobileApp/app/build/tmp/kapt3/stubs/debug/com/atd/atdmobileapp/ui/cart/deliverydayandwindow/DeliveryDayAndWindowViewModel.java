package com.atd.atdmobileapp.ui.cart.deliverydayandwindow;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/deliverydayandwindow/DeliveryDayAndWindowViewModel;", "Landroidx/lifecycle/ViewModel;", "deliveriesRepository", "Lcom/atd/atdmobileapp/repository/DeliveriesRepository;", "(Lcom/atd/atdmobileapp/repository/DeliveriesRepository;)V", "deliveryDaysLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/DeliveryDaysResponse;", "getDeliveryDaysLiveData", "()Landroidx/lifecycle/LiveData;", "getDeliveryDays", "", "deliveryDayRequest", "Lcom/atd/atdmobileapp/models/DeliveryDayRequest;", "app_debug"})
public final class DeliveryDayAndWindowViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.DeliveriesRepository deliveriesRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.DeliveryDaysResponse>> deliveryDaysLiveData = null;
    
    @javax.inject.Inject
    public DeliveryDayAndWindowViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.DeliveriesRepository deliveriesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.DeliveryDaysResponse>> getDeliveryDaysLiveData() {
        return null;
    }
    
    public final void getDeliveryDays(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.DeliveryDayRequest deliveryDayRequest) {
    }
}
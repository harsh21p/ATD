package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\'H\u0002J\u0012\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00103\u001a\u00020&H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00064"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentMyOrdersBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentMyOrdersBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentMyOrdersBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter;", "getAdapter", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter;", "setAdapter", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter;)V", "binding", "getBinding", "myOrdersViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersViewModel;", "getMyOrdersViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersViewModel;", "myOrdersViewModel$delegate", "Lkotlin/Lazy;", "orderstatuse", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/myordersdata/Orderstatuse;", "Lkotlin/collections/ArrayList;", "getOrderstatuse", "()Ljava/util/ArrayList;", "setOrderstatuse", "(Ljava/util/ArrayList;)V", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "addOrders", "", "Lcom/atd/atdmobileapp/models/myordersdata/MyOrdersData;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupUI", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MyOrdersFragment extends androidx.fragment.app.Fragment {
    public java.util.ArrayList<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> orderstatuse;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentMyOrdersBinding _binding;
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter adapter;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private final kotlin.Lazy myOrdersViewModel$delegate = null;
    
    public MyOrdersFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> getOrderstatuse() {
        return null;
    }
    
    public final void setOrderstatuse(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentMyOrdersBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentMyOrdersBinding p0) {
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentMyOrdersBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersViewModel getMyOrdersViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addOrders(com.atd.atdmobileapp.models.myordersdata.MyOrdersData orderstatuse) {
    }
}
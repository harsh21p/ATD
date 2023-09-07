package com.atd.atdmobileapp.ui.product;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J \u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\u001a\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/ProductFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentProductBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentProductBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentProductBinding;)V", "binding", "getBinding", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "objects", "", "Lcom/atd/atdmobileapp/models/productsearch/Title;", "productAdapter", "Lcom/atd/atdmobileapp/ui/product/ProductAdapter;", "productViewModel", "Lcom/atd/atdmobileapp/ui/product/ProductViewModel;", "getProductViewModel", "()Lcom/atd/atdmobileapp/ui/product/ProductViewModel;", "productViewModel$delegate", "Lkotlin/Lazy;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "tiresFrag", "Lcom/atd/atdmobileapp/ui/product/tires/TiresFragment;", "BackPressed", "", "loadTireFrag", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTopTitleItemClicked", "title", "position", "", "positionOfTitleSelected", "onViewCreated", "view", "setUpTheme", "visitProdSearchEvent", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class ProductFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentProductBinding _binding;
    private com.atd.atdmobileapp.ui.product.ProductAdapter productAdapter;
    private java.util.List<com.atd.atdmobileapp.models.productsearch.Title> objects;
    private final kotlin.Lazy productViewModel$delegate = null;
    private com.atd.atdmobileapp.ui.product.tires.TiresFragment tiresFrag;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    
    public ProductFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentProductBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentProductBinding p0) {
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentProductBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.product.ProductViewModel getProductViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setUpTheme() {
    }
    
    private final void BackPressed() {
    }
    
    private final void loadTireFrag() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onTopTitleItemClicked(com.atd.atdmobileapp.models.productsearch.Title title, int position, int positionOfTitleSelected) {
    }
    
    private final void visitProdSearchEvent() {
    }
}
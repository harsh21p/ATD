package com.atd.atdmobileapp.ui.keywordsearch.filterandsort;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0016\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003H\u0002J\b\u0010\'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J \u00102\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u00103\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020!H\u0016J\u001a\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020!H\u0002J\b\u0010:\u001a\u00020!H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterFragment;", "Landroidx/fragment/app/DialogFragment;", "productList", "", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "(Ljava/util/List;)V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentFilterBinding;", "adapter", "Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentFilterBinding;", "filterOptions", "Lcom/atd/atdmobileapp/models/productsearch/FilterOptions;", "isClearAllActive", "", "listOfFilteredProducts", "", "mainViewModel", "Lcom/atd/atdmobileapp/MainViewModel;", "productByKeywordResponse", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductByKeywordResponse;", "totalCount", "", "type", "", "updatedVersionOfFilterOptions", "availabilityMatchesProduct", "availability", "Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;", "selectedAvailability", "closeAllOtherView", "", "expandAndCollapseRecyclerView", "filterProducts", "getSelectedCount", "item", "Lcom/atd/atdmobileapp/models/productsearch/FilterItem;", "makeNoOfSelectionsInvisible", "onClickApply", "onClickClearAll", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "position", "onStart", "onViewCreated", "view", "setAllSelectedToFalse", "setResult", "setupFilterView", "setupRecyclerViews", "Companion", "app_debug"})
public final class FilterFragment extends androidx.fragment.app.DialogFragment {
    private final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> productList = null;
    private com.atd.atdmobileapp.databinding.FragmentFilterBinding _binding;
    private com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterAdapter adapter;
    private com.atd.atdmobileapp.models.productsearch.FilterOptions updatedVersionOfFilterOptions;
    private java.lang.String type = "";
    private com.atd.atdmobileapp.MainViewModel mainViewModel;
    private com.atd.atdmobileapp.models.productsearch.FilterOptions filterOptions;
    private java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> listOfFilteredProducts;
    private com.atd.atdmobileapp.models.keywordsearch.ProductByKeywordResponse productByKeywordResponse;
    private boolean isClearAllActive = false;
    private int totalCount = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "filterFrag";
    
    public FilterFragment(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> productList) {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentFilterBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onClickClearAll() {
    }
    
    private final void setAllSelectedToFalse(com.atd.atdmobileapp.models.productsearch.FilterOptions filterOptions) {
    }
    
    private final void onClickApply() {
    }
    
    private final void setResult() {
    }
    
    private final void filterProducts() {
    }
    
    private final boolean availabilityMatchesProduct(com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability, java.lang.String selectedAvailability) {
        return false;
    }
    
    private final void setupFilterView() {
    }
    
    private final void makeNoOfSelectionsInvisible() {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void expandAndCollapseRecyclerView() {
    }
    
    private final void closeAllOtherView() {
    }
    
    private final int getSelectedCount(java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> item) {
        return 0;
    }
    
    private final void onItemClick(java.lang.String type, com.atd.atdmobileapp.models.productsearch.FilterItem item, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
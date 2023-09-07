package com.atd.atdmobileapp.ui.product.tires.brands;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002$%B3\u0012$\u0010\u0004\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010\u001b\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u001c\u0010\u001d\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0014\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\"\u0010#\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u0004\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/tires/brands/PreferredBrandsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/atd/atdmobileapp/ui/product/tires/brands/PreferredBrandsAdapter$NestedViewHolder;", "onSelectPreferredBrandClicked", "Lkotlin/Function2;", "", "", "", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Lkotlin/jvm/functions/Function2;Landroidx/fragment/app/FragmentActivity;)V", "filteredItems", "", "originalItems", "rowIndex", "Ljava/util/HashSet;", "selectedItems", "", "selectedPositions", "clearSelectedViews", "filterItems", "query", "getItem", "position", "getItemCount", "getSelectedPositions", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "items", "setSelectedViews", "ComparatorDiffUtil", "NestedViewHolder", "app_debug"})
public final class PreferredBrandsAdapter extends androidx.recyclerview.widget.ListAdapter<java.lang.String, com.atd.atdmobileapp.ui.product.tires.brands.PreferredBrandsAdapter.NestedViewHolder> {
    private final kotlin.jvm.functions.Function2<java.util.Set<java.lang.String>, java.util.Set<java.lang.Integer>, kotlin.Unit> onSelectPreferredBrandClicked = null;
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private final java.util.HashSet<java.lang.Integer> rowIndex = null;
    private final java.util.Set<java.lang.String> selectedItems = null;
    private final java.util.Set<java.lang.Integer> selectedPositions = null;
    private java.util.List<java.lang.String> originalItems;
    private java.util.List<java.lang.String> filteredItems;
    
    public PreferredBrandsAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.util.Set<java.lang.String>, ? super java.util.Set<java.lang.Integer>, kotlin.Unit> onSelectPreferredBrandClicked, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.product.tires.brands.PreferredBrandsAdapter.NestedViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.tires.brands.PreferredBrandsAdapter.NestedViewHolder holder, int position) {
    }
    
    public final void clearSelectedViews() {
    }
    
    public final void setSelectedViews(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.Integer> selectedPositions, @org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> selectedItems) {
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> items) {
    }
    
    public final void filterItems(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    private final java.util.Set<java.lang.Integer> getSelectedPositions() {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected java.lang.String getItem(int position) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/tires/brands/PreferredBrandsAdapter$NestedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/NestedItemBinding;", "(Lcom/atd/atdmobileapp/ui/product/tires/brands/PreferredBrandsAdapter;Lcom/atd/atdmobileapp/databinding/NestedItemBinding;)V", "bind", "", "brand", "", "position", "", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "app_debug"})
    public final class NestedViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.NestedItemBinding binding = null;
        
        public NestedViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.NestedItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String brand, int position, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity requireActivity) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/tires/brands/PreferredBrandsAdapter$ComparatorDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ComparatorDiffUtil extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> {
        
        public ComparatorDiffUtil() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        java.lang.String oldItem, @org.jetbrains.annotations.NotNull
        java.lang.String newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        java.lang.String oldItem, @org.jetbrains.annotations.NotNull
        java.lang.String newItem) {
            return false;
        }
    }
}
package com.atd.atdmobileapp.ui.keywordsearch.filterandsort;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001d\u001eBE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u0013\u001a\u00020\tJ\u001c\u0010\u0014\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/productsearch/FilterItem;", "Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter$ViewHolder;", "type", "", "onClick", "Lkotlin/Function3;", "", "", "context", "Landroidx/fragment/app/FragmentActivity;", "filterItems", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/fragment/app/FragmentActivity;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "clearItems", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "newItems", "FilterOptionsCallback", "ViewHolder", "app_release"})
public final class FilterAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.productsearch.FilterItem, com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.lang.String type;
    private final kotlin.jvm.functions.Function3<java.lang.String, com.atd.atdmobileapp.models.productsearch.FilterItem, java.lang.Integer, kotlin.Unit> onClick = null;
    private final androidx.fragment.app.FragmentActivity context = null;
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> filterItems;
    
    public FilterAdapter(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super com.atd.atdmobileapp.models.productsearch.FilterItem, ? super java.lang.Integer, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity context, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> filterItems) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.keywordsearch.filterandsort.FilterAdapter.ViewHolder holder, int position) {
    }
    
    public final void clearItems() {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> newItems) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/NestedItemBinding;", "(Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter;Lcom/atd/atdmobileapp/databinding/NestedItemBinding;)V", "bind", "", "item", "Lcom/atd/atdmobileapp/models/productsearch/FilterItem;", "position", "", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.NestedItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.NestedItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.FilterItem item, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/FilterAdapter$FilterOptionsCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/productsearch/FilterItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class FilterOptionsCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.productsearch.FilterItem> {
        
        public FilterOptionsCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.FilterItem oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.FilterItem newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.FilterItem oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.FilterItem newItem) {
            return false;
        }
    }
}
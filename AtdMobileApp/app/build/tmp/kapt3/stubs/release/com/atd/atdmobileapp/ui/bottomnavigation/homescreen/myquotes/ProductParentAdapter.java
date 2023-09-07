package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u001c\u0010\u0013\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ProductParentAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ProductParentAdapter$ViewHolder;", "()V", "isWorkingQuote", "", "()Z", "setWorkingQuote", "(Z)V", "itemsList", "", "Lcom/atd/atdmobileapp/models/myquotes/Item;", "addItem", "", "item", "formatCurrency", "", "amountString", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FilterOptionsCallback", "ViewHolder", "app_release"})
public final class ProductParentAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.keywordsearch.Product, com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ProductParentAdapter.ViewHolder> {
    private java.util.List<com.atd.atdmobileapp.models.myquotes.Item> itemsList;
    private boolean isWorkingQuote = false;
    
    public ProductParentAdapter() {
        super(null);
    }
    
    public final boolean isWorkingQuote() {
        return false;
    }
    
    public final void setWorkingQuote(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ProductParentAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ProductParentAdapter.ViewHolder holder, int position) {
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.Item> item) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatCurrency(@org.jetbrains.annotations.NotNull
    java.lang.String amountString) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ProductParentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/QuoteDetailsProductItemBinding;", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ProductParentAdapter;Lcom/atd/atdmobileapp/databinding/QuoteDetailsProductItemBinding;)V", "bind", "", "item", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "showWorkingQuoteIcons", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.QuoteDetailsProductItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.QuoteDetailsProductItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product item) {
        }
        
        private final void showWorkingQuoteIcons() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ProductParentAdapter$FilterOptionsCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class FilterOptionsCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.keywordsearch.Product> {
        
        public FilterOptionsCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product newItem) {
            return false;
        }
    }
}
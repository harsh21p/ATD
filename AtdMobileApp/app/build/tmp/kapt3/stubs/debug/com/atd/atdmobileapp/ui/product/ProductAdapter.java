package com.atd.atdmobileapp.ui.product;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B%\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/ProductAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/productsearch/Title;", "Lcom/atd/atdmobileapp/ui/product/ProductAdapter$ProductViewHolder;", "titleClickListener", "Lkotlin/reflect/KFunction3;", "", "", "(Lkotlin/reflect/KFunction;)V", "positionOfTitleSeleted", "getPositionOfTitleSeleted", "()I", "setPositionOfTitleSeleted", "(I)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffUtil", "ProductViewHolder", "app_debug"})
public final class ProductAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.productsearch.Title, com.atd.atdmobileapp.ui.product.ProductAdapter.ProductViewHolder> {
    private final kotlin.reflect.KFunction<kotlin.Unit> titleClickListener = null;
    private int positionOfTitleSeleted = -1;
    
    public ProductAdapter(@org.jetbrains.annotations.NotNull
    kotlin.reflect.KFunction<kotlin.Unit> titleClickListener) {
        super(null);
    }
    
    public final int getPositionOfTitleSeleted() {
        return 0;
    }
    
    public final void setPositionOfTitleSeleted(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.product.ProductAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.ProductAdapter.ProductViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/ProductAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/ProductTopListItemBinding;", "(Lcom/atd/atdmobileapp/ui/product/ProductAdapter;Lcom/atd/atdmobileapp/databinding/ProductTopListItemBinding;)V", "bind", "", "title", "Lcom/atd/atdmobileapp/models/productsearch/Title;", "position", "", "app_debug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.ProductTopListItemBinding binding = null;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.ProductTopListItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.Title title, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/ProductAdapter$DiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/productsearch/Title;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffUtil extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.productsearch.Title> {
        
        public DiffUtil() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.Title oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.Title newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.Title oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.productsearch.Title newItem) {
            return false;
        }
    }
}
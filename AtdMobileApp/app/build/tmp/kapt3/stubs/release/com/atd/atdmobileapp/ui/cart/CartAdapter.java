package com.atd.atdmobileapp.ui.cart;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/CartItem;", "Lcom/atd/atdmobileapp/ui/cart/CartAdapter$CartHolder;", "onDeleteCart", "Lkotlin/Function1;", "", "", "onQuantityAndEditClick", "prefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "CostVisibilityCheck", "", "getCostVisibilityCheck", "()Z", "setCostVisibilityCheck", "(Z)V", "checkProductCost", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CartHolder", "ComparatorDiffUtil", "app_release"})
public final class CartAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.CartItem, com.atd.atdmobileapp.ui.cart.CartAdapter.CartHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onDeleteCart = null;
    private final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.CartItem, kotlin.Unit> onQuantityAndEditClick = null;
    private final com.atd.atdmobileapp.utils.SharedPrefManager prefManager = null;
    private boolean CostVisibilityCheck = false;
    
    public CartAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteCart, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.CartItem, kotlin.Unit> onQuantityAndEditClick, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager prefManager) {
        super(null);
    }
    
    public final boolean getCostVisibilityCheck() {
        return false;
    }
    
    public final void setCostVisibilityCheck(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.cart.CartAdapter.CartHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.cart.CartAdapter.CartHolder holder, int position) {
    }
    
    public final void checkProductCost(boolean CostVisibilityCheck) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartAdapter$CartHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CartItemBinding;", "(Lcom/atd/atdmobileapp/ui/cart/CartAdapter;Lcom/atd/atdmobileapp/databinding/CartItemBinding;)V", "bind", "", "cart", "Lcom/atd/atdmobileapp/models/CartItem;", "position", "", "app_release"})
    public final class CartHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CartItemBinding binding = null;
        
        public CartHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CartItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.CartItem cart, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartAdapter$ComparatorDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/CartItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class ComparatorDiffUtil extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.CartItem> {
        
        public ComparatorDiffUtil() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.CartItem oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.CartItem newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.CartItem oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.CartItem newItem) {
            return false;
        }
    }
}
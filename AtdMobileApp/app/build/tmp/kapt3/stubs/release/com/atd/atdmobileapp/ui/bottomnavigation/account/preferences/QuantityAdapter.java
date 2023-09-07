package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\'\u0012\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/QuantityAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/preferences/Item;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/QuantityAdapter$ViewHolder;", "sendQty", "Lkotlin/Function1;", "", "", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Lkotlin/jvm/functions/Function1;Landroidx/fragment/app/FragmentActivity;)V", "localItemList", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "itemList", "ViewHolder", "YearDiffCallback", "app_release"})
public final class QuantityAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.preferences.Item, com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.QuantityAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<java.util.List<com.atd.atdmobileapp.models.preferences.Item>, kotlin.Unit> sendQty = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private java.util.List<com.atd.atdmobileapp.models.preferences.Item> localItemList;
    
    public QuantityAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.atd.atdmobileapp.models.preferences.Item>, kotlin.Unit> sendQty, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.preferences.Item> itemList) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.QuantityAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.QuantityAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/QuantityAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/PreferencesCustomQuantityLayoutBinding;", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/QuantityAdapter;Lcom/atd/atdmobileapp/databinding/PreferencesCustomQuantityLayoutBinding;)V", "bind", "", "item", "Lcom/atd/atdmobileapp/models/preferences/Item;", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.PreferencesCustomQuantityLayoutBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.PreferencesCustomQuantityLayoutBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.preferences.Item item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/QuantityAdapter$YearDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/preferences/Item;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class YearDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.preferences.Item> {
        
        public YearDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.preferences.Item oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.preferences.Item newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.preferences.Item oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.preferences.Item newItem) {
            return false;
        }
    }
}
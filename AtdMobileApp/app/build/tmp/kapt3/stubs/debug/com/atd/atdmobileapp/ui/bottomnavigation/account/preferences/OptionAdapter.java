package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/OptionAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/OptionAdapter$ViewHolder;", "send", "Lkotlin/Function1;", "", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Lkotlin/jvm/functions/Function1;Landroidx/fragment/app/FragmentActivity;)V", "previousSelection", "getPreviousSelection", "()Ljava/lang/String;", "setPreviousSelection", "(Ljava/lang/String;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "YearDiffCallback", "app_debug"})
public final class OptionAdapter extends androidx.recyclerview.widget.ListAdapter<java.lang.String, com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.OptionAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> send = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String previousSelection = "";
    
    public OptionAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> send, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPreviousSelection() {
        return null;
    }
    
    public final void setPreviousSelection(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.OptionAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.OptionAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/OptionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/OptionAdapter;Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;)V", "bind", "", "item", "", "position", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String item, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/preferences/OptionAdapter$YearDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class YearDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> {
        
        public YearDiffCallback() {
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
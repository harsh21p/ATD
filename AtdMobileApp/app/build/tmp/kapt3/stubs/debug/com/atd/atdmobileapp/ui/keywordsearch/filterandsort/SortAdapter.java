package com.atd.atdmobileapp.ui.keywordsearch.filterandsort;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/SortAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/SortAdapter$ViewHolderSort;", "previousSelectedOption", "", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getPreviousSelectedOption", "()Ljava/lang/Object;", "setPreviousSelectedOption", "(Ljava/lang/Object;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SortOptionsCallback", "ViewHolderSort", "app_debug"})
public final class SortAdapter extends androidx.recyclerview.widget.ListAdapter<java.lang.String, com.atd.atdmobileapp.ui.keywordsearch.filterandsort.SortAdapter.ViewHolderSort> {
    @org.jetbrains.annotations.Nullable
    private java.lang.Object previousSelectedOption;
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onClick = null;
    
    public SortAdapter(@org.jetbrains.annotations.Nullable
    java.lang.Object previousSelectedOption, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onClick) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPreviousSelectedOption() {
        return null;
    }
    
    public final void setPreviousSelectedOption(@org.jetbrains.annotations.Nullable
    java.lang.Object p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.keywordsearch.filterandsort.SortAdapter.ViewHolderSort onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.keywordsearch.filterandsort.SortAdapter.ViewHolderSort holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/SortAdapter$ViewHolderSort;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;", "(Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/SortAdapter;Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;)V", "bind", "", "option", "", "position", "", "app_debug"})
    public final class ViewHolderSort extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding = null;
        
        public ViewHolderSort(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String option, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/filterandsort/SortAdapter$SortOptionsCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class SortOptionsCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> {
        
        public SortOptionsCallback() {
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
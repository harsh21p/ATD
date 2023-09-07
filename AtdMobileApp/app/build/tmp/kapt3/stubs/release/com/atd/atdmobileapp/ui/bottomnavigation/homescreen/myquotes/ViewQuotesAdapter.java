package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ViewQuotesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/myquotes/Retailquote;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ViewQuotesAdapter$ViewHolder;", "onClick", "Lkotlin/Function1;", "", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Lkotlin/jvm/functions/Function1;Landroidx/fragment/app/FragmentActivity;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FilterOptionsCallback", "ViewHolder", "app_release"})
public final class ViewQuotesAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.myquotes.Retailquote, com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewQuotesAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.myquotes.Retailquote, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    
    public ViewQuotesAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.myquotes.Retailquote, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewQuotesAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewQuotesAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ViewQuotesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/MyquotesItemBinding;", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ViewQuotesAdapter;Lcom/atd/atdmobileapp/databinding/MyquotesItemBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/MyquotesItemBinding;", "bind", "", "retailquote", "Lcom/atd/atdmobileapp/models/myquotes/Retailquote;", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.MyquotesItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.MyquotesItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.MyquotesItemBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.Retailquote retailquote) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/ViewQuotesAdapter$FilterOptionsCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/myquotes/Retailquote;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class FilterOptionsCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.myquotes.Retailquote> {
        
        public FilterOptionsCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.Retailquote oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.Retailquote newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.Retailquote oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.Retailquote newItem) {
            return false;
        }
    }
}
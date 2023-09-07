package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/CommentsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/myquotes/QuoteComment;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/CommentsAdapter$ViewHolder;", "()V", "formatDateString", "", "inputDate", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FilterOptionsCallback", "ViewHolder", "app_release"})
public final class CommentsAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.myquotes.QuoteComment, com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.CommentsAdapter.ViewHolder> {
    
    public CommentsAdapter() {
        super(null);
    }
    
    private final java.lang.String formatDateString(java.lang.String inputDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.CommentsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.CommentsAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/CommentsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CommentsCustomLayoutBinding;", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/CommentsAdapter;Lcom/atd/atdmobileapp/databinding/CommentsCustomLayoutBinding;)V", "bind", "", "item", "Lcom/atd/atdmobileapp/models/myquotes/QuoteComment;", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CommentsCustomLayoutBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CommentsCustomLayoutBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.QuoteComment item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myquotes/CommentsAdapter$FilterOptionsCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/myquotes/QuoteComment;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class FilterOptionsCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.myquotes.QuoteComment> {
        
        public FilterOptionsCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.QuoteComment oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.QuoteComment newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.QuoteComment oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myquotes.QuoteComment newItem) {
            return false;
        }
    }
}
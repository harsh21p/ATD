package com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B-\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/KeywordRecentSearchesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/KeywordRecentSearchesAdapter$DataViewHolder;", "recentSearches", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchEntity;", "Lkotlin/collections/ArrayList;", "clickItem", "Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/OnClickItem;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Ljava/util/ArrayList;Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/OnClickItem;Landroidx/fragment/app/FragmentActivity;)V", "binding", "Lcom/atd/atdmobileapp/databinding/RecentItemBinding;", "getClickItem", "()Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/OnClickItem;", "mClickListener", "getMClickListener", "setMClickListener", "(Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/OnClickItem;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "showAll", "", "addRecentSearches", "", "Searches", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DataViewHolder", "app_debug"})
public final class KeywordRecentSearchesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeywordRecentSearchesAdapter.DataViewHolder> {
    private final java.util.ArrayList<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity> recentSearches = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem clickItem = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private com.atd.atdmobileapp.databinding.RecentItemBinding binding;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem mClickListener;
    private boolean showAll = false;
    
    public KeywordRecentSearchesAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity> recentSearches, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem clickItem, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem getClickItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem getMClickListener() {
        return null;
    }
    
    public final void setMClickListener(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeywordRecentSearchesAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeywordRecentSearchesAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addRecentSearches(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity> Searches) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/KeywordRecentSearchesAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/RecentItemBinding;", "(Lcom/atd/atdmobileapp/databinding/RecentItemBinding;)V", "app_debug"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.RecentItemBinding binding) {
            super(null);
        }
    }
}
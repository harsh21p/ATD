package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0014\u0010!\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter$ViewHolder;", "actvity", "Landroidx/fragment/app/FragmentActivity;", "myList", "", "Lcom/atd/atdmobileapp/models/mylist/Productlists;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "MyListDetails", "Lkotlin/reflect/KFunction1;", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/atd/atdmobileapp/utils/SharedPrefManager;Lkotlin/reflect/KFunction;)V", "getMyListDetails", "()Lkotlin/reflect/KFunction;", "getActvity", "()Landroidx/fragment/app/FragmentActivity;", "getMyList", "()Ljava/util/List;", "setMyList", "(Ljava/util/List;)V", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ViewHolder", "app_debug"})
public final class MyListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.mylists.MyListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity actvity = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> myList;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.reflect.KFunction<kotlin.Unit> MyListDetails = null;
    
    public MyListAdapter(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity actvity, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> myList, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager, @org.jetbrains.annotations.NotNull
    kotlin.reflect.KFunction<kotlin.Unit> MyListDetails) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getActvity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> getMyList() {
        return null;
    }
    
    public final void setMyList(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KFunction<kotlin.Unit> getMyListDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.mylists.MyListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.mylists.MyListAdapter.ViewHolder holder, int position) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> myList) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/MylistChildItemsBinding;", "(Lcom/atd/atdmobileapp/databinding/MylistChildItemsBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/MylistChildItemsBinding;", "bind", "", "productlists", "Lcom/atd/atdmobileapp/models/mylist/Productlists;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.MylistChildItemsBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.MylistChildItemsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.MylistChildItemsBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.mylist.Productlists productlists) {
        }
    }
}
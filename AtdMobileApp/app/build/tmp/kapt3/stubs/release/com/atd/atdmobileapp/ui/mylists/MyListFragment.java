package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0013J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u00103\u001a\u00020%J\b\u00104\u001a\u00020%H\u0002J\u0018\u00105\u001a\u00020%2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u00a8\u00066"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentMyListBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentMyListBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentMyListBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter;", "getAdapter", "()Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter;", "setAdapter", "(Lcom/atd/atdmobileapp/ui/mylists/MyListAdapter;)V", "binding", "getBinding", "myListResponse", "", "Lcom/atd/atdmobileapp/models/mylist/Productlists;", "originalFilteredKey", "", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "themeColor", "", "viewModel", "Lcom/atd/atdmobileapp/ui/mylists/MyListViewModel;", "getViewModel", "()Lcom/atd/atdmobileapp/ui/mylists/MyListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "MyListDetails", "", "productlists", "addList", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpTheme", "setUpUI", "updateData", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MyListFragment extends androidx.fragment.app.Fragment {
    private int themeColor = com.atd.atdmobileapp.R.color.black;
    private java.lang.String originalFilteredKey = "";
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentMyListBinding _binding;
    public com.atd.atdmobileapp.ui.mylists.MyListAdapter adapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> myListResponse;
    
    public MyListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentMyListBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentMyListBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.FragmentMyListBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.mylists.MyListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.mylists.MyListAdapter p0) {
    }
    
    private final com.atd.atdmobileapp.ui.mylists.MyListViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void addList() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateData(java.util.List<com.atd.atdmobileapp.models.mylist.Productlists> myListResponse) {
    }
    
    private final void setUpUI() {
    }
    
    public final void MyListDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.mylist.Productlists productlists) {
    }
    
    public final void setUpTheme() {
    }
    
    private final void onBackPressed() {
    }
}
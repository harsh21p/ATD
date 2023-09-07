package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter$DataViewHolder;", "Orders", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/myapprovals/Orderapproval;", "Lkotlin/collections/ArrayList;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "showAll", "", "addApprovals", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "viewAll", "DataViewHolder", "app_release"})
public final class MyApprovalsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter.DataViewHolder> {
    private final java.util.ArrayList<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private boolean showAll = false;
    
    public MyApprovalsAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addApprovals(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders) {
    }
    
    public final void viewAll(boolean showAll) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/ApprovalsItemBinding;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Lcom/atd/atdmobileapp/databinding/ApprovalsItemBinding;Landroidx/fragment/app/FragmentActivity;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/ApprovalsItemBinding;", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "bind", "", "orderApproval", "Lcom/atd/atdmobileapp/models/myapprovals/Orderapproval;", "app_release"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.ApprovalsItemBinding binding = null;
        @org.jetbrains.annotations.NotNull
        private final androidx.fragment.app.FragmentActivity requireActivity = null;
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.ApprovalsItemBinding binding, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity requireActivity) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.ApprovalsItemBinding getBinding() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.fragment.app.FragmentActivity getRequireActivity() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myapprovals.Orderapproval orderApproval) {
        }
    }
}
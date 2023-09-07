package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J\u000e\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u000e\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/SubmitApprovalsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/SubmitApprovalsAdapter$DataViewHolder;", "requiresActivity", "Landroidx/fragment/app/FragmentActivity;", "Orders", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/myapprovals/Orderapproval;", "Lkotlin/collections/ArrayList;", "approve", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/ApproveData;", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/ArrayList;Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/ApproveData;)V", "getApprove", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/ApproveData;", "checkBoxVisible", "", "getRequiresActivity", "()Landroidx/fragment/app/FragmentActivity;", "sellectAll", "addApprovals", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DataViewHolder", "app_release"})
public final class SubmitApprovalsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsAdapter.DataViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requiresActivity = null;
    private final java.util.ArrayList<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.ApproveData approve = null;
    private boolean sellectAll = false;
    private boolean checkBoxVisible = false;
    
    public SubmitApprovalsAdapter(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requiresActivity, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.ApproveData approve) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequiresActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.ApproveData getApprove() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addApprovals(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.Orderapproval> Orders) {
    }
    
    public final void sellectAll(boolean sellectAll) {
    }
    
    public final void checkBoxVisible(boolean checkBoxVisible) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/submitaprovals/SubmitApprovalsAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/SubmitApprovalsBinding;", "(Lcom/atd/atdmobileapp/databinding/SubmitApprovalsBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/SubmitApprovalsBinding;", "bind", "", "orderApproval", "Lcom/atd/atdmobileapp/models/myapprovals/Orderapproval;", "requiresActivity", "Landroidx/fragment/app/FragmentActivity;", "app_release"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.SubmitApprovalsBinding binding = null;
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.SubmitApprovalsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.SubmitApprovalsBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myapprovals.Orderapproval orderApproval, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity requiresActivity) {
        }
    }
}
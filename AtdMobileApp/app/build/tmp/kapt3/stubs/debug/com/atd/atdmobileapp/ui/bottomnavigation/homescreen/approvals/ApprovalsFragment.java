package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u001eH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/ApprovalsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentApprovalsBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentApprovalsBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentApprovalsBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter;", "getAdapter", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter;", "setAdapter", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsAdapter;)V", "approvalViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsViewModel;", "getApprovalViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsViewModel;", "approvalViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "addApprovals", "", "orderstatuse", "Lcom/atd/atdmobileapp/models/myapprovals/MyApprovalsData;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupUI", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ApprovalsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentApprovalsBinding _binding;
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter adapter;
    private final kotlin.Lazy approvalViewModel$delegate = null;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    
    public ApprovalsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentApprovalsBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentApprovalsBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.FragmentApprovalsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsAdapter p0) {
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsViewModel getApprovalViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addApprovals(com.atd.atdmobileapp.models.myapprovals.MyApprovalsData orderstatuse) {
    }
}
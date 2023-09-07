package com.atd.atdmobileapp.ui.bottomnavigation.mygarage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u001a\u00102\u001a\u00020$2\u0006\u0010/\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u00065"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/RecyclerViewClickListner;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentMyGarageBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentMyGarageBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentMyGarageBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter;", "getAdapter", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter;", "setAdapter", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter;)V", "approvalViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsViewModel;", "getApprovalViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/approvals/MyApprovalsViewModel;", "approvalViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "myGarageViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageViewModel;", "getMyGarageViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageViewModel;", "myGarageViewModel$delegate", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onItemClick", "view", "tabName", "", "onViewCreated", "setupLocationDetails", "setupUI", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MyGarageFragment extends androidx.fragment.app.Fragment implements com.atd.atdmobileapp.ui.bottomnavigation.mygarage.RecyclerViewClickListner {
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentMyGarageBinding _binding;
    private final kotlin.Lazy myGarageViewModel$delegate = null;
    public com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter adapter;
    private final kotlin.Lazy approvalViewModel$delegate = null;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    
    public MyGarageFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentMyGarageBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentMyGarageBinding p0) {
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentMyGarageBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageViewModel getMyGarageViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter p0) {
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
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupLocationDetails() {
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override
    public void onItemClick(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    java.lang.String tabName) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}
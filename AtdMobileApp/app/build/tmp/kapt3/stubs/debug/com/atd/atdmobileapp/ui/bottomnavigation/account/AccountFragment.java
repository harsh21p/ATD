package com.atd.atdmobileapp.ui.bottomnavigation.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0014H\u0016J\u001a\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\"H\u0002J\u0006\u00102\u001a\u00020\"J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020\"H\u0002J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/RecyclerViewClickListener;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentAccountBinding;", "accountViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountViewModel;", "getAccountViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountViewModel;", "accountViewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountAdapter;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentAccountBinding;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "location_number_local", "", "permissionViewModel", "Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "getPermissionViewModel", "()Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "permissionViewModel$delegate", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "username_local", "getVersionName", "", "logoutEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClick", "view", "tabName", "onViewCreated", "setUpTheme", "setupUI", "showDialog", "tapChangesLocationEvent", "tapFeedbackLinkEvent", "taplogOutEvent", "visitAccountEvent", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class AccountFragment extends androidx.fragment.app.Fragment implements com.atd.atdmobileapp.ui.bottomnavigation.account.RecyclerViewClickListener {
    private com.atd.atdmobileapp.databinding.FragmentAccountBinding _binding;
    private final kotlin.Lazy permissionViewModel$delegate = null;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private com.atd.atdmobileapp.ui.bottomnavigation.account.AccountAdapter adapter;
    private java.lang.String username_local;
    private java.lang.String location_number_local = "";
    private final kotlin.Lazy accountViewModel$delegate = null;
    
    public AccountFragment() {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentAccountBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.login.LoginViewModel getPermissionViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel getAccountViewModel() {
        return null;
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
    
    private final void setUpTheme() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setupUI() {
    }
    
    private final void visitAccountEvent() {
    }
    
    @java.lang.Override
    public void onItemClick(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    java.lang.String tabName) {
    }
    
    private final void tapFeedbackLinkEvent() {
    }
    
    private final void tapChangesLocationEvent() {
    }
    
    private final void logoutEvent() {
    }
    
    private final void taplogOutEvent() {
    }
    
    private final void showDialog() {
    }
    
    private final void getVersionName() {
    }
}
package com.atd.atdmobileapp.ui.onboarding.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\'"}, d2 = {"Lcom/atd/atdmobileapp/ui/onboarding/pages/WelcomeToATDFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentWelcomeBinding;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentWelcomeBinding;", "hasNotificationPermissionGranted", "", "getHasNotificationPermissionGranted", "()Z", "setHasNotificationPermissionGranted", "(Z)V", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "showNotificationPermissionRationale", "showSettingDialog", "skipOnBoarding", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class WelcomeToATDFragment extends androidx.fragment.app.Fragment {
    private com.atd.atdmobileapp.databinding.FragmentWelcomeBinding _binding;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private boolean hasNotificationPermissionGranted = false;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    
    public WelcomeToATDFragment() {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentWelcomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    public final boolean getHasNotificationPermissionGranted() {
        return false;
    }
    
    public final void setHasNotificationPermissionGranted(boolean p0) {
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
    
    private final void skipOnBoarding() {
    }
    
    private final void showSettingDialog() {
    }
    
    private final void showNotificationPermissionRationale() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}
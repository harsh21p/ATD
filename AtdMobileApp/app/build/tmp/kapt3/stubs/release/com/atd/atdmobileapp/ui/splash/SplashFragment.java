package com.atd.atdmobileapp.ui.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u00062"}, d2 = {"Lcom/atd/atdmobileapp/ui/splash/SplashFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentSplashBinding;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentSplashBinding;", "biometricPrompt", "Landroidx/biometric/BiometricPrompt;", "callBack", "Landroidx/biometric/BiometricPrompt$AuthenticationCallback;", "executor", "Ljava/util/concurrent/Executor;", "keyguardManager", "Landroid/app/KeyguardManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "authenticateWithBiometrics", "", "biometricsEnrollIntent", "Landroid/content/Intent;", "checkAPILevelAndProceed", "checkDeviceCanAuthenticateWithBiometrics", "getErrorMessage", "", "errorCode", "", "init", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onPause", "screenDelay", "setUpDeviceLockInAPIBelow23Intent", "showDialog", "Companion", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class SplashFragment extends androidx.fragment.app.Fragment {
    private com.atd.atdmobileapp.databinding.FragmentSplashBinding _binding;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private androidx.biometric.BiometricPrompt biometricPrompt;
    private java.util.concurrent.Executor executor;
    private androidx.biometric.BiometricPrompt.AuthenticationCallback callBack;
    private android.app.KeyguardManager keyguardManager;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    @org.jetbrains.annotations.NotNull
    public static final com.atd.atdmobileapp.ui.splash.SplashFragment.Companion Companion = null;
    public static final int RC_BIOMETRICS_ENROLL = 10;
    public static final int RC_DEVICE_CREDENTIAL_ENROLL = 18;
    
    public SplashFragment() {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentSplashBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void screenDelay() {
    }
    
    private final void authenticateWithBiometrics() {
    }
    
    private final void init() {
    }
    
    private final void showDialog() {
    }
    
    private final void checkDeviceCanAuthenticateWithBiometrics() {
    }
    
    private final android.content.Intent biometricsEnrollIntent() {
        return null;
    }
    
    private final android.content.Intent setUpDeviceLockInAPIBelow23Intent() {
        return null;
    }
    
    private final void checkAPILevelAndProceed() {
    }
    
    private final java.lang.String getErrorMessage(int errorCode) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/atd/atdmobileapp/ui/splash/SplashFragment$Companion;", "", "()V", "RC_BIOMETRICS_ENROLL", "", "RC_DEVICE_CREDENTIAL_ENROLL", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
package com.atd.atdmobileapp.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!H\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010!H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0018\u0010\'\u001a\u00020\u001e2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010!H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\u001a\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010;\u001a\u00020\u001eH\u0002J\u0012\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u0015H\u0002J\b\u0010C\u001a\u00020\u001eH\u0002J\u0010\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u0015H\u0002J\u0018\u0010F\u001a\u00020\u001e2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010!H\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/atd/atdmobileapp/ui/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentLoginBinding;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentLoginBinding;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseCrashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "loginViewModel", "Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "getLoginViewModel", "()Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "password", "", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "userName", "bindObservers", "", "chooseProfile", "data", "", "createUser", "userList", "Lcom/atd/atdmobileapp/models/User;", "enableBiometric", "enableLogin", "firebaseAuth", "user", "getBase64Encoded", "username", "landsOnLoginScreenEvent", "logEvents", "buttonId", "buttonType", "login", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "rememberUserRequest", "resetPassword", "url", "saveApproveOrderWebsite", "permission", "Lcom/atd/atdmobileapp/models/Permission;", "saveUserRole", "role", "setTheme", "showErrors", "error", "signInUser", "tapLoginButtonEvent", "validateRememberMe", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class LoginFragment extends androidx.fragment.app.Fragment {
    private com.atd.atdmobileapp.databinding.FragmentLoginBinding _binding;
    private final kotlin.Lazy loginViewModel$delegate = null;
    private java.lang.String userName = "";
    private java.lang.String password = "";
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private com.google.firebase.crashlytics.FirebaseCrashlytics firebaseCrashlytics;
    private com.google.firebase.auth.FirebaseAuth auth;
    
    public LoginFragment() {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentLoginBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.login.LoginViewModel getLoginViewModel() {
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
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void landsOnLoginScreenEvent() {
    }
    
    private final void login() {
    }
    
    private final void logEvents(java.lang.String buttonId, java.lang.String buttonType) {
    }
    
    private final void setTheme() {
    }
    
    private final void enableBiometric() {
    }
    
    private final void enableLogin() {
    }
    
    private final void rememberUserRequest() {
    }
    
    private final void validateRememberMe() {
    }
    
    private final void bindObservers() {
    }
    
    private final void saveUserRole(java.lang.String role) {
    }
    
    private final void tapLoginButtonEvent() {
    }
    
    private final void saveApproveOrderWebsite(com.atd.atdmobileapp.models.Permission permission) {
    }
    
    private final void firebaseAuth(java.util.List<com.atd.atdmobileapp.models.User> user) {
    }
    
    private final void createUser(java.util.List<com.atd.atdmobileapp.models.User> userList) {
    }
    
    private final void signInUser(java.util.List<com.atd.atdmobileapp.models.User> userList) {
    }
    
    private final void chooseProfile(java.util.List<java.lang.String> data) {
    }
    
    private final void showErrors(java.lang.String error) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    private final java.lang.String getBase64Encoded(java.lang.String username, java.lang.String password) {
        return null;
    }
    
    private final void resetPassword(java.lang.String url) {
    }
}
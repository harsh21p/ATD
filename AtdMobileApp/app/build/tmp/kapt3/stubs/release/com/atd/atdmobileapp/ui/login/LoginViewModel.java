package com.atd.atdmobileapp.ui.login;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r0\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/atd/atdmobileapp/repository/UserRepository;", "permissionsRepository", "Lcom/atd/atdmobileapp/repository/PermissionsRepository;", "atdRoomDatabase", "Lcom/atd/atdmobileapp/roomdatabase/ATDRoomDatabase;", "(Lcom/atd/atdmobileapp/repository/UserRepository;Lcom/atd/atdmobileapp/repository/PermissionsRepository;Lcom/atd/atdmobileapp/roomdatabase/ATDRoomDatabase;)V", "getAtdRoomDatabase", "()Lcom/atd/atdmobileapp/roomdatabase/ATDRoomDatabase;", "checkPermission", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "getCheckPermission", "()Landroidx/lifecycle/LiveData;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "permissionList", "", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionEntity;", "getPermissionList", "userResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/models/UserResponse;", "getUserResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "deleteRoomDatabase", "", "profileSelected", "filter", "loginUser", "userName", "savePermissions", "permission", "app_release"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.UserRepository userRepository = null;
    private final com.atd.atdmobileapp.repository.PermissionsRepository permissionsRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase atdRoomDatabase = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.PermissionsRepository permissionsRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase atdRoomDatabase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase getAtdRoomDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.UserResponse>> getUserResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> getCheckPermission() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity>>> getPermissionList() {
        return null;
    }
    
    public final void loginUser(@org.jetbrains.annotations.NotNull
    java.lang.String userName) {
    }
    
    public final void getCheckPermission(@org.jetbrains.annotations.NotNull
    java.lang.String profileSelected, @org.jetbrains.annotations.NotNull
    java.lang.String filter) {
    }
    
    public final void getPermissionList() {
    }
    
    public final void savePermissions(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity permission) {
    }
    
    public final void deleteRoomDatabase() {
    }
}
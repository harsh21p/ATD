package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u001c\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tR \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/atd/atdmobileapp/repository/PermissionsRepository;", "", "permissionsDAO", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionsDAO;", "(Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionsDAO;)V", "_permissionsListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionEntity;", "_permissionsLiveData", "Landroidx/lifecycle/LiveData;", "", "get_permissionsLiveData", "()Landroidx/lifecycle/LiveData;", "permissionsListLiveData", "getPermissionsListLiveData", "permissionsLiveData", "getPermissionsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "deletePermissions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCheckPermission", "profileSelected", "filter", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissions", "handleResponse", "response", "permissionCheckResponse", "savePermissions", "Lkotlinx/coroutines/Job;", "permission", "app_debug"})
public final class PermissionsRepository {
    private final com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO permissionsDAO = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> permissionsLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity>>> _permissionsListLiveData = null;
    
    @javax.inject.Inject
    public PermissionsRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO permissionsDAO) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> getPermissionsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.lang.String>> get_permissionsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCheckPermission(@org.jetbrains.annotations.NotNull
    java.lang.String profileSelected, @org.jetbrains.annotations.NotNull
    java.lang.String filter, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void permissionCheckResponse(java.lang.String response) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job savePermissions(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity permission) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity>>> getPermissionsListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPermissions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleResponse(java.util.List<com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity> response) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deletePermissions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}
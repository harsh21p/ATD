package com.atd.atdmobileapp.roomdatabase.permissions;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0007\u001a\u00020\u0003H\'J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionsDAO;", "", "Insert", "", "entity", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionEntity;", "Update", "deleteAll", "getApprovePermission", "", "filter", "profileSelected", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissions", "", "app_release"})
public abstract interface PermissionsDAO {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void Insert(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity entity);
    
    @androidx.room.Update
    public abstract void Update(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity entity);
    
    @androidx.room.Query(value = "Delete from Permissions")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select * from Permissions")
    public abstract java.util.List<com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity> getPermissions();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT permissionValue FROM Permissions where permissionValue=:filter And website=:profileSelected")
    public abstract java.lang.Object getApprovePermission(@org.jetbrains.annotations.NotNull
    java.lang.String filter, @org.jetbrains.annotations.NotNull
    java.lang.String profileSelected, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> continuation);
}
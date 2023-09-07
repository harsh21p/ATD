package com.atd.atdmobileapp.roomdatabase.permissions;

import java.lang.System;

@androidx.room.Entity(tableName = "Permissions")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionEntity;", "", "()V", "ID", "", "getID", "()I", "setID", "(I)V", "permissionValue", "", "getPermissionValue", "()Ljava/lang/String;", "setPermissionValue", "(Ljava/lang/String;)V", "website", "getWebsite", "setWebsite", "app_release"})
public final class PermissionEntity {
    @androidx.room.ColumnInfo(name = "ID")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int ID = 0;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "permissionValue")
    private java.lang.String permissionValue;
    @org.jetbrains.annotations.Nullable
    @androidx.room.ColumnInfo(name = "website")
    private java.lang.String website;
    
    public PermissionEntity() {
        super();
    }
    
    public final int getID() {
        return 0;
    }
    
    public final void setID(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPermissionValue() {
        return null;
    }
    
    public final void setPermissionValue(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getWebsite() {
        return null;
    }
    
    public final void setWebsite(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}
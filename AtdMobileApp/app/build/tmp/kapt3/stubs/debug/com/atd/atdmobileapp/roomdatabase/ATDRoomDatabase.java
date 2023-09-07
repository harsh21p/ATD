package com.atd.atdmobileapp.roomdatabase;

import java.lang.System;

@androidx.room.Database(entities = {com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity.class, com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity.class, com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/roomdatabase/ATDRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "clearTables", "", "configLocationDAO", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "permissionsDAO", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionsDAO;", "previousKeywordSearchDAO", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;", "app_debug"})
public abstract class ATDRoomDatabase extends androidx.room.RoomDatabase {
    
    public ATDRoomDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO previousKeywordSearchDAO();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO configLocationDAO();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO permissionsDAO();
    
    public final void clearTables() {
    }
}
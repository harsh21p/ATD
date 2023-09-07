package com.atd.atdmobileapp.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/atd/atdmobileapp/di/DbModule;", "", "()V", "provide", "Lcom/atd/atdmobileapp/roomdatabase/ATDRoomDatabase;", "context", "Landroid/content/Context;", "provideConfigLocatioEntity", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationEntity;", "provideConfigLocationDao", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "db", "provideDao", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;", "provideEntity", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchEntity;", "providePermissionsDao", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionsDAO;", "providePermissionsEntity", "Lcom/atd/atdmobileapp/roomdatabase/permissions/PermissionEntity;", "app_release"})
@dagger.Module
public final class DbModule {
    @org.jetbrains.annotations.NotNull
    public static final com.atd.atdmobileapp.di.DbModule INSTANCE = null;
    
    private DbModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase provide(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO provideDao(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity provideEntity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO provideConfigLocationDao(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity provideConfigLocatioEntity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO providePermissionsDao(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity providePermissionsEntity() {
        return null;
    }
}
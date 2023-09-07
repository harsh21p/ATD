package com.atd.atdmobileapp.roomdatabase.configlocations;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationsDAO;", "", "Delete", "", "entity", "Lcom/atd/atdmobileapp/roomdatabase/configlocations/ConfigLocationEntity;", "Insert", "Update", "getConfigLocationList", "", "getPreferredBrandConfigurationList", "Lcom/atd/atdmobileapp/models/locationconfig/Locationconfiguration;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface ConfigLocationsDAO {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void Insert(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity entity);
    
    @androidx.room.Update
    public abstract void Update(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity entity);
    
    @androidx.room.Delete
    public abstract void Delete(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity entity);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select * from configlocation")
    public abstract java.util.List<com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity> getConfigLocationList();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM configlocation where configuration =\'PREFERRED_BRAND\'")
    public abstract java.lang.Object getPreferredBrandConfigurationList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.atd.atdmobileapp.models.locationconfig.Locationconfiguration>> continuation);
}
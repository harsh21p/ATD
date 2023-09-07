package com.atd.atdmobileapp.roomdatabase.keywordsearch;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchDAO;", "", "Delete", "", "previousKeywordSearchEntity", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchEntity;", "Insert", "Update", "getKeyWordList", "", "app_debug"})
public abstract interface PreviousKeywordSearchDAO {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void Insert(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity previousKeywordSearchEntity);
    
    @androidx.room.Update
    public abstract void Update(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity previousKeywordSearchEntity);
    
    @androidx.room.Delete
    public abstract void Delete(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity previousKeywordSearchEntity);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "Select * from KeywordSearch order By ID DESC LIMIT 10 OFFSET 0")
    public abstract java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity> getKeyWordList();
}
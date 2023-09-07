package com.atd.atdmobileapp.roomdatabase.keywordsearch

import androidx.room.*
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity

@Dao
interface PreviousKeywordSearchDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun Insert(previousKeywordSearchEntity: PreviousKeywordSearchEntity)

    @Update
    fun Update(previousKeywordSearchEntity: PreviousKeywordSearchEntity)

    @Delete
    fun Delete(previousKeywordSearchEntity: PreviousKeywordSearchEntity)

    @Query("Select * from KeywordSearch order By ID DESC LIMIT 10 OFFSET 0")
    fun getKeyWordList() :  List<PreviousKeywordSearchEntity>
}
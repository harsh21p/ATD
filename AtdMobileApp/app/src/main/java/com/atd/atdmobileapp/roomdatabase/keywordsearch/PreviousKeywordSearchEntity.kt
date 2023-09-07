package com.atd.atdmobileapp.roomdatabase.keywordsearch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.atd.atdmobileapp.utils.Constants

@Entity(tableName = Constants.PREVIOUS_KEYWORD_TABLE_NAME,indices = [Index(value = ["keyword"], unique = true)])
class PreviousKeywordSearchEntity() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var ID: Int= 0

    @ColumnInfo(name = "keyword")
    var keyword : String=""

}

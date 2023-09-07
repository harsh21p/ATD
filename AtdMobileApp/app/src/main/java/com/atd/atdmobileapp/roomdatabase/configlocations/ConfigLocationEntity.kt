package com.atd.atdmobileapp.roomdatabase.configlocations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.atd.atdmobileapp.utils.Constants

@Entity(tableName = Constants.Config_Location_TABLE_NAME,indices = [Index(value = ["configuration","value"], unique = true)])
class ConfigLocationEntity() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var ID: Int= 0

    @ColumnInfo(name = "configuration")
    var configuration: String=""

    @ColumnInfo(name = "value")
    var value: String=""
}
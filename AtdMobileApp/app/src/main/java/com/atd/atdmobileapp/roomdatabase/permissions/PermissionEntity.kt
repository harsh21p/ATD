package com.atd.atdmobileapp.roomdatabase.permissions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.atd.atdmobileapp.utils.Constants


@Entity(tableName = Constants.Permissions_TABLE_NAME)
class PermissionEntity() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var ID: Int= 0

    @ColumnInfo(name = "permissionValue")
    var permissionValue: String? =null

    @ColumnInfo(name = "website")
    var website: String?=null

}
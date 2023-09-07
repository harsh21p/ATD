package com.atd.atdmobileapp.roomdatabase.permissions

import androidx.room.*

@Dao
interface PermissionsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun Insert(entity: PermissionEntity)

    @Update
    fun Update(entity: PermissionEntity)

   /* @Delete
    fun Delete(entity: PermissionEntity)*/

    @Query("Delete from Permissions")
    fun deleteAll()
    @Query("Select * from Permissions")
    fun getPermissions() :  List<PermissionEntity>

    @Query("SELECT permissionValue FROM Permissions where permissionValue=:filter And website=:profileSelected")
   suspend fun getApprovePermission(filter: String, profileSelected: String) :String
}

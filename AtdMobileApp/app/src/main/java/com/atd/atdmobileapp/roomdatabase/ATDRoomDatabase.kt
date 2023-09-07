package com.atd.atdmobileapp.roomdatabase

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionsDAO
import com.atd.atdmobileapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Singleton


@Database(entities = [PreviousKeywordSearchEntity::class,ConfigLocationEntity::class, PermissionEntity::class], version = 2, exportSchema = false)
abstract class ATDRoomDatabase : RoomDatabase() {

    abstract fun previousKeywordSearchDAO() : PreviousKeywordSearchDAO
    abstract fun configLocationDAO() : ConfigLocationsDAO
    abstract fun permissionsDAO(): PermissionsDAO

    fun clearTables() {
        GlobalScope.launch(Dispatchers.IO) {
            this@ATDRoomDatabase.clearAllTables()
        }
    }
}
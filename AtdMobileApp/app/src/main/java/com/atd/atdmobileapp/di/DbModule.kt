package com.atd.atdmobileapp.di

import android.content.Context
import androidx.room.Room
import com.atd.atdmobileapp.roomdatabase.ATDRoomDatabase
import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchDAO
import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity
import com.atd.atdmobileapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, ATDRoomDatabase::class.java, Constants.ROOM_DATABASE)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: ATDRoomDatabase) = db.previousKeywordSearchDAO()

    @Provides
    fun provideEntity() = PreviousKeywordSearchEntity()

    @Provides
    @Singleton
    fun provideConfigLocationDao(db: ATDRoomDatabase) = db.configLocationDAO()

    @Provides
    fun provideConfigLocatioEntity() = ConfigLocationEntity()

    @Provides
    @Singleton
    fun providePermissionsDao(db: ATDRoomDatabase) = db.permissionsDAO()

    @Provides
    fun providePermissionsEntity() = PermissionEntity()
}
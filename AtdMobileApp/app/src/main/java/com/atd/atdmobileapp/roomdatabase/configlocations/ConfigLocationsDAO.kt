package com.atd.atdmobileapp.roomdatabase.configlocations

import androidx.room.*
import com.atd.atdmobileapp.models.locationconfig.Locationconfiguration

@Dao
interface ConfigLocationsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun Insert(entity: ConfigLocationEntity)

    @Update
    fun Update(entity: ConfigLocationEntity)

    @Delete
    fun Delete(entity: ConfigLocationEntity)

    @Query("Select * from configlocation")
    fun getConfigLocationList() :  List<ConfigLocationEntity>
    @Query("SELECT * FROM configlocation where configuration ='PREFERRED_BRAND'")
   suspend fun getPreferredBrandConfigurationList() :List<Locationconfiguration>
}
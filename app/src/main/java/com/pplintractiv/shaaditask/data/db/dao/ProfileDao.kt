package com.pplintractiv.shaaditask.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pplintractiv.shaaditask.data.db.entities.Profile

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfiles(profiles: List<Profile>)

    @Query("select * from Profile")
    fun getProfiles(): LiveData<List<Profile>>
}
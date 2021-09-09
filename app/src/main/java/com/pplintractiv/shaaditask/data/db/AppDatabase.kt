package com.pplintractiv.shaaditask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pplintractiv.shaaditask.data.db.dao.ProfileDao
import com.pplintractiv.shaaditask.data.db.entities.Profile

@Database(
    entities = [Profile::class],
    version = DBConstants.DB_VERSION
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProfileDao(): ProfileDao
}
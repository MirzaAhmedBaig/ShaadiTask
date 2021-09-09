package com.pplintractiv.shaaditask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pplintractiv.shaaditask.data.db.dao.ProfileDao
import com.pplintractiv.shaaditask.data.db.entities.Dob
import com.pplintractiv.shaaditask.data.db.entities.Location
import com.pplintractiv.shaaditask.data.db.entities.Name
import com.pplintractiv.shaaditask.data.db.entities.Picture
import com.pplintractiv.shaaditask.data.db.entities.Profile

@Database(
    entities = [Profile::class, Dob::class, Location::class, Name::class, Picture::class],
    version = DBConstants.DB_VERSION
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProfileDao(): ProfileDao
}
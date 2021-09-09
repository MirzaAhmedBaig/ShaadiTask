package com.pplintractiv.shaaditask.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pplintractiv.shaaditask.data.db.entities.Dob
import com.pplintractiv.shaaditask.data.db.entities.Location
import com.pplintractiv.shaaditask.data.db.entities.Name
import com.pplintractiv.shaaditask.data.db.entities.Picture

object Converters {

    @TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToName(name: String?): Name? {
        return Gson().fromJson(name, Name::class.java)
    }

    @TypeConverter
    fun nameToString(name: Name?): String? {
        return Gson().toJson(name)
    }

    @TypeConverter
    fun stringToLocation(location: String?): Location? {
        return Gson().fromJson(location, Location::class.java)
    }

    @TypeConverter
    fun locationToString(location: Location?): String? {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun stringToDob(dob: String?): Dob? {
        return Gson().fromJson(dob, Dob::class.java)
    }

    @TypeConverter
    fun dobToString(dob: Dob?): String? {
        return Gson().toJson(dob)
    }

    @TypeConverter
    fun stringToPicture(picture: String?): Picture? {
        return Gson().fromJson(picture, Picture::class.java)
    }

    @TypeConverter
    fun pictureToString(picture: Picture?): String? {
        return Gson().toJson(picture)
    }
}
package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Picture(
    @PrimaryKey
    val _id: Int,
    val large: String,
    val medium: String,
    val thumbnail: String
)
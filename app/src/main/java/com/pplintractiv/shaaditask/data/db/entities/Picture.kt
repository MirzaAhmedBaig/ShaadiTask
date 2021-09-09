package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity

@Entity
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)
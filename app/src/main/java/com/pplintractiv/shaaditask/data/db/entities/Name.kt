package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Name(
    @PrimaryKey
    val _id: Int,
    val title: String,
    val first: String,
    val last: String
)
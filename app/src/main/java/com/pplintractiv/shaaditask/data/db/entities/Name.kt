package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity

@Entity
data class Name(
    val title: String,
    val first: String,
    val last: String
)
package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity

@Entity
data class Registered(
    val date: String,
    val age: Int
)
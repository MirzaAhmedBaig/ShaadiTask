package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dob(
    @PrimaryKey
    val _id: Int,
    val date: String,
    val age: Int
)
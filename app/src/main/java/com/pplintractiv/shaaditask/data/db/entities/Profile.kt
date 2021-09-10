package com.pplintractiv.shaaditask.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pplintractiv.shaaditask.ui.data.ProfileState

@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dob: Dob,
    val phone: String,
    val cell: String,
    val picture: Picture,
    val nat: String,
    @ProfileState var state: Int = ProfileState.NONE
)
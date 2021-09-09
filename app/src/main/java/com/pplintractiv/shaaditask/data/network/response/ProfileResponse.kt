package com.pplintractiv.shaaditask.data.network.response

import com.pplintractiv.shaaditask.data.db.entities.Profile

data class ProfileResponse(
    val results: Profile,
    val info: Info
)
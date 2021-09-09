package com.pplintractiv.shaaditask.data.network

import com.pplintractiv.shaaditask.data.network.response.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiManager {
    @GET(EndPoints.GET_PROFILES)
    suspend fun getProfiles(@Query("results") results: Int = 10): List<ProfileResponse>
}
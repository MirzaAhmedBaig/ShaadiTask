package com.pplintractiv.shaaditask.data.repository

import com.pplintractiv.shaaditask.data.db.AppDatabase
import com.pplintractiv.shaaditask.data.db.entities.Profile
import com.pplintractiv.shaaditask.data.network.ApiManager
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiManager: ApiManager,
    private val db: AppDatabase
) : BaseRepository() {

    suspend fun getRemoteProfiles() = safeApiCall { apiManager.getProfiles() }

    fun getLocalProfiles() = db.getProfileDao().getProfiles()
    suspend fun getLocalProfile(id: Int) = db.getProfileDao().getProfile(id)
    suspend fun updateProfile(profile: Profile) = db.getProfileDao().updateProfile(profile)

    suspend fun saveProfiles(profiles: List<Profile>) = db.getProfileDao().insertProfiles(profiles)

}
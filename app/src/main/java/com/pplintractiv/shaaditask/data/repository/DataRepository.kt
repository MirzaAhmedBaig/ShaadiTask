package com.pplintractiv.shaaditask.data.repository

import com.pplintractiv.shaaditask.data.db.AppDatabase
import com.pplintractiv.shaaditask.data.network.ApiManager
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiManager: ApiManager,
    private val db: AppDatabase
) : BaseRepository() {

}
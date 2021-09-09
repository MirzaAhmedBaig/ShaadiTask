package com.pplintractiv.shaaditask.ui.pages.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pplintractiv.shaaditask.data.db.entities.Profile
import com.pplintractiv.shaaditask.data.network.Resource
import com.pplintractiv.shaaditask.data.network.response.ProfileResponse
import com.pplintractiv.shaaditask.data.repository.DataRepository
import kotlinx.coroutines.launch

class CardsViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private var _profileResponse: MutableLiveData<Resource<ProfileResponse>> =
        MutableLiveData()
    val profileResponse: LiveData<Resource<ProfileResponse>>
        get() = _profileResponse

    fun getRemoteProfiles() = viewModelScope.launch {
        _profileResponse.value = dataRepository.getRemoteProfiles()
    }

    fun getLocalProfiles() = dataRepository.getLocalProfiles()

    fun saveProfiles(profiles: List<Profile>) = viewModelScope.launch {
        dataRepository.saveProfiles(profiles)
    }

}
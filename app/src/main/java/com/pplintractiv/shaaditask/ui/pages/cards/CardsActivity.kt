package com.pplintractiv.shaaditask.ui.pages.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pplintractiv.shaaditask.R
import com.pplintractiv.shaaditask.data.db.entities.Profile
import com.pplintractiv.shaaditask.databinding.ActivityCardsBinding
import com.pplintractiv.shaaditask.ui.base.BaseVMActivity
import com.pplintractiv.shaaditask.ui.data.ProfileState
import com.pplintractiv.shaaditask.utils.BottomMarginItemDecorator
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsActivity : BaseVMActivity<CardsViewModel, ActivityCardsBinding>() {

    private lateinit var listItems: List<CardItem>

    override fun getViewBinding(): ActivityCardsBinding {
        return ActivityCardsBinding.inflate(layoutInflater)
    }

    override fun getClassName(): String {
        return CardsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeProfiles()
    }

    private fun setProfiles(data: List<Profile>) {
        val mAdapter = GroupAdapter<GroupieViewHolder>().apply {
            listItems = data.map {
                CardItem(it, onAccept = { profileId ->
                    Log.d(TAG,"OnAccept : $profileId")
                    viewModel.setProfileState(ProfileState.ACCEPTED, profileId)
                    updateCardState(ProfileState.ACCEPTED, profileId)
                }, onDecline = { profileId ->
                    Log.d(TAG,"onDecline : $profileId")
                    viewModel.setProfileState(ProfileState.REJECTED, profileId)
                    updateCardState(ProfileState.REJECTED, profileId)
                })
            }
            addAll(listItems)
        }

        binding.rvProfiles.apply {
            layoutManager = LinearLayoutManager(this@CardsActivity)
            adapter = mAdapter
            addItemDecoration(BottomMarginItemDecorator())
        }
        binding.pbLoader.visibility = View.GONE
    }

    private fun updateCardState(@ProfileState state: Int, profileId: Int) {
        listItems.indexOfFirst { it.profile._id == profileId }.takeIf { it != -1 }?.let {
            listItems[it].profile.state = state
            binding.rvProfiles.adapter?.notifyItemChanged(it)
        }
    }

    private fun observeProfiles() {
        viewModel.getLocalProfiles().observe(this, Observer {
            if (it.isNullOrEmpty()) {
                observerRemoteProfiles()
                viewModel.getRemoteProfiles()
            } else {
                if (!::listItems.isInitialized)
                    setProfiles(it)
            }
        })
    }

    private fun observerRemoteProfiles() {
        viewModel.profileResponse.observe(this, Observer {
            it.checkResponse(onSuccess = {
                if (it.value.results.isNullOrEmpty()) {
                    binding.pbLoader.visibility = View.GONE
                    Toast.makeText(this@CardsActivity, "No data found", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.saveProfiles(it.value.results)
                }
            }, onError = {
                binding.pbLoader.visibility = View.GONE
                handleError(it)
            })
        })
    }
}
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
import com.pplintractiv.shaaditask.utils.BottomMarginItemDecorator
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsActivity : BaseVMActivity<CardsViewModel, ActivityCardsBinding>() {

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
        Log.d(TAG, "setProfiles : Size : ${data.size}\nData : $data")
        val mAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(data.map {
                CardItem(it, onAccept = {

                }, onDecline = {

                })
            })
        }

        binding.rvProfiles.apply {
            layoutManager = LinearLayoutManager(this@CardsActivity)
            adapter = mAdapter
            addItemDecoration(BottomMarginItemDecorator())
        }
        binding.pbLoader.visibility = View.GONE
    }

    private fun observeProfiles() {
        viewModel.getLocalProfiles().observe(this, Observer {
            if (it.isNullOrEmpty()) {
                observerRemoteProfiles()
                viewModel.getRemoteProfiles()
            } else {
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
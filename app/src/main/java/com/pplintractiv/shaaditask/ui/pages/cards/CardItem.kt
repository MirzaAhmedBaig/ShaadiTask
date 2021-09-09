package com.pplintractiv.shaaditask.ui.pages.cards

import android.view.View
import com.bumptech.glide.Glide
import com.pplintractiv.shaaditask.data.db.entities.Profile
import com.pplintractiv.shaaditask.databinding.CardItemBinding
import com.pplintractiv.shaaditask.utils.Layout
import com.pplintractiv.shaaditask.utils.centerImgOption
import com.xwray.groupie.viewbinding.BindableItem

class CardItem(
    private val profile: Profile,
    val onAccept: (id: Int) -> Unit,
    val onDecline: (id: Int) -> Unit
) :
    BindableItem<CardItemBinding>() {

    override fun bind(binding: CardItemBinding, position: Int) {

        Glide.with(binding.root.context)
            .load(profile.picture.large)
            .apply(centerImgOption)
            .into(binding.ivProfile)

        binding.tvName.text = "${profile.name.first} ${profile.name.last}"
        binding.tvDetails.text =
            "${profile.dob.age}, ${profile.gender.capitalize()}, ${profile.location.city}, ${profile.location.state}, ${profile.location.country}"
        if (profile.isDeclined) {
            binding.grpAsk.visibility = View.GONE
            binding.tvStatus.visibility = View.VISIBLE
        } else {
            binding.tvStatus.visibility = View.GONE
            binding.grpAsk.visibility = View.VISIBLE

            binding.bvAccept.setOnClickListener {
                onAccept(profile._id)
            }
            binding.bvDecline.setOnClickListener {
                onDecline(profile._id)
            }
        }

    }

    override fun getLayout() = Layout.card_item

    override fun initializeViewBinding(view: View): CardItemBinding {
        return CardItemBinding.bind(view)
    }
}
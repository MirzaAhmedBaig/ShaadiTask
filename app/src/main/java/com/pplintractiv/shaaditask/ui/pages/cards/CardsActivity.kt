package com.pplintractiv.shaaditask.ui.pages.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pplintractiv.shaaditask.R
import com.pplintractiv.shaaditask.databinding.ActivityCardsBinding
import com.pplintractiv.shaaditask.ui.base.BaseVMActivity

class CardsActivity : BaseVMActivity<CardsViewModel,ActivityCardsBinding>() {

    override fun getViewBinding(): ActivityCardsBinding {
        return ActivityCardsBinding.inflate(layoutInflater)
    }

    override fun getClassName(): String {
        return CardsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
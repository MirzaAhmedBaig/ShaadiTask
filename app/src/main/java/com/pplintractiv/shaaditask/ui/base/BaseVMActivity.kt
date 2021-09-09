package com.pplintractiv.shaaditask.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.pplintractiv.shaaditask.data.network.Resource
import com.pplintractiv.shaaditask.utils.Anim
import java.lang.reflect.ParameterizedType
import java.net.HttpURLConnection
import javax.inject.Inject

abstract class BaseVMActivity<VM : ViewModel, B : ViewBinding> : AppCompatActivity() {

    val TAG: String
        get() = getClassName()

    lateinit var viewModel: VM
    lateinit var binding: B

    @Inject
    lateinit var factory: BaseViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(getViewModelClass())
        binding = getViewBinding()
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(Anim.abc_fade_in, Anim.abc_fade_out)
    }

    override fun finish() {
        overridePendingTransition(Anim.abc_fade_in, Anim.abc_fade_out)
        super.finish()
    }

    override fun finishAffinity() {
        overridePendingTransition(Anim.abc_fade_in, Anim.abc_fade_out)
        super.finishAffinity()
    }

    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }

    fun handleError(error: Resource.Failure) {
        when {
            error.isNetworkError -> Toast.makeText(this, "No internet access", Toast.LENGTH_SHORT)
                .show()
            error.errorCode == HttpURLConnection.HTTP_BAD_GATEWAY -> Toast.makeText(
                this,
                "Server not responding",
                Toast.LENGTH_SHORT
            ).show()
            else -> Toast.makeText(this, "Communication to server failed", Toast.LENGTH_SHORT)
                .show()
        }
    }

    abstract fun getViewBinding(): B
    abstract fun getClassName(): String
}
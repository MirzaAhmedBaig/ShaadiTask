package com.pplintractiv.shaaditask.ui.data

import androidx.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(
    ProfileState.ACCEPTED,
    ProfileState.REJECTED,
    ProfileState.NONE
)
annotation class ProfileState {
    companion object {
        const val NONE = 0
        const val ACCEPTED = 1
        const val REJECTED = 2
    }
}

package com.pplintractiv.shaaditask.extensions

import android.content.res.Resources

fun Int.dpToPx(): Int {
    return ((this * Resources.getSystem().displayMetrics.density).toInt())
}
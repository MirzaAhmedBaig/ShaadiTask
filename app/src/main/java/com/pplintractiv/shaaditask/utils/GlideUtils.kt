package com.pplintractiv.shaaditask.utils

import com.bumptech.glide.request.RequestOptions

val centerImgOption = RequestOptions.circleCropTransform()
    .placeholder(Drawable.ic_person)
    .error(Drawable.ic_person)
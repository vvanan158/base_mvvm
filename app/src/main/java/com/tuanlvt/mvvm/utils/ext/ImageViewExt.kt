package com.tuanlvt.mvvm.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tuanlvt.mvvm.R
import com.tuanlvt.mvvm.utils.Constant

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
            .load(Constant.BASE_URL_IMAGE + url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.img_default)
            .into(this)
}

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
            .load(Constant.BASE_URL_IMAGE + url)
            .circleCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.img_circle_default)
            .into(this)
}

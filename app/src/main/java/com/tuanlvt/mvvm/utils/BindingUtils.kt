package com.tuanlvt.mvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.tuanlvt.mvvm.utils.ext.loadImageCircleWithUrl
import com.tuanlvt.mvvm.utils.ext.loadImageWithUrl

object BindingUtils {
    @JvmStatic
    @BindingAdapter("app:imageCircleUrl")
    fun setImageCircleUrl(imageView: ImageView, url: String?) {
        url?.let {
            imageView.loadImageCircleWithUrl(it)
        }
    }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        url?.let {
            imageView.loadImageWithUrl(it)
        }
    }
}

package com.tuanlvt.mvvm.utils

import com.tuanlvt.mvvm.utils.Constant.POSITION_DEFAULT

interface OnItemClickListener<T> {
    fun onItemViewClick(item: T, position: Int = POSITION_DEFAULT)
}

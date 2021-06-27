package com.tuanlvt.mvvm.utils.di

import com.tuanlvt.mvvm.utils.Constant
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single { named(Constant.BASE_URL) }
}

package com.tuanlvt.mvvm.utils.di

import android.app.Application
import com.tuanlvt.mvvm.data.di.dataSourceModule
import com.tuanlvt.mvvm.data.di.networkModule
import com.tuanlvt.mvvm.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(appModule,
                repositoryModule,
                dataSourceModule,
                networkModule,
                viewModelModule)
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}

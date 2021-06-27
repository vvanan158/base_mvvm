package com.tuanlvt.mvvm.data.di

import com.tuanlvt.mvvm.data.repository.source.MovieDataSource
import com.tuanlvt.mvvm.data.repository.source.local.MovieLocalImpl
import com.tuanlvt.mvvm.data.repository.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MovieDataSource.Local> {
        MovieLocalImpl()
    }

    single<MovieDataSource.Remote> {
        MovieRemoteImpl(apiService = get())
    }
}

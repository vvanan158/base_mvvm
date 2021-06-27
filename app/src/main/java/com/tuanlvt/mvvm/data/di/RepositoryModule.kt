package com.tuanlvt.mvvm.data.di

import com.tuanlvt.mvvm.data.MovieRepository
import com.tuanlvt.mvvm.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(remote = get(), local = get())
    }
}

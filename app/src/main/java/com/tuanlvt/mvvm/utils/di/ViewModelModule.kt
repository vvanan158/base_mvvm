package com.tuanlvt.mvvm.utils.di

import com.tuanlvt.mvvm.screen.detail.DetailViewModel
import com.tuanlvt.mvvm.screen.listMovie.MoviesViewModel
import com.tuanlvt.mvvm.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }

    viewModel { MoviesViewModel(get()) }

    viewModel { DetailViewModel() }
}

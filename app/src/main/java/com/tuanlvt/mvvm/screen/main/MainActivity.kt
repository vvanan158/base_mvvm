package com.tuanlvt.mvvm.screen.main

import android.view.LayoutInflater
import com.tuanlvt.mvvm.R
import com.tuanlvt.mvvm.databinding.ActivityMainBinding
import com.tuanlvt.mvvm.screen.listMovie.MoviesFragment
import com.tuanlvt.mvvm.utils.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)

    override fun initView() {
        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = viewModel

        supportFragmentManager
                .beginTransaction()
                .addToBackStack(MoviesFragment::javaClass.name)
                .replace(R.id.layoutContainer, MoviesFragment.newInstance())
                .commit()
    }

    override fun initData() {}
}

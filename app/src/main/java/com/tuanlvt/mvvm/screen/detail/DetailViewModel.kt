package com.tuanlvt.mvvm.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.utils.base.BaseViewModel

class DetailViewModel : BaseViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie

    fun setMovie(data: Movie?) {
        data?.let { _movie.postValue(it) }
    }
}

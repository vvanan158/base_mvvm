package com.tuanlvt.mvvm.screen.listMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.data.MovieRepository
import com.tuanlvt.mvvm.utils.base.BaseViewModel

class MoviesViewModel(private val movieRepository: MovieRepository) : BaseViewModel() {

    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>>
        get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        launchTaskSync(
                onRequest = { movieRepository.getMovies() },
                onSuccess = {
                    _movies.value = it
                },
                onError = {
                    exception.value = it
                })

    }
}

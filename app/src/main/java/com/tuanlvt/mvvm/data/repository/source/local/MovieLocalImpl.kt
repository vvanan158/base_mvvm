package com.tuanlvt.mvvm.data.repository.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.data.repository.source.MovieDataSource

class MovieLocalImpl : MovieDataSource.Local {

    override suspend fun getMoviesLocal(): LiveData<MutableList<Movie>> {
        return liveData { mutableListOf<Movie>() }
    }
}

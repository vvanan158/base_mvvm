package com.tuanlvt.mvvm.data.repository

import androidx.lifecycle.LiveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.data.MovieRepository
import com.tuanlvt.mvvm.data.repository.source.MovieDataSource
import com.tuanlvt.mvvm.utils.base.BaseRepository

class MovieRepositoryImpl(private val remote: MovieDataSource.Remote,
                          private val local: MovieDataSource.Local) : BaseRepository(), MovieRepository {

    override suspend fun getMoviesLocal(): LiveData<MutableList<Movie>> = local.getMoviesLocal()

    override suspend fun getMovies() = withResultContext {
        remote.getMovies().data
    }
}

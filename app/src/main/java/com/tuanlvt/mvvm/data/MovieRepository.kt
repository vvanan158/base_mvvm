package com.tuanlvt.mvvm.data

import androidx.lifecycle.LiveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.utils.scheduler.DataResult

interface MovieRepository {
    /**
     * Local
     */
    suspend fun getMoviesLocal(): LiveData<MutableList<Movie>>

    /**
     * Remote
     */
    suspend fun getMovies(): DataResult<MutableList<Movie>>
}

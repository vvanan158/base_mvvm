package com.tuanlvt.mvvm.data.repository.source

import androidx.lifecycle.LiveData
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.data.repository.source.remote.api.response.BaseResponse

interface MovieDataSource {

    interface Local {
        suspend fun getMoviesLocal(): LiveData<MutableList<Movie>>
    }

    interface Remote {
        suspend fun getMovies(): BaseResponse<MutableList<Movie>>
    }
}

package com.tuanlvt.mvvm.data.repository.source.remote

import com.tuanlvt.mvvm.data.repository.source.MovieDataSource
import com.tuanlvt.mvvm.data.repository.source.remote.api.ApiService

class MovieRemoteImpl(private val apiService: ApiService) : MovieDataSource.Remote {

    override suspend fun getMovies() = apiService.getTopRated()
}

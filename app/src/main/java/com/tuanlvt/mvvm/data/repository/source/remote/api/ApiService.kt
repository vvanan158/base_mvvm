package com.tuanlvt.mvvm.data.repository.source.remote.api

import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.data.repository.source.remote.api.response.BaseResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated?")
    suspend fun getTopRated(): BaseResponse<MutableList<Movie>>
}

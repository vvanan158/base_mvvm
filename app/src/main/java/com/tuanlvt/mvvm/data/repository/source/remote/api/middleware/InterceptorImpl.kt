package com.tuanlvt.mvvm.data.repository.source.remote.api.middleware

import android.app.Application
import androidx.annotation.NonNull
import com.tuanlvt.mvvm.utils.Constant
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class InterceptorImpl(private val application: Application) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        return chain.proceed(initializeHeader(chain).build())
    }

    private fun initializeHeader(chain: Interceptor.Chain): Request.Builder {
        val originRequest = chain.request()
        val url = originRequest
                .url
                .newBuilder()
                .addQueryParameter(HEADER_AUTH_TOKEN, Constant.BASE_API_KEY)
                .addQueryParameter(QUERY_LOCALE, "en-US")
                .build()

        return originRequest.newBuilder()
                .addHeader(HEADER_ACCEPT, "application/json")
                .addHeader(HEADER_CACHE_CONTROL, "no-store")
                .url(url)
                .method(originRequest.method, originRequest.body)
    }

    companion object {
        private const val HEADER_AUTH_TOKEN = "api_key"
        private const val QUERY_LOCALE = "language"
        private const val HEADER_ACCEPT = "Accept"
        private const val HEADER_CACHE_CONTROL = "Cache-Control"
    }
}

package com.tuanlvt.mvvm.data.repository.source.remote.api

import com.google.gson.Gson
import com.tuanlvt.mvvm.data.repository.source.remote.api.middleware.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private const val CONNECT_TIMEOUT = 60000L
    private const val READ_TIMEOUT = 60000L
    private const val WRITE_TIMEOUT = 30000L

    fun <T> generate(
            baseUrl: String,
            serviceClass: Class<T>,
            gson: Gson,
            interceptors: List<Interceptor>): T {
        val okHttpClient = buildOkHttpClient(interceptors)
        val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        return builder.create(serviceClass)
    }

    /**
     * Builds an [OkHttpClient] with the given interceptors attached to it
     *
     * @param interceptors [List] of [Interceptor] to attach to the expected client
     */
    private fun buildOkHttpClient(interceptors: List<Interceptor>): OkHttpClient =
            OkHttpClient.Builder().apply {
                for (interceptor in interceptors) addInterceptor(interceptor)
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            }.build()
}

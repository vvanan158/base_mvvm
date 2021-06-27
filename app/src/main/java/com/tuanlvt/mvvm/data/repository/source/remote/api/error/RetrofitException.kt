package com.tuanlvt.mvvm.data.repository.source.remote.api.error

import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class RetrofitException : RuntimeException {

    private val errorType: String
    private lateinit var response: Response<*>
    private var errorResponse: ErrorResponse? = null

    private constructor(type: String, cause: Throwable) : super(cause.message, cause) {
        this.errorType = type
    }

    private constructor(type: String, response: Response<*>) {
        this.errorType = type
        this.response = response
    }

    constructor(type: String, response: ErrorResponse?) {
        this.errorType = type
        this.errorResponse = response
    }

    fun getMessageError(): String {
        when (errorType) {
            Type.SERVER -> {
                errorResponse?.message.let {
                    return it!!
                }
            }

            Type.NETWORK -> {
                return getNetworkErrorMessage(cause)
            }

            Type.HTTP -> {
                return response.code().getHttpErrorMessage()
            }

            else -> return "Error"
        }
    }

    private fun getNetworkErrorMessage(throwable: Throwable?): String {
        if (throwable is SocketTimeoutException) {
            return throwable.message.toString()
        }

        if (throwable is UnknownHostException) {
            return throwable.message.toString()
        }

        if (throwable is IOException) {
            return throwable.message.toString()
        }

        return throwable?.message.toString()
    }

    private fun Int.getHttpErrorMessage(): String {
        if (this in 300..308) {
            // Redirection
            return "It was transferred to a different URL. I'm sorry for causing you trouble"
        }
        if (this in 400..451) {
            // Client error
            return "An error occurred on the application side. Please try again later!"
        }
        if (this in 500..511) {
            // Server error
            return "A server error occurred. Please try again later!"
        }

        // Unofficial error
        return "An error occurred. Please try again later!"
    }

    companion object {

        fun toNetworkError(cause: Throwable): RetrofitException {
            return RetrofitException(Type.NETWORK, cause)
        }

        fun toHttpError(response: Response<*>): RetrofitException {
            return RetrofitException(Type.HTTP, response)
        }

        fun toUnexpectedError(cause: Throwable): RetrofitException {
            return RetrofitException(Type.UNEXPECTED, cause)
        }

        fun toServerError(response: ErrorResponse): RetrofitException {
            return RetrofitException(Type.SERVER, response)
        }
    }
}

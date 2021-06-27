package com.tuanlvt.mvvm.data.repository.source.remote.api.error

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorResponse(
        @Expose
        @SerializedName("status_code")
        val status: Int = 0,
        @Expose
        @SerializedName("status_message")
        val message: String = ""
)

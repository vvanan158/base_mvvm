package com.tuanlvt.mvvm.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
        @Expose
        @SerializedName("id")
        val id: Int = 0,
        @Expose
        @SerializedName("backdrop_path")
        val backDropImage: String = "",
        @Expose
        @SerializedName("overview")
        val overView: String = "",
        @Expose
        @SerializedName("vote_average")
        val vote: Double = 0.0,
        @Expose
        @SerializedName("vote_count")
        val voteCount: Int = 0,
        @Expose
        @SerializedName("title")
        val title: String = "",
        @Expose
        @SerializedName("poster_path")
        val urlImage: String = "",
        @Expose
        @SerializedName("original_title")
        val originalTitle: String = ""
) : Parcelable

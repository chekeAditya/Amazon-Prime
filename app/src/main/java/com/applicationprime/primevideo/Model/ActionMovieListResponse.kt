package com.applicationprime.primevideo.Model

import com.google.gson.annotations.SerializedName

class ActionMovieListResponse (
    @SerializedName("description")
    val description: String?,
    @SerializedName("Director")
    val director: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("MovieName")
    val movieName: String?,
    @SerializedName("MovieTrailerLink")
    val movieTrailerLink: String?
)
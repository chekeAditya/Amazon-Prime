package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class MovieApiList(
    @SerializedName("Description")
    val description: String?,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("Image")
    val image: String?,
    @SerializedName("MovieName")
    val movieName: String?,
    @SerializedName("release_date")
    val releaseDate: Int?
)
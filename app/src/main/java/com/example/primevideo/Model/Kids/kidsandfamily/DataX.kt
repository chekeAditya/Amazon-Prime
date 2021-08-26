package com.example.primevideo.Model.Kids.kidsandfamily


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("description")
    val description: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("DirectorImage")
    val directorImage: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("MovieName")
    val movieName: String,
    @SerializedName("MovieTrailerLink")
    val movieTrailerLink: String,
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("Timing")
    val timing: String,
    @SerializedName("Year")
    val year: String
)
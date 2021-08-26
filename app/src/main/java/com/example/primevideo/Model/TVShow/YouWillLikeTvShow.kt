package com.example.primevideo.Model.TVShow
import com.google.gson.annotations.SerializedName
data class YouWillLikeTvShow(
    @SerializedName("Audio Language")
    val audioLanguage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("Description")
    val director: String,
    @SerializedName("DirectorImage")
    val directorImage: String,
    @SerializedName("Directors")
    val directors: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("MovieName")
    val movieName: String,
    @SerializedName("MovieTrailerLink")
    val movieTrailerLink: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("Timing")
    val timing: String,
    @SerializedName("Year")
    val year: String
)
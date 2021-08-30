package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class MovieApi(
    @SerializedName("Data")
    val `data`: List<MovieApiList>
)
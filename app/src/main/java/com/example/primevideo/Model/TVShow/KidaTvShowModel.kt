package com.example.primevideo.Model.TVShow


import com.google.gson.annotations.SerializedName

data class KidaTvShowModel(
    @SerializedName("data")
    val `data`: List<KidsTvShowData>
)
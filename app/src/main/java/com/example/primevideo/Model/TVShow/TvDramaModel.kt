package com.example.primevideo.Model.TVShow


import com.google.gson.annotations.SerializedName

data class TvDramaModel(
    @SerializedName("data")
    val `data`: List<DramaTvShow>
)
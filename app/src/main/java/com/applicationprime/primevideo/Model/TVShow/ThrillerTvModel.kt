package com.applicationprime.primevideo.Model.TVShow


import com.google.gson.annotations.SerializedName

data class ThrillerTvModel(
    @SerializedName("data")
    val `data`: List<ThrillerTvData>
)
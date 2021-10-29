package com.applicationprime.primevideo.Model.TVShow


import com.google.gson.annotations.SerializedName

data class YouWillLIkeModel(
    @SerializedName("data")
    val `data`: List<YouWillLikeTvShow>
)
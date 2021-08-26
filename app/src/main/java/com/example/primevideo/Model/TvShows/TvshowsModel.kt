package com.example.primevideo.Model.TvShows


import com.google.gson.annotations.SerializedName

data class TvshowsModel(
    @SerializedName("TvShows")
    val tvShows: List<TvShow>
)
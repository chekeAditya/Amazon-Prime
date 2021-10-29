package com.applicationprime.primevideo.Model.PopularShows


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double
)
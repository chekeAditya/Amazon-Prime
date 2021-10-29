package com.applicationprime.primevideo.Model.Shows


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double
)
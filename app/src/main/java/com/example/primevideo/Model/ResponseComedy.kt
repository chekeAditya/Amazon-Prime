package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class ResponseComedy(
    @SerializedName("data")
    val `data`: List<ResponseComedyList>
)
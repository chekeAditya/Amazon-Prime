package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class RomanceResponseDTO(
    @SerializedName("data")
    val `data`: List<RomanceData>?
)
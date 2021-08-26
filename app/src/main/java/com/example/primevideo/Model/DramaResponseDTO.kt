package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class DramaResponseDTO(
    @SerializedName("data")
    val `data`: List<DramaDataList>?
)
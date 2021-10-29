package com.applicationprime.primevideo.Model


import com.google.gson.annotations.SerializedName

data class KidsPickYouModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val kidsPickYouResults: List<KidsPickYouResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
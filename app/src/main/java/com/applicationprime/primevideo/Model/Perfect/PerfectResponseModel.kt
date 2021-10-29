package com.applicationprime.primevideo.Model.Perfect


import com.google.gson.annotations.SerializedName

data class PerfectResponseModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val perfectResults: List<PerfectResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
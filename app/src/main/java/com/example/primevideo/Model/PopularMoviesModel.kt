package com.example.primevideo.Model


import com.google.gson.annotations.SerializedName

data class PopularMoviesModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val resultModels: List<ResultModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
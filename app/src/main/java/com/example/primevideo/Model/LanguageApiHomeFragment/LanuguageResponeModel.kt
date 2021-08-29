package com.example.primevideo.Model.LanguageApiHomeFragment


import com.google.gson.annotations.SerializedName

data class LanuguageResponeModel(
    @SerializedName("data")
    val languageData: List<LanguageData>
)
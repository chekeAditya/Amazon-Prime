package com.example.primevideo.Model.Kids.kidsandfamily


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("Person1")
    val person1: String,
    @SerializedName("Person1Image")
    val person1Image: String,
    @SerializedName("Person2")
    val person2: String,
    @SerializedName("Person2Image")
    val person2Image: String,
    @SerializedName("Person3")
    val person3: String,
    @SerializedName("Person3Image")
    val person3Image: String
)
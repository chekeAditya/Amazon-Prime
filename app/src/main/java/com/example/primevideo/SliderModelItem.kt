package com.example.primevideo

import com.google.gson.annotations.SerializedName

class SliderModelItem {
    private var url: String? = null

    fun slideItemLayoutHomeActivity(url: String?) {
        this.url = url
    }

    fun getUrl(): String? {
        return url
    }
}
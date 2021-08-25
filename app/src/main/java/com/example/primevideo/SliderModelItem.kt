package com.example.primevideo


class SliderModelItem {
    private var url: String? = null

    fun slideItemLayoutHomeActivity(url: String?) {
        this.url = url
    }

    fun getUrl(): String? {
        return url
    }
}
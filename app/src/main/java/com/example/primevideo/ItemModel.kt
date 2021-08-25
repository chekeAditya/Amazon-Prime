package com.example.primevideo

class ItemModel(s: String) {
    private var image : String? =null


    fun Item( image: String) {
        this.image = image
    }

    fun getImage(): String? {
        return image
    }


}
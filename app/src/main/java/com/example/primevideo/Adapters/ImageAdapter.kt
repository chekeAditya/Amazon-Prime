package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.LanguageApiHomeFragment.LanguageData
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.ImageViewHolder

class ImageAdapter(var languageDataList : List<LanguageData>) : RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_language, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       val languageData : LanguageData = languageDataList[position]
        holder.setData(languageData)
    }

    override fun getItemCount(): Int {
       return languageDataList.size
    }
}
/*
(var indianToon: List<IndianToon>, private val listener: OnItemClickListener) :

    RecyclerView.Adapter<InidanToonsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InidanToonsHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return InidanToonsHolder(view,listener)
    }

    override fun onBindViewHolder(holder: InidanToonsHolder, position: Int) {
        val indianToon: IndianToon = indianToon[position]
        holder.setData(indianToon)
    }

    override fun getItemCount(): Int {
        return indianToon.size
    }
}
 */
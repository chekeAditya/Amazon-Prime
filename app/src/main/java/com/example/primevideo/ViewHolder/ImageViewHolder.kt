package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.LanguageApiHomeFragment.LanguageData
import kotlinx.android.synthetic.main.item_layout_language.view.*
import kotlinx.android.synthetic.main.itemlayout_popular_show.view.*

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(languageData: LanguageData){
        itemView.apply {
            languageData.run {
                Glide.with(ivLanguageHomeFragment).load(languageData.image).into(ivLanguageHomeFragment)
            }
        }
    }
}

/*
(itemView: View, val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(indianToon: IndianToon) {
        itemView.apply {
            indianToon.run {
                Glide.with(ivPopularMovies)
                    .load(indianToon.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onInidanToonClick(indianToon,adapterPosition)
        }
    }
}
 */
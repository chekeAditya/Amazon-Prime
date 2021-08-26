package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.TVShow.DramaTvShow
import com.example.primevideo.Network.OnItemClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class DramaTVShowHolder(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
    fun setDramaData(dramaTvShow: DramaTvShow) {
        itemView.apply {
            dramaTvShow.run {
                Glide.with(ivPopularMovies)
                    .load(dramaTvShow.image)
                    .into(ivPopularMovies)
            }
        }
    }

    init {
        itemView.setOnClickListener {
            listener.onitemclick(adapterPosition)
        }
    }
}
package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.TVShow.DramaTvShow
import com.applicationprime.primevideo.Network.OnItemListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class DramaTVShowHolder(itemView: View, val listener: OnItemListener): RecyclerView.ViewHolder(itemView) {
    fun setDramaData(dramaTvShow: DramaTvShow) {
        itemView.apply {
            dramaTvShow.run {
                Glide.with(ivPopularMovies)
                    .load(dramaTvShow.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onTvClicked(dramaTvShow,adapterPosition)
        }
    }
}
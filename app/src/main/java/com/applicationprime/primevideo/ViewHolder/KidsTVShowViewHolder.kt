package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.TVShow.KidsTvShowData
import com.applicationprime.primevideo.Network.OnItemListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class KidsTVShowViewHolder (itemView: View, val listeners: OnItemListener): RecyclerView.ViewHolder(itemView) {
    fun SetKidsTvShow(kidsTvShowData: KidsTvShowData) {
        itemView.apply {
            kidsTvShowData.run {
                Glide.with(ivPopularMovies)
                    .load(kidsTvShowData.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listeners.onKidsTvShow(kidsTvShowData,adapterPosition)
        }
    }
}
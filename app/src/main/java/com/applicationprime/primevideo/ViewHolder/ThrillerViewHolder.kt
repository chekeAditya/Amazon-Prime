package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.TVShow.ThrillerTvData
import com.applicationprime.primevideo.Network.OnItemListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class ThrillerViewHolder(itemView: View, val listeners: OnItemListener): RecyclerView.ViewHolder(itemView) {
    fun setThrillerData(thrillerTvData: ThrillerTvData) {
        itemView.apply {
            thrillerTvData.run {
                Glide.with(ivPopularMovies)
                    .load(thrillerTvData.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listeners.onThrillerTV(thrillerTvData,adapterPosition)
        }
    }
}
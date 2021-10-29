package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.TVShow.DataTvSHowRated
import com.applicationprime.primevideo.Network.OnItemListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*
class TopRatedTvShowHolder(itemView: View, val listeners: OnItemListener): RecyclerView.ViewHolder(itemView) {
    fun setDramaData(dataTvSHowRated: DataTvSHowRated) {
        itemView.apply {
            dataTvSHowRated.run {
                Glide.with(ivPopularMovies)
                    .load(dataTvSHowRated.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listeners.onTopRatedCLicked(dataTvSHowRated,adapterPosition)
        }
    }
}
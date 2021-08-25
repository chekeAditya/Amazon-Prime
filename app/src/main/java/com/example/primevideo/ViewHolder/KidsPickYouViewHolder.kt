package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.KidsPickYouResult
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class KidsPickYouViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(kidsPickYouResult: KidsPickYouResult) {
        itemView.apply {
            kidsPickYouResult.run {
                Glide.with(ivPopularMovies)
                    .load("https://image.tmdb.org/t/p/w500/" + kidsPickYouResult.posterPath)
                    .into(ivPopularMovies)
            }
        }
    }
}
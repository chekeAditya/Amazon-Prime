package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.Perfect.PerfectResult
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class PopularSeasonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(perfectResult: PerfectResult) {
        itemView.apply {
            perfectResult.run {
                Glide.with(ivPopularMovies)
                    .load("https://image.tmdb.org/t/p/w500" + perfectResult.posterPath)
                    .into(ivPopularMovies)
            }
        }
    }
}
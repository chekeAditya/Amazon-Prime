package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.Perfect.PerfectResult
import com.example.primevideo.Model.ResultModel
import com.example.primevideo.Model.Shows.Shows
import com.example.primevideo.Model.Shows.ShowsItem
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
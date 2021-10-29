package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.ResultModel
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class PopularMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(resultModel: ResultModel) {
        itemView.apply {
            resultModel.run {
                Glide.with(ivPopularMovies)
                    .load("https://image.tmdb.org/t/p/w500/" + resultModel.posterPath)
                    .into(ivPopularMovies)
            }
        }
    }
}
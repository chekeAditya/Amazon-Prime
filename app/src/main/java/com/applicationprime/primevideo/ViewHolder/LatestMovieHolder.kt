package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.MovieApiList
import kotlinx.android.synthetic.main.item_romance_movie_design.view.*

class LatestMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    fun setData(AData: MovieApiList){
        itemView.apply {
            AData.run {
                Glide.with(ivImageforRomanceMovierecycler)
                    .load(AData.image)
                    .into(ivImageforRomanceMovierecycler)
            }
        }
    }
}
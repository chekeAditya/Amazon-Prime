package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.ActionMovieListResponse
import kotlinx.android.synthetic.main.item_romance_movie_design.view.*

class NewMovieHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {



    fun setData(rData: ActionMovieListResponse){
        itemView.apply {
            rData.run {
                Glide.with(ivImageforRomanceMovierecycler)
                    .load(rData.image)
                    .into(ivImageforRomanceMovierecycler)
            }
        }
    }
}
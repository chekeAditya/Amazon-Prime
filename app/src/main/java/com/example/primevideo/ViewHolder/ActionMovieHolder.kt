package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.ActionMovieListResponse
import kotlinx.android.synthetic.main.item_latestmovie_design.view.*

class ActionMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(data1:ActionMovieListResponse){
        itemView.apply {
            data1.run {
                Glide.with(ivImageforlatestMovierecycler)
                    .load(data1.image)
                    .into(ivImageforlatestMovierecycler)
            }
        }

    }

}
package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.ResponseComedyList
import com.example.primevideo.Model.RomanceData
import com.example.primevideo.Network.OnItemMovieClick
import kotlinx.android.synthetic.main.item_romance_movie_design.view.*

class LatestComedyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    fun setData(rData: ResponseComedyList){
        itemView.apply {
            rData.run {
                Glide.with(ivImageforRomanceMovierecycler)
                    .load(rData.image)
                    .into(ivImageforRomanceMovierecycler)
            }
        }
    }
}
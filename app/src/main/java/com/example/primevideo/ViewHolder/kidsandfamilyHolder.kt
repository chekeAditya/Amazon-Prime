package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.Kids.kidsandfamily.Data
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class kidsandfamilyHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(data:Data) {
        itemView.apply {
            data.run {
                Glide.with(ivPopularMovies)
                    .load(data.image)
                    .into(ivPopularMovies)
            }
        }
    }
}
package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.applicationprime.primevideo.Network.OnItemClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class InidanToonsHolder (itemView: View, val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(indianToon: IndianToon) {
        itemView.apply {
            indianToon.run {
                Glide.with(ivPopularMovies)
                    .load(indianToon.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onInidanToonClick(indianToon,adapterPosition)
        }
    }
}
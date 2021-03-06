package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.Data
import com.applicationprime.primevideo.Network.OnItemClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class kidsandfamilyHolder(itemView: View, val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(data: Data) {
        itemView.apply {
            data.run {
                Glide.with(ivPopularMovies)
                    .load(data.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onitemclick(data,adapterPosition)
        }
    }

}
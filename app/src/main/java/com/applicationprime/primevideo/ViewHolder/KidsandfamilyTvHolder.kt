package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.DataX
import com.applicationprime.primevideo.Network.OnItemClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class KidsandfamilyTvHolder(itemView: View, val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(dataX: DataX) {
        itemView.apply {
            dataX.run {
                Glide.with(ivPopularMovies)
                    .load(dataX.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onkidsTvclick(dataX,adapterPosition)
        }
    }
}
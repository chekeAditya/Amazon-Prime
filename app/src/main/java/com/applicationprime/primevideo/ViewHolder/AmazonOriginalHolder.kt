package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.AmazonOriginalKid
import com.applicationprime.primevideo.Network.OnItemClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_movies.view.*

class AmazonOriginalHolder (itemView: View, val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(amazonOriginalKid: AmazonOriginalKid) {
        itemView.apply {
            amazonOriginalKid.run {
                Glide.with(ivPopularMovies)
                    .load(amazonOriginalKid.image)
                    .into(ivPopularMovies)
            }
        }
        itemView.setOnClickListener {
            listener.onAmazonOriginal(amazonOriginalKid,adapterPosition)
        }
    }
}
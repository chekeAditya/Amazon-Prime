package com.example.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.PopularShows.PopularShowsModelItem
import kotlinx.android.synthetic.main.itemlayout_popular_show.view.*

class PopularShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(showsModelItem: PopularShowsModelItem) {
        itemView.apply {
            showsModelItem.run {
                Glide.with(ivPopularShows).load(showsModelItem.image.original).into(ivPopularShows)
            }
        }
    }
}

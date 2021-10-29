package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.DramaDataList
import com.applicationprime.primevideo.Network.OnItemMovieClick
import kotlinx.android.synthetic.main.item_layout_top_movie.view.*

class DramaMovieHolder(itemView: View, val listener: OnItemMovieClick) : RecyclerView.ViewHolder(itemView) {

    fun setData(dramaDataList:DramaDataList){
        itemView.apply {
            dramaDataList.run {
                Glide.with(ivTopMovie)
                    .load(dramaDataList.image)
                    .into(ivTopMovie)
            }
        }
        itemView.setOnClickListener {
            listener.onDramaClick(dramaDataList,adapterPosition)
        }
    }
}
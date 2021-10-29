package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.ActionMovieListResponse
import com.applicationprime.primevideo.Network.OnItemMovieClick
import kotlinx.android.synthetic.main.item_latestmovie_design.view.*

class ActionMovieHolder(itemView: View,val listener: OnItemMovieClick) : RecyclerView.ViewHolder(itemView) {

    fun setData(action:ActionMovieListResponse){
        itemView.apply {
            action.run {
                Glide.with(ivImageforlatestMovierecycler)
                    .load(action.image)
                    .into(ivImageforlatestMovierecycler)
            }
        }
        itemView.setOnClickListener {
            listener.onActionClick(action,adapterPosition)
        }
    }

}
package com.example.primevideo.ViewHolder

import android.view.OrientationEventListener
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.ActionMovieListResponse
import com.example.primevideo.Network.OnItemMovieClick
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
package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.ActionMovieListResponse
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.ActionMovieHolder

class ActionMovieAdapter (var action :List<ActionMovieListResponse>,val listener: OnItemMovieClick):
    RecyclerView.Adapter<ActionMovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionMovieHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_latestmovie_design, parent, false)
        return ActionMovieHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ActionMovieHolder, position: Int) {
        val datalist: ActionMovieListResponse = action[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return action.size
    }
}
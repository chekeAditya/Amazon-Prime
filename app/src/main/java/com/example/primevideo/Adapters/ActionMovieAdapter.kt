package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.ActionMovieListResponse
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.ActionMovieHolder

class ActionMovieAdapter (var data1 :List<ActionMovieListResponse>):
    RecyclerView.Adapter<ActionMovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionMovieHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_latestmovie_design, parent, false)
        return ActionMovieHolder(view)
    }

    override fun onBindViewHolder(holder: ActionMovieHolder, position: Int) {
        val datalist: ActionMovieListResponse = data1[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data1.size
    }
}
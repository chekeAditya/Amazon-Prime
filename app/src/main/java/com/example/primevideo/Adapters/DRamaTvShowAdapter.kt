package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.TVShow.DramaTvShow
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.Network.OnItemListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.DramaTVShowHolder

class DRamaTvShowAdapter (var dramaTvShow: List<DramaTvShow>, private val listener: OnItemListener) :

    RecyclerView.Adapter<DramaTVShowHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaTVShowHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return DramaTVShowHolder(view,listener)
    }



    override fun onBindViewHolder(holder: DramaTVShowHolder, position: Int) {
        val dramaTvShow:DramaTvShow = dramaTvShow[position]
        holder.setDramaData(dramaTvShow)
    }

    override fun getItemCount(): Int {
        return dramaTvShow.size
    }
}
package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.TVShow.DramaTvShow
import com.applicationprime.primevideo.Network.OnItemListener
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.DramaTVShowHolder

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
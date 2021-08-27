package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.TVShow.ThrillerTvData
import com.example.primevideo.Network.OnItemListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.ThrillerViewHolder

class ThrillerAdapter(
    var thrillerTvData: List<ThrillerTvData>,
    private val listener: OnItemListener
) :
    RecyclerView.Adapter<ThrillerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrillerViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return ThrillerViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ThrillerViewHolder, position: Int) {
        val thrillerTvData: ThrillerTvData = thrillerTvData[position]
        holder.setThrillerData(thrillerTvData)
    }

    override fun getItemCount(): Int {
        return thrillerTvData.size
    }

}
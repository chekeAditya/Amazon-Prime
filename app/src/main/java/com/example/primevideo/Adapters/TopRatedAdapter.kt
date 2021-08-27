package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.TVShow.DataTvSHowRated
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.Network.OnItemListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.TopRatedTvShowHolder

class TopRatedAdapter(var dataTvSHowRated:  List<DataTvSHowRated>, private val listener: OnItemListener) :

    RecyclerView.Adapter<TopRatedTvShowHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedTvShowHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return TopRatedTvShowHolder(view,listener)
    }

    override fun getItemCount(): Int {
        return dataTvSHowRated.size
    }

    override fun onBindViewHolder(holder: TopRatedTvShowHolder, position: Int) {
        val dataTvSHowRated:DataTvSHowRated = dataTvSHowRated[position]
        holder.setDramaData(dataTvSHowRated)
    }
}
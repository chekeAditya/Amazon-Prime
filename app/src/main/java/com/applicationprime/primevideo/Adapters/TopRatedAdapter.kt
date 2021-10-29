package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.TVShow.DataTvSHowRated
import com.applicationprime.primevideo.Network.OnItemListener
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.TopRatedTvShowHolder

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
package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.RomanceData
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.RomanceMovieHolder

class RomanceMovieAdapter(var data :List<RomanceData>,val listener:OnItemMovieClick) : RecyclerView.Adapter<RomanceMovieHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RomanceMovieHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_romance_movie_design, parent, false)
        return RomanceMovieHolder(view,listener)
    }

    override fun onBindViewHolder(holder: RomanceMovieHolder, position: Int) {
        val datalist: RomanceData = data[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
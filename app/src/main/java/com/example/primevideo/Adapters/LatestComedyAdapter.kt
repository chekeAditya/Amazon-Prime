package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.ResponseComedyList
import com.example.primevideo.Model.MovieApiList
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.LatestComedyHolder
import com.example.primevideo.ViewHolder.LatestMovieHolder

class LatestComedyAdapter(var data1 :List<ResponseComedyList> ): RecyclerView.Adapter<LatestComedyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestComedyHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_romance_movie_design, parent, false)
        return LatestComedyHolder(view)
    }

    override fun onBindViewHolder(holder: LatestComedyHolder, position: Int) {
        val datalist: ResponseComedyList = data1[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data1.size
    }
}
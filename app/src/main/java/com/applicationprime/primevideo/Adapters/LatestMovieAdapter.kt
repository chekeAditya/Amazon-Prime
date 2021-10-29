package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.MovieApiList
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.LatestMovieHolder


class LatestMovieAdapter(var data :List<MovieApiList> ): RecyclerView.Adapter<LatestMovieHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestMovieHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_romance_movie_design, parent, false)
        return LatestMovieHolder(view)
    }

    override fun onBindViewHolder(holder: LatestMovieHolder, position: Int) {
        val datalist: MovieApiList = data[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.DramaDataList
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.DramaMovieHolder

class DramaMovieAdapter(var data:List<DramaDataList>, private val listener: OnItemMovieClick): RecyclerView.Adapter<DramaMovieHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaMovieHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_top_movie, parent, false)
        return DramaMovieHolder(view,listener)
    }

    override fun onBindViewHolder(holder: DramaMovieHolder, position: Int) {
        val datalist: DramaDataList = data[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}
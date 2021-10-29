package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.ResponseComedyList
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.LatestComedyHolder

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
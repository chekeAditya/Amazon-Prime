package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.kidsandfamilyHolder

class kidsandfamilyAdaptor(var data: List<Data>,private val listener: OnItemClickListener) :

    RecyclerView.Adapter<kidsandfamilyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kidsandfamilyHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return kidsandfamilyHolder(view,listener)
    }

    override fun onBindViewHolder(holder: kidsandfamilyHolder, position: Int) {
        val data: Data = data[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
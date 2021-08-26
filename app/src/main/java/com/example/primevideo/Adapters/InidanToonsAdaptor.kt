package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.InidanToonsHolder

class InidanToonsAdaptor (var indianToon: List<IndianToon>, private val listener: OnItemClickListener) :

    RecyclerView.Adapter<InidanToonsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InidanToonsHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return InidanToonsHolder(view,listener)
    }

    override fun onBindViewHolder(holder: InidanToonsHolder, position: Int) {
        val indianToon: IndianToon = indianToon[position]
        holder.setData(indianToon)
    }

    override fun getItemCount(): Int {
        return indianToon.size
    }
}
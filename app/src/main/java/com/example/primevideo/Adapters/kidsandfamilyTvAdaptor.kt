package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Kids.kidsandfamily.DataX
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.KidsandfamilyTvHolder

class kidsandfamilyTvAdaptor (var dataX: List<DataX>, private val listener: OnItemClickListener) :

    RecyclerView.Adapter<KidsandfamilyTvHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KidsandfamilyTvHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return KidsandfamilyTvHolder(view,listener)
    }

    override fun onBindViewHolder(holder: KidsandfamilyTvHolder, position: Int) {
        val dataX: DataX = dataX[position]
        holder.setData(dataX)
    }

    override fun getItemCount(): Int {
        return dataX.size
    }
}
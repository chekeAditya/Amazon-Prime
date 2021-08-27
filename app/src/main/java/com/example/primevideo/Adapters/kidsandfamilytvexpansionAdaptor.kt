package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Kids.kidsandfamily.DataX
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.kidsandfamilytvexpansionholder

class kidsandfamilytvexpansionAdaptor (var indianToon: List<IndianToon>) :

    RecyclerView.Adapter<kidsandfamilytvexpansionholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kidsandfamilytvexpansionholder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return kidsandfamilytvexpansionholder(view)
    }

    override fun onBindViewHolder(holder: kidsandfamilytvexpansionholder, position: Int) {
        val indianToon: IndianToon = indianToon[position]
        holder.setData(indianToon)
    }

    override fun getItemCount(): Int {
        return indianToon.size
    }
}
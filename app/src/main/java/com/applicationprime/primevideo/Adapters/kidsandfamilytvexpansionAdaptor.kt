package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.kidsandfamilytvexpansionholder

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
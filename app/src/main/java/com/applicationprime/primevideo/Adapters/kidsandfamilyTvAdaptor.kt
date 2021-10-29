package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.DataX
import com.applicationprime.primevideo.Network.OnItemClickListener
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.KidsandfamilyTvHolder

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
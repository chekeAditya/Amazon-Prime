package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Kids.kidsandfamily.AmazonOriginalKid
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.AmazonOriginalHolder

class AmazonOrigingalAdaptor (var amazonOriginalKid: List<AmazonOriginalKid> , private val listener: OnItemClickListener) :

    RecyclerView.Adapter<AmazonOriginalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmazonOriginalHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return AmazonOriginalHolder (view,listener)
    }

    override fun onBindViewHolder(holder: AmazonOriginalHolder, position: Int) {
        val amazonOriginalKid: AmazonOriginalKid = amazonOriginalKid[position]
        holder.setData(amazonOriginalKid)
    }

    override fun getItemCount(): Int {
        return amazonOriginalKid.size
    }
}
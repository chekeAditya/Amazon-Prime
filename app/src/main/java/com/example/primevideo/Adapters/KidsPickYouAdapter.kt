package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.KidsPickYouResult
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.KidsPickYouViewHolder

class KidsPickYouAdapter(var kidsPickYouResult: List<KidsPickYouResult>) :

    RecyclerView.Adapter<KidsPickYouViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KidsPickYouViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return KidsPickYouViewHolder(view)
    }

    override fun onBindViewHolder(holder: KidsPickYouViewHolder, position: Int) {
        val kidsPickYouResult: KidsPickYouResult = kidsPickYouResult[position]
        holder.setData(kidsPickYouResult)
    }

    override fun getItemCount(): Int {
        return kidsPickYouResult.size
    }
}
package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.Perfect.PerfectResult
import com.example.primevideo.Model.Shows.ShowsItem
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.PopularSeasonViewHolder

class PopularSeasonAdapter(var popularSeasonModelList: List<PerfectResult>) :

    RecyclerView.Adapter<PopularSeasonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularSeasonViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return PopularSeasonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularSeasonViewHolder, position: Int) {
        val perfectResult: PerfectResult = popularSeasonModelList[position]
        holder.setData(perfectResult)
    }

    override fun getItemCount(): Int {
        return popularSeasonModelList.size
    }
}
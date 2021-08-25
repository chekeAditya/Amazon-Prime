package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.ResultModel
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.PopularMoviesViewHolder

class PopularMoviesAdapter(var resultModelList: List<ResultModel>) :

    RecyclerView.Adapter<PopularMoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return PopularMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val resultModel: ResultModel = resultModelList[position]
        holder.setData(resultModel)
    }

    override fun getItemCount(): Int {
        return resultModelList.size
    }
}
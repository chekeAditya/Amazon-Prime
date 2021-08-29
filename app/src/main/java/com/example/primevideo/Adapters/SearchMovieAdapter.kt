package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.SearchFragmentModel.SearchResult
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.SearchMovieViewHolder

class SearchMovieAdapter(var searchMovieList: List<SearchResult>) :
    RecyclerView.Adapter<SearchMovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_show, parent, false)
        return SearchMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        val resultSearchResult: SearchResult = searchMovieList[position]
        holder.setData(resultSearchResult)
    }

    override fun getItemCount(): Int {
        return searchMovieList.size
    }
}
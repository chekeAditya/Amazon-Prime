package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.SearchFragmentModel.SearchResult
import com.applicationprime.primevideo.Network.SearchClickListener
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.SearchMovieViewHolder

class SearchMovieAdapter(var searchMovieList: List<SearchResult>, val listener: SearchClickListener) :
    RecyclerView.Adapter<SearchMovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_show, parent, false)
        return SearchMovieViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        val resultSearchResult: SearchResult = searchMovieList[position]
        holder.setData(resultSearchResult)
    }

    override fun getItemCount(): Int {
        return searchMovieList.size
    }
}
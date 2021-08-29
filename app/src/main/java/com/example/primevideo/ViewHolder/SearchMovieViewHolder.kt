package com.example.primevideo.ViewHolder

import android.view.OrientationEventListener
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.SearchFragmentModel.SearchResult
import com.example.primevideo.Network.SearchClickListener
import kotlinx.android.synthetic.main.itemlayout_popular_show.view.*

class SearchMovieViewHolder(itemView: View, val listener: SearchClickListener) : RecyclerView.ViewHolder(itemView) {
    fun setData(searchResult: SearchResult) {
        itemView.apply {
            searchResult.run {
                Glide.with(ivPopularShows)
                    .load("https://image.tmdb.org/t/p/w500/" + searchResult.posterPath)
                    .into(ivPopularShows)
            }
        }
        itemView.setOnClickListener{
            listener.onSearchItemClicked(searchResult,adapterPosition)
        }
    }
}
package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.SearchFragmentModel.SearchResult
import com.applicationprime.primevideo.Network.SearchClickListener
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
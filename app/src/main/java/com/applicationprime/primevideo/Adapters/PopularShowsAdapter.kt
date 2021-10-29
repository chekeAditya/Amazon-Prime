package com.applicationprime.primevideo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applicationprime.primevideo.Model.PopularShows.PopularShowsModelItem
import com.applicationprime.primevideo.R
import com.applicationprime.primevideo.ViewHolder.PopularShowViewHolder

class PopularShowsAdapter(private var showsModelItem: List<PopularShowsModelItem>) :
    RecyclerView.Adapter<PopularShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularShowViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout_popular_show,parent,false)
        return PopularShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularShowViewHolder, position: Int) {
        val popularShowModel:PopularShowsModelItem = showsModelItem[position]
        holder.setData(popularShowModel)
    }

    override fun getItemCount(): Int {
        return showsModelItem.size
    }

    fun updateshowsadaptor(showsModelItem: List<PopularShowsModelItem>){
        this.showsModelItem = showsModelItem
        notifyDataSetChanged()
    }
}

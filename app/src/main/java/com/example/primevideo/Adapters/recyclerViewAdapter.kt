package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.get
import com.bumptech.glide.Glide.with
import com.example.primevideo.ItemModel


class recyclerViewAdapter(var userlist: List<ItemModel>) :
    RecyclerView.Adapter<recyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recyclerViewHolder {
        val inflate1: View = LayoutInflater.from(parent.context)
            .inflate(com.example.primevideo.R.layout.item_topmovie_recycler, parent, false)
        return recyclerViewHolder(inflate1)

    }

    override fun onBindViewHolder(holder: recyclerViewHolder, position: Int) {
        val item: ItemModel = userlist[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}



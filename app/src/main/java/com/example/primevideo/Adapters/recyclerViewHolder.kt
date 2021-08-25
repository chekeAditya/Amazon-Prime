package com.example.primevideo.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.ItemModel
import kotlinx.android.synthetic.main.item_topmovie_recycler.view.*


class recyclerViewHolder(private var itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(itemModel: ItemModel) {
        itemModel.apply {
            Glide.with(itemView.ivTopMoviewImage).load(itemModel.getImage())
                .into(itemView.ivTopMoviewImage)
        }
    }
}
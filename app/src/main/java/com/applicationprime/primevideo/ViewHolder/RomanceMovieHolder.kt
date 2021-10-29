package com.applicationprime.primevideo.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.Model.RomanceData
import com.applicationprime.primevideo.Network.OnItemMovieClick
import kotlinx.android.synthetic.main.item_romance_movie_design.view.*

class RomanceMovieHolder(itemView: View,val listener:OnItemMovieClick) : RecyclerView.ViewHolder(itemView) {



    fun setData(romanceData:RomanceData){
        itemView.apply {
            romanceData.run {
                Glide.with(ivImageforRomanceMovierecycler)
                    .load(romanceData.image)
                    .into(ivImageforRomanceMovierecycler)
            }
        }
        itemView.setOnClickListener{
            listener.onRomanceClick(romanceData,adapterPosition)
        }
    }
}
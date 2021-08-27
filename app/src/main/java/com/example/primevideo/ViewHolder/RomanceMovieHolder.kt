package com.example.primevideo.ViewHolder

import android.view.OrientationEventListener
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primevideo.Model.RomanceData
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.Network.OnItemMovieClick
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
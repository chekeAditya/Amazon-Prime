package com.example.primevideo.Adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primevideo.Model.TVShow.KidsTvShowData
import com.example.primevideo.Network.OnItemListener
import com.example.primevideo.R
import com.example.primevideo.ViewHolder.KidsTVShowViewHolder

class KidsTvShowAdapter (var kidsTvShowData: List<KidsTvShowData>, private val listener: OnItemListener):

    RecyclerView.Adapter<KidsTVShowViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KidsTVShowViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlayout_popular_movies, parent, false)
        return KidsTVShowViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: KidsTVShowViewHolder, position: Int) {
        val kidsTvShowData : KidsTvShowData= kidsTvShowData[position]
        holder.SetKidsTvShow(kidsTvShowData)
    }

    override fun getItemCount(): Int {
        return kidsTvShowData.size
    }
}
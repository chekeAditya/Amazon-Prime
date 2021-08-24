package com.example.primevideo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

// Holder and Adaptor are in the same file
// Adaptor Started
class MySliderImageAdapter() : SliderViewAdapter<MySliderImageAdapter.SliderAdapterViewHolder>() {

    private var mSliderItems = ArrayList<String>()
    fun renewItems(sliderItems: ArrayList<String>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun addItem(sliderItems: String){
        mSliderItems.add(sliderItems)
        notifyDataSetChanged()
    }

    //Holder started

    class SliderAdapterViewHolder(itemView: View) :
        SliderViewAdapter.ViewHolder(itemView) {
        var imageView : ImageView = itemView.findViewById(R.id.imageSlider)
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterViewHolder {
        val inflate: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout_slider, null)
        return SliderAdapterViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterViewHolder?, position: Int) {
        Picasso.get().load(mSliderItems[position]).fit().into(viewHolder?.imageView)
    }
}
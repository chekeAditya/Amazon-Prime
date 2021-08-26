package com.example.primevideo.Network

import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Model.Kids.kidsandfamily.DataX
import com.example.primevideo.Model.TVShow.DataTvSHowRated
import com.example.primevideo.Model.TVShow.DramaTvShow

interface OnItemClickListener {

    fun onitemclick(data: Data, position: Int)
    fun onTvClicked(dramaTvShow: DramaTvShow,position: Int)
    fun onkidsTvclick(dataX: DataX,position: Int)
    fun onTopRatedCLicked(dataTvSHowRated: DataTvSHowRated,position: Int)
}
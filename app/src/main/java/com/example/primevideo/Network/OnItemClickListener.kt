package com.example.primevideo.Network

import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Model.Kids.kidsandfamily.DataX

interface OnItemClickListener {

    fun onitemclick(data: Data,position : Int)

    fun onkidsTvclick(dataX: DataX,position: Int)
}
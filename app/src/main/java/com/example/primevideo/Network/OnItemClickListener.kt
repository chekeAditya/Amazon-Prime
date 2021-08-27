package com.example.primevideo.Network

import com.example.primevideo.Model.ActionMovieListResponse
import com.example.primevideo.Model.DramaDataList
import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Model.Kids.kidsandfamily.DataX
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Model.RomanceData

interface OnItemClickListener {

    fun onitemclick(data: Data,position : Int)

    fun onkidsTvclick(dataX: DataX,position: Int)

    fun onInidanToonClick(indianToon: IndianToon, position: Int)



}
interface OnItemMovieClick{

    fun onDramaClick(drama:DramaDataList,position: Int)
    fun onActionClick(action:ActionMovieListResponse,position: Int)
    fun onRomanceClick(romance: RomanceData,position: Int)



}
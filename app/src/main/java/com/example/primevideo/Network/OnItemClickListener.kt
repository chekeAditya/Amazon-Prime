package com.example.primevideo.Network

import com.example.primevideo.Model.ActionMovieListResponse
import com.example.primevideo.Model.DramaDataList
import com.example.primevideo.Model.Kids.kidsandfamily.AmazonOriginalKid
import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Model.Kids.kidsandfamily.DataX
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Model.RomanceData
import com.example.primevideo.Model.TVShow.DataTvSHowRated
import com.example.primevideo.Model.TVShow.DramaTvShow
import com.example.primevideo.Model.TVShow.KidsTvShowData
import com.example.primevideo.Model.TVShow.ThrillerTvData

interface OnItemClickListener {

    fun onitemclick(data: Data, position: Int)

    fun onkidsTvclick(dataX: DataX, position: Int)

    fun onInidanToonClick(indianToon: IndianToon, position: Int)

    fun onAmazonOriginal(amazonOriginalKid: AmazonOriginalKid, position: Int)

}
interface OnItemMovieClick{

    fun onDramaClick(drama: DramaDataList, position: Int)
    fun onActionClick(action: ActionMovieListResponse, position: Int)
    fun onRomanceClick(romance: RomanceData, position: Int)

}
interface OnItemListener{
    fun onTvClicked(dramaTvShow: DramaTvShow, position: Int)
    fun onTopRatedCLicked(dataTvSHowRated: DataTvSHowRated, position: Int)
    fun onKidsTvShow(kidsTvShowData: KidsTvShowData, position: Int)
    fun onThrillerTV(thrillerTvData: ThrillerTvData,position: Int)
}
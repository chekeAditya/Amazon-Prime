package com.applicationprime.primevideo.Network

import com.applicationprime.primevideo.Model.*
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.AmazonOriginalKid
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.Data
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.DataX
import com.applicationprime.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.applicationprime.primevideo.Model.Perfect.PerfectResult
import com.applicationprime.primevideo.Model.RomanceData
import com.applicationprime.primevideo.Model.SearchFragmentModel.SearchResult
import com.applicationprime.primevideo.Model.TVShow.DataTvSHowRated
import com.applicationprime.primevideo.Model.TVShow.DramaTvShow
import com.applicationprime.primevideo.Model.TVShow.KidsTvShowData
import com.applicationprime.primevideo.Model.TVShow.ThrillerTvData

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
interface OnHomeListener{
    fun onPopular(popularMovie: ResultModel, position: Int)
    fun onPerfect(perfectMovie: PerfectResult, position: Int)
}

interface onItemHomeClick{

}

interface SearchClickListener{
    fun onSearchItemClicked(searchResult: SearchResult,position: Int)
}

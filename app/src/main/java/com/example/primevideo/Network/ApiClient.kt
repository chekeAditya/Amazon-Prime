package com.example.primevideo.Network

import com.example.primevideo.Model.Kids.kidsandfamily.IndianToonsModel
import com.example.primevideo.Model.*
import com.example.primevideo.Model.Kids.kidsandfamily.kidsandfamilyModel
import com.example.primevideo.Model.Kids.kidsandfamily.kidsandfamilyTv
import com.example.primevideo.Model.KidsPickYouModel
import com.example.primevideo.Model.PopularMoviesModel
import com.example.primevideo.Model.PopularShows.PopularShowsModelItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

//    Popular Movies :- https://run.mocky.io/v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e
    @GET("v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e")
    fun getPopularMovie2(): Call<PopularMoviesModel>

    //kids :- https://run.mocky.io/v3/97294d57-7c7b-4069-9033-bfc3797eceb5
    @GET("v3/97294d57-7c7b-4069-9033-bfc3797eceb5")
    fun getKidsPickYou(): Call<KidsPickYouModel>

    //Popular Shows :- https://run.mocky.io/v3/de4c3f24-d9f7-4dcc-af8a-ce4a348b3b13
    @GET("v3/de4c3f24-d9f7-4dcc-af8a-ce4a348b3b13")
    fun getPopularShows(): Call<List<PopularShowsModelItem>>


    ///https://run.mocky.io/v3/0b4b8e78-ff2f-4b8b-8bd3-a5f7c9bdd300
    @GET("v3/0b4b8e78-ff2f-4b8b-8bd3-a5f7c9bdd300")
    fun getTOPMovies(): Call<DramaResponseDTO>

    //https://run.mocky.io/v3/b09a7c22-c951-4ae3-988a-955f15102589
    @GET("v3/b09a7c22-c951-4ae3-988a-955f15102589")
    fun getLatestMovies(): Call<List<ActionMovieListResponse>>


    //https://run.mocky.io/v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd
    @GET("v3/5b7ee441-85e8-4cc8-95dc-da056caccdcd")
    fun getRomanticMovies(): Call<RomanceResponseDTO>



    //kids and family :- https://run.mocky.io/v3/3331e1e3-cd07-4aad-a476-29954de2eec6
    @GET("v3/3331e1e3-cd07-4aad-a476-29954de2eec6")
    fun getkidsandfamily(): Call<kidsandfamilyModel>

    //kids and family :- https://run.mocky.io/v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68
    @GET("v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68")
    fun getkidsandfamilyTv(): Call<kidsandfamilyTv>

    //kids and family :- https://run.mocky.io/v3/b8cbd3d1-d886-43d3-b998-915986190721
    @GET("v3/b8cbd3d1-d886-43d3-b998-915986190721")
    fun getInidanToons(): Call<IndianToonsModel>
}
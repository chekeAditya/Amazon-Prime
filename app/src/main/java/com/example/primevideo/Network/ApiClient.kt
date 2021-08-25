package com.example.primevideo.Network

import com.example.primevideo.Model.KidsPickYouModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

//   Popular Movies API  https://run.mocky.io/v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e
//    @GET("v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e")
//    fun getPopularMovie2(): Call<PopularMoviesModel>

    //kids :- https://run.mocky.io/v3/97294d57-7c7b-4069-9033-bfc3797eceb5
    @GET("v3/97294d57-7c7b-4069-9033-bfc3797eceb5")
    fun getKidsPickYou(): Call<KidsPickYouModel>
}
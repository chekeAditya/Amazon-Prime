package com.example.primevideo.Network

import com.example.primevideo.Model.Kids.kidsandfamily.*
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

    //kids and family :- https://run.mocky.io/v3/3331e1e3-cd07-4aad-a476-29954de2eec6
    @GET("v3/3331e1e3-cd07-4aad-a476-29954de2eec6")
    fun getkidsandfamily(): Call<kidsandfamilyModel>

    //kids and family :- https://run.mocky.io/v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68
    @GET("v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68")
    fun getkidsandfamilyTv(): Call<kidsandfamilyTv>

    //kids and family :- https://run.mocky.io/v3/0404dd7e-c1ba-4669-b14b-3331f46741ec
    @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
    fun getInidanToons(): Call<IndianToonsModel>

    //kids and family :- https://run.mocky.io/v3/e36a25b3-e17e-4363-bc50-893f8db4528a
    @GET("v3/e36a25b3-e17e-4363-bc50-893f8db4528a")
    fun getAmazonorginal(): Call<AmazonOriginalKids>
}
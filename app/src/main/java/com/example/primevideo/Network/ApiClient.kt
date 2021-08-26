package com.example.primevideo.Network

import com.example.primevideo.Model.*
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


    ///https://run.mocky.io/v3/2d811ba0-7dfe-4472-a554-34f2b8e05b73
    @GET("v3/2d811ba0-7dfe-4472-a554-34f2b8e05b73")
    fun getTOPMovies(): Call<DramaResponseDTO>

    //https://run.mocky.io/v3/45344816-bcd2-4617-aacc-f2e3fde8901c
    @GET("v3/45344816-bcd2-4617-aacc-f2e3fde8901c")
    fun getLatestMovies(): Call<List<ActionMovieListResponse>>


    //https://run.mocky.io/v3/72c8b521-479d-44be-af63-ed73f548ded3
    @GET("v3/72c8b521-479d-44be-af63-ed73f548ded3")
    fun getRomanticMovies(): Call<RomanceResponseDTO>


}
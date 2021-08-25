package com.example.primevideo.Network

import com.example.primevideo.Model.PopularMoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    //    Popular Movies API :- https://api.themoviedb.org/3/movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9
//    https://run.mocky.io/v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e
    @GET("3/movie/popular/{api_key}")
    fun getPopularMovie(@Query("api_Key") api_Key: String): Call<PopularMoviesModel>

    @GET("v3/4d8c2d78-30e1-409c-a015-99b4e7dcc85e")
    fun getPopularMovie2(): Call<PopularMoviesModel>
}
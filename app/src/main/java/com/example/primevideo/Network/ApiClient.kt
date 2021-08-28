package com.example.primevideo.Network

import com.example.primevideo.Model.*
import com.example.primevideo.Model.Kids.kidsandfamily.AmazonOriginalKids
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToonsModel
import com.example.primevideo.Model.Kids.kidsandfamily.kidsandfamilyModel
import com.example.primevideo.Model.Kids.kidsandfamily.kidsandfamilyTv
import com.example.primevideo.Model.Perfect.PerfectResponseModel
import com.example.primevideo.Model.PopularShows.PopularShowsModelItem
import com.example.primevideo.Model.SearchFragmentModel.SearchModelFindFragment
import com.example.primevideo.Model.TVShow.KidaTvShowModel
import com.example.primevideo.Model.TVShow.ThrillerTvModel
import com.example.primevideo.Model.TVShow.TopRatedTvSHow
import com.example.primevideo.Model.TVShow.TvDramaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    //kids :- https://run.mocky.io/v3/97294d57-7c7b-4069-9033-bfc3797eceb5
    @GET("v3/97294d57-7c7b-4069-9033-bfc3797eceb5")
    fun getPerfectShow(): Call<PerfectResponseModel>

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

        //Drama Tv Show :-https://run.mocky.io/v3/508e5537-aabb-4d07-a1c4-e04c9c777cd0
        @GET("v3/508e5537-aabb-4d07-a1c4-e04c9c777cd0")
        fun getDramaTvShow(): Call<TvDramaModel>

        //kids and family :- https://run.mocky.io/v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68
        @GET("v3/dd8c9ec3-6151-44d0-8b2d-55315e2bbc68")
        fun getkidsandfamilyTv(): Call<kidsandfamilyTv>

        //https://run.mocky.io/v3/922bacd0-b2bc-4905-a9f6-cd25bfea412a
        @GET("v3/922bacd0-b2bc-4905-a9f6-cd25bfea412a")
        fun getTopRatedTvShows(): Call<TopRatedTvSHow>

        //kids and family :- https://run.mocky.io/v3/0404dd7e-c1ba-4669-b14b-3331f46741ec
        @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
        fun getInidanToons(): Call<IndianToonsModel>

        //kids and family :- https://run.mocky.io/v3/e36a25b3-e17e-4363-bc50-893f8db4528a
        @GET("v3/e36a25b3-e17e-4363-bc50-893f8db4528a")
        fun getAmazonorginal(): Call<AmazonOriginalKids>

        //kids tv show:- https://run.mocky.io/v3/d113146a-d7a9-440a-ba31-c3239203ebc9
        @GET("v3/d113146a-d7a9-440a-ba31-c3239203ebc9")
        fun getKidsTvShow(): Call<KidaTvShowModel>

        //search option :- https://api.themoviedb.org/3/search/movie?apiKey=2147294b386ecadcb05cd19bcbbdddb9&movieName=mimi
        @GET("3/search/movie")
        fun getSearchedMovie(@Query("api_key") api_key: String, @Query("query") query: String):Call<SearchModelFindFragment>

        //Thriller tv :-https://run.mocky.io/v3/709a1e5e-9ca2-4c72-b21d-cb0873119d5d
        @GET("v3/709a1e5e-9ca2-4c72-b21d-cb0873119d5d")
        fun getThrillerTvShow(): Call<ThrillerTvModel>
}
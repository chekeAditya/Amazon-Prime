package com.example.primevideo.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }


        fun getInstanceSearch(): Retrofit{
            return  Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(Companion.httpLoggingInterceptor).build())
                .build()
        }
    }
}

/*
Popular Movies API :- https://api.themoviedb.org/3/movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9
Search Movies API :- https://api.themoviedb.org/3/search/movie?api_key=2147294b386ecadcb05cd19bcbbdddb9&query=mimi
 */
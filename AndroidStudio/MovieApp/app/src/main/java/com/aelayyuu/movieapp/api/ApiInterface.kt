package com.aelayyuu.movieapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class ApiInterface {


    @GET("top-headlines")
    
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<Result>

}
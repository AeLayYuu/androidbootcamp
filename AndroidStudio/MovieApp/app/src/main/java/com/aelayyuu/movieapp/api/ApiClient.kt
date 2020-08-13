package com.aelayyuu.movieapp.api

import com.aelayyuu.movieapp.model.ResultApi
import com.aelayyuu.movieapp.viewmodel.NewsViewmodel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object{
        val API_KEY = "be359f45fb4d16ade4dca2ed6fa86d7e"
    }

    private val apiInterface: ApiClient

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            ApiClient::class.java
        )
    }

    fun getTopHeadlines(
        country: String,
        category: String,
        apiKey: String
    ): Call<ResultApi> {
        return apiInterface.getTopHeadlines(
            country, category, apiKey
        )
    }

}
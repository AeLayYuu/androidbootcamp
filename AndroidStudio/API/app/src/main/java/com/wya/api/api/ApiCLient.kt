package com.wya.api.api

import com.google.gson.Gson
import com.wya.api.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCLient {
    private val BASE_URL = "https://newsapi.org/v2/"

    val apiIInterface: NewApiIInterface

    init {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        apiIInterface = retrofit.create(NewApiIInterface::class.java)
    }
    fun getTopHeadLines():Call<News>{
        return apiIInterface.getTopHeadlines("us","b90dd3c699c94e97944d7cc600740c26")
    }
}
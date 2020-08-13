package com.wya.api.api

import com.google.gson.Gson
import com.wya.api.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCLient {
    private val BASE_URL = "https://newsapi.org/v2/"    //"/" need don't forget

    val apiIInterface: NewApiIInterface

    companion object{
        val API_KEY="b90dd3c699c94e97944d7cc600740c26"
    }


    // init is needed build after apiclient

    init {
        var retrofit =
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiIInterface = retrofit.create(NewApiIInterface::class.java)
    }


    fun getTopHeadLines(country : String):Call<News>{
        return apiIInterface.getTopHeadlines("us","b90dd3c699c94e97944d7cc600740c26")
    }
}
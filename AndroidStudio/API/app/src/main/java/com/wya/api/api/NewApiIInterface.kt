package com.wya.api.api

import com.wya.api.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface NewApiIInterface {

    @GET("top-headlines")

    fun getTopHeadlines(
        @Query("country") country: String,//due to query
        @Query("apiKey") apiKey: String
    ): Call<News>// call News in api
}
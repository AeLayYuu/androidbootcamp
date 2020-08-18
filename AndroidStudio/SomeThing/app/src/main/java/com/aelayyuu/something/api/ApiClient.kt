package com.aelayyuu.something.api

import com.aelayyuu.something.model.getvideos.GetResult
import com.aelayyuu.something.model.getvideos.GetVideo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.Result as Result

class ApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    private val apiInterface: ApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getTopRatedMovie(): Call<GetVideo> {
        return apiInterface.getTopRated("be359f45fb4d16ade4dca2ed6fa86d7e")
    }

    fun getDetailMovie(id : Int) : Call<GetResult>{
        return apiInterface.getDetailMovie(id,"be359f45fb4d16ade4dca2ed6fa86d7e")
    }
}
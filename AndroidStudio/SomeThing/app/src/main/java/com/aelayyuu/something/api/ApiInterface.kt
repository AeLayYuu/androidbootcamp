package com.aelayyuu.something.api

import com.aelayyuu.something.model.getvideos.GetResult
import com.aelayyuu.something.model.getvideos.GetVideo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("top_rated")
    fun getTopRated (
        @Query("api_key") api_key : String
    ) : Call<GetVideo>

    @GET("{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String
    ) : Call<GetResult>
}
package com.example.movies.ui.api

import com.example.movies.ui.details.biographyview.Biography
import com.example.movies.ui.details.castview.Casts
import com.example.movies.ui.details.similarview.Similars
import com.example.movies.ui.details.view.Details
import com.example.movies.ui.nowPlaying.model.NowPlaying
import com.example.movies.ui.popular.view.Popular
import com.example.movies.ui.topRated.view.TopRated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET ("top_rated")
    fun getTopRated(
        @Query("api_key") api_key : String,
        @Query("language") language : String,
        @Query("page") page : String
    ):Call<TopRated>

    @GET("popular")
    fun getPopular(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ):Call<Popular>

    @GET ( "now_playing")
    fun getNowPlaying(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ):Call<NowPlaying>

    @GET("{movie_id}")
    fun getDetails(
        @Path ("movie_id") id :Int,
        @Query("api_key") api_key: String
    ):Call<Details>

    @GET("{movie_id}/credits")
    fun getCasts(
        @Path ("movie_id") id :Int,
        @Query("api_key") api_key: String
    ):Call<Casts>

    @GET("{movie_id}/similar")
    fun getSimilars(
        @Path ("movie_id") id :Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: String
    ):Call<Similars>

    @GET("{person_id}")
    fun getBiography(
        @Path ("person_id") id :Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ):Call<Biography>

}
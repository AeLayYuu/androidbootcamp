package com.example.movies.ui.api

import com.example.movies.ui.details.biographyview.Biography
import com.example.movies.ui.details.castview.Casts
import com.example.movies.ui.details.similarview.Similars
import com.example.movies.ui.details.view.Details
import com.example.movies.ui.nowPlaying.model.NowPlaying
import com.example.movies.ui.popular.view.Popular
import com.example.movies.ui.topRated.view.TopRated
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val Base_Url = "https://api.themoviedb.org/3/movie/"
    private val Person_Url="https://api.themoviedb.org/3/person/"

    companion object {
        val API_KEY = "f5b4b4a244942dc69732aa01528c2054"
        val Image_Path= "https://image.tmdb.org/t/p/w500/"
    }

    val apiInterface: ApiInterface
    val apiInterfacePerson : ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(ApiInterface::class.java)

        val retrofitPerson = Retrofit.Builder().baseUrl(Person_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        apiInterfacePerson=retrofitPerson.create(ApiInterface::class.java)
    }

    fun getTopRated(
        api_key : String,
        language : String,
        page : String
    ):Call<TopRated>
    {
        return apiInterface.getTopRated(api_key,language,page)
    }

    fun getPopular(
        api_key: String,
        language: String,
        page: String
    ):Call<Popular>{
        return apiInterface.getPopular(api_key,language,page)
    }

    fun getNowPlaying(
        api_key: String,
        language: String,
        page: String
    ):Call<NowPlaying>{
        return apiInterface.getNowPlaying(api_key,language,page)
    }

    fun getDetails(
        id : Int,
        api_key: String
    ):Call<Details>{
        return apiInterface.getDetails(id,api_key)
    }

    fun getCasts(
        id : Int,
        api_key: String
    ):Call<Casts>{
        return apiInterface.getCasts(id,api_key)
    }

    fun getSimilars(
        id : Int,
        api_key: String,
        language: String,
        page: String
    ):Call<Similars>{
        return apiInterface.getSimilars(id,api_key,language,page)
    }

    fun getBiography(
        id : Int,
        api_key: String,
        language: String
    ):Call<Biography>{
        return apiInterfacePerson.getBiography(id,api_key,language)
    }
}
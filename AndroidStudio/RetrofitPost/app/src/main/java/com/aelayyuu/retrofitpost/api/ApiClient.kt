package com.aelayyuu.retrofitpost.api

import com.aelayyuu.retrofitpost.model.City
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "http://food-delivery-shwe-sin-soe.khaingthinkyi.me/api/setup/"
    private var apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            ApiInterface::class.java
        )
    }

    fun addCity(cityName: String): Call<City> {
        return apiInterface.addCity(cityName)
    }
}
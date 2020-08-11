package com.example.kingandqueenretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{
    private val BASE_URL ="https://ucsmonywaonlinevote.000webhostapp.com/api/"
    private var retrofit:Retrofit?=null

    init {
      if (retrofit == null)
      {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    val postApiService = retrofit!!.create(ApiInterface::class.java)
}
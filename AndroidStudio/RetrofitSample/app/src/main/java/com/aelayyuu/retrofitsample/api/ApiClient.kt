package com.aelayyuu.retrofitsample.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASEURL = "https://my-json-server.typicode.com/typicode/demo/"
    private var retrofit: Retrofit? = null

    init {
//        fun getRetrofitClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
//            return retrofit
//        }
    }

    val postApiService = retrofit!!.create(ApiInterface::class.java) //create api service
}
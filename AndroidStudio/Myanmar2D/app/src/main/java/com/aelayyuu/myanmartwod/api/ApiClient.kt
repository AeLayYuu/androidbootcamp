package com.aelayyuu.myanmartwod.api

import com.aelayyuu.myanmartwod.model.TwoDresult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val URL = "https://2dmyanmar.000webhostapp.com/"

    private  val apiInterface: ApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }
    fun getResult() : Call<TwoDresult> {
        return apiInterface.getResult("")
    }
    fun getSet() : Call<TwoDresult> {
        return  apiInterface.getSet("")
    }
    fun getvalue(): Call<TwoDresult> {
        return apiInterface.getValue("")
    }
}

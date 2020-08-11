package com.example.kingandqueenretrofit.api

import com.example.kingandqueenretrofit.Model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("queen")
    fun getPost(): Call<ArrayList<QueenItem>>
}
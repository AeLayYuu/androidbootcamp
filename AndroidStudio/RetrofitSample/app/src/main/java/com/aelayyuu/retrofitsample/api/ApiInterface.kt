package com.aelayyuu.retrofitsample.api

import com.aelayyuu.retrofitsample.model.PostItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPost(): Call<ArrayList<PostItem>>
}
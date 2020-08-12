package com.aelayyuu.retrofitsample.api

import com.aelayyuu.retrofitsample.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPost(): Call<ArrayList<PostItem>>

    @GET("posts/{postID}")
    fun getPostWithID(@Path("postID")postId : Int) : Call<PostItem>
}

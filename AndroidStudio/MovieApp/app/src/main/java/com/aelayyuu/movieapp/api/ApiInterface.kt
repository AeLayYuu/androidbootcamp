package com.aelayyuu.movieapp.api

import android.graphics.pdf.PdfDocument
import com.aelayyuu.movieapp.model.ResultApi
import com.aelayyuu.movieapp.model.PopularModel
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("popular")

    fun getTopHeadlines(

        @Query("language") language: String,
        @Query("page") page: String,
        @Query("apiKey") apiKey: String
    ): Call<ResultApi>

}
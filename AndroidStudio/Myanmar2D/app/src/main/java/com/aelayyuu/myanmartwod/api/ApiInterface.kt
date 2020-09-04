package com.aelayyuu.myanmartwod.api

import com.aelayyuu.myanmartwod.model.TwoDresult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/")
    fun getResult(
        @Path("result") result: String
    ) : Call<TwoDresult>
    fun getSet(
        @Path("set") set : String
    ) : Call<TwoDresult>
    fun getValue(
        @Path("value") value :String
    ) : Call<TwoDresult>
}
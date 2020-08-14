package com.aelayyuu.retrofitpost.api

import com.aelayyuu.retrofitpost.model.City
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST ("city")
    fun addCity (
        @Field("city_name") cityName : String
    ) : Call<City>
}
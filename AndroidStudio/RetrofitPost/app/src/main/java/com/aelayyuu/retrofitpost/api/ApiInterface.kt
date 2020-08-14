package com.aelayyuu.retrofitpost.api

import com.aelayyuu.retrofitpost.model.City
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiInterface {
    @POST ("city")
    fun addCity (
        @Field("city_name") cityName : String
    ) : Call<City>
}
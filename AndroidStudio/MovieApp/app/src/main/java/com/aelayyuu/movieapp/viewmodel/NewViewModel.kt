package com.aelayyuu.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aelayyuu.movieapp.api.ApiClient
import com.aelayyuu.movieapp.model.ResultApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewmodel: ViewModel() {

    private var result: MutableLiveData<ResultApi> = MutableLiveData()

    fun getResult(): LiveData<ResultApi> = result

    fun loadNews() {
        var apiClient = ApiClient()
        val call = apiClient.getTopHeadlines(
            "us", "Technology", ApiClient.API_KEY
        )
        call.enqueue(object: Callback<ResultApi> {
            override fun onFailure(call: Call<ResultApi>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }

            override fun onResponse(call: Call<ResultApi>, response: Response<ResultApi>) {
                result.value = response.body()
            }

        })
    }
}
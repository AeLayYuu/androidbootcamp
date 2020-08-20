package com.example.movies.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.popular.view.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {

   private var result : MutableLiveData<Popular> = MutableLiveData()
    fun getResult() : LiveData<Popular> = result

    fun loadPopular()
    {
        var apiClient = ApiClient()
        var apiCall = apiClient.getPopular(ApiClient.API_KEY,"en-US","1")

        apiCall.enqueue(object : Callback<Popular>{
            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.d("Error >>>>>>>" , t.toString())
            }

            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                result.value = response.body()
            }
        })
    }
}
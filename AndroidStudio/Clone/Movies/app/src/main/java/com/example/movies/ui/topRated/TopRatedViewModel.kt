package com.example.movies.ui.topRated

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.topRated.view.TopRated
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedViewModel : ViewModel() {

    private var result : MutableLiveData <TopRated> = MutableLiveData()
    fun getResult():LiveData<TopRated> = result

    fun loadTopRated()
    {
        var apiClient = ApiClient()
        var apiCall = apiClient.getTopRated(ApiClient.API_KEY,"en-US","1")

        apiCall.enqueue(object : Callback<TopRated>{
            override fun onFailure(call: Call<TopRated>, t: Throwable) {
                Log.d("Error>>>>>",t.toString())
            }

            override fun onResponse(call: Call<TopRated>, response: Response<TopRated>) {
                result.value = response.body()
            }
        })
    }
}
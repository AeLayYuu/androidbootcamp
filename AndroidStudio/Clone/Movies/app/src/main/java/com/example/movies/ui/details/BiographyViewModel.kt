package com.example.movies.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.details.biographyview.Biography
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BiographyViewModel: ViewModel() {

    private var result : MutableLiveData<Biography> = MutableLiveData()
    fun getResult() : LiveData<Biography> = result

    fun loadBiography(id:Int)
    {
        var apiClient= ApiClient()
        var apiCall = apiClient.getBiography(id, ApiClient.API_KEY,"en-US")

        apiCall.enqueue(object : Callback<Biography> {
            override fun onFailure(call: Call<Biography>, t: Throwable) {
                Log.d("Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<Biography>, response: Response<Biography>) {
                result.value=response.body()
            }
        })
    }
}
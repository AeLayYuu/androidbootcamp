package com.example.movies.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.details.castview.Casts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CastViewModel :ViewModel(){
    private var result : MutableLiveData<Casts> = MutableLiveData()
    fun getResult() : LiveData<Casts> = result

    fun loadCasts(id:Int)
    {
        var apiClient= ApiClient()
        var apiCall = apiClient.getCasts(id, ApiClient.API_KEY)

        apiCall.enqueue(object : Callback<Casts> {
            override fun onFailure(call: Call<Casts>, t: Throwable) {
                Log.d("Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<Casts>, response: Response<Casts>) {
                result.value=response.body()
            }

        })
    }
}
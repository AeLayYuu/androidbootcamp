package com.example.movies.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.details.similarview.Similars
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimilarViewModel :ViewModel(){
    private var result : MutableLiveData<Similars> = MutableLiveData()
    fun getResult() : LiveData<Similars> = result

    fun loadSimilars(id:Int)
    {
        var apiClient= ApiClient()
        var apiCall = apiClient.getSimilars(id, ApiClient.API_KEY,"en-US","1")

        apiCall.enqueue(object : Callback<Similars> {
            override fun onFailure(call: Call<Similars>, t: Throwable) {
                Log.d("Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<Similars>, response: Response<Similars>) {
                result.value=response.body()
            }
        })
    }
}
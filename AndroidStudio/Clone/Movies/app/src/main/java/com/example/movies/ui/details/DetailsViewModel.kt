package com.example.movies.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.details.view.Details
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel : ViewModel(){
    private var result : MutableLiveData<Details> = MutableLiveData()
    fun getResult() : LiveData<Details> = result

    fun loadDetails(id:Int)
    {
        var apiClient= ApiClient()
        var apiCall = apiClient.getDetails(id,ApiClient.API_KEY)

        apiCall.enqueue(object : Callback<Details>{
            override fun onFailure(call: Call<Details>, t: Throwable) {
                Log.d("Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                result.value=response.body()
            }

        })
    }
}
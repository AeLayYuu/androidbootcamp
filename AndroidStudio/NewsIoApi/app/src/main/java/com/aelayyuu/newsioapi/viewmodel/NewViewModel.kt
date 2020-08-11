package com.aelayyuu.newsioapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aelayyuu.newsioapi.api.ApiClient
import com.aelayyuu.newsioapi.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewViewModel : ViewModel() {
    private var result: MutableLiveData<News> = MutableLiveData()
    private var errorMessage: MutableLiveData<String> = MutableLiveData()
    private var errorStatus: MutableLiveData<Boolean> = MutableLiveData()
    private var loading: MutableLiveData<Boolean> = MutableLiveData()
    fun getResult(): LiveData<News> = result
    fun geterrorMessage(): LiveData<String> = errorMessage
    fun geterrorStatus(): LiveData<Boolean> = errorStatus
    fun getloading(): LiveData<Boolean> = loading
    fun loadResult() {
        var apiClient = ApiClient()
        var apiCall = apiClient.getTopHeadlines()
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                loading.value = false
                errorMessage.value = t.toString()

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                loading.value = false
                errorStatus.value = true
                result.value = response.body()
            }

        })
    }

}
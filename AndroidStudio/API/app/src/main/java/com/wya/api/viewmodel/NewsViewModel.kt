package com.wya.api.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wya.api.api.ApiCLient
import com.wya.api.model.News
import retrofit2.Call
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private var result: MutableLiveData<News> = MutableLiveData()//assign variable
    private var errorMessage: MutableLiveData<String> = MutableLiveData()
    private var errorStatus: MutableLiveData<Boolean> = MutableLiveData()
    private var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getResult(): LiveData<News> = result//return result

    fun getErrorMessage(): LiveData<String> = errorMessage
    fun getErrorStatus(): LiveData<Boolean> = errorStatus

    fun getLoading(): LiveData<Boolean> = loading

    fun loadResult() {//set variable
        var apiCLient = ApiCLient()
        val apiCall = apiCLient.getTopHeadLines("us")
        apiCall.enqueue(object : retrofit2.Callback<News> {    //implement members in follow


            override fun onFailure(call: Call<News>, t: Throwable) {
                loading.value = false
                errorMessage.value = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                loading.value = false
                errorStatus.value = false
                result.value = response.body()
            }


        })
    }
}

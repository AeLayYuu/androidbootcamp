package com.aelayyuu.retrofitpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aelayyuu.retrofitpost.api.ApiClient
import com.aelayyuu.retrofitpost.model.City
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun apiCall(){
        var apiClient = ApiClient()
        var call = apiClient.addCity("Monywa")
        call.enqueue(object : Callback<City>)
        txtResponse.text = t.toString()
    }
    override fun
}
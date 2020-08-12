package com.aelayyuu.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.retrofitsample.api.ApiClient
import com.aelayyuu.retrofitsample.model.PostItem
import com.aelayyuu.retrofitsample.postadapter.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getPosts()
    }
//    fun getPosts(){
//        val apiClient = ApiClient()
//        val apiCall = apiClient.postApiService.getPost()
//
//        apiCall.enqueue(object : Callback<ArrayList<PostItem>>{
//            override fun onFailure(call: Call<ArrayList<PostItem>>, t: Throwable) {
//                txtResponse.text = t.toString()
//                Toast.makeText(
//                    applicationContext,
//                    t.toString(),
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//            override fun onResponse(
//                call: Call<ArrayList<PostItem>>,
//                response: Response<ArrayList<PostItem>>
//            ) {
//                txtResponse.text = response.body().toString()
//
//                recyclerView.apply {
//                    layoutManager = LinearLayoutManager(context)
//                    adapter = PostAdapter(response.body()!!)
//                }
//                Toast.makeText(
//                    applicationContext,
//                   response.message(),
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//        })
//    }
}

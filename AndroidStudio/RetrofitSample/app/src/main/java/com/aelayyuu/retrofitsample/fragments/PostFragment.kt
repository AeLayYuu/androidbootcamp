package com.aelayyuu.retrofitsample.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.aelayyuu.retrofitsample.R
import com.aelayyuu.retrofitsample.api.ApiClient
import com.aelayyuu.retrofitsample.model.PostItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostFragment : Fragment() {

//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("response>>>>>>>>>>", "asdfgh")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiClient = ApiClient()
        val apiCall = apiClient.postApiService.getPostWithID(3)

        apiCall.enqueue(object : Callback<PostItem> {
            override fun onFailure(call: Call<PostItem>, t: Throwable) {
                Toast.makeText(context,t.toString(),Toast.LENGTH_LONG).show()
                Log.d("response>>>>>>>>>>", t.toString())
            }

            override fun onResponse(call: Call<PostItem>, response: Response<PostItem>) {
                Log.d("response>>>>>>>>>>", response.body().toString())
            }

        })
    }

}
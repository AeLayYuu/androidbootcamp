package com.example.kingandqueenretrofit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kingandqueenretrofit.Model.QueenItem
import com.example.kingandqueenretrofit.R
import com.example.kingandqueenretrofit.adapters.QueenAdapter
import com.example.kingandqueenretrofit.api.ApiClient
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QueenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_queen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiClient = ApiClient()
        val apiCall = apiClient.postApiService.getPost()

        apiCall.enqueue(object : Callback<ArrayList<QueenItem>> {
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {

                txtResponse.text = t.toString()
                Log.d("error",t.toString())

            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
                Log.d("response",response.body().toString())
//                txtResponse.text = response.body().toString()
//                Toast.makeText(
//                    context, response.message(), Toast.LENGTH_LONG
//                ).show()
            recyclerView2.apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                adapter=QueenAdapter(response.body()!!)
            }

            }

        })
    }


}
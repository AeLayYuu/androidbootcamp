package com.example.kingandqueenretrofit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kingandqueenretrofit.Model.KingItem
import com.example.kingandqueenretrofit.Model.QueenItem
import com.example.kingandqueenretrofit.R
import com.example.kingandqueenretrofit.adapters.KingAdapter
import com.example.kingandqueenretrofit.adapters.QueenAdapter
import com.example.kingandqueenretrofit.api.ApiClient
import kotlinx.android.synthetic.main.fragment_king.*
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_king, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getKingInfo()
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.)
        }
    }
    fun getKingInfo() {
        val apiClient = ApiClient()
        val apiCall = apiClient.ApiService.getKing()
        apiCall.enqueue(object : Callback<ArrayList<KingItem>> {
            override fun onFailure(call: Call<ArrayList<KingItem>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ArrayList<KingItem>>,
                response: Response<ArrayList<KingItem>>
            ) {
                recyclerView_King.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = KingAdapter(response.body()!!)
                }
            }

        })
    }
}
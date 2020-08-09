package com.aelayyuu.mycart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.mycart.R
import com.aelayyuu.mycart.adapter.HeaderAdapter
import com.aelayyuu.mycart.model.Header
import kotlinx.android.synthetic.main.fragment_header.*

class HeaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerList = ArrayList<Header>()
        headerList.add(Header("Fine Grain Sugar","price - $20.00","1 Kg",R.drawable.sugar))
        headerList.add(Header("Peanuts","Price - $20.00","3 Kg",R.drawable.peanuts))
        headerList.add(Header("Dawat Rice","Price - $80.00","2 Kg",R.drawable.dawarrice))

        RecyclerHeaderView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = HeaderAdapter(headerList)
        }
    }
}
package com.aelayyuu.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.fragments.R
import com.aelayyuu.fragments.adapter.HeaderAdapter
import com.aelayyuu.fragments.model.Header
import kotlinx.android.synthetic.main.activity_main.*
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
        headerList.add(Header("APPLE"))
        headerList.add(Header("Orange"))
        headerList.add(Header("Banana"))
        headerList.add(Header("Grape"))
        headerList.add(Header("Pine Apple"))
        headerList.add(Header("Coconet"))

        RecyclerHeaderView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = HeaderAdapter(headerList)
        }
    }
}
package com.aelayyuu.newsioapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.newsioapi.R
import com.aelayyuu.newsioapi.adapter.ItemAdapter
import com.aelayyuu.newsioapi.model.Article
import com.aelayyuu.newsioapi.viewmodel.NewViewModel
import kotlinx.android.synthetic.main.fragment_top_headline.*

class DetailNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
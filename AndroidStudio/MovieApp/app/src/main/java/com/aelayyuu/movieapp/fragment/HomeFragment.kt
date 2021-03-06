package com.aelayyuu.movieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.movieapp.R
import com.aelayyuu.movieapp.adapter.HomeAdapter
import com.aelayyuu.movieapp.model.ResultApi
import com.aelayyuu.movieapp.viewmodel.NewsViewmodel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeAdapter.ClickListener {

    lateinit var newsViewmodel: NewsViewmodel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewmodel = ViewModelProvider(this)
            .get(NewsViewmodel::class.java)

        homeAdapter = HomeAdapter()
        recyclerHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
        homeAdapter.
        observeViewmodel()
    }

    private fun observeViewmodel() {
        newsViewmodel.getResult().observe(
            viewLifecycleOwner, Observer { news ->
                homeAdapter
            }
        )
    }

    override fun onResume() {
        super.onResume()
        newsViewmodel.loadNews()
    }


    override fun onClcik(resultApi: ResultApi) {
        var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(resultApi.title)
        findNavController().navigate(action)
    }

}

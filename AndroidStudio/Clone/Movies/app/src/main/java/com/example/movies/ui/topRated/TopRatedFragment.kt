package com.example.movies.ui.topRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.ui.topRated.view.Result
import kotlinx.android.synthetic.main.fragment_home.*

class TopRatedFragment : Fragment(), TopRatedAdapter.ClickListener{

    private lateinit var homeViewModel: TopRatedViewModel
    lateinit var homeAdapter: TopRatedAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        //val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            //textView.text = it
//        })
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(TopRatedViewModel::class.java)

        homeAdapter = TopRatedAdapter()
        recyclerTopRated.apply {
            layoutManager = GridLayoutManager(context,3)
            adapter=homeAdapter
        }
        observeViewModel()
        homeAdapter.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.loadTopRated()
    }
    private fun observeViewModel()
    {
        homeViewModel.getResult().observe(
            viewLifecycleOwner, Observer { topRated->
                homeAdapter.updateResult(topRated.results)
            }
        )
    }

    override fun onClick(result: Result) {
        var action = TopRatedFragmentDirections.actionNavHomeToDetailsFragment(result.id)
        findNavController().navigate(action)
    }
}
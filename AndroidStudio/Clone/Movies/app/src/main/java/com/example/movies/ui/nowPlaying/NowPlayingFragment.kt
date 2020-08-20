package com.example.movies.ui.nowPlaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.ui.nowPlaying.model.Result
import kotlinx.android.synthetic.main.fragment_slideshow.*

class NowPlayingFragment : Fragment(),NowPlayingAdapter.ClickListener {

    private lateinit var nowPlayingViewModel: NowPlayingViewModel
    lateinit var nowPlayingAdapter: NowPlayingAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_slideshow,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nowPlayingViewModel=ViewModelProvider(this).get(NowPlayingViewModel::class.java)
        nowPlayingAdapter = NowPlayingAdapter()

        recyclerNowPlaying.apply {
            layoutManager= GridLayoutManager(context,3)
            adapter = nowPlayingAdapter
        }
        observeViewModel()
        nowPlayingAdapter.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        nowPlayingViewModel.loadNowPlaying()
    }

    private fun observeViewModel(){
        nowPlayingViewModel.getResult().observe(viewLifecycleOwner, Observer {nowPlaying->
            nowPlayingAdapter.updateResult(nowPlaying.results)
        })
    }

    override fun onClick(result: Result) {
        var action = NowPlayingFragmentDirections.actionNavSlideshowToDetailsFragment(result.id)
        findNavController().navigate(action)
    }
}
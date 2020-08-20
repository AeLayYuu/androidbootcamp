package com.example.movies.ui.popular

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
import com.example.movies.ui.popular.view.Result
import kotlinx.android.synthetic.main.fragment_gallery.*

class PopularFragment : Fragment(),PopularAdapter.ClickListener {

    private lateinit var popularViewModel: PopularViewModel

    lateinit var popularAdapter: PopularAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel=ViewModelProvider(this).get(PopularViewModel::class.java)

        popularAdapter = PopularAdapter()

        recyclerPopular.apply {
            layoutManager= GridLayoutManager(context,3)
            adapter= popularAdapter
        }
        observeViewModel()
        popularAdapter.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        popularViewModel.loadPopular()
    }

    private fun observeViewModel(){
        popularViewModel.getResult().observe(viewLifecycleOwner, Observer { popular->
            popularAdapter.updateResultPopular(popular.results)
        })
    }

    override fun onClick(result: Result) {
        var action = PopularFragmentDirections.actionNavGalleryToDetailsFragment(result.id)
        findNavController().navigate(action)
    }
}
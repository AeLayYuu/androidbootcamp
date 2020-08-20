package com.example.movies.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.ui.api.ApiClient
import com.example.movies.ui.details.adapter.CastAdapter
import com.example.movies.ui.details.adapter.SimilarAdapter
import com.example.movies.ui.details.castview.Cast
import com.example.movies.ui.details.similarview.Result
import com.example.movies.ui.topRated.TopRatedFragmentDirections
import com.example.movies.ui.topRated.TopRatedViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment(),SimilarAdapter.ClickListener ,CastAdapter.ClickListener{

    lateinit var detailViewModel: DetailsViewModel
    lateinit var castViewModel: CastViewModel
    lateinit var similarViewModel: SimilarViewModel

    lateinit var castAdapter: CastAdapter
    lateinit var similarAdapter: SimilarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var item = arguments?.let {
            DetailsFragmentArgs.fromBundle(it)
        }
        var id= item?.movieId
        detailViewModel= ViewModelProvider(this).get(DetailsViewModel::class.java)
        detailViewModel.loadDetails(id!!)

        observeViewModel()

        //for Casts
        castAdapter= CastAdapter()

        castViewModel=ViewModelProvider(this).get(CastViewModel::class.java)
        castViewModel.loadCasts(id!!)

        observeVMForCasts()
//        recyclerCastDetails.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter= castAdapter
//        }

        recyclerCastDetails.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerCastDetails.adapter = castAdapter
        castAdapter.setOnClickListener(this)

        //For Similar
        similarAdapter= SimilarAdapter()

        similarViewModel=ViewModelProvider(this).get(SimilarViewModel::class.java)
        similarViewModel.loadSimilars(id!!)

        observeVMForSimilars()
        recyclersimlermovies.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclersimlermovies.adapter = similarAdapter

        similarAdapter.setOnClickListener(this)
    }

    fun observeViewModel()
    {
        detailViewModel.getResult().observe(viewLifecycleOwner, Observer { details->
            Picasso.get().load(ApiClient.Image_Path + details.backdrop_path).placeholder(R.drawable.movies).into(imgMovieDetails)
            textMovieName.text= details.title

            var date :String =details.release_date.substring(0,4)

            textReleaseDate.text= "  ("+date+")"
            textTagLine.text=details.tagline
            textOverView.text=details.overview
            textVote.text = details.vote_average.toString()
            textType.text=details.genres[0].name
        })
    }

    fun observeVMForCasts()
    {
        castViewModel.getResult().observe(viewLifecycleOwner, Observer { casts->
           castAdapter.updateResult(casts.cast)
        })
    }
    fun observeVMForSimilars()
    {
        similarViewModel.getResult().observe(viewLifecycleOwner, Observer { similars->
            similarAdapter.updateResult(similars.results)
        })
    }

    override fun onClick(result: Result) {
        var action = DetailsFragmentDirections.actionDetailsFragmentSelf(result.id)
        findNavController().navigate(action)
    }

    override fun onClick(result: Cast) {
        var action = DetailsFragmentDirections.actionDetailsFragmentToBiographyFragment(result.id)
        findNavController().navigate(action)
    }
}
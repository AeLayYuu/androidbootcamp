package com.example.movies.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.ui.api.ApiClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_biography.*

class BiographyFragment : Fragment() {

    lateinit var biographyViewModel: BiographyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biography, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var item = arguments?.let {
            BiographyFragmentArgs.fromBundle(it)
        }

        var id = item?.peopleId
        biographyViewModel= ViewModelProvider(this).get(BiographyViewModel::class.java)
        biographyViewModel.loadBiography(id!!)

        observeViewModel()
    }
    fun observeViewModel(){
        biographyViewModel.getResult().observe(viewLifecycleOwner, Observer {biography->
            textBiographyName.text=biography.name
            textBiographyDetails.text=biography.biography
            Picasso.get().load(ApiClient.Image_Path+ biography.profile_path).placeholder(R.drawable.movies).into(imgBiography)
        })
    }
}
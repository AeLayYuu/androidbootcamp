package com.wya.api.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wya.api.R
import com.wya.api.adapter.TopHeadlinesAdapter
import com.wya.api.model.Article
import com.wya.api.model.News
import com.wya.api.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_top_headlines.*


class TopHeadlinesFragment : Fragment(), TopHeadlinesAdapter.CLickListener {
    lateinit var newsViewModel: NewsViewModel
    lateinit var topHeadlinesAdapter: TopHeadlinesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headlines, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        topHeadlinesAdapter= TopHeadlinesAdapter()
        //for click
        topHeadlinesAdapter.setOnCLickListener(this)

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topHeadlinesAdapter
        }
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        newsViewModel.loadResult()
    }

    fun observeViewModel() {
        newsViewModel.getResult()
            .observe(viewLifecycleOwner, Observer<News> { news ->//observe use due to livedata
                topHeadlinesAdapter.updateArticle(news.articles as ArrayList<Article>)
            })

        newsViewModel.getLoading().observe(
            viewLifecycleOwner, Observer { isLoading ->
                progressLoading.visibility =
                if (isLoading) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
        )
        newsViewModel.getErrorStatus().observe(
            viewLifecycleOwner, Observer { status ->
                if (status) {
                    newsViewModel.getErrorMessage().observe(
                        viewLifecycleOwner, Observer { message ->
                            txtError.text = message
                        }
                    )
                }

            }
        )
    }


    override fun onClick(article: Article) {
        view?.findNavController()?.navigate(
            R.id.action_topFragment_to_nextFragment
        )
    }
}


/* var apiCLient=ApiCLient()
var apiCall=apiCLient.getTopHeadLines()//call ApiInterface
apiCall.enqueue(object: retrofit2.Callback<News>{
override fun onFailure(call: Call<News>, t: Throwable) {
}

override fun onResponse(call: Call<News>, response: Response<News>) {
    recyclerview.apply{
        layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}

})*/
/* newsViewModel.getResult()
                 .observe(viewLifecycleOwner, Observer<News> { news ->//observe use due to livedata
                     recyclerview.adapter = TopHeadlinesAdapter(news.articles as ArrayList<Article>)
                 })*/
/* newsViewModel.getResult().observe(this, Observer {
recyclerview.apply {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    adapter = TopHeadlinesAdapter(it.articles as ArrayList<Article>)
}
})*/

/* btnClick.setOnClickListener {
     Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()
        *//*var action=OneFragmentDirections.actionOneFragmentToTwoFragment("Message from one")
                findNavController().navigate(action)*//*
            }*/


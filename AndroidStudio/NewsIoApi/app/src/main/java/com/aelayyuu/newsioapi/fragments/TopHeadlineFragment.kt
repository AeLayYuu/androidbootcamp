package com.aelayyuu.newsioapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.newsioapi.R
import com.aelayyuu.newsioapi.adapter.ItemAdapter
import com.aelayyuu.newsioapi.model.Article
import com.aelayyuu.newsioapi.model.News
import com.aelayyuu.newsioapi.viewmodel.NewViewModel
import kotlinx.android.synthetic.main.fragment_top_headline.*



class TopHeadlineFragment : Fragment() , ItemAdapter.ClickListener {
    lateinit var newViewModel: NewViewModel
     var itemAdapter: ItemAdapter = ItemAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        newViewModel = ViewModelProvider(this).get(NewViewModel::class.java)


        RecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter

        }
        itemAdapter.setOnClickListener(this)
        observeViewmodel()

    }
    fun observeViewmodel() {
        newViewModel.getResult().observe(viewLifecycleOwner, Observer<News> { news ->
            itemAdapter.updateArticle(news.articles as ArrayList<Article>)
        })
        newViewModel.getloading().observe(
            viewLifecycleOwner, Observer { isLoading ->
                if (isLoading) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
        )
        newViewModel.geterrorStatus().observe(
            viewLifecycleOwner, Observer { status ->
                if (status) {
                    newViewModel.geterrorMessage().observe(
                        viewLifecycleOwner, Observer { message ->
                            txtResponse.text = message
                        }
                    )
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        newViewModel.loadResult()
    }
    override fun onClick(article: Article) {
        Toast.makeText(context,"Hello",Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_topHeadlineFragment_to_detailNewsFragment)
    }
}
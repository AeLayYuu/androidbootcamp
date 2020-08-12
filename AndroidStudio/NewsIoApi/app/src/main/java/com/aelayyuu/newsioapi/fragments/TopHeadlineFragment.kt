package com.aelayyuu.newsioapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

var newsViewHolder = NewViewModel()

class TopHeadlineFragment : Fragment() , ItemAdapter.ClickListener {
    lateinit var newViewModel: NewViewModel
    lateinit var itemAdapter: ItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemAdapter.setOnClickListener(this)

        newsViewHolder = ViewModelProvider(this).get(NewViewModel::class.java)
        newsViewHolder.loadResult()

        newsViewHolder.getResult().observe(viewLifecycleOwner, Observer {

            RecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ItemAdapter(it.articles as ArrayList<Article>)

            }
        })

    }
    fun observeViewmodel() {
        newsViewHolder.getResult().observe(viewLifecycleOwner, Observer<News> { news ->
            itemAdapter.updateArticle(news.articles as ArrayList<Article>)
        })
        newsViewHolder.getloading().observe(
            viewLifecycleOwner, Observer { isLoading ->
                if (isLoading) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
        )
        newsViewHolder.geterrorStatus().observe(
            viewLifecycleOwner, Observer { status ->
                if (status) {
                    newsViewHolder.geterrorMessage().observe(
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
        newsViewHolder.loadResult()
    }
    override fun onClick(article: Article) {
        findNavController().navigate(R.id.action_topHeadlineFragment_to_detailNewsFragment)
    }
}
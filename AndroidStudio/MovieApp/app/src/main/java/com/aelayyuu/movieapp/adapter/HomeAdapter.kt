package com.aelayyuu.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.movieapp.R
import com.aelayyuu.movieapp.fragment.HomeFragment
import com.aelayyuu.movieapp.model.ResultApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(var ArticleList: List<ResultApi> = ArrayList<ResultApi>()) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var article: ResultApi

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(article: ResultApi) {
            this.article = article

            itemView.txtPoster.text = article.poster_path
            itemView.txtOverView.text = article.overview
            itemView.txtID.text = article.id.toString()
            itemView.txtOriginalTitle.text = article.original_title
            itemView.txtPopularity.text = article.popularity.toString()
            itemView.txtReleaseDate.text = article.release_date

            Picasso.get()
                .load(article.poster_path)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgPoster)
        }

        var mClickListener: ClickListener? = null

        fun setOnClickListener(clickListener: HomeFragment) {
            this.mClickListener = clickListener
        }
        override fun onClick(v: View?) {
            mClickListener?.onClcik(article)
        }
    }
    interface ClickListener {
        fun onClcik(article: ResultApi)
    }

    fun updateArticle(articleList: List<ResultApi>) {
        this.ArticleList = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ArticleList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(ArticleList.get(position))
    }
}

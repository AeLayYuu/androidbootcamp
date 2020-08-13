package com.wya.api.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wya.api.R
import com.wya.api.fragments.TopHeadlinesFragment
import com.wya.api.model.Article
import kotlinx.android.synthetic.main.item_top_headlines.view.*

class TopHeadlinesAdapter(var newList: List<Article> = ArrayList()) :
    RecyclerView.Adapter<TopHeadlinesAdapter.NewsViewHolder>() {

    var mCLickListener: CLickListener? = null
    
    fun setOnCLickListener(clcikListener: TopHeadlinesFragment) {
        this.mCLickListener = clcikListener
    }

    fun updateArticle(newList: ArrayList<Article>) {
        this.newList = newList
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemview: View)
        : RecyclerView.ViewHolder(itemview),
        View.OnClickListener {

        lateinit var article: Article
        private var view: View = itemView

        init {
            itemview.setOnClickListener(this)
        }

        fun bindNews(article: Article) {

            this.article=article

            itemView.txtName.text = article.source.name
            itemView.txtAuthor.text = article.author
            Picasso.get()
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imageView)
            itemView.txtTitle.text = article.title
            itemView.txtDescription.text = article.description
        }

        override fun onClick(v: View?) {
            mCLickListener?.onClick(article)
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_top_headlines, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindNews(newList[position])
    }

    interface CLickListener {
        fun onClick(article: Article)
    }

}
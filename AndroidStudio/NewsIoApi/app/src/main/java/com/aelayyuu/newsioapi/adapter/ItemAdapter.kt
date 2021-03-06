package com.aelayyuu.newsioapi.adapter

import android.util.Log
import android.view.KeyCharacterMap.load
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.newsioapi.R
import com.aelayyuu.newsioapi.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_news.view.*
import kotlinx.android.synthetic.main.itemtopheader_layout.view.*

class ItemAdapter (var itemlist : ArrayList<Article> = ArrayList()) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var mClickListener:ClickListener? = null



    fun setOnClickListener(clickListener:ClickListener) {
        Log.d("hello","hello")
        this.mClickListener = clickListener
    }

    fun updateArticle(itemlist: ArrayList<Article>) {
        this.itemlist = itemlist
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        lateinit var article: Article
        init {
            itemView.setOnClickListener(this)
        }
//        private var view: View = itemView
        fun bind(article: Article) {
            this.article = article
            itemView.txtdetailtitle.text = article.title
            itemView.txtdetailcontent.text = article.content
            itemView.txtdetailauthor.text = article.author
            itemView.txtdetaildescription.text = article.description
//            Picasso.get()
//                .load(article.urlToImage)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(itemView.imgitem)
        }
        override fun onClick(v: View?) {
            mClickListener?.onClick(article)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_detail_news, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }
    interface ClickListener {
        fun onClick(article: Article)
    }
}
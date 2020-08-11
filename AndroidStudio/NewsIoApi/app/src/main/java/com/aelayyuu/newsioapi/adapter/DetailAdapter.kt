package com.aelayyuu.newsioapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.newsioapi.R
import com.aelayyuu.newsioapi.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_news.view.*
import kotlinx.android.synthetic.main.itemtopheader_layout.view.*

class DetailAdapter (var itemlist : ArrayList<Article>) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
    class DetailViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind (article: Article) {
            itemView.txtdetailtitle.text= article.title
            itemView.txtdetailcontent.text = article.content
            itemView.txtdetailauthor.text = article.author
            itemView.txtdetaildescription.text = article.description
            Picasso.get().load(article.urlToImage).into(itemView.imgitem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_detail_news,parent,false)
        return DetailViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemlist.size

    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }
}
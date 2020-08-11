package com.aelayyuu.newsioapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.newsioapi.R
import com.aelayyuu.newsioapi.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemtopheader_layout.view.*

class ItemAdapter(var itemlist : ArrayList<Article>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind (article: Article) {
            itemView.txtitem.text= article.title
            itemView.txtitem1.text = article.description
            Picasso.get().load(article.urlToImage).into(itemView.imgitem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemtopheader_layout,parent,false)
        return ItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemlist.size

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }
}
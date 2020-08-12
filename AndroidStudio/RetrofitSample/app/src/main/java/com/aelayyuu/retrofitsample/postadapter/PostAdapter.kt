package com.aelayyuu.retrofitsample.postadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.retrofitsample.R
import com.aelayyuu.retrofitsample.model.PostItem
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter (var postList: ArrayList<PostItem>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    class PostViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){
        fun bind ( post: PostItem) {
            itemView.txtPost1.text = post.id.toString()
            itemView.txtPost2.text = post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_post,
            parent,false
        )
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bind(postList[position])
    }
}
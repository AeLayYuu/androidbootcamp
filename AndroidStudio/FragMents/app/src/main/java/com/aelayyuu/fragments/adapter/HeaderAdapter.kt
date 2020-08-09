package com.aelayyuu.fragments.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.fragments.R
import com.aelayyuu.fragments.model.Header
import kotlinx.android.synthetic.main.activity_header.view.*

class HeaderAdapter (var headerlist : ArrayList<Header>) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindHeader(header : Header){
           itemView.tvHeader.text= header.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_header,parent,false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return headerlist.size
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bindHeader(headerlist[position])
    }

}
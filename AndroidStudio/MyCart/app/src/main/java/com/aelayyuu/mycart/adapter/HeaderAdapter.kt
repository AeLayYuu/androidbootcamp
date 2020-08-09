package com.aelayyuu.mycart.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.mycart.R
import com.aelayyuu.mycart.model.Header
import kotlinx.android.synthetic.main.activity_header_adapter.view.*

class HeaderAdapter (var headerlist : ArrayList<Header>) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindHeader(header: Header) {
            itemView.txtName.text = header.name
            itemView.txtPrice.text=header.price
            itemView.txtAmount.text=header.amount
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_header_adapter,parent,false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return headerlist.size
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bindHeader(headerlist[position])
    }

}
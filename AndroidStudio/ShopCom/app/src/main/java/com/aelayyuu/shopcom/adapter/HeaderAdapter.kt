package com.aelayyuu.shopcom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.model.LatestArrivals
import kotlinx.android.synthetic.main.fragment_description.view.*
import kotlinx.android.synthetic.main.fragment_header.view.*

class HeaderAdapter (private var headerlist : ArrayList<LatestArrivals>) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindHeader(latestArrivals: LatestArrivals) {
            itemView.txtheader1.text=latestArrivals.labelarrival
            itemView.txtheader2.text=latestArrivals.captionarrival
            itemView.txtheader5.text= latestArrivals.pricearrival
            itemView.imgheader.setImageResource(latestArrivals.imagearrival)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_header,parent,false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return headerlist.size
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bindHeader(headerlist[position])
    }

}
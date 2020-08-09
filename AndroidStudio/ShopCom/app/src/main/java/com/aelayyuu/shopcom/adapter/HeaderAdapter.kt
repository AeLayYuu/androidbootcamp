package com.aelayyuu.shopcom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.model.LatestArrivals
import kotlinx.android.synthetic.main.fragment_header.view.*

class HeaderAdapter (private var headerlist : ArrayList<LatestArrivals>) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindHeader(latestArrivals: LatestArrivals) {
            itemView.txtheader3.text=latestArrivals.labelarrival
            itemView.txtheader4.text=latestArrivals.captionarrival
            itemView.txtheader5.text= latestArrivals.pricearrival
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
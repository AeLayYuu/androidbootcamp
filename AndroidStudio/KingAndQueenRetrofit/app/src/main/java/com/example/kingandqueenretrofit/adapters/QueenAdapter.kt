package com.example.kingandqueenretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingandqueenretrofit.Model.Queen
import com.example.kingandqueenretrofit.Model.QueenItem
import com.example.kingandqueenretrofit.R
import kotlinx.android.synthetic.main.layout_queen.view.*

class QueenAdapter (var queenList : ArrayList<QueenItem>) : RecyclerView.Adapter<QueenAdapter.QueenViewHolder>(){
    class QueenViewHolder (itemview: View):RecyclerView.ViewHolder(itemview){
        fun  bindView(queen :QueenItem){
            itemView.nameQueen.text = queen.name
            itemView.classQueen.text=queen.`class`
            itemView.imageUrlQueen.text=queen.img_url
            itemView.idQueen.text= queen.id
            itemView.voteCountQueen.text=queen.vote_count.toString()
            itemView.voteTimeStatusQueen.text=queen.vote_time_status.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_queen,parent,false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        return holder.bindView(queenList[position])
    }
}
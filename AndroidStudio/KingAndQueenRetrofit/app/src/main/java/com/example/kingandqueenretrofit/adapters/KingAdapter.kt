package com.example.kingandqueenretrofit.adapters

import android.graphics.ColorSpace.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingandqueenretrofit.Model.KingItem
import com.example.kingandqueenretrofit.Model.QueenItem
import com.example.kingandqueenretrofit.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_king.view.*
import kotlinx.android.synthetic.main.layout_queen.view.*
import kotlinx.android.synthetic.main.layout_queen.view.class_txt
import kotlinx.android.synthetic.main.layout_queen.view.id_txt
import kotlinx.android.synthetic.main.layout_queen.view.name_txt
import kotlinx.android.synthetic.main.layout_queen.view.vote_txt
import java.lang.reflect.Array.get

class KingAdapter(var kingItemList:ArrayList<KingItem>):RecyclerView.Adapter<KingAdapter.KingViewHolder>() {
    class KingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind (kingItem:KingItem){
            itemView.id_txt.text=kingItem.id
            itemView.name_txt.text=kingItem.name
            itemView.class_txt.text=kingItem.`class`
            itemView.vote_txt.text=kingItem.vote_count.toString()
            Picasso.get().load(kingItem.img_url).into(itemView.king_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        return KingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_king_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return kingItemList.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.bind(kingItemList[position])
    }
}
package com.example.movies.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.details.similarview.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_show_similar.view.*

class SimilarAdapter (var similarList : List<Result> = ArrayList()):RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder>() {

    var mClickListener : ClickListener? = null
    interface ClickListener{
        fun onClick(result: Result)
    }

    fun setOnClickListener(clickListener: ClickListener)
    {
        this.mClickListener = clickListener
    }
    inner class SimilarViewHolder(itemView : View): RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindCasts(result : Result)
        {
            this.result = result
            var imgUrl :String ="https://image.tmdb.org/t/p/w500/"

            itemView.textSimilarName.text= result.title
            Picasso.get().load( imgUrl + result.poster_path).placeholder(R.drawable.movies).into(itemView.imgSimilar)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_show_similar,parent,false)
        return SimilarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return similarList.size
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        holder.bindCasts(similarList[position])
    }
    fun updateResult(result : List<Result>){
        similarList= result
        notifyDataSetChanged()
    }
}
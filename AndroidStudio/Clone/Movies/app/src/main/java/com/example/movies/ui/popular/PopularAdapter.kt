package com.example.movies.ui.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.popular.view.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_rated.view.*

class PopularAdapter(var popularList : List<Result> = ArrayList()):RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    var mClickListener : ClickListener? =null
    interface ClickListener{
        fun onClick(result:Result)
    }
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener=clickListener
    }
    inner class PopularViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindPopular(result: Result)
        {
            this.result=result
            var imgUrl :String ="https://image.tmdb.org/t/p/w500/"

            //itemView.movieTitle.text=result.title
            //itemView.movieOverview.text= result.overview

            Picasso.get().load( imgUrl + result.poster_path).placeholder(R.drawable.movies).into(itemView.posterImage)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_popular,parent,false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bindPopular(popularList[position])
    }

    fun updateResultPopular(result: List<Result>)
    {
        popularList= result
        notifyDataSetChanged()
    }
}
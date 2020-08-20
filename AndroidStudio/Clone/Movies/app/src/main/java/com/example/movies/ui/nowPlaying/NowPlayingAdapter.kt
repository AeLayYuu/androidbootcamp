package com.example.movies.ui.nowPlaying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.nowPlaying.model.Result
import com.example.movies.ui.topRated.TopRatedAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_rated.view.*

class NowPlayingAdapter(var nowPlayingList : List<Result> = ArrayList()):RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>()
{
    var mClickListener : ClickListener? = null

    interface ClickListener{
        fun onClick (result: Result)
    }
    fun setOnClickListener(clickListener: ClickListener)
    {
        this.mClickListener=clickListener
    }
    inner class NowPlayingViewHolder(itemView : View):RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindNowPlaying(result : Result)
        {
            this.result = result
            var imgUrl :String ="https://image.tmdb.org/t/p/w500/"

            //itemView.movieTitle.text=result.title
            //itemView.movieOverview.text= result.overview

            Picasso.get().load( imgUrl + result.poster_path).placeholder(R.drawable.movies).into(itemView.posterImage)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing,parent,false)
        return NowPlayingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nowPlayingList.size
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bindNowPlaying(nowPlayingList[position])
    }

    fun updateResult(result : List<Result>){
        nowPlayingList= result
        notifyDataSetChanged()
    }
}
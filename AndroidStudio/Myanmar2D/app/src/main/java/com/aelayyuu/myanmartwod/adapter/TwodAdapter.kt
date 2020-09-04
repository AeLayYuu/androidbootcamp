package com.aelayyuu.myanmartwod.adapter

import android.view.View

class TwodAdapter {



    inner class TopRatingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var result: Result

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(result: Result) {
            this.result=result
            itemView.topMovieTitle.text = result.title
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/" + result.poster_path)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.topMoviePhoto)
        }

        override fun onClick(p0: View?) {
            clickListener?.onClick(result)
        }
    }

}
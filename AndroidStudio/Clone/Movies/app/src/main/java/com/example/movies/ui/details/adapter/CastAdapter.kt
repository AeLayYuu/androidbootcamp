package com.example.movies.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.details.castview.Cast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_show_cast.view.*

class CastAdapter (var castList : List<Cast> = ArrayList()):RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    var mClickListener : ClickListener? = null
    interface ClickListener{
        fun onClick(result: Cast)
    }
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class CastViewHolder(itemView : View): RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        lateinit var result: Cast
        init {
            itemView.setOnClickListener(this)
        }
        fun bindCasts(result : Cast)
        {
            this.result = result
            var imgUrl :String ="https://image.tmdb.org/t/p/w500/"

            itemView.textCastName.text= result.name
            Picasso.get().load( imgUrl + result.profile_path)
                .placeholder(R.drawable.movies)
                .into(itemView.imgCast)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_show_cast,parent,false)
        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return castList.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bindCasts(castList[position])
    }
    fun updateResult(result : List<Cast>){
        castList= result
        notifyDataSetChanged()
    }
}
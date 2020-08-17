package com.aelayyuu.wordroomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.wordroomdatabase.R
import com.aelayyuu.wordroomdatabase.model.Book

class BookAdapter(var booklist: ArrayList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(book: Book) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return booklist.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        return holder.bind(booklist[position])
    }

}
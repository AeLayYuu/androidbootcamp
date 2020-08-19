package com.aelayyuu.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.roomdatabase.R
import com.aelayyuu.roomdatabase.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter:RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    private var books = emptyList<Book>()

    inner class BookViewHolder(itemview: View):
            RecyclerView.ViewHolder(itemview) {
        fun bind ( book: Book) {
            itemView.txtBookName.text = book.bookName
        }
    }

    fun addBookList(booklist: List<Book>) {
        this.books = booklist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
      return holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
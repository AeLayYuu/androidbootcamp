package com.aelayyuu.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.roomdatabase.R
import com.aelayyuu.roomdatabase.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter:RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var mClickListener : ClickListener?=null
    fun setOnClickListener(clickListener: ClickListener) {
        this.mClickListener= clickListener
    }
    private var books = emptyList<Book>()
    inner class BookViewHolder(itemview: View):
            RecyclerView.ViewHolder(itemview),
    View.OnClickListener{
        init {
            itemview.setOnClickListener(this)
        }
        lateinit var book: Book


        fun bind ( book: Book) {
            this.book = book
            itemView.txtBookName.text = book.bookName
        }

        override fun onClick(view: View?) {
            mClickListener?.onClick(book)
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

    interface ClickListener {
        fun onClick(book: Book)
    }

}
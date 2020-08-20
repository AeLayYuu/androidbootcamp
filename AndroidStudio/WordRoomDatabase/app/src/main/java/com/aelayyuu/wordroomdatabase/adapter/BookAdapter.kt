package com.aelayyuu.wordroomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.wordroomdatabase.R
import com.aelayyuu.wordroomdatabase.model.Book
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var mCLickListener: CLickListener?=null

    private var books = emptyList<Book>()

    fun setOnClickListener(clickListener: CLickListener){
        this.mCLickListener= clickListener
    }

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        lateinit var book: Book

        fun bind(book: Book) {
            this.book=book
            itemView.txtitemBook.text = book.bookName
        }

        override fun onClick(p0: View?) {
            mCLickListener?.onClick(book)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        return holder.bind(books[position])
    }

    fun addBookList(book: List<Book>) {
        this.books = book
        notifyDataSetChanged()
    }
    interface CLickListener{
        fun onClick(book: Book)
    }


}
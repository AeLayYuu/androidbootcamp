package com.aelayyuu.wordroomdatabase.repository

import androidx.lifecycle.LiveData
import com.aelayyuu.wordroomdatabase.dao.BookDao
import com.aelayyuu.wordroomdatabase.model.Book

class BookRepository(private val bookDao: BookDao) {
    val allBook : LiveData<List<Book>> =bookDao.getAllBook()

    fun bookInsert (book : Book) {
        bookDao.saveBook(book)
    }
}
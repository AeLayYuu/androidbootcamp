package com.aelayyuu.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.aelayyuu.roomdatabase.dao.BookDao
import com.aelayyuu.roomdatabase.model.Book

class BookRepository (private val bookDao : BookDao) {
    val allBook : LiveData<List<Book>> = bookDao.getAllBook()

    suspend fun insert(book : Book) {
        bookDao.insert(book)
    }

    suspend fun delete(){
        bookDao.deleteAll()
    }

    suspend fun deleteItem(name : String){
        bookDao.deleteItem(name)
    }
}
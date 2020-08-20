package com.aelayyuu.wordroomdatabase.repository

import androidx.lifecycle.LiveData
import com.aelayyuu.wordroomdatabase.dao.BookDao
import com.aelayyuu.wordroomdatabase.model.Book

class BookRepository(private val bookDao: BookDao) {

    val allBook: LiveData<List<Book>> = bookDao.getAllBook()

    suspend fun bookInsert(book: Book) {
        bookDao.insert(book)
    }

    suspend fun bookDelete() {
        bookDao.deleteAll()
    }

    suspend fun deleteItem(name: String) {
        bookDao.deleteItem(name)
    }

    suspend fun updateItem(updateName: String, name :String){
        bookDao.updateItem(updateName,name)
    }
}
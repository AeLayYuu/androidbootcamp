package com.aelayyuu.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aelayyuu.roomdatabase.dao.BookDao
import com.aelayyuu.roomdatabase.database.BookDataBase
import com.aelayyuu.roomdatabase.model.Book
import com.aelayyuu.roomdatabase.repository.BookRepository

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val allBook : LiveData<List<Book>>
    init {
        val bookDao = BookDataBase.getDatabase(application, viewModelScope).bookDao()
    }
}
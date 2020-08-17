package com.aelayyuu.wordroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aelayyuu.wordroomdatabase.database.BookDataBase
import com.aelayyuu.wordroomdatabase.model.Book
import com.aelayyuu.wordroomdatabase.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : BookRepository
    val allBook : LiveData<List<Book>>

    init {
        val bookDao = BookDataBase.getDatabase(
            application).bookDao()

        repository = BookRepository(bookDao)
        allBook = repository.allBook
    }
    fun insert(book : Book) = viewModelScope.launch {
        repository.bookInsert(book)

    }
}
package com.aelayyuu.wordroomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aelayyuu.wordroomdatabase.model.Book

@Dao
interface BookDao {

    @Query(value = "Select * from Book")
    fun getAllBook(): LiveData<List<Book>>

    @Insert
    fun saveBook(book: Book)
}
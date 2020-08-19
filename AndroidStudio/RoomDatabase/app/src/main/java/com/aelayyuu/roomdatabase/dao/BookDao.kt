package com.aelayyuu.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aelayyuu.roomdatabase.model.Book


@Dao
interface BookDao {

    @Query(value = "Select * from book_table ORDER BY book_name ASC")
    fun getAllBook(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(book: Book)
}
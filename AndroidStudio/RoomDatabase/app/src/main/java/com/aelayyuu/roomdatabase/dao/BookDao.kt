package com.aelayyuu.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aelayyuu.roomdatabase.model.Book


@Dao
interface BookDao {

    @Query(value = "Select * from book_table ORDER BY book_name ASC")
    fun getAllBook(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book) //please add suspend

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()

}
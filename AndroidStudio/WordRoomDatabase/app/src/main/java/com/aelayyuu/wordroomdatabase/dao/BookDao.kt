package com.aelayyuu.wordroomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aelayyuu.wordroomdatabase.model.Book

@Dao
interface BookDao {

    @Query(value = "Select * from book_name ORDER BY book_name ASC")
//  @Query(value = "Select * from BookTable")
    fun getAllBook(): LiveData<List<Book>>    // getter (SELECT)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)        // setter (INSERT)

    @Query("Delete from book_name")
    suspend fun deleteAll()             // deleter (DELETE)

    @Query("DELETE from book_name WHERE book_name=:name")
    suspend fun deleteItem(name: String)

    @Query("UPDATE book_name SET book_name=:updateName WHERE book_name=:name")
    suspend fun updateItem(updateName: String, name: String)

}
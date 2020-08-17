package com.aelayyuu.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aelayyuu.roomdatabase.dao.BookDao
import com.aelayyuu.roomdatabase.model.Book


@Database(entities = [(Book::class)], version = 1)
abstract class BookDataBase : RoomDatabase(){
    abstract fun bookDao() : BookDao
}
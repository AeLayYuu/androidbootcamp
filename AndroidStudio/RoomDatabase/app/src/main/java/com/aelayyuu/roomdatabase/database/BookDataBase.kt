package com.aelayyuu.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aelayyuu.roomdatabase.dao.BookDao
import com.aelayyuu.roomdatabase.model.Book


@Database(entities = [(Book::class)], version = 1)
abstract class BookDataBase : RoomDatabase(){
    abstract fun bookDao() : BookDao

    companion object {
        private var INSTANCE : BookDataBase? = null
        fun getDatabase(context : Context) : BookDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDataBase::class.java,
                    "book-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
package com.aelayyuu.wordroomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aelayyuu.wordroomdatabase.dao.BookDao
import com.aelayyuu.wordroomdatabase.model.Book
import java.security.AccessControlContext

@Database(entities = [(Book::class)], version = 2)
abstract class BookDataBase : RoomDatabase(){
    abstract fun bookDao() : BookDao

    companion object {
        private var INSTANCE : BookDataBase ? = null

        fun getDatabase(context: Context): BookDataBase {
            val teamInstance = INSTANCE
            if ( teamInstance != null) {
                return teamInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                context.applicationContext,
                BookDataBase::class.java,
                "BookDB"
                ).build()
                INSTANCE = instance
                return instance

            }
        }
    }
}
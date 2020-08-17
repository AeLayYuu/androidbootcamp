package com.aelayyuu.wordroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.aelayyuu.wordroomdatabase.adapter.BookAdapter
import com.aelayyuu.wordroomdatabase.database.BookDataBase
import com.aelayyuu.wordroomdatabase.model.Book
import com.aelayyuu.wordroomdatabase.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            BookDataBase::class.java,
//            "BookDB"
//        ).build()
//
//        Thread {
//            val book = Book(
//                2,
//                "Android Development"
//            )
//            db.bookDao().saveBook(book)
//            db.bookDao().getAllBook().forEach {
//
//                Log.d(
//                    "Fetch",
//                    "${it.bookID}"
//                )
//                Log.d(
//                    "FetchDataBase >>>>>>>>>",
//                    "${it.bookName}"
//                )
//            }
//        }.start()
    }
    val bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
    val bookAdapter = BookAdapter()
    
}
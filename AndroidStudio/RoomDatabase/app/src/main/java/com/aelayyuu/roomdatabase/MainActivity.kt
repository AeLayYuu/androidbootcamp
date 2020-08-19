package com.aelayyuu.roomdatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.roomdatabase.adapter.BookAdapter
import com.aelayyuu.roomdatabase.model.Book
import com.aelayyuu.roomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bookViewModel: BookViewModel
    private val addBookActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookAdapter = BookAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

        bookViewModel = ViewModelProviders.of(this)
            .get(BookViewModel::class.java)

        bookViewModel.allBook.observe(
            this, Observer { books ->
                books.let {
                    bookAdapter.addBookList(books)
                }
            }
        )

        btnAdd.setOnClickListener{
            val intent = Intent(
            this,
            AddBookActivity::class.java
            )
//            startActivity(intent)
            startActivityForResult(intent, addBookActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == addBookActivityRequestCode
            && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AddBookActivity.EXTRA_REPLY)?.let {
                    val book = Book(it)
                bookViewModel.insert(book)
                }
        }
    }

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
//            db.bookDao().getAllBook(book)
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
//    }

}

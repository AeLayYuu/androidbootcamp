package com.aelayyuu.roomdatabase

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.roomdatabase.adapter.BookAdapter
import com.aelayyuu.roomdatabase.model.Book
import com.aelayyuu.roomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BookAdapter.ClickListener {
    private lateinit var bookViewModel: BookViewModel
    private val addBookActivityRequestCode = 1
    private lateinit var bookAdapter : BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      bookAdapter = BookAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }
        bookAdapter.setOnClickListener(this)

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
        btnDelete.setOnClickListener{
            bookViewModel.delete()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addBookActivityRequestCode
            && resultCode == Activity.RESULT_OK
        ) {
            data?.getStringExtra(AddBookActivity.EXTRA_REPLY)?.let {
                val book = Book(it)
                bookViewModel.insert(book)
            }
        }
    }
    override fun onClick(book:Book) {

        val builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("Delete item")
            setMessage("Are You Sure ?")
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton("Yes"){
                dialogInterface, i ->
                bookViewModel.deleteItem(book.bookName)
            }
            setNegativeButton("No"){
                dialogInterface, i ->
                Toast.makeText(applicationContext,
                "Delete Cancel",Toast.LENGTH_LONG).show()
            }
        }
        val alertDialog = builder.create()
        alertDialog.show()
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

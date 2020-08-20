package com.aelayyuu.wordroomdatabase

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.wordroomdatabase.adapter.BookAdapter
import com.aelayyuu.wordroomdatabase.model.Book
import com.aelayyuu.wordroomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_update.view.*

class MainActivity : AppCompatActivity(),BookAdapter.CLickListener {
    private lateinit var bookViewModel: BookViewModel // global declaration
    private val addBookActivityRequestCode = 1
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookAdapter = BookAdapter()
        recyclerviewBook.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }
        bookAdapter.setOnClickListener(this)


        bookViewModel= ViewModelProvider.of(this).get(BookViewModel::class.java)

        bookViewModel.allBook.observe(
            this, Observer { book ->
                book.let {
                    bookAdapter.addBookList(book)
                }
            }
        )

        btnAdd.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            //  startActivity(intent)
            startActivityForResult(intent, addBookActivityRequestCode)

        }
        btnDelete.setOnClickListener {
            bookViewModel.delete()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == addBookActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.getStringExtra(AddBookActivity.EXTRA_REPLY)?.let {
                val book = Book(it)
                bookViewModel.insert(book)
            }

        }
    }

    private fun Book(idbook: String): Book {
        return Book(idbook)
    }

    override fun onClick(book: Book) {
        //  bookViewModel.deleteItem(book.bookName) // on click yin delete lote tar
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("Delete Item")
            setMessage("Are you sure to delete?")
            setIcon(android.R.drawable.ic_dialog_alert)
            setPositiveButton("Yes"){
                    dialogInterface, i->
                bookViewModel.deleteItem(book.bookName)

            }
            setNegativeButton("No"){
                    dialogInterface,i ->
                Toast.makeText(applicationContext,"Delete cancel",Toast.LENGTH_LONG).show()
            }
            setNeutralButton("Update"){dialogInterface,i->
                val updateBuilder = AlertDialog.Builder(context)
                val dialogLayout = layoutInflater.inflate(
                    R.layout.dialog_update,null
                )
                updateBuilder.apply {
                    setTitle("Update Book")
                    setView(dialogLayout)
                    setPositiveButton("OK"){ dialogInterface, i->
                        val updateText = dialogLayout.edtupdname.text.toString()
                        bookViewModel.updateItem(updateText,book.bookName)


                    }
                }
                val updateDialog : AlertDialog = updateBuilder.create()
                updateDialog.show()
            }
//        val alertDialog : AlertDialog = builder.create()
//        alertDialog.show()

        }


    }
}
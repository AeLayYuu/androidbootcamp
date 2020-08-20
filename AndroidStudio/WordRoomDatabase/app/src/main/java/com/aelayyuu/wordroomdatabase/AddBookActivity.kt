package com.aelayyuu.wordroomdatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : AppCompatActivity() {

    lateinit var bookName: String

    companion object {
        const val EXTRA_REPLY = "REPLY_BOOK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        btnSave.setOnClickListener {
            val replyIntent = Intent()

            bookName = edittxtBookName.text.toString()

            if(TextUtils.isEmpty(edittxtBookName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                bookName = edittxtBookName.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, bookName)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()            // activity will auto finished
        }
    }
}
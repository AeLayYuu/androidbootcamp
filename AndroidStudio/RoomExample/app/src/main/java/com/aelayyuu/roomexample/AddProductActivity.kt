package com.aelayyuu.roomexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity: AppCompatActivity() {
    lateinit var productName : String

    companion object {
        const val EXTRA_REPLY = "REPLY_BOOK"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_add_product)

        BtnSave.setOnClickListener {
            val replyIntent = Intent()

            productName = EditTxtProductName.text.toString()

            if (TextUtils.isEmpty(EditTxtProductName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                productName = EditTxtProductName.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, productName)
                setResult(Activity.RESULT_OK, replyIntent)

            }
            finish()
        }
    }
}
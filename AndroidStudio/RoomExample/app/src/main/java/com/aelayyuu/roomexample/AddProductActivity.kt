package com.aelayyuu.roomexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity: AppCompatActivity() {
    lateinit var productName : String
    lateinit var productID : String
    lateinit var productPrice : String
    lateinit var productQuentity : String

    companion object {
        const val EXTRA_ID = "REPLY_ID"
        const val EXTRA_NAME = " REPLY_NAME"
        const val EXTRA_PRICE= "REPLY_PRICE"
        const val EXTRA_QUENTITY = "REPLY_QUENTITY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("next", "next page")
        setContentView(R.layout.activity_add_product)

        BtnSave.setOnClickListener {
            val replyIntent = Intent()

            productName = EditTxtProductName.text.toString()

            if (TextUtils.isEmpty(EditTxtProductName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                productName = EditTxtProductName.text.toString()
                productID = EditTxtProductID.text.toString()
                productPrice = EditTxtProductPrice.text.toString()
                productQuentity = EditTxtProductQuentity.text.toString()
                replyIntent.putExtra(EXTRA_ID, productID)
                replyIntent.putExtra(EXTRA_NAME, productName)
                replyIntent.putExtra(EXTRA_PRICE, productPrice)
                replyIntent.putExtra(EXTRA_QUENTITY, productQuentity)

                setResult(Activity.RESULT_OK, replyIntent)

            }
            finish()
        }
    }
}
package com.aelayyuu.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        btncount2.setOnClickListener{
            var count: Int = txtcount.text.toString().toInt()
            count -= 2
            txtcount.text=count.toString()
        }
        val count=intent.getStringExtra("COUNT")
        txtnext.text=count
    }
}
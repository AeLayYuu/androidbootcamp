package com.aelayyuu.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       btnmain1.setOnClickListener {
            var count: Int = txtmain1.text.toString().toInt()
            count += 2
            txtmain1.text=count.toString()
        }
    }
}
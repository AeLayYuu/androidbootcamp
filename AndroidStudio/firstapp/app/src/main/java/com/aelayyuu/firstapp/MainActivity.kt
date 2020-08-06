package com.aelayyuu.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btncount1.setOnClickListener {
            var count: Int = txtcount.text.toString().toInt()
            count += 2
            txtcount.text=count.toString()
        }
        btnnext.setOnClickListener{
            val intent = Intent(this,NextActivity::class.java)
            val count = txtcount.text.toString()
            intent.putExtra("COUNT",count)
            startActivity(intent)
        }
    }
}
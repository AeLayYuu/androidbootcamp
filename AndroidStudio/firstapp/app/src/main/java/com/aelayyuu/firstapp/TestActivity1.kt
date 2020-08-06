package com.aelayyuu.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_test1.*

class TestActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        button1.setOnClickListener{
            val intent = Intent(this,TestActivity2::class.java)
            val Name = edittxt1.text.toString()
            intent.putExtra("Name",Name)
            val Age = edittxt2.text.toString()
            intent.putExtra("Age",Age)
            startActivity(intent)
        }
    }
}